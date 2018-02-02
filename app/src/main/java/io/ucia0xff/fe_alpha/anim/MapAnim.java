package io.ucia0xff.fe_alpha.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import io.ucia0xff.fe_alpha.Values;

public class MapAnim extends Animation {
    private Rect src;
    private Rect dst;

    //构造方法
    public MapAnim(Context context, int[] resId, boolean isLoop) {
        super(context, resId, isLoop);
        frameWidth = getFramesBitmap().getWidth();
        frameHeight = getFramesBitmap().getHeight();
        src = new Rect(0, 0, frameWidth, frameHeight);
        if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_16)
            dst = Values.MAP_ANIM_SIZE_16x16;
        else if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_32)
            dst = Values.MAP_ANIM_SIZE_16x32;
        else//(frameWidth==32 && frameHeight==32)
            dst = Values.MAP_ANIM_SIZE_32x32;
    }

    public MapAnim(Bitmap[] frameBitmaps, boolean isLoop) {
        super(frameBitmaps, isLoop);
        frameWidth = getFramesBitmap().getWidth();
        frameHeight = getFramesBitmap().getHeight();
        src = new Rect(0, 0, frameWidth, frameHeight);
        if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_16)
            dst = Values.MAP_ANIM_SIZE_16x16;
        else if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_32)
            dst = Values.MAP_ANIM_SIZE_16x32;
        else//(frameWidth==32 && frameHeight==32)
            dst = Values.MAP_ANIM_SIZE_32x32;
    }

    @Override
    public void DrawAnim(Canvas Canvas, Paint paint, int x, int y) {
        if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_16)
            dst.offsetTo(x, y);
        else if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_32)
            dst.offsetTo(x, y - Values.MAP_TILE_HEIGHT);
        else//(frameWidth==32 && frameHeight==32)
            dst.offsetTo(x - Values.MAP_TILE_WIDTH / 2, y - Values.MAP_TILE_HEIGHT);

        if (!isEnd) {
            Canvas.drawBitmap(frames[nowFrame], src, dst, paint);
            long time = System.currentTimeMillis();
            if (time - lastTime > durations[nowFrame]) {
                nowFrame++;
                lastTime = time;
                if (nowFrame >= frameCount) {
                    //标志动画播放结束
                    isEnd = true;
                    if (isLoop) {
                        //设置循环播放
                        isEnd = false;
                        nowFrame = 0;
                    }
                }
            }
        }
    }

    @Override
    public void DrawAnim(Canvas Canvas, Paint paint,int[] xyTile, int offsetX, int offsetY) {

        if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_16)
            dst.offsetTo(xyTile[0] * Values.MAP_TILE_WIDTH + offsetX, xyTile[1] * Values.MAP_TILE_HEIGHT + offsetY);
        else if (frameWidth == Values.RES_ANIM_SIZE_16 && frameHeight == Values.RES_ANIM_SIZE_32)
            dst.offsetTo(xyTile[0] * Values.MAP_TILE_WIDTH + offsetX, xyTile[1] * Values.MAP_TILE_HEIGHT - Values.MAP_TILE_HEIGHT + offsetY);
        else
            dst.offsetTo(xyTile[0] * Values.MAP_TILE_WIDTH - Values.MAP_TILE_WIDTH / 2 + offsetX, xyTile[1] * Values.MAP_TILE_HEIGHT - Values.MAP_TILE_HEIGHT + offsetY);

        if (!isEnd) {
            Canvas.drawBitmap(frames[nowFrame], src, dst, paint);
            long time = System.currentTimeMillis();
            if (time - lastTime > durations[nowFrame]) {
                nowFrame++;
                lastTime = time;
                if (nowFrame >= frameCount) {
                    //标志动画播放结束
                    isEnd = true;
                    if (isLoop) {
                        //设置循环播放
                        isEnd = false;
                        nowFrame = 0;
                    }
                }
            }
        }
    }
    @Override
    public void DrawFrame(Canvas canvas, Paint paint, int x, int y, int frameID) {}
    @Override
    public void DrawAnim(Canvas Canvas, Paint paint, Rect dst) {}
}
