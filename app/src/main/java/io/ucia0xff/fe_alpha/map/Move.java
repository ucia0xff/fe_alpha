package io.ucia0xff.fe_alpha.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

import io.ucia0xff.fe_alpha.R;
import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.actor.Actor;
import io.ucia0xff.fe_alpha.anim.Animation;
import io.ucia0xff.fe_alpha.game.GameView;

public class Move {
    private int[] mapSize;//地图大小
    private int[][] mapTerrain;//地形
    private Actor srcActor;
    private Actor dstActor;
    private int actorMoveCost;//角色消耗类型
    private NodeList canMove;//移动范围
    private NodeList movePath;//移动路线
    private NodeList canUseStaff;//杖的使用范围
    private static int[][] DIRECTION = {//移动方向
            {0, -1},//上
            {1, 0},//右
            {0, 1},//下
            {-1, 0}//左
    };
    private Node startNode;//起始格子
    private Node nowNode;//当前格子
    private Node newNode;//下一个格子
    private Bitmap canMoveBlock;//能移动
    private Bitmap canUseStaffBlock;//能用杖

    //构造方法
    public Move(Context context) {
        canMove = new NodeList();
        movePath = new NodeList();
        canMoveBlock = Animation.ReadBitMap(context, R.drawable.block_blue);
    }

    public Move(Context context, Map map) {
        this(context);
        this.setMap(map);
    }

    public Move(Context context, Actor actor, Map map) {
        this(context, map);
        this.setActor(actor);
    }

    public void setActor(Actor actor) {
        srcActor = actor;
        actorMoveCost = actor.getMoveCost();
        startNode = new Node(srcActor.getXyTile());
        startNode.setMoveCost(0);
    }

    public void setMap(Map map) {
        mapSize = new int[]{map.getMapWidthTileCount(), map.getMapHeightTileCount()};
        mapTerrain = map.getTerrain();
    }

    //得到移动区域
    public void setCanMove() {
        canMove.clear();
        canMove.add(startNode);
        int[] nowXY;
        int[] newXY = new int[2];
        for (int i = 0; i < canMove.size(); i++) {
            nowNode = canMove.get(i);
            nowXY = nowNode.getPosition();
            for (int j = 0; j < DIRECTION.length; j++) {
                newXY[0] = nowXY[0] + DIRECTION[j][0];
                newXY[1] = nowXY[1] + DIRECTION[j][1];
                if (newXY[0] < 0 || newXY[1] < 0 || newXY[0] >= mapSize[0] || newXY[1] >= mapSize[1])//检查是否超出地图边界
                    continue;
                else {
                    newNode = new Node(newXY);
                    newNode.setParent(nowNode);
                    newNode.setMoveCost(newNode.getMoveCost() + nowNode.getMoveCost());
                    if (newNode.getMoveCost() <= srcActor.getMove()) {
                        dstActor = GameView.getActor(newXY[0], newXY[1]);
                        if (dstActor!=null) {
                            switch (srcActor.getParty()){
                                case Values.PARTY_ALLY:
                                case Values.PARTY_PLAYER:
                                    if (dstActor.getParty()==Values.PARTY_ENEMY)
                                        continue;
                                    break;
                                case Values.PARTY_ENEMY:
                                    if (dstActor.getParty()==Values.PARTY_PLAYER || dstActor.getParty()==Values.PARTY_ALLY)
                                        continue;
                                    break;
                            }
                        }
                        canMove.add(newNode);
                    }
                }
            }
        }
    }

    public NodeList getCanMove() {
        return canMove;
    }

    //得到移动路线
    public void setMovePath(int[] target) {
        movePath.clear();
        int index = canMove.find(target);
        nowNode = canMove.get(index);
        while (nowNode != startNode) {
            movePath.add(0, nowNode);
            nowNode = nowNode.getParent();
        }
    }

    public NodeList getMovePath(int[] target) {
        return movePath;
    }

    //显示移动区域
    public void DrawMoveArea(Canvas canvas, Paint paint, int offsetX, int offsetY) {
        setCanMove();
        int[] tmpXY;
        for (int i = 0; i < canMove.size(); i++) {
            tmpXY = canMove.get(i).getPosition();
            DrawBlock(canvas, paint, tmpXY[0] * Values.MAP_TILE_WIDTH + offsetX, tmpXY[1] * Values.MAP_TILE_HEIGHT + offsetY, 0);
        }
    }

    //绘制一个格子
    private void DrawBlock(Canvas canvas, Paint paint, int x, int y, int type) {
        canvas.drawBitmap(canMoveBlock, new Rect(0, 0, canMoveBlock.getWidth(), canMoveBlock.getHeight()), new Rect(x, y, x + Values.MAP_TILE_WIDTH, y+Values.MAP_TILE_HEIGHT), paint);
    }

    //到某格子的移动方向
    public String[] getMoveDirections(int[] target) {
        setMovePath(target);
        nowNode = startNode;
        int[] nowXY;
        int[] newXY;
        int dx, dy;
        String[] directions = new String[srcActor.getMove()];
        for (int i = 0; i < srcActor.getMove(); i++){
            directions[i] = "";
        }
        for (int i = 0; i < movePath.size(); i++) {
            nowXY = nowNode.getPosition();
            newNode = movePath.get(i);
            newXY = newNode.getPosition();
            dx = newXY[0] - nowXY[0];
            dy = newXY[1] - nowXY[1];
            if (dx == 0 && dy < 0)
                directions[i] = Values.MAP_ANIM_UP;
            else if (dx > 0 && dy == 0)
                directions[i] = Values.MAP_ANIM_RIGHT;
            else if (dx == 0 && dy > 0)
                directions[i] = Values.MAP_ANIM_DOWN;
            else if (dx < 0 && dy == 0)
                directions[i] = Values.MAP_ANIM_LEFT;
            nowNode = newNode;
        }
        return directions;
    }

    //得到杖的使用范围
    public void setCanUseStaff() {
        canUseStaff.clear();
    }


    //内部类——节点
    public class Node implements Comparable<Node> {
        private int[] position;//当前格子位置
        private int moveCost;//移动力消耗
        private int f;//g和h的和
        private int g;//从起始格子到当前格子的移动力消耗
        private int h;//从当前格子到终点格子的预估移动力消耗
        private Node parent;//路径上的父格子

        public Node(int[] position) {
            this.position = new int[2];
            this.position[0] = position[0];
            this.position[1] = position[1];
            this.moveCost = TerrainInfo.MOVE_COST[actorMoveCost][mapTerrain[position[1]][position[0]]];
            this.parent = null;
        }

        public boolean equals(int[] position) {
            return this.position[0] == position[0] && this.position[1] == position[1];
        }

        @Override
        public int compareTo(Node another) {
            int result = this.f - another.f;
            if (result == 0) {
                result = this.h - another.h;
                ;
            }
            return result;
        }

        public int[] getPosition() {
            return position;
        }

        public void setPosition(int[] position) {
            this.position = position;
        }

        public int getMoveCost() {
            return moveCost;
        }

        public void setMoveCost(int moveCost) {
            this.moveCost = moveCost;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    //内部类——节点链表
    public static class NodeList extends ArrayList<Node> {
        public boolean add(Node node) {
            if (size() == 0)
                super.add(node);
            else {
                int index = find(node.position);
                if (index != -1) {
                    if (node.getMoveCost() < get(index).getMoveCost()) {
                        remove(index);
                        super.add(node);
                        return true;
                    }
                    return false;
                } else super.add(node);
            }
            return true;
        }

        public int find(int[] position) {
            for (int i = size() - 1; i >= 0; i--) {
                Node node = get(i);
                if (node.equals(position)) {
                    return i;
                }
            }
            return -1;
        }

        public void insert(Node node) {
            for (int i = size(); i > 0; i--) {
                Node n = get(i - 1);
                if (node.compareTo(n) >= 0) {
                    add(i, node);
                    return;
                }
            }
            add(0, node);
        }

        public void sort(Node node) {
            for (int i = size() - 1; i >= 0; i--) {
                Node n = get(i);
                if (n == node) {
                    for (; i > 0; i--) {
                        n = get(i - 1);
                        if (node.compareTo(n) >= 0) {
                            return;
                        } else {
                            set(i, n);
                            set(i - 1, node);
                        }
                    }
                }
            }
        }
    }
}
