// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;

public interface ListService
{

    public abstract void statuses(Long long1, String s, String s1, Long long2, Long long3, Long long4, Integer integer, 
            Boolean boolean1, Boolean boolean2, Callback callback);
}
