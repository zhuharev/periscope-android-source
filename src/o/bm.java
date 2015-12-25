// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package o:
//            bk

final class bm extends BroadcastReceiver
{

    private bk zR;

    bm(bk bk1)
    {
        zR = bk1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (Log.isLoggable("InstanceID", 3))
        {
            intent.getStringExtra("registration_id");
            Log.d("InstanceID", (new StringBuilder("Received GSF callback using dynamic receiver: ")).append(intent.getExtras()).toString());
        }
        zR._mth02CB(intent);
        zR.stop();
    }
}
