// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1Encodable, DEROutputStream, DLOutputStream

public class ASN1OutputStream
{
    class ImplicitOutputStream extends ASN1OutputStream
    {

        private boolean St;
        private ASN1OutputStream Wc;

        public final void write(int i)
        {
            if (St)
            {
                St = false;
                return;
            } else
            {
                write(i);
                return;
            }
        }

        public ImplicitOutputStream(OutputStream outputstream)
        {
            Wc = ASN1OutputStream.this;
            super(outputstream);
            St = true;
        }
    }


    OutputStream Wb;

    public ASN1OutputStream(OutputStream outputstream)
    {
        Wb = outputstream;
    }

    void write(int i)
    {
        Wb.write(i);
    }

    final void _mth02CA(int i, int j, byte abyte0[])
    {
        _mth144A(i, j);
        _mth1449(abyte0.length);
        Wb.write(abyte0);
    }

    final void _mth02CB(ASN1Primitive asn1primitive)
    {
        if (asn1primitive != null)
        {
            asn1primitive._mth02CA(new ImplicitOutputStream(Wb));
            return;
        } else
        {
            throw new IOException("null object detected");
        }
    }

    public void _mth02CF(ASN1Encodable asn1encodable)
    {
        if (asn1encodable != null)
        {
            asn1encodable._mth0427()._mth02CA(this);
            return;
        } else
        {
            throw new IOException("null object detected");
        }
    }

    DEROutputStream _mth05E6()
    {
        return new DEROutputStream(Wb);
    }

    ASN1OutputStream _mth0628()
    {
        return new DLOutputStream(Wb);
    }

    final void _mth1449(int i)
    {
        if (i > 127)
        {
            int j = 1;
            int k = i;
            do
            {
                int l = k >>> 8;
                k = l;
                if (l == 0)
                {
                    break;
                }
                j++;
            } while (true);
            write((byte)(j | 0x80));
            for (j = j - 1 << 3; j >= 0; j -= 8)
            {
                write((byte)(i >> j));
            }

            return;
        } else
        {
            write((byte)i);
            return;
        }
    }

    final void _mth144A(int i, int j)
    {
        if (j < 31)
        {
            write(i | j);
            return;
        }
        write(i | 0x1f);
        if (j < 128)
        {
            write(j);
            return;
        }
        byte abyte0[] = new byte[5];
        i = 5 - 1;
        abyte0[4] = (byte)(j & 0x7f);
        int k;
        int l;
        do
        {
            k = j >> 7;
            l = i - 1;
            abyte0[l] = (byte)(k & 0x7f | 0x80);
            i = l;
            j = k;
        } while (k > 127);
        Wb.write(abyte0, l, 5 - l);
    }
}
