// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;

// Referenced classes of package o:
//            ph, pq, pt

final class pp
    implements Runnable
{

    private ph.if Ob;

    pp(ph.if if1)
    {
        Ob = if1;
        super();
    }

    public final void run()
    {
        ph.if._mth02CA(Ob);
        ph._mth02CB(Ob.NX).invalidate();
        if (ph._mth02CB(Ob.NX).Oc.size() == 1)
        {
            ph._mth02CA(Ob.NX, (pt)ph._mth02CB(Ob.NX).Oc.get(0));
            ph._mth02BC(Ob.NX).OD = true;
        }
    }
}
