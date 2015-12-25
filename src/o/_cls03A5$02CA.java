// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Message;

// Referenced classes of package o:
//            _cls03A5

static final class <init>
    implements android.os.llback
{

    public final boolean handleMessage(Message message)
    {
        if (1 == message.what || 2 == message.what)
        {
            _cls03A5 _lcls03a5 = (_cls03A5)message.obj;
            if (1 == message.what)
            {
                _cls03A5._mth02CA(_lcls03a5);
            } else
            {
                _cls03A5._mth02CB(_lcls03a5);
            }
            return true;
        } else
        {
            return false;
        }
    }

    private essage()
    {
    }

    essage(byte byte0)
    {
        this();
    }
}
