package io.ucia0xff.fe_alpha.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.InputStream;

import io.ucia0xff.fe_alpha.Paints;
import io.ucia0xff.fe_alpha.R;
import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.game.GameView;

public class TerrainInfoPanel {
    //是否在屏幕左边
    private Boolean isLeft = true;

    //背景图片
    private Bitmap panelBg;

    //地形信息
    private int[][] mapTerrain;
    private String tileName = "";
    private int[] tileEffect;
    private String effectText = "";
    private int strLength;

    //构造方法
    public TerrainInfoPanel(Context context, Map map){
        panelBg = ReadBitMap(context, R.drawable.panel_terrain_info);
        mapTerrain = map.getTerrain();
    }

    public void setLeft(Boolean left) {
        isLeft = left;
    }

    public void setMapTerrain(int[][] mapTerrain) {
        this.mapTerrain = mapTerrain;
    }

    //显示地形信息
    public void DisplayTileInfo(Canvas canvas, Paint paint, Boolean isLeft) {
        tileName = TerrainInfo.TERRAIN_NAME[mapTerrain[GameView.cursorY][GameView.cursorX]];
        tileEffect = TerrainInfo.TERRAIN_EFFECT[mapTerrain[GameView.cursorY][GameView.cursorX]];
        if (canvas==null) return;
        if (isLeft) {
            canvas.drawBitmap(panelBg, Values.SCREEN_WIDTH - panelBg.getWidth(), Values.SCREEN_HEIGHT - panelBg.getHeight(), paint);
            strLength = (int) paint.measureText(tileName);
            canvas.drawText(tileName, Values.SCREEN_WIDTH - panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 130, Paints.paints.get("terrain_name"));
            effectText = "AVD." + (tileEffect[0]>9 ? tileEffect[0] : " "+tileEffect[0]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, Values.SCREEN_WIDTH - panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 210, Paints.paints.get("terrain_effect"));
            effectText = "DEF." + (tileEffect[1]>9 ? tileEffect[1]: " "+tileEffect[1]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, Values.SCREEN_WIDTH - panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 265, Paints.paints.get("terrain_effect"));
            effectText = "REC." + (tileEffect[3]>9 ? tileEffect[3]: " "+tileEffect[3]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, Values.SCREEN_WIDTH - panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 320, Paints.paints.get("terrain_effect"));
        }else {
            canvas.drawBitmap(panelBg, 0, Values.SCREEN_HEIGHT - panelBg.getHeight(), paint);
            strLength = (int) paint.measureText(tileName);
            canvas.drawText(tileName, panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 130, Paints.paints.get("terrain_name"));
            effectText = "AVD." + (tileEffect[0]>9 ? tileEffect[0] : " "+tileEffect[0]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 210, Paints.paints.get("terrain_effect"));
            effectText = "DEF." + (tileEffect[1]>9 ? tileEffect[1]: " "+tileEffect[1]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 265, Paints.paints.get("terrain_effect"));
            effectText = "REC." + (tileEffect[3]>9 ? tileEffect[3]: " "+tileEffect[3]);
            strLength = (int) paint.measureText(effectText);
            canvas.drawText(effectText, panelBg.getWidth() / 2, Values.SCREEN_HEIGHT - panelBg.getHeight() + 320, Paints.paints.get("terrain_effect"));
        }
    }

    //读取图片资源
    public Bitmap ReadBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;//色彩模式，RGB_565模式下一个像素点占用2bytes(R占5bit,G占6bit,B占5bit)
        opt.inPurgeable = true;// 可被释放
        opt.inInputShareable = true;//可被共享，和上一个参数一起用
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
}
