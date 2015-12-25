// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1OutputStream, StreamUtil

public class ASN1UTCTime extends ASN1Primitive
{

    private byte VV[];

    ASN1UTCTime(byte abyte0[])
    {
        VV = abyte0;
    }

    public int hashCode()
    {
        return Arrays.hashCode(VV);
    }

    public String toString()
    {
        return Strings._mth1D59(VV);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        asn1outputstream.write(23);
        int j = VV.length;
        asn1outputstream._mth1449(j);
        for (int i = 0; i != j; i++)
        {
            asn1outputstream.write(VV[i]);
        }

    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1UTCTime))
        {
            return false;
        } else
        {
            return Arrays._mth1427(VV, ((ASN1UTCTime)asn1primitive).VV);
        }
    }

    final boolean _mth03BD()
    {
        return false;
    }

    final int _mth03DA()
    {
        int i = VV.length;
        return StreamUtil._mth14BE(i) + 1 + i;
    }

    public final String _mth0437()
    {
        String s2 = Strings._mth1D59(VV);
        if (s2.indexOf('-') < 0 && s2.indexOf('+') < 0)
        {
            if (s2.length() == 11)
            {
                return (new StringBuilder()).append(s2.substring(0, 10)).append("00GMT+00:00").toString();
            } else
            {
                return (new StringBuilder()).append(s2.substring(0, 12)).append("GMT+00:00").toString();
            }
        }
        int j = s2.indexOf('-');
        int i = j;
        if (j < 0)
        {
            i = s2.indexOf('+');
        }
        String s = s2;
        String s1 = s;
        if (i == s2.length() - 3)
        {
            s1 = (new StringBuilder()).append(s).append("00").toString();
        }
        if (i == 10)
        {
            return (new StringBuilder()).append(s1.substring(0, 10)).append("00GMT").append(s1.substring(10, 13)).append(":").append(s1.substring(13, 15)).toString();
        } else
        {
            return (new StringBuilder()).append(s1.substring(0, 12)).append("GMT").append(s1.substring(12, 15)).append(":").append(s1.substring(15, 17)).toString();
        }
    }

    public final String _mth0695()
    {
        String s = _mth0437();
        if (s.charAt(0) < '5')
        {
            return (new StringBuilder("20")).append(s).toString();
        } else
        {
            return (new StringBuilder("19")).append(s).toString();
        }
    }
}
