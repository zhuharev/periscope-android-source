// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Color;

public final class aap
{

    public final int bar;
    private int src;

    public aap(int i, int j)
    {
        src = i;
        bar = j;
    }

    public final int _mth1428(float f)
    {
        int i = Color.red(src);
        int j = Color.red(bar);
        int k = Color.green(src);
        int l = Color.green(bar);
        int i1 = Color.blue(src);
        int j1 = Color.blue(bar);
        return Color.rgb((int)((float)i + (float)(j - i) * f), (int)((float)k + (float)(l - k) * f), (int)((float)i1 + (float)(j1 - i1) * f));
    }
}
