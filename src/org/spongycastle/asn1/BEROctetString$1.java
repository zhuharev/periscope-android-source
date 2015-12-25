// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.util.Enumeration;

// Referenced classes of package org.spongycastle.asn1:
//            BEROctetString

class Wr
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

    (BEROctetString beroctetstring)
    {
        Ws = beroctetstring;
        super();
        Wr = 0;
    }
}
