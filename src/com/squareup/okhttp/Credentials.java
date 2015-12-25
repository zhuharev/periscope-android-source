// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import o.vq;
import o.vw;

public final class Credentials
{

    private Credentials()
    {
    }

    public static String basic(String s, String s1)
    {
        try
        {
            s = vq._mth02BF(vw._mth02C9((new StringBuilder()).append(s).append(":").append(s1).toString().getBytes("ISO-8859-1")).data);
            s = (new StringBuilder("Basic ")).append(s).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError();
        }
        return s;
    }
}
