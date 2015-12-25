// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package o:
//            _cls14D7, _cls1D3C

final class <init>
    implements android.os.llback
{

    private _cls14D7 qc;

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            message = (essage.what)message.obj;
            _cls14D7 _lcls14d7 = qc;
            if (_lcls14d7.pZ)
            {
                _lcls14d7.handler.obtainMessage(2, message).sendToTarget();
            } else
            {
                ject ject = _lcls14d7.pY;
                _lcls14d7.pY = message;
                _lcls14d7.pU._mth1D53(((_cls1D53) (message)).dex);
                if (ject != null)
                {
                    _lcls14d7.handler.obtainMessage(2, ject).sendToTarget();
                }
                _lcls14d7.pW = false;
                _lcls14d7.FE9C();
            }
            return true;
        }
        if (message.what == 2)
        {
            _cls1D3C._mth02CA((essage.what)message.obj);
        }
        return false;
    }

    private essage(_cls14D7 _pcls14d7)
    {
        qc = _pcls14d7;
        super();
    }

    ject(_cls14D7 _pcls14d7, byte byte0)
    {
        this(_pcls14d7);
    }
}
