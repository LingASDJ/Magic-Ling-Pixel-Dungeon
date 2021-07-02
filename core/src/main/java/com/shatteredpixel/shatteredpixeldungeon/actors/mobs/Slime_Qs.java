/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ooze;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CausticSlimeSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.LtSprites;
import com.shatteredpixel.shatteredpixeldungeon.sprites.QsSprites;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RedSprites;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Slime_Qs extends Slime {
    {
        spriteClass = QsSprites.class;

        properties.add(Property.ACIDIC);
    }

    @Override
    public int attackProc( Char enemy, int damage ) {
        if (Random.Int( 2 ) == 0) {
            Buff.affect( enemy, Poison.class ).set( Poison.DURATION );
            enemy.sprite.burst( 0x000000, 5 );
        }

        return super.attackProc( enemy, damage );
    }

    @Override
    public void rollToDropLoot() {
        if (Dungeon.hero.lvl > maxLvl + 2) return;

        super.rollToDropLoot();

        int ofs;
        do {
            ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
        } while (!Dungeon.level.passable[pos + ofs]);
        Dungeon.level.drop( new GooBlob(), pos + ofs ).sprite.drop( pos );
    }
}
