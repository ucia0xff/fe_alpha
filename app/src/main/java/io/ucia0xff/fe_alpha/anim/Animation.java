package io.ucia0xff.fe_alpha.anim;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class Animation {
    //上一帧播放时间
    public long lastTime = 0;

    //当前播放的帧
    public int nowFrame = 0;

    //动画的帧数
    public int frameCount = 0;

    //动画的每一帧
    public Bitmap[] frameBitmaps = null;

    //每一帧的宽高
    public int frameWidth = 0;
    public int frameHeight = 0;

    //是否循环播放
    public boolean isLoop = false;

    //是否播放结束
    public boolean isEnd = false;

    //每一帧的持续时间
    public int durations[];

    //默认每一帧的持续时间
    public static final int defaultDuration = 100;

    //设置动画播放间隙时间
    public void setDurations(int duration) {
        Arrays.fill(durations, duration);
    }
    public void setDurations(int index, int duration) {
        durations[index] = duration;
    }
    public void setDurations(int[] durations){
        this.durations = durations;
    }

    // 构造方法
    public Animation(){}
    public Animation(Context context, int[] resId, boolean isLoop) {
        frameCount = resId.length;
        frameBitmaps = new Bitmap[frameCount];
        durations = new int[frameCount];
        setDurations(defaultDuration);
        for (int i = 0; i < frameCount; i++) {
            frameBitmaps[i] = ReadBitMap(context, resId[i]);
        }
        this.isLoop = isLoop;
    }
    public Animation(Bitmap[] frameBitmaps, boolean isLoop) {
        frameCount = frameBitmaps.length;
        durations = new int[frameCount];
        Arrays.fill(durations, defaultDuration);
        this.frameBitmaps = frameBitmaps;
        this.isLoop = isLoop;
    }

    //绘制动画中的其中一帧
    public abstract void DrawFrame(Canvas canvas, Paint paint, int x, int y, int frameID);

    //在指定位置绘制动画
    public abstract void DrawAnim(Canvas Canvas, Paint paint, int x, int y);
    //在指定格子绘制动画
    public abstract void DrawAnim(Canvas Canvas, Paint paint, int[] xyTile, int offsetX, int offsetY);
    //在指定区域绘制动画
    public abstract void DrawAnim(Canvas Canvas, Paint paint, Rect dst);

    //读取图片资源
    public static Bitmap ReadBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
    public static Bitmap ReadBitMap(Context context, String fileName) throws IOException {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;//色彩模式，RGB_565模式下一个像素点占用2bytes(R占5bit,G占6bit,B占5bit)
        opt.inPurgeable = true;// 可被释放
        opt.inInputShareable = true;//可被共享，和上一个参数一起用
        InputStream is = context.getAssets().open(fileName);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    //从一张完整图片中切割出一组图片
    public static Bitmap[] SplitBitmap(Bitmap src, int start, int end, int height) {
        int count = end - start + 1;
        Bitmap[] splited = new Bitmap[count];
        for (int i = 0; i < count; i++)
            splited[i] = Bitmap.createBitmap(src, 0, (start - 1 + i) * height, src.getWidth(), height);
        return splited;
    }

    //将图片水平翻转
    public static Bitmap[] getMirrorBitmap(Bitmap[] srcs) {
        Matrix m = new Matrix();
        m.preScale(-1, 1);
        Bitmap[] mirrors = new Bitmap[srcs.length];
        for (int i = 0; i < srcs.length; i++)
            mirrors[i] = Bitmap.createBitmap(srcs[i], 0, 0, srcs[i].getWidth(), srcs[i].getHeight(), m, false);
        return mirrors;
    }

    //获取一帧
    public Bitmap getFramesBitmap(){
        return frameBitmaps[0];
    }
    public Bitmap getFrame(int frameId){
        return frameBitmaps[frameId];
    }
}
