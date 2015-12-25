// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto;


// Referenced classes of package org.spongycastle.crypto:
//            AsymmetricCipherKeyPair, KeyEncoder

public class EphemeralKeyPair
{

    public AsymmetricCipherKeyPair amE;
    public KeyEncoder amF;

    public EphemeralKeyPair(AsymmetricCipherKeyPair asymmetriccipherkeypair, KeyEncoder keyencoder)
    {
        amE = asymmetriccipherkeypair;
        amF = keyencoder;
    }
}
