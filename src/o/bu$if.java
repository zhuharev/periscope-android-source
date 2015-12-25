// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

// Referenced classes of package o:
//            bu, _cls0E04, _cls09F0

public static final class os.Looper extends Handler
{

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 1: // '\001'
            Object obj = (Pair)message.obj;
            message = (_cls0E04)((Pair) (obj)).first;
            obj = (_cls09F0)((Pair) (obj)).second;
            try
            {
                message._mth02CA(((_cls09F0) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                bu._mth02CF(((_cls09F0) (obj)));
            }
            throw message;

        case 2: // '\002'
            ((bu)message.obj)._mth02CE(Status.xk);
            return;
        }
        Log.wtf("BasePendingResult", (new StringBuilder("Don't know how to handle message: ")).append(message.what).toString(), new Exception());
    }

    public os.Looper()
    {
        this(Looper.getMainLooper());
    }

    public os.Looper(Looper looper)
    {
        super(looper);
    }
}
