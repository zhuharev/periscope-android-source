// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1Encodable, ASN1TaggedObject, 
//            ASN1OctetString, ASN1OutputStream, StreamUtil, DefiniteLengthInputStream

public class DERBitString extends ASN1Primitive
    implements ASN1String
{

    private static final char WD[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    private int WE;
    public byte data[];

    public DERBitString(int i)
    {
        int j = 4;
        for (int k = 3; k > 0 && (255 << (k << 3) & i) == 0; k--)
        {
            j--;
        }

        byte abyte0[] = new byte[j];
        for (int l = 0; l < j; l++)
        {
            abyte0[l] = (byte)(i >> (l << 3));
        }

        data = abyte0;
        boolean flag = false;
        int i1 = 3;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i1 < 0)
            {
                break;
            }
            if (i1 != 0)
            {
                if (i >> (i1 << 3) != 0)
                {
                    j = i >> (i1 << 3) & 0xff;
                    break;
                }
            } else
            if (i != 0)
            {
                j = i & 0xff;
                break;
            }
            i1--;
        } while (true);
        if (j == 0)
        {
            i = 7;
        } else
        {
            i = 1;
            do
            {
                int j1 = j << 1;
                j = j1;
                if ((j1 & 0xff) == 0)
                {
                    break;
                }
                i++;
            } while (true);
            i = 8 - i;
        }
        WE = i;
    }

    public DERBitString(ASN1Encodable asn1encodable)
    {
        data = asn1encodable._mth0427().getEncoded("DER");
        WE = 0;
    }

    public DERBitString(byte abyte0[])
    {
        this(abyte0, 0);
    }

    public DERBitString(byte abyte0[], int i)
    {
        data = abyte0;
        WE = i;
    }

    public static DERBitString _mth02BD(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        if (asn1taggedobject instanceof DERBitString)
        {
            return _mth14BD(asn1taggedobject);
        }
        asn1taggedobject = ((ASN1OctetString)asn1taggedobject)._mth0501();
        if (asn1taggedobject.length <= 0)
        {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        byte byte0 = asn1taggedobject[0];
        byte abyte0[] = new byte[asn1taggedobject.length - 1];
        if (abyte0.length != 0)
        {
            System.arraycopy(asn1taggedobject, 1, abyte0, 0, asn1taggedobject.length - 1);
        }
        return new DERBitString(abyte0, byte0);
    }

    static DERBitString _mth02CA(int i, DefiniteLengthInputStream definitelengthinputstream)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int j = definitelengthinputstream.read();
        byte abyte0[] = new byte[i - 1];
        if (abyte0.length != 0 && Streams._mth02CB(definitelengthinputstream, abyte0) != abyte0.length)
        {
            throw new EOFException("EOF encountered in middle of BIT STRING");
        } else
        {
            return new DERBitString(abyte0, j);
        }
    }

    public static DERBitString _mth14BD(Object obj)
    {
        if (obj == null || (obj instanceof DERBitString))
        {
            return (DERBitString)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(obj.getClass().getName()).toString());
        }
    }

    public final byte[] getBytes()
    {
        return data;
    }

    public final String getString()
    {
        IOException ioexception;
        StringBuffer stringbuffer = new StringBuffer("#");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ASN1OutputStream asn1outputstream = new ASN1OutputStream(bytearrayoutputstream);
        try
        {
            asn1outputstream._mth02CF(this);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            throw new RuntimeException("internal error encoding BitString");
        }
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        for (int i = 0; i != abyte0.length; i++)
        {
            stringbuffer.append(WD[abyte0[i] >>> 4 & 0xf]);
            stringbuffer.append(WD[abyte0[i] & 0xf]);
        }

        return stringbuffer.toString();
    }

    public int hashCode()
    {
        return WE ^ Arrays.hashCode(data);
    }

    public final int intValue()
    {
        int j = 0;
        for (int i = 0; i != data.length && i != 4; i++)
        {
            j |= (data[i] & 0xff) << i * 8;
        }

        return j;
    }

    public String toString()
    {
        return getString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = new byte[data.length + 1];
        abyte0[0] = (byte)WE;
        System.arraycopy(data, 0, abyte0, 1, abyte0.length - 1);
        asn1outputstream.write(3);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    protected final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERBitString))
        {
            return false;
        }
        asn1primitive = (DERBitString)asn1primitive;
        return WE == ((DERBitString) (asn1primitive)).WE && Arrays._mth1427(data, ((DERBitString) (asn1primitive)).data);
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(data.length + 1) + 1 + data.length + 1;
    }

    public final int _mth06B9()
    {
        return WE;
    }

}
