// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1OctetString, ASN1OutputStream, StreamUtil, DEROutputStream

public class DEROctetString extends ASN1OctetString
{

    public DEROctetString(byte abyte0[])
    {
        super(abyte0);
    }

    static void _mth02CA(DEROutputStream deroutputstream, byte abyte0[])
    {
        deroutputstream.write(4);
        deroutputstream._mth1449(abyte0.length);
        ((ASN1OutputStream) (deroutputstream)).Wb.write(abyte0);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = Wa;
        asn1outputstream.write(4);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(Wa.length) + 1 + Wa.length;
    }
}
