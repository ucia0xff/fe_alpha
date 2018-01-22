package io.ucia0xff.fe_alpha.actor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import io.ucia0xff.fe_alpha.Paints;
import io.ucia0xff.fe_alpha.R;
import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.anim.Animation;

public class ActorInfoPanel {
//    private Actor actor;

    //背景图片
    private Bitmap dataBg;
    private Bitmap faceBg;
    private Bitmap careerBg;

    //图标
    private Bitmap mounts;
    private Bitmap affins;
    private Bitmap weapons;

    //标题
    private int allPage = 3;
    private int nowPage = 0;
    private Bitmap dataTitle;
    private Bitmap itemsTitle;
    private Bitmap levelTitle;

    //要显示区域
    private Rect dataBgSrc;
    private Rect faceBgSrc;
    private Rect careerBgSrc;
    private Rect actorFaceSrc;
    private Rect actorFaceSrcCut;
    private Rect titleSrc;

    //绘制在画布上的区域
    private Rect dataBgDst;
    private Rect faceBgDst;
    private Rect careerBgDst;
    private Rect actorFaceDst;
    private Rect titleDst;

    //构造方法
    public ActorInfoPanel(Context context) {
        faceBg = Animation.ReadBitMap(context, R.drawable.panel_actor_face);
        faceBgSrc = new Rect(0, 0, faceBg.getWidth(), faceBg.getHeight());
        faceBgDst = new Rect(0, 0, Values.SCREEN_WIDTH / 2, (int) (Values.SCREEN_WIDTH / 2.0 / faceBg.getWidth() * faceBg.getHeight()));
        careerBg = Animation.ReadBitMap(context, R.drawable.panel_actor_career);
        careerBgSrc = new Rect(0, 0, careerBg.getWidth(), careerBg.getHeight());
        careerBgDst = new Rect(Values.SCREEN_WIDTH / 2, 0, Values.SCREEN_WIDTH, faceBgDst.bottom);
        dataBg = Animation.ReadBitMap(context, R.drawable.panel_actor_data);
        dataBgSrc = new Rect(0, 0, dataBg.getWidth(), dataBg.getHeight());
        dataBgDst = new Rect(0, faceBgDst.bottom, Values.SCREEN_WIDTH, Values.SCREEN_HEIGHT);
        actorFaceSrc = new Rect(0, 0, 80, 72);
        actorFaceSrcCut = new Rect(8, 0, 88, 72);
        actorFaceDst = new Rect((int) (8.0 / faceBgSrc.width() * faceBgDst.width()), (int) (8.0 / faceBgSrc.width() * faceBgDst.width()), faceBgDst.right - (int) (8.0 / faceBgSrc.width() * faceBgDst.width()), faceBgDst.bottom - (int) (5.0 / faceBgSrc.width() * faceBgDst.width()));
        dataTitle = Animation.ReadBitMap(Values.CONTEXT, R.drawable.title_data);
        itemsTitle = Animation.ReadBitMap(Values.CONTEXT, R.drawable.title_items);
        levelTitle = Animation.ReadBitMap(Values.CONTEXT, R.drawable.title_level);
        titleSrc = new Rect(0, 0, dataTitle.getWidth(), dataTitle.getHeight());
        titleDst = new Rect(0, dataBgDst.top + 20, Values.SCREEN_WIDTH, dataBgDst.top + 20 + Values.SCREEN_WIDTH / titleSrc.width() * titleSrc.height());
        mounts = Animation.ReadBitMap(Values.CONTEXT, R.drawable.icon_mounts);
        affins = Animation.ReadBitMap(Values.CONTEXT, R.drawable.icon_affins);
        weapons = Animation.ReadBitMap(Values.CONTEXT, R.drawable.icon_weapons);
    }

    //显示角色信息面板
    public void DisplayActorInfo(Canvas canvas, Paint paint, Actor actor) {
        canvas.drawBitmap(faceBg, faceBgSrc, faceBgDst, paint);//头像背景
        canvas.drawBitmap(careerBg, careerBgSrc, careerBgDst, paint);//职业背景
        canvas.drawBitmap(dataBg, dataBgSrc, dataBgDst, paint);//数据背景

        String text;
        int num;

        //头像
        canvas.drawBitmap(actor.getFace(), (actor.getFace().getWidth() == 96) ? actorFaceSrcCut : actorFaceSrc, actorFaceDst, paint);

        //角色名
        text = actor.getName();
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (17.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("actor_name"));

        //职业名
        text = actor.getCareer().getNAME();
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (42.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("career_name"));

        //LV、Exp
        text = "LV  E  ";
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (60.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp"));
        num = actor.getLevel();
        text = (num > 9 ? "  " : "   ") + num + "   ";
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (60.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_blue"));
        num = actor.getExp();
        text = (num > 9 ? "     " : "      ") + num;
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (60.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_blue"));

        //HP、MaxHP
        text = "HP  /  ";
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (76.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp"));
        num = actor.getHP();
        text = (num > 99 ? "  --   " : num > 9 ? "  " + num + "   " : "   " + num + "   ");
        if (actor.getHP() < actor.getMaxHP() * 0.3)
            canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (76.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_red"));
        else if (actor.getHP() < actor.getMaxHP() * 0.7)
            canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (76.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_yellow"));
        else
            canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (76.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_blue"));
        num = actor.getMaxHP();
        text = (num > 99 ? "     --" : num > 9 ? "     " + num : "      " + num);
        canvas.drawText(text, careerBgDst.left + careerBgDst.width() / 2, (int) (76.0 / careerBgSrc.height() * careerBgDst.height()), Paints.paints.get("lv_exp_hp_num_green"));

        //页面指示
        canvas.drawText(nowPage + 1 + "/" + allPage, Values.SCREEN_WIDTH, titleDst.bottom - 40, Paints.paints.get("page_indicator"));
        switch (nowPage) {
            case 0:
                DisplayData(canvas, paint, actor);
                break;
            case 1:
                DisplayItems(canvas, paint, actor);
                break;
            case 2:
                DisplayLevel(canvas, paint, actor);
                break;
        }
    }

    public void DisplayData(Canvas canvas, Paint paint, Actor actor) {
        int col1 = (int) (8.0 / dataBgSrc.width() * dataBgDst.width());
        int col2 = Values.SCREEN_WIDTH / 2;
        int col3 = col1 + (int) Paints.paints.get("ability_name").measureText("能力") + 20;
        int col4 = col2 + (int) Paints.paints.get("ability_name").measureText("能力") + 20;

        //标题
        canvas.drawBitmap(dataTitle, titleSrc, titleDst, paint);

        //第一列+0力量
        canvas.drawText("力量", col1, titleDst.bottom + 40, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6, col3 + actor.getCareer().getMAX_STR() * 10 + 6, titleDst.bottom + 6, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6, col3 + actor.getCareer().getMAX_STR() * 10, titleDst.bottom + 6, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6, col3 + actor.getStr() * 10, titleDst.bottom + 6, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getStr() + "", col3 + 150, titleDst.bottom + 30, Paints.paints.get((actor.getStr() == actor.getCareer().getMAX_STR()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+100魔力
        canvas.drawText("魔力", col1, titleDst.bottom + 40 + 100, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 100, col3 + actor.getCareer().getMAX_MAG() * 10 + 6, titleDst.bottom + 6 + 100, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 100, col3 + actor.getCareer().getMAX_MAG() * 10, titleDst.bottom + 6 + 100, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 100, col3 + actor.getMag() * 10, titleDst.bottom + 6 + 100, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getMag() + "", col3 + 150, titleDst.bottom + 30 + 100, Paints.paints.get((actor.getMag() == actor.getCareer().getMAX_MAG()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+200技术
        canvas.drawText("技术", col1, titleDst.bottom + 40 + 200, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 200, col3 + actor.getCareer().getMAX_SKILL() * 10 + 6, titleDst.bottom + 6 + 200, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 200, col3 + actor.getCareer().getMAX_SKILL() * 10, titleDst.bottom + 6 + 200, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 200, col3 + actor.getSkill() * 10, titleDst.bottom + 6 + 200, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getSkill() + "", col3 + 150, titleDst.bottom + 30 + 200, Paints.paints.get((actor.getSkill() == actor.getCareer().getMAX_SKILL()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+300速度
        canvas.drawText("速度", col1, titleDst.bottom + 40 + 300, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 300, col3 + actor.getCareer().getMAX_SPD() * 10 + 6, titleDst.bottom + 6 + 300, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 300, col3 + actor.getCareer().getMAX_SPD() * 10, titleDst.bottom + 6 + 300, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 300, col3 + actor.getSpd() * 10, titleDst.bottom + 6 + 300, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getSpd() + "", col3 + 150, titleDst.bottom + 30 + 300, Paints.paints.get((actor.getSpd() == actor.getCareer().getMAX_SPD()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+400幸运
        canvas.drawText("幸运", col1, titleDst.bottom + 40 + 400, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 400, col3 + actor.getCareer().getMAX_LUCK() * 10 + 6, titleDst.bottom + 6 + 400, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 400, col3 + actor.getCareer().getMAX_LUCK() * 10, titleDst.bottom + 6 + 400, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 400, col3 + actor.getLuck() * 10, titleDst.bottom + 6 + 400, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getLuck() + "", col3 + 150, titleDst.bottom + 30 + 400, Paints.paints.get((actor.getLuck() == actor.getCareer().getMAX_LUCK()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+500守备
        canvas.drawText("守备", col1, titleDst.bottom + 40 + 500, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 500, col3 + actor.getCareer().getMAX_DEF() * 10 + 6, titleDst.bottom + 6 + 500, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 500, col3 + actor.getCareer().getMAX_DEF() * 10, titleDst.bottom + 6 + 500, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 500, col3 + actor.getDef() * 10, titleDst.bottom + 6 + 500, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getDef() + "", col3 + 150, titleDst.bottom + 30 + 500, Paints.paints.get((actor.getDef() == actor.getCareer().getMAX_DEF()) ? "ability_data_green" : "ability_data_blue"));

        //第一列+600魔防
        canvas.drawText("魔防", col1, titleDst.bottom + 40 + 600, Paints.paints.get("ability_name"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 6 + 600, col3 + actor.getCareer().getMAX_RES() * 10 + 6, titleDst.bottom + 6 + 600, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 600, col3 + actor.getCareer().getMAX_RES() * 10, titleDst.bottom + 6 + 600, Paints.paints.get("ability_blank"));
        canvas.drawLine(col3, titleDst.bottom + 6 + 600, col3 + actor.getRes() * 10, titleDst.bottom + 6 + 600, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getRes() + "", col3 + 150, titleDst.bottom + 30 + 600, Paints.paints.get((actor.getRes() == actor.getCareer().getMAX_RES()) ? "ability_data_green" : "ability_data_blue"));

        //第二列+0移动
        canvas.drawText("移动", col2, titleDst.bottom + 40, Paints.paints.get("ability_name"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 6, col4 + actor.getCareer().getMAX_MOVE() * 10 + 6, titleDst.bottom + 6, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 6, col4 + actor.getCareer().getMAX_MOVE() * 10, titleDst.bottom + 6, Paints.paints.get("ability_blank"));
        canvas.drawLine(col4, titleDst.bottom + 6, col4 + actor.getMove() * 10, titleDst.bottom + 6, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getMove() + "", col4 + 150, titleDst.bottom + 30, Paints.paints.get((actor.getMove() == actor.getCareer().getMAX_MOVE()) ? "ability_data_green" : "ability_data_blue"));

        //第二列+100体格
        canvas.drawText("体格", col2, titleDst.bottom + 40 + 100, Paints.paints.get("ability_name"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 6 + 100, col4 + actor.getCareer().getMAX_CON() * 10 + 6, titleDst.bottom + 6 + 100, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 6 + 100, col4 + actor.getCareer().getMAX_CON() * 10, titleDst.bottom + 6 + 100, Paints.paints.get("ability_blank"));
        canvas.drawLine(col4, titleDst.bottom + 6 + 100, col4 + actor.getCon() * 10, titleDst.bottom + 6 + 100, Paints.paints.get("ability_yellow"));
        canvas.drawText(actor.getCon() + "", col4 + 150, titleDst.bottom + 30 + 100, Paints.paints.get((actor.getCon() == actor.getCareer().getMAX_CON()) ? "ability_data_green" : "ability_data_blue"));

        //第二列+200坐骑
        canvas.drawText("坐骑", col2, titleDst.bottom + 40 + 200, Paints.paints.get("ability_name"));
        canvas.drawBitmap(mounts, new Rect(actor.getMount() * 32, 0, actor.getMount() * 32 + 32, 32), new Rect(col4 + 50, titleDst.bottom + 30 + 130, col4 + 150, titleDst.bottom + 30 + 230), paint);

        //第二列+300救出
        canvas.drawText("救出", col2, titleDst.bottom + 40 + 300, Paints.paints.get("ability_name"));
        canvas.drawText(actor.getAid() + "", col4 + 150, titleDst.bottom + 30 + 300, Paints.paints.get("ability_data_blue"));

        //第二列+400同行
        canvas.drawText("同行", col2, titleDst.bottom + 40 + 400, Paints.paints.get("ability_name"));

        //第二列+500属性
        canvas.drawText("属性", col2, titleDst.bottom + 40 + 500, Paints.paints.get("ability_name"));
        canvas.drawBitmap(affins, new Rect(actor.getAffin() * 16, 0, actor.getAffin() * 16 + 16, 16), new Rect(col4 + 50, titleDst.bottom + 30 + 430, col4 + 150, titleDst.bottom + 30 + 530), paint);
        canvas.drawText(Values.AFFIN[actor.getAffin()], col4 + 150, titleDst.bottom + 30 + 500, Paints.paints.get("ability_text_blue"));

        //第二列+600状态
        canvas.drawText("状态", col2, titleDst.bottom + 40 + 600, Paints.paints.get("ability_name"));
    }

    public void DisplayItems(Canvas canvas, Paint paint, Actor actor) {
        //标题
        canvas.drawBitmap(itemsTitle, titleSrc, titleDst, paint);
    }

    public void DisplayLevel(Canvas canvas, Paint paint, Actor actor) {
        int col1 = (int) (8.0 / dataBgSrc.width() * dataBgDst.width());
        int col2 = Values.SCREEN_WIDTH / 2;
        int col3 = (int) (col1 + 100 + Paints.paints.get("weapon_type").measureText("剑") + 20);
        int col4 = (int) (col2 + 100 + Paints.paints.get("weapon_type").measureText("剑") + 20);
        int col5 = col2 - col1;
        int col6 = Values.SCREEN_WIDTH - col1 - col1;


        int length = col5 - col3;
        int exp;
        int next;
        int rest;
        String level;

        //标题
        canvas.drawBitmap(levelTitle, titleSrc, titleDst, paint);

        canvas.drawBitmap(weapons, new Rect(0 * 32, 0, 0 * 32 + 32, 32), new Rect(col1, titleDst.bottom - 30, col1 + 100, titleDst.bottom + 70), paint);
        canvas.drawText("剑", col1 + 100, titleDst.bottom + 40, Paints.paints.get("weapon_type"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 10, col5+6, titleDst.bottom + 10, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 10, col5, titleDst.bottom + 10, Paints.paints.get("ability_blank"));
        exp = actor.getSwordExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col3, titleDst.bottom + 10, col3 + (float)rest/next * length, titleDst.bottom + 10, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col3 + col5)/2, titleDst.bottom + 35, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_SWORD()?"weapon_level_green":"weapon_level_blue"));


        canvas.drawBitmap(weapons, new Rect(1 * 32, 0, 1 * 32 + 32, 32), new Rect(col1, titleDst.bottom - 30 + 100, col1 + 100, titleDst.bottom + 70 + 100), paint);
        canvas.drawText("枪", col1 + 100, titleDst.bottom + 40 + 100, Paints.paints.get("weapon_type"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 10 + 100, col5+6, titleDst.bottom + 10 + 100, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 10 + 100, col5, titleDst.bottom + 10 + 100, Paints.paints.get("ability_blank"));
        exp = actor.getLanceExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col3, titleDst.bottom + 10 + 100, col3 + (float)rest/next * length, titleDst.bottom + 10 + 100, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col3 + col5)/2, titleDst.bottom + 35 + 100, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_LANCE()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(2 * 32, 0, 2 * 32 + 32, 32), new Rect(col1, titleDst.bottom - 30 + 200, col1 + 100, titleDst.bottom + 70 + 200), paint);
        canvas.drawText("斧", col1 + 100, titleDst.bottom + 40 + 200, Paints.paints.get("weapon_type"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 10 + 200, col5+6, titleDst.bottom + 10 + 200, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 10 + 200, col5, titleDst.bottom + 10 + 200, Paints.paints.get("ability_blank"));
        exp = actor.getAxeExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col3, titleDst.bottom + 10 + 200, col3 + (float)rest/next * length, titleDst.bottom + 10 + 200, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col3 + col5)/2, titleDst.bottom + 35 + 200, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_AXE()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(3 * 32, 0, 3 * 32 + 32, 32), new Rect(col1, titleDst.bottom - 30 + 300, col1 + 100, titleDst.bottom + 70 + 300), paint);
        canvas.drawText("弓", col1 + 100, titleDst.bottom + 40 + 300, Paints.paints.get("weapon_type"));
        canvas.drawLine(col3 - 6, titleDst.bottom + 10 + 300, col5+6, titleDst.bottom + 10 + 300, Paints.paints.get("ability_border"));
        canvas.drawLine(col3, titleDst.bottom + 10 + 300, col5, titleDst.bottom + 10 + 300, Paints.paints.get("ability_blank"));
        exp = actor.getBowExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col3, titleDst.bottom + 10 + 300, col3 + (float)rest/next * length, titleDst.bottom + 10 + 300, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col3 + col5)/2, titleDst.bottom + 35 + 300, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_BOW()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(4 * 32, 0, 4 * 32 + 32, 32), new Rect(col2, titleDst.bottom - 30, col2 + 100, titleDst.bottom + 70), paint);
        canvas.drawText("杖", col2 + 100, titleDst.bottom + 40, Paints.paints.get("weapon_type"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 10, col6+6, titleDst.bottom + 10, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 10, col6, titleDst.bottom + 10, Paints.paints.get("ability_blank"));
        exp = actor.getStaffExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col4, titleDst.bottom + 10 , col4 + (float)rest/next * length, titleDst.bottom + 10, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col4 + col6)/2, titleDst.bottom + 35, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_STAFF()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(5 * 32, 0, 5 * 32 + 32, 32), new Rect(col2, titleDst.bottom - 30 + 100, col2 + 100, titleDst.bottom + 70 + 100), paint);
        canvas.drawText("理", col2 + 100, titleDst.bottom + 40 + 100, Paints.paints.get("weapon_type"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 10 + 100, col6+6, titleDst.bottom + 10 + 100, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 10 + 100, col6, titleDst.bottom + 10 + 100, Paints.paints.get("ability_blank"));
        exp = actor.getAnimaExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col4, titleDst.bottom + 10 + 100, col4 + (float)rest/next * length, titleDst.bottom + 10 + 100, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col4 + col6)/2, titleDst.bottom + 35 + 100, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_ANIMA()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(6 * 32, 0, 6 * 32 + 32, 32), new Rect(col2, titleDst.bottom - 30 + 200, col2 + 100, titleDst.bottom + 70 + 200), paint);
        canvas.drawText("光", col2 + 100, titleDst.bottom + 40 + 200, Paints.paints.get("weapon_type"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 10 + 200, col6+6, titleDst.bottom + 10 + 200, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 10 + 200, col6, titleDst.bottom + 10 + 200, Paints.paints.get("ability_blank"));
        exp = actor.getLightExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col4, titleDst.bottom + 10 + 200, col4 + (float)rest/next * length, titleDst.bottom + 10 + 200, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col4 + col6)/2, titleDst.bottom + 35 + 200, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_LIGHT()?"weapon_level_green":"weapon_level_blue"));

        canvas.drawBitmap(weapons, new Rect(7 * 32, 0, 7 * 32 + 32, 32), new Rect(col2, titleDst.bottom - 30 + 300, col2 + 100, titleDst.bottom + 70 + 300), paint);
        canvas.drawText("暗", col2 + 100, titleDst.bottom + 40 + 300, Paints.paints.get("weapon_type"));
        canvas.drawLine(col4 - 6, titleDst.bottom + 10 + 300, col6+6, titleDst.bottom + 10 + 300, Paints.paints.get("ability_border"));
        canvas.drawLine(col4, titleDst.bottom + 10 + 300, col6, titleDst.bottom + 10 + 300, Paints.paints.get("ability_blank"));
        exp = actor.getDarkExp();
        next = getNext(exp);
        rest = getRest(exp);
        level = getLevel(exp);
        if(next>0)
            canvas.drawLine(col4, titleDst.bottom + 10 + 300, col4 + (float)rest/next * length, titleDst.bottom + 10 + 300, Paints.paints.get("ability_yellow"));
        canvas.drawText(level, (col4 + col6)/2, titleDst.bottom + 35 + 300, Paints.paints.get(exp>0 && exp==actor.getCareer().getMAX_EXP_DARK()?"weapon_level_green":"weapon_level_blue"));

    }

    public void TurnRight() {
        nowPage = (nowPage + 1) % allPage;
    }

    public void TurnLeft() {
        nowPage = (nowPage - 1 < 0) ? 2 : nowPage - 1;
    }

    public static int getNext(int exp){
        if (exp>=Values.WEAPON_LEVEL_S)
            return 0;
        else if (exp >= Values.WEAPON_LEVEL_A)
            return Values.WEAPON_A_TO_S - 1;
        else if (exp>=Values.WEAPON_LEVEL_B)
            return Values.WEAPON_B_TO_A - 1;
        else if (exp>=Values.WEAPON_LEVEL_C)
            return Values.WEAPON_C_TO_B - 1;
        else if (exp>=Values.WEAPON_LEVEL_D)
            return Values.WEAPON_D_TO_C - 1;
        else if (exp>=Values.WEAPON_LEVEL_E)
            return Values.WEAPON_E_TO_D - 1;
        else
            return 0;
    }

    public static int getRest(int exp){
        if (exp>=Values.WEAPON_LEVEL_S)
            return 0;
        else if (exp >= Values.WEAPON_LEVEL_A)
            return exp - Values.WEAPON_LEVEL_A;
        else if (exp>=Values.WEAPON_LEVEL_B)
            return exp - Values.WEAPON_LEVEL_B;
        else if (exp>=Values.WEAPON_LEVEL_C)
            return exp - Values.WEAPON_LEVEL_C;
        else if (exp>=Values.WEAPON_LEVEL_D)
            return exp - Values.WEAPON_LEVEL_D;
        else if (exp>=Values.WEAPON_LEVEL_E)
            return exp - Values.WEAPON_LEVEL_E;
        else
            return 0;
    }

    public static String getLevel(int exp){
        if (exp==Values.WEAPON_LEVEL_SS)
            return Values.WEAPON_SS;
        else if (exp==Values.WEAPON_LEVEL_S)
            return Values.WEAPON_S;
        else if (exp >= Values.WEAPON_LEVEL_A)
            return Values.WEAPON_A;
        else if (exp>=Values.WEAPON_LEVEL_B)
            return Values.WEAPON_B;
        else if (exp>=Values.WEAPON_LEVEL_C)
            return Values.WEAPON_C;
        else if (exp>=Values.WEAPON_LEVEL_D)
            return Values.WEAPON_D;
        else if (exp>=Values.WEAPON_LEVEL_E)
            return Values.WEAPON_E;
        else
            return Values.WEAPON__;
    }
}
