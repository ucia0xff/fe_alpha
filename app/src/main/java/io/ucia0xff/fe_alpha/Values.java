package io.ucia0xff.fe_alpha;

import android.content.Context;
import android.graphics.Rect;

public class Values {
    public static Context CONTEXT = null;

    //屏幕宽高
    public static int SCREEN_WIDTH = 1080;
    public static int SCREEN_HEIGHT = 1920;

    //图集中瓦片块的宽高
    public static final int RES_TILE_WIDTH = 16;
    public static final int RES_TILE_HEIGHT = 16;

    //游戏中瓦片块的宽高
    public static final int MAP_TILE_WIDTH = 100;
    public static final int MAP_TILE_HEIGHT = 100;

    //角色地图动画资源大小
    public static final int RES_ANIM_SIZE_16 = 16;
    public static final int RES_ANIM_SIZE_32 = 32;

    //角色地图动画显示区域
    public static Rect MAP_ANIM_SIZE_16x16 = new Rect(0, 0, MAP_TILE_WIDTH, MAP_TILE_HEIGHT);
    public static Rect MAP_ANIM_SIZE_16x32 = new Rect(0, 0, MAP_TILE_WIDTH, MAP_TILE_HEIGHT*2);
    public static Rect MAP_ANIM_SIZE_32x32 = new Rect(0, 0, MAP_TILE_WIDTH*2, MAP_TILE_HEIGHT*2);

    //角色阵营
    public static final int PARTY_COUNT = 4;
    public static final int PARTY_PLAYER = 0;//我军
    public static final int PARTY_ENEMY = 1;//敌军
    public static final int PARTY_ALLY = 2;//友军
    public static final int PARTY_UNKNOW = 3;//中立

    //回合
    public static final int PHASE_PLAYER = 0;
    public static final int PHASE_ENEMY = 1;
    public static final int PHASE_ALLY = 2;
    public static final int PHASE_UNKNOW = 3;

    //游戏进行阶段
    public static final int CASE_NORMAL = 0;//未选中角色
    public static final int CASE_BEFORE_MOVE = 1;//移动前显示移动范围、选择移动地点
    public static final int CASE_MOVING = 2;//移动过程中
    public static final int CASE_AFTER_MOVE = 3;//移动结束、选择行动
    public static final int CASE_SELECT_WEAPON = 4;//选择武器/杖
    public static final int CASE_BEFORE_ATTACK = 5;//显示范围、选择目标
    public static final int CASE_ATTACKING = 6;//攻击/使用杖中过程
    public static final int CASE_AFTER_ATTACK = 7;//攻击/使用杖结束
    public static final int CASE_SHOW_ACTOR_INFO = 8;//显示角色信息
    public static final int CASE_SHOW_GAME_OPTIONS = 9;//显示游戏菜单


    //角色地图动画状态
    public static final String MAP_ANIM_STATIC = "Static";
    public static final String MAP_ANIM_DYNAMIC = "Dynamic";
    public static final String MAP_ANIM_DOWN = "Down";
    public static final String MAP_ANIM_UP = "Up";
    public static final String MAP_ANIM_RIGHT = "Right";
    public static final String MAP_ANIM_LEFT = "Left";
    public static final String MAP_ANIM_STANDBY = "Standby";

    //光标动画状态
    public static final String CURSOR_DYNAMIC="CURSOR_DYNAMIC";
    public static final String CURSOR_STATIC="CURSOR_STATIC";
    public static final String CURSOR_TARGET="CURSOR_TARGET";
    public static final String CURSOR_ALLOWED="CURSOR_ALLOWED";
    public static final String CURSOR_FORBIDEN="CURSOR_FORBIDEN";

    //武器熟练度等级
    public static final int WEAPON_LEVEL__ = 0;
    public static final int WEAPON_LEVEL_E = 1;
    public static final int WEAPON_LEVEL_D = 31;
    public static final int WEAPON_LEVEL_C = 71;
    public static final int WEAPON_LEVEL_B = 121;
    public static final int WEAPON_LEVEL_A = 181;
    public static final int WEAPON_LEVEL_S = 251;
    public static final int WEAPON_LEVEL_SS = 255;

    public static final String WEAPON__ = "—";
    public static final String WEAPON_E = "E";
    public static final String WEAPON_D = "D";
    public static final String WEAPON_C = "C";
    public static final String WEAPON_B = "B";
    public static final String WEAPON_A = "A";
    public static final String WEAPON_S = "S";
    public static final String WEAPON_SS = "SS";
    public static final String WEAPON_P = "★";

    public static final int WEAPON_E_TO_D = 30;
    public static final int WEAPON_D_TO_C = 40;
    public static final int WEAPON_C_TO_B = 50;
    public static final int WEAPON_B_TO_A = 60;
    public static final int WEAPON_A_TO_S = 70;


    //战斗动画名称
    public static final String BATTLE_ANIM_NONE = "BATTLE_ANIM_NONE";//无武器
    public static final String BATTLE_ANIM_SWORD = "BATTLE_ANIM_SWORD";//剑
    public static final String BATTLE_ANIM_LANCE = "BATTLE_ANIM_LANCE";//枪
    public static final String BATTLE_ANIM_AXE = "BATTLE_ANIM_AXE";//斧
    public static final String BATTLE_ANIM_BOW = "BATTLE_ANIM_BOW";//弓
    public static final String BATTLE_ANIM_ANIMA = "BATTLE_ANIM_ANIMA";//理
    public static final String BATTLE_ANIM_DARK = "BATTLE_ANIM_DARK";//暗
    public static final String BATTLE_ANIM_STAFF = "BATTLE_ANIM_STAFF";//杖
    public static final String BATTLE_ANIM_LIGHT = "BATTLE_ANIM_LIGHT";//光
    public static final String BATTLE_ANIM_MAGSWD = "BATTLE_ANIM_MAGSWD";//魔法剑
    public static final String BATTLE_ANIM_JAVELIN = "BATTLE_ANIM_JAVELIN";//投枪
    public static final String BATTLE_ANIM_HADNAXE = "BATTLE_ANIM_HADNAXE";//投斧

    public static final String BATTLE_ANIM_SWORD_CRIT = "BATTLE_ANIM_SWORD_CRIT";//剑必杀
    public static final String BATTLE_ANIM_LANCE_CRIT = "BATTLE_ANIM_LANCE_CRIT";//枪必杀
    public static final String BATTLE_ANIM_AXE_CRIT = "BATTLE_ANIM_AXE_CRIT";//斧必杀
    public static final String BATTLE_ANIM_BOW_CRIT = "BATTLE_ANIM_BOW_CRIT";//弓必杀
    public static final String BATTLE_ANIM_ANIMA_CRIT = "BATTLE_ANIM_ANIMA_CRIT";//理必杀
    public static final String BATTLE_ANIM_DARK_CRIT = "BATTLE_ANIM_DARK_CRIT";//暗必杀
    public static final String BATTLE_ANIM_LIGHT_CRIT = "BATTLE_ANIM_LIGHT_CRIT";//光必杀
    public static final String BATTLE_ANIM_MAGSWD_CRIT = "BATTLE_ANIM_MAGSWD_CRIT";//魔法剑必杀
    public static final String BATTLE_ANIM_JAVELIN_CRIT = "BATTLE_ANIM_JAVELIN_CRIT";//投枪必杀
    public static final String BATTLE_ANIM_HADNAXE_CRIT = "BATTLE_ANIM_HADNAXE_CRIT";//投斧必杀

    public static final String BATTLE_ANIM_NONE_DODGE = "BATTLE_ANIM_NONE_DODGE";//无武器回避
    public static final String BATTLE_ANIM_SWORD_DODGE = "BATTLE_ANIM_SWORD_DODGE";//剑回避
    public static final String BATTLE_ANIM_LANCE_DODGE = "BATTLE_ANIM_LANCE_DODGE";//枪回避
    public static final String BATTLE_ANIM_AXE_DODGE = "BATTLE_ANIM_AXE_DODGE";//斧回避
    public static final String BATTLE_ANIM_BOW_DODGE = "BATTLE_ANIM_BOW_DODGE";//弓回避
    public static final String BATTLE_ANIM_MAGSWD_DODGE = "BATTLE_ANIM_MAGSWD_DODGE";//魔法剑回避
    public static final String BATTLE_ANIM_JAVELIN_DODGE = "BATTLE_ANIM_JAVELIN_DODGE";//投枪回避
    public static final String BATTLE_ANIM_HADNAXE_DODGE = "BATTLE_ANIM_HADNAXE_DODGE";//投斧回避
    public static final String BATTLE_ANIM_MAGIC_DODGE = "BATTLE_ANIM_DODGE";//魔法系回避

    //人物属性
    public static final String[] AFFIN = {"","炎","雷","风","冰","暗","光","理"};
}
