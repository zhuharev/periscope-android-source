// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.text.TextUtils;
import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.AuthTokenAdapter;
import java.io.StringReader;
import o.ig;
import o.im;
import o.is;
import o.ki;
import o.ra;
import o.rl;
import o.ur;

// Referenced classes of package com.digits.sdk.android:
//            DigitsSession

public static class 
    implements ur
{

    private static final String TAG = "Digits";
    private final ig gson = (new im())._mth02CA(com/twitter/sdk/android/core/AuthToken, new AuthTokenAdapter())._mth0490();

    public DigitsSession deserialize(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ig ig1 = gson;
        if (s == null)
        {
            s = null;
            break MISSING_BLOCK_LABEL_36;
        }
        s = ((String) (ig1._mth02CA(new StringReader(s), com/digits/sdk/android/DigitsSession)));
        s = (DigitsSession)ki._mth02BC(com/digits/sdk/android/DigitsSession).cast(s);
        if (DigitsSession.access$000(s) != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        s = new DigitsSession(s.getAuthToken(), s.getId(), "");
        return s;
        return s;
        s;
        ra._mth0454()._mth02BE("Digits", s.getMessage());
        return null;
    }

    public volatile Object deserialize(String s)
    {
        return deserialize(s);
    }

    public String serialize(DigitsSession digitssession)
    {
        if (digitssession == null || digitssession.getAuthToken() == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ig ig1 = gson;
        if (digitssession != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        return ig1._mth02CA(is.GB);
        digitssession = ig1._mth02CA(digitssession, digitssession.getClass());
        return digitssession;
        digitssession;
        ra._mth0454()._mth02BE("Digits", digitssession.getMessage());
        return "";
    }

    public volatile String serialize(Object obj)
    {
        return serialize((DigitsSession)obj);
    }

    public ()
    {
    }
}
