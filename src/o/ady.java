// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package o:
//            adx

final class ady extends OrientationEventListener
{

    private adx bgi;

    ady(adx adx1, Context context, int i)
    {
        bgi = adx1;
        super(context, 3);
    }

    public final void onOrientationChanged(int i)
    {
        if (i != -1)
        {
            adx._mth02CA(bgi, ((i + 45) / 90) * 90);
            adx._mth02CA(bgi);
        }
    }
}
