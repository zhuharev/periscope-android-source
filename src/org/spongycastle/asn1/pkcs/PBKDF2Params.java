// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers

public class PBKDF2Params extends ASN1Object
{

    public static final AlgorithmIdentifier aaR;
    private ASN1Integer Zt;
    public ASN1OctetString aaS;
    public ASN1Integer aaT;
    public AlgorithmIdentifier aaU;

    private PBKDF2Params(ASN1Sequence asn1sequence)
    {
        Enumeration enumeration = asn1sequence._mth0675();
        aaS = (ASN1OctetString)enumeration.nextElement();
        aaT = (ASN1Integer)enumeration.nextElement();
        if (enumeration.hasMoreElements())
        {
            asn1sequence = ((ASN1Sequence) (enumeration.nextElement()));
            if (asn1sequence instanceof ASN1Integer)
            {
                Zt = ASN1Integer.FB1D(asn1sequence);
                if (enumeration.hasMoreElements())
                {
                    asn1sequence = ((ASN1Sequence) (enumeration.nextElement()));
                } else
                {
                    asn1sequence = null;
                }
            } else
            {
                Zt = null;
            }
            if (asn1sequence != null)
            {
                aaU = AlgorithmIdentifier._mth01C3(asn1sequence);
            }
        }
    }

    public PBKDF2Params(byte abyte0[], int i)
    {
        aaS = new DEROctetString(abyte0);
        aaT = new ASN1Integer(i);
    }

    public static PBKDF2Params _mth02CD(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof PBKDF2Params)
        {
            return (PBKDF2Params)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new PBKDF2Params(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aaS;
        asn1encodablevector.VS.addElement(obj);
        obj = aaT;
        asn1encodablevector.VS.addElement(obj);
        if (Zt != null)
        {
            ASN1Integer asn1integer = Zt;
            asn1encodablevector.VS.addElement(asn1integer);
        }
        if (aaU != null && !aaU.equals(aaR))
        {
            AlgorithmIdentifier algorithmidentifier = aaU;
            asn1encodablevector.VS.addElement(algorithmidentifier);
        }
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        aaR = new AlgorithmIdentifier(PKCSObjectIdentifiers.abD, DERNull.WL);
    }
}
