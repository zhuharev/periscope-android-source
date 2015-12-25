// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Referenced classes of package o:
//            yo, yq, aos, aix, 
//            _cls1D3C, _cls1D5A, _cls1D27, _cls1607, 
//            aiz, aja

public final class aiy
{

    private final Random bnU = aos.dE();
    private final String boA;
    private Bitmap boB;
    private Bitmap boC;
    public final ArrayList bow = new ArrayList();
    final HashMap box = new HashMap();
    final HashMap boy = new HashMap();
    private final String boz;
    private final Context mContext;

    public aiy(Context context)
    {
        mContext = context;
        boz = yo.aVs.l();
        switch (context.getResources().getDisplayMetrics().densityDpi)
        {
        case 120: // 'x'
        case 160: 
        case 240: 
            context = "drawable-hdpi";
            break;

        case 320: 
            context = "drawable-xhdpi";
            break;

        default:
            context = "drawable-xxhdpi";
            break;
        }
        boA = context;
    }

    public final aix FB40(int i)
    {
        aix aix1 = new aix(mContext);
        Bitmap bitmap;
        Bitmap bitmap1;
        if (!bow.isEmpty() && bnU.nextInt(6) == 0)
        {
            String s = (String)bow.get(bnU.nextInt(bow.size()));
            bitmap = (Bitmap)box.get(s);
            bitmap1 = (Bitmap)boy.get(s);
            if (bitmap == null)
            {
                Object obj = _cls1D3C._mth1427(mContext);
                Object obj2 = boA;
                obj2 = String.format("https://%s/public/heart_theme/android/%s/%s_%s.png", new Object[] {
                    boz, obj2, s, "border"
                });
                obj = (_cls1D27)((_cls1D5A) (obj))._mth02CA(java/lang/String).FF70(obj2);
                obj2 = ((_cls1D27) (obj)).jm;
                ((_cls1607)new _cls1607(((_cls1D27) (obj)), ((_cls1D27) (obj)).jj, ((_cls1D27) (obj)).jk, ((_cls1D27) (obj)).jm))._mth02CA(new aiz(this, s));
            }
            if (bitmap1 == null)
            {
                Object obj1 = _cls1D3C._mth1427(mContext);
                Object obj3 = boA;
                obj3 = String.format("https://%s/public/heart_theme/android/%s/%s_%s.png", new Object[] {
                    boz, obj3, s, "fill"
                });
                obj1 = (_cls1D27)((_cls1D5A) (obj1))._mth02CA(java/lang/String).FF70(obj3);
                obj3 = ((_cls1D27) (obj1)).jm;
                ((_cls1607)new _cls1607(((_cls1D27) (obj1)), ((_cls1D27) (obj1)).jj, ((_cls1D27) (obj1)).jk, ((_cls1D27) (obj1)).jm))._mth02CA(new aja(this, s));
            }
        } else
        {
            bitmap = null;
            bitmap1 = null;
        }
        if (bitmap != null && bitmap1 != null)
        {
            aix1.setColorAndDrawables(i, bitmap, bitmap1);
            return aix1;
        }
        if (boB == null)
        {
            boB = BitmapFactory.decodeResource(mContext.getResources(), 0x7f0200c1);
        }
        if (boC == null)
        {
            boC = BitmapFactory.decodeResource(mContext.getResources(), 0x7f0200c2);
        }
        aix1.setColorAndDrawables(i, boB, boC);
        return aix1;
    }
}
