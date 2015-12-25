// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.BitmapFactory;

// Referenced classes of package o:
//            rz, ra, rl

public final class vb
{

    public final String Ud;
    public final int Uv;
    public final int height;
    public final int width;

    private vb(String s, int i, int j, int k)
    {
        Ud = s;
        Uv = i;
        width = j;
        height = k;
    }

    public static vb _mth02BF(Context context, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        int i = rz._mth1421(context);
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder("App icon resource ID is ")).append(i).toString());
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        context = new vb(s, i, options.outWidth, options.outHeight);
        return context;
        context;
        ra._mth0454()._mth02CB("Fabric", "Failed to load icon", context);
        return null;
    }
}
