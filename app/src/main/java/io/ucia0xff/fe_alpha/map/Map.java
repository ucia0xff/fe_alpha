package io.ucia0xff.fe_alpha.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.ucia0xff.fe_alpha.Values;
import io.ucia0xff.fe_alpha.anim.Animation;

public class Map {
    //瓦片图集
    public static Bitmap res;

    //图集的宽高
    public static int resWidth = 0;
    public static int resHeight = 0;

    //地图的宽高
    public static int mapWidth = 0;
    public static int mapHeight = 0;

    //图集中横纵向瓦片块的数量
    public static int resWidthTileCount = 0;
    public static int resHeightTileCount = 0;

    //游戏中横纵向瓦片块的数量
    public static int mapWidthTileCount = 0;
    public static int mapHeightTileCount = 0;

    //在图集中的序号
    public static int[][] map;


    //瓦片对应的地形id
    public static int[][] terrain;

    public Map(Context context, String mapName) throws IOException {
        InputStream is = context.getAssets().open("map_config/" + mapName + ".map");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();//第一行是地图块集文件名
        String tilesetName = "tilesets/" + line + ".png";
        line = br.readLine();//第二行是地图高和宽
        String[] mapSize = line.split(" ");
        mapWidthTileCount = Integer.parseInt(mapSize[1]);
        mapHeightTileCount = Integer.parseInt(mapSize[0]);
        mapWidth = mapWidthTileCount * Values.MAP_TILE_WIDTH;
        mapHeight = mapHeightTileCount * Values.MAP_TILE_HEIGHT;

        //得到地图
        map = new int[mapHeightTileCount][mapWidthTileCount];
        String[] values;
        for (int i = 0; i < mapHeightTileCount && (line = br.readLine()) != null; i++) {
            values = line.split(" ");
            for (int j = 0; j < values.length; j++)
                map[i][j] = Integer.parseInt(values[j]);
        }
        is.close();

        //得到地形
        is = context.getAssets().open("map_config/" + mapName + ".terrain");
        br = new BufferedReader(new InputStreamReader(is));
        terrain = new int[mapHeightTileCount][mapWidthTileCount];
        for (int i = 0; i < mapHeightTileCount && (line = br.readLine()) != null; i++) {
            values = line.split(" ");
            for (int j = 0; j < values.length; j++)
                terrain[i][j] = Integer.parseInt(values[j]);
        }
        is.close();

        //得到地图块集
        initRes(context, tilesetName);
    }


    //初始化地图资源
    public void initRes(Context context, String tilesetName) throws IOException {
        res = Animation.ReadBitMap(context, tilesetName);
        resWidth = res.getWidth();
        resHeight = res.getHeight();
        resWidthTileCount = resWidth / Values.RES_TILE_WIDTH;
        resHeightTileCount = resHeight / Values.RES_TILE_HEIGHT;
    }

    //绘制游戏地图
    public static void DrawMap(Canvas canvas, Paint paint, int mapOffsetScreenX, int mapOffsetScreenY) {
        for (int i = 0; i < mapHeightTileCount; i++) {
            for (int j = 0; j < mapWidthTileCount; j++) {
                DrawMapTile(map[i][j], canvas, paint, res, j * Values.MAP_TILE_WIDTH + mapOffsetScreenX, i * Values.MAP_TILE_HEIGHT + mapOffsetScreenY);
            }
        }
    }

    //根据ID绘制一个地图块
    public static void DrawMapTile(int id, Canvas canvas, Paint paint, Bitmap bitmap, int x, int y) {
        //算出要绘制的地图块在地图资源中的XY 坐标
        int bitmapX = id % resWidthTileCount * Values.RES_TILE_WIDTH;//需要的地图块在地图资源中的X坐标
        int bitmapY = id / resWidthTileCount * Values.RES_TILE_HEIGHT;//需要的地图块在地图资源中的Y坐标

        if (canvas==null) return;
        canvas.save();
        canvas.clipRect(x, y, x + Values.MAP_TILE_WIDTH, y + Values.MAP_TILE_HEIGHT);
        canvas.drawBitmap(bitmap, new Rect(bitmapX, bitmapY, bitmapX + Values.RES_TILE_WIDTH, bitmapY + Values.RES_TILE_HEIGHT), new Rect(x, y, x + Values.MAP_TILE_WIDTH, y + Values.MAP_TILE_HEIGHT), paint);
        canvas.restore();
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeightTileCount() {
        return mapHeightTileCount;
    }

    public void setMapHeightTileCount(int mapHeightTileCount) {
        this.mapHeightTileCount = mapHeightTileCount;
    }

    public int getMapWidthTileCount() {
        return mapWidthTileCount;
    }

    public void setMapWidthTileCount(int mapWidthTileCount) {
        this.mapWidthTileCount = mapWidthTileCount;
    }

    public int getTerrain(int x,int y) {
        return terrain[y][x];
    }

    public void setTerrain(int[][] terrain) {
        this.terrain = terrain;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[][] getTerrain() {
        return terrain;
    }
}
