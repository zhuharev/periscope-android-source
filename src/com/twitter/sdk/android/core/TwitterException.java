// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;


public class TwitterException extends RuntimeException
{

    public TwitterException(String s)
    {
        super(s);
    }

    public TwitterException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
