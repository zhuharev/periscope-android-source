// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import java.util.Collections;
import java.util.List;
import o.ql;
import o.yv;
import o.zu;
import o.zw;
import o.zy;

// Referenced classes of package tv.periscope.android.api:
//            ApiManager

class mFeaturedBroadcasts
    implements CompleteCallback
{

    private List mFeaturedBroadcasts;
    private List mFollowingBroadcasts;
    private List mGlobalBroadcasts;
    final ApiManager this$0;

    public void onComplete(int i)
    {
        if (i == 0)
        {
            ApiManager.access$100(ApiManager.this).mEventBus._mth1429(zw.aYH);
            return;
        } else
        {
            ApiManager.access$100(ApiManager.this)._mth02CA(mFeaturedBroadcasts, mFollowingBroadcasts, mGlobalBroadcasts);
            return;
        }
    }

    public void onReceive(zu zu1)
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
            ApiManager.access$000(ApiManager.this).onEventMainThread(zu1);
            return;
        }
        switch (.SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.()])
        {
        default:
            return;

        case 1: // '\001'
            mGlobalBroadcasts = (List)zu1.data;
            return;

        case 2: // '\002'
            mFeaturedBroadcasts = (List)zu1.data;
            return;

        case 3: // '\003'
            mFollowingBroadcasts = (List)zu1.data;
            break;
        }
    }

    public void onRetry(zy zy)
    {
        ApiManager.access$000(ApiManager.this).onEventMainThread(zy);
    }

    entHandler()
    {
        this$0 = ApiManager.this;
        super();
        mGlobalBroadcasts = Collections.emptyList();
        mFollowingBroadcasts = Collections.emptyList();
        mFeaturedBroadcasts = Collections.emptyList();
    }
}
