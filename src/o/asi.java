// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            apj, adg, apo

public final class asi
    implements apj
{

    private final apj bCL;
    private final apj bCM;
    private apj bCN;

    public asi(adg adg, adg adg1)
    {
        bCL = adg;
        bCM = adg1;
        bCN = bCL;
    }

    public final int aT()
    {
        return bCN.aT();
    }

    public final apo aV()
    {
        return bCN.aV();
    }

    public final boolean execute()
    {
        bCN.execute();
        if (bCN == bCL)
        {
            bCN = bCM;
        } else
        {
            bCN = bCL;
        }
        return true;
    }

    public final int getIconResId()
    {
        return bCN.getIconResId();
    }

    public final int getIconTint()
    {
        return bCN.getIconTint();
    }

    public final String _mth1D36(Context context)
    {
        return bCN._mth1D36(context);
    }
}
