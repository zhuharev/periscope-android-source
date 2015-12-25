// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.pkcs;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

// Referenced classes of package org.spongycastle.asn1.pkcs:
//            PKCSObjectIdentifiers

public class RSASSAPSSparams extends ASN1Object
{

    private static AlgorithmIdentifier ade;
    private static AlgorithmIdentifier adf;
    private static ASN1Integer adt = new ASN1Integer(20L);
    private static ASN1Integer adu = new ASN1Integer(1L);
    public AlgorithmIdentifier adb;
    public AlgorithmIdentifier adc;
    public ASN1Integer adr;
    public ASN1Integer ads;

    public RSASSAPSSparams()
    {
        adb = ade;
        adc = adf;
        adr = adt;
        ads = adu;
    }

    private RSASSAPSSparams(ASN1Sequence asn1sequence)
    {
        adb = ade;
        adc = adf;
        adr = adt;
        ads = adu;
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
                adr = ASN1Integer._mth02CB(asn1taggedobject, true);
                break;

            case 3: // '\003'
                ads = ASN1Integer._mth02CB(asn1taggedobject, true);
                break;

            default:
                throw new IllegalArgumentException("unknown tag");
            }
        }

    }

    public RSASSAPSSparams(AlgorithmIdentifier algorithmidentifier, AlgorithmIdentifier algorithmidentifier1, ASN1Integer asn1integer, ASN1Integer asn1integer1)
    {
        adb = algorithmidentifier;
        adc = algorithmidentifier1;
        adr = asn1integer;
        ads = asn1integer1;
    }

    public static RSASSAPSSparams _mth1D57(Object obj)
    {
        if (obj instanceof RSASSAPSSparams)
        {
            return (RSASSAPSSparams)obj;
        }
        if (obj != null)
        {
            return new RSASSAPSSparams(ASN1Sequence._mth141F(obj));
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
        if (!adr.equals(adt))
        {
            DERTaggedObject dertaggedobject2 = new DERTaggedObject(true, 2, adr);
            asn1encodablevector.VS.addElement(dertaggedobject2);
        }
        if (!ads.equals(adu))
        {
            DERTaggedObject dertaggedobject3 = new DERTaggedObject(true, 3, ads);
            asn1encodablevector.VS.addElement(dertaggedobject3);
        }
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        ade = new AlgorithmIdentifier(OIWObjectIdentifiers.aav, DERNull.WL);
        adf = new AlgorithmIdentifier(PKCSObjectIdentifiers.abd, ade);
    }
}
