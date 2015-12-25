// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1TaggedObject, ASN1Encodable, ASN1OctetString, 
//            ASN1OutputStream

public class ASN1Boolean extends ASN1Primitive
{

    private static final byte VN[] = {
        -1
    };
    private static final byte VO[] = {
        0
    };
    private static ASN1Boolean VQ = new ASN1Boolean(false);
    public static final ASN1Boolean VR = new ASN1Boolean(true);
    public byte VP[];

    public ASN1Boolean(boolean flag)
    {
        byte abyte0[];
        if (flag)
        {
            abyte0 = VN;
        } else
        {
            abyte0 = VO;
        }
        VP = abyte0;
    }

    private ASN1Boolean(byte abyte0[])
    {
        if (abyte0.length != 1)
        {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        if (abyte0[0] == 0)
        {
            VP = VO;
            return;
        }
        if ((abyte0[0] & 0xff) == 255)
        {
            VP = VN;
            return;
        } else
        {
            VP = Arrays._mth1D4C(abyte0);
            return;
        }
    }

    public static ASN1Boolean _mth02CA(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof ASN1Boolean))
        {
            return (ASN1Boolean)asn1encodable;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public static ASN1Boolean _mth02CA(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        if (asn1taggedobject instanceof ASN1Boolean)
        {
            return _mth02CA(((ASN1Encodable) (asn1taggedobject)));
        } else
        {
            return _mth02CC(((ASN1OctetString)asn1taggedobject)._mth0501());
        }
    }

    static ASN1Boolean _mth02CC(byte abyte0[])
    {
        if (abyte0.length != 1)
        {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        if (abyte0[0] == 0)
        {
            return VQ;
        }
        if ((abyte0[0] & 0xff) == 255)
        {
            return VR;
        } else
        {
            return new ASN1Boolean(abyte0);
        }
    }

    public static ASN1Boolean _mth02E3(boolean flag)
    {
        if (flag)
        {
            return VR;
        } else
        {
            return VQ;
        }
    }

    public int hashCode()
    {
        return VP[0];
    }

    public String toString()
    {
        if (VP[0] != 0)
        {
            return "TRUE";
        } else
        {
            return "FALSE";
        }
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = VP;
        asn1outputstream.write(1);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    protected final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (asn1primitive instanceof ASN1Boolean)
        {
            return VP[0] == ((ASN1Boolean)asn1primitive).VP[0];
        } else
        {
            return false;
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return 3;
    }

}
