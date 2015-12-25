// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

// Referenced classes of package org.spongycastle.asn1.x509:
//            CRLReason, Extension, Extensions, Time

public class V2TBSCertListGenerator
{

    private static final ASN1Sequence akb[];
    private ASN1Integer ada;
    private Extensions aii;
    private Time ajG;
    private ASN1EncodableVector aka;

    public V2TBSCertListGenerator()
    {
        ada = new ASN1Integer(1L);
        ajG = null;
        aii = null;
        aka = new ASN1EncodableVector();
    }

    private static DERSequence _mth153E(int i)
    {
        Object obj = new ASN1EncodableVector();
        Object obj1 = CRLReason._mth14EB(i);
        try
        {
            org.spongycastle.asn1.ASN1ObjectIdentifier asn1objectidentifier = Extension.aiI;
            ((ASN1EncodableVector) (obj)).VS.addElement(asn1objectidentifier);
            obj1 = new DEROctetString(((CRLReason) (obj1)).getEncoded());
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException((new StringBuilder("error encoding reason: ")).append(obj).toString());
        }
        return new DERSequence(((ASN1EncodableVector) (obj)));
    }

    static 
    {
        ASN1Sequence aasn1sequence[] = new ASN1Sequence[11];
        akb = aasn1sequence;
        aasn1sequence[0] = _mth153E(0);
        akb[1] = _mth153E(1);
        akb[2] = _mth153E(2);
        akb[3] = _mth153E(3);
        akb[4] = _mth153E(4);
        akb[5] = _mth153E(5);
        akb[6] = _mth153E(6);
        akb[7] = _mth153E(7);
        akb[8] = _mth153E(8);
        akb[9] = _mth153E(9);
        akb[10] = _mth153E(10);
    }
}
