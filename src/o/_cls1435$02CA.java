// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            _cls1435

final class ooper extends Handler
{

    private _cls1435 yc;

    private static boolean _mth02CA(Message message)
    {
        return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
    }

    public final void handleMessage(Message message)
    {
        if (yc.ya.get() != message.arg1)
        {
            if (_mth02CA(message))
            {
                ((essage)message.obj).unregister();
            }
            return;
        }
        if ((message.what == 1 || message.what == 5 || message.what == 6) && !yc.isConnecting())
        {
            ((necting)message.obj).unregister();
            return;
        }
        if (message.what == 3)
        {
            message = new ConnectionResult(message.arg2, null);
            yc.xS._mth02CB(message);
            return;
        }
        if (message.what == 4)
        {
            yc._mth02CA(4, null);
            if (yc.xX != null)
            {
                yc.xX._mth02C1(message.arg2);
            }
            int i = message.arg2;
            yc._mth02CA(4, 1, null);
            return;
        }
        if (message.what == 2 && !yc.isConnected())
        {
            ((nected)message.obj).unregister();
            return;
        }
        if (_mth02CA(message))
        {
            ((essage)message.obj)._mth0694();
            return;
        } else
        {
            Log.wtf("GmsClient", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
            return;
        }
    }

    public ooper(_cls1435 _pcls1435, Looper looper)
    {
        yc = _pcls1435;
        super(looper);
    }
}
