// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


public class Image
{

    public final int h;
    public final String imageType;
    public final int w;

    public Image(int i, int j, String s)
    {
        w = i;
        h = j;
        imageType = s;
    }
}
