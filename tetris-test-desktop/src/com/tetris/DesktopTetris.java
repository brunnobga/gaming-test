package com.tetris;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopTetris {
	public static void main(String [] args){
		new LwjglApplication(new Tetris(), "Tetris", 480, 800, false);
	}
}
