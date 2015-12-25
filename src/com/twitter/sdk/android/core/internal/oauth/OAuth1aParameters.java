// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import o.ra;
import o.rl;

class OAuth1aParameters
{

    private static final SecureRandom RAND = new SecureRandom();
    private static final String SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String VERSION = "1.0";
    private final TwitterAuthConfig authConfig;
    private final TwitterAuthToken authToken;
    private final String callback;
    private final String method;
    private final Map postParams;
    private final String url;

    public OAuth1aParameters(TwitterAuthConfig twitterauthconfig, TwitterAuthToken twitterauthtoken, String s, String s1, String s2, Map map)
    {
        authConfig = twitterauthconfig;
        authToken = twitterauthtoken;
        callback = s;
        method = s1;
        url = s2;
        postParams = map;
    }

    private void appendParameter(StringBuilder stringbuilder, String s, String s1)
    {
        if (s1 != null)
        {
            stringbuilder.append(' ').append(o._cls141D.if._mth02CF(s)).append("=\"").append(o._cls141D.if._mth02CF(s1)).append("\",");
        }
    }

    private String getEncodedQueryParams(TreeMap treemap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = treemap.size();
        int i = 0;
        treemap = treemap.entrySet().iterator();
        do
        {
            if (!treemap.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)treemap.next();
            stringbuilder.append(o._cls141D.if._mth02CF(o._cls141D.if._mth02CF((String)entry.getKey()))).append("%3D").append(o._cls141D.if._mth02CF(o._cls141D.if._mth02CF((String)entry.getValue())));
            i++;
            if (i < j)
            {
                stringbuilder.append("%26");
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String getNonce()
    {
        return (new StringBuilder()).append(String.valueOf(System.nanoTime())).append(String.valueOf(Math.abs(RAND.nextLong()))).toString();
    }

    private String getSigningKey()
    {
        String s;
        if (authToken != null)
        {
            s = authToken.secret;
        } else
        {
            s = null;
        }
        return (new StringBuilder()).append(o._cls141D.if._mth02CB(authConfig.getConsumerSecret())).append('&').append(o._cls141D.if._mth02CB(s)).toString();
    }

    private String getTimestamp()
    {
        return Long.toString(System.currentTimeMillis() / 1000L);
    }

    String calculateSignature(String s)
    {
        try
        {
            Object obj = getSigningKey();
            s = s.getBytes("UTF8");
            obj = new SecretKeySpec(((String) (obj)).getBytes("UTF8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(((java.security.Key) (obj)));
            s = mac.doFinal(s);
            s = new String(o.ug.if._mth02BB(s, 0, s.length), "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to calculate signature", s);
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to calculate signature", s);
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ra._mth0454()._mth02CB("Twitter", "Failed to calculate signature", s);
            return "";
        }
        return s;
    }

    String constructAuthorizationHeader(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder("OAuth");
        appendParameter(stringbuilder, "oauth_callback", callback);
        appendParameter(stringbuilder, "oauth_consumer_key", authConfig.getConsumerKey());
        appendParameter(stringbuilder, "oauth_nonce", s);
        appendParameter(stringbuilder, "oauth_signature", s2);
        appendParameter(stringbuilder, "oauth_signature_method", "HMAC-SHA1");
        appendParameter(stringbuilder, "oauth_timestamp", s1);
        if (authToken != null)
        {
            s = authToken.token;
        } else
        {
            s = null;
        }
        appendParameter(stringbuilder, "oauth_token", s);
        appendParameter(stringbuilder, "oauth_version", "1.0");
        return stringbuilder.substring(0, stringbuilder.length() - 1);
    }

    String constructSignatureBase(String s, String s1)
    {
        URI uri = URI.create(url);
        TreeMap treemap = o._cls141D.if._mth02CA(uri.getRawQuery(), true);
        if (postParams != null)
        {
            treemap.putAll(postParams);
        }
        if (callback != null)
        {
            treemap.put("oauth_callback", callback);
        }
        treemap.put("oauth_consumer_key", authConfig.getConsumerKey());
        treemap.put("oauth_nonce", s);
        treemap.put("oauth_signature_method", "HMAC-SHA1");
        treemap.put("oauth_timestamp", s1);
        if (authToken != null && authToken.token != null)
        {
            treemap.put("oauth_token", authToken.token);
        }
        treemap.put("oauth_version", "1.0");
        s = (new StringBuilder()).append(uri.getScheme()).append("://").append(uri.getHost()).append(uri.getPath()).toString();
        return (new StringBuilder()).append(method.toUpperCase(Locale.ENGLISH)).append('&').append(o._cls141D.if._mth02CF(s)).append('&').append(getEncodedQueryParams(treemap)).toString();
    }

    public String getAuthorizationHeader()
    {
        String s = getNonce();
        String s1 = getTimestamp();
        return constructAuthorizationHeader(s, s1, calculateSignature(constructSignatureBase(s, s1)));
    }

}
