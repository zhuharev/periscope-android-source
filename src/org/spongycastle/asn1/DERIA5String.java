// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1TaggedObject, ASN1Encodable, 
//            ASN1OctetString, ASN1OutputStream, StreamUtil

public class DERIA5String extends ASN1Primitive
    implements ASN1String
{

    private byte Wa[];

    public DERIA5String(String s)
    {
        this(s, false);
    }

    public DERIA5String(String s, boolean flag)
    {
        if (s == null)
        {
            throw new NullPointerException("string cannot be null");
        }
        if (flag && !_mth03B9(s))
        {
            throw new IllegalArgumentException("string contains illegal characters");
        } else
        {
            Wa = Strings.FEE7(s);
            return;
        }
    }

    DERIA5String(byte abyte0[])
    {
        Wa = abyte0;
    }

    public static DERIA5String _mth02BB(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof DERIA5String))
        {
            return (DERIA5String)asn1encodable;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    public static DERIA5String _mth037A(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        if (asn1taggedobject.Wn != null)
        {
            asn1taggedobject = asn1taggedobject.Wn._mth0427();
        } else
        {
            asn1taggedobject = null;
        }
        if (asn1taggedobject instanceof DERIA5String)
        {
            return _mth02BB(asn1taggedobject);
        } else
        {
            return new DERIA5String(((ASN1OctetString)asn1taggedobject)._mth0501());
        }
    }

    private static boolean _mth03B9(String s)
    {
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) > '\177')
            {
                return false;
            }
        }

        return true;
    }

    public final String getString()
    {
        return Strings._mth1D59(Wa);
    }

    public int hashCode()
    {
        return Arrays.hashCode(Wa);
    }

    public String toString()
    {
        return getString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = Wa;
        asn1outputstream.write(22);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERIA5String))
        {
            return false;
        } else
        {
            asn1primitive = (DERIA5String)asn1primitive;
            return Arrays._mth1427(Wa, ((DERIA5String) (asn1primitive)).Wa);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(Wa.length) + 1 + Wa.length;
    }
}
