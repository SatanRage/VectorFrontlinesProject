package com.vectorfrontlines.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;



public class LogoSplash {



    SpriteBatch batch;
    Animation<TextureRegion> animation;
    float elapsed;
    private TextureRegion frameToRender;
    OrthographicCamera camera;
    Viewport viewport;

    int logoWidth=0;
    int logoHeight=0;


//TODO document this class
    public LogoSplash() {
        batch = new SpriteBatch();

        if(LogoSpreadSheetLoader()) {}
        else
        if(GifToAnimation()) {}

        camera = new OrthographicCamera();
        viewport =new FitViewport(logoWidth,logoHeight,camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
    }

    public void render() {

        elapsed += Gdx.graphics.getDeltaTime();
        camera.update();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        frameToRender = animation.getKeyFrame(elapsed);



        batch.draw(frameToRender,
                0,
                0);


        batch.end();
    }
    public void update(int width, int height)
    {
        viewport.update(width,height);
        camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
    }
    public void dispose() {
        batch.dispose();
    }

    private boolean  LogoSpreadSheetLoader()
    {   Texture logoSpreadSheet;
        try {
        logoSpreadSheet = new Texture("splashlogo.png");
        }catch(Exception e){return false;}
        //TODO find a way to get rid of this hardcoded stuff by PNG metadata(?) o external file configs
        //abasso l'HARDCODING di valori!!!
        //######################################
        logoWidth= logoSpreadSheet.getWidth()/8;
        logoHeight=logoSpreadSheet.getHeight()/6;
        int frames=44;
        //######################################
        TextureRegion logoTxReg=new TextureRegion(logoSpreadSheet);
        TextureRegion[] logoFrames = new TextureRegion[frames] ;
        TextureRegion[][] tmp=logoTxReg.split(logoWidth,logoHeight);
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                try {
                    logoFrames[index++] = tmp[i][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }
        animation=new Animation(1.0f/30,logoFrames);
        animation.setPlayMode( Animation.PlayMode.LOOP);
        return true;
    }
    //TODO [trivial] need a method to generate spreadsheet and frames data from gif as fallback for no-logo error dodging
    //in inglese fa piu figo ma, seriamente se devo modificare il logo camma fa(?)
    private boolean GifToAnimation()
    {   try{
        GifDecoder gifDec = new GifDecoder();
        gifDec.read(Gdx.files.internal("splashlogo.gif").read());
        animation = gifDec.getAnimation
                (Animation.PlayMode.LOOP);
        logoWidth=gifDec.getPixmap().getWidth();
        logoHeight=gifDec.getPixmap().getHeight();
        return true;
    }catch(Exception e){//e.printStackTrace();
        return false;}

    }
}



