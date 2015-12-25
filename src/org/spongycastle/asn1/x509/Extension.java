// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extension extends ASN1Object
{

    public static final ASN1ObjectIdentifier aiD = new ASN1ObjectIdentifier("2.5.29.15");
    public static final ASN1ObjectIdentifier aiE = new ASN1ObjectIdentifier("2.5.29.17");
    public static final ASN1ObjectIdentifier aiF = new ASN1ObjectIdentifier("2.5.29.18");
    public static final ASN1ObjectIdentifier aiG = new ASN1ObjectIdentifier("2.5.29.19");
    public static final ASN1ObjectIdentifier aiH = new ASN1ObjectIdentifier("2.5.29.20");
    public static final ASN1ObjectIdentifier aiI = new ASN1ObjectIdentifier("2.5.29.21");
    public static final ASN1ObjectIdentifier aiJ = new ASN1ObjectIdentifier("2.5.29.27");
    public static final ASN1ObjectIdentifier aiK = new ASN1ObjectIdentifier("2.5.29.28");
    public static final ASN1ObjectIdentifier aiL = new ASN1ObjectIdentifier("2.5.29.29");
    public static final ASN1ObjectIdentifier aiM = new ASN1ObjectIdentifier("2.5.29.30");
    public static final ASN1ObjectIdentifier aiN = new ASN1ObjectIdentifier("2.5.29.31");
    public static final ASN1ObjectIdentifier aiO = new ASN1ObjectIdentifier("2.5.29.32");
    public static final ASN1ObjectIdentifier aiP = new ASN1ObjectIdentifier("2.5.29.33");
    public static final ASN1ObjectIdentifier aiQ = new ASN1ObjectIdentifier("2.5.29.35");
    public static final ASN1ObjectIdentifier aiR = new ASN1ObjectIdentifier("2.5.29.36");
    public static final ASN1ObjectIdentifier aiS = new ASN1ObjectIdentifier("2.5.29.37");
    public static final ASN1ObjectIdentifier aiT = new ASN1ObjectIdentifier("2.5.29.46");
    public static final ASN1ObjectIdentifier aiU = new ASN1ObjectIdentifier("2.5.29.54");
    ASN1ObjectIdentifier aiV;
    public boolean aiW;
    public ASN1OctetString aiX;

    private Extension(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() == 2)
        {
            aiV = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
            aiW = false;
            aiX = ASN1OctetString.FB39(asn1sequence._mth144B(1));
            return;
        }
        if (asn1sequence.size() == 3)
        {
            aiV = ASN1ObjectIdentifier._mth02CE(asn1sequence._mth144B(0));
            boolean flag;
            if (ASN1Boolean._mth02CA(asn1sequence._mth144B(1)).VP[0] != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aiW = flag;
            aiX = ASN1OctetString.FB39(asn1sequence._mth144B(2));
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Bad sequence size: ")).append(asn1sequence.size()).toString());
        }
    }

    public static ASN1Primitive _mth02CA(Extension extension)
    {
        try
        {
            extension = ASN1Primitive._mth0640(extension.aiX._mth0501());
        }
        // Misplaced declaration of an exception variable
        catch (Extension extension)
        {
            throw new IllegalArgumentException((new StringBuilder("can't convert extension: ")).append(extension).toString());
        }
        return extension;
    }

    public static Extension _mth02D0(Object obj)
    {
        if (obj instanceof Extension)
        {
            return (Extension)obj;
        }
        if (obj != null)
        {
            return new Extension(ASN1Sequence._mth141F(obj));
        } else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Extension))
        {
            return false;
        }
        obj = (Extension)obj;
        return ((Extension) (obj)).aiV.equals(aiV) && ((Extension) (obj)).aiX.equals(aiX) && ((Extension) (obj)).aiW == aiW;
    }

    public int hashCode()
    {
        if (aiW)
        {
            return aiX.hashCode() ^ aiV.hashCode();
        } else
        {
            return ~(aiX.hashCode() ^ aiV.hashCode());
        }
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        Object obj = aiV;
        asn1encodablevector.VS.addElement(obj);
        if (aiW)
        {
            obj = ASN1Boolean._mth02E3(true);
            asn1encodablevector.VS.addElement(obj);
        }
        obj = aiX;
        asn1encodablevector.VS.addElement(obj);
        return new DERSequence(asn1encodablevector);
    }

    static 
    {
        new ASN1ObjectIdentifier("2.5.29.9");
        new ASN1ObjectIdentifier("2.5.29.14");
        new ASN1ObjectIdentifier("2.5.29.16");
        new ASN1ObjectIdentifier("2.5.29.23");
        new ASN1ObjectIdentifier("2.5.29.24");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        new ASN1ObjectIdentifier("2.5.29.56");
        new ASN1ObjectIdentifier("2.5.29.55");
    }
}
