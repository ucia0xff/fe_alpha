package io.ucia0xff.fe_alpha.actor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.anim.Animation;
import io.ucia0xff.fe_alpha.career.Career;
import io.ucia0xff.fe_alpha.anim.MapAnims;
import io.ucia0xff.fe_alpha.career.Careers;
import io.ucia0xff.fe_alpha.game.GameView;

public class Actor {
    private int party;//阵营
    private int[] xyTile;//在地图数组中的坐标
    private int[] xyPos;//角色在地图数组中的格子的左上角
    private String actorKey = "";//角色标识
    private String Name = "角色名";//角色名
    private String Info = "角色说明";//角色说明
    private Bitmap Face;//个人头像

    //职业信息
    private Career career;//职业
    private int Level;//等级
    private int Exp;//经验

    //移动类型
    private int MoveCost;

    //能力值
    private int MaxHP;//最大HP
    private int HP;//HP
    private int Str;//力量
    private int Mag;//魔力
    private int Skill;//技术
    private int Spd;//速度
    private int Luck;//幸运
    private int Def;//守备
    private int Res;//魔防
    private int Move;//移动
    private int Con;//体格
    private int Aid;//救出
    private int Affin;//属性
    private int Mount;//坐骑

    private int[] Status;//状态

    //成长率
    private int MaxHPGrow;//MaxHP
    private int StrGrow;//力量
    private int MagGrow;//魔力
    private int SkillGrow;//技术
    private int SpdGrow;//速度
    private int LuckGrow;//幸运
    private int DefGrow;//守备
    private int ResGrow;//魔防

    //武器熟练度
    private int SwordExp = 0;
    private int LanceExp = 0;
    private int AxeExp = 0;
    private int BowExp = 0;
    private int StaffExp = 0;
    private int AnimaExp = 0;
    private int LightExp = 0;
    private int DarkExp = 0;

    //战斗面板
    private int Atk;//攻击
    private int Hit;//命中
    private int Avoid;//回避
    private int Cit;//必杀
    private int AtkSpd;//攻速

    //角色地图动画
    private String mapAnimKey;

    //当前动画
    private String nowAnim;

    //是否待机
    private boolean Standby;

    //是否可见
    private boolean Visible;


    public Actor(Context context, String xmlName) throws Exception {
        InputStream in = context.getAssets().open("actor_config/" + xmlName + ".xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        Element actor = document.getDocumentElement();//获得xml文件的根节点，即<Actor>
        NodeList tags = actor.getChildNodes();//获得根节点下的所有子节点
        for (int i = 0; i < tags.getLength(); i++) {
            if (tags.item(i).getNodeType() == Node.ELEMENT_NODE) {
                if ("ACTOR_KEY".equals(tags.item(i).getNodeName())) {
                    String key = tags.item(i).getTextContent();
                    if (key.length() > 0)
                        actorKey = key;
                } else if ("CAREER_KEY".equals(tags.item(i).getNodeName())) {
                    String careerKey = tags.item(i).getTextContent();
                    if (Careers.MAP_ANIMS.containsKey(careerKey)) {
                        career = Careers.MAP_ANIMS.get(careerKey);
                    } else {
                        career = new Career(Values.CONTEXT, careerKey);
                        Careers.MAP_ANIMS.put(career.getCAREER_KEY(), career);
                    }
                    MoveCost = career.getMOVE_COST();
                    mapAnimKey = (actorKey.length() > 0) ? career.getCAREER_KEY() + "_" + actorKey : career.getCAREER_KEY();
                } else if ("XY".equals(tags.item(i).getNodeName())) {
                    String[] xyText = tags.item(i).getTextContent().split(",");
                    xyTile = new int[2];
                    xyPos = new int[2];
                    xyTile[0] = Integer.parseInt(xyText[0]);
                    xyTile[1] = Integer.parseInt(xyText[1]);
                    xyPos[0] = xyTile[0] * Values.MAP_TILE_WIDTH;
                    xyPos[1] = xyTile[1] * Values.MAP_TILE_HEIGHT;
                } else if ("PARTY".equals(tags.item(i).getNodeName())) {
                    party = Integer.parseInt(tags.item(i).getTextContent());
                    switch (party){
                        case Values.PARTY_PLAYER:
                            mapAnimKey += "_Player_";
                            break;
                        case Values.PARTY_ENEMY:
                            mapAnimKey += "_Enemy_";
                            break;
                        case Values.PARTY_ALLY:
                            mapAnimKey += "_Ally_";
                            break;
                        case Values.PARTY_UNKNOWN:
                            mapAnimKey += "_Unknow_";
                            break;
                    }
                    setNowAnim(Values.MAP_ANIM_STATIC);
                } else if ("FACE".equals(tags.item(i).getNodeName())) {
                    String fileName = tags.item(i).getTextContent();
                    Face = (fileName.trim().length() > 0) ? Animation.ReadBitMap(Values.CONTEXT, "faces/" + fileName) : career.getFACE();
                } else if ("NAME".equals(tags.item(i).getNodeName())) {
                    Name = tags.item(i).getTextContent();
                } else if ("INFO".equals(tags.item(i).getNodeName())) {
                    Info = tags.item(i).getTextContent();
                } else if ("ADJUST_LEVEL".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Level = (adjust.length() > 0) ? career.getINIT_LEVEL() + Integer.parseInt(adjust) : career.getINIT_LEVEL();
                } else if ("ADJUST_MAXHP".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    MaxHP = (adjust.length() > 0) ? career.getINIT_MAXHP() + Integer.parseInt(adjust) : career.getINIT_MAXHP();
                    HP = MaxHP;
                } else if ("ADJUST_STR".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Str = (adjust.length() > 0) ? career.getINIT_STR() + Integer.parseInt(adjust) : career.getINIT_STR();
                } else if ("ADJUST_MAG".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Mag = (adjust.length() > 0) ? career.getINIT_MAG() + Integer.parseInt(adjust) : career.getINIT_MAG();
                } else if ("ADJUST_SKILL".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Skill = (adjust.length() > 0) ? career.getINIT_SKILL() + Integer.parseInt(adjust) : career.getINIT_SKILL();
                } else if ("ADJUST_SPD".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Spd = (adjust.length() > 0) ? career.getINIT_SPD() + Integer.parseInt(adjust) : career.getINIT_SPD();
                } else if ("ADJUST_LUCK".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Luck = (adjust.length() > 0) ? career.getINIT_LUCK() + Integer.parseInt(adjust) : career.getINIT_LUCK();
                } else if ("ADJUST_DEF".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Def = (adjust.length() > 0) ? career.getINIT_DEF() + Integer.parseInt(adjust) : career.getINIT_DEF();
                } else if ("ADJUST_RES".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Res = (adjust.length() > 0) ? career.getINIT_RES() + Integer.parseInt(adjust) : career.getINIT_RES();
                } else if ("ADJUST_MOVE".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Move = (adjust.length() > 0) ? career.getINIT_MOVE() + Integer.parseInt(adjust) : career.getINIT_MOVE();
                } else if ("ADJUST_CON".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Con = (adjust.length() > 0) ? career.getINIT_CON() + Integer.parseInt(adjust) : career.getINIT_CON();
                } else if ("ADJUST_AFFIN".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Affin = (adjust.length() > 0) ? Integer.parseInt(adjust) : 0;
                } else if ("ADJUST_MOUNT".equals(tags.item(i).getNodeName())) {
                    String adjust = tags.item(i).getTextContent();
                    Mount = (adjust.length() > 0) ? Integer.parseInt(adjust) : 0;
                    Aid = (Mount == 0) ? Con - 1 : career.getMAX_CON() - Con;
                } else if ("GROW_MAXHP".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    MaxHPGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_MAXHP();
                } else if ("GROW_STR".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    StrGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_STR();
                } else if ("GROW_MAG".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    MagGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_MAG();
                } else if ("GROW_SKILL".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    SkillGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_SKILL();
                } else if ("GROW_SPD".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    SpdGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_SPD();
                } else if ("GROW_LUCK".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    LuckGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_LUCK();
                } else if ("GROW_DEF".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    DefGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_DEF();
                } else if ("GROW_RES".equals(tags.item(i).getNodeName())) {
                    String rate = tags.item(i).getTextContent();
                    ResGrow = (rate.length() > 0) ? Integer.parseInt(rate) : career.getGROW_RES();
                } else if ("EXP_SWORD".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    SwordExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_SWORD();
                } else if ("EXP_LANCE".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    LanceExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_LANCE();
                } else if ("EXP_AXE".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    AxeExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_AXE();
                } else if ("EXP_BOW".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    BowExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_BOW();
                } else if ("EXP_STAFF".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    StaffExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_STAFF();
                } else if ("EXP_ANIMA".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    AnimaExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_ANIMA();
                } else if ("EXP_LIGHT".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    LightExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_LIGHT();
                } else if ("EXP_DARK".equals(tags.item(i).getNodeName())) {
                    String exp = tags.item(i).getTextContent();
                    DarkExp = (exp.length() > 0) ? Integer.parseInt(exp) : career.getEXP_DARK();
                }
            }
        }
        in.close();
    }

    public void RenderAnimation(Canvas canvas, Paint paint, int offsetX, int offsetY) {
        if (isStandby())
            setNowAnim(Values.MAP_ANIM_STANDBY);
        try {
            MapAnims.MAP_ANIMS.get(nowAnim).DrawAnim(canvas, paint, xyTile, offsetX, offsetY);
        }catch (Exception e){
        }
    }

    public void lostCursor() {
        if (isStandby()) {
            setNowAnim(Values.MAP_ANIM_STANDBY);
        } else {
            setNowAnim(Values.MAP_ANIM_STATIC);
        }
    }

    public void getCursor() {
        if (isStandby()) {
            setNowAnim(Values.MAP_ANIM_STANDBY);
        } else if (party != Values.PARTY_PLAYER) {
            setNowAnim(Values.MAP_ANIM_STATIC);
        } else {
            setNowAnim(Values.MAP_ANIM_DYNAMIC);
        }
        GameView.cursorX = xyTile[0];
        GameView.cursorY = xyTile[1];
    }

    public int[] getXyTile() {
        return xyTile;
    }

    public void setXyTile(int[] xyTile) {
        this.xyTile = xyTile;
    }

    public int[] getXyPos() {
        return xyPos;
    }

    public void setXyPos(int[] xyPos) {
        this.xyPos = xyPos;
    }

    public String getActorKey() {
        return actorKey;
    }

    public void setActorKey(String actorKey) {
        this.actorKey = actorKey;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public int getMoveCost() {
        return MoveCost;
    }

    public void setMoveCost(int moveCost) {
        MoveCost = moveCost;
    }

    public String getMapAnimKey() {
        return mapAnimKey;
    }

    public void setMapAnimKey(String mapAnimKey) {
        this.mapAnimKey = mapAnimKey;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        Visible = visible;
    }

    public String getNowAnim() {
        return nowAnim;
    }

    public void setNowAnim(String nowAnim) {
        this.nowAnim = mapAnimKey + nowAnim;
    }

    public boolean equals(Actor actor) {
        if (actor == null)
            return false;
        return xyTile[0] == actor.getXyTile()[0] && xyTile[1] == actor.getXyTile()[1] && actorKey.equals(actor.getActorKey());
    }

    public int getParty() {
        return party;
    }

    public void setParty(int party) {
        this.party = party;
    }

    public boolean isStandby() {
        return Standby;
    }

    public void setStandby(boolean standby) {
        Standby = standby;
    }

    public Bitmap getFace() {
        return Face;
    }

    public void setFace(Bitmap face) {
        this.Face = face;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStr() {
        return Str;
    }

    public void setStr(int str) {
        Str = str;
    }

    public int getMag() {
        return Mag;
    }

    public void setMag(int mag) {
        Mag = mag;
    }

    public int getSkill() {
        return Skill;
    }

    public void setSkill(int skill) {
        Skill = skill;
    }

    public int getSpd() {
        return Spd;
    }

    public void setSpd(int spd) {
        Spd = spd;
    }

    public int getLuck() {
        return Luck;
    }

    public void setLuck(int luck) {
        Luck = luck;
    }

    public int getDef() {
        return Def;
    }

    public void setDef(int def) {
        Def = def;
    }

    public int getRes() {
        return Res;
    }

    public void setRes(int res) {
        Res = res;
    }

    public int getMove() {
        return Move;
    }

    public void setMove(int move) {
        Move = move;
    }

    public int getCon() {
        return Con;
    }

    public void setCon(int con) {
        Con = con;
    }

    public int getAid() {
        return Aid;
    }

    public void setAid(int aid) {
        Aid = aid;
    }

    public int getAffin() {
        return Affin;
    }

    public void setAffin(int affin) {
        Affin = affin;
    }

    public int getMount() {
        return Mount;
    }

    public void setMount(int mount) {
        Mount = mount;
        Aid = Mount>0?career.getMAX_CON()-Con:Con-1;
    }

    public int[] getStatus() {
        return Status;
    }

    public void setStatus(int[] status) {
        Status = status;
    }

    public int getMaxHPGrow() {
        return MaxHPGrow;
    }

    public void setMaxHPGrow(int maxHPGrow) {
        this.MaxHPGrow = maxHPGrow;
    }

    public int getStrGrow() {
        return StrGrow;
    }

    public void setStrGrow(int strGrow) {
        StrGrow = strGrow;
    }

    public int getMagGrow() {
        return MagGrow;
    }

    public void setMagGrow(int magGrow) {
        MagGrow = magGrow;
    }

    public int getSkillGrow() {
        return SkillGrow;
    }

    public void setSkillGrow(int skillGrow) {
        SkillGrow = skillGrow;
    }

    public int getSpdGrow() {
        return SpdGrow;
    }

    public void setSpdGrow(int spdGrow) {
        SpdGrow = spdGrow;
    }

    public int getLuckGrow() {
        return LuckGrow;
    }

    public void setLuckGrow(int luckGrow) {
        LuckGrow = luckGrow;
    }

    public int getDefGrow() {
        return DefGrow;
    }

    public void setDefGrow(int defGrow) {
        DefGrow = defGrow;
    }

    public int getResGrow() {
        return ResGrow;
    }

    public void setResGrow(int resGrow) {
        ResGrow = resGrow;
    }

    public int getSwordExp() {
        return SwordExp;
    }

    public void setSwordExp(int swordExp) {
        SwordExp = swordExp;
    }

    public int getLanceExp() {
        return LanceExp;
    }

    public void setLanceExp(int lanceExp) {
        LanceExp = lanceExp;
    }

    public int getAxeExp() {
        return AxeExp;
    }

    public void setAxeExp(int axeExp) {
        AxeExp = axeExp;
    }

    public int getBowExp() {
        return BowExp;
    }

    public void setBowExp(int bowExp) {
        BowExp = bowExp;
    }

    public int getAnimaExp() {
        return AnimaExp;
    }

    public void setAnimaExp(int animaExp) {
        AnimaExp = animaExp;
    }

    public int getDarkExp() {
        return DarkExp;
    }

    public void setDarkExp(int darkExp) {
        DarkExp = darkExp;
    }

    public int getStaffExp() {
        return StaffExp;
    }

    public void setStaffExp(int staffExp) {
        StaffExp = staffExp;
    }

    public int getLightExp() {
        return LightExp;
    }

    public void setLightExp(int lightExp) {
        LightExp = lightExp;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public int getHit() {
        return Hit;
    }

    public void setHit(int hit) {
        Hit = hit;
    }

    public int getAvoid() {
        return Avoid;
    }

    public void setAvoid(int avoid) {
        Avoid = avoid;
    }

    public int getCit() {
        return Cit;
    }

    public void setCit(int cit) {
        Cit = cit;
    }

    public int getAtkSpd() {
        return AtkSpd;
    }

    public void setAtkSpd(int atkSpd) {
        AtkSpd = atkSpd;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}