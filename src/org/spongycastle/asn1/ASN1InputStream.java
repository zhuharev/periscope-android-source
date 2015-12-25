// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Vector;
import org.spongycastle.util.io.Streams;

// Referenced classes of package org.spongycastle.asn1:
//            BERTags, StreamUtil, DefiniteLengthInputStream, DERApplicationSpecific, 
//            ASN1StreamParser, ASN1EncodableVector, ASN1OctetString, ASN1Encodable, 
//            BEROctetString, LazyEncodedSequence, DERFactory, DERExternal, 
//            DERBitString, DERBMPString, ASN1Boolean, ASN1Enumerated, 
//            ASN1GeneralizedTime, DERGeneralString, DERIA5String, ASN1Integer, 
//            DERNull, DERNumericString, ASN1ObjectIdentifier, DEROctetString, 
//            DERPrintableString, DERT61String, DERUniversalString, ASN1UTCTime, 
//            DERUTF8String, DERVisibleString, IndefiniteLengthInputStream, BERApplicationSpecificParser, 
//            BERTaggedObjectParser, BEROctetStringParser, BERSequenceParser, BERSetParser, 
//            DERExternalParser, ASN1Exception, ASN1Primitive

public class ASN1InputStream extends FilterInputStream
    implements BERTags
{

    private final boolean VW;
    private final byte VX[][];
    final int limit;

    public ASN1InputStream(InputStream inputstream)
    {
        this(inputstream, StreamUtil._mth02CF(inputstream));
    }

    private ASN1InputStream(InputStream inputstream, int i)
    {
        this(inputstream, i, false);
    }

    private ASN1InputStream(InputStream inputstream, int i, boolean flag)
    {
        super(inputstream);
        limit = i;
        VW = flag;
        VX = new byte[11][];
    }

    public ASN1InputStream(PushbackInputStream pushbackinputstream, boolean flag)
    {
        this(((InputStream) (pushbackinputstream)), StreamUtil._mth02CF(pushbackinputstream), true);
    }

    public ASN1InputStream(byte abyte0[])
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))), abyte0.length);
    }

    public ASN1InputStream(byte abyte0[], boolean flag)
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))), abyte0.length, true);
    }

    private ASN1Primitive _mth02BE(int i, int j, int k)
    {
        boolean flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Object obj = new DefiniteLengthInputStream(this, k);
        if ((i & 0x40) != 0)
        {
            return new DERApplicationSpecific(flag, j, ((DefiniteLengthInputStream) (obj)).toByteArray());
        }
        if ((i & 0x80) != 0)
        {
            return (new ASN1StreamParser(((DefiniteLengthInputStream) (obj))))._mth02CA(flag, j);
        }
        if (flag)
        {
            switch (j)
            {
            case 4: // '\004'
                ASN1InputStream asn1inputstream = new ASN1InputStream(((InputStream) (obj)));
                obj = new ASN1EncodableVector();
                do
                {
                    ASN1Primitive asn1primitive = asn1inputstream._mth04B7();
                    if (asn1primitive == null)
                    {
                        break;
                    }
                    ((ASN1EncodableVector) (obj)).VS.addElement(asn1primitive);
                } while (true);
                ASN1OctetString aasn1octetstring[] = new ASN1OctetString[((ASN1EncodableVector) (obj)).VS.size()];
                for (i = 0; i != aasn1octetstring.length; i++)
                {
                    aasn1octetstring[i] = (ASN1OctetString)(ASN1Encodable)((ASN1EncodableVector) (obj)).VS.elementAt(i);
                }

                return new BEROctetString(aasn1octetstring);

            case 16: // '\020'
                if (VW)
                {
                    return new LazyEncodedSequence(((DefiniteLengthInputStream) (obj)).toByteArray());
                }
                obj = new ASN1InputStream(((InputStream) (obj)));
                ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
                do
                {
                    ASN1Primitive asn1primitive1 = ((ASN1InputStream) (obj))._mth04B7();
                    if (asn1primitive1 != null)
                    {
                        asn1encodablevector.VS.addElement(asn1primitive1);
                    } else
                    {
                        return DERFactory._mth02CB(asn1encodablevector);
                    }
                } while (true);

            case 17: // '\021'
                obj = new ASN1InputStream(((InputStream) (obj)));
                ASN1EncodableVector asn1encodablevector1 = new ASN1EncodableVector();
                do
                {
                    ASN1Primitive asn1primitive2 = ((ASN1InputStream) (obj))._mth04B7();
                    if (asn1primitive2 != null)
                    {
                        asn1encodablevector1.VS.addElement(asn1primitive2);
                    } else
                    {
                        return DERFactory._mth02CE(asn1encodablevector1);
                    }
                } while (true);

            case 8: // '\b'
                return new DERExternal(_mth02CA(((DefiniteLengthInputStream) (obj))));
            }
            throw new IOException((new StringBuilder("unknown tag ")).append(j).append(" encountered").toString());
        } else
        {
            return _mth02CA(j, ((DefiniteLengthInputStream) (obj)), VX);
        }
    }

    static int _mth02CA(InputStream inputstream, int i)
    {
        int j = i & 0x1f;
        i = j;
        if (j == 31)
        {
            int k = 0;
            int l = inputstream.read();
            i = l;
            if ((l & 0x7f) == 0)
            {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
            for (; i >= 0 && (i & 0x80) != 0; i = inputstream.read())
            {
                k = (i & 0x7f | k) << 7;
            }

            if (i < 0)
            {
                throw new EOFException("EOF found inside tag value.");
            }
            i = k | i & 0x7f;
        }
        return i;
    }

    private static ASN1EncodableVector _mth02CA(DefiniteLengthInputStream definitelengthinputstream)
    {
        return (new ASN1InputStream(definitelengthinputstream))._mth04AF();
    }

    static ASN1Primitive _mth02CA(int i, DefiniteLengthInputStream definitelengthinputstream, byte abyte0[][])
    {
        switch (i)
        {
        case 3: // '\003'
            return DERBitString._mth02CA(definitelengthinputstream.WS, definitelengthinputstream);

        case 30: // '\036'
            return new DERBMPString(_mth02CB(definitelengthinputstream));

        case 1: // '\001'
            return ASN1Boolean._mth02CC(_mth02CA(definitelengthinputstream, abyte0));

        case 10: // '\n'
            return ASN1Enumerated._mth02CD(_mth02CA(definitelengthinputstream, abyte0));

        case 24: // '\030'
            return new ASN1GeneralizedTime(definitelengthinputstream.toByteArray());

        case 27: // '\033'
            return new DERGeneralString(definitelengthinputstream.toByteArray());

        case 22: // '\026'
            return new DERIA5String(definitelengthinputstream.toByteArray());

        case 2: // '\002'
            return new ASN1Integer(definitelengthinputstream.toByteArray(), false);

        case 5: // '\005'
            return DERNull.WL;

        case 18: // '\022'
            return new DERNumericString(definitelengthinputstream.toByteArray());

        case 6: // '\006'
            return ASN1ObjectIdentifier._mth02D1(_mth02CA(definitelengthinputstream, abyte0));

        case 4: // '\004'
            return new DEROctetString(definitelengthinputstream.toByteArray());

        case 19: // '\023'
            return new DERPrintableString(definitelengthinputstream.toByteArray());

        case 20: // '\024'
            return new DERT61String(definitelengthinputstream.toByteArray());

        case 28: // '\034'
            return new DERUniversalString(definitelengthinputstream.toByteArray());

        case 23: // '\027'
            return new ASN1UTCTime(definitelengthinputstream.toByteArray());

        case 12: // '\f'
            return new DERUTF8String(definitelengthinputstream.toByteArray());

        case 26: // '\032'
            return new DERVisibleString(definitelengthinputstream.toByteArray());
        }
        throw new IOException((new StringBuilder("unknown tag ")).append(i).append(" encountered").toString());
    }

    private static byte[] _mth02CA(DefiniteLengthInputStream definitelengthinputstream, byte abyte0[][])
    {
        int i = definitelengthinputstream.WS;
        if (definitelengthinputstream.WS < abyte0.length)
        {
            byte abyte2[] = abyte0[i];
            byte abyte1[] = abyte2;
            if (abyte2 == null)
            {
                abyte1 = new byte[i];
                abyte0[i] = abyte1;
            }
            Streams._mth02CB(definitelengthinputstream, abyte1);
            return abyte1;
        } else
        {
            return definitelengthinputstream.toByteArray();
        }
    }

    static int _mth02CB(InputStream inputstream, int i)
    {
        int k = inputstream.read();
        int j = k;
        if (k < 0)
        {
            throw new EOFException("EOF found when length expected");
        }
        if (j == 128)
        {
            return -1;
        }
        k = j;
        if (j > 127)
        {
            int l = j & 0x7f;
            if (l > 4)
            {
                throw new IOException((new StringBuilder("DER length more than 4 bytes: ")).append(l).toString());
            }
            j = 0;
            for (k = 0; k < l; k++)
            {
                int i1 = inputstream.read();
                if (i1 < 0)
                {
                    throw new EOFException("EOF found reading length");
                }
                j = (j << 8) + i1;
            }

            if (j < 0)
            {
                throw new IOException("corrupted stream - negative length found");
            }
            k = j;
            if (j >= i)
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }
        return k;
    }

    private static char[] _mth02CB(DefiniteLengthInputStream definitelengthinputstream)
    {
        int k = definitelengthinputstream.WS / 2;
        char ac[] = new char[k];
        int i = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            int l = definitelengthinputstream.read();
            if (l < 0)
            {
                break;
            }
            int i1 = definitelengthinputstream.read();
            if (i1 < 0)
            {
                break;
            }
            int j = i + 1;
            ac[i] = (char)(l << 8 | i1 & 0xff);
            i = j;
        } while (true);
        return ac;
    }

    private int _mth04AB()
    {
        return _mth02CB(this, limit);
    }

    private ASN1EncodableVector _mth04AF()
    {
        ASN1EncodableVector asn1encodablevector = new ASN1EncodableVector();
        do
        {
            ASN1Primitive asn1primitive = _mth04B7();
            if (asn1primitive != null)
            {
                asn1encodablevector.VS.addElement(asn1primitive);
            } else
            {
                return asn1encodablevector;
            }
        } while (true);
    }

    public final ASN1Primitive _mth04B7()
    {
        int i = read();
        if (i <= 0)
        {
            if (i == 0)
            {
                throw new IOException("unexpected end-of-contents marker");
            } else
            {
                return null;
            }
        }
        int j = _mth02CA(this, i);
        boolean flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int k = _mth04AB();
        if (k < 0)
        {
            if (!flag)
            {
                throw new IOException("indefinite length primitive encoding encountered");
            }
            ASN1StreamParser asn1streamparser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, limit), limit);
            if ((i & 0x40) != 0)
            {
                return (new BERApplicationSpecificParser(j, asn1streamparser))._mth0505();
            }
            if ((i & 0x80) != 0)
            {
                return (new BERTaggedObjectParser(true, j, asn1streamparser))._mth0505();
            }
            switch (j)
            {
            case 4: // '\004'
                return (new BEROctetStringParser(asn1streamparser))._mth0505();

            case 16: // '\020'
                return (new BERSequenceParser(asn1streamparser))._mth0505();

            case 17: // '\021'
                return (new BERSetParser(asn1streamparser))._mth0505();

            case 8: // '\b'
                return (new DERExternalParser(asn1streamparser))._mth0505();
            }
            throw new IOException("unknown BER object encountered");
        }
        ASN1Primitive asn1primitive;
        try
        {
            asn1primitive = _mth02BE(i, j, k);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new ASN1Exception("corrupted stream detected", illegalargumentexception);
        }
        return asn1primitive;
    }
}
