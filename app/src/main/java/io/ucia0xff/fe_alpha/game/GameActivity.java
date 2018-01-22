package io.ucia0xff.fe_alpha.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import io.ucia0xff.fe_alpha.Values;

public class GameActivity extends Activity {
    GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Values.SCREEN_WIDTH = (getWindowManager().getDefaultDisplay().getWidth());
        Values.SCREEN_HEIGHT = (getWindowManager().getDefaultDisplay().getHeight());
        Values.CONTEXT = this;
        view = new GameView(this);
        setContentView(view);
    }
}
