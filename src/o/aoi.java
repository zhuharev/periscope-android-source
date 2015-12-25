// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;

// Referenced classes of package o:
//            aoh, aoj

final class aoi
    implements Runnable
{

    private Bitmap buY;
    private aoh buZ;

    aoi(aoh aoh1, Bitmap bitmap)
    {
        buZ = aoh1;
        buY = bitmap;
        super();
    }

    public final void run()
    {
        buZ.buX._mth02C8(buY);
    }
}
