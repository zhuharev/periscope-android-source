// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1EncodableVector, ASN1Encodable, ASN1Object, 
//            ASN1ParsingException, ASN1Set, ASN1Sequence, ASN1OutputStream, 
//            StreamUtil, ASN1InputStream

public class DERApplicationSpecific extends ASN1Primitive
{

    public final boolean WA;
    public final byte WB[];
    public final int tag;

    public DERApplicationSpecific(int i, ASN1EncodableVector asn1encodablevector)
    {
        tag = i;
        WA = true;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        for (i = 0; i != asn1encodablevector.VS.size(); i++)
        {
            try
            {
                bytearrayoutputstream.write(((ASN1Object)(ASN1Encodable)asn1encodablevector.VS.elementAt(i)).getEncoded("DER"));
            }
            // Misplaced declaration of an exception variable
            catch (ASN1EncodableVector asn1encodablevector)
            {
                throw new ASN1ParsingException((new StringBuilder("malformed object: ")).append(asn1encodablevector).toString(), asn1encodablevector);
            }
        }

        WB = bytearrayoutputstream.toByteArray();
    }

    public DERApplicationSpecific(boolean flag, int i, ASN1Object asn1object)
    {
        ASN1Primitive asn1primitive = asn1object._mth0427();
        asn1object = asn1primitive.getEncoded("DER");
        if ((asn1primitive instanceof ASN1Set) || (asn1primitive instanceof ASN1Sequence))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        WA = flag;
        tag = i;
        i = asn1object[1] & 0xff;
        if (i != 128 && i > 127)
        {
            i &= 0x7f;
            if (i > 4)
            {
                throw new IllegalStateException((new StringBuilder("DER length more than 4 bytes: ")).append(i).toString());
            }
            i += 2;
        } else
        {
            i = 2;
        }
        byte abyte0[] = new byte[asn1object.length - i];
        System.arraycopy(asn1object, i, abyte0, 0, abyte0.length);
        WB = abyte0;
    }

    DERApplicationSpecific(boolean flag, int i, byte abyte0[])
    {
        WA = flag;
        tag = i;
        WB = abyte0;
    }

    public int hashCode()
    {
        boolean flag;
        if (WA)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag ^ tag ^ Arrays.hashCode(WB);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte byte0 = 64;
        if (WA)
        {
            byte0 = 96;
        }
        int i = tag;
        byte abyte0[] = WB;
        asn1outputstream._mth144A(byte0, i);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERApplicationSpecific))
        {
            return false;
        }
        asn1primitive = (DERApplicationSpecific)asn1primitive;
        return WA == ((DERApplicationSpecific) (asn1primitive)).WA && tag == ((DERApplicationSpecific) (asn1primitive)).tag && Arrays._mth1427(WB, ((DERApplicationSpecific) (asn1primitive)).WB);
    }

    public final boolean _mth03BD()
    {
        return WA;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14EA(tag) + StreamUtil._mth14BE(WB.length) + WB.length;
    }

    public final ASN1Primitive _mth1466(int i)
    {
        byte abyte0[] = getEncoded();
        i = abyte0[0];
        int k = 1;
        if ((i & 0x1f) == 31)
        {
            i = 1 + 1;
            k = abyte0[1] & 0xff;
            int j = k;
            if ((k & 0x7f) == 0)
            {
                throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            }
            do
            {
                k = i;
                if (j < 0)
                {
                    break;
                }
                k = i;
                if ((j & 0x80) == 0)
                {
                    break;
                }
                k = i + 1;
                j = abyte0[i] & 0xff;
                i = k;
            } while (true);
        }
        byte abyte1[] = new byte[(abyte0.length - k) + 1];
        System.arraycopy(abyte0, k, abyte1, 1, abyte1.length - 1);
        abyte1[0] = 16;
        if ((abyte0[0] & 0x20) != 0)
        {
            abyte1[0] = (byte)(abyte1[0] | 0x20);
        }
        return (new ASN1InputStream(abyte1))._mth04B7();
    }
}
