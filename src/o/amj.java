// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package o:
//            amh

final class amj
    implements Runnable
{

    private Bitmap Oa;
    private amh bsR;

    amj(amh amh1, Bitmap bitmap)
    {
        bsR = amh1;
        Oa = bitmap;
        super();
    }

    public final void run()
    {
        amh._mth02CB(bsR).setImageBitmap(Oa);
        amh._mth02CE(bsR).setImageBitmap(Oa);
    }
}
