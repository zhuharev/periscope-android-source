// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

// Referenced classes of package org.spongycastle.crypto.prng:
//            EntropySourceProvider

public class BasicEntropySourceProvider
    implements EntropySourceProvider
{

    private final SecureRandom axM;
    private final boolean axN;

    public BasicEntropySourceProvider(SecureRandom securerandom, boolean flag)
    {
        axM = securerandom;
        axN = flag;
    }

    static SecureRandom _mth02CA(BasicEntropySourceProvider basicentropysourceprovider)
    {
        return basicentropysourceprovider.axM;
    }
}
