// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;


abstract class ClosedCaption
{

    public static final int TYPE_CTRL = 0;
    public static final int TYPE_TEXT = 1;
    public final int type;

    protected ClosedCaption(int i)
    {
        type = i;
    }
}
