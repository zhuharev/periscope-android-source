// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            cd, ci, _cls09A8

final class ch
    implements _cls09AA._cls02CB
{

    private cd Bt;
    private _cls09A8 Bu;
    private int Bv;

    ch(cd cd1, _cls09A8 _pcls09a8, int i)
    {
        Bt = cd1;
        Bu = _pcls09a8;
        Bv = i;
        super();
    }

    public final void _mth02CA(ConnectionResult connectionresult)
    {
        Bt.AZ.lock();
        Bt.Bm._mth02CA(connectionresult, Bu, Bv);
        Bt.AZ.unlock();
        return;
        connectionresult;
        Bt.AZ.unlock();
        throw connectionresult;
    }
}
