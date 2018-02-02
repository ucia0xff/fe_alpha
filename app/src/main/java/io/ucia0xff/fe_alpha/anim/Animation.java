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
    public Bitmap[] frames = null;

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

    //获取一帧
    public Bitmap getFrame(int frameId){
        return frames[frameId];
    }

    // 构造方法
    public Animation(){}
    public Animation(Context context, int[] resId, boolean isLoop) {
        frameCount = resId.length;
        frames = new Bitmap[frameCount];
        durations = new int[frameCount];
        setDurations(defaultDuration);
        for (int i = 0; i < frameCount; i++) {
            frames[i] = ReadBitMap(context, resId[i]);
        }
        this.isLoop = isLoop;
    }
    public Animation(Bitmap[] frames, boolean isLoop) {
        frameCount = frames.length;
        durations = new int[frameCount];
        Arrays.fill(durations, defaultDuration);
        this.frames = frames;
        this.isLoop = isLoop;
    }

    //绘制动画中的其中一帧
    public abstract void DrawFrame(Canvas canvas, Paint paint, int x, int y, int frameId);

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
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }
    public static Bitmap ReadBitMap(Context context, String fileName) throws IOException {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;//色彩模式，RGB_565模式下一个像素点占用2bytes(R占5bit,G占6bit,B占5bit)
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

    //将图片转为黑白
    public static Bitmap convertToBlackWhite(Bitmap bmp) {
        int width = bmp.getWidth(); // 获取位图的宽
        int height = bmp.getHeight(); // 获取位图的高
        int[] pixels = new int[width * height]; // 通过位图的大小创建像素点数组

        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        int alpha = 0xFF << 24;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[width * i + j];

                //分离三原色
                int red = ((grey & 0x00FF0000) >> 16);
                int green = ((grey & 0x0000FF00) >> 8);
                int blue = (grey & 0x000000FF);

                //转化成灰度像素
                grey = (int) (red * 0.3 + green * 0.59 + blue * 0.11);
                grey = alpha | (grey << 16) | (grey << 8) | grey;
                pixels[width * i + j] = grey;
            }
        }
        //新建图片
        Bitmap newBmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        //设置图片数据
        newBmp.setPixels(pixels, 0, width, 0, 0, width, height);

        return newBmp;
    }

}
