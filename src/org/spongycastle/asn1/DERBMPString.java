// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1OutputStream, StreamUtil

public class DERBMPString extends ASN1Primitive
    implements ASN1String
{

    private char WC[];

    public DERBMPString(String s)
    {
        WC = s.toCharArray();
    }

    DERBMPString(char ac[])
    {
        WC = ac;
    }

    public final String getString()
    {
        return new String(WC);
    }

    public int hashCode()
    {
        return Arrays.hashCode(WC);
    }

    public String toString()
    {
        return getString();
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(30);
        asn1outputstream._mth1449(WC.length << 1);
        for (int i = 0; i != WC.length; i++)
        {
            char c = WC[i];
            asn1outputstream.write((byte)(c >> 8));
            asn1outputstream.write((byte)c);
        }

    }

    protected final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERBMPString))
        {
            return false;
        } else
        {
            asn1primitive = (DERBMPString)asn1primitive;
            return Arrays._mth02CA(WC, ((DERBMPString) (asn1primitive)).WC);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        return StreamUtil._mth14BE(WC.length << 1) + 1 + (WC.length << 1);
    }
}
