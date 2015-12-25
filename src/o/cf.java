// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            cd, ci

final class cf
    implements _cls09AA._cls02CA
{

    private cd Bt;

    cf(cd cd1)
    {
        Bt = cd1;
        super();
    }

    public final void _mth02C1(int i)
    {
        Bt.AZ.lock();
        Bt.Bm._mth02C1(i);
        Bt.AZ.unlock();
        return;
        Exception exception;
        exception;
        Bt.AZ.unlock();
        throw exception;
    }

    public final void _mth141D(Bundle bundle)
    {
        Bt.AZ.lock();
        Bt.Bm._mth141D(bundle);
        Bt.AZ.unlock();
        return;
        bundle;
        Bt.AZ.unlock();
        throw bundle;
    }
}
