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

import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class Bestiary {

	public static ArrayList<Class<? extends Mob>> getMobRotation( int depth ){
		ArrayList<Class<? extends Mob>> mobs = standardMobRotation( depth );
		addRareMobs(depth, mobs);
		swapMobAlts(mobs);
		Random.shuffle(mobs);
		return mobs;
	}

	//returns a rotation of standard mobs, unshuffled.
	private static ArrayList<Class<? extends Mob>> standardMobRotation(int i) {
		switch (i) {
			case 1:
				//3x rat, 1x snake
				return new ArrayList<>(Arrays.asList(
						Rat.class, Rat.class,
						Snake.class,
						Snake.class,
						Snake.class));
			case 2:
				return new ArrayList<>(Arrays.asList(Rat.class,
						Rat.class, Rat.class, Gnoll.class, Gnoll.class,
						Gnoll.class, OGPDLLS.class, OGPDNQHZ.class,
						OGPDZSLS.class, Rat.class, Rat.class));
			case 3:
				return new ArrayList<>(Arrays.asList(Rat.class,
						Snake.class, Gnoll.class, Gnoll.class,
						Gnoll.class, Gnoll.class, Crab.class, Swarm.
								class, OGPDLLS.class, OGPDNQHZ.class,
						OGPDZSLS.class, OGPDLLS.class,
						OGPDZSLS.class));
			case 4:
			case 5:
				return new ArrayList<>(Arrays.asList(Rat.class,
						Gnoll.class, Gnoll.
								class, Crab.class,
						Crab.class, Crab.class,
						Swarm.class, OGPDLLS.class,
						OGPDNQHZ.class, OGPDZSLS.class,
						OGPDLLS.class, Snake.class));
			case 6:case 7:case 8: case 9:
				return new ArrayList<>(Arrays.asList(Slime.class,
						Snake.class,
						OGPDZSLS.class,
						OGPDZSLS.class,
						OGPDLLS.class,Snake.class,
						Gnoll.class, Gnoll.class,Slime.class,Slime.class));
			case 11:
				return new ArrayList<>(Arrays.asList(Skeleton.class,
						KagenoNusujin.class, BlackHost.class,
						Thief.class, Guard.class));
			case 12:
			case 13:
				return new ArrayList<>(Arrays.asList(Skeleton.class,
						KagenoNusujin.class, Skeleton.class,
						Thief.class, Shaman.random(),
						Shaman.random(), Guard.class, SRPDHBLR.class, BlackHost.class));
			case 14:case 15:
				return new ArrayList<>(Arrays.asList(Skeleton.class, Skeleton.class, Skeleton.class,
						Thief.class,
						DM100.class,
						Guard.class,DM100.class,DM100.class,DM100.class,DM100.class,
						DM100.class));

			case 17: case 18:case 19:
				//1x skeleton, 1x thief, 2x DM-100, 2x guard, 2x necromancer
				return new ArrayList<>(Arrays.asList(Skeleton.class,
						Thief.class,
						DM100.class, DM100.class,
						Guard.class, Guard.class,
						Necromancer.class, Necromancer.class,
						Guard.class,DM201.class,DM100.class,
						DM100.class,DM200.class,
						DM100.class,SRPDHBLR.class,SRPDHBLR.class));

			case 20:case 21:case 22:case 23:case 24:case 25:
				return new ArrayList<>(Arrays.asList(Bat.class,
						FireGhost.class, Brute.class, Brute.class,
						Shaman.random(), Spinner.class, MolotovHuntsman.class,
						BlackHost.class, Spinner.class, FlameB01.class,
						FlameB01.class, SRPDHBLR.class, SRPDHBLR.class));
			case 26:case 27:case 28:case 29:
				return new ArrayList<>(Arrays.asList(Bat.class,
						FireGhost.class, Brute.class, Brute.class,
						Shaman.random(), Spinner.class, MolotovHuntsman.class,
						BlackHost.class, Spinner.class, FlameB01.class,
						FlameB01.class, SRPDHBLR.class, SRPDHBLR.class, Rat.class, Rat.class));
			case 30:
				//1x bat, 1x brute, 2x shaman, 2x spinner, 2x DM-300
				return new ArrayList<>(Arrays.asList(
						Bat.class,
						Brute.class,
						Shaman.random(), Shaman.random(),
						Spinner.class, Spinner.class,
						DM200.class, DM200.class,
						Brute.class,
						Shaman.random(), Shaman.random(),
						Spinner.class, Spinner.class,
						DM201.class, DM201.class));

			// City
			case 31:
				//5x elemental, 5x warlock, 1x monk, 2x silvercrab
				return new ArrayList<>(Arrays.asList(
						Elemental.random(), Elemental.random(), Elemental.random(), Elemental.random(),
						Monk.class,
						Shaman.random()));
			case 32:
				//2x elemental, 2x warlock, 2x monk, 1x silvercrab
				return new ArrayList<>(Arrays.asList(
						Elemental.random(), Elemental.random(), Elemental.random(),
						Monk.class, Monk.class,
						Shaman.random()));
			case 33:
				//1x elemental, 1x warlock, 2x monk, 1x golem
				return new ArrayList<>(Arrays.asList(
						Elemental.random(),
						Shaman.random(),
						Monk.class, Monk.class, Monk.class));
			case 34:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Monk.class,
						Shaman.random(), Shaman.random(),
						Golem.class, Golem.class));
			case 35:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Elemental.random(),
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class, Golem.class, Golem.class));
			case 36:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Ghoul.class,
						Elemental.random(),
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class));
			case 37:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Ghoul.class,
						Elemental.random(), Elemental.random(),
						Warlock.class,
						Monk.class));
			case 38:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Elemental.random(),
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class, Golem.class, Golem.class));
			case 39:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Elemental.random(),
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class, Golem.class, Golem.class));
			case 40:
				//1x elemental, 1x warlock, 2x monk, 3x golem
				return new ArrayList<>(Arrays.asList(
						Elemental.random(),
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class, Golem.class, Golem.class,
						Warlock.class, Warlock.class,
						Monk.class, Monk.class,
						Golem.class, Golem.class, Golem.class,Elemental.random()));

			case 42:case 41:
				//3x succubus, 3x evil eye
				return new ArrayList<>(Arrays.asList(
						Succubus.class, Succubus.class, Succubus.class,
						Succubus.class, Succubus.class,
						Eye.class));
			case 43:
				//2x succubus, 4x evil eye, 2x scorpio
				return new ArrayList<>(Arrays.asList(
						Succubus.class, Succubus.class,
						Scorpio.class, Scorpio.class, Scorpio.class));
			case 44:
			case 45:
			case 46	:
			case 47	:
			case 48	:
			case 49:
				//1x: succubus, 2x evil eye, 3x scorpio
				return new ArrayList<>(Arrays.asList(
						Succubus.class,
						Eye.class, Eye.class,
						Scorpio.class, Eye.class, Eye.class,Succubus.class, Succubus.class,
						Scorpio.class, Scorpio.class, Scorpio.class));
			//前半段决战
			case 50:
				//1x succubus, 2x evil eye, 3x scorpio
				return new ArrayList<>(Arrays.asList(
						Succubus.class,
						Eye.class, Eye.class,
						Scorpio.class, Eye.class, Eye.class,Succubus.class, Succubus.class,
						Scorpio.class, Scorpio.class, Scorpio.class,Elemental.random(),
						Shaman.random(),
						Monk.class, Monk.class, Monk.class,Rat.class,
						Rat.class, Rat.class, Gnoll.class, Gnoll.class,
						Gnoll.class, OGPDLLS.class, OGPDNQHZ.class,
						OGPDZSLS.class, Rat.class, Rat.class,
						FireGhost.class, Brute.class, Brute.class,
						Shaman.random(), Spinner.class, MolotovHuntsman.class,
						BlackHost.class, Spinner.class, FlameB01.class,
						FlameB01.class, SRPDHBLR.class, SRPDHBLR.class));
			default:
				return new ArrayList<>(Arrays.asList(Rat.class, Rat.class,
						Rat.class,
						Rat.class, Rat.class, Rat.class,
						Rat.class, Rat.class, Rat.class,
						Rat.class));
		}
	}

	//has a chance to add a rarely spawned mobs to the rotation
	public static void addRareMobs( int depth, ArrayList<Class<?extends Mob>> rotation ){

		switch (depth){

			// Sewers
			default:
				return;
			case 9:
				if (Random.Float() < 0.025f) rotation.add(Thief.class);
				return;

			// Prison
			case 19:
				if (Random.Float() < 0.025f) rotation.add(Bat.class);
				return;

			// Caves
			case 29:
				if (Random.Float() < 0.025f) rotation.add(Ghoul.class);
				return;

			// City
			case 39:
				if (Random.Float() < 0.025f) rotation.add(Succubus.class);
				return;
		}
	}

	//switches out regular mobs for their alt versions when appropriate
	private static void swapMobAlts(ArrayList<Class<?extends Mob>> rotation){
		for (int i = 0; i < rotation.size(); i++){
			if (Random.Int( 50 ) == 0) {
				Class<? extends Mob> cl = rotation.get(i);
				if (cl == Rat.class) {
					cl = Albino.class;
				} else if (cl == Slime.class) {
					cl = CausticSlime.class;
				} else if (cl == Thief.class) {
					cl = Bandit.class;
				} else if (cl == Brute.class) {
					cl = ArmoredBrute.class;
				} else if (cl == DM200.class) {
					cl = DM201.class;
				} else if (cl == Monk.class) {
					cl = Senior.class;
				} else if (cl == Scorpio.class) {
					cl = Acidic.class;
				}
				rotation.set(i, cl);
			}
		}
	}
}
