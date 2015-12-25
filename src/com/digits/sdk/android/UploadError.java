// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


class UploadError
{

    final int code;
    final int item;
    final String message;

    UploadError(int i, String s, int j)
    {
        code = i;
        message = s;
        item = j;
    }
}
