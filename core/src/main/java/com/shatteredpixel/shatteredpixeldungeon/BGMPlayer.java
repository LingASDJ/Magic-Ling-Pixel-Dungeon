package com.shatteredpixel.shatteredpixeldungeon;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LockedFloor;
import com.watabou.noosa.audio.Music;
import com.watabou.utils.Random;

public class BGMPlayer {
    public static void playBGMWithDepth() {
        if (Dungeon.hero != null) {
            if (Dungeon.hero.buff(LockedFloor.class) != null) {
                playBoss();
                return;
            }
        }
        int d = Dungeon.depth;
        if (d == -1) {
            Music.INSTANCE.play(Assets.BGM_O, true);
        }else if (d == 0) {
            Music.INSTANCE.play(Assets.BGM_0, true);
        } else if (d > 0 && d <= 5) {
            Music.INSTANCE.play(Assets.BGM_1, true);
        } else if (d > 5 && d <= 10) {
            Music.INSTANCE.play(Assets.BGM_2, true);
        } else if (d > 10 && d <= 15) {
            Music.INSTANCE.play(Assets.BGM_3, true);
        } else if (d > 15 && d <= 20) {
            Music.INSTANCE.play(Assets.BGM_4, true);
        } else if (d > 20 && d <= 26) {
            Music.INSTANCE.play(Assets.BGM_5, true);
        } else if
            //default
        (Random.Int(0, 5) > 3) {
            Music.INSTANCE.play(Assets.Music.THEME, true);
        } else {
            Music.INSTANCE.play(Assets.Music.GAME, true);
        }
    }

    public static void playBoss() {
        int t = Dungeon.depth;
        if (t == 5) {
            Music.INSTANCE.play(Assets.BGM_BOSSA, true);
        } else if (t == 10) {
            Music.INSTANCE.play(Assets.BGM_BOSSB, true);
        } else if (t == 15) {
            Music.INSTANCE.play(Assets.BGM_BOSSC, true);
        } else if (t == 20) {
            Music.INSTANCE.play(Assets.BGM_BOSSD, true);
        } else if (t == 25) {
            Music.INSTANCE.play(Assets.BGM_BOSSE, true);
        }
    }
}
