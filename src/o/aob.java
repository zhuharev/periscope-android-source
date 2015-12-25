// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewTreeObserver;
import java.util.List;

// Referenced classes of package o:
//            apl, arx, xf, apk, 
//            aoc, qh

public class aob
    implements apl
{

    protected final arx bgt;
    public final apk buO;
    public final qh buP;

    public aob(arx arx1, apk apk1, qh qh)
    {
        bgt = arx1;
        buO = apk1;
        buP = qh;
    }

    public final boolean aO()
    {
        return arx._mth1424(buO);
    }

    public final void dC()
    {
        xf._mth141D(buP);
        bgt._mth14A2(buO);
    }

    public final void _mth02CB(String s, List list)
    {
        buO.setSnippet(s);
        buO.setActions(list);
        s = buO.getViewTreeObserver();
        s.addOnPreDrawListener(new aoc(this, s));
        buO.requestLayout();
    }
}
