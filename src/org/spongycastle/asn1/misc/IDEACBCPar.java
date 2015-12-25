// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.misc;

import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class IDEACBCPar extends ASN1Object
{

    public ASN1OctetString Yk;

    public IDEACBCPar(ASN1Sequence asn1sequence)
    {
        if (asn1sequence.size() == 1)
        {
            Yk = (ASN1OctetString)asn1sequence._mth144B(0);
            return;
        } else
        {
            Yk = null;
            return;
        }
    }

    public IDEACBCPar(byte abyte0[])
    {
        Yk = new DEROctetString(abyte0);
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        if (Yk != null)
        {
            ASN1OctetString asn1octetstring = Yk;
            asn1encodablevector.VS.addElement(asn1octetstring);
        }
        return new DERSequence(asn1encodablevector);
    }
}
