// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Object, ASN1InputStream, ASN1Encodable, ASN1OutputStream

public abstract class ASN1Primitive extends ASN1Object
{

    ASN1Primitive()
    {
    }

    public static ASN1Primitive _mth0640(byte abyte0[])
    {
        abyte0 = new ASN1InputStream(abyte0);
        try
        {
            abyte0 = abyte0._mth04B7();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IOException("cannot recognise object in stream");
        }
        return abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        return (obj instanceof ASN1Encodable) && _mth02CA(((ASN1Encodable)obj)._mth0427());
    }

    public abstract int hashCode();

    public abstract void _mth02CA(ASN1OutputStream asn1outputstream);

    abstract boolean _mth02CA(ASN1Primitive asn1primitive);

    abstract boolean _mth03BD();

    abstract int _mth03DA();

    public final ASN1Primitive _mth0427()
    {
        return this;
    }

    public ASN1Primitive _mth0582()
    {
        return this;
    }

    ASN1Primitive _mth05D7()
    {
        return this;
    }
}
