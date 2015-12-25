// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            cd

final class os.Looper extends Handler
{

    private cd Bt;

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 39
    //                   2 86
    //                   3 94
    //                   4 109;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        message = Bt;
        ((cd) (message)).AZ.lock();
        if (message.FF2A())
        {
            message.connect();
        }
        ((cd) (message)).AZ.unlock();
        return;
        Exception exception;
        exception;
        ((cd) (message)).AZ.unlock();
        throw exception;
_L3:
        cd._mth02CA(Bt);
        return;
_L4:
        ((A)message.obj)._mth02CB(Bt);
        return;
_L5:
        throw (RuntimeException)message.obj;
_L1:
        Log.w("GoogleApiClientImpl", (new StringBuilder("Unknown message id: ")).append(message.what).toString());
        return;
    }

    os.Looper(cd cd1, Looper looper)
    {
        Bt = cd1;
        super(looper);
    }
}
