// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
//* Pixel Dungeon
//        * Copyright (C) 2012-2015 Oleg Dolya
//        *
//        * Shattered Pixel Dungeon
//        * Copyright (C) 2014-2019 Evan Debenham
//        *
//        * This program is free software: you can redistribute it and/or modify
//        * it under the terms of the GNU General Public License as published by
//        * the Free Software Foundation, either version 3 of the License, or
//        * (at your option) any later version.
//        *
//        * This program is distributed in the hope that it will be useful,
//        * but WITHOUT ANY WARRANTY; without even the implied warranty of
//        * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//        * GNU General Public License for more details.
//        *
//        * You should have received a copy of the GNU General Public License
//        * along with this program.  If not, see <http://www.gnu.org/licenses/>
//警告：尚未完全修复

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.bosses;

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.ToxicGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.*;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.effects.*;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.ElmoParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.LloydsBeacon;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.SkeletonKey;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM150Sprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM300AttackSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM300DeathBallSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM300SpiderSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM300Sprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM75Sprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.BossHealthBar;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.Camera;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.*;
import com.watabou.utils.Random;

import java.util.*;

public class DM300 extends Mob
{
    public static class DM150 extends Mob
    {

        public int attackSkill(Char char1)
        {
            return 14;
        }

        @Override
        public void damage(int dmg, Object src) {
            super.damage(dmg, src);
            LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
            if (lock != null && !isImmune(src.getClass())) lock.addTime(dmg*1.5f);
        }
        public int damageRoll()
        {
            return Random.NormalIntRange(10, 13);
        }

        public void die(Object obj)
        {
            super.die(obj);
            obj = new ArrayList();
            for(int i = 0; i < PathFinder.NEIGHBOURS8.length; i++)
                ((ArrayList) (obj)).add(Integer.valueOf(pos + PathFinder.NEIGHBOURS8[i]));

            if(!Dungeon.level.mobs.isEmpty())
            {
                for(obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    int j = ((Integer)((Iterator) (obj)).next()).intValue();
                    if(Actor.findChar(j) instanceof DM150)
                    {
                        if(Actor.findChar(j) instanceof DM150)
                        obj = new DM300AttackMode();
                        ((DM300AttackMode) obj).pos = pos;
                        GameScene.add(((Mob) (obj)));
                        Actor.addDelayed(new Pushing(((Char) (obj)), pos, ((DM300AttackMode) (obj)).pos), -1F);
                        return;
                    }
                }

                for(obj = Dungeon.level.mobs.iterator(); ((Iterator) (obj)).hasNext(); Actor.findChar(((Mob)((Iterator) (obj)).next()).pos).die(this));
                GameScene.bossSlain();
                Dungeon.level.drop(new SkeletonKey(Dungeon.depth), pos).sprite.drop();
                Badges.validateBossSlain();
                obj = (LloydsBeacon)Dungeon.hero.belongings.getItem(LloydsBeacon.class);
                if(obj != null)
                    ((LloydsBeacon) (obj)).upgrade();
                yell( Messages.get(this, "defeated") );
            }
        }

        public int drRoll() {
            return Random.NormalIntRange(0, 10);
        }

        public void move(int i)
        {
            super.move(i);
            if(Dungeon.level.map[i] == 19 && HP < HT)
            {
                HP = HP + Random.Int(1, HT - HP);
                sprite.emitter().burst(ElmoParticle.FACTORY, 3);
                if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                    GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
            }
        }

        public void notice()
        {
            super.notice();
            yell(Messages.get(this, "notice"));
        }

        public DM150()
        {
            spriteClass = DM150Sprite.class;
            HT = 50;
            HP = 50;
            EXP = 15;
            defenseSkill = 9;
            loot = new StoneOfEnchantment();
            lootChance = 0.333F;
        }
    }

    public static class DM300AttackMode extends Mob
    {

        public int attackSkill(Char char1)
        {
            return 28;
        }

        @Override
        public void damage(int dmg, Object src) {
            super.damage(dmg, src);
            LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
            if (lock != null && !isImmune(src.getClass())) lock.addTime(dmg*1.5f);
        }

        public int damageRoll()
        {
            return Random.NormalIntRange(20, 25);
        }

        public void die( Object cause ) {

            super.die( cause );

            GameScene.bossSlain();
            Dungeon.level.drop( new SkeletonKey( Dungeon.depth  ), pos ).sprite.drop();

            //60% chance of 2 shards, 30% chance of 3, 10% chance for 4. Average of 2.5
            int shards = Random.chances(new float[]{0, 0, 6, 3, 1});
            for (int i = 0; i < shards; i++){
                int ofs;
                do {
                    ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
                } while (!Dungeon.level.passable[pos + ofs]);
                Dungeon.level.drop( new MetalShard(), pos + ofs ).sprite.drop( pos );
            }

            Badges.validateBossSlain();

            LloydsBeacon beacon = Dungeon.hero.belongings.getItem(LloydsBeacon.class);
            if (beacon != null) {
                beacon.upgrade();
            }

            yell( Messages.get(this, "defeated") );
        }

        public int drRoll()
        {
            return Random.NormalIntRange(0, 10);
        }

        public void move(int i)
        {
            super.move(i);
            if(Dungeon.level.map[i] == 19 && HP < HT)
            {
                HP = HP + Random.Int(1, HT - HP);
                sprite.emitter().burst(ElmoParticle.FACTORY, 5);
                if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                    GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
            }
            int ai[] = new int[8];
            int j = i - 1;
            ai[0] = j;
            int k = i + 1;
            ai[1] = k;
            ai[2] = i - Dungeon.level.width();
            ai[3] = i + Dungeon.level.width();
            ai[4] = j - Dungeon.level.width();
            ai[5] = j + Dungeon.level.width();
            ai[6] = k - Dungeon.level.width();
            ai[7] = k + Dungeon.level.width();
            i = ai[Random.Int(ai.length)];
            if(Dungeon.level.heroFOV[i])
            {
                CellEmitter.get(i).start(Speck.factory(8), 0.07F, 10);
                Camera.main.shake(3F, 0.7F);
                Sample.INSTANCE.play("sound/snd_rocks.mp3");
                if(Dungeon.level.water[i])
                    GameScene.ripple(i);
                else
                if(Dungeon.level.map[i] == 1)
                {
                    Level.set(i, 20);
                    GameScene.updateMap(i);
                }
            }
            Char char1 = Actor.findChar(i);
            Char ch = null;
            if(char1 != null && char1 != this)
                Buff.prolong( ch, Paralysis.class, 2 );
        }

        public void notice()
        {
            super.notice();
            BossHealthBar.assignBoss(this);
            yell(Messages.get(this, "notice"));
        }

        public void restoreFromBundle(Bundle bundle)
        {
            super.restoreFromBundle(bundle);
            BossHealthBar.assignBoss(this);
        }

        public void split(int i, Char char1)
        {
            ArrayList arraylist = new ArrayList();
            for(int j = 0; j < PathFinder.NEIGHBOURS8.length; j++)
            {
                int k = PathFinder.NEIGHBOURS8[j] + i;
                if(Actor.findChar(k) == null && (Dungeon.level.passable[k] || Dungeon.level.avoid[k]))
                    arraylist.add(Integer.valueOf(k));
            }

            if(arraylist.size() > 0)
            {
                DM75 dm75 = new DM75();
                dm75.pos = ((Integer)Random.element(arraylist)).intValue();
                GameScene.add(dm75);
                Actor.addDelayed(new Pushing(dm75, i, dm75.pos), -1F);
            }
            Iterator iterator = Dungeon.level.mobs.iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                Mob mob = (Mob)iterator.next();
                if(mob instanceof DM150)
                    mob.aggro(char1);
            } while(true);
        }

        public DM300AttackMode()
        {
            spriteClass = DM300AttackSprite.class;
            HT = 200;
            HP = 200;
            EXP = 30;
            defenseSkill = 18;
        }
    }

    public static class DM300DeathBall extends Mob
    {

        public int attackSkill(Char char1)
        {
            return 15;
        }

        public void damage(int i, Object obj)
        {
            super.damage(i, obj);
            LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
        }

        public int damageRoll()
        {
            return Random.NormalIntRange(20, 25);
        }

        public void die(Object obj)
        {
            super.die(obj);
            GameScene.bossSlain();
            Dungeon.level.drop(new SkeletonKey(Dungeon.depth), pos).sprite.drop();
            Badges.validateBossSlain();
            LloydsBeacon beacon = Dungeon.hero.belongings.getItem(LloydsBeacon.class);
            if(obj != null)
                ((LloydsBeacon) (obj)).upgrade();
            yell( Messages.get(this, "defeated") );
        }

        public int drRoll()
        {
            return Random.NormalIntRange(0, 8);
        }

        public void move(int i)
        {
            super.move(i);
            if(Dungeon.level.map[i] == 19 && HP < HT)
            {
                HP = HP + Random.Int(1, HT - HP);
                sprite.emitter().burst(ElmoParticle.FACTORY, 5);
                if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                    GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
            }
            int ai[] = new int[8];
            int j = i - 1;
            ai[0] = j;
            int k = i + 1;
            ai[1] = k;
            ai[2] = i - Dungeon.level.width();
            ai[3] = i + Dungeon.level.width();
            ai[4] = j - Dungeon.level.width();
            ai[5] = j + Dungeon.level.width();
            ai[6] = k - Dungeon.level.width();
            ai[7] = k + Dungeon.level.width();
            i = ai[Random.Int(ai.length)];
            if(Dungeon.level.heroFOV[i])
            {
                CellEmitter.get(i).start(Speck.factory(8), 0.07F, 10);
                Camera.main.shake(3F, 0.7F);
                Sample.INSTANCE.play("sound/snd_rocks.mp3");
                if(Dungeon.level.water[i])
                    GameScene.ripple(i);
                else
                if(Dungeon.level.map[i] == 1)
                {
                    Level.set(i, 20);
                    GameScene.updateMap(i);
                }
            }
            Char char1 = Actor.findChar(i);
            if(char1 != null && char1 != this)
                Buff.prolong( char1, Paralysis.class, 2 );
        }

        public void notice()
        {
            super.notice();
            BossHealthBar.assignBoss(this);
            yell(Messages.get(this, "notice"));
        }

        public void restoreFromBundle(Bundle bundle)
        {
            super.restoreFromBundle(bundle);
            BossHealthBar.assignBoss(this);
        }

        public DM300DeathBall()
        {
            spriteClass = DM300DeathBallSprite.class;
            HT = 50;
            HP = 50;
            EXP = 10;
            defenseSkill = 25;
        }
    }

    public static class DM300SpiderMode extends Mob
    {

        public int attackSkill(Char char1)
        {
            return 26;
        }

        @Override
        public void damage(int dmg, Object src) {
            super.damage(dmg, src);
            LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
            if (lock != null && !isImmune(src.getClass())) lock.addTime(dmg*1.5f);
        }

        public int damageRoll()
        {
            return Random.NormalIntRange(18, 23);
        }

        public void die(Object obj)
        {
            super.die(obj);
            obj = new DM300DeathBall();
            ((DM300DeathBall) obj).pos = pos;
            GameScene.add(((Mob) (obj)));
            Actor.addDelayed(new Pushing(((Char) (obj)), pos, ((DM300DeathBall) (obj)).pos), -1F);
            yell( Messages.get(this, "defeated") );
        }

        public int drRoll()
        {
            return Random.NormalIntRange(0, 8);
        }

        public void move(int i)
        {
            super.move(i);
            if(Dungeon.level.map[i] == 19 && HP < HT)
            {
                HP = HP + Random.Int(1, HT - HP);
                sprite.emitter().burst(ElmoParticle.FACTORY, 5);
                if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                    GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
            }
            int ai[] = new int[8];
            int j = i - 1;
            ai[0] = j;
            int k = i + 1;
            ai[1] = k;
            ai[2] = i - Dungeon.level.width();
            ai[3] = i + Dungeon.level.width();
            ai[4] = j - Dungeon.level.width();
            ai[5] = j + Dungeon.level.width();
            ai[6] = k - Dungeon.level.width();
            ai[7] = k + Dungeon.level.width();
            i = ai[Random.Int(ai.length)];
            if(Dungeon.level.heroFOV[i])
            {
                CellEmitter.get(i).start(Speck.factory(8), 0.07F, 10);
                Camera.main.shake(3F, 0.7F);
                Sample.INSTANCE.play("sound/snd_rocks.mp3");
                if(Dungeon.level.water[i])
                    GameScene.ripple(i);
                else
                if(Dungeon.level.map[i] == 1)
                {
                    Level.set(i, 20);
                    GameScene.updateMap(i);
                }
            }
            Char char1 = Actor.findChar(i);
            if(char1 != null && char1 != this)
                Buff.prolong( char1, Paralysis.class, 2 );
        }

        public void notice()
        {
            super.notice();
            BossHealthBar.assignBoss(this);
            yell(Messages.get(this, "notice"));
        }

        public void restoreFromBundle(Bundle bundle)
        {
            super.restoreFromBundle(bundle);
            BossHealthBar.assignBoss(this);
        }

        public DM300SpiderMode()
        {
            spriteClass = DM300SpiderSprite.class;
            HT = 80;
            HP = 80;
            EXP = 10;
            defenseSkill = 23;
        }
    }

    public static class DM75 extends Mob
    {

        public int attackSkill(Char char1)
        {
            return 7;
        }

        @Override
        public void damage(int dmg, Object src) {
            super.damage(dmg, src);
            LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
            if (lock != null && !isImmune(src.getClass())) lock.addTime(dmg*1.5f);
        }

        public int damageRoll()
        {
            return Random.NormalIntRange(5, 6);
        }

        public void die(Object obj)
        {
            super.die(obj);
            obj = new ArrayList();
            for(int i = 0; i < PathFinder.NEIGHBOURS8.length; i++)
                ((ArrayList) (obj)).add(Integer.valueOf(pos + PathFinder.NEIGHBOURS8[i]));

            if(!Dungeon.level.mobs.isEmpty())
            {
                for(obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    int j = ((Integer)((Iterator) (obj)).next()).intValue();
                    if(Actor.findChar(j) instanceof DM75)
                    {
                        Actor.findChar(j).die(this);
                        obj = new DM300SpiderMode();
                        ((DM300SpiderMode) obj).pos = pos;
                        GameScene.add(((Mob) (obj)));
                        Actor.addDelayed(new Pushing(((Char) (obj)), pos, ((DM300SpiderMode) (obj)).pos), -1F);
                        return;
                    }
                }

                for(obj = Dungeon.level.mobs.iterator(); ((Iterator) (obj)).hasNext(); Actor.findChar(((Mob)((Iterator) (obj)).next()).pos).die(this));
                GameScene.bossSlain();
                Dungeon.level.drop(new SkeletonKey(Dungeon.depth), pos).sprite.drop();
                Badges.validateBossSlain();
                LloydsBeacon beacon = Dungeon.hero.belongings.getItem(LloydsBeacon.class);
                if(obj != null)
                    ((LloydsBeacon) (obj)).upgrade();
                yell( Messages.get(this, "defeated") );
            }
        }

        public int drRoll()
        {
            return Random.NormalIntRange(0, 3);
        }

        public void move(int i)
        {
            super.move(i);
            if(Dungeon.level.map[i] == 19 && HP < HT)
            {
                HP = HP + Random.Int(1, HT - HP);
                sprite.emitter().burst(ElmoParticle.FACTORY, 1);
                if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                    GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
            }
        }

        public void notice()
        {
            super.notice();
            yell(Messages.get(this, "notice", new Object[0]));
        }

        public DM75()
        {
            spriteClass = DM75Sprite.class;
            HT = 25;
            HP = 25;
            EXP = 7;
            defenseSkill = 4;
            loot = new StoneOfEnchantment();
            lootChance = 0.333F;
        }
    }


    public DM300()
    {
        spriteClass = DM300Sprite.class;

        HP = HT = 200;
        EXP = 30;
        defenseSkill = 18;


        properties.add(Property.BOSS);
        properties.add(Property.INORGANIC);
    }

    public boolean act()
    {
        GameScene.add(Blob.seed(pos, 30, ToxicGas.class));
        return super.act();
    }

    public int attackSkill(Char char1)
    {
        return 20;
    }

    @Override
    public void damage(int dmg, Object src) {
        super.damage(dmg, src);
        LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
        if (lock != null && !isImmune(src.getClass())) lock.addTime(dmg*1.5f);
    }

    public int damageRoll()
    {
        return Random.NormalIntRange(15, 20);
    }

    public void die(Object obj)
    {
        super.die(obj);
        split(pos, enemy);
        split(pos, enemy);
        int i = 0;
        yell( Messages.get(this, "defeated") );
        boolean flag = true;
        int j;
        if(Dungeon.isChallenged(1))
        {
            i = 10;
            j = 1;
        } else
        {
            j = 0;
        }
        int k = j;
        j = i;
        if(Dungeon.isChallenged(2))
        {
            j = i + 10;
            k = 1;
        }
        i = j;
        if(Dungeon.isChallenged(4))
        {
            i = j + 10;
            k = 1;
        }
        j = i;
        if(Dungeon.isChallenged(8))
        {
            j = i + 10;
            k = 1;
        }
        i = k;
        k = j;
        if(Dungeon.isChallenged(16))
        {
            k = j + 10;
            i = 1;
        }
        j = i;
        i = k;
        if(Dungeon.isChallenged(32))
        {
            i = k + 10;
            j = 1;
        }
        k = j;
        j = i;
        if(Dungeon.isChallenged(64))
        {
            j = i + 10;
            k = 1;
        }
        if(Dungeon.isChallenged(128))
        {
            j += 10;
            i = ((flag) ? 1 : 0);
        } else
        {
            i = k;
        }
    }

    public int drRoll()
    {
        return Random.NormalIntRange(0, 8);
    }

    public void move(int i)
    {
        super.move(i);
        if(Dungeon.level.map[i] == 19 && HP < HT)
        {
            HP = HP + Random.Int(1, HT - HP);
            sprite.emitter().burst(ElmoParticle.FACTORY, 5);
            if(Dungeon.level.heroFOV[i] && Dungeon.hero.isAlive())
                GLog.n(Messages.get(this, "repair", new Object[0]), new Object[0]);
        }
        int ai[] = new int[8];
        int j = i - 1;
        ai[0] = j;
        int k = i + 1;
        ai[1] = k;
        ai[2] = i - Dungeon.level.width();
        ai[3] = i + Dungeon.level.width();
        ai[4] = j - Dungeon.level.width();
        ai[5] = j + Dungeon.level.width();
        ai[6] = k - Dungeon.level.width();
        ai[7] = k + Dungeon.level.width();
        i = ai[Random.Int(ai.length)];
        if(Dungeon.level.heroFOV[i])
        {
            CellEmitter.get(i).start(Speck.factory(8), 0.07F, 10);
            Camera.main.shake(3F, 0.7F);
            Sample.INSTANCE.play("sound/snd_rocks.mp3");
            if(Dungeon.level.water[i])
                GameScene.ripple(i);
            else
            if(Dungeon.level.map[i] == 1)
            {
                Level.set(i, 20);
                GameScene.updateMap(i);
            }
        }
        Char char1 = Actor.findChar(i);
        if(char1 != null && char1 != this)
            Buff.prolong( char1, Paralysis.class, 2 );
    }

    public void notice()
    {
        super.notice();
        BossHealthBar.assignBoss(this);
        yell(Messages.get(this, "notice", new Object[0]));
    }

    public void restoreFromBundle(Bundle bundle)
    {
        super.restoreFromBundle(bundle);
        BossHealthBar.assignBoss(this);
    }

    public void split(int i, Char char1)
    {
        ArrayList arraylist = new ArrayList();
        for(int j = 0; j < PathFinder.NEIGHBOURS8.length; j++)
        {
            int k = PathFinder.NEIGHBOURS8[j] + i;
            if(Actor.findChar(k) == null && (Dungeon.level.passable[k] || Dungeon.level.avoid[k]))
                arraylist.add(Integer.valueOf(k));
        }

        if(arraylist.size() > 0)
        {
            DM75 dm75 = new DM75();
            dm75.pos = ((Integer)Random.element(arraylist)).intValue();
            GameScene.add(dm75);
            Actor.addDelayed(new Pushing(dm75, i, dm75.pos), -1F);
        }
        Iterator iterator = Dungeon.level.mobs.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            Mob mob = (Mob)iterator.next();
            if(mob instanceof DM150)
                mob.aggro(char1);
        } while(true);
    }
}
