// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1SequenceParser, BERSequence, ASN1StreamParser, ASN1Primitive

public class BERSequenceParser
    implements ASN1SequenceParser
{

    private ASN1StreamParser Wv;

    BERSequenceParser(ASN1StreamParser asn1streamparser)
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
            throw new IllegalStateException(ioexception.getMessage());
        }
        return asn1primitive;
    }

    public final ASN1Primitive _mth0505()
    {
        return new BERSequence(Wv._mth0692());
    }
}
