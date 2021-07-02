/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * Experienced Pixel Dungeon
 * Copyright (C) 2019-2020 Trashbox Bobylev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.scrolls;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Degrade;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MagicImmune;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ShadowParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.UnstableSpellbook;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;

import java.util.ArrayList;

public class ScrollOfUpgrade extends InventoryScroll {

	public static final String AC_UPGRADE = "UPGRADE";

	{
		icon = ItemSpriteSheet.Icons.SCROLL_UPGRADE;
		mode = WndBag.Mode.UPGRADEABLE;
	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);

		if (action.equals(AC_UPGRADE)){
			if (hero.buff(MagicImmune.class) != null){
				GLog.w( Messages.get(this, "no_magic") );
			} else if (hero.buff( Blindness.class ) != null) {
				GLog.w( Messages.get(this, "blinded") );
			} else if (hero.buff(UnstableSpellbook.bookRecharge.class) != null
					&& hero.buff(UnstableSpellbook.bookRecharge.class).isCursed()){
				GLog.n( Messages.get(this, "cursed") );
			} else {
				curUser = hero;
				curItem = detachAll( hero.belongings.backpack );
				GameScene.selectItem( itemSelector2, mode, inventoryTitle );
			}
		}
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions( hero );
		if (!anonymous || isIdentified()) actions.add(AC_UPGRADE);
		return actions;
	}

	protected static WndBag.Listener itemSelector2 = new WndBag.Listener() {
		@Override
		public void onSelect( Item item ) {

			//FIXME this safety check shouldn't be necessary
			//it would be better to eliminate the curItem static variable.
			if (!(curItem instanceof InventoryScroll)){
				return;
			}

			if (item != null) {


				((InventoryScroll)curItem).readAnimation();
				upgrade( curUser );

				Degrade.detach( curUser, Degrade.class );

				//logic for telling the user when item properties change from upgrades
				//...yes this is rather messy
				if (item instanceof Weapon){
					Weapon w = (Weapon) item;
					boolean wasCursed = w.cursed;
					boolean hadCursedEnchant = w.hasCurseEnchant();
					boolean hadGoodEnchant = w.hasGoodEnchant();

					for (int i = 0; i < curItem.quantity(); i++) w.upgrade();

					if (w.cursedKnown && hadCursedEnchant && !w.hasCurseEnchant()){
						removeCurse( Dungeon.hero );
					} else if (w.cursedKnown && wasCursed && !w.cursed){
						weakenCurse( Dungeon.hero );
					}
					if (hadGoodEnchant && !w.hasGoodEnchant()){
						GLog.w( Messages.get(Weapon.class, "incompatible") );
					}

				} else if (item instanceof Armor){
					Armor a = (Armor) item;
					boolean wasCursed = a.cursed;
					boolean hadCursedGlyph = a.hasCurseGlyph();
					boolean hadGoodGlyph = a.hasGoodGlyph();

					for (int i = 0; i < curItem.quantity(); i++) a.upgrade();

					if (a.cursedKnown && hadCursedGlyph && !a.hasCurseGlyph()){
						removeCurse( Dungeon.hero );
					} else if (a.cursedKnown && wasCursed && !a.cursed){
						weakenCurse( Dungeon.hero );
					}
					if (hadGoodGlyph && !a.hasGoodGlyph()){
						GLog.w( Messages.get(Armor.class, "incompatible") );
					}

				} else if (item instanceof Wand || item instanceof Ring) {
					boolean wasCursed = item.cursed;

					for (int i = 0; i < curItem.quantity(); i++) item.upgrade();

					if (wasCursed && !item.cursed){
						removeCurse( Dungeon.hero );
					}

				} else {
					for (int i = 0; i < curItem.quantity(); i++) item.upgrade();
				}

				Badges.validateItemLevelAquired( item );
				Statistics.upgradesUsed += curItem.quantity();
				Badges.validateMageUnlock();
				Sample.INSTANCE.play( Assets.Sounds.READ );
				Invisibility.dispel();

			} else if (identifiedByUse && !((Scroll)curItem).anonymous) {

				((InventoryScroll)curItem).confirmCancelation();

			} else if (!((Scroll)curItem).anonymous) {

				curItem.collect( curUser.belongings.backpack );

			}
		}
	};

	@Override
	protected void onItemSelected( Item item ) {

		upgrade( curUser );

		Degrade.detach( curUser, Degrade.class );

		//logic for telling the user when item properties change from upgrades
		//...yes this is rather messy
		if (item instanceof Weapon){
			Weapon w = (Weapon) item;
			boolean wasCursed = w.cursed;
			boolean hadCursedEnchant = w.hasCurseEnchant();
			boolean hadGoodEnchant = w.hasGoodEnchant();

			w.upgrade();

			if (w.cursedKnown && hadCursedEnchant && !w.hasCurseEnchant()){
				removeCurse( Dungeon.hero );
			} else if (w.cursedKnown && wasCursed && !w.cursed){
				weakenCurse( Dungeon.hero );
			}
			if (hadGoodEnchant && !w.hasGoodEnchant()){
				GLog.w( Messages.get(Weapon.class, "incompatible") );
			}

		} else if (item instanceof Armor){
			Armor a = (Armor) item;
			boolean wasCursed = a.cursed;
			boolean hadCursedGlyph = a.hasCurseGlyph();
			boolean hadGoodGlyph = a.hasGoodGlyph();

			a.upgrade();

			if (a.cursedKnown && hadCursedGlyph && !a.hasCurseGlyph()){
				removeCurse( Dungeon.hero );
			} else if (a.cursedKnown && wasCursed && !a.cursed){
				weakenCurse( Dungeon.hero );
			}
			if (hadGoodGlyph && !a.hasGoodGlyph()){
				GLog.w( Messages.get(Armor.class, "incompatible") );
			}

		} else if (item instanceof Wand || item instanceof Ring) {
			boolean wasCursed = item.cursed;

			item.upgrade();

			if (wasCursed && !item.cursed){
				removeCurse( Dungeon.hero );
			}

		} else {
			item.upgrade();
		}

		Badges.validateItemLevelAquired( item );
		Statistics.upgradesUsed++;
		Badges.validateMageUnlock();
	}

	public static void upgrade( Hero hero ) {
		hero.sprite.emitter().start( Speck.factory( Speck.UP ), 0.2f, 3 );
	}

	public static void weakenCurse( Hero hero ){
		GLog.p( Messages.get(ScrollOfUpgrade.class, "weaken_curse") );
		hero.sprite.emitter().start( ShadowParticle.UP, 0.05f, 5 );
	}

	public static void removeCurse( Hero hero ){
		GLog.p( Messages.get(ScrollOfUpgrade.class, "remove_curse") );
		hero.sprite.emitter().start( ShadowParticle.UP, 0.05f, 10 );
	}

	@Override
	public void empoweredRead() {
		//does nothing for now, this should never happen.
	}

	@Override
	public int price() {
		return isKnown() ? 50 * quantity : super.price();
	}
}
