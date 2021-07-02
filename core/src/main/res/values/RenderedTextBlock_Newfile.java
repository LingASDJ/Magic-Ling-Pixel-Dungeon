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

package com.shatteredpixel.shatteredpixeldungeon.ui;

import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.watabou.noosa.Game;
import com.watabou.noosa.RenderedText;
import com.watabou.noosa.ui.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RenderedTextBlock extends Component {

	private int maxWidth = Integer.MAX_VALUE;
	public int nLines;
	protected boolean multiline = false;
	private String text;
	public ArrayList<RenderedText> words = new ArrayList<>();
	private static final RenderedText SPACE = new RenderedText();
	private static final RenderedText NEWLINE = new RenderedText();
	public static final int LEFT_ALIGN = 1;
	public static final int CENTER_ALIGN = 2;
	public static final int RIGHT_ALIGN = 3;
	private int alignment = LEFT_ALIGN;
	private int size;
	private float zoom;
	private int color = -1;
	private List<String> tokens;
	private static final String color0 = "_";
	private static final String color1 = "§";
	private static final String color2 = "$";
	private static final String color3 = "¢";
	private int hightlightColor = Window.TITLE_COLOR;
	private boolean highlightingEnabled = true;

	private boolean chinese = false;

	public RenderedTextBlock(int size){
		this.size = size;
	}

	public RenderedTextBlock(String text, int size){
		this.size = size;
		text(text);
	}

	public void text(String text){
		this.text = text;

		if (text != null && !text.equals("")) {
			tokens = Arrays.asList(Game.platform.splitforTextBlock(text, multiline));

		}else if (chinese){
				tokens = Arrays.asList(text.split(""));
			} else {
				tokens = Arrays.asList(text.split("(?<= )|(?= )|(?<=\n)|(?=\n)"));
			}
			build();
		}


	public void text(String text, int maxWidth){
		this.maxWidth = maxWidth;
		multiline = true;
		text(text);
	}

	public String text(){
		return text;
	}

	public void maxWidth(int maxWidth){
		if (this.maxWidth != maxWidth){
			this.maxWidth = maxWidth;
			multiline = true;
			layout();
		}
	}

	public int maxWidth(){
		return maxWidth;
	}


	public synchronized void resetColor(){
		this.color = -1;
		for (RenderedText word : words) {
			if (word != null) word.resetColor();
		}
	}

	public synchronized void align(int align){
		alignment = align;
		layout();
	}

	public synchronized void alpha(float value){
		for (RenderedText word : words) {
			if (word != null) word.alpha( value );
		}
	}

	private synchronized void build(){
		if (tokens == null) return;

		clear();
		words = new ArrayList<>();
		boolean highlighting = false;
		for (String str : tokens){
			if (str.equals(color0)){
				highlighting = !highlighting;
			} else if (str.equals(NEWLINE)){
				words.add(null);
			} else if (!str.equals(SPACE)){
				RenderedText word;
				if (str.startsWith(color0) && str.endsWith(color0)){
					word = new RenderedText(str.substring(1, str.length()-1), size);
					word.hardlight(0xFFFF44);
				} else if(str.startsWith(color1) && str.endsWith(color1)){
					word = new RenderedText(str.substring(1, str.length()-1), size);
					word.hardlight(0x00FF00);
				} else if(str.startsWith(color2) && str.endsWith(color2)){
					word = new RenderedText(str.substring(1, str.length()-1), size);
					word.hardlight(0xFF3300);
				} else if(str.startsWith(color3) && str.endsWith(color3)){
					word = new RenderedText(str.substring(1, str.length()-1), size);
					word.hardlight(0x44FF98);
				} else {
					if (str.startsWith(color0)){
						highlighting = !highlighting;
						word = new RenderedText(str.substring(1, str.length()), size);
					} else if (str.endsWith(color0)) {
						word = new RenderedText(str.substring(0, str.length()-1), size);
					} else {
						word = new RenderedText(str, size);
					}
					if (highlighting) word.hardlight(0xFFFF44);
					else if (color != -1) word.hardlight(color);

					if (str.endsWith(color0)) highlighting = !highlighting;
				}
				word.scale.set(zoom);
				words.add(word);
				add(word);

				if (height < word.height()) height = word.height();

			}
		}
		layout();
	}

	public synchronized void zoom(float zoom){
		this.zoom = zoom;
		for (RenderedText word : words) {
			if (word != null) word.scale.set(zoom);
		}
	}

	public synchronized void hardlight(int color){
		this.color = color;
		for (RenderedText word : words) {
			if (word != null) word.hardlight( color );
		}
	}

	public synchronized void invert(){
		if (words != null) {
			for (RenderedText word : words) {
				if (word != null) {
					word.ra = 0.77f;
					word.ga = 0.73f;
					word.ba = 0.62f;
					word.rm = -0.77f;
					word.gm = -0.73f;
					word.bm = -0.62f;
				}
			}
		}
	}

	public synchronized void setHightlighting(boolean enabled){
		setHightlighting(enabled, Window.TITLE_COLOR);
	}

	public synchronized void setHightlighting(boolean enabled, int color){
		if (enabled != highlightingEnabled || color != hightlightColor) {
			hightlightColor = color;
			highlightingEnabled = enabled;

			build();
		}
	}

	@Override
	protected synchronized void layout() {
		super.layout();
		float x = this.x;
		float y = this.y;
		float height = 0;
		nLines = 1;

		ArrayList<ArrayList<RenderedText>> lines = new ArrayList<>();
		ArrayList<RenderedText> curLine = new ArrayList<>();
		lines.add(curLine);

		width = 0;
		for (RenderedText word : words){
			if (word == SPACE){
				x += 1.5f;
			} else if (word == NEWLINE) {
				//newline
				y += height+2f;
				x = this.x;
				nLines++;
				curLine = new ArrayList<>();
				lines.add(curLine);
			} else {
				if (word.height() > height) height = word.height();

				if ((x - this.x) + word.width() > maxWidth && !curLine.isEmpty()){
					y += height+2f;
					x = this.x;
					nLines++;
					curLine = new ArrayList<>();
					lines.add(curLine);
				}

				word.x = x;
				word.y = y;
				PixelScene.align(word);
				x += word.width();
				curLine.add(word);

				if ((x - this.x) > width) width = (x - this.x);

				//TODO spacing currently doesn't factor in halfwidth and fullwidth characters
				//(e.g. Ideographic full stop)
				x -= 0.5f;

			}
		}
		this.height = (y - this.y) + height;

		if (alignment != LEFT_ALIGN){
			for (ArrayList<RenderedText> line : lines){
				if (line.size() == 0) continue;
				float lineWidth = line.get(line.size()-1).width() + line.get(line.size()-1).x - this.x;
				if (alignment == CENTER_ALIGN){
					for (RenderedText text : line){
						text.x += (width() - lineWidth)/2f;
						PixelScene.align(text);
					}
				} else if (alignment == RIGHT_ALIGN) {
					for (RenderedText text : line){
						text.x += width() - lineWidth;
						PixelScene.align(text);
					}
				}
			}
		}
	}
}