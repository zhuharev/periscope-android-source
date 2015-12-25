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
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.LittleEndianConversions;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McEliecePrivateKey extends ASN1Object
{

    private ASN1ObjectIdentifier aFE;
    private byte aJK[];
    private byte aJL[];
    private byte aJN[];
    private byte aJO[][];
    private byte aJR[];
    private byte aJS[];
    private byte aJT[];
    private int afK;
    private int axg;

    public McEliecePrivateKey(ASN1ObjectIdentifier asn1objectidentifier, int i, int j, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, GF2Matrix gf2matrix, Permutation permutation, 
            Permutation permutation1, GF2Matrix gf2matrix1, PolynomialGF2mSmallM apolynomialgf2msmallm[])
    {
        aFE = asn1objectidentifier;
        axg = i;
        afK = j;
        aJK = LittleEndianConversions._mth027E(gf2mfield.aOA);
        aJL = polynomialgf2msmallm.getEncoded();
        aJR = gf2matrix.getEncoded();
        aJS = permutation.getEncoded();
        aJT = permutation1.getEncoded();
        aJN = gf2matrix1.getEncoded();
        aJO = new byte[apolynomialgf2msmallm.length][];
        for (i = 0; i != apolynomialgf2msmallm.length; i++)
        {
            aJO[i] = apolynomialgf2msmallm[i].getEncoded();
        }

    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aFE;
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1Integer(axg);
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1Integer(afK);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJK);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJL);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJR);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJS);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJT);
        asn1encodablevector.VS.addElement(obj);
        obj = new DEROctetString(aJN);
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        for (int i = 0; i < aJO.length; i++)
        {
            DEROctetString deroctetstring = new DEROctetString(aJO[i]);
            ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
