// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.User;

public interface AccountService
{

    public abstract User verifyCredentials(Boolean boolean1, Boolean boolean2);

    public abstract void verifyCredentials(Boolean boolean1, Boolean boolean2, Callback callback);
}
