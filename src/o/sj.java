// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            sk, rn, ra, rl

public final class sj
{

    private final sk Sl = new sk(this);
    private final rn Sm = new rn();

    public sj()
    {
    }

    public final String _mth1507(Context context)
    {
        boolean flag;
        try
        {
            context = (String)Sm._mth02CA(context, Sl);
            flag = "".equals(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ra._mth0454()._mth02CB("Fabric", "Failed to determine installer package name", context);
            return null;
        }
        if (flag)
        {
            return null;
        } else
        {
            return context;
        }
    }
}
