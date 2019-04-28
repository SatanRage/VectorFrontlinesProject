package com.vectorfrontlines.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.TimeUtils;

public class menu
{
    String mustShow="logo";
    String WhatIsShowNow="";

    LogoSplash logoSplash;
    long logoMsTime;
    long startTime;

    public menu()
    {

    }

        public boolean GameSectionsHandler()
        {
            switch(mustShow)
            {
                case "logo":
                    if(!WhatIsShowNow.equals("logo"))
                    {
                        pr("logo, start time");
                        logoSplash = new LogoSplash();
                        WhatIsShowNow="logo";
                        startTime = TimeUtils.millis();
                        logoMsTime=5000;
                    }

                    logoSplash.render();
                    pr("logo, Frame");
                    if(TimeUtils.timeSinceMillis(startTime)>=logoMsTime)
                    {   pr(String.valueOf(TimeUtils.timeSinceMillis(startTime)) );
                        pr("logo, closing");
                        mustShow="menu";
                        Gdx.gl.glClearColor(0, 0, 0, 0);
                        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                        logoSplash.dispose();

                    }
                break;

                case"menu":
                    //TODO menu code
                break;

                default:
                    //TODO see message "failed to start"
                break;
            }

        return true;
        }
     public void update(int width,int height)
     {
         if(WhatIsShowNow.equals("logo")){logoSplash.update(width,height);}


     }
     private void pr(String string)
     {
         System.out.println(string);
     }
}
