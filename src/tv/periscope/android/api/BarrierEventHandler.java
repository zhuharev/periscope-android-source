// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.util.Collections;
import java.util.HashSet;
import o.zu;
import o.zy;

// Referenced classes of package tv.periscope.android.api:
//            ApiEventHandler

public class BarrierEventHandler
    implements ApiEventHandler
{

    private final ApiManager.OnCompleteCallback mCallback;
    private final HashSet mExpect = new HashSet();
    private int mSuccess;

    public BarrierEventHandler(ApiManager.OnCompleteCallback oncompletecallback)
    {
        mCallback = oncompletecallback;
    }

    private void dispatchComplete(int i)
    {
        mCallback.onComplete(i);
    }

    private void dispatchReceive(zu zu1)
    {
        mCallback.onReceive(zu1);
    }

    private void dispatchRetry(zy zy)
    {
        mCallback.onRetry(zy);
    }

    public boolean allFailed()
    {
        return mSuccess == 0;
    }

    public transient BarrierEventHandler expect(o.zu.if aif[])
    {
        Collections.addAll(mExpect, aif);
        mSuccess = mExpect.size();
        return this;
    }

    public void onEventMainThread(zu zu1)
    {
        if (mExpect.remove(zu1.aXk))
        {
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                mSuccess = mSuccess - 1;
            }
            dispatchReceive(zu1);
            if (mExpect.isEmpty())
            {
                dispatchComplete(mSuccess);
            }
        }
    }

    public void onEventMainThread(zy zy)
    {
        dispatchRetry(zy);
    }
}
