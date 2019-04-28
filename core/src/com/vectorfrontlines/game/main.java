package com.vectorfrontlines.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class main extends ApplicationAdapter {
	menu menu_Obj;

	@Override
	public void create () {
		//object initialisation
		 menu_Obj=new menu();
	}

	@Override
	public void render () {
		menu_Obj.GameSectionsHandler();
		//object configurations
		//game logic
		//animation configuration
		//animation logic

	}

	@Override
	public void dispose () {
		//states savings
		//object cleaning

	}

	@Override
	public void resize(int width, int height) {
		menu_Obj.update(width,height);
	}
}

