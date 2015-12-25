// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import o.yo;
import o.yq;

// Referenced classes of package tv.periscope.android.api:
//            RestClient, ApiService

public class ApiClient extends RestClient
{

    public ApiClient(Context context, Executor executor)
    {
        super(context, executor, getEndpoint(context), tv/periscope/android/api/ApiService);
    }

    private static String getEndpoint(Context context)
    {
        if (o._cls30CE.if._mth1428(context))
        {
            return (new StringBuilder()).append(context.getApplicationContext().getSharedPreferences("api_tweaks", 0).getString("pref_local_api", "https://dev-api.periscope.tv")).append("/api/v").append("2").toString();
        }
        if (o._cls30CE.if.FE73(context))
        {
            return (String)o.yp.CON._mth02CA("o.yp").getField("aVv").get(null);
        } else
        {
            return yo.aVs.m();
        }
    }
}
