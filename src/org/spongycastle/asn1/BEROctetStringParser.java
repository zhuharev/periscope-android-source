// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1OctetStringParser, ASN1ParsingException, ConstructedOctetStream, BEROctetString, 
//            ASN1StreamParser, ASN1Primitive

public class BEROctetStringParser
    implements ASN1OctetStringParser
{

    private ASN1StreamParser Wv;

    BEROctetStringParser(ASN1StreamParser asn1streamparser)
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
            throw new ASN1ParsingException((new StringBuilder("IOException converting stream to byte array: ")).append(ioexception.getMessage()).toString(), ioexception);
        }
        return asn1primitive;
    }

    public final InputStream _mth04CC()
    {
        return new ConstructedOctetStream(Wv);
    }

    public final ASN1Primitive _mth0505()
    {
        return new BEROctetString(Streams._mth02D1(new ConstructedOctetStream(Wv)));
    }
}
