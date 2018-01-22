package io.ucia0xff.fe_alpha.anim;

import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

import io.ucia0xff.fe_alpha.R;
import io.ucia0xff.fe_alpha.Values;

public class CursorAnims {
    public static Bitmap bitmap;
    public static Bitmap[] bitmaps;
    public static Map<String, CursorAnim> CURSOR_ANIMS = new HashMap<String, CursorAnim>();
    static {
        bitmap = Animation.ReadBitMap(Values.CONTEXT, R.drawable.cursor);
        bitmaps = Animation.SplitBitmap(bitmap, 1, 2, bitmap.getHeight()/7);
        CursorAnim cursorAnim = new CursorAnim(bitmaps, true);
        cursorAnim.setDurations(300);
        CURSOR_ANIMS.put(Values.CURSOR_DYNAMIC, cursorAnim);

        bitmap = Animation.ReadBitMap(Values.CONTEXT, R.drawable.cursor);
        bitmaps = Animation.SplitBitmap(bitmap, 3, 4, bitmap.getHeight()/7);
        cursorAnim = new CursorAnim(bitmaps, true);
        cursorAnim.setDurations(300);
        CURSOR_ANIMS.put(Values.CURSOR_TARGET, cursorAnim);

        bitmap = Animation.ReadBitMap(Values.CONTEXT, R.drawable.cursor);
        bitmaps = Animation.SplitBitmap(bitmap, 5, 5, bitmap.getHeight()/7);
        cursorAnim = new CursorAnim(bitmaps, true);
        cursorAnim.setDurations(300);
        CURSOR_ANIMS.put(Values.CURSOR_STATIC, cursorAnim);

        bitmap = Animation.ReadBitMap(Values.CONTEXT, R.drawable.cursor);
        bitmaps = Animation.SplitBitmap(bitmap, 6, 6, bitmap.getHeight()/7);
        cursorAnim = new CursorAnim(bitmaps, true);
        cursorAnim.setDurations(300);
        CURSOR_ANIMS.put(Values.CURSOR_ALLOWED, cursorAnim);

        bitmap = Animation.ReadBitMap(Values.CONTEXT, R.drawable.cursor);
        bitmaps = Animation.SplitBitmap(bitmap, 7, 7, bitmap.getHeight()/7);
        cursorAnim = new CursorAnim(bitmaps, true);
        cursorAnim.setDurations(300);
        CURSOR_ANIMS.put(Values.CURSOR_FORBIDEN, cursorAnim);
    }
}

