// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            apj, apo, xf, agb, 
//            agp

public final class agf
    implements apj
{

    private final String bei;
    private final agb bjH;

    public agf(String s, agp agp)
    {
        bei = s;
        bjH = agp;
    }

    public final int aT()
    {
        return 0x7f0c0037;
    }

    public final apo aV()
    {
        return apo.byX;
    }

    public final boolean execute()
    {
        xf._mth02CA(xf.if.aSQ);
        bjH.bU();
        return false;
    }

    public final int getIconResId()
    {
        return 0x7f0200cf;
    }

    public final int getIconTint()
    {
        return 0x7f0c00a3;
    }

    public final String _mth1D36(Context context)
    {
        return context.getString(0x7f06014f);
    }
}
