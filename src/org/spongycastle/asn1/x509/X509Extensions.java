// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            X509Extension

public class X509Extensions extends ASN1Object
{

    public static final ASN1ObjectIdentifier akd = new ASN1ObjectIdentifier("2.5.29.15");
    public static final ASN1ObjectIdentifier ake = new ASN1ObjectIdentifier("2.5.29.17");
    public static final ASN1ObjectIdentifier akf = new ASN1ObjectIdentifier("2.5.29.19");
    public static final ASN1ObjectIdentifier akg = new ASN1ObjectIdentifier("2.5.29.20");
    public static final ASN1ObjectIdentifier akh = new ASN1ObjectIdentifier("2.5.29.27");
    public static final ASN1ObjectIdentifier aki = new ASN1ObjectIdentifier("2.5.29.28");
    public static final ASN1ObjectIdentifier akj = new ASN1ObjectIdentifier("2.5.29.30");
    public static final ASN1ObjectIdentifier akk = new ASN1ObjectIdentifier("2.5.29.31");
    public static final ASN1ObjectIdentifier akl = new ASN1ObjectIdentifier("2.5.29.32");
    public static final ASN1ObjectIdentifier akm = new ASN1ObjectIdentifier("2.5.29.33");
    public static final ASN1ObjectIdentifier akn = new ASN1ObjectIdentifier("2.5.29.35");
    public static final ASN1ObjectIdentifier ako = new ASN1ObjectIdentifier("2.5.29.36");
    public static final ASN1ObjectIdentifier akp = new ASN1ObjectIdentifier("2.5.29.46");
    public static final ASN1ObjectIdentifier akq = new ASN1ObjectIdentifier("2.5.29.54");
    public static final ASN1ObjectIdentifier akr = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    public static final ASN1ObjectIdentifier aks = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    public static final ASN1ObjectIdentifier akt = new ASN1ObjectIdentifier("2.5.29.56");
    public static final ASN1ObjectIdentifier aku = new ASN1ObjectIdentifier("2.5.29.55");
    private Hashtable aiY;
    private Vector aiZ;

    private X509Extensions(ASN1Sequence asn1sequence)
    {
        aiY = new Hashtable();
        aiZ = new Vector();
        ASN1Sequence asn1sequence1;
        for (asn1sequence = asn1sequence._mth0675(); asn1sequence.hasMoreElements(); aiZ.addElement(asn1sequence1._mth144B(0)))
        {
            asn1sequence1 = ASN1Sequence._mth141F(asn1sequence.nextElement());
            if (asn1sequence1.size() == 3)
            {
                aiY.put(asn1sequence1._mth144B(0), new X509Extension(ASN1Boolean._mth02CA(asn1sequence1._mth144B(1)), ASN1OctetString.FB39(asn1sequence1._mth144B(2))));
                continue;
            }
            if (asn1sequence1.size() == 2)
            {
                aiY.put(asn1sequence1._mth144B(0), new X509Extension(false, ASN1OctetString.FB39(asn1sequence1._mth144B(1))));
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence1.size()).toString());
            }
        }

    }

    public static X509Extensions _mth02CC(ASN1Primitive asn1primitive)
    {
        do
        {
            if (asn1primitive == null)
            {
                return (X509Extensions)asn1primitive;
            }
            if (asn1primitive instanceof ASN1Sequence)
            {
                return new X509Extensions((ASN1Sequence)asn1primitive);
            }
            if (asn1primitive instanceof ASN1TaggedObject)
            {
                asn1primitive = (ASN1TaggedObject)asn1primitive;
                if (((ASN1TaggedObject) (asn1primitive)).Wn != null)
                {
                    asn1primitive = ((ASN1TaggedObject) (asn1primitive)).Wn._mth0427();
                } else
                {
                    asn1primitive = null;
                }
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1primitive.getClass().getName()).toString());
            }
        } while (true);
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj;
        for (Enumeration enumeration = aiZ.elements(); enumeration.hasMoreElements(); asn1encodablevector.VS.addElement(obj))
        {
            ASN1ObjectIdentifier asn1objectidentifier = (ASN1ObjectIdentifier)enumeration.nextElement();
            Object obj1 = (X509Extension)aiY.get(asn1objectidentifier);
            obj = new ASN1EncodableVector();
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1objectidentifier);
            if (((X509Extension) (obj1)).aiW)
            {
                ASN1Boolean asn1boolean = ASN1Boolean.VR;
                ((ASN1EncodableVector) (obj)).VS.addElement(asn1boolean);
            }
            obj1 = ((X509Extension) (obj1)).aiX;
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
            obj = new DERSequence(((ASN1EncodableVector) (obj)));
        }

        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        new ASN1ObjectIdentifier("2.5.29.9");
        new ASN1ObjectIdentifier("2.5.29.14");
        new ASN1ObjectIdentifier("2.5.29.16");
        new ASN1ObjectIdentifier("2.5.29.18");
        new ASN1ObjectIdentifier("2.5.29.21");
        new ASN1ObjectIdentifier("2.5.29.23");
        new ASN1ObjectIdentifier("2.5.29.24");
        new ASN1ObjectIdentifier("2.5.29.29");
        new ASN1ObjectIdentifier("2.5.29.37");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    }
}
