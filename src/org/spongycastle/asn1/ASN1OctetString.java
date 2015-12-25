// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1OctetStringParser, ASN1TaggedObject, ASN1Encodable, 
//            ASN1Sequence, BEROctetString, DEROctetString, ASN1OutputStream

public abstract class ASN1OctetString extends ASN1Primitive
    implements ASN1OctetStringParser
{

    byte Wa[];

    public ASN1OctetString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("string cannot be null");
        } else
        {
            Wa = abyte0;
            return;
        }
    }

    public static ASN1OctetString _mth02CF(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        if (asn1taggedobject instanceof ASN1OctetString)
        {
            return FB39(asn1taggedobject);
        } else
        {
            return BEROctetString._mth02CA(ASN1Sequence._mth141F(asn1taggedobject));
        }
    }

    public static ASN1OctetString FB39(Object obj)
    {
        if (obj == null || (obj instanceof ASN1OctetString))
        {
            return (ASN1OctetString)obj;
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = FB39(ASN1Primitive._mth0640((byte[])obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("failed to construct OCTET STRING from byte[]: ")).append(((IOException) (obj)).getMessage()).toString());
            }
            return ((ASN1OctetString) (obj));
        }
        if (obj instanceof ASN1Encodable)
        {
            ASN1Primitive asn1primitive = ((ASN1Encodable)obj)._mth0427();
            if (asn1primitive instanceof ASN1OctetString)
            {
                return (ASN1OctetString)asn1primitive;
            }
        }
        throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(obj.getClass().getName()).toString());
    }

    public int hashCode()
    {
        return Arrays.hashCode(_mth0501());
    }

    public String toString()
    {
        return (new StringBuilder("#")).append(new String(Hex._mth1D65(Wa))).toString();
    }

    abstract void _mth02CA(ASN1OutputStream asn1outputstream);

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1OctetString))
        {
            return false;
        } else
        {
            asn1primitive = (ASN1OctetString)asn1primitive;
            return Arrays._mth1427(Wa, ((ASN1OctetString) (asn1primitive)).Wa);
        }
    }

    public final InputStream _mth04CC()
    {
        return new ByteArrayInputStream(Wa);
    }

    public byte[] _mth0501()
    {
        return Wa;
    }

    public final ASN1Primitive _mth0505()
    {
        return _mth0427();
    }

    final ASN1Primitive _mth0582()
    {
        return new DEROctetString(Wa);
    }

    final ASN1Primitive _mth05D7()
    {
        return new DEROctetString(Wa);
    }
}
