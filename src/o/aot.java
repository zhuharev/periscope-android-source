// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            aqv

final class aot extends aqv
{

    private android.view.View.OnClickListener bvt[];
    private int bvu;

    aot(int i, android.view.View.OnClickListener aonclicklistener[], int j)
    {
        bvt = aonclicklistener;
        bvu = j;
        super(i);
    }

    public final void onClick(View view)
    {
        bvt[bvu].onClick(view);
    }
}
