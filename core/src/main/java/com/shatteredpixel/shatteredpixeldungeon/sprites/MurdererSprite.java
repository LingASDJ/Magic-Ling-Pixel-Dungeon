//
// Decompiled by Jadx - 940ms
//
package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.watabou.noosa.MovieClip;
import com.watabou.noosa.TextureFilm;

public class MurdererSprite extends MobSprite {
    public MurdererSprite() {
        texture("sprites/thief2.png");
        TextureFilm textureFilm = new TextureFilm(this.texture, 12, 13);
        this.idle = new MovieClip.Animation(1, true);
        this.idle.frames(textureFilm, new Object[]{0, 0, 0, 1, 0, 0, 0, 0, 1});
        this.run = new MovieClip.Animation(15, true);
        this.run.frames(textureFilm, new Object[]{0, 0, 2, 3, 3, 4});
        this.die = new MovieClip.Animation(10, false);
        this.die.frames(textureFilm, new Object[]{5, 6, 7, 8, 9});
        this.attack = new MovieClip.Animation(12, false);
        this.attack.frames(textureFilm, new Object[]{10, 11, 12, 0});
        idle();
    }
}
