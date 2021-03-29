//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.NormalNpc;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SlylSprite;

import java.util.ArrayList;

public class Slyl extends NormalNpc {
    public Slyl() {
        this.spriteClass = SlylSprite.class;
        this.chat = new ArrayList<String>() {
            {
                this.add(Messages.get(Slyl.class, "chat", new Object[0]));
                this.add(Messages.get(Slyl.class, "chat1", new Object[0]));
                this.add(Messages.get(Slyl.class, "chat2", new Object[0]));
            }
        };
    }
}
