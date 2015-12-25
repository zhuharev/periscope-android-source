// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Referenced classes of package o:
//            eb, dj

static final class DN extends Handler
{

    private final dj DN;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 1: // '\001'
            message = new Location((Location)message.obj);
            DN.onLocationChanged(message);
            return;
        }
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
    }

    public .Looper(dj dj1)
    {
        DN = dj1;
    }

    public .Looper(dj dj1, Looper looper)
    {
        super(looper);
        DN = dj1;
    }
}
