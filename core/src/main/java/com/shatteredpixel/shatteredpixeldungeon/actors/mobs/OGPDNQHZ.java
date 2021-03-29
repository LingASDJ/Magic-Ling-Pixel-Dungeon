//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.OGPDNQHZTT;

public class OGPDNQHZ extends Rat {
    public OGPDNQHZ() {
        this.spriteClass = OGPDNQHZTT.class;
        this.HT = 10;
        this.HP = 10;
        this.maxLvl = 16;
    }

    public int attackProc(Char var1, int var2) {
        return super.attackProc(var1, var2) + 5;
    }
}
