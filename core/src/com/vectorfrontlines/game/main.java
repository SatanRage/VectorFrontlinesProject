package com.vectorfrontlines.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class main extends ApplicationAdapter {
	LogoSplash logoSplash;

	@Override
	public void create () {
		//object initialisation
		logoSplash = new LogoSplash();
	}

	@Override
	public void render () {

		//object configurations
		//game logic
		//animation configuration
		//animation logic
		logoSplash.render();
	}

	@Override
	public void dispose () {
		//states savings
		//object cleaning
		logoSplash.dispose();
	}

	@Override
	public void resize(int width, int height) {
		logoSplash.update(width,height);
	}
}

