// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package o:
//            aky

final class ale
    implements Runnable
{

    private aky brD;
    private Bitmap brH;

    ale(aky aky1, Bitmap bitmap)
    {
        brD = aky1;
        brH = bitmap;
        super();
    }

    public final void run()
    {
        aky._mth02BB(brD).setImageBitmap(brH);
    }
}
