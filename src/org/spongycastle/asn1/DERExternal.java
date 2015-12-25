// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1EncodableVector, ASN1Encodable, ASN1ObjectIdentifier, 
//            ASN1Integer, DERTaggedObject, ASN1TaggedObject, ASN1OutputStream

public class DERExternal extends ASN1Primitive
{

    public ASN1ObjectIdentifier WF;
    public ASN1Integer WG;
    public ASN1Primitive WH;
    public ASN1Primitive WI;
    public int encoding;

    public DERExternal(ASN1EncodableVector asn1encodablevector)
    {
        int j = 0;
        if (asn1encodablevector.VS.size() <= 0)
        {
            throw new IllegalArgumentException("too few objects in input vector");
        }
        ASN1Primitive asn1primitive1 = ((ASN1Encodable)asn1encodablevector.VS.elementAt(0))._mth0427();
        ASN1Primitive asn1primitive = asn1primitive1;
        if (asn1primitive1 instanceof ASN1ObjectIdentifier)
        {
            WF = (ASN1ObjectIdentifier)asn1primitive1;
            j = 0 + 1;
            if (asn1encodablevector.VS.size() <= 1)
            {
                throw new IllegalArgumentException("too few objects in input vector");
            }
            asn1primitive = ((ASN1Encodable)asn1encodablevector.VS.elementAt(1))._mth0427();
        }
        int i = j;
        asn1primitive1 = asn1primitive;
        if (asn1primitive instanceof ASN1Integer)
        {
            WG = (ASN1Integer)asn1primitive;
            i = j + 1;
            if (asn1encodablevector.VS.size() <= i)
            {
                throw new IllegalArgumentException("too few objects in input vector");
            }
            asn1primitive1 = ((ASN1Encodable)asn1encodablevector.VS.elementAt(i))._mth0427();
        }
        j = i;
        asn1primitive = asn1primitive1;
        if (!(asn1primitive1 instanceof DERTaggedObject))
        {
            WH = asn1primitive1;
            j = i + 1;
            if (asn1encodablevector.VS.size() <= j)
            {
                throw new IllegalArgumentException("too few objects in input vector");
            }
            asn1primitive = ((ASN1Encodable)asn1encodablevector.VS.elementAt(j))._mth0427();
        }
        if (asn1encodablevector.VS.size() != j + 1)
        {
            throw new IllegalArgumentException("input vector too large");
        }
        if (!(asn1primitive instanceof DERTaggedObject))
        {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        asn1encodablevector = (DERTaggedObject)asn1primitive;
        i = ((ASN1TaggedObject) (asn1encodablevector)).Wk;
        if (i < 0 || i > 2)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid encoding value: ")).append(i).toString());
        }
        encoding = i;
        if (((ASN1TaggedObject) (asn1encodablevector)).Wn != null)
        {
            asn1encodablevector = ((ASN1TaggedObject) (asn1encodablevector)).Wn._mth0427();
        } else
        {
            asn1encodablevector = null;
        }
        WI = asn1encodablevector;
    }

    public int hashCode()
    {
        int j = 0;
        if (WF != null)
        {
            j = WF.hashCode();
        }
        int i = j;
        if (WG != null)
        {
            i = j ^ WG.hashCode();
        }
        j = i;
        if (WH != null)
        {
            j = i ^ WH.hashCode();
        }
        return WI.hashCode() ^ j;
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (WF != null)
        {
            bytearrayoutputstream.write(WF.getEncoded("DER"));
        }
        if (WG != null)
        {
            bytearrayoutputstream.write(WG.getEncoded("DER"));
        }
        if (WH != null)
        {
            bytearrayoutputstream.write(WH.getEncoded("DER"));
        }
        bytearrayoutputstream.write((new DERTaggedObject(true, encoding, WI)).getEncoded("DER"));
        asn1outputstream._mth02CA(32, 8, bytearrayoutputstream.toByteArray());
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERExternal))
        {
            return false;
        }
        if (this == asn1primitive)
        {
            return true;
        }
        asn1primitive = (DERExternal)asn1primitive;
        if (WF != null && (((DERExternal) (asn1primitive)).WF == null || !((DERExternal) (asn1primitive)).WF.equals(WF)))
        {
            return false;
        }
        if (WG != null && (((DERExternal) (asn1primitive)).WG == null || !((DERExternal) (asn1primitive)).WG.equals(WG)))
        {
            return false;
        }
        if (WH != null && (((DERExternal) (asn1primitive)).WH == null || !((DERExternal) (asn1primitive)).WH.equals(WH)))
        {
            return false;
        } else
        {
            return WI.equals(((DERExternal) (asn1primitive)).WI);
        }
    }

    final boolean _mth03BD()
    {
        return true;
    }

    final int _mth03DA()
    {
        return getEncoded().length;
    }
}
