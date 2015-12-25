// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.text.TextUtils;
import o.ig;
import o.is;
import o.ra;
import o.rl;
import o.ur;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterSession

static class 
    implements ur
{

    private final ig gson = new ig();

    public TwitterSession deserialize(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        s = (TwitterSession)gson._mth02CA(s, com/twitter/sdk/android/core/TwitterSession);
        return s;
        s;
        ra._mth0454()._mth02BE("Twitter", s.getMessage());
        return null;
    }

    public volatile Object deserialize(String s)
    {
        return deserialize(s);
    }

    public String serialize(TwitterSession twittersession)
    {
        if (twittersession == null || twittersession.getAuthToken() == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ig ig1 = gson;
        if (twittersession != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        return ig1._mth02CA(is.GB);
        twittersession = ig1._mth02CA(twittersession, twittersession.getClass());
        return twittersession;
        twittersession;
        ra._mth0454()._mth02BE("Twitter", twittersession.getMessage());
        return "";
    }

    public volatile String serialize(Object obj)
    {
        return serialize((TwitterSession)obj);
    }

    public ()
    {
    }
}
