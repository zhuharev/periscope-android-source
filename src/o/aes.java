// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.Toast;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;

// Referenced classes of package o:
//            xf, aed

final class aes extends Callback
{

    private aed bhH;

    aes(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void failure(TwitterException twitterexception)
    {
        xf._mth02CA(xf.if.aSq);
        Toast.makeText(bhH, 0x7f06016c, 1).show();
    }

    public final void success(Result result)
    {
        xf._mth02CA(xf.if.aSp);
        aed._mth02CE(bhH, true);
    }
}
