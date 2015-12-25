// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.asn1;

import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPrivateKey extends ASN1Object
{

    private ASN1ObjectIdentifier aFE;
    public byte aKf[][];
    public byte aKg[];
    public byte aKh[][];
    public byte aKi[];
    public byte aKj[];
    public Layer aKk[];
    private ASN1Integer ada;

    private RainbowPrivateKey(ASN1Sequence asn1sequence)
    {
        if (asn1sequence._mth144B(0) instanceof ASN1Integer)
        {
            ada = ASN1Integer.FB1D(asn1sequence._mth144B(0));
        } else
        {
            aFE = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
        }
        ASN1Sequence asn1sequence1 = (ASN1Sequence)asn1sequence._mth144B(1);
        aKf = new byte[asn1sequence1.size()][];
        for (int i = 0; i < asn1sequence1.size(); i++)
        {
            aKf[i] = ((ASN1OctetString)asn1sequence1._mth144B(i))._mth0501();
        }

        aKg = ((ASN1OctetString)((ASN1Sequence)asn1sequence._mth144B(2))._mth144B(0))._mth0501();
        asn1sequence1 = (ASN1Sequence)asn1sequence._mth144B(3);
        aKh = new byte[asn1sequence1.size()][];
        for (int j = 0; j < asn1sequence1.size(); j++)
        {
            aKh[j] = ((ASN1OctetString)asn1sequence1._mth144B(j))._mth0501();
        }

        aKi = ((ASN1OctetString)((ASN1Sequence)asn1sequence._mth144B(4))._mth144B(0))._mth0501();
        aKj = ((ASN1OctetString)((ASN1Sequence)asn1sequence._mth144B(5))._mth144B(0))._mth0501();
        ASN1Sequence asn1sequence2 = (ASN1Sequence)asn1sequence._mth144B(6);
        asn1sequence = new byte[asn1sequence2.size()][][][];
        byte abyte0[][][][] = new byte[asn1sequence2.size()][][][];
        byte abyte1[][][] = new byte[asn1sequence2.size()][][];
        byte abyte2[][] = new byte[asn1sequence2.size()][];
        for (int k = 0; k < asn1sequence2.size(); k++)
        {
            ASN1Sequence asn1sequence3 = (ASN1Sequence)asn1sequence2._mth144B(k);
            ASN1Sequence asn1sequence4 = (ASN1Sequence)asn1sequence3._mth144B(0);
            asn1sequence[k] = new byte[asn1sequence4.size()][][];
            for (int i1 = 0; i1 < asn1sequence4.size(); i1++)
            {
                ASN1Sequence asn1sequence5 = (ASN1Sequence)asn1sequence4._mth144B(i1);
                asn1sequence[k][i1] = new byte[asn1sequence5.size()][];
                for (int i2 = 0; i2 < asn1sequence5.size(); i2++)
                {
                    asn1sequence[k][i1][i2] = ((ASN1OctetString)asn1sequence5._mth144B(i2))._mth0501();
                }

            }

            asn1sequence4 = (ASN1Sequence)asn1sequence3._mth144B(1);
            abyte0[k] = new byte[asn1sequence4.size()][][];
            for (int j1 = 0; j1 < asn1sequence4.size(); j1++)
            {
                ASN1Sequence asn1sequence6 = (ASN1Sequence)asn1sequence4._mth144B(j1);
                abyte0[k][j1] = new byte[asn1sequence6.size()][];
                for (int j2 = 0; j2 < asn1sequence6.size(); j2++)
                {
                    abyte0[k][j1][j2] = ((ASN1OctetString)asn1sequence6._mth144B(j2))._mth0501();
                }

            }

            asn1sequence4 = (ASN1Sequence)asn1sequence3._mth144B(2);
            abyte1[k] = new byte[asn1sequence4.size()][];
            for (int k1 = 0; k1 < asn1sequence4.size(); k1++)
            {
                abyte1[k][k1] = ((ASN1OctetString)asn1sequence4._mth144B(k1))._mth0501();
            }

            abyte2[k] = ((ASN1OctetString)asn1sequence3._mth144B(3))._mth0501();
        }

        int l1 = aKj.length - 1;
        aKk = new Layer[l1];
        for (int l = 0; l < l1; l++)
        {
            Layer layer = new Layer(aKj[l], aKj[l + 1], RainbowUtil._mth02CA(asn1sequence[l]), RainbowUtil._mth02CA(abyte0[l]), RainbowUtil._mth02CE(abyte1[l]), RainbowUtil._mth14A2(abyte2[l]));
            aKk[l] = layer;
        }

    }

    public RainbowPrivateKey(short aword0[][], short aword1[], short aword2[][], short aword3[], int ai[], Layer alayer[])
    {
        ada = new ASN1Integer(1L);
        aKf = RainbowUtil._mth02CB(aword0);
        aKg = RainbowUtil._mth02CA(aword1);
        aKh = RainbowUtil._mth02CB(aword2);
        aKi = RainbowUtil._mth02CA(aword3);
        aKj = RainbowUtil._mth02CD(ai);
        aKk = alayer;
    }

    public static RainbowPrivateKey _mth1423(ASN1Encodable asn1encodable)
    {
        if (asn1encodable instanceof RainbowPrivateKey)
        {
            return (RainbowPrivateKey)asn1encodable;
        }
        if (asn1encodable != null)
        {
            return new RainbowPrivateKey(ASN1Sequence._mth141F(asn1encodable));
        } else
        {
            return null;
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (ada != null)
        {
            ASN1Integer asn1integer = ada;
            asn1encodablevector.VS.addElement(asn1integer);
        } else
        {
            ASN1ObjectIdentifier asn1objectidentifier = aFE;
            asn1encodablevector.VS.addElement(asn1objectidentifier);
        }
        Object obj = new ASN1EncodableVector();
        for (int i = 0; i < aKf.length; i++)
        {
            DEROctetString deroctetstring = new DEROctetString(aKf[i]);
            ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        DEROctetString deroctetstring1 = new DEROctetString(aKg);
        ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring1);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        for (int j = 0; j < aKh.length; j++)
        {
            deroctetstring1 = new DEROctetString(aKh[j]);
            ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring1);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        deroctetstring1 = new DEROctetString(aKi);
        ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring1);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        deroctetstring1 = new DEROctetString(aKj);
        ((ASN1EncodableVector) (obj)).VS.addElement(deroctetstring1);
        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        obj = new ASN1EncodableVector();
        for (int k = 0; k < aKk.length; k++)
        {
            Object obj1 = new ASN1EncodableVector();
            Object obj2 = RainbowUtil._mth02CB(aKk[k].aNw);
            ASN1EncodableVector asn1encodablevector1 = new ASN1EncodableVector();
            for (int l = 0; l < obj2.length; l++)
            {
                Object obj3 = new ASN1EncodableVector();
                for (int k1 = 0; k1 < obj2[l].length; k1++)
                {
                    DEROctetString deroctetstring3 = new DEROctetString(obj2[l][k1]);
                    ((ASN1EncodableVector) (obj3)).VS.addElement(deroctetstring3);
                }

                obj3 = new DERSequence(((ASN1EncodableVector) (obj3)));
                asn1encodablevector1.VS.addElement(obj3);
            }

            obj2 = new DERSequence(asn1encodablevector1);
            ((ASN1EncodableVector) (obj1)).VS.addElement(obj2);
            obj2 = RainbowUtil._mth02CB(aKk[k].aNx);
            asn1encodablevector1 = new ASN1EncodableVector();
            for (int i1 = 0; i1 < obj2.length; i1++)
            {
                Object obj4 = new ASN1EncodableVector();
                for (int l1 = 0; l1 < obj2[i1].length; l1++)
                {
                    DEROctetString deroctetstring4 = new DEROctetString(obj2[i1][l1]);
                    ((ASN1EncodableVector) (obj4)).VS.addElement(deroctetstring4);
                }

                obj4 = new DERSequence(((ASN1EncodableVector) (obj4)));
                asn1encodablevector1.VS.addElement(obj4);
            }

            obj2 = new DERSequence(asn1encodablevector1);
            ((ASN1EncodableVector) (obj1)).VS.addElement(obj2);
            obj2 = RainbowUtil._mth02CB(aKk[k].aNy);
            asn1encodablevector1 = new ASN1EncodableVector();
            for (int j1 = 0; j1 < obj2.length; j1++)
            {
                DEROctetString deroctetstring2 = new DEROctetString(obj2[j1]);
                asn1encodablevector1.VS.addElement(deroctetstring2);
            }

            obj2 = new DERSequence(asn1encodablevector1);
            ((ASN1EncodableVector) (obj1)).VS.addElement(obj2);
            obj2 = new DEROctetString(RainbowUtil._mth02CA(aKk[k].aNz));
            ((ASN1EncodableVector) (obj1)).VS.addElement(obj2);
            obj1 = new DERSequence(((ASN1EncodableVector) (obj1)));
            ((ASN1EncodableVector) (obj)).VS.addElement(obj1);
        }

        obj = new DERSequence(((ASN1EncodableVector) (obj)));
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }
}
