// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;

public interface StatusesService
{

    public abstract void destroy(Long long1, Boolean boolean1, Callback callback);

    public abstract void homeTimeline(Integer integer, Long long1, Long long2, Boolean boolean1, Boolean boolean2, Boolean boolean3, Boolean boolean4, 
            Callback callback);

    public abstract void lookup(String s, Boolean boolean1, Boolean boolean2, Boolean boolean3, Callback callback);

    public abstract void mentionsTimeline(Integer integer, Long long1, Long long2, Boolean boolean1, Boolean boolean2, Boolean boolean3, Callback callback);

    public abstract void retweet(Long long1, Boolean boolean1, Callback callback);

    public abstract void retweetsOfMe(Integer integer, Long long1, Long long2, Boolean boolean1, Boolean boolean2, Boolean boolean3, Callback callback);

    public abstract void show(Long long1, Boolean boolean1, Boolean boolean2, Boolean boolean3, Callback callback);

    public abstract void unretweet(Long long1, Boolean boolean1, Callback callback);

    public abstract void update(String s, Long long1, Boolean boolean1, Double double1, Double double2, String s1, Boolean boolean2, 
            Boolean boolean3, Callback callback);

    public abstract void update(String s, Long long1, Boolean boolean1, Double double1, Double double2, String s1, Boolean boolean2, 
            Boolean boolean3, String s2, Callback callback);

    public abstract void userTimeline(Long long1, String s, Integer integer, Long long2, Long long3, Boolean boolean1, Boolean boolean2, 
            Boolean boolean3, Boolean boolean4, Callback callback);
}
