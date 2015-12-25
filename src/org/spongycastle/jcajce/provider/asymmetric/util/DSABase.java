// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.jcajce.provider.asymmetric.util:
//            DSAEncoder

public abstract class DSABase extends SignatureSpi
    implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{

    public DSA aCZ;
    private DSAEncoder aEo;
    public Digest amS;

    public DSABase(Digest digest, DSA dsa, DSAEncoder dsaencoder)
    {
        amS = digest;
        aCZ = dsa;
        aEo = dsaencoder;
    }

    protected Object engineGetParameter(String s)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(String s, Object obj)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected void engineSetParameter(AlgorithmParameterSpec algorithmparameterspec)
    {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    protected byte[] engineSign()
    {
        Object aobj[] = new byte[amS._mth14AF()];
        amS.doFinal(((byte []) (aobj)), 0);
        try
        {
            aobj = aCZ._mth1428(((byte []) (aobj)));
            aobj = aEo._mth02CB(aobj[0], aobj[1]);
        }
        catch (Exception exception)
        {
            throw new SignatureException(exception.toString());
        }
        return ((byte []) (aobj));
    }

    protected void engineUpdate(byte byte0)
    {
        amS.update(byte0);
    }

    protected void engineUpdate(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    protected boolean engineVerify(byte abyte0[])
    {
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        try
        {
            abyte0 = aEo._mth1D57(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new SignatureException("error decoding signature bytes.");
        }
        return aCZ._mth02CA(abyte1, abyte0[0], abyte0[1]);
    }
}
