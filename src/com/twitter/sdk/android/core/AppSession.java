// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import o.ig;
import o.im;
import o.is;
import o.ra;
import o.rl;
import o.ur;

// Referenced classes of package com.twitter.sdk.android.core:
//            Session, AuthTokenAdapter

public class AppSession extends Session
{
    static class Serializer
        implements ur
    {

        private final ig gson = (new im())._mth02CA(com/twitter/sdk/android/core/internal/oauth/OAuth2Token, new AuthTokenAdapter())._mth0490();

        public AppSession deserialize(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_51;
            }
            s = (AppSession)gson._mth02CA(s, com/twitter/sdk/android/core/AppSession);
            return s;
            s;
            ra._mth0454()._mth02BE("Twitter", (new StringBuilder("Failed to deserialize session ")).append(s.getMessage()).toString());
            return null;
        }

        public volatile Object deserialize(String s)
        {
            return deserialize(s);
        }

        public String serialize(AppSession appsession)
        {
            if (appsession == null || appsession.getAuthToken() == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            ig ig1 = gson;
            if (appsession != null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            return ig1._mth02CA(is.GB);
            appsession = ig1._mth02CA(appsession, appsession.getClass());
            return appsession;
            appsession;
            ra._mth0454()._mth02BE("Twitter", (new StringBuilder("Failed to serialize session ")).append(appsession.getMessage()).toString());
            return "";
        }

        public volatile String serialize(Object obj)
        {
            return serialize((AppSession)obj);
        }

        public Serializer()
        {
        }
    }


    AppSession(GuestAuthToken guestauthtoken)
    {
        super(guestauthtoken, 0L);
    }

    AppSession(OAuth2Token oauth2token)
    {
        super(oauth2token, 0L);
    }
}
