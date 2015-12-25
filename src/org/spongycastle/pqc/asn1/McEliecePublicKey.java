// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.asn1;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object
{

    private ASN1ObjectIdentifier aFE;
    private int aJP;
    private byte aJQ[];
    private int axg;

    public McEliecePublicKey(ASN1ObjectIdentifier asn1objectidentifier, int i, int j, GF2Matrix gf2matrix)
    {
        aFE = asn1objectidentifier;
        axg = i;
        aJP = j;
        aJQ = gf2matrix.getEncoded();
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aFE;
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1Integer(axg);
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1Integer(aJP);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJQ);
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
