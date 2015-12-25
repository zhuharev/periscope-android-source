// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Media;

// Referenced classes of package o:
//            agj

final class agk extends Callback
{

    private int bjK;
    private int bjL;
    private String bjM;
    private String bjN;
    private agj bjO;
    private Callback val$callback;

    agk(agj agj1, int i, int j, String s, String s1, Callback callback)
    {
        bjO = agj1;
        bjK = i;
        bjL = j;
        bjM = s;
        bjN = s1;
        val$callback = callback;
        super();
    }

    public final void failure(TwitterException twitterexception)
    {
        if (val$callback != null)
        {
            val$callback.failure(twitterexception);
        }
    }

    public final void success(Result result)
    {
        result = ((Media)result.data).mediaIdString;
        bjO._mth02CB(bjK, bjL, bjM, bjN, result, val$callback);
    }
}
