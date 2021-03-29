//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shatteredpixel.shatteredpixeldungeon.levels;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Goo;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.SlimeKing;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;


public class SLMKingLevel extends Level {
    private static final int SIZE = 5;
    private static final int[] pre_map = new int[]{64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,
            64,64,64,64,64,64,
            64,98,4,4,4,4,4,20,4,4,17,4,4,20,4,4,4,4,4,98,64,
            64,98,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,98,64,
            64,64,64,64,64,64,64,64,64,64,82,64,64,64,64,64,64,64,64,64,64,
            64,66,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,66,64,
            64,66,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,66,64,
            64,66,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,66,64,
            64,66,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,66,64,
            64,66,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,66,64,
            64,66,4,1,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,66,64,
            64,66,4,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,4,66,64,
            64,66,4,1,4,1,4,4,4,4,16,4,4,4,4,4,4,1,4,66,64,
            64,66,4,1,4,1,4,1,1,1,1,1,1,1,1,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,4,4,4,4,4,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,1,1,1,1,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,1,4,4,4,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,1,1,1,4,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,4,4,4,4,4,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,1,1,1,1,1,1,1,4,1,4,1,4,66,64,
            64,66,4,1,4,1,4,4,4,4,4,4,4,4,4,1,4,1,4,66,64,
            64,66,4,1,4,1,1,1,1,1,1,1,1,1,1,1,4,1,4,66,64,
            64,66,4,1,4,4,4,4,4,4,4,4,4,4,4,4,4,1,4,66,64,
            64,66,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,66,64,
            64,66,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,66,64,
            64,66,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,66,64,
            64,66,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,66,64,
            64,64,64,64,64,64,64,64,64,64,80,64,64,64,64,64,64,64,64,64,64,
            64,4,4,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,4,4,64,
            64,4,4,3,3,3,3,3,3,3,4,3,3,3,3,3,3,3,4,4,64,
            64,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,64,
            64,4,4,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,4,4,64,
            64,4,4,3,3,3,3,3,3,3,4,3,3,3,3,3,3,3,4,4,64,
            64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64
    };

    private int stairs = 0;
    public void seal() {
        if (exit != 0) {

            super.seal();

            set( exit, Terrain.EMPTY_SP );
            GameScene.updateMap( exit );
            GameScene.ripple( exit );

            stairs = entrance;
            entrance = 0;
        }
    }

    public void unseal() {
        if (stairs != 0) {

            super.unseal();

            exit = stairs;
            stairs = 0;

            set( exit, Terrain.ENTRANCE );
            GameScene.updateMap( exit );

        }
    }

    public SLMKingLevel() {
        this.color1 = 5459774;
        this.color2 = 12179041;
        Dungeon.isChallenged(32);
        this.viewDistance = 6;
    }

    private int mapToTerrain(int i) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                if (i == 16) {
                    return 7;
                }

                if (i == 17) {
                    return 8;
                }

                switch(i) {
                    case -2147483644:
                        break;
                    case -2147483584:
                    case 64:
                    case 115:
                        return 4;
                    case -2147483550:
                    case 98:
                        return 25;
                    case -2147483524:
                    case 124:
                    case 140:
                        return 27;
                    case 69:
                        return 12;
                    case 80:
                        return 5;
                    case 96:
                        return 23;
                    case 120:
                        return 20;
                    case 20:
                        return 11;
                    case 82:
                        return 10;
                    default:
                        return 1;
                }
            }

            return 14;
        } else {
            return 29;
        }
    }

    protected boolean build() {
        this.setSize(21, 35);
        this.exit = this.width * 10 + 31;
        this.entrance = this.width * 10 + 11;

        for(int var1 = 0; var1 < this.map.length; ++var1) {
            this.map[var1] = this.mapToTerrain(pre_map[var1]);
        }

        return true;
    }

    protected void createItems() {
        this.drop(new PotionOfHealing(),  this.width * 1 + 7);
        this.drop(new Food(),  this.width * 1 + 13 );
    }

    public Mob createMob() {
        return null;
    }

    protected void createMobs() {
        SlimeKing a = new SlimeKing();
        a.pos = (this.width * 17) + 10;
        this.mobs.add(a);
    }

    public int randomRespawnCell() {
        return this.entrance - this.width();
    }

    public Actor respawner() {
        return null;
    }

    public String tilesTex() {
        return "environment/tiles_sewers.png";
    }

    public String waterTex() {
        return "environment/water0.png";
    }
}
