// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.ImageView;

// Referenced classes of package o:
//            arv

final class arw
    implements Runnable
{

    private arv bBV;

    arw(arv arv1)
    {
        bBV = arv1;
        super();
    }

    public final void run()
    {
        arv._mth02CA(bBV).setVisibility(0);
        arv._mth02CA(bBV).startAnimation(arv._mth02CB(bBV));
    }
}
