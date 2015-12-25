// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1OutputStream, StreamUtil

public class ASN1Enumerated extends ASN1Primitive
{

    private static ASN1Enumerated VT[] = new ASN1Enumerated[12];
    public byte bytes[];

    public ASN1Enumerated(int i)
    {
        bytes = BigInteger.valueOf(i).toByteArray();
    }

    private ASN1Enumerated(byte abyte0[])
    {
        bytes = abyte0;
    }

    static ASN1Enumerated _mth02CD(byte abyte0[])
    {
        if (abyte0.length > 1)
        {
            return new ASN1Enumerated(Arrays._mth1D4C(abyte0));
        }
        if (abyte0.length == 0)
        {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = abyte0[0] & 0xff;
        if (i >= VT.length)
        {
            return new ASN1Enumerated(Arrays._mth1D4C(abyte0));
        }
        ASN1Enumerated asn1enumerated1 = VT[i];
        ASN1Enumerated asn1enumerated = asn1enumerated1;
        if (asn1enumerated1 == null)
        {
            ASN1Enumerated aasn1enumerated[] = VT;
            asn1enumerated = new ASN1Enumerated(Arrays._mth1D4C(abyte0));
            aasn1enumerated[i] = asn1enumerated;
        }
        return asn1enumerated;
    }

    public static ASN1Enumerated _mth1D63(Object obj)
    {
        if (obj == null || (obj instanceof ASN1Enumerated))
        {
            return (ASN1Enumerated)obj;
        }
        if (obj instanceof byte[])
        {
            try
            {
                obj = (ASN1Enumerated)_mth0640((byte[])obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalArgumentException((new StringBuilder("encoding error in getInstance: ")).append(((Exception) (obj)).toString()).toString());
            }
            return ((ASN1Enumerated) (obj));
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(obj.getClass().getName()).toString());
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = bytes;
        asn1outputstream.write(10);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1Enumerated))
        {
            return false;
        } else
        {
            asn1primitive = (ASN1Enumerated)asn1primitive;
            return Arrays._mth1427(bytes, ((ASN1Enumerated) (asn1primitive)).bytes);
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
