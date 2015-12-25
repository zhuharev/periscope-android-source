// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.spec;

import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPublicKey;

public class MQVPublicKeySpec
    implements KeySpec, MQVPublicKey
{

    public String getAlgorithm()
    {
        return "ECMQV";
    }

    public byte[] getEncoded()
    {
        return null;
    }

    public String getFormat()
    {
        return null;
    }

    public final PublicKey _mth1E93()
    {
        return null;
    }

    public final PublicKey _mth1ECD()
    {
        return null;
    }
}
