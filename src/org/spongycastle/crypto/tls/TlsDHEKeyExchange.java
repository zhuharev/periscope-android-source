// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.util.io.TeeInputStream;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsDHKeyExchange, TlsSignerCredentials, TlsFatalAlert, TlsCredentials, 
//            TlsContext, SignerInputBuffer, ServerDHParams, DigitallySigned, 
//            TlsSigner, SecurityParameters, TlsDHUtils, DigestInputBuffer, 
//            TlsUtils, SignatureAndHashAlgorithm, CombinedHash

public class TlsDHEKeyExchange extends TlsDHKeyExchange
{

    private TlsSignerCredentials aBE;

    public TlsDHEKeyExchange(int i, Vector vector, DHParameters dhparameters)
    {
        super(i, vector, null);
        aBE = null;
    }

    public final void _mth02CA(TlsCredentials tlscredentials)
    {
        if (!(tlscredentials instanceof TlsSignerCredentials))
        {
            throw new TlsFatalAlert((short)80);
        } else
        {
            _mth02CA(tlscredentials._mth067B());
            aBE = (TlsSignerCredentials)tlscredentials;
            return;
        }
    }

    public final void _mth02CB(ByteArrayInputStream bytearrayinputstream)
    {
        SecurityParameters securityparameters = azJ._mth03DC();
        SignerInputBuffer signerinputbuffer = new SignerInputBuffer();
        ServerDHParams serverdhparams = ServerDHParams._mth141D(new TeeInputStream(bytearrayinputstream, signerinputbuffer));
        bytearrayinputstream = DigitallySigned._mth02CA(azJ, bytearrayinputstream);
        Signer signer = aBF._mth02CA(bytearrayinputstream._mth072B(), aBH);
        signer.update(securityparameters.aBj, 0, securityparameters.aBj.length);
        signer.update(securityparameters.aBk, 0, securityparameters.aBk.length);
        signerinputbuffer._mth02CA(signer);
        if (!signer.FE73(bytearrayinputstream.getSignature()))
        {
            throw new TlsFatalAlert((short)51);
        } else
        {
            aBI = TlsDHUtils._mth02CA(serverdhparams._mth09A8());
            return;
        }
    }

    public final byte[] _mth04ED()
    {
        if (aBG == null)
        {
            throw new TlsFatalAlert((short)80);
        }
        DigestInputBuffer digestinputbuffer = new DigestInputBuffer();
        aBL = TlsDHUtils._mth02CA(azJ._mth03D2(), aBG, digestinputbuffer);
        SignatureAndHashAlgorithm signatureandhashalgorithm;
        Object obj;
        if (TlsUtils._mth02CF(azJ))
        {
            signatureandhashalgorithm = aBE._mth050F();
            if (signatureandhashalgorithm == null)
            {
                throw new TlsFatalAlert((short)80);
            }
            obj = TlsUtils._mth02BD(signatureandhashalgorithm._mth09AA());
        } else
        {
            signatureandhashalgorithm = null;
            obj = new CombinedHash();
        }
        SecurityParameters securityparameters = azJ._mth03DC();
        ((Digest) (obj)).update(securityparameters.aBj, 0, securityparameters.aBj.length);
        ((Digest) (obj)).update(securityparameters.aBk, 0, securityparameters.aBk.length);
        digestinputbuffer._mth02CB(((Digest) (obj)));
        byte abyte0[] = new byte[((Digest) (obj))._mth14AF()];
        ((Digest) (obj)).doFinal(abyte0, 0);
        (new DigitallySigned(signatureandhashalgorithm, aBE._mth15EE(abyte0)))._mth02CB(digestinputbuffer);
        return digestinputbuffer.toByteArray();
    }
}
