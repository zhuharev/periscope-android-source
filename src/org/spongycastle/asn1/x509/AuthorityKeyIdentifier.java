// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

// Referenced classes of package org.spongycastle.asn1.x509:
//            GeneralNames

public class AuthorityKeyIdentifier extends ASN1Object
{

    public ASN1OctetString aij;
    private GeneralNames aik;
    private ASN1Integer ail;

    private AuthorityKeyIdentifier(ASN1Sequence asn1sequence)
    {
        aij = null;
        aik = null;
        ail = null;
        asn1sequence = asn1sequence._mth0675();
        do
        {
            if (!asn1sequence.hasMoreElements())
            {
                break;
            }
            ASN1TaggedObject asn1taggedobject = DERTaggedObject._mth142A(asn1sequence.nextElement());
            switch (asn1taggedobject.Wk)
            {
            case 0: // '\0'
                aij = ASN1OctetString._mth02CF(asn1taggedobject, false);
                break;

            case 1: // '\001'
                aik = GeneralNames._mth02C8(asn1taggedobject, false);
                break;

            case 2: // '\002'
                ail = ASN1Integer._mth02CB(asn1taggedobject, false);
                break;

            default:
                throw new IllegalArgumentException("illegal tag");
            }
        } while (true);
    }

    public static AuthorityKeyIdentifier _mth037A(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            return new AuthorityKeyIdentifier(ASN1Sequence._mth141F(asn1primitive));
        } else
        {
            return null;
        }
    }

    public String toString()
    {
        return (new StringBuilder("AuthorityKeyIdentifier: KeyID(")).append(aij._mth0501()).append(")").toString();
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (aij != null)
        {
            DERTaggedObject dertaggedobject = new DERTaggedObject(false, 0, aij);
            asn1encodablevector.VS.addElement(dertaggedobject);
        }
        if (aik != null)
        {
            DERTaggedObject dertaggedobject1 = new DERTaggedObject(false, 1, aik);
            asn1encodablevector.VS.addElement(dertaggedobject1);
        }
        if (ail != null)
        {
            DERTaggedObject dertaggedobject2 = new DERTaggedObject(false, 2, ail);
            asn1encodablevector.VS.addElement(dertaggedobject2);
        }
        return new DERSequence(asn1encodablevector);
    }
}
