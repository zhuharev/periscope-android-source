// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o.abl;
import o.ql;
import o.xd;

public class ConnectivityChangeReceiver extends BroadcastReceiver
{

    public ConnectivityChangeReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            xd.getEventBus()._mth1429(new abl(intent.getExtras()));
        }
    }
}
