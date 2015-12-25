// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.metadata;


public interface MetadataParser
{

    public abstract boolean canParse(String s);

    public abstract Object parse(byte abyte0[], int i);
}
