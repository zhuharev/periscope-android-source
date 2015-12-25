// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package o:
//            _cls02C9, _cls02D1, _cls0640, _cls1428

final class _cls02CC extends Handler
{

    private _cls02C9 FB1D;

    _cls02CC(_cls02C9 _pcls02c9)
    {
        FB1D = _pcls02c9;
        super();
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 1: // '\001'
            if (FB1D.mStopped)
            {
                FB1D.doReallyStop(false);
                return;
            }
            break;

        case 2: // '\002'
            FB1D.onResumeFragments();
            FB1D.mFragments.mHost.mFragmentManager.execPendingActions();
            return;

        default:
            super.handleMessage(message);
            break;
        }
    }
}
