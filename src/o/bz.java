// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package o:
//            bx

final class bz extends cd._cls02CA
{

    private bx AO;
    private ConnectionResult AP;
    private bx.if AQ;

    bz(bx.if if1, bx bx1, bx bx2, ConnectionResult connectionresult)
    {
        AQ = if1;
        AO = bx2;
        AP = connectionresult;
        super(bx1);
    }

    public final void _mth216C()
    {
        bx bx1 = AO;
        ConnectionResult connectionresult = AP;
        if (bx1._mth02E4(2))
        {
            boolean flag;
            if (connectionresult.wC == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                bx1.FB3B();
                return;
            }
            if (bx1._mth02BB(connectionresult))
            {
                bx1.FBA2();
                bx1.FB3B();
                return;
            }
            bx1._mth02BC(connectionresult);
        }
    }
}
