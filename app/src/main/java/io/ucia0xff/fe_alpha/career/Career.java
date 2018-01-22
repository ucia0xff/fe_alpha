package io.ucia0xff.fe_alpha.career;

import android.content.Context;
import android.graphics.Bitmap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.anim.Animation;

public class Career {
    //基本信息
    private String CAREER_KEY;//职业标识
    private String NAME;//职业名
    private String INFO;//职业说明
    private Bitmap FACE;//职业通用头像

    //移动消耗
    private int MOVE_COST = 0;//移动消耗类型

    //初始能力
    private int INIT_LEVEL = 0;//等级
    private int INIT_MAXHP = 0;//最大HP
    private int INIT_STR = 0;//力量
    private int INIT_MAG = 0;//魔力
    private int INIT_SKILL = 0;//技术
    private int INIT_SPD = 0;//速度
    private int INIT_LUCK = 0;//幸运
    private int INIT_DEF = 0;//守备
    private int INIT_RES = 0;//魔防
    private int INIT_MOVE = 0;//移动
    private int INIT_CON = 0;//体格
    private int INIT_AFFIN = 0;//体格
    private int INIT_MOUNT = 0;//坐骑

    //能力上限
    private int MAX_LEVEL = 0;//等级上限
    private int MAX_MAXHP = 0;//最大HP上限
    private int MAX_STR = 0;//力量上限
    private int MAX_MAG = 0;//魔力上限
    private int MAX_SKILL = 0;//技术上限
    private int MAX_SPD = 0;//速度上限
    private int MAX_LUCK = 0;//幸运上限
    private int MAX_DEF = 0;//守备上限
    private int MAX_RES = 0;//魔防上限
    private int MAX_MOVE = 0;//移动上限
    private int MAX_CON = 0;//体格上限

    //成长率
    private int GROW_MAXHP = 0;//HP
    private int GROW_STR = 0;//力量
    private int GROW_MAG = 0;//魔力
    private int GROW_SKILL = 0;//技术
    private int GROW_SPD = 0;//速度
    private int GROW_LUCK = 0;//幸运
    private int GROW_DEF = 0;//守备
    private int GROW_RES = 0;//魔防

    //初始武器熟练度
    private int EXP_SWORD = 0;//剑
    private int EXP_LANCE = 0;//枪
    private int EXP_AXE = 0;//斧
    private int EXP_BOW = 0;//弓
    private int EXP_STAFF = 0;//杖
    private int EXP_ANIMA = 0;//理
    private int EXP_LIGHT = 0;//光
    private int EXP_DARK = 0;//暗

    //最大武器熟练度
    private int MAX_EXP_SWORD = 0;
    private int MAX_EXP_LANCE = 0;
    private int MAX_EXP_AXE = 0;
    private int MAX_EXP_BOW = 0;
    private int MAX_EXP_STAFF = 0;
    private int MAX_EXP_ANIMA = 0;
    private int MAX_EXP_LIGHT = 0;
    private int MAX_EXP_DARK = 0;

    public Career(Context context, String careerName) throws Exception {
        InputStream in = context.getAssets().open("career_config/" + careerName +".xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        Element actor = document.getDocumentElement();//获得xml文件的根节点，即<Actor>
        NodeList tags = actor.getChildNodes();//获得根节点下的所有子节点
        for (int i = 0; i < tags.getLength(); i++) {
            if (tags.item(i).getNodeType() == Node.ELEMENT_NODE) {
                if ("CAREER_KEY".equals(tags.item(i).getNodeName())) {
                    CAREER_KEY = tags.item(i).getTextContent();
                }else if ("NAME".equals(tags.item(i).getNodeName())){
                    NAME = tags.item(i).getTextContent();
                }else if ("INFO".equals(tags.item(i).getNodeName())){
                    INFO = tags.item(i).getTextContent();
                }else if ("FACE".equals(tags.item(i).getNodeName())){
                    String fileName = tags.item(i).getTextContent();
                    if (fileName.trim().length() > 0) {
                        FACE = Animation.ReadBitMap(Values.CONTEXT, "faces/" + fileName);
                    } else {
                        FACE = Animation.ReadBitMap(Values.CONTEXT, "faces/Unknow.png");
                    }
                }else if ("MOVE_COST".equals(tags.item(i).getNodeName())){
                    MOVE_COST = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_LEVEL".equals(tags.item(i).getNodeName())){
                    INIT_LEVEL = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_MAXHP".equals(tags.item(i).getNodeName())){
                    INIT_MAXHP = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_STR".equals(tags.item(i).getNodeName())){
                    INIT_STR = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_MAG".equals(tags.item(i).getNodeName())){
                    INIT_MAG = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_SKILL".equals(tags.item(i).getNodeName())){
                    INIT_SKILL = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_SPD".equals(tags.item(i).getNodeName())){
                    INIT_SPD = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_LUCK".equals(tags.item(i).getNodeName())){
                    INIT_LUCK = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_DEF".equals(tags.item(i).getNodeName())){
                    INIT_DEF = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_RES".equals(tags.item(i).getNodeName())){
                    INIT_RES = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_MOVE".equals(tags.item(i).getNodeName())){
                    INIT_MOVE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_CON".equals(tags.item(i).getNodeName())){
                    INIT_CON = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_AFFIN".equals(tags.item(i).getNodeName())){
                    INIT_AFFIN = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("INIT_MOUNT".equals(tags.item(i).getNodeName())){
                    INIT_MOUNT = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_LEVEL".equals(tags.item(i).getNodeName())){
                    MAX_LEVEL = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_MAXHP".equals(tags.item(i).getNodeName())){
                    MAX_MAXHP = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_STR".equals(tags.item(i).getNodeName())){
                    MAX_STR = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_MAG".equals(tags.item(i).getNodeName())){
                    MAX_MAG = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_SKILL".equals(tags.item(i).getNodeName())){
                    MAX_SKILL = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_SPD".equals(tags.item(i).getNodeName())){
                    MAX_SPD = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_LUCK".equals(tags.item(i).getNodeName())){
                    MAX_LUCK = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_DEF".equals(tags.item(i).getNodeName())){
                    MAX_DEF = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_RES".equals(tags.item(i).getNodeName())){
                    MAX_RES = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_MOVE".equals(tags.item(i).getNodeName())){
                    MAX_MOVE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_CON".equals(tags.item(i).getNodeName())){
                    MAX_CON = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_MAXHP".equals(tags.item(i).getNodeName())){
                    GROW_MAXHP = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_STR".equals(tags.item(i).getNodeName())){
                    GROW_STR = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_MAG".equals(tags.item(i).getNodeName())){
                    GROW_MAG = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_SKILL".equals(tags.item(i).getNodeName())){
                    GROW_SKILL = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_SPD".equals(tags.item(i).getNodeName())){
                    GROW_SPD = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_LUCK".equals(tags.item(i).getNodeName())){
                    GROW_LUCK = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_DEF".equals(tags.item(i).getNodeName())){
                    GROW_DEF = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("GROW_RES".equals(tags.item(i).getNodeName())){
                    GROW_RES = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_SWORD".equals(tags.item(i).getNodeName())){
                    EXP_SWORD = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_LANCE".equals(tags.item(i).getNodeName())){
                    EXP_LANCE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_AXE".equals(tags.item(i).getNodeName())){
                    EXP_AXE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_BOW".equals(tags.item(i).getNodeName())){
                    EXP_BOW = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_SATFF".equals(tags.item(i).getNodeName())){
                    EXP_STAFF = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_ANIMA".equals(tags.item(i).getNodeName())){
                    EXP_ANIMA = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_LIGHT".equals(tags.item(i).getNodeName())){
                    EXP_LIGHT = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("EXP_DARK".equals(tags.item(i).getNodeName())){
                    EXP_DARK = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_SWORD".equals(tags.item(i).getNodeName())){
                    MAX_EXP_SWORD = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_LANCE".equals(tags.item(i).getNodeName())){
                    MAX_EXP_LANCE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_AXE".equals(tags.item(i).getNodeName())){
                    MAX_EXP_AXE = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_BOW".equals(tags.item(i).getNodeName())){
                    MAX_EXP_BOW = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_SATFF".equals(tags.item(i).getNodeName())){
                    MAX_EXP_STAFF = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_ANIMA".equals(tags.item(i).getNodeName())){
                    MAX_EXP_ANIMA = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_LIGHT".equals(tags.item(i).getNodeName())){
                    MAX_EXP_LIGHT = Integer.parseInt(tags.item(i).getTextContent());
                }else if ("MAX_EXP_DARK".equals(tags.item(i).getNodeName())){
                    MAX_EXP_DARK = Integer.parseInt(tags.item(i).getTextContent());
                }
            }
        }
        in.close();
    }

    public String getCAREER_KEY() {
        return CAREER_KEY;
    }

    public String getNAME() {
        return NAME;
    }

    public String getINFO() {
        return INFO;
    }

    public Bitmap getFACE() {
        return FACE;
    }

    public int getMOVE_COST() {
        return MOVE_COST;
    }

    public int getINIT_LEVEL() {
        return INIT_LEVEL;
    }

    public int getINIT_MAXHP() {
        return INIT_MAXHP;
    }

    public int getINIT_STR() {
        return INIT_STR;
    }

    public int getINIT_MAG() {
        return INIT_MAG;
    }

    public int getINIT_SKILL() {
        return INIT_SKILL;
    }

    public int getINIT_SPD() {
        return INIT_SPD;
    }

    public int getINIT_LUCK() {
        return INIT_LUCK;
    }

    public int getINIT_DEF() {
        return INIT_DEF;
    }

    public int getINIT_RES() {
        return INIT_RES;
    }

    public int getINIT_MOVE() {
        return INIT_MOVE;
    }

    public int getINIT_CON() {
        return INIT_CON;
    }

    public int getINIT_AFFIN() {
        return INIT_AFFIN;
    }

    public int getINIT_MOUNT() {
        return INIT_MOUNT;
    }

    public int getMAX_LEVEL() {
        return MAX_LEVEL;
    }

    public int getMAX_MAXHP() {
        return MAX_MAXHP;
    }

    public int getMAX_STR() {
        return MAX_STR;
    }

    public int getMAX_MAG() {
        return MAX_MAG;
    }

    public int getMAX_SKILL() {
        return MAX_SKILL;
    }

    public int getMAX_SPD() {
        return MAX_SPD;
    }

    public int getMAX_LUCK() {
        return MAX_LUCK;
    }

    public int getMAX_DEF() {
        return MAX_DEF;
    }

    public int getMAX_RES() {
        return MAX_RES;
    }

    public int getMAX_MOVE() {
        return MAX_MOVE;
    }

    public int getMAX_CON() {
        return MAX_CON;
    }

    public int getGROW_MAXHP() {
        return GROW_MAXHP;
    }

    public int getGROW_STR() {
        return GROW_STR;
    }

    public int getGROW_MAG() {
        return GROW_MAG;
    }

    public int getGROW_SKILL() {
        return GROW_SKILL;
    }

    public int getGROW_SPD() {
        return GROW_SPD;
    }

    public int getGROW_LUCK() {
        return GROW_LUCK;
    }

    public int getGROW_DEF() {
        return GROW_DEF;
    }

    public int getGROW_RES() {
        return GROW_RES;
    }

    public int getEXP_SWORD() {
        return EXP_SWORD;
    }

    public int getEXP_LANCE() {
        return EXP_LANCE;
    }

    public int getEXP_AXE() {
        return EXP_AXE;
    }

    public int getEXP_BOW() {
        return EXP_BOW;
    }

    public int getEXP_STAFF() {
        return EXP_STAFF;
    }

    public int getEXP_ANIMA() {
        return EXP_ANIMA;
    }

    public int getEXP_LIGHT() {
        return EXP_LIGHT;
    }

    public int getEXP_DARK() {
        return EXP_DARK;
    }

    public int getMAX_EXP_SWORD() {
        return MAX_EXP_SWORD;
    }

    public int getMAX_EXP_LANCE() {
        return MAX_EXP_LANCE;
    }

    public int getMAX_EXP_AXE() {
        return MAX_EXP_AXE;
    }

    public int getMAX_EXP_BOW() {
        return MAX_EXP_BOW;
    }

    public int getMAX_EXP_STAFF() {
        return MAX_EXP_STAFF;
    }

    public int getMAX_EXP_ANIMA() {
        return MAX_EXP_ANIMA;
    }

    public int getMAX_EXP_LIGHT() {
        return MAX_EXP_LIGHT;
    }

    public int getMAX_EXP_DARK() {
        return MAX_EXP_DARK;
    }
}
