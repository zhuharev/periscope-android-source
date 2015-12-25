// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionParameters

public class NTRUEncryptionKeyParameters extends AsymmetricKeyParameter
{

    protected final NTRUEncryptionParameters aMP;

    public NTRUEncryptionKeyParameters(boolean flag, NTRUEncryptionParameters ntruencryptionparameters)
    {
        super(flag);
        aMP = ntruencryptionparameters;
    }

    public final NTRUEncryptionParameters _mth06D2()
    {
        return aMP;
    }
}
