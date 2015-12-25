// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import java.util.List;

// Referenced classes of package o:
//            asc, ake, akg

final class akf
    implements asc
{

    private asc bqr;
    final ake bqs;

    akf(ake ake1, asc asc1)
    {
        bqs = ake1;
        bqr = asc1;
        super();
    }

    public final void aN()
    {
        bqr.aN();
        if (!ake._mth02CB(bqs))
        {
            ake._mth02CA(bqs).cV();
            if (ake._mth02CE(bqs))
            {
                ake._mth02CA(bqs, false);
                ake._mth02CF(bqs).post(new akg(this));
            }
        }
    }

    public final boolean aO()
    {
        return bqr.aO();
    }

    public final void _mth1D65(Object obj)
    {
        obj = (List)obj;
        ake._mth02CA(bqs).cW();
        bqr._mth1D65(obj);
    }
}
