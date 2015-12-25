// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public final class aum
    implements CookiePolicy
{

    public aum()
    {
    }

    static String _mth02CA(HttpCookie httpcookie)
    {
        httpcookie = httpcookie.getDomain();
        if (httpcookie.startsWith("."))
        {
            return httpcookie;
        } else
        {
            return (new StringBuilder(".")).append(httpcookie).toString();
        }
    }

    public final boolean shouldAccept(URI uri, HttpCookie httpcookie)
    {
        return HttpCookie.domainMatches(_mth02CA(httpcookie), uri.getHost());
    }
}
