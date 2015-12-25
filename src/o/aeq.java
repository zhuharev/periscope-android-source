// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.view.ViewPropertyAnimator;

// Referenced classes of package o:
//            aed

final class aeq
    implements Runnable
{

    private aed bhH;

    aeq(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        aed._mth141D(bhH).animate().alpha(0.0F);
    }
}
