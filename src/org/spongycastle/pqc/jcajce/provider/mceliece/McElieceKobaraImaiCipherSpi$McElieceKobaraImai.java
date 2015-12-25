// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.jcajce.provider.mceliece;

import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;

// Referenced classes of package org.spongycastle.pqc.jcajce.provider.mceliece:
//            McElieceKobaraImaiCipherSpi

public static class  extends McElieceKobaraImaiCipherSpi
{

    public ()
    {
        super(new SHA1Digest(), new McElieceKobaraImaiCipher());
    }
}
