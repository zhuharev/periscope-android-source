// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            adg, adk, xf

public final class afz extends adg
{

    public afz(String s, adk adk1)
    {
        super(s, adk1);
    }

    public final boolean execute()
    {
        if (!bej.ba())
        {
            xf._mth02CA(xf.if.aRZ);
            bej._mth05D6(bei);
            return true;
        } else
        {
            return false;
        }
    }

    public final int getIconResId()
    {
        return !bej.ba() ? 0x7f0200dd : 0;
    }

    public final int getIconTint()
    {
        return !bej.ba() ? 0x7f0c00b5 : 0;
    }

    public final String _mth1D36(Context context)
    {
        if (bej.ba())
        {
            return context.getString(0x7f06003e);
        } else
        {
            return context.getString(0x7f06003d);
        }
    }
}
