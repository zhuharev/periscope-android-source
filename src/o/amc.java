// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package o:
//            aly

final class amc
    implements Runnable
{

    private Bitmap brH;
    private aly bsE;

    amc(aly aly1, Bitmap bitmap)
    {
        bsE = aly1;
        brH = bitmap;
        super();
    }

    public final void run()
    {
        aly._mth02CE(bsE).setImageBitmap(brH);
    }
}
