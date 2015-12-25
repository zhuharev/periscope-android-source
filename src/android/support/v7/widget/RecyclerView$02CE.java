// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class eG
{
    /* member class not found */
    class if {}


    public if eA;
    private ArrayList eB;
    public long eC;
    public long eD;
    public long eE;
    public long eF;
    public boolean eG;

    public abstract boolean isRunning();

    public abstract boolean _mth02CA(if if1);

    public abstract boolean _mth02CA(if if1, int i, int j, int k, int l);

    public abstract boolean _mth02CA(if if1, if if2, int i, int j, int k, int l);

    public abstract boolean _mth02CB(if if1);

    public abstract void _mth02CE(if if1);

    public final void _mth30FD()
    {
        int j = eB.size();
        for (int i = 0; i < j; i++)
        {
            eB.get(i);
        }

        eB.clear();
    }

    public abstract void FEE8();

    public abstract void FF68();

    public if()
    {
        eA = null;
        eB = new ArrayList();
        eC = 120L;
        eD = 120L;
        eE = 250L;
        eF = 250L;
        eG = true;
    }
}
