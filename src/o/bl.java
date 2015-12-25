// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.iid.MessengerCompat;

// Referenced classes of package o:
//            bk

public final class bl extends Handler
{

    private bk zR;

    bl(bk bk1, Looper looper)
    {
        zR = bk1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        bk._mth02CA(zR, message, MessengerCompat._mth02CB(message));
    }
}
