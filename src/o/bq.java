// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;

// Referenced classes of package o:
//            bp

final class bq extends Handler
{

    private bp Ah;

    bq(bp bp1, Looper looper)
    {
        Ah = bp1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        bp bp1 = Ah;
        if (message != null)
        {
            if (message.obj instanceof Intent)
            {
                Object obj = (Intent)message.obj;
                ((Intent) (obj)).setExtrasClassLoader(com/google/android/gms/iid/MessengerCompat.getClassLoader());
                if (((Intent) (obj)).hasExtra("google.messenger"))
                {
                    obj = ((Intent) (obj)).getParcelableExtra("google.messenger");
                    if (obj instanceof MessengerCompat)
                    {
                        bp1.Ab = (MessengerCompat)obj;
                    }
                    if (obj instanceof Messenger)
                    {
                        bp1.Aa = (Messenger)obj;
                    }
                }
                bp1._mth02BB((Intent)message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }
}
