// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            McElieceFujisakiCipherSpi

public static class a extends McElieceFujisakiCipherSpi
{

    public a()
    {
        super(new SHA384Digest(), new McElieceFujisakiCipher());
    }
}
