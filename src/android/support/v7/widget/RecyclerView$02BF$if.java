// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.animation.Interpolator;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static class mInterpolator
{

    public static final int fg = 0x7f0d00da;
    public static final int fh = 0x7f0d00db;
    public static final int fi = 0x7f0d00d9;
    private int fb;
    private int fc;
    private int fd;
    private boolean fe;
    int ff;
    private Interpolator mInterpolator;

    public ()
    {
    }

    public (int i, int j)
    {
        this(0, 0, 0x80000000, null);
    }

    private <init>(int i, int j, int k, Interpolator interpolator)
    {
        fe = false;
        ff = 0;
        fb = i;
        fc = j;
        fd = 0x80000000;
        mInterpolator = null;
    }
}
