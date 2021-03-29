//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.sprites.FireGhostSprite;
import com.watabou.utils.Random;

public class FireGhost extends Mob {
    public FireGhost() {
        this.spriteClass = FireGhostSprite.class;
        this.HT = 35;
        this.HP = 35;
        this.defenseSkill = 19;
        this.EXP = 6;
        this.maxLvl = 16;
        this.flying = true;
        this.loot = new PotionOfLiquidFlame();
        this.lootChance = 0.1F;
        this.properties.add(Property.FIERY);
    }

    public int attackSkill(Char var1) {
        return 18;
    }

    public int damageRoll() {
        return Random.NormalIntRange(6, 19);
    }

    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

}
