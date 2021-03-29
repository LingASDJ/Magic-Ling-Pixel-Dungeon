package com.shatteredpixel.shatteredpixeldungeon;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LockedFloor;
import com.watabou.noosa.audio.Music;

public class BGMPlayer {
    public static void playBGMWithDepth() {
        if (Dungeon.hero != null) {
            if (Dungeon.hero.buff(LockedFloor.class) != null) {
                playBoss();
                return;
            }
        }
        int d = Dungeon.depth;
        if (d == 0 ) {
            Music.INSTANCE.play(Assets.BGM_0, true);
        } else if (d > 0 && d <= 10) {
            Music.INSTANCE.play(Assets.BGM_1, true);
        } else if (d > 10 && d <= 20) {
            Music.INSTANCE.play(Assets.BGM_2, true);
        } else if (d > 20 && d <= 30) {
            Music.INSTANCE.play(Assets.BGM_3, true);
        } else if (d > 30 && d <= 40) {
            Music.INSTANCE.play(Assets.BGM_4, true);
        } else if (d > 40 && d <= 51) {
            Music.INSTANCE.play(Assets.BGM_5, true);
        } else {
            //default
            Music.INSTANCE.play(Assets.Music.GAME, true);
        }
    }

    public static void playBoss() {
        int t = Dungeon.depth;
        if (t == 10) {
            Music.INSTANCE.play(Assets.BGM_BOSSA, true);
        } else if (t == 20) {
            Music.INSTANCE.play(Assets.BGM_BOSSB, true);
        } else if (t == 30) {
            Music.INSTANCE.play(Assets.BGM_BOSSC, true);
        } else if (t == 40) {
            Music.INSTANCE.play(Assets.BGM_BOSSD, true);
        } else if (t == 50) {
            Music.INSTANCE.play(Assets.BGM_BOSSE, true);
        }
    }
}
