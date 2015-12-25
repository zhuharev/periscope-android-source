// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.agreement.kdf:
//            DHKDFParameters

public class ECDHKEKGenerator
    implements DigestDerivationFunction
{

    private int Yp;
    private ASN1ObjectIdentifier amP;
    private byte amQ[];
    private KDF2BytesGenerator amU;

    public ECDHKEKGenerator(SHA1Digest sha1digest)
    {
        amU = new KDF2BytesGenerator(sha1digest);
    }

    public final int _mth02BF(byte abyte0[], int i, int j)
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = new AlgorithmIdentifier(amP, DERNull.WL);
        asn1encodablevector.VS.addElement(obj);
        obj = new DERTaggedObject(true, 2, new DEROctetString(Pack._mth1D31(Yp)));
        asn1encodablevector.VS.addElement(obj);
        try
        {
            amU._mth02CA(new KDFParameters(amQ, (new DERSequence(asn1encodablevector)).getEncoded("DER")));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException((new StringBuilder("unable to initialise kdf: ")).append(abyte0.getMessage()).toString());
        }
        return amU._mth02BF(abyte0, i, j);
    }

    public final void _mth02CA(DerivationParameters derivationparameters)
    {
        derivationparameters = (DHKDFParameters)derivationparameters;
        amP = ((DHKDFParameters) (derivationparameters)).amP;
        Yp = ((DHKDFParameters) (derivationparameters)).Yp;
        amQ = ((DHKDFParameters) (derivationparameters)).amQ;
    }
}
