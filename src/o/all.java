// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

// Referenced classes of package o:
//            alo, alk, akx

final class all extends Callback
{

    all()
    {
    }

    public final void failure(TwitterException twitterexception)
    {
        alk.FB5C(alo.brY);
        alk._mth02CA(new akx(null, null, null, twitterexception));
    }

    public final void success(Result result)
    {
        alk.FB5C(alo.brX);
        alk._mth02CA(new akx((TwitterSession)result.data, null, null, null));
    }
}
