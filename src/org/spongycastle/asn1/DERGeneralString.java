// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1OutputStream, StreamUtil

public class DERGeneralString extends ASN1Primitive
    implements ASN1String
{

    private byte Wa[];

    DERGeneralString(byte abyte0[])
    {
        Wa = abyte0;
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
        asn1outputstream.write(27);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERGeneralString))
        {
            return false;
        } else
        {
            asn1primitive = (DERGeneralString)asn1primitive;
            return Arrays._mth1427(Wa, ((DERGeneralString) (asn1primitive)).Wa);
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
