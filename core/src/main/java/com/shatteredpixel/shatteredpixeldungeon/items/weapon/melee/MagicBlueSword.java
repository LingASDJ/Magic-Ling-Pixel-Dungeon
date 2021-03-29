package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class MagicBlueSword extends MeleeWeapon {
    public MagicBlueSword() {
        this.image = ItemSpriteSheet.MagicBlueSword;
        this.tier = 3;
    }

    public int max(int i) {
        int round =
                (Math.round(((float) (this.tier + 1)) * 0.5f) * i) + Math.round(((float) (this.tier + 1)) * 2.0f);
        this.DLY = 0.8f;
        return round;
    }

    public int min(int i) {
        return (Math.round(((float) (this.tier + 1)) * 0.0f) * i) + Math.round(((float) (this.tier + 3)) * 1.34f);
    }

    @Override
    public int price() {
        return quantity * 800;
    }
}

