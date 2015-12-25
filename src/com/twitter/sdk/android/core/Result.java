// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import retrofit.client.Response;

public class Result
{

    public final Object data;
    public final Response response;

    public Result(Object obj, Response response1)
    {
        data = obj;
        response = response1;
    }
}
