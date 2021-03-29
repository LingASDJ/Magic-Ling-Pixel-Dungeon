/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ooze;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.IronKey;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.SkeletonKey;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CausticSlimeSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SlimeKingSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SlimeSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.BossHealthBar;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class SlimeKing extends Slime {

	{
		HP = HT = 140;
		EXP = 20;
		defenseSkill = 34;
		spriteClass = SlimeKingSprite.class;

		lootChance = 1;

		properties.add(Property.BOSS);
	}

    private int delay = 0;

	private boolean canTryToSummon() {

		int ratCount = 0;
		for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])){

			if (mob instanceof Rat){
				ratCount++;
			}
		}
		if (ratCount < 6 && delay <= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean attack( Char enemy ) {
		if (canAttack(enemy) && canTryToSummon()) {
			summon();
			return true;
		} else if(canAttack(enemy)){
			return super.attack(enemy);
		}
		else return false;
	}

    @Override
    public int attackProc( Char enemy, int damage ) {
        if (Random.Int( 2 ) == 0) {
            Buff.affect( enemy, Ooze.class ).set( Ooze.DURATION );
            enemy.sprite.burst( 0x000000, 5 );
        }

        return super.attackProc( enemy, damage );
    }

	@Override
	public void move( int step ) {
		Dungeon.level.seal();
		super.move( step );
	}
    private int summonCooldown = 10;

	private void summon() {

		delay = (int)(summonCooldown - (5 - 5 * (float)HP/HT));

		sprite.centerEmitter().start( Speck.factory( Speck.SCREAM ), 0.4f, 2 );
		Sample.INSTANCE.play( Assets.Sounds.CHALLENGE );

		for(int i = 0;i <= (6 + (1 -(float)HP/HT)) ; i++){
			int newPos = 0;
			do {
				newPos = Random.Int(Dungeon.level.length());
			} while (
					Dungeon.level.solid[newPos] ||
							Dungeon.level.distance(newPos, enemy.pos) < 12 ||
							Actor.findChar(newPos) != null);
			if (Random.Int(1000) <= 500){
				Slime_Red rat = new Slime_Red();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else if(Random.Int(500) <= 250){
				Slime_Orange rat = new Slime_Orange();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else if(Random.Int(250) <= 125){
				Slime_Lt rat = new Slime_Lt();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else if(Random.Int(125) <= 75){
				Slime_Qs rat = new Slime_Qs();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else if(Random.Int(75) <= 37){
				Slime_Lg rat = new Slime_Lg();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else if(Random.Int(37) <= 18){
				Slime_Sn rat = new Slime_Sn();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}else{
				Slime_Sz rat = new Slime_Sz();
				rat.state = rat.WANDERING;
				rat.pos = newPos;
				GameScene.add(rat);
				rat.beckon(pos );
			}
		}

		yell( Messages.get(this, "arise") );
	}

	@Override
	public void notice() {
		super.notice();
		BossHealthBar.assignBoss(this);
		yell( Messages.get(this, "notice") );
	}

		@Override
	public void die( Object cause ) {

		super.die( cause );

		Dungeon.level.unseal();

		GameScene.bossSlain();
		Dungeon.level.drop( new IronKey( Dungeon.depth ), pos ).sprite.drop();

		//60% chance of 2 blobs, 30% chance of 3, 10% chance for 4. Average of 2.5
		int blobs = Random.chances(new float[]{0, 0, 6, 3, 1});
		for (int i = 0; i < blobs; i++){
			int ofs;
			do {
				ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
			} while (!Dungeon.level.passable[pos + ofs]);
			Dungeon.level.drop( new GooBlob(), pos + ofs ).sprite.drop( pos );
		}

		Badges.validateBossSlain();

		yell( Messages.get(this, "defeated") );
	}

    @Override
    public void rollToDropLoot() {
        if (Dungeon.hero.lvl > maxLvl + 2) return;

        super.rollToDropLoot();

        int ofs;
        do {
            ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
        } while (!Dungeon.level.passable[pos + ofs]);
        Dungeon.level.drop( new GooBlob(), pos + ofs ).sprite.drop( pos );
    }
}
