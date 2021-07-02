package com.shatteredpixel.shatteredpixeldungeon.ui.changelist;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.ChangesScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;

import java.util.ArrayList;

public class T_Changes {
    public static void addAllChanges(ArrayList<ChangeInfo> changeInfos) {
        V0_2_XChanges(changeInfos);
    }


    public static void V0_2_XChanges(ArrayList<ChangeInfo> changeInfos) {
        ChangeInfo changes = new ChangeInfo( Messages.get( ChangesScene.class, "who"), true,
                Messages.get( ChangesScene.class, "logs"));
        changes.hardlight(Window.TITLE_COLOR);
        changeInfos.add(changes);
    }
}
