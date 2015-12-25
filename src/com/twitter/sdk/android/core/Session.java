// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;


// Referenced classes of package com.twitter.sdk.android.core:
//            AuthToken

public class Session
{

    private final AuthToken authToken;
    private final long id;

    public Session(AuthToken authtoken, long l)
    {
        authToken = authtoken;
        id = l;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Session)obj;
        if (id != ((Session) (obj)).id)
        {
            return false;
        }
        return authToken == null ? ((Session) (obj)).authToken == null : authToken.equals(((Session) (obj)).authToken);
    }

    public AuthToken getAuthToken()
    {
        return authToken;
    }

    public long getId()
    {
        return id;
    }

    public int hashCode()
    {
        int i;
        if (authToken != null)
        {
            i = authToken.hashCode();
        } else
        {
            i = 0;
        }
        return i * 31 + (int)(id ^ id >>> 32);
    }
}
