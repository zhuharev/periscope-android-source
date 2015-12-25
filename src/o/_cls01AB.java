// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package o:
//            FF6B

final class _cls01AB extends BroadcastReceiver
{

    private FF6B uQ;

    _cls01AB(FF6B ff6b)
    {
        uQ = ff6b;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        FF6B._mth02CA(uQ, true);
    }
}
