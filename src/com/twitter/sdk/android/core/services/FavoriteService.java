// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;

public interface FavoriteService
{

    public abstract void create(Long long1, Boolean boolean1, Callback callback);

    public abstract void destroy(Long long1, Boolean boolean1, Callback callback);

    public abstract void list(Long long1, String s, Integer integer, String s1, String s2, Boolean boolean1, Callback callback);
}
