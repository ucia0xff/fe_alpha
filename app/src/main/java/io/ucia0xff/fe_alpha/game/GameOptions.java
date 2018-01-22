package io.ucia0xff.fe_alpha.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import io.ucia0xff.fe_alpha.Paints;
import io.ucia0xff.fe_alpha.R;
import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.anim.Animation;

public class GameOptions {
    public static final String[] OPTIONS = {"结束", "部队", "状态", "设定", "中断"};
    public static final int ID_TURN_OVER = 0;
    public static final int ID_PLAYER_TEAM = 1;
    public static final int ID_GAME_STATUS = 2;
    public static final int ID_GEME_SETTING = 3;
    public static final int ID_GAME_PAUSE = 4;

    private Bitmap panelStart;
    private Bitmap panelOne;
    private Bitmap panelEnd;
    private Bitmap pointer;

    private int pointTo;

    public GameOptions(Context context) {
        panelStart = Animation.ReadBitMap(context, R.drawable.panel_game_options_start);
        panelOne = Animation.ReadBitMap(context, R.drawable.panel_game_options_one);
        panelEnd = Animation.ReadBitMap(context, R.drawable.panel_game_options_end);
        pointer = Animation.ReadBitMap(context, R.drawable.pointer);
        pointTo = 0;
    }

    public void DisplayGameOptions(Canvas canvas, Paint paint, Boolean isLeft) {
        if (isLeft) {
            canvas.drawBitmap(panelStart, Values.SCREEN_WIDTH - 150 - panelStart.getWidth(), 500, paint);
            for (int i = 0; i < OPTIONS.length; i++) {
                canvas.drawBitmap(panelOne, Values.SCREEN_WIDTH - 150 - panelOne.getWidth(), 500 + panelStart.getHeight() + i * panelOne.getHeight(), paint);
                canvas.drawText(OPTIONS[i], Values.SCREEN_WIDTH - 150 - panelOne.getWidth() / 2, 500 + panelStart.getHeight() + i * panelOne.getHeight() + panelOne.getHeight() * 2 / 3, Paints.paints.get("game_options"));
            }
            canvas.drawBitmap(panelEnd, Values.SCREEN_WIDTH - 150 - panelEnd.getWidth(), 500 + panelStart.getHeight() + 5 * panelOne.getHeight(), paint);
            canvas.drawBitmap(pointer, Values.SCREEN_WIDTH - 150 - panelStart.getWidth() - 65, 500 + panelStart.getHeight() + pointTo * panelOne.getHeight() + 6, paint);
        } else {
            canvas.drawBitmap(panelStart, 150, 500, paint);
            for (int i = 0; i < OPTIONS.length; i++) {
                canvas.drawBitmap(panelOne, 150, 500 + panelStart.getHeight() + i * panelOne.getHeight(), paint);
                canvas.drawText(OPTIONS[i], 150 + panelOne.getWidth() / 2, 500 + panelStart.getHeight() + i * panelOne.getHeight() + panelOne.getHeight() * 2 / 3, Paints.paints.get("game_options"));
            }
            canvas.drawBitmap(panelEnd, 150, 500 + panelStart.getHeight() + 5 * panelOne.getHeight(), paint);
            canvas.drawBitmap(pointer, 150-65, 500 + panelStart.getHeight() + pointTo * panelOne.getHeight() + 6, paint);
        }
    }

    //确定选择哪项
    public int CheckOption(int x, int y, Boolean isLeft) {
        if (isLeft) {
            if (Values.SCREEN_WIDTH - 150 - panelOne.getWidth() < x && x < Values.SCREEN_WIDTH - 150) {
                for (int i = 0; i < OPTIONS.length; i++) {
                    if (500 + panelStart.getHeight() + i * panelOne.getHeight() < y && y < 500 + panelStart.getHeight() + i * panelOne.getHeight() + panelOne.getHeight()) {
                        pointTo = i;
                        return i;
                    }
                }
            }
        }else{
            if (150 < x && x < 150 + panelOne.getWidth()) {
                for (int i = 0; i < OPTIONS.length; i++) {
                    if (500 + panelStart.getHeight() + i * panelOne.getHeight() < y && y < 500 + panelStart.getHeight() + i * panelOne.getHeight() + panelOne.getHeight()) {
                        pointTo = i;
                        return i;
                    }
                }
            }
        }
        pointTo = 0;
        return OPTIONS.length+1;
    }

    //执行一个选项
    public Boolean HandleOption(int x, int y, boolean isLeft) {
        switch (CheckOption(x,y,isLeft)) {
            case ID_TURN_OVER:
                GameView.TurnOver();
                break;
            default:
                pointTo = 0;
                return false;
        }
        return true;
    }
}
