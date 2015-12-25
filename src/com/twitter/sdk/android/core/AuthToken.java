// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.AuthHeaders;

public abstract class AuthToken
    implements AuthHeaders
{

    public final long createdAt;

    public AuthToken()
    {
        createdAt = System.currentTimeMillis();
    }

    public AuthToken(long l)
    {
        createdAt = l;
    }

    public abstract boolean isExpired();
}
