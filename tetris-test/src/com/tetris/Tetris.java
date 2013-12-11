package com.tetris;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class Tetris implements ApplicationListener, GestureListener {
	private final float CAMERA_W = 288f;
	private final float CAMERA_H = 512f;
	private final float X_ORIGIN = -CAMERA_W/2;
	private final float Y_ORIGIN = -CAMERA_H/2;
	private final int TEXTURE_SIZE = 32;
	
	private String message;
	private OrthographicCamera camera;
	private BitmapFont font;
	private Texture texture;
	private SpriteBatch batch;
	private TextureRegion[] colors;
	private int[][] tiles;
	private int lastX, lastY;

	@Override
	public void create() {
		message = "";
		camera = new OrthographicCamera(CAMERA_W, CAMERA_H);
		batch = new SpriteBatch();
		font = new BitmapFont();
		texture = new Texture(Gdx.files.internal("block.png"));
		colors = TextureRegion.split(texture, TEXTURE_SIZE, TEXTURE_SIZE)[0];
		
		Random r = new Random();
		tiles = new int[9][9];
		for(int i = 0, j = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				tiles[i][j] = r.nextInt(5);
			}
		}
		
		GestureDetector gd = new GestureDetector(this);
		Gdx.input.setInputProcessor(gd);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i = 0, j = 0; i < 9; i++){
			for(j = 0; j < 9; j++){
				batch.draw(colors[tiles[i][j]], X_ORIGIN + i * TEXTURE_SIZE, Y_ORIGIN + j * TEXTURE_SIZE);
			}
		}
		message = String.format("FPS: %s Touch: %s, %s",Gdx.graphics.getFramesPerSecond(), lastX, lastY);
		font.drawMultiLine(batch, message, -CAMERA_W/2, CAMERA_H/2);
		batch.end();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		lastX = (int) x;
		lastY = (int) y;
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
