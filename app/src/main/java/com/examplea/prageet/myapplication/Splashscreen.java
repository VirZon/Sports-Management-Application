package com.examplea.prageet.myapplication;

import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Splashscreen extends Activity {
    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        Window win=getWindow();
        win.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Animation anim= AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);
        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);
        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 1500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {

                    SharedPreferences preferences = getSharedPreferences("testapp",MODE_PRIVATE);
                    final SharedPreferences.Editor editor = preferences.edit();
                     boolean hasLoggedIn = preferences.getBoolean("hasLoggedIn", false);

                    String str = preferences.getString("Name",null);


                    if(!hasLoggedIn)
                    {
                        Log.d("HOWZAA","Wooooooooooing");
                        Intent it = new Intent(Splashscreen.this,RegisterFinal.class);
                        startActivity(it);
                        Splashscreen.this.finish();
                    }
                }

            }
        };

        splashTread.start();

/*
        SharedPreferences preferences = getSharedPreferences("testapp",MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        boolean hasLoggedIn = preferences.getBoolean("hasLoggedIn", false);
        String str = preferences.getString("Name",null);


        if(str.equalsIgnoreCase(""))
        {
            Intent it = new Intent(this,RegisterFinal.class);
            startActivity(it);
            this.finish();
        }
*/

    }

}