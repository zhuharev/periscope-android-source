// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;

public class CramerShoupCoreEngine
{
    public static class CramerShoupCiphertextException extends Exception
    {
    }


    private String label;

    public CramerShoupCoreEngine()
    {
        label = null;
    }

    static 
    {
        BigInteger.valueOf(1L);
    }
}
