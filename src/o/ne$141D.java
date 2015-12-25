// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package o:
//            ne, nj, er, nn

final class <init> extends Handler
{

    final ne KW;
    private boolean Lt;
    Thread.start Lu;

    public final void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            Lt = false;
            if (Lu != null)
            {
                sendEmptyMessage(0);
            }
            return;
        }
        removeMessages(0);
        if (Lt)
        {
            return;
        }
        if (Lu == null)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        message = Lu;
        Lu = null;
        Lt = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        message;
        throw message;
_L1:
        message.p = new nj(this);
        message.q = ne._mth141D(KW)._mth05F0();
        float f = ne._mth141D(KW)._mth0447().EL;
        message.s = f;
        message.r = new nn(Math.pow(2D, Math.min(f, ne._mth02BB(((Math.min) (message)).W))) * 256D);
        (new Thread(message)).start();
        return;
    }

    private .Message(ne ne1)
    {
        KW = ne1;
        super();
        Lt = false;
        Lu = null;
    }

    Lu(ne ne1, byte byte0)
    {
        this(ne1);
    }
}
