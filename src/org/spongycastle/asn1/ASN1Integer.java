// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1TaggedObject, ASN1Encodable, ASN1OctetString, 
//            ASN1OutputStream, StreamUtil

public class ASN1Integer extends ASN1Primitive
{

    public byte bytes[];

    public ASN1Integer(long l)
    {
        bytes = BigInteger.valueOf(l).toByteArray();
    }

    public ASN1Integer(BigInteger biginteger)
    {
        bytes = biginteger.toByteArray();
    }

    private ASN1Integer(byte abyte0[])
    {
        this(abyte0, true);
    }

    ASN1Integer(byte abyte0[], boolean flag)
    {
        if (flag)
        {
            abyte0 = Arrays._mth1D4C(abyte0);
        }
        bytes = abyte0;
    }

    public static ASN1Integer _mth02CB(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        ASN1Primitive asn1primitive;
        if (asn1taggedobject.Wn != null)
        {
            asn1primitive = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1primitive = null;
        }
        if (flag || (asn1primitive instanceof ASN1Integer))
        {
            return FB1D(asn1primitive);
        }
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        return new ASN1Integer(ASN1OctetString.FB39(asn1taggedobject)._mth0501());
    }

    public static ASN1Integer FB1D(Object obj)
    {
        if (obj == null || (obj instanceof ASN1Integer))
        {
            return (ASN1Integer)obj;
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = (ASN1Integer)_mth0640((byte[])obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("encoding error in getInstance: ")).append(((Exception) (obj)).toString()).toString());
            }
            return ((ASN1Integer) (obj));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(obj.getClass().getName()).toString());
        }
    }

    public int hashCode()
    {
        int j = 0;
        for (int i = 0; i != bytes.length; i++)
        {
            j ^= (bytes[i] & 0xff) << i % 4;
        }

        return j;
    }

    public String toString()
    {
        return (new BigInteger(bytes)).toString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = bytes;
        asn1outputstream.write(2);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1Integer))
        {
            return false;
        } else
        {
            asn1primitive = (ASN1Integer)asn1primitive;
            return Arrays._mth1427(bytes, ((ASN1Integer) (asn1primitive)).bytes);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(bytes.length) + 1 + bytes.length;
    }
}
