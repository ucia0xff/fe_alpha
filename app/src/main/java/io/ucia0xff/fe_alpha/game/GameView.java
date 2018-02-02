package io.ucia0xff.fe_alpha.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder;

import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.actor.Actor;
import io.ucia0xff.fe_alpha.actor.ActorInfoPanel;
import io.ucia0xff.fe_alpha.anim.CursorAnim;
import io.ucia0xff.fe_alpha.anim.CursorAnims;
import io.ucia0xff.fe_alpha.map.Map;
import io.ucia0xff.fe_alpha.map.Move;
import io.ucia0xff.fe_alpha.map.TerrainInfoPanel;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, Runnable {
    public static int parties;//阵营总数
    public static int nowParty = 0;//当前行动的阵营
    public static Actor[] actors;
    public static Actor selectedActor;//当前角色
    public static Actor targetActor;//目标角色
    Map map;
    TerrainInfoPanel terrainInfoPanel;
    ActorInfoPanel actorInfoPanel;
    CursorAnim cursor;
    Move move;
    GameOptions gameOptions;
    Move.Node targetNode;//移动地点

    //画笔
    private Paint paint = null;

    //画布
    private Canvas canvas = null;

    // 游戏主线程
    private Thread thread = null;

    // 线程循环标志
    private boolean isRunning = false;

    private SurfaceHolder surfaceHolder = null;

    //手势解析器
    private GestureDetector gestureDetector;

    //游戏地图左上角对屏幕左上角的偏移量
    public static int mapOffsetScreenX = 0;
    public static int mapOffsetScreenY = 0;

    //单击点在屏幕上的位置
    private int xInScreen;
    private int yInScreen;

    //是否在屏幕某区域
    private Boolean isLeft = true;
    private Boolean isDown = true;

    //单击点在地图上的位置
    private int xInMap;
    private int yInMap;

    //单击点在地图数组中的坐标
    private int xInArray;
    private int yInArray;

    //光标在地图数组中的坐标
    public static int cursorX = 0;
    public static int cursorY = 0;

    //游戏进行阶段
    public static int GAME_CASE = Values.CASE_NORMAL;

    //移动方向
    public static String[] directions;
    public static int dirIndex = 0;

    //构造方法
    public GameView(Context context) {
        super(context);
        paint = new Paint();
        paint.setTextSize(80);
        paint.setColor(Color.WHITE);
        actors = new Actor[2];
        try {
            actors[0] = new Actor(context, "Natasha");
            actors[1] = new Actor(context, "Priscilla");

            map = new Map(context, "map1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setParties(actors);
        terrainInfoPanel = new TerrainInfoPanel(context, map);
        actorInfoPanel = new ActorInfoPanel(context);
        move = new Move(context, map);
        gameOptions = new GameOptions(context);

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setClickable(true);
        setFocusable(true);
        gestureDetector = new GestureDetector(this);
        setOnTouchListener(this);
    }

    //绘制游戏画面
    protected void Draw() {
        setParties(actors);
        switch (GAME_CASE) {
            case Values.CASE_NORMAL:
                map.DrawMap(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawActors(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawCursor(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                terrainInfoPanel.DisplayTileInfo(canvas, paint, isLeft);
                break;
            case Values.CASE_BEFORE_MOVE:
                map.DrawMap(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawMoveArea(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawActors(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawCursor(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                break;
            case Values.CASE_MOVING:
                map.DrawMap(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawActors(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                Moving(selectedActor);
                break;
            case Values.CASE_AFTER_MOVE:
                map.DrawMap(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawActors(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DisplayActorOptions(selectedActor);
                break;
            case Values.CASE_BEFORE_ACT:
                break;
            case Values.CASE_SHOW_ACTOR_INFO:
                actorInfoPanel.DisplayActorInfo(canvas, paint, selectedActor);
                break;
            case Values.CASE_SHOW_GAME_OPTIONS:
                map.DrawMap(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DrawActors(canvas, paint, mapOffsetScreenX, mapOffsetScreenY);
                DisplayGameOptions(canvas, paint, isLeft);
                break;
        }
    }

    private void DrawActors(Canvas canvas, Paint paint, int offsetX, int offsetY){
        for (Actor actor : actors) {
            if (actor.equals(selectedActor))
                continue;
            actor.RenderAnimation(canvas, paint, offsetX, offsetY);
        }
        if (selectedActor!=null)
            selectedActor.RenderAnimation(canvas, paint, offsetX, offsetY);
    }

    //显示光标
    private void DrawCursor(Canvas canvas, Paint paint, int offsetX, int offsetY) {
        selectedActor = getActor(cursorX, cursorY);
        if (selectedActor==null || selectedActor.getParty() != Values.PARTY_PLAYER || selectedActor.isStandby()) {
            cursor = CursorAnims.CURSOR_ANIMS.get(Values.CURSOR_DYNAMIC);
        } else {
            cursor = CursorAnims.CURSOR_ANIMS.get(Values.CURSOR_STATIC);
            selectedActor.getCursor();
        }
        cursor.DrawAnim(canvas, paint, new int[]{cursorX, cursorY},offsetX, offsetY);
    }

    //显示移动区域
    public void DrawMoveArea(Canvas canvas, Paint paint, int offsetX, int offsetY) {
        if (selectedActor == null) return;
        move.setActor(selectedActor);
        move.DrawMoveArea(canvas, paint, offsetX, offsetY);
    }


    //显示行动选项
    public void DisplayActorOptions(Actor actor) {
        actor.setStandby(true);
        cursorX = actor.getXyTile()[0];
        cursorY = actor.getXyTile()[1];
        GAME_CASE = Values.CASE_NORMAL;
    }

    //显示游戏选项
    public void DisplayGameOptions(Canvas canvas, Paint paint, Boolean isLeft){
        if (GAME_CASE!=Values.CASE_SHOW_GAME_OPTIONS) return;
        gameOptions.DisplayGameOptions(canvas, paint, isLeft);
    }

    //长按
    @Override
    public void onLongPress(MotionEvent e) {
//        if (nowParty!=Values.PARTY_PLAYER)
//            return;
        xInScreen = (int) e.getX();
        yInScreen = (int) e.getY();
        xInMap = xInScreen - mapOffsetScreenX;
        yInMap = yInScreen - mapOffsetScreenY;
        xInArray = xInMap / Values.MAP_TILE_WIDTH;
        yInArray = yInMap / Values.MAP_TILE_HEIGHT;
        switch (GAME_CASE) {
            case Values.CASE_NORMAL:
                cursorX = xInArray;
                cursorY = yInArray;
                if (selectedActor != null)
                    selectedActor.lostCursor();
                selectedActor = getActor(cursorX, cursorY);
                if (selectedActor != null) {
                    selectedActor.getCursor();
                    GAME_CASE = Values.CASE_SHOW_ACTOR_INFO;//游戏进入显示角色信息阶段
                }
                break;
            default:
                break;
        }
    }


    //单击
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
//        if (nowParty!=Values.PARTY_PLAYER)
//            return true;
        xInScreen = (int) e.getX();
        yInScreen = (int) e.getY();
        xInMap = xInScreen - mapOffsetScreenX;
        yInMap = yInScreen - mapOffsetScreenY;
        xInArray = xInMap / Values.MAP_TILE_WIDTH;
        yInArray = yInMap / Values.MAP_TILE_HEIGHT;
        targetActor = getActor(xInArray, yInArray);
        switch (GAME_CASE) {
            //一般阶段
            case Values.CASE_NORMAL:
                cursorX = xInArray;
                cursorY = yInArray;
                if (selectedActor != null)
                    selectedActor.lostCursor();
                selectedActor = getActor(cursorX, cursorY);
                if (selectedActor != null)
                    selectedActor.getCursor();
                isLeft = (xInScreen < Values.SCREEN_WIDTH / 2) ? true : false;
                isDown = (yInScreen > Values.SCREEN_HEIGHT / 2) ? true : false;
                break;
            //移动前
            case Values.CASE_BEFORE_MOVE:
                Move.NodeList canMove = move.getCanMove();
                if (selectedActor.getParty() == Values.PARTY_PLAYER && canMove.find(new int[]{xInArray, yInArray}) != -1) {
                    if (targetActor == null || targetActor.equals(selectedActor)) {//格子上没有单位或者是自己
                        directions = move.getMoveDirections(new int[]{xInArray, yInArray});
                        GAME_CASE = Values.CASE_MOVING;
                    }
                    else{//格子上有单位且不是自己
                        cursorX = xInArray;
                        cursorY = yInArray;
                        selectedActor.lostCursor();
                        selectedActor=targetActor;
                        selectedActor.getCursor();
                        GAME_CASE = Values.CASE_NORMAL;
                    }
                }else {//非玩家单位
                    cursorX = xInArray;
                    cursorY = yInArray;
                    selectedActor.lostCursor();
                    selectedActor = targetActor;
                    if (selectedActor != null)
                        selectedActor.getCursor();
                    GAME_CASE = Values.CASE_NORMAL;
                }
                isLeft = (xInScreen < Values.SCREEN_WIDTH / 2) ? true : false;
                isDown = (yInScreen > Values.SCREEN_HEIGHT / 2) ? true : false;
                break;
            //显示角色信息
            case Values.CASE_SHOW_ACTOR_INFO:
                break;
            case Values.CASE_MOVING:
                break;
            case Values.CASE_SHOW_GAME_OPTIONS:
                if (gameOptions.CheckOption(xInScreen, yInScreen, isLeft) > GameOptions.OPTIONS.length){
                    GAME_CASE = Values.CASE_NORMAL;
                }
                break;
            default:
                GAME_CASE = Values.CASE_NORMAL;
        }
        return true;
    }

    //双击
    @Override
    public boolean onDoubleTap(MotionEvent e) {
//        if (nowParty!=Values.PARTY_PLAYER)
//            return true;
        xInScreen = (int) e.getX();
        yInScreen = (int) e.getY();
        xInMap = xInScreen - mapOffsetScreenX;
        yInMap = yInScreen - mapOffsetScreenY;
        xInArray = xInMap / Values.MAP_TILE_WIDTH;
        yInArray = yInMap / Values.MAP_TILE_HEIGHT;
        switch (GAME_CASE) {
            case Values.CASE_NORMAL:
                cursorX = xInArray;
                cursorY = yInArray;
                if (selectedActor != null)
                    selectedActor.lostCursor();
                selectedActor = getActor(cursorX, cursorY);
                if (selectedActor == null || selectedActor.isStandby()) {
                    GAME_CASE = Values.CASE_SHOW_GAME_OPTIONS;
                }else{
                    selectedActor.getCursor();
                    if (selectedActor.getParty() == Values.PARTY_PLAYER){
                        selectedActor.setNowAnim(Values.MAP_ANIM_DOWN);
                    }
                    GAME_CASE = Values.CASE_BEFORE_MOVE;
                }
                isLeft = (xInScreen < Values.SCREEN_WIDTH / 2) ? true : false;
                isDown = (yInScreen > Values.SCREEN_HEIGHT / 2) ? true : false;
                break;
            case Values.CASE_SHOW_GAME_OPTIONS:
                gameOptions.HandleOption(xInScreen,yInScreen,isLeft);
                GAME_CASE = Values.CASE_NORMAL;
                break;
            case Values.CASE_SHOW_ACTOR_INFO:
                GAME_CASE = Values.CASE_NORMAL;
            default:
                break;
        }
        return true;
    }

    //在屏幕上拖动
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        switch (GAME_CASE) {
            case Values.CASE_NORMAL:
            case Values.CASE_BEFORE_MOVE:
            case Values.CASE_MOVING:
            case Values.CASE_AFTER_MOVE:
            case Values.CASE_BEFORE_ACT:
            case Values.CASE_SELECT_ITEM:
                if (mapOffsetScreenX - (int) distanceX + map.getMapWidth() <= Values.SCREEN_WIDTH)//最右
                    mapOffsetScreenX = -(map.getMapWidth() - Values.SCREEN_WIDTH);
                else if (mapOffsetScreenX - (int) distanceX >= 0)//最左
                    mapOffsetScreenX = 0;
                else mapOffsetScreenX -= (int) distanceX;

                if (mapOffsetScreenY - (int) distanceY + map.getMapHeight() <= Values.SCREEN_HEIGHT)//最下
                    mapOffsetScreenY = -(map.getMapHeight() - Values.SCREEN_HEIGHT);
                else if (mapOffsetScreenY - (int) distanceY >= 0)//最上
                    mapOffsetScreenY = 0;
                else mapOffsetScreenY -= (int) distanceY;
                break;
            case Values.CASE_SHOW_ACTOR_INFO:
                break;
            default:
        }
        return true;
    }

    //回合结束
    public static void TurnOver(){
        for (Actor actor:actors){
            actor.setStandby(false);
            actor.setNowAnim(Values.MAP_ANIM_STATIC);
        }
        nowParty = (nowParty+1)%parties;
    }

    //移动过程
    public void Moving(Actor actor) {
        int[] actorXY = actor.getXyTile();
        if (dirIndex < actor.getMove()) {
            switch (directions[dirIndex]) {
                case Values.MAP_ANIM_UP:
                    actorXY[1] -= 1;
                    actor.setNowAnim(Values.MAP_ANIM_UP);
                    actor.setXyTile(actorXY);
                    dirIndex++;
                    break;
                case Values.MAP_ANIM_RIGHT:
                    actorXY[0] += 1;
                    actor.setNowAnim(Values.MAP_ANIM_RIGHT);
                    actor.setXyTile(actorXY);
                    dirIndex++;
                    break;
                case Values.MAP_ANIM_DOWN:
                    actorXY[1] += 1;
                    actor.setNowAnim(Values.MAP_ANIM_DOWN);
                    actor.setXyTile(actorXY);
                    dirIndex++;
                    break;
                case Values.MAP_ANIM_LEFT:
                    actorXY[0] -= 1;
                    actor.setNowAnim(Values.MAP_ANIM_LEFT);
                    actor.setXyTile(actorXY);
                    dirIndex++;
                    break;
                default:
                    GAME_CASE = Values.CASE_AFTER_MOVE;//未达到最大移动力或通过复杂地形的移动结束
                    dirIndex = 0;//复位
            }
        } else {
            GAME_CASE = Values.CASE_AFTER_MOVE;//达到最大移动力的移动结束
            dirIndex = 0;//复位
        }
    }

    public void setParties(Actor[] actors){
        parties = 0;
        int[] partyCount = new int[Values.PARTY_COUNT];
        for (Actor actor:actors){
            partyCount[actor.getParty()]++;
        }
        for (int n:partyCount){
            if (n>0) parties++;
        }
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    public int getMapOffsetScreenX() {
        return mapOffsetScreenX;
    }

    public void setMapOffsetScreenX(int mapOffsetScreenX) {
        this.mapOffsetScreenX = mapOffsetScreenX;
    }

    public int getMapOffsetScreenY() {
        return mapOffsetScreenY;
    }

    public void setMapOffsetScreenY(int mapOffsetScreenY) {
        this.mapOffsetScreenY = mapOffsetScreenY;
    }

    @Override
    public void run() {
        while (isRunning) {
//            控制刷新率
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            //在这里加上线程安全锁
            synchronized (surfaceHolder) {
                /**拿到当前画布 然后锁定**/
                canvas = surfaceHolder.lockCanvas();
                Draw();
                /**绘制结束后解锁显示在屏幕上**/
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        return false;
    }

    //判断单击点是否有角色
    public static Actor getActor(int xTile, int yTile) {
        for (Actor actor : actors)
            if (actor.getXyTile()[0] == xTile && actor.getXyTile()[1] == yTile)
                return actor;
        return null;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        switch (GAME_CASE){
            case Values.CASE_SHOW_ACTOR_INFO:
                if (e2.getX()-e1.getX()>200)
                    actorInfoPanel.TurnLeft();
                else if (e2.getX()-e1.getX()<-200)
                    actorInfoPanel.TurnRight();
                break;
        }
        return true;
    }
}
