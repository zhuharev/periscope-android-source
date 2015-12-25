// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;


// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterException

public class TwitterAuthException extends TwitterException
{

    private static final long serialVersionUID = 0x8020878bacaa03aL;

    public TwitterAuthException(String s)
    {
        super(s);
    }

    public TwitterAuthException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
