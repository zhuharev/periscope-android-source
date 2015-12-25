// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            apj, apo, agb, agp

public final class agc
    implements apj
{

    private String bei;
    private agb bjH;

    public agc(String s, agp agp)
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
        bjH.bV();
        return false;
    }

    public final int getIconResId()
    {
        return 0x7f0200cb;
    }

    public final int getIconTint()
    {
        return 0x7f0c0056;
    }

    public final String _mth1D36(Context context)
    {
        return context.getString(0x7f060147);
    }
}
