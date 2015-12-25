// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewTreeObserver;

// Referenced classes of package o:
//            aob, arx

final class aoc
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private ViewTreeObserver bqG;
    private aob buQ;

    aoc(aob aob1, ViewTreeObserver viewtreeobserver)
    {
        buQ = aob1;
        bqG = viewtreeobserver;
        super();
    }

    public final boolean onPreDraw()
    {
        buQ.bgt._mth14A1(buQ.buO);
        bqG.removeOnPreDrawListener(this);
        return true;
    }
}
