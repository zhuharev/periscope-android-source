// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.AppAuthToken;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import o.ig;
import o.ip;
import o.iq;
import o.is;
import o.it;
import o.iw;
import o.ix;
import o.kd;
import o.kx;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterAuthToken, AuthToken

public class AuthTokenAdapter
    implements ix, ip
{

    private static final String AUTH_TOKEN = "auth_token";
    private static final String AUTH_TYPE = "auth_type";
    static final Map authTypeRegistry;
    private final ig gson = new ig();

    public AuthTokenAdapter()
    {
    }

    static String getAuthTypeString(Class class1)
    {
        for (Iterator iterator = authTypeRegistry.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((Class)entry.getValue()).equals(class1))
            {
                return (String)entry.getKey();
            }
        }

        return "";
    }

    public AuthToken deserialize$1293bb37(iq iq1, Type type, o._cls141F.if if1)
    {
        type = iq1._mth0673();
        iq1 = ((iw)((it) (type)).GC.get("auth_type"))._mth04AE();
        type = (iq)((it) (type)).GC.get("auth_token");
        return (AuthToken)gson._mth02CA(type, (Class)authTypeRegistry.get(iq1));
    }

    public Object deserialize$140ae884(iq iq1, Type type, o._cls141F.if if1)
    {
        return deserialize$1293bb37(iq1, type, if1);
    }

    public iq serialize$117eb95b(Object obj, Type type, o._cls141F.if if1)
    {
        return serialize$3a407aa8((AuthToken)obj, type, if1);
    }

    public iq serialize$3a407aa8(AuthToken authtoken, Type type, o._cls141F.if if1)
    {
        if1 = new it();
        if1._mth02BD("auth_type", getAuthTypeString(authtoken.getClass()));
        type = gson;
        if (authtoken == null)
        {
            authtoken = is.GB;
        } else
        {
            Class class1 = authtoken.getClass();
            kx kx1 = new kx();
            type._mth02CA(authtoken, class1, kx1);
            authtoken = kx1._mth13A8();
        }
        type = authtoken;
        if (authtoken == null)
        {
            type = is.GB;
        }
        ((it) (if1)).GC.put("auth_token", type);
        return if1;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        authTypeRegistry = hashmap;
        hashmap.put("oauth1a", com/twitter/sdk/android/core/TwitterAuthToken);
        authTypeRegistry.put("oauth2", com/twitter/sdk/android/core/internal/oauth/OAuth2Token);
        authTypeRegistry.put("guest", com/twitter/sdk/android/core/internal/oauth/GuestAuthToken);
        authTypeRegistry.put("app", com/twitter/sdk/android/core/internal/oauth/AppAuthToken);
    }
}
