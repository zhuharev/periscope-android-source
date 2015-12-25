// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.crypto.signers.DSASigner;
import org.spongycastle.crypto.signers.HMacDSAKCalculator;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsDSASigner, TlsUtils

public class TlsDSSSigner extends TlsDSASigner
{

    public TlsDSSSigner()
    {
    }

    public final boolean _mth02CE(AsymmetricKeyParameter asymmetrickeyparameter)
    {
        return asymmetrickeyparameter instanceof DSAPublicKeyParameters;
    }

    protected final short _mth0E05()
    {
        return 2;
    }

    protected final DSA _mth141D(short word0)
    {
        return new DSASigner(new HMacDSAKCalculator(TlsUtils._mth02BD(word0)));
    }
}
