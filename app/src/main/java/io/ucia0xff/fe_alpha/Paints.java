package io.ucia0xff.fe_alpha;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public class Paints {
    public static Map<String, Paint> paints = new HashMap<String, Paint>();

    //预设的画笔样式
    static {
        //地形名称
        Paint paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("terrain_name", paint);

        //地形效果
        paint = new Paint();
        paint.setTextSize(60);
        paint.setColor(Color.WHITE);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("terrain_effect", paint);

        //游戏菜单
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.WHITE);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("game_options", paint);

        //角色信息-角色名
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("actor_name", paint);

        //角色信息-职业名
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.WHITE);
        paint.setTypeface(Typeface.SANS_SERIF);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("career_name", paint);

        //角色信息-Lv/Exp/HP标题
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.YELLOW);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("lv_exp_hp", paint);

        //角色信息-Lv/Exp/HP数值-正常
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.rgb(192,248,248));
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("lv_exp_hp_num_blue", paint);

        //角色信息-Lv/Exp/HP数值-满值
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.GREEN);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("lv_exp_hp_num_green", paint);

        //角色信息-Lv/Exp/HP数值-警告
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.YELLOW);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("lv_exp_hp_num_yellow", paint);

        //角色信息-Lv/Exp/HP数值-危险
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.RED);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("lv_exp_hp_num_red", paint);

        //角色信息-各项数据标题
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.YELLOW);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("ability_name", paint);

        //角色信息-页面指示
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.rgb(192,248,248));
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("page_indicator", paint);

        //角色信息-各项数据条最大值
        paint = new Paint();
        paint.setColor(Color.rgb(80, 72, 64));
        paint.setStrokeWidth(24);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("ability_border", paint);

        //角色信息-各项数据条当前值
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(12);
        paints.put("ability_yellow", paint);

        //角色信息-各项数据条剩余值
        paint = new Paint();
        paint.setColor(Color.rgb(128, 136, 152));
        paint.setStrokeWidth(12);
        paints.put("ability_blank", paint);

        //角色信息-各项数据当前值
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.rgb(192,248,248));
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("ability_data_blue", paint);

        //角色信息-各项数据最大值
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.GREEN);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("ability_data_green", paint);

        //角色信息-各项数据文字
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.rgb(192,248,248));
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("ability_text_blue", paint);

        //角色信息-武器种类标题
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("weapon_type", paint);

        //角色信息-武器熟练度等级
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.rgb(192,248,248));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("weapon_level_blue", paint);

        //角色信息-武器熟练度最高级
        paint = new Paint();
        paint.setTextSize(70);
        paint.setColor(Color.GREEN);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setShadowLayer(5, 5, 5, Color.rgb(56, 48, 40));
        paints.put("weapon_level_green", paint);
    }
}
