// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class IETFUtils
{

    public IETFUtils()
    {
    }

    private static void _mth02CA(StringBuffer stringbuffer, AttributeTypeAndValue attributetypeandvalue, Hashtable hashtable)
    {
        hashtable = (String)hashtable.get(attributetypeandvalue.agb);
        if (hashtable != null)
        {
            stringbuffer.append(hashtable);
        } else
        {
            stringbuffer.append(attributetypeandvalue.agb.identifier);
        }
        stringbuffer.append('=');
        stringbuffer.append(_mth0559(attributetypeandvalue.agc));
    }

    public static void _mth02CA(StringBuffer stringbuffer, RDN rdn, Hashtable hashtable)
    {
        boolean flag;
        if (rdn.agd.Wf.size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            rdn = rdn._mth09AC();
            boolean flag1 = true;
            for (int i = 0; i != rdn.length; i++)
            {
                if (flag1)
                {
                    flag1 = false;
                } else
                {
                    stringbuffer.append('+');
                }
                _mth02CA(stringbuffer, rdn[i], hashtable);
            }

            return;
        } else
        {
            _mth02CA(stringbuffer, rdn._mth09A2(), hashtable);
            return;
        }
    }

    private static boolean _mth02CA(AttributeTypeAndValue attributetypeandvalue, AttributeTypeAndValue attributetypeandvalue1)
    {
        if (attributetypeandvalue == attributetypeandvalue1)
        {
            return true;
        }
        if (attributetypeandvalue == null)
        {
            return false;
        }
        if (attributetypeandvalue1 == null)
        {
            return false;
        }
        if (!attributetypeandvalue.agb.equals(attributetypeandvalue1.agb))
        {
            return false;
        }
        return _mth1509(_mth0559(attributetypeandvalue.agc)).equals(_mth1509(_mth0559(attributetypeandvalue1.agc)));
    }

    public static boolean _mth02CA(RDN rdn, RDN rdn1)
    {
        boolean flag;
        if (rdn.agd.Wf.size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            boolean flag1;
            if (rdn1.agd.Wf.size() > 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                rdn = rdn._mth09AC();
                rdn1 = rdn1._mth09AC();
                if (rdn.length != rdn1.length)
                {
                    return false;
                }
                for (int i = 0; i != rdn.length; i++)
                {
                    if (!_mth02CA(rdn[i], rdn1[i]))
                    {
                        return false;
                    }
                }

            } else
            {
                return false;
            }
        } else
        {
            boolean flag2;
            if (rdn1.agd.Wf.size() > 1)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!flag2)
            {
                return _mth02CA(rdn._mth09A2(), rdn1._mth09A2());
            } else
            {
                return false;
            }
        }
        return true;
    }

    public static String _mth0559(ASN1Encodable asn1encodable)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if ((asn1encodable instanceof ASN1String) && !(asn1encodable instanceof DERUniversalString))
        {
            asn1encodable = ((ASN1String)asn1encodable).getString();
            if (asn1encodable.length() > 0 && asn1encodable.charAt(0) == '#')
            {
                stringbuffer.append((new StringBuilder("\\")).append(asn1encodable).toString());
            } else
            {
                stringbuffer.append(asn1encodable);
            }
        } else
        {
            try
            {
                stringbuffer.append((new StringBuilder("#")).append(_mth1427(Hex._mth1D65(asn1encodable._mth0427().getEncoded("DER")))).toString());
            }
            // Misplaced declaration of an exception variable
            catch (ASN1Encodable asn1encodable)
            {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        }
        int l = stringbuffer.length();
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        int k = l;
        if (stringbuffer.length() >= 2)
        {
            i = ((flag) ? 1 : 0);
            k = l;
            if (stringbuffer.charAt(0) == '\\')
            {
                i = ((flag) ? 1 : 0);
                k = l;
                if (stringbuffer.charAt(1) == '#')
                {
                    i = 0 + 2;
                    k = l;
                }
            }
        }
        int i1;
        for (; i != k; k = i1)
        {
            int j1;
label0:
            {
                if (stringbuffer.charAt(i) != ',' && stringbuffer.charAt(i) != '"' && stringbuffer.charAt(i) != '\\' && stringbuffer.charAt(i) != '+' && stringbuffer.charAt(i) != '=' && stringbuffer.charAt(i) != '<' && stringbuffer.charAt(i) != '>')
                {
                    j1 = i;
                    i1 = k;
                    if (stringbuffer.charAt(i) != ';')
                    {
                        break label0;
                    }
                }
                stringbuffer.insert(i, "\\");
                j1 = i + 1;
                i1 = k + 1;
            }
            i = j1 + 1;
        }

        i = 0;
        if (stringbuffer.length() > 0)
        {
            for (; stringbuffer.length() > i && stringbuffer.charAt(i) == ' '; i += 2)
            {
                stringbuffer.insert(i, "\\");
            }

        }
        for (int j = stringbuffer.length() - 1; j >= 0 && stringbuffer.charAt(j) == ' '; j--)
        {
            stringbuffer.insert(j, '\\');
        }

        return stringbuffer.toString();
    }

    private static String _mth1427(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        return new String(ac);
    }

    public static String _mth1509(String s)
    {
        Object obj = Strings.FE91(s.trim());
        s = ((String) (obj));
        if (((String) (obj)).length() > 0)
        {
            s = ((String) (obj));
            if (((String) (obj)).charAt(0) == '#')
            {
                ASN1Primitive asn1primitive = _mth150A(((String) (obj)));
                s = ((String) (obj));
                if (asn1primitive instanceof ASN1String)
                {
                    s = Strings.FE91(((ASN1String)asn1primitive).getString().trim());
                }
            }
        }
        obj = new StringBuffer();
        if (s.length() != 0)
        {
            char c = s.charAt(0);
            ((StringBuffer) (obj)).append(c);
            int i = 1;
            char c2 = c;
            for (; i < s.length(); i++)
            {
                char c1 = s.charAt(i);
                if (c2 != ' ' || c1 != ' ')
                {
                    ((StringBuffer) (obj)).append(c1);
                }
                c2 = c1;
            }

        }
        return ((StringBuffer) (obj)).toString();
    }

    private static ASN1Primitive _mth150A(String s)
    {
        try
        {
            s = ASN1Primitive._mth0640(Hex._mth1508(s.substring(1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException((new StringBuilder("unknown encoding in name: ")).append(s).toString());
        }
        return s;
    }
}
