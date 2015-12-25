// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

// Referenced classes of package org.spongycastle.asn1:
//            StreamUtil, DERTaggedObject, DEROctetString, DefiniteLengthInputStream, 
//            IndefiniteLengthInputStream, ASN1EncodableVector, BERTaggedObject, ASN1Encodable, 
//            BERFactory, DERFactory, ASN1InputStream, BERApplicationSpecificParser, 
//            BERTaggedObjectParser, DERExternalParser, BEROctetStringParser, BERSequenceParser, 
//            BERSetParser, ASN1Exception, DERApplicationSpecific, DERSequenceParser, 
//            DERSetParser, DEROctetStringParser, InMemoryRepresentable, ASN1TaggedObject

public class ASN1StreamParser
{

    private final byte VX[][];
    private final InputStream Wi;
    private final int Wj;

    public ASN1StreamParser(InputStream inputstream, int i)
    {
        Wi = inputstream;
        Wj = i;
        VX = new byte[11][];
    }

    public ASN1StreamParser(DefiniteLengthInputStream definitelengthinputstream)
    {
        this(((InputStream) (definitelengthinputstream)), StreamUtil._mth02CF(definitelengthinputstream));
    }

    final ASN1TaggedObject _mth02CA(boolean flag, int i)
    {
        if (!flag)
        {
            return new DERTaggedObject(false, i, new DEROctetString(((DefiniteLengthInputStream)Wi).toByteArray()));
        }
        ASN1EncodableVector asn1encodablevector = _mth0692();
        if (Wi instanceof IndefiniteLengthInputStream)
        {
            if (asn1encodablevector.VS.size() == 1)
            {
                return new BERTaggedObject(true, i, (ASN1Encodable)asn1encodablevector.VS.elementAt(0));
            } else
            {
                return new BERTaggedObject(false, i, BERFactory._mth02CA(asn1encodablevector));
            }
        }
        if (asn1encodablevector.VS.size() == 1)
        {
            return new DERTaggedObject(true, i, (ASN1Encodable)asn1encodablevector.VS.elementAt(0));
        } else
        {
            return new DERTaggedObject(false, i, DERFactory._mth02CB(asn1encodablevector));
        }
    }

    public final ASN1Encodable _mth068B()
    {
        int i = Wi.read();
        if (i == -1)
        {
            return null;
        }
        if (Wi instanceof IndefiniteLengthInputStream)
        {
            IndefiniteLengthInputStream indefinitelengthinputstream = (IndefiniteLengthInputStream)Wi;
            indefinitelengthinputstream.WW = false;
            indefinitelengthinputstream._mth06CA();
        }
        int j = ASN1InputStream._mth02CA(Wi, i);
        boolean flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = ASN1InputStream._mth02CB(Wi, Wj);
        if (k < 0)
        {
            if (!flag)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }
            ASN1StreamParser asn1streamparser = new ASN1StreamParser(new IndefiniteLengthInputStream(Wi, Wj), Wj);
            if ((i & 0x40) != 0)
            {
                return new BERApplicationSpecificParser(j, asn1streamparser);
            }
            if ((i & 0x80) != 0)
            {
                return new BERTaggedObjectParser(true, j, asn1streamparser);
            }
            switch (j)
            {
            case 8: // '\b'
                return new DERExternalParser(asn1streamparser);

            case 4: // '\004'
                return new BEROctetStringParser(asn1streamparser);

            case 16: // '\020'
                return new BERSequenceParser(asn1streamparser);

            case 17: // '\021'
                return new BERSetParser(asn1streamparser);
            }
            throw new ASN1Exception((new StringBuilder("unknown BER object encountered: 0x")).append(Integer.toHexString(j)).toString());
        }
        Object obj = new DefiniteLengthInputStream(Wi, k);
        if ((i & 0x40) != 0)
        {
            return new DERApplicationSpecific(flag, j, ((DefiniteLengthInputStream) (obj)).toByteArray());
        }
        if ((i & 0x80) != 0)
        {
            return new BERTaggedObjectParser(flag, j, new ASN1StreamParser(((DefiniteLengthInputStream) (obj))));
        }
        if (flag)
        {
            switch (j)
            {
            case 4: // '\004'
                return new BEROctetStringParser(new ASN1StreamParser(((DefiniteLengthInputStream) (obj))));

            case 16: // '\020'
                return new DERSequenceParser(new ASN1StreamParser(((DefiniteLengthInputStream) (obj))));

            case 17: // '\021'
                return new DERSetParser(new ASN1StreamParser(((DefiniteLengthInputStream) (obj))));

            case 8: // '\b'
                return new DERExternalParser(new ASN1StreamParser(((DefiniteLengthInputStream) (obj))));
            }
            throw new IOException((new StringBuilder("unknown tag ")).append(j).append(" encountered").toString());
        }
        switch (j)
        {
        case 4: // '\004'
            return new DEROctetStringParser(((DefiniteLengthInputStream) (obj)));
        }
        try
        {
            obj = ASN1InputStream._mth02CA(j, ((DefiniteLengthInputStream) (obj)), VX);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1Exception("corrupted stream detected", illegalargumentexception);
        }
        return ((ASN1Encodable) (obj));
    }

    final ASN1EncodableVector _mth0692()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        do
        {
            Object obj = _mth068B();
            if (obj != null)
            {
                if (obj instanceof InMemoryRepresentable)
                {
                    obj = ((InMemoryRepresentable)obj)._mth0505();
                    asn1encodablevector.VS.addElement(obj);
                } else
                {
                    obj = ((ASN1Encodable) (obj))._mth0427();
                    asn1encodablevector.VS.addElement(obj);
                }
            } else
            {
                return asn1encodablevector;
            }
        } while (true);
    }
}
