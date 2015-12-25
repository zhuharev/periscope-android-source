// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.content.Context;
import java.util.Locale;
import o.aos;
import retrofit.RequestInterceptor;

// Referenced classes of package tv.periscope.android.api:
//            RestClient

class val.context
    implements RequestInterceptor
{

    final RestClient this$0;
    final Context val$context;

    public void intercept(retrofit.eptor.RequestFacade requestfacade)
    {
        requestfacade.addHeader("User-Agent", "tv.periscope.android/1.3.2 (1900162)");
        requestfacade.addHeader("package", "tv.periscope.android");
        requestfacade.addHeader("build", "76d06c0");
        requestfacade.addHeader("locale", Locale.getDefault().getLanguage());
        requestfacade.addHeader("install_id", aos._mth1D4B(val$context));
        requestfacade.addHeader("os", aos.dF());
    }

    ade()
    {
        this$0 = final_restclient;
        val$context = Context.this;
        super();
    }
}
