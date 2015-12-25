// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Null, ASN1OutputStream

public class DERNull extends ASN1Null
{

    public static final DERNull WL = new DERNull();
    private static final byte WM[] = new byte[0];

    public DERNull()
    {
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = WM;
        asn1outputstream.write(5);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return 2;
    }

}
