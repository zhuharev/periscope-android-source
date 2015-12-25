// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FF8C

final class FF8D
    implements Runnable
{

    private View ga;
    private FF8C gb;

    FF8D(FF8C ff8c, View view)
    {
        gb = ff8c;
        ga = view;
        super();
    }

    public final void run()
    {
        int i = ga.getLeft();
        int j = (gb.getWidth() - ga.getWidth()) / 2;
        gb.smoothScrollTo(i - j, 0);
        gb.fR = null;
    }
}
