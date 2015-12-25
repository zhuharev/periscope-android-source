// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import o.vw;

public final class Header
{

    public static final vw RESPONSE_STATUS = vw._mth02C0(":status");
    public static final vw TARGET_AUTHORITY = vw._mth02C0(":authority");
    public static final vw TARGET_HOST = vw._mth02C0(":host");
    public static final vw TARGET_METHOD = vw._mth02C0(":method");
    public static final vw TARGET_PATH = vw._mth02C0(":path");
    public static final vw TARGET_SCHEME = vw._mth02C0(":scheme");
    public static final vw VERSION = vw._mth02C0(":version");
    final int hpackSize;
    public final vw name;
    public final vw value;

    public Header(String s, String s1)
    {
        this(vw._mth02C0(s), vw._mth02C0(s1));
    }

    public Header(vw vw1, String s)
    {
        this(vw1, vw._mth02C0(s));
    }

    public Header(vw vw1, vw vw2)
    {
        name = vw1;
        value = vw2;
        hpackSize = vw1.data.length + 32 + vw2.data.length;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Header)
        {
            obj = (Header)obj;
            return name.equals(((Header) (obj)).name) && value.equals(((Header) (obj)).value);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (name.hashCode() + 527) * 31 + value.hashCode();
    }

    public final String toString()
    {
        return String.format("%s: %s", new Object[] {
            name._mth0178(), value._mth0178()
        });
    }

}
