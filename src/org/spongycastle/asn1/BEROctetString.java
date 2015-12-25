// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1OctetString, ASN1Sequence, DEROctetString, ASN1OutputStream, 
//            ASN1Encodable, ASN1Primitive

public class BEROctetString extends ASN1OctetString
{

    private ASN1OctetString Wq[];

    public BEROctetString(byte abyte0[])
    {
        super(abyte0);
    }

    public BEROctetString(ASN1OctetString aasn1octetstring[])
    {
        super(_mth02CA(aasn1octetstring));
        Wq = aasn1octetstring;
    }

    static BEROctetString _mth02CA(ASN1Sequence asn1sequence)
    {
        ASN1OctetString aasn1octetstring[] = new ASN1OctetString[asn1sequence.size()];
        asn1sequence = asn1sequence._mth0675();
        int j;
        for (int i = 0; asn1sequence.hasMoreElements(); i = j)
        {
            j = i + 1;
            aasn1octetstring[i] = (ASN1OctetString)asn1sequence.nextElement();
        }

        return new BEROctetString(aasn1octetstring);
    }

    private static byte[] _mth02CA(ASN1OctetString aasn1octetstring[])
    {
        ClassCastException classcastexception;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        for (int i = 0; i != aasn1octetstring.length; i++)
        {
            try
            {
                bytearrayoutputstream.write(((DEROctetString)aasn1octetstring[i])._mth0501());
            }
            // Misplaced declaration of an exception variable
            catch (ClassCastException classcastexception)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(aasn1octetstring[i].getClass().getName()).append(" found in input should only contain DEROctetString").toString());
            }
            // Misplaced declaration of an exception variable
            catch (ASN1OctetString aasn1octetstring[])
            {
                throw new IllegalArgumentException((new StringBuilder("exception converting octets ")).append(aasn1octetstring.toString()).toString());
            }
        }

        return bytearrayoutputstream.toByteArray();
    }

    static ASN1OctetString[] _mth02CA(BEROctetString beroctetstring)
    {
        return beroctetstring.Wq;
    }

    public final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(36);
        asn1outputstream.write(128);
        for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements(); asn1outputstream._mth02CF((ASN1Encodable)enumeration.nextElement())) { }
        asn1outputstream.write(0);
        asn1outputstream.write(0);
    }

    final boolean _mth03BD()
    {
        return true;
    }

    final int _mth03DA()
    {
        int i = 0;
        for (Enumeration enumeration = _mth0675(); enumeration.hasMoreElements();)
        {
            i += ((ASN1Encodable)enumeration.nextElement())._mth0427()._mth03DA();
        }

        return i + 2 + 2;
    }

    public byte[] _mth0501()
    {
        return Wa;
    }

    public Enumeration _mth0675()
    {
        if (Wq == null)
        {
            Vector vector = new Vector();
            for (int i = 0; i < Wa.length; i += 1000)
            {
                int j;
                if (i + 1000 > Wa.length)
                {
                    j = Wa.length;
                } else
                {
                    j = i + 1000;
                }
                byte abyte0[] = new byte[j - i];
                System.arraycopy(Wa, i, abyte0, 0, abyte0.length);
                vector.addElement(new DEROctetString(abyte0));
            }

            return vector.elements();
        } else
        {
            return new _cls1();
        }
    }

    private class _cls1
        implements Enumeration
    {

        private int Wr;
        private BEROctetString Ws;

        public boolean hasMoreElements()
        {
            return Wr < BEROctetString._mth02CA(Ws).length;
        }

        public Object nextElement()
        {
            ASN1OctetString aasn1octetstring[] = BEROctetString._mth02CA(Ws);
            int i = Wr;
            Wr = i + 1;
            return aasn1octetstring[i];
        }

        _cls1()
        {
            Ws = BEROctetString.this;
            super();
            Wr = 0;
        }
    }

}
