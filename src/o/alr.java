// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aod, alq

final class alr extends aod
{

    private alq bsk;

    alr(alq alq1)
    {
        bsk = alq1;
        super();
    }

    protected final int getItemCount()
    {
        return bsk.getItemCount();
    }

    protected final boolean FB61(int i)
    {
        return bsk.getItemViewType(i) == 2;
    }

    protected final String FB64(int i)
    {
        Object obj = alq._mth02CA(bsk, i);
        if (obj instanceof PsUser)
        {
            return ((PsUser)obj).id;
        } else
        {
            return "";
        }
    }
}
