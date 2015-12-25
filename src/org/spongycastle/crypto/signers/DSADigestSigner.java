// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DSADigestSigner
    implements Signer
{

    private final Digest amS;
    private final DSA ayY;
    private boolean ayZ;

    public DSADigestSigner(DSA dsa, Digest digest)
    {
        amS = digest;
        ayY = dsa;
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        ayZ = flag;
        AsymmetricKeyParameter asymmetrickeyparameter;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)((ParametersWithRandom)cipherparameters).axC;
        } else
        {
            asymmetrickeyparameter = (AsymmetricKeyParameter)cipherparameters;
        }
        if (flag && !asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        }
        if (!flag && asymmetrickeyparameter.awQ)
        {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        } else
        {
            amS.reset();
            ayY._mth02CA(flag, cipherparameters);
            return;
        }
    }

    public final byte[] _mth14B6()
    {
        IOException ioexception;
        if (!ayZ)
        {
            throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
        }
        Object aobj[] = new byte[amS._mth14AF()];
        amS.doFinal(((byte []) (aobj)), 0);
        aobj = ayY._mth1428(((byte []) (aobj)));
        Object obj = aobj[0];
        BigInteger biginteger = aobj[1];
        try
        {
            ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
            obj = new ASN1Integer(((BigInteger) (obj)));
            asn1encodablevector.VS.addElement(obj);
            obj = new ASN1Integer(biginteger);
            asn1encodablevector.VS.addElement(obj);
            asn1encodablevector = (new DERSequence(asn1encodablevector)).getEncoded("DER");
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new IllegalStateException("unable to encode signature");
        }
        return asn1encodablevector;
    }

    public final boolean FE73(byte abyte0[])
    {
        if (ayZ)
        {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
        byte abyte1[] = new byte[amS._mth14AF()];
        amS.doFinal(abyte1, 0);
        boolean flag;
        try
        {
            abyte0 = (ASN1Sequence)ASN1Primitive._mth0640(abyte0);
            BigInteger abiginteger[] = new BigInteger[2];
            abiginteger[0] = new BigInteger(((ASN1Integer)abyte0._mth144B(0)).bytes);
            abiginteger[1] = new BigInteger(((ASN1Integer)abyte0._mth144B(1)).bytes);
            flag = ayY._mth02CA(abyte1, abiginteger[0], abiginteger[1]);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return false;
        }
        return flag;
    }
}
