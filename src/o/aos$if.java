// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

// Referenced classes of package o:
//            aos

static final class .HashMap extends Handler
{

    HashMap bvv;

    public final void handleMessage(Message message)
    {
        int i = message.what;
        if (!hasMessages(i))
        {
            removeMessages(i);
            ((Runnable)message.obj).run();
        }
    }

    public ()
    {
        bvv = new HashMap();
    }
}
