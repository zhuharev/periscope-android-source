// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.services;

import com.twitter.sdk.android.core.Callback;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;

public interface MediaService
{

    public abstract void upload(TypedFile typedfile, TypedFile typedfile1, TypedString typedstring, Callback callback);
}
