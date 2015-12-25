// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.crypto.prng:
//            EntropySource, BasicEntropySourceProvider

class 
    implements EntropySource
{

    private int axO;
    private BasicEntropySourceProvider axP;

    public final byte[] _mth01B3()
    {
        return BasicEntropySourceProvider._mth02CA(axP).generateSeed((axO + 7) / 8);
    }

    public final int _mth021A()
    {
        return axO;
    }
}
