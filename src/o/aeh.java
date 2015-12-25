// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.Animator;

// Referenced classes of package o:
//            aed

final class aeh
    implements Runnable
{

    private aed bhH;

    aeh(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        aed._mth02CA(bhH, aed._mth141D(bhH)).start();
    }
}
