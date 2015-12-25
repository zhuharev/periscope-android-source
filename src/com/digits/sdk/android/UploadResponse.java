// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.util.List;

public class UploadResponse
{

    final List errors;

    UploadResponse(List list)
    {
        errors = list;
    }
}
