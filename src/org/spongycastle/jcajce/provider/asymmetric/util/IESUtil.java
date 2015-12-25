// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.jce.spec.IESParameterSpec;

public class IESUtil
{

    public IESUtil()
    {
    }

    public static IESParameterSpec _mth02CA(IESEngine iesengine)
    {
        if (iesengine.arO == null)
        {
            return new IESParameterSpec(null, null, 128);
        }
        if (iesengine.arO._mth14AD()._mth14AC().equals("DES") || iesengine.arO._mth14AD()._mth14AC().equals("RC2") || iesengine.arO._mth14AD()._mth14AC().equals("RC5-32") || iesengine.arO._mth14AD()._mth14AC().equals("RC5-64"))
        {
            return new IESParameterSpec(null, null, 64, 64);
        }
        if (iesengine.arO._mth14AD()._mth14AC().equals("SKIPJACK"))
        {
            return new IESParameterSpec(null, null, 80, 80);
        }
        if (iesengine.arO._mth14AD()._mth14AC().equals("GOST28147"))
        {
            return new IESParameterSpec(null, null, 256, 256);
        } else
        {
            return new IESParameterSpec(null, null, 128, 128);
        }
    }
}
