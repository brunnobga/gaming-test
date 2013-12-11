package com.tetris;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.tetris.Tetris;


public class AndroidTetris extends AndroidApplication {
	public void onCreate(android.os.Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		initialize(new Tetris(), true);
		//initialize(new InputDemo3(), false);
	}

}
