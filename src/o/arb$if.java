// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package o:
//            arb

final class s.Handler extends Handler
{

    private arb bBf;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 1: // '\001'
            arb._mth02CB(bBf).onShowPress(arb._mth02CA(bBf));
            return;

        case 2: // '\002'
            arb._mth02CE(bBf);
            return;

        case 3: // '\003'
            if (arb._mth02CF(bBf) != null)
            {
                if (!arb._mth141D(bBf))
                {
                    arb._mth02CF(bBf).onSingleTapConfirmed(arb._mth02CA(bBf));
                    return;
                } else
                {
                    arb._mth02CA(bBf, true);
                    return;
                }
            } else
            {
                return;
            }
        }
        throw new RuntimeException((new StringBuilder("Unknown message ")).append(message).toString());
    }

    (arb arb1)
    {
        bBf = arb1;
        super();
    }
}
