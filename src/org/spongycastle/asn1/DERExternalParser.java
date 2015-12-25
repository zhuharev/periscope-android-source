// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Encodable, InMemoryRepresentable, ASN1ParsingException, DERExternal, 
//            ASN1StreamParser, ASN1Exception, ASN1Primitive

public class DERExternalParser
    implements ASN1Encodable, InMemoryRepresentable
{

    private ASN1StreamParser Wv;

    public DERExternalParser(ASN1StreamParser asn1streamparser)
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
            throw new ASN1ParsingException("unable to get DER object", ioexception);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1ParsingException("unable to get DER object", illegalargumentexception);
        }
        return asn1primitive;
    }

    public final ASN1Primitive _mth0505()
    {
        DERExternal derexternal;
        try
        {
            derexternal = new DERExternal(Wv._mth0692());
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1Exception(illegalargumentexception.getMessage(), illegalargumentexception);
        }
        return derexternal;
    }
}
