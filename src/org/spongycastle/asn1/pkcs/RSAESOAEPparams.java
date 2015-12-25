// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers

public class RSAESOAEPparams extends ASN1Object
{

    private static AlgorithmIdentifier ade;
    private static AlgorithmIdentifier adf;
    private static AlgorithmIdentifier adg;
    public AlgorithmIdentifier adb;
    public AlgorithmIdentifier adc;
    public AlgorithmIdentifier add;

    public RSAESOAEPparams()
    {
        adb = ade;
        adc = adf;
        add = adg;
    }

    private RSAESOAEPparams(ASN1Sequence asn1sequence)
    {
        adb = ade;
        adc = adf;
        add = adg;
        for (int i = 0; i != asn1sequence.size(); i++)
        {
            ASN1TaggedObject asn1taggedobject = (ASN1TaggedObject)asn1sequence._mth144B(i);
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                adb = AlgorithmIdentifier._mth02BE(asn1taggedobject, true);
                break;

            case 1: // '\001'
                adc = AlgorithmIdentifier._mth02BE(asn1taggedobject, true);
                break;

            case 2: // '\002'
                add = AlgorithmIdentifier._mth02BE(asn1taggedobject, true);
                break;

            default:
                throw new IllegalArgumentException("unknown tag");
            }
        }

    }

    public RSAESOAEPparams(AlgorithmIdentifier algorithmidentifier, AlgorithmIdentifier algorithmidentifier1, AlgorithmIdentifier algorithmidentifier2)
    {
        adb = algorithmidentifier;
        adc = algorithmidentifier1;
        add = algorithmidentifier2;
    }

    public static RSAESOAEPparams _mth1D40(Object obj)
    {
        if (obj != null)
        {
            return new RSAESOAEPparams(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (!adb.equals(ade))
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(true, 0, adb);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (!adc.equals(adf))
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(true, 1, adc);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        if (!add.equals(adg))
        {
            DERTaggedObject dertaggedobject2 = new DERTaggedObject(true, 2, add);
            asn1encodablevector.VS.addElement(dertaggedobject2);
        }
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        ade = new AlgorithmIdentifier(OIWObjectIdentifiers.aav, DERNull.WL);
        adf = new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, ade);
        adg = new AlgorithmIdentifier(PKCSObjectIdentifiers.abe, new DEROctetString(new byte[0]));
    }
}
