package io.ucia0xff.fe_alpha.anim;

import android.graphics.Bitmap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.ucia0xff.fe_alpha.Values;

public class MapAnims {
    public static Bitmap bitmap;
    public static Bitmap[] bitmaps;
    public static Map<String, MapAnim> MAP_ANIMS = new HashMap<String, MapAnim>();
    static {
        try {
//修女（娜塔莎）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Sister/Sister_Natasha_Player_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            MapAnim mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Sister/Sister_Natasha_Player_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/Sister/Sister_Natasha_Player_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 4, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 5, 8, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 9, 12, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Sister/Sister_Natasha_Player_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("Sister_Natasha_Player_"+Values.MAP_ANIM_STANDBY, mapAnim);

//神官骑士（我方）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Troubadour/Troubadour_Player_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Troubadour/Troubadour_Player_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Troubadour/Troubadour_Player_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 4, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 5, 8, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 9, 12, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/Troubadour/Troubadour_Player_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("Troubadour_Player_"+Values.MAP_ANIM_STANDBY, mapAnim);

//天马骑士（我方）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/PegasusKnight/PegasusKnight_Player_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/PegasusKnight/PegasusKnight_Player_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/PegasusKnight/PegasusKnight_Player_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 4, 6, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 7, 9, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/PegasusKnight/PegasusKnight_Player_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("PegasusKnight_Player_"+Values.MAP_ANIM_STANDBY, mapAnim);

//翼龙骑士（我方）

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Player_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Player_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Player_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 4, 6, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 7, 9, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Player_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("WyvernKnight_Player_"+Values.MAP_ANIM_STANDBY, mapAnim);

//翼龙骑士（敌方）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Enemy_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Enemy_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Enemy_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 4, 6, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 7, 9, bitmap.getHeight()/9);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/WyvernKnight/WyvernKnight_Enemy_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("WyvernKnight_Enemy_"+Values.MAP_ANIM_STANDBY, mapAnim);

//魔刹犬（我方）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Player_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Player_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Player_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 4, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 5, 8, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 9, 12, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Player_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("MautheDog_Player_"+Values.MAP_ANIM_STANDBY, mapAnim);

//魔刹犬（敌方）
            bitmap = Animation.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Enemy_Static.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_STATIC, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Enemy_Dynamic.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_DYNAMIC, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Enemy_Move.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 4, bitmap.getHeight()/12);
            mapAnim = new MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_DOWN, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 5, 8, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_UP, mapAnim);

            bitmaps = MapAnim.SplitBitmap(bitmap, 9, 12, bitmap.getHeight()/12);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_RIGHT, mapAnim);

            bitmaps = MapAnim.getMirrorBitmap(bitmaps);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(200);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_LEFT, mapAnim);

            bitmap = MapAnim.ReadBitMap(Values.CONTEXT, "animations/MautheDog/MautheDog_Enemy_Standby.png");
            bitmaps = MapAnim.SplitBitmap(bitmap, 1, 3, bitmap.getHeight()/3);
            mapAnim = new  MapAnim(bitmaps, true);
            mapAnim.setDurations(400);
            MAP_ANIMS.put("MautheDog_Enemy_"+Values.MAP_ANIM_STANDBY, mapAnim);


        } catch (IOException e) {}
    }
}

