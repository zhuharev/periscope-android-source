// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

public final class Strings
{

    public Strings()
    {
    }

    public static byte[] _mth02BB(char ac[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            _mth02CA(ac, bytearrayoutputstream);
        }
        // Misplaced declaration of an exception variable
        catch (char ac[])
        {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
        return bytearrayoutputstream.toByteArray();
    }

    private static void _mth02CA(char ac[], ByteArrayOutputStream bytearrayoutputstream)
    {
        for (int i = 0; i < ac.length; i++)
        {
            int j = ac[i];
            if (j < 128)
            {
                bytearrayoutputstream.write(j);
                continue;
            }
            if (j < 2048)
            {
                bytearrayoutputstream.write(j >> 6 | 0xc0);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
                continue;
            }
            if (j >= 55296 && j <= 57343)
            {
                if (i + 1 >= ac.length)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                i++;
                char c = ac[i];
                if (j > 56319)
                {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
                j = ((j & 0x3ff) << 10 | c & 0x3ff) + 0x10000;
                bytearrayoutputstream.write(j >> 18 | 0xf0);
                bytearrayoutputstream.write(j >> 12 & 0x3f | 0x80);
                bytearrayoutputstream.write(j >> 6 & 0x3f | 0x80);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
            } else
            {
                bytearrayoutputstream.write(j >> 12 | 0xe0);
                bytearrayoutputstream.write(j >> 6 & 0x3f | 0x80);
                bytearrayoutputstream.write(j & 0x3f | 0x80);
            }
        }

    }

    public static String[] _mth02CA(String s, char c)
    {
        Vector vector = new Vector();
        for (c = '\001'; c != 0;)
        {
            int i = s.indexOf('.');
            if (i > 0)
            {
                vector.addElement(s.substring(0, i));
                s = s.substring(i + 1);
            } else
            {
                c = '\0';
                vector.addElement(s);
            }
        }

        s = new String[vector.size()];
        for (c = '\0'; c != s.length; c++)
        {
            s[c] = (String)vector.elementAt(c);
        }

        return s;
    }

    public static String _mth1D53(byte abyte0[])
    {
        int i = 0;
        int j = 0;
        while (i < abyte0.length) 
        {
            j++;
            if ((abyte0[i] & 0xf0) == 240)
            {
                j++;
                i += 4;
            } else
            if ((abyte0[i] & 0xe0) == 224)
            {
                i += 3;
            } else
            if ((abyte0[i] & 0xc0) == 192)
            {
                i += 2;
            } else
            {
                i++;
            }
        }
        char ac[] = new char[j];
        i = 0;
        int i1;
        for (int k = 0; i < abyte0.length; k = i1)
        {
            char c;
            if ((abyte0[i] & 0xf0) == 240)
            {
                int l = ((abyte0[i] & 3) << 18 | (abyte0[i + 1] & 0x3f) << 12 | (abyte0[i + 2] & 0x3f) << 6 | abyte0[i + 3] & 0x3f) - 0x10000;
                char c1 = (char)(l >> 10 | 0xd800);
                c = (char)(l & 0x3ff | 0xdc00);
                l = k + 1;
                ac[k] = c1;
                i += 4;
                k = l;
            } else
            if ((abyte0[i] & 0xe0) == 224)
            {
                c = (char)((abyte0[i] & 0xf) << 12 | (abyte0[i + 1] & 0x3f) << 6 | abyte0[i + 2] & 0x3f);
                i += 3;
            } else
            if ((abyte0[i] & 0xd0) == 208)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
            } else
            if ((abyte0[i] & 0xc0) == 192)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
            } else
            {
                c = (char)(abyte0[i] & 0xff);
                i++;
            }
            i1 = k + 1;
            ac[k] = c;
        }

        return new String(ac);
    }

    public static String _mth1D59(byte abyte0[])
    {
        return new String(_mth1D5B(abyte0));
    }

    private static char[] _mth1D5B(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        return ac;
    }

    public static byte[] FE7B(String s)
    {
        return _mth02BB(s.toCharArray());
    }

    public static String FE7C(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for (int i = 0; i != ac.length;)
        {
            char c = ac[i];
            boolean flag1 = flag;
            if ('a' <= c)
            {
                flag1 = flag;
                if ('z' >= c)
                {
                    flag1 = true;
                    ac[i] = (char)((c - 97) + 65);
                }
            }
            i++;
            flag = flag1;
        }

        if (flag)
        {
            return new String(ac);
        } else
        {
            return s;
        }
    }

    public static String FE91(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for (int i = 0; i != ac.length;)
        {
            char c = ac[i];
            boolean flag1 = flag;
            if ('A' <= c)
            {
                flag1 = flag;
                if ('Z' >= c)
                {
                    flag1 = true;
                    ac[i] = (char)((c - 65) + 97);
                }
            }
            i++;
            flag = flag1;
        }

        if (flag)
        {
            return new String(ac);
        } else
        {
            return s;
        }
    }

    public static byte[] FEE7(String s)
    {
        byte abyte0[] = new byte[s.length()];
        for (int i = 0; i != abyte0.length; i++)
        {
            abyte0[i] = (byte)s.charAt(i);
        }

        return abyte0;
    }
}
