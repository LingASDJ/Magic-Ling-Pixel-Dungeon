/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blizzard;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Electricity;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Fire;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Freezing;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Inferno;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.SmokeScreen;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barrier;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Chill;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Reaction;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ooze;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Slow;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Lightning;
import com.shatteredpixel.shatteredpixeldungeon.effects.MagicMissile;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.BlastParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ShadowParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SmokeParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Recipe;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TalismanOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.AlchemicalCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.Potion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfMindVision;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfParalyticGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfPurity;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.BlizzardBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.CausticBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.InfernalBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.ShockingBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.Elixir;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfAdrenalineSurge;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfEarthenArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfHolyFuror;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMagicalSight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShielding;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStamina;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStormClouds;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.Shocking;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.Door;
import com.shatteredpixel.shatteredpixeldungeon.levels.features.HighGrass;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.CellSelector;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class Pistol extends Weapon {

    public static final String AC_SHOOT = "SHOOT";
    public static final String AC_RELOAD = "RELOAD";

    private int max_round;
    private int round;
    private float reload_time;
    private static final String TXT_STATUS = "%d/%d";

    {
        image = ItemSpriteSheet.DG20;

        defaultAction = AC_SHOOT;
        usesTargeting = true;

        unique = true;
        bones = false;
    }

    private static final String ROUND = "round";
    private static final String MAX_ROUND = "max_round";
    private static final String RELOAD_TIME = "reload_time";
    public static final String POTIONATTRIB = "potionattrib";
    public static final String WAS_POTIONATTRIB = "was_potionattrib";

    public Potion potionAttrib = null;
    public Potion was_potionAttrib = null;
    public ItemSprite.Glowing potionGlow = null;

    @Override
    public void storeInBundle(Bundle bundle) {
        super.storeInBundle(bundle);
        bundle.put(MAX_ROUND, max_round);
        bundle.put(ROUND, round);
        bundle.put(RELOAD_TIME, reload_time);
        bundle.put(POTIONATTRIB, potionAttrib);
        bundle.put(WAS_POTIONATTRIB, was_potionAttrib);
    }

    @Override
    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        max_round = bundle.getInt(MAX_ROUND);
        round = bundle.getInt(ROUND);
        reload_time = bundle.getFloat(RELOAD_TIME);
        if (bundle.contains(POTIONATTRIB) && round <= max_round) {
            infusePotion((Potion) bundle.get(POTIONATTRIB), true, level(), reload_time, null);
        }
        if (bundle.contains(WAS_POTIONATTRIB)) {
            setWasPotion((Potion) bundle.get(WAS_POTIONATTRIB));
        }
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.remove(AC_EQUIP);
        actions.add(AC_SHOOT);
        actions.add(AC_RELOAD);
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {

        super.execute(hero, action);

        if (action.equals(AC_SHOOT)) {
            if (round <= 0) {
                reload();
            } else {
                curUser = hero;
                curItem = this;
                GameScene.selectCell(shooter);
                updateQuickslot();
            }
        }
        if (action.equals(AC_RELOAD)) {
            reload();
        }
    }

    public void reload() {
        curUser.spend(reload_time);
        curUser.busy();

        Sample.INSTANCE.play(Assets.Sounds.UNLOCK, 2, 1.1f);
        curUser.sprite.operate(curUser.pos);
        round = Math.max(max_round, round);

        GLog.i(Messages.get(this, "reloading"));

        potionAttrib = null;
        potionGlow = null;

        if (curUser.subClass == HeroSubClass.INNOVATOR){
            potionAttrib = was_potionAttrib;
            was_potionAttrib = null;
            potionGlow = setPotionGlow(potionAttrib);
        }

        updateQuickslot();

        if (curUser.subClass == HeroSubClass.TRAILBLAZER){
            Buff.affect(curUser, Reaction.class);
        }
    }

    public void reload_start() {
        max_round = 4;
        round = Math.max(max_round, round);
        setReloadTime(2f);
        updateQuickslot();
    }

    public int getRound() { return this.round; }
    public int getMaxRound() { return this.max_round; }
    public float getReloadTime() { return this.reload_time; }

    public void setReloadTime(float time) {
        reload_time = time;
    }
    public void setWasPotion(Potion was) {
        if (was == null) was_potionAttrib = null;
        else was_potionAttrib = was;
    }

    public Item infusePotion(Potion potion, boolean restore, int upgrade, float time, Potion second) {

        potionAttrib = potion;
        potionAttrib.anonymize();
        this.level(upgrade);
        this.reload_time = time;
        if (!restore) {
            if (curUser.subClass == HeroSubClass.INNOVATOR) {
                was_potionAttrib = second;
            }
        }

        this.identify();

        if (potionAttrib instanceof PotionOfStrength) {
            if (!restore) {
                upgrade();
                max_round = level() + 4;
                round = max_round;
            }
            potionAttrib = null;
            potionGlow = null;

        } else if (potionAttrib instanceof PotionOfAdrenalineSurge) {
            if (!restore) {
                max_round = level() + 4;
                round = max_round * 3;
            }
            potionAttrib = null;
            potionGlow = null;

        } else if (!restore) {
            max_round = level() + 4;
            round = Math.max(round, max_round);
        }

        if (potion instanceof PotionOfHealing) potionGlow = new ItemSprite.Glowing(0xFF0000);
        if (potion instanceof PotionOfParalyticGas) potionGlow = new ItemSprite.Glowing(0xFFFF60);
        if (potion instanceof PotionOfInvisibility) potionGlow = new ItemSprite.Glowing(0x7FA9D2);
        if (potion instanceof PotionOfLiquidFlame) potionGlow = new ItemSprite.Glowing(0xFFAA33);
        if (potion instanceof PotionOfFrost) potionGlow = new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfMindVision) potionGlow = new ItemSprite.Glowing(0xFFC4E5);
        if (potion instanceof PotionOfToxicGas) potionGlow = new ItemSprite.Glowing(0x50FF60);
        if (potion instanceof PotionOfLevitation) potionGlow = new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfPurity) potionGlow = new ItemSprite.Glowing(0x73AB00);
        if (potion instanceof PotionOfExperience) potionGlow = new ItemSprite.Glowing(0xFFFF00);
        if (potion instanceof PotionOfHaste) potionGlow = new ItemSprite.Glowing(0xFFCF32);

        if (potion instanceof PotionOfShielding) potionGlow = new ItemSprite.Glowing(0x00A0FF);
        if (potion instanceof PotionOfMagicalSight) potionGlow = new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfSnapFreeze) potionGlow = new ItemSprite.Glowing(0x00E5FF);
        if (potion instanceof PotionOfDragonsBreath) potionGlow = new ItemSprite.Glowing(0xFFAA33);
        if (potion instanceof PotionOfCorrosiveGas) potionGlow = new ItemSprite.Glowing(0xFF8800);
        if (potion instanceof PotionOfStamina) potionGlow = new ItemSprite.Glowing(0xB4E6BC);
        if (potion instanceof PotionOfShroudingFog) potionGlow = new ItemSprite.Glowing(0x000000);
        if (potion instanceof PotionOfStormClouds) potionGlow = new ItemSprite.Glowing(0x8AD8D8);
        if (potion instanceof PotionOfEarthenArmor) potionGlow = new ItemSprite.Glowing(0x998F5C);
        if (potion instanceof PotionOfCleansing) potionGlow = new ItemSprite.Glowing(0xFF4CD2);
        if (potion instanceof PotionOfHolyFuror) potionGlow = new ItemSprite.Glowing(0xFFCF32);

        if (potion instanceof AlchemicalCatalyst) potionGlow = new ItemSprite.Glowing(0xA39E85);

        if (potion instanceof BlizzardBrew) potionGlow = new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof CausticBrew) potionGlow = new ItemSprite.Glowing(0x000000);
        if (potion instanceof InfernalBrew) potionGlow = new ItemSprite.Glowing(0xEE7722);
        if (potion instanceof ShockingBrew) potionGlow = new ItemSprite.Glowing(0xFFFF00);

        return this;
    }

    public ItemSprite.Glowing setPotionGlow(Potion potion) {

        if (potion instanceof PotionOfHealing) return new ItemSprite.Glowing(0xFF0000);
        if (potion instanceof PotionOfParalyticGas) return new ItemSprite.Glowing(0xFFFF60);
        if (potion instanceof PotionOfInvisibility) return new ItemSprite.Glowing(0x7FA9D2);
        if (potion instanceof PotionOfLiquidFlame) return new ItemSprite.Glowing(0xFFAA33);
        if (potion instanceof PotionOfFrost) return new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfMindVision) return new ItemSprite.Glowing(0xFFC4E5);
        if (potion instanceof PotionOfToxicGas) return new ItemSprite.Glowing(0x50FF60);
        if (potion instanceof PotionOfLevitation) return new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfPurity) return new ItemSprite.Glowing(0x73AB00);
        if (potion instanceof PotionOfExperience) return new ItemSprite.Glowing(0xFFFF00);
        if (potion instanceof PotionOfHaste) return new ItemSprite.Glowing(0xFFCF32);

        if (potion instanceof PotionOfShielding) return new ItemSprite.Glowing(0x00A0FF);
        if (potion instanceof PotionOfMagicalSight) return new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof PotionOfSnapFreeze) return new ItemSprite.Glowing(0x00E5FF);
        if (potion instanceof PotionOfDragonsBreath) return new ItemSprite.Glowing(0xFFAA33);
        if (potion instanceof PotionOfCorrosiveGas) return new ItemSprite.Glowing(0xFF8800);
        if (potion instanceof PotionOfStamina) return new ItemSprite.Glowing(0xB4E6BC);
        if (potion instanceof PotionOfShroudingFog) return new ItemSprite.Glowing(0x000000);
        if (potion instanceof PotionOfStormClouds) return new ItemSprite.Glowing(0x8AD8D8);
        if (potion instanceof PotionOfEarthenArmor) return new ItemSprite.Glowing(0x998F5C);
        if (potion instanceof PotionOfCleansing) return new ItemSprite.Glowing(0xFF4CD2);
        if (potion instanceof PotionOfHolyFuror) return new ItemSprite.Glowing(0xFFCF32);

        if (potion instanceof AlchemicalCatalyst) return new ItemSprite.Glowing(0xA39E85);

        if (potion instanceof BlizzardBrew) return new ItemSprite.Glowing(0xFFFFFF);
        if (potion instanceof CausticBrew) return new ItemSprite.Glowing(0x000000);
        if (potion instanceof InfernalBrew) return new ItemSprite.Glowing(0xEE7722);
        if (potion instanceof ShockingBrew) return new ItemSprite.Glowing(0xFFFF00);

        return null;
    }

    @Override
    public ItemSprite.Glowing glowing() {
        if (potionAttrib == null) {
            return null;
        }
        return potionGlow;
    }

    @Override
    public String status() {
        return Messages.format(TXT_STATUS, round, max_round);
    }

    @Override
    public String info() {
        String info = desc();

        info += "\n\n" + Messages.get(Pistol.class, "stats",
                Math.round(min()),
                Math.round(max()),
                round, max_round, reload_time);

        if (potionAttrib != null) {
            info += "\n\n" + Messages.get(Pistol.class, "now_infused", potionAttrib.toString());

            if (potionAttrib instanceof PotionOfHealing)
                info += " " + Messages.get(Pistol.class, "healing");
            if (potionAttrib instanceof PotionOfParalyticGas)
                info += " " + Messages.get(Pistol.class, "paralyticgas");
            if (potionAttrib instanceof PotionOfInvisibility)
                info += " " + Messages.get(Pistol.class, "invisibility");
            if (potionAttrib instanceof PotionOfLiquidFlame)
                info += " " + Messages.get(Pistol.class, "liquidflame");
            if (potionAttrib instanceof PotionOfFrost)
                info += " " + Messages.get(Pistol.class, "frost");
            if (potionAttrib instanceof PotionOfMindVision)
                info += " " + Messages.get(Pistol.class, "mindvision");
            if (potionAttrib instanceof PotionOfToxicGas)
                info += " " + Messages.get(Pistol.class, "toxicgas");
            if (potionAttrib instanceof PotionOfLevitation)
                info += " " + Messages.get(Pistol.class, "levitation");
            if (potionAttrib instanceof PotionOfPurity)
                info += " " + Messages.get(Pistol.class, "purity");
            if (potionAttrib instanceof PotionOfExperience)
                info += " " + Messages.get(Pistol.class, "experience");
            if (potionAttrib instanceof PotionOfHaste)
                info += " " + Messages.get(Pistol.class, "haste");

            if (potionAttrib instanceof PotionOfShielding)
                info += " " + Messages.get(Pistol.class, "shielding");
            if (potionAttrib instanceof PotionOfMagicalSight)
                info += " " + Messages.get(Pistol.class, "magicalsight");
            if (potionAttrib instanceof PotionOfSnapFreeze)
                info += " " + Messages.get(Pistol.class, "snapfreeze");
            if (potionAttrib instanceof PotionOfDragonsBreath)
                info += " " + Messages.get(Pistol.class, "dragonbreath");
            if (potionAttrib instanceof PotionOfCorrosiveGas)
                info += " " + Messages.get(Pistol.class, "corrosivegas");
            if (potionAttrib instanceof PotionOfStamina)
                info += " " + Messages.get(Pistol.class, "stamina");
            if (potionAttrib instanceof PotionOfShroudingFog)
                info += " " + Messages.get(Pistol.class, "shroudingfog");
            if (potionAttrib instanceof PotionOfStormClouds)
                info += " " + Messages.get(Pistol.class, "stormclouds");
            if (potionAttrib instanceof PotionOfEarthenArmor)
                info += " " + Messages.get(Pistol.class, "earthenarmor");
            if (potionAttrib instanceof PotionOfCleansing)
                info += " " + Messages.get(Pistol.class, "cleasnsing");
            if (potionAttrib instanceof PotionOfHolyFuror)
                info += " " + Messages.get(Pistol.class, "holyfuror");

            if (potionAttrib instanceof AlchemicalCatalyst)
                info += " " + Messages.get(Pistol.class, "catalyst");

            if (potionAttrib instanceof BlizzardBrew)
                info += " " + Messages.get(Pistol.class, "blizzard");
            if (potionAttrib instanceof CausticBrew)
                info += " " + Messages.get(Pistol.class, "caustic");
            if (potionAttrib instanceof InfernalBrew)
                info += " " + Messages.get(Pistol.class, "infernal");
            if (potionAttrib instanceof ShockingBrew)
                info += " " + Messages.get(Pistol.class, "shocking");
        }

        if (was_potionAttrib != null) {
            info += " " + Messages.get(Pistol.class, "was_infused", was_potionAttrib.toString());
        }

        info += "\n\n" + Messages.get(Pistol.class, "no_ring");

        return info;
    }

    @Override
    public int STRReq(int lvl) {
        return 1; //never receive bonus from excess STR
    }

    @Override
    public int min(int lvl){
        return 4 + (int)(lvl*2.5f);
    }

    @Override
    public int max(int lvl) {
        return 6 + (int)(lvl*3.5f);
    }

    private int targetPos;

    @Override
    public float speedFactor(Char owner) {
        if (potionAttrib != null) {
            if (potionAttrib instanceof PotionOfStamina)
                return super.speedFactor(owner) * 0.5f;
        }

        return super.speedFactor(owner);
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    public PistolShot knockShot() {
        return new PistolShot();
    }

    public class PistolShot extends MissileWeapon {

        {
            image = ItemSpriteSheet.DG20;

            hitSound = Assets.Sounds.PUFF;
            hitSoundPitch = 0.8f;
        }

        @Override
        public int damageRoll(Char owner) {
            return Pistol.this.damageRoll(owner);
        }

        @Override
        public int proc(Char attacker, Char defender, int damage) {
            // on-Hit effects
            if (Pistol.this.potionAttrib != null) {
                if (Pistol.this.potionAttrib instanceof PotionOfHealing) {
                    // 50% of damage dealt
                    int healAmt = Math.round(damage * 0.5f);
                    healAmt = Math.min(healAmt, attacker.HT - attacker.HP);

                    if (healAmt > 0 && attacker.isAlive()) {
                        attacker.HP += healAmt;
                        attacker.sprite.emitter().start(Speck.factory(Speck.HEALING), 0.4f, 1);
                        attacker.sprite.showStatus(CharSprite.POSITIVE, Integer.toString(healAmt));
                    }
                } else if (Pistol.this.potionAttrib instanceof PotionOfShielding) {
                    // 33% of damage dealt
                    int shAmt = Math.round(damage * 0.333f);
                    if (shAmt > 0 && attacker.isAlive()) {

                        if (attacker.shielding() <= 0) {
                            Buff.affect(attacker, Barrier.class).setShield(shAmt);
                        } else Buff.affect(attacker, Barrier.class).incShield(shAmt);

                        attacker.sprite.emitter().burst(MagicMissile.MagicParticle.ATTRACTING, 10);
                        attacker.sprite.showStatus(0x00A0FF, Integer.toString(shAmt));
                    }
                } else if (Pistol.this.potionAttrib instanceof PotionOfLiquidFlame)
                    Buff.affect(defender, Burning.class).reignite(defender, 4f);
                else if (Pistol.this.potionAttrib instanceof PotionOfFrost)
                    Buff.affect(defender, Chill.class, 4f);
                else if (Pistol.this.potionAttrib instanceof PotionOfParalyticGas)
                    Buff.affect(defender, Paralysis.class, Pistol.this.speedFactor(curUser)+curUser.cooldown());
                else if (Pistol.this.potionAttrib instanceof PotionOfToxicGas)
                    Buff.affect(defender, Poison.class).set(4f);
                else if (Pistol.this.potionAttrib instanceof PotionOfMindVision)
                    Buff.append(Dungeon.hero, TalismanOfForesight.CharAwareness.class, 10f).charID = defender.id();
                else if (Pistol.this.potionAttrib instanceof PotionOfInvisibility)
                    Buff.affect(defender, Blindness.class, 1f+Pistol.this.speedFactor(curUser));
                else if (Pistol.this.potionAttrib instanceof PotionOfLevitation)
                    Buff.affect(defender, Vertigo.class, 2f);
                else if (Pistol.this.potionAttrib instanceof PotionOfHaste)
                    Buff.affect(defender, Slow.class, 2f);
                else if (Pistol.this.potionAttrib instanceof PotionOfStamina)
                    damage -= damage * 0.333f;
                else if (Pistol.this.potionAttrib instanceof PotionOfCleansing)
                    PotionOfPurity.purify(attacker.pos);
                else if (Pistol.this.potionAttrib instanceof PotionOfStormClouds) {
                    ArrayList<Char> affected = new ArrayList<>();
                    ArrayList<Lightning.Arc> arcs = new ArrayList<>();
                    Shocking.arc(curUser, defender, 2, affected, arcs);
                    if (!Dungeon.level.water[defender.pos]) {
                        affected.remove(defender);
                    }
                    for (Char ch : affected) {
                        ch.damage(Math.round(damage * 0.4f), curUser);
                    }
                    curUser.sprite.parent.addToFront(new Lightning(arcs, null));
                    Sample.INSTANCE.play(Assets.Sounds.LIGHTNING);
                } else if (Pistol.this.potionAttrib instanceof PotionOfEarthenArmor) {
                    Buff.affect(attacker, Barkskin.class).add(Actor.findById(2), 4);
                } else if (Pistol.this.potionAttrib instanceof PotionOfHolyFuror) {
                    if (defender.properties().contains(Char.Property.DEMONIC)
                            || defender.properties().contains(Char.Property.UNDEAD)) {
                        defender.sprite.emitter().start(ShadowParticle.UP, 0.05f, 10);
                        damage *= 1.333f;
                    }
                } else if (Pistol.this.potionAttrib instanceof AlchemicalCatalyst) {
                    damage += Math.max(1, Dungeon.depth / 5);
                }
            }

            if (curUser.subClass == HeroSubClass.TRAILBLAZER
                    && defender.HP <= damage){
                Buff.affect(curUser, Reaction.class);
            }

            return Pistol.this.proc(attacker, defender, damage);
        }

        @Override
        public float speedFactor(Char user) {
            return Pistol.this.speedFactor(user);
        }

        @Override
        public float accuracyFactor(Char owner) {
            if (Pistol.this.potionAttrib instanceof PotionOfExperience) {
                return Float.POSITIVE_INFINITY;
            } else {
                return super.accuracyFactor(owner);
            }
        }

        @Override
        public int STRReq(int lvl) {
            return Pistol.this.STRReq(lvl);
        }

        @Override
        protected void onThrow(int cell) {
            CellEmitter.get(curUser.pos).burst(SmokeParticle.FACTORY, 2);
            CellEmitter.center(curUser.pos).burst(BlastParticle.FACTORY, 2);

            Char enemy = Actor.findChar(cell);
            if (enemy == null || enemy == curUser) {
                parent = null;
                CellEmitter.get(cell).burst(SmokeParticle.FACTORY, 2);
                CellEmitter.center(cell).burst(BlastParticle.FACTORY, 2);
            } else {
                if (!curUser.shoot(enemy, this)) {
                    CellEmitter.get(cell).burst(SmokeParticle.FACTORY, 2);
                    CellEmitter.center(cell).burst(BlastParticle.FACTORY, 2);
                }
            }

            // cell effects
            if (Pistol.this.potionAttrib != null) {
                if (Pistol.this.potionAttrib instanceof PotionOfPurity) {
                    PotionOfPurity.purify(cell);
                }
                else if (Pistol.this.potionAttrib instanceof PotionOfLiquidFlame) {
                    if (enemy == null && !Dungeon.level.solid[cell]) {
                        Fire.burn(cell);
                    }
                }
                else if (Pistol.this.potionAttrib instanceof PotionOfFrost) {
                    if (enemy == null && !Dungeon.level.solid[cell]) {
                        Fire fire = (Fire) Dungeon.level.blobs.get(Fire.class);
                        Freezing.affect(cell, fire);
                        Freezing.freeze(cell);
                    }
                }
                else if (Pistol.this.potionAttrib instanceof PotionOfMagicalSight) {
                    for (int n : PathFinder.NEIGHBOURS9) {
                        if (Dungeon.level.discoverable[cell + n])
                            Dungeon.level.mapped[cell + n] = true;

                        int terr = Dungeon.level.map[cell + n];
                        if ((Terrain.flags[terr] & Terrain.SECRET) != 0) {
                            Dungeon.level.discover(cell);
                            GameScene.discoverTile(cell, terr);
                            ScrollOfMagicMapping.discover(cell);
                        }
                    }
                    GameScene.updateFog();
                }
                else if (Pistol.this.potionAttrib instanceof PotionOfDragonsBreath) {
                    if (!Dungeon.level.solid[cell]) {
                        ArrayList<Char> affected = new ArrayList<>();
                        if (Dungeon.level.heroFOV[cell]) {
                            CellEmitter.center(cell).burst(BlastParticle.FACTORY, 30);
                        }
                        boolean terrainAffected = false;
                        for (int n : PathFinder.NEIGHBOURS9) {
                            int c = cell + n;
                            if (c >= 0 && c < Dungeon.level.length()) {
                                if (Dungeon.level.heroFOV[c]) {
                                    CellEmitter.get(c).burst(SmokeParticle.FACTORY, 4);
                                }
                                if (Dungeon.level.flamable[c]) {
                                    Dungeon.level.destroy(c);
                                    GameScene.updateMap(c);
                                    terrainAffected = true;
                                }
                                Heap heap = Dungeon.level.heaps.get(c);
                                if (heap != null) heap.explode();
                                Char ch = Actor.findChar(c);
                                if (ch != null) {
                                    affected.add(ch);
                                }
                            }
                        }
                        for (Char ch : affected) {
                            if (!ch.isAlive()) {
                                continue;
                            }
                            int dmg = damageRoll(curUser);
                            if (ch.pos != cell) {
                                dmg = Math.round(dmg * 0.666f);
                            }
                            dmg -= ch.drRoll();

                            if  (dmg > 2) {
                                dmg /= 2;
                            }

                            if (dmg > 0) {
                                ch.damage(dmg, this);
                            }
                            if (ch == Dungeon.hero && !ch.isAlive()) {
                                Dungeon.fail(Bomb.class);
                            }
                        }
                        if (terrainAffected) {
                            Dungeon.observe();
                        }
                    }
                }
                else if (Pistol.this.potionAttrib instanceof PotionOfShroudingFog) {
                    for (int offset : PathFinder.NEIGHBOURS9) {
                        if (!Dungeon.level.solid[cell + offset]) {
                            GameScene.add(Blob.seed(cell + offset, 10, SmokeScreen.class));
                            Sample.INSTANCE.play(Assets.Sounds.GAS);
                        }
                    }
                }
                else if (Pistol.this.potionAttrib instanceof BlizzardBrew) {
                    for (int offset : PathFinder.NEIGHBOURS9) {
                        if (!Dungeon.level.solid[cell + offset]) {
                            GameScene.add(Blob.seed(cell + offset, 3, Blizzard.class));
                            Sample.INSTANCE.play(Assets.Sounds.GAS);
                        }
                    }
                }
                else if (Pistol.this.potionAttrib instanceof InfernalBrew) {
                    for (int offset : PathFinder.NEIGHBOURS9) {
                        if (!Dungeon.level.solid[cell + offset]) {
                            GameScene.add(Blob.seed(cell + offset, 5, Inferno.class));
                            Sample.INSTANCE.play(Assets.Sounds.GAS);
                        }
                    }
                }
                else if (Pistol.this.potionAttrib instanceof ShockingBrew) {
                    for (int offset : PathFinder.NEIGHBOURS9) {
                        if (!Dungeon.level.solid[cell + offset]) {
                            GameScene.add(Blob.seed(cell + offset, 3, Electricity.class));
                            Sample.INSTANCE.play(Assets.Sounds.LIGHTNING);
                        }
                    }
                }
                else if (Pistol.this.potionAttrib instanceof CausticBrew) {
                    for (int offset : PathFinder.NEIGHBOURS9) {
                        if (!Dungeon.level.solid[cell + offset]) {
                            Splash.at(cell, 0x000000, 5);
                            Char caustic = Actor.findChar(cell);
                            if (caustic != null) {
                                Buff.affect(caustic, Ooze.class).set(5f);
                            }
                            Sample.INSTANCE.play(Assets.Sounds.MELD);
                        }
                    }
                }
            }
        }

        @Override
        public void throwSound() {
            Sample.INSTANCE.play(Assets.Sounds.HIT_CRUSH, 1, Random.Float(0.33f, 0.66f));
        }

        @Override
        public void cast(final Hero user, final int dst) {
            final int cell = throwPos(user, dst);
            Pistol.this.targetPos = cell;
            if (Pistol.this.round == 1){
                Sample.INSTANCE.play(Assets.Sounds.HIT_PARRY, 0.33f, 1.1f);
            }
            Pistol.this.round--;
            updateQuickslot();

            super.cast(user, dst);
        }
    }

    private CellSelector.Listener shooter = new CellSelector.Listener() {
        @Override
        public void onSelect(Integer target) {
            if (target != null) {

                if (target == curUser.pos) {
                    reload();

                } else {

                    Ballistica prepare = new Ballistica(curUser.pos, target,
                            Ballistica.IGNORE_SOFT_SOLID);
                    boolean terrainAffected = false;
                    boolean terrainSolid = false;
                    for (int c : prepare.path) {
                        Char obstacle = Actor.findChar(c);
                        if ((!Dungeon.level.passable[c] && !Dungeon.level.avoid[c])
                                || (obstacle != null && obstacle != curUser)) {
                            terrainSolid = true;
                        }

                        if (Dungeon.level.flamable[c] && !terrainSolid && !(c == curUser.pos)) {
                            if (Dungeon.level.map[c] == Terrain.DOOR) {
                                Door.enter(c);
                            } else if (Dungeon.level.map[c] == Terrain.HIGH_GRASS
                                    || Dungeon.level.map[c] == Terrain.FURROWED_GRASS) {
                                HighGrass.trample(Dungeon.level, c);
                            }

                            GameScene.updateMap(c);
                            terrainAffected = true;
                        }
                    }
                    if (terrainAffected) {
                        Dungeon.observe();
                    }
                    knockShot().cast(curUser, target);
                }
            }
        }

        @Override
        public String prompt() {
            return Messages.get(Pistol.class, "prompt");
        }
    };

    public static class PotionRound extends Recipe {

        @Override
        //also sorts ingredients if it can
        public boolean testIngredients(ArrayList<Item> ingredients) {
            if (ingredients.size() != 2) return false;

            if (!ingredients.get(0).isIdentified())
                return false;
            if (!ingredients.get(1).isIdentified())
                return false;

            if (ingredients.get(0) instanceof Pistol) {
                if (!(ingredients.get(1) instanceof Potion)) {
                    return false;
                } else if (ingredients.get(1) instanceof Elixir) return false;
            } else if (ingredients.get(0) instanceof Potion) {
                if (ingredients.get(0) instanceof Elixir) return false;
                else if (ingredients.get(1) instanceof Pistol) {
                    Item temp = ingredients.get(0);
                    ingredients.set(0, ingredients.get(1));
                    ingredients.set(1, temp);
                } else {
                    return false;
                }
            } else {
                return false;
            }

            Pistol pistol = (Pistol) ingredients.get(0);
            Potion potion = (Potion) ingredients.get(1);

            if (pistol.quantity() >= 1 && potion.quantity() >= 1) {
                return true;
            }

            return false;
        }

        @Override
        public int cost(ArrayList<Item> ingredients) {
            return 0;
        }

        @Override
        public Item brew(ArrayList<Item> ingredients) {
            if (!testIngredients(ingredients)) return null;

            int upgrade = ingredients.get(0).level();
            float time = ((Pistol)ingredients.get(0)).getReloadTime();
            Potion second = ((Pistol) ingredients.get(0)).potionAttrib;

            if (ingredients.get(0) instanceof Pistol){
                ingredients.get(1).quantity(ingredients.get(1).quantity() - 1);
                return ((Pistol) ingredients.get(0)).infusePotion((Potion) ingredients.get(1), false, upgrade, time, second);
            } else {
                ingredients.get(0).quantity(ingredients.get(0).quantity() - 1);
                return ((Pistol) ingredients.get(0)).infusePotion((Potion) ingredients.get(1), false, upgrade, time, second);
            }
        }

        @Override
        public Item sampleOutput(ArrayList<Item> ingredients) {
            if (!testIngredients(ingredients)) return null;

            int upgrade = ingredients.get(0).level();
            float time = ((Pistol)ingredients.get(0)).getReloadTime();
            Potion second = ((Pistol) ingredients.get(0)).was_potionAttrib;

            return new Pistol().infusePotion((Potion) ingredients.get(1), false, upgrade, time, second);
        }
    }
}
