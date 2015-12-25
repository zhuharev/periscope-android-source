// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import java.net.HttpURLConnection;
import retrofit.client.OkClient;
import retrofit.client.Request;

// Referenced classes of package com.twitter.sdk.android.core:
//            DefaultClient

class this._cls0 extends OkClient
{

    final DefaultClient this$0;

    protected HttpURLConnection openConnection(Request request)
    {
        return openSslConnection(super.openConnection(request));
    }

    ()
    {
        this$0 = DefaultClient.this;
        super();
    }
}
