package com.shatteredpixel.shatteredpixeldungeon.scenes;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.GamesInProgress;
import com.shatteredpixel.shatteredpixeldungeon.ShatteredPixelDungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.BannerSprites;
import com.shatteredpixel.shatteredpixeldungeon.effects.Fireball;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.Archs;
import com.shatteredpixel.shatteredpixeldungeon.ui.ChangesButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.ExitButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.LanguageButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.PrefsButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.watabou.glwrap.Blending;
import com.watabou.noosa.BitmapText;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.ui.Button;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.GameMath;

public class TitleScene extends PixelScene {

	private void placeTorch( float x, float y ) {
		Fireball fb = new Fireball();
		fb.setPos( x, y );
		add( fb );
	}

	@Override
	public void create() {

		super.create();

		Music.INSTANCE.play( Assets.Music.THEME, true );

		uiCamera.visible = false;

		int w = Camera.main.width;
		int h = Camera.main.height;

		Archs archs = new Archs();
		archs.setSize( w, h );
		add( archs );

		float topRegion = Math.max(95f, h*0.45f);

		final Image swordLeft = new Image( BannerSprites.get( BannerSprites.Type.SWORD ) ) {
			private float preCurTime = 0;
			private float preTime = 0.9f;
			private float curTime = 0;
			private float time = 0.8f;
			@Override
			public void update() {
				super.update();
				this.origin.set( this.width / 2, this.height / 2 );
				this.x = - this.width + curTime/time * (Camera.main.width / 2f + this.width / 2f);
				this.angle = 90 - curTime/time*225;
				am = curTime*curTime*curTime/(time*time*time);

				if (preCurTime < preTime) {
					preCurTime += Game.elapsed;
					return;
				}
				if (curTime < time) {
					curTime += Game.elapsed;
					if (curTime >= time) Camera.main.shake( GameMath.gate( 1, 2, 5), 0.3f );
				}
			}
		};
		swordLeft.x = 0;
		if (PixelScene.landscape())
			swordLeft.y = (topRegion - 37) / 2f;
		else
			swordLeft.y = 16 + (topRegion - 53) / 2f;
		add( swordLeft );

		final Image swordRight = new Image( BannerSprites.get( BannerSprites.Type.SWORD ) ) {
			private float preCurTime = 0;
			private float preTime = 0.9f;
			private float curTime = 0;
			private float time = 0.8f;
			@Override
			public void update() {
				super.update();
				this.origin.set( this.width / 2, this.height / 2 );
				this.x = Camera.main.width - curTime/time * (Camera.main.width / 2f + this.width / 2f);
				this.angle = 90 + curTime/time*225;
				am = curTime*curTime*curTime/(time*time*time);

				if (preCurTime < preTime) {
					preCurTime += Game.elapsed;
					return;
				}
				if (curTime < time) curTime += Game.elapsed;
			}
		};
		swordRight.x = 0;
		if (PixelScene.landscape())
			swordRight.y = (topRegion - 37) / 2f;
		else
			swordRight.y = 16 + (topRegion - 53) / 2f;
		add( swordRight );

		final Image title = new Image(BannerSprites.get( BannerSprites.Type.PIXEL_DUNGEON )){
			private float time = 0;
			@Override
			public void update() {
				super.update();
				int h = Camera.main.height;
				float topRegion = Math.max(95f, h*0.45f);
				if (PixelScene.landscape())
					y = (topRegion - height()) / 2f;
				else
					y = 16 + (topRegion - height() - 16) / 2f;
				y = y + (3 * Math.max(0f, (float)Math.sin( time += Game.elapsed )));
				if (time >= 1f*Math.PI) time = 0;
			}
		};
		add( title );

		title.x = (w - title.width()) / 2f;
		if (PixelScene.landscape())
			title.y = (topRegion - title.height()) / 2f;
		else
			title.y = 16 + (topRegion - title.height() - 16) / 2f;

		align(title);

		placeTorch(title.x + 22, title.y + 46);
		placeTorch(title.x + title.width - 22, title.y + 46);

		Image signs = new Image( BannerSprites.get( BannerSprites.Type.PIXEL_DUNGEON_SIGNS ) ) {
			private float time = 0;
			@Override
			public void update() {
				super.update();
				am = Math.max(0f, (float)Math.sin( time += Game.elapsed ));
				if (time >= 1.5f*Math.PI) time = 0;
			}
			@Override
			public void draw() {
				Blending.setLightMode();
				super.draw();
				Blending.setNormalMode();
			}
		};
		signs.x = title.x + (title.width() - signs.width())/2f;
		signs.y = title.y;
		add( signs );

		DashboardItem btnBadges = new DashboardItem( Messages.get(this, "badges"), 3 ) {
			@Override
			protected void onClick() {
				ShatteredPixelDungeon.switchNoFade( BadgesScene.class );
			}
		};
		add(btnBadges);

		DashboardItem btnAbout = new DashboardItem( Messages.get(this, "about"), 1 ) {
			@Override
			protected void onClick() {
				ShatteredPixelDungeon.switchNoFade( AboutScene.class );
			}
		};
		add( btnAbout );

		DashboardItem btnPlay = new DashboardItem( Messages.get(this, "play"), 0 ) {
			@Override
			protected void onClick() {
				if (GamesInProgress.checkAll().size() == 0){
					GamesInProgress.selectedClass = null;
					GamesInProgress.curSlot = 1;
					ShatteredPixelDungeon.switchScene(HeroSelectScene.class);
				} else {
					ShatteredPixelDungeon.switchNoFade( StartScene.class );
				}
			}

			@Override
			protected boolean onLongClick() {
				//making it easier to start runs quickly while debugging
				if (DeviceCompat.isDebug()) {
					GamesInProgress.selectedClass = null;
					GamesInProgress.curSlot = 1;
					ShatteredPixelDungeon.switchScene(HeroSelectScene.class);
					return true;
				}
				return super.onLongClick();
			}
		};
		add( btnPlay );

		DashboardItem btnRankings = new DashboardItem( Messages.get(this, "rankings"), 2 ) {
			@Override
			protected void onClick() {
				ShatteredPixelDungeon.switchNoFade( RankingsScene.class );
			}
		};
		add( btnRankings );

		if (PixelScene.landscape()) {
			btnRankings     .setPos( w / 2 - btnRankings.width(), topRegion );
			btnBadges       .setPos( w / 2, topRegion );
			btnPlay         .setPos( btnRankings.left() - btnPlay.width(), topRegion );
			btnAbout        .setPos( btnBadges.right(), topRegion );
		} else {
			btnPlay.setPos( w / 2 - btnPlay.width(), topRegion );
			btnRankings.setPos( w / 2, btnPlay.top() );
			btnBadges.setPos( w / 2 - btnBadges.width(), btnPlay.top() + DashboardItem.SIZE );
			btnAbout.setPos( w / 2, btnBadges.top() );
		}

		BitmapText version = new BitmapText( "v " + Game.version + "", pixelFont);
		version.measure();
		version.hardlight( 0x888888 );
		version.x = w - version.width();
		version.y = h - version.height();
		add( version );

		Button changes = new ChangesButton();
		changes.setPos( w-changes.width(), h - version.height() - changes.height());
		add( changes );

		int pos = 0;

		PrefsButton btnPrefs = new PrefsButton();
		btnPrefs.setRect( pos, 0, 16, 16 );
		add( btnPrefs );

		pos += btnPrefs.width();

		LanguageButton btnLang = new LanguageButton();
		btnLang.setRect(pos, 0, 14, 16);
		add( btnLang );

		ExitButton btnExit = new ExitButton();
		btnExit.setPos( w - btnExit.width(), 0 );
		add( btnExit );

		fadeIn();
	}

	private static class DashboardItem extends Button {

		public static final float SIZE	= 48;

		private static final int IMAGE_SIZE	= 32;

		private Image image;
		private RenderedTextBlock label;

		public DashboardItem( String text, int index ) {
			super();

			image.frame( image.texture.uvRect( index * IMAGE_SIZE, 0, (index + 1) * IMAGE_SIZE, IMAGE_SIZE ) );
			this.label.text( text );

			setSize( SIZE, SIZE );
		}

		@Override
		protected void createChildren() {
			super.createChildren();

			image = new Image(Assets.Interfaces.DASHBOARD );
			add( image );

			label = renderTextBlock( 9 );
			label.nLines=1;
			add( label );
		}

		@Override
		protected void layout() {
			super.layout();

			image.x = x + (width - image.width()) / 2;
			image.y = y;
			align(image);


			label.setPos(x + (width - label.width()) / 2, image.y + image.height() +2);
			align(label);
		}

		@Override
		protected void onPointerDown() {
			image.brightness( 1.5f );
			Sample.INSTANCE.play( Assets.Sounds.CLICK, 1, 1, 0.8f );
		}

		@Override
		protected void onPointerUp() {
			image.resetColor();
		}
	}
}