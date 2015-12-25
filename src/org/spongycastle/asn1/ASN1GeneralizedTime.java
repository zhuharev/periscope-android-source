// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1OutputStream, StreamUtil, ASN1Encodable

public class ASN1GeneralizedTime extends ASN1Primitive
{

    private byte VV[];

    public ASN1GeneralizedTime(String s)
    {
        VV = Strings.FEE7(s);
        try
        {
            getDate();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid date string: ")).append(s.getMessage()).toString());
        }
    }

    ASN1GeneralizedTime(byte abyte0[])
    {
        VV = abyte0;
    }

    public static ASN1GeneralizedTime _mth02CB(ASN1Encodable asn1encodable)
    {
        if (asn1encodable == null || (asn1encodable instanceof ASN1GeneralizedTime))
        {
            return (ASN1GeneralizedTime)asn1encodable;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("illegal object in getInstance: ")).append(asn1encodable.getClass().getName()).toString());
        }
    }

    private String _mth043B()
    {
        String s;
        TimeZone timezone;
        int i;
        int j;
        int k;
        s = "+";
        timezone = TimeZone.getDefault();
        k = timezone.getRawOffset();
        j = k;
        i = j;
        if (k < 0)
        {
            s = "-";
            i = -j;
        }
        j = i / 0x36ee80;
        k = (i - j * 60 * 60 * 1000) / 60000;
        i = j;
        if (!timezone.useDaylightTime())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        i = j;
        boolean flag;
        if (!timezone.inDaylightTime(getDate()))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        flag = s.equals("+");
        if (flag)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        i += j;
_L2:
        StringBuilder stringbuilder = (new StringBuilder("GMT")).append(s);
        if (i < 10)
        {
            s = (new StringBuilder("0")).append(i).toString();
        } else
        {
            s = Integer.toString(i);
        }
        stringbuilder = stringbuilder.append(s).append(":");
        if (k < 10)
        {
            s = (new StringBuilder("0")).append(k).toString();
        } else
        {
            s = Integer.toString(k);
        }
        return stringbuilder.append(s).toString();
        ParseException parseexception;
        parseexception;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean _mth044C()
    {
        for (int i = 0; i != VV.length; i++)
        {
            if (VV[i] == 46 && i == 14)
            {
                return true;
            }
        }

        return false;
    }

    public final Date getDate()
    {
        String s1 = Strings._mth1D59(VV);
        SimpleDateFormat simpledateformat;
        if (s1.endsWith("Z"))
        {
            if (_mth044C())
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpledateformat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else
        if (s1.indexOf('-') > 0 || s1.indexOf('+') > 0)
        {
            s1 = _mth0437();
            if (_mth044C())
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpledateformat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else
        {
            if (_mth044C())
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else
            {
                simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpledateformat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        String s = s1;
        if (_mth044C())
        {
            String s2 = s1.substring(14);
            int i = 1;
            do
            {
                if (i >= s2.length())
                {
                    break;
                }
                char c = s2.charAt(i);
                if ('0' > c || c > '9')
                {
                    break;
                }
                i++;
            } while (true);
            if (i - 1 > 3)
            {
                s = (new StringBuilder()).append(s2.substring(0, 4)).append(s2.substring(i)).toString();
                s = (new StringBuilder()).append(s1.substring(0, 14)).append(s).toString();
            } else
            if (i - 1 == 1)
            {
                s = (new StringBuilder()).append(s2.substring(0, i)).append("00").append(s2.substring(i)).toString();
                s = (new StringBuilder()).append(s1.substring(0, 14)).append(s).toString();
            } else
            {
                s = s1;
                if (i - 1 == 2)
                {
                    s = (new StringBuilder()).append(s2.substring(0, i)).append("0").append(s2.substring(i)).toString();
                    s = (new StringBuilder()).append(s1.substring(0, 14)).append(s).toString();
                }
            }
        }
        return simpledateformat.parse(s);
    }

    public int hashCode()
    {
        return Arrays.hashCode(VV);
    }

    final void _mth02CA(ASN1OutputStream asn1outputstream)
    {
        byte abyte0[] = VV;
        asn1outputstream.write(24);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof ASN1GeneralizedTime))
        {
            return false;
        } else
        {
            return Arrays._mth1427(VV, ((ASN1GeneralizedTime)asn1primitive).VV);
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
        String s = Strings._mth1D59(VV);
        if (s.charAt(s.length() - 1) == 'Z')
        {
            return (new StringBuilder()).append(s.substring(0, s.length() - 1)).append("GMT+00:00").toString();
        }
        int i = s.length() - 5;
        char c = s.charAt(i);
        if (c == '-' || c == '+')
        {
            return (new StringBuilder()).append(s.substring(0, i)).append("GMT").append(s.substring(i, i + 3)).append(":").append(s.substring(i + 3)).toString();
        }
        i = s.length() - 3;
        c = s.charAt(i);
        if (c == '-' || c == '+')
        {
            return (new StringBuilder()).append(s.substring(0, i)).append("GMT").append(s.substring(i)).append(":00").toString();
        } else
        {
            return (new StringBuilder()).append(s).append(_mth043B()).toString();
        }
    }
}
