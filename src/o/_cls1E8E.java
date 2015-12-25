// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package o:
//            _cls1E6D, _cls1E2C

final class _cls1E8E extends BroadcastReceiver
{

    private _cls1E6D qM;

    _cls1E8E(_cls1E6D _pcls1e6d)
    {
        qM = _pcls1e6d;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag1 = qM.qJ;
        intent = qM;
        _cls1E6D _lcls1e6d = qM;
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if (context != null && context.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.qJ = flag;
        if (flag1 != qM.qJ)
        {
            qM.qI._mth02C6(qM.qJ);
        }
    }
}
