package io.ucia0xff.fe_alpha.map;

//地形信息
public class TerrainInfo {
    public static final String[] TERRAIN_NAME = {
            "——",//00
            "平地",//01
            "道路",//02
            "村庄",//03
            "已关闭",//04
            "民家",//05
            "武器店",//06
            "道具店",//07
            "斗技场",//08
            "运输队",//09？？WTF
            "要塞",//10
            "城门",//11
            "森林",//12
            "密林",//13
            "沙地",//14
            "沙漠",//15
            "河",//16
            "山",//17
            "高山",//18
            "桥",//19
            "吊桥",//20？？WTF
            "海",//21
            "湖",//22
            "地板",//23
            "地板",//24？？WTF
            "围墙",//25
            "墙壁",//26
            "墙壁",//27可破坏的墙壁
            "被破坏的墙壁",//28可通过？？WTF
            "柱子",//28
            "门",//30
            "宝座",//31
            "空宝箱",//32
            "宝箱",//33
            "屋顶",//34
            "大门",//35
            "教会",//36
            "废墟",//37
            "悬崖",//38
            "长弩",//39？？WTF
            "钢铁弩",//40？？WTF
            "必杀弩",//41？？WTF
            "荒地",//42
            "破坏的民家",//43？？WTF
            "——",//44城堡外圈
            "楼梯",//45
            "——",//46村庄外圈
            "冰河",//47
            "通信斗技场",//48？？WTF
            "山谷",//49
            "围墙",//50？？WTF
            "古树",//51
            "圆木桥",//52
            "天空",//53？？WTF
            "深海",//54？？WTF
            "遗迹",//55
            "酒馆",//56
            "桶",//57
            "骨",//58
            "暗",//59？？WTF
            "水",//60
            "船舷",//61
            "甲板",//62
            "支柱",//63
            "桅杆",//64
            "垛口",//65？？WTF
    };
    public static final int[][] TERRAIN_EFFECT = {
            //回避，守备，魔防，回复(%)
            {0, 0, 0, 0},//0--
            {0, 0, 0, 0},//1平地
            {0, 0, 0, 0},//2道路
            {10, 0, 0, 0},//3村庄
            {10, 0, 0, 0},//4已关闭
            {10, 0, 0, 0},//5民家
            {10, 0, 0, 0},//6武器店
            {10, 0, 0, 0},//7道具店
            {10, 0, 0, 0},//8斗技场
            {10, 0, 0, 0},//9运输队
            {20, 2, 0, 20},//10要塞
            {20, 3, 0, 10},//11城门
            {20, 1, 0, 0},//12森林
            {30, 2, 0, 0},//13密林
            {5, 0, 0, 0},//14沙地
            {5, 0, 0, 0},//15沙漠
            {0, 0, 0, 0},//16河
            {30, 1, 0, 0},//17山
            {40, 2, 0, 0},//18高山
            {0, 0, 0, 0},//19桥
            {0, 0, 0, 0},//20吊桥
            {10, 0, 0, 0},//21海
            {10, 0, 0, 0},//22湖
            {0, 0, 0, 0},//23地板
            {0, 0, 10, 0},//24地板？？WTF
            {20, 1, 0, 0},//25围墙
            {20, 1, 0, 0},//26墙壁
            {0, 0, 0, 0},//27墙壁(可破坏)
            {0, 0, 0, 0},//28被破坏的墙壁？？WTF
            {20, 1, 0, 0},//29柱子
            {0, 0, 0, 0},//30门
            {30, 3, 5, 10},//31宝座
            {0, 0, 0, 0},//32空宝箱
            {0, 0, 0, 0},//33宝箱
            {0, 0, 0, 0},//34屋顶
            {30, 3, 0, 10},//35大门
            {15, 0, 0, 10},//36教会？？WTF
            {0, 0, 0, 0},//37废墟
            {0, 0, 0, 0},//38悬崖
            {5, 0, 0, 0},//39长弩？？WTF
            {5, 0, 0, 0},//40钢铁弩？？WTF
            {5, 0, 0, 0},//41必杀弩？？WTF
            {0, 0, 0, 0},//42荒地
            {0, 0, 0, 0},//43破坏的民家？？WTF
            {0, 0, 0, 0},//44——(城堡外围)
            {0, 0, 0, 0},//45楼梯
            {0, 0, 0, 0},//46——(村庄外围)
            {0, 0, 0, 0},//47冰河
            {0, 0, 0, 0},//48通信斗技场？？WTF
            {20, 1, 0, 0},//49山谷
            {20, 1, 0, 0},//50围墙？？WTF
            {0, 0, 0, 0},//51古树
            {0, 0, 0, 0},//52圆木桥
            {0, 0, 0, 0},//53天空？？WTF
            {0, 0, 0, 0},//54深海
            {10, 0, 0, 0},//55遗迹
            {10, 0, 0, 0},//56酒馆
            {0, 0, 0, 0},//57桶
            {0, 0, 0, 0},//58骨
            {0, 0, 0, 0},//59暗
            {10, 0, 0, 0},//60水
            {0, 0, 0, 0},//61船舷
            {0, 0, 0, 0},//62甲板
            {20, 1, 0, 0},//63支柱
            {20, 1, 0, 0},//64桅杆
    };
    public static final int[][] MOVE_COST = {
            {//0下位步兵系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    255,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//1上位步兵系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    5,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//2下位骑兵系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    3,//12森林
                    255,//13密林
                    1,//14沙地
                    4,//15沙漠
                    255,//16河
                    255,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    2,//28被破坏的墙壁？？WTF
                    3,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//3上位骑兵系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    3,//12森林
                    255,//13密林
                    1,//14沙地
                    4,//15沙漠
                    255,//16河
                    6,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    2,//28被破坏的墙壁？？WTF
                    3,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//4下位弓骑系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    3,//15沙漠
                    255,//16河
                    255,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    2,//28被破坏的墙壁？？WTF
                    3,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//5上位弓骑系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    3,//15沙漠
                    5,//16河
                    6,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    2,//28被破坏的墙壁？？WTF
                    3,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//6重甲系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    3,//15沙漠
                    255,//16河
                    255,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//7贼系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    5,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//8飞行系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    1,//10要塞
                    1,//11城门
                    1,//12森林
                    1,//13密林
                    1,//14沙地
                    1,//15沙漠
                    1,//16河
                    1,//17山
                    1,//18高山
                    1,//19桥
                    1,//20吊桥
                    1,//21海
                    1,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    1,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    1,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    1,//37废墟
                    1,//38悬崖
                    1,//39长弩？？WTF
                    1,//40钢铁弩？？WTF
                    1,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    1,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    1,//49山谷
                    1,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    1,//53天空
                    1,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    1,//57桶
                    1,//58骨
                    1,//59暗
                    1,//60水
                    1,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//9魔法系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    1,//15沙漠
                    255,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//10战士系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    3,//15沙漠
                    255,//16河
                    3,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//11山系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    5,//16河
                    3,//17山
                    4,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//12海系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    2,//16河
                    3,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    2,//21海
                    3,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    3,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//13狂战士系
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    2,//16河
                    3,//17山
                    4,//18高山
                    1,//19桥
                    255,//20吊桥
                    2,//21海
                    3,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    3,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//14魔王&远古火龙&冰龙&神龙&火龙&魔龙
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    255,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    1,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    2,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    1,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    1,//50围墙？？WTF
                    1,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//15其他非战斗单位
                    255,//0--
                    1,//1平地
                    1,//2道路
                    1,//3村庄
                    255,//4已关闭
                    1,//5民家
                    1,//6武器店
                    1,//7道具店
                    1,//8斗技场
                    1,//9运输队
                    2,//10要塞
                    1,//11城门
                    2,//12森林
                    255,//13密林
                    1,//14沙地
                    2,//15沙漠
                    255,//16河
                    4,//17山
                    255,//18高山
                    1,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    1,//23地板
                    1,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    1,//28被破坏的墙壁？？WTF
                    2,//29柱子
                    255,//30门
                    1,//31宝座
                    1,//32空宝箱
                    1,//33宝箱
                    255,//34屋顶
                    1,//35大门
                    1,//36教会
                    2,//37废墟
                    255,//38悬崖
                    2,//39长弩？？WTF
                    2,//40钢铁弩？？WTF
                    2,//41必杀弩？？WTF
                    1,//42荒地
                    1,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    1,//45楼梯
                    255,//46——(村庄外围)
                    1,//47冰河
                    1,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    1,//52圆木桥
                    255,//53天空
                    255,//54深海
                    1,//55遗迹
                    1,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    1,//62甲板
                    255,//63支柱
                    255,//64桅杆
            },
            {//16弩车
                    255,//0--
                    0,//1平地
                    0,//2道路
                    255,//3村庄
                    255,//4已关闭
                    255,//5民家
                    255,//6武器店
                    255,//7道具店
                    255,//8斗技场
                    255,//9运输队
                    255,//10要塞
                    255,//11城门
                    255,//12森林
                    255,//13密林
                    255,//14沙地
                    255,//15沙漠
                    255,//16河
                    255,//17山
                    255,//18高山
                    255,//19桥
                    255,//20吊桥
                    255,//21海
                    255,//22湖
                    255,//23地板
                    255,//24地板？？WTF
                    255,//25围墙
                    255,//26墙壁
                    255,//27墙壁(可破坏)
                    255,//28被破坏的墙壁？？WTF
                    255,//29柱子
                    255,//30门
                    255,//31宝座
                    255,//32空宝箱
                    255,//33宝箱
                    255,//34屋顶
                    255,//35大门
                    255,//36教会
                    255,//37废墟
                    255,//38悬崖
                    255,//39长弩？？WTF
                    255,//40钢铁弩？？WTF
                    255,//41必杀弩？？WTF
                    255,//42荒地
                    255,//43被破坏的民家？？WTF
                    255,//44——(城堡外围)
                    255,//45楼梯
                    255,//46——(村庄外围)
                    255,//47冰河
                    255,//48通信斗技场？？WTF
                    255,//49山谷
                    255,//50围墙？？WTF
                    255,//51古树
                    255,//52圆木桥
                    255,//53天空
                    255,//54深海
                    255,//55遗迹
                    255,//56酒馆
                    255,//57桶
                    255,//58骨
                    255,//59暗
                    255,//60水
                    255,//61船舷
                    255,//62甲板
                    255,//63支柱
                    255,//64桅杆
            }
    };
}
