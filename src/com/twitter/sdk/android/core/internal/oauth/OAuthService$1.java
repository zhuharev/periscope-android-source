// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import retrofit.RequestInterceptor;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuthService

class this._cls0
    implements RequestInterceptor
{

    final OAuthService this$0;

    public void intercept(retrofit.tor.RequestFacade requestfacade)
    {
        requestfacade.addHeader("User-Agent", getUserAgent());
    }

    ()
    {
        this$0 = OAuthService.this;
        super();
    }
}
