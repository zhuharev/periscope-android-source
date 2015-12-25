// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

// Referenced classes of package o:
//            bx

final class ca extends cd._cls02CA
{

    private bx AO;
    private ResolveAccountResponse AR;
    private bx._cls02CA AS;

    ca(bx._cls02CA _pcls02ca, bx bx1, bx bx2, ResolveAccountResponse resolveaccountresponse)
    {
        AS = _pcls02ca;
        AO = bx2;
        AR = resolveaccountresponse;
        super(bx1);
    }

    public final void _mth216C()
    {
        bx bx1 = AO;
        ResolveAccountResponse resolveaccountresponse = AR;
        if (bx1._mth02E4(0))
        {
            ConnectionResult connectionresult = resolveaccountresponse.xy;
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
                bx1.AI = _cls14B4.if._mth02CB(resolveaccountresponse.xn);
                bx1.AH = true;
                bx1.xz = resolveaccountresponse.xz;
                bx1.AJ = resolveaccountresponse.xA;
                bx1._mth30A3();
                return;
            }
            if (bx1._mth02BB(connectionresult))
            {
                bx1.FBA2();
                bx1._mth30A3();
                return;
            }
            bx1._mth02BC(connectionresult);
        }
    }
}
