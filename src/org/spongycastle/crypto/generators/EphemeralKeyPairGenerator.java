// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyEncoder;

public class EphemeralKeyPairGenerator
{

    public AsymmetricCipherKeyPairGenerator aud;
    public KeyEncoder aue;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetriccipherkeypairgenerator, KeyEncoder keyencoder)
    {
        aud = asymmetriccipherkeypairgenerator;
        aue = keyencoder;
    }
}
