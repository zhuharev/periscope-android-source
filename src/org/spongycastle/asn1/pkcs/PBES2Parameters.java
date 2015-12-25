// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers, KeyDerivationFunc, PBKDF2Params, EncryptionScheme

public class PBES2Parameters extends ASN1Object
    implements PKCSObjectIdentifiers
{

    public KeyDerivationFunc aaP;
    public EncryptionScheme aaQ;

    private PBES2Parameters(ASN1Sequence asn1sequence)
    {
        asn1sequence = asn1sequence._mth0675();
        ASN1Sequence asn1sequence1 = ASN1Sequence._mth141F(((ASN1Encodable)asn1sequence.nextElement())._mth0427());
        if (asn1sequence1._mth144B(0).equals(abu))
        {
            aaP = new KeyDerivationFunc(abu, PBKDF2Params._mth02CD(asn1sequence1._mth144B(1)));
        } else
        {
            aaP = KeyDerivationFunc._mth02CB(asn1sequence1);
        }
        aaQ = EncryptionScheme._mth1D36(asn1sequence.nextElement());
    }

    public static PBES2Parameters _mth02CC(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof PBES2Parameters)
        {
            return (PBES2Parameters)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new PBES2Parameters(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaP;
        asn1encodablevector.VS.addElement(obj);
        obj = aaQ;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
