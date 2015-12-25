// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

// Referenced classes of package o:
//            ake, asc

static final class bqv extends Handler
{

    private final asc bqv;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 100: // 'd'
            bqv._mth1D65((List)message.obj);
            break;
        }
    }

    public Looper(asc asc1)
    {
        super(Looper.getMainLooper());
        bqv = asc1;
    }
}
