// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;


public class SupplementalDataEntry
{

    private int aBs;
    private byte data[];

    public SupplementalDataEntry(int i, byte abyte0[])
    {
        aBs = i;
        data = abyte0;
    }

    public final byte[] getData()
    {
        return data;
    }

    public final int getDataType()
    {
        return aBs;
    }
}
