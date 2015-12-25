// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

// Referenced classes of package org.spongycastle.crypto.tls:
//            SignatureAndHashAlgorithm, TlsContext

public interface TlsSigner
{

    public abstract Signer _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter);

    public abstract void _mth02CA(TlsContext tlscontext);

    public abstract boolean _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, byte abyte0[], AsymmetricKeyParameter asymmetrickeyparameter, byte abyte1[]);

    public abstract byte[] _mth02CA(AsymmetricKeyParameter asymmetrickeyparameter, byte abyte0[]);

    public abstract byte[] _mth02CA(SignatureAndHashAlgorithm signatureandhashalgorithm, AsymmetricKeyParameter asymmetrickeyparameter, byte abyte0[]);

    public abstract boolean _mth02CE(AsymmetricKeyParameter asymmetrickeyparameter);
}
