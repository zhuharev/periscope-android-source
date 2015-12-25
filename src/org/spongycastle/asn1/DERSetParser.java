// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1SetParser, ASN1ParsingException, DERSet, ASN1StreamParser, 
//            ASN1Primitive

public class DERSetParser
    implements ASN1SetParser
{

    private ASN1StreamParser Wv;

    DERSetParser(ASN1StreamParser asn1streamparser)
    {
        Wv = asn1streamparser;
    }

    public final ASN1Primitive _mth0427()
    {
        ASN1Primitive asn1primitive;
        try
        {
            asn1primitive = _mth0505();
        }
        catch (IOException ioexception)
        {
            throw new ASN1ParsingException(ioexception.getMessage(), ioexception);
        }
        return asn1primitive;
    }

    public final ASN1Primitive _mth0505()
    {
        return new DERSet(Wv._mth0692(), false);
    }
}
