// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1;

import java.io.OutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

// Referenced classes of package org.spongycastle.asn1:
//            ASN1Primitive, ASN1String, ASN1OutputStream, StreamUtil

public class DERPrintableString extends ASN1Primitive
    implements ASN1String
{

    private byte Wa[];

    public DERPrintableString(String s)
    {
        this(s, false);
    }

    public DERPrintableString(String s, boolean flag)
    {
        if (flag)
        {
            int i = s.length() - 1;
label0:
            do
            {
                if (i >= 0)
                {
                    char c = s.charAt(i);
                    if (c > '\177')
                    {
                        i = 0;
                        break;
                    }
                    if (('a' > c || c > 'z') && ('A' > c || c > 'Z') && ('0' > c || c > '9'))
                    {
                        switch (c)
                        {
                        case 33: // '!'
                        case 34: // '"'
                        case 35: // '#'
                        case 36: // '$'
                        case 37: // '%'
                        case 38: // '&'
                        case 42: // '*'
                        case 48: // '0'
                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                        case 59: // ';'
                        case 60: // '<'
                        case 62: // '>'
                        default:
                            i = 0;
                            break label0;

                        case 32: // ' '
                        case 39: // '\''
                        case 40: // '('
                        case 41: // ')'
                        case 43: // '+'
                        case 44: // ','
                        case 45: // '-'
                        case 46: // '.'
                        case 47: // '/'
                        case 58: // ':'
                        case 61: // '='
                        case 63: // '?'
                            break;
                        }
                    }
                    i--;
                    continue;
                }
                i = 1;
                break;
            } while (true);
            if (i == 0)
            {
                throw new IllegalArgumentException("string contains illegal characters");
            }
        }
        Wa = Strings.FEE7(s);
    }

    DERPrintableString(byte abyte0[])
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
        asn1outputstream.write(19);
        asn1outputstream._mth1449(abyte0.length);
        asn1outputstream.Wb.write(abyte0);
    }

    final boolean _mth02CA(ASN1Primitive asn1primitive)
    {
        if (!(asn1primitive instanceof DERPrintableString))
        {
            return false;
        } else
        {
            asn1primitive = (DERPrintableString)asn1primitive;
            return Arrays._mth1427(Wa, ((DERPrintableString) (asn1primitive)).Wa);
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
