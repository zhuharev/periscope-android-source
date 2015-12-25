// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static final class eM extends android.view.youtParams
{

    eM eJ;
    public final Rect eK;
    public boolean eL;
    boolean eM;

    public (int i, int j)
    {
        super(-2, -2);
        eK = new Rect();
        eL = true;
        eM = false;
    }

    public eM(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        eK = new Rect();
        eL = true;
        eM = false;
    }

    public eM(eM em)
    {
        super(em);
        eK = new Rect();
        eL = true;
        eM = false;
    }

    public eM(android.view.rams rams)
    {
        super(rams);
        eK = new Rect();
        eL = true;
        eM = false;
    }

    public eM(android.view.youtParams youtparams)
    {
        super(youtparams);
        eK = new Rect();
        eL = true;
        eM = false;
    }
}
