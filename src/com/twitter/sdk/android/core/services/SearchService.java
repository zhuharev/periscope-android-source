// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.services.params.Geocode;

public interface SearchService
{

    public abstract void tweets(String s, Geocode geocode, String s1, String s2, String s3, Integer integer, String s4, 
            Long long1, Long long2, Boolean boolean1, Callback callback);
}
