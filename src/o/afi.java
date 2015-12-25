// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            adg, adk, asi, xf

public final class afi extends adg
{
    static final class if extends adg
    {

        public final boolean execute()
        {
            xf._mth02CA(xf.if.aSh);
            bej.aX();
            return false;
        }

        public final int getIconResId()
        {
            return 0x7f0200e2;
        }

        public final int getIconTint()
        {
            return 0x7f0c00b5;
        }

        public final String _mth1D36(Context context)
        {
            return context.getString(0x7f060039);
        }

        public if(String s, adk adk1)
        {
            super(s, adk1);
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final asi biy;

    public afi(String s, adk adk1)
    {
        super(s, adk1);
        if if1 = new if(s, adk1);
        s = new _cls02CA(s, adk1);
        if (adk1.aZ())
        {
            biy = new asi(if1, s);
            return;
        } else
        {
            biy = new asi(s, if1);
            return;
        }
    }

    public final boolean execute()
    {
        biy.execute();
        return true;
    }

    public final int getIconResId()
    {
        return biy.getIconResId();
    }

    public final int getIconTint()
    {
        return biy.getIconTint();
    }

    public final String _mth1D36(Context context)
    {
        return biy._mth1D36(context);
    }
}
