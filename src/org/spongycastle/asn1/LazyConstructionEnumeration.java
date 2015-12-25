// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1InputStream, ASN1ParsingException, ASN1Primitive

class LazyConstructionEnumeration
    implements Enumeration
{

    private ASN1InputStream WX;
    private Object WY;

    public LazyConstructionEnumeration(byte abyte0[])
    {
        WX = new ASN1InputStream(abyte0, true);
        WY = _mth071A();
    }

    private ASN1Primitive _mth071A()
    {
        ASN1Primitive asn1primitive;
        try
        {
            asn1primitive = WX._mth04B7();
        }
        catch (IOException ioexception)
        {
            throw new ASN1ParsingException((new StringBuilder("malformed DER construction: ")).append(ioexception).toString(), ioexception);
        }
        return asn1primitive;
    }

    public boolean hasMoreElements()
    {
        return WY != null;
    }

    public Object nextElement()
    {
        Object obj = WY;
        WY = _mth071A();
        return obj;
    }
}
