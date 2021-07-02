//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.NormalNpc;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SlylSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.Game;
import com.watabou.utils.Callback;

public class Slyl extends NormalNpc {
    public Slyl() {
        this.spriteClass = SlylSprite.class;

        Game.runOnRenderThread(new Callback() {
            @Override
            public void call() {
                {
                    GLog.w( Messages.get(this, "warning") );
                }
                //GameScene.show( something );
            }

            private void add(String chat) {
            }
        });
        }
    }
