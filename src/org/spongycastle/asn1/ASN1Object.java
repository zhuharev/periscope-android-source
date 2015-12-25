// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Encodable, ASN1Primitive, ASN1OutputStream, DEROutputStream, 
//            DLOutputStream

public abstract class ASN1Object
    implements ASN1Encodable
{

    public ASN1Object()
    {
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof ASN1Encodable))
        {
            return false;
        } else
        {
            obj = (ASN1Encodable)obj;
            return _mth0427().equals(((ASN1Encodable) (obj))._mth0427());
        }
    }

    public byte[] getEncoded()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        (new ASN1OutputStream(bytearrayoutputstream))._mth02CF(this);
        return bytearrayoutputstream.toByteArray();
    }

    public final byte[] getEncoded(String s)
    {
        if (s.equals("DER"))
        {
            s = new ByteArrayOutputStream();
            DEROutputStream deroutputstream = new DEROutputStream(s);
            if (this != null)
            {
                _mth0427()._mth0582()._mth02CA(deroutputstream);
            } else
            {
                throw new IOException("null object detected");
            }
            return s.toByteArray();
        }
        if (s.equals("DL"))
        {
            s = new ByteArrayOutputStream();
            DLOutputStream dloutputstream = new DLOutputStream(s);
            if (this != null)
            {
                _mth0427()._mth05D7()._mth02CA(dloutputstream);
            } else
            {
                throw new IOException("null object detected");
            }
            return s.toByteArray();
        } else
        {
            return getEncoded();
        }
    }

    public int hashCode()
    {
        return _mth0427().hashCode();
    }

    public abstract ASN1Primitive _mth0427();
}
