// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.UnsupportedEncodingException;

public final class vq
{

    private static final byte Vf[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };

    public static String _mth02BF(byte abyte0[])
    {
        return _mth02CA(abyte0, Vf);
    }

    private static String _mth02CA(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[(abyte0.length + 2 << 2) / 3];
        int i = 0;
        int i1 = abyte0.length - abyte0.length % 3;
        for (int j = 0; j < i1; j += 3)
        {
            int j1 = i + 1;
            abyte2[i] = abyte1[(abyte0[j] & 0xff) >> 2];
            i = j1 + 1;
            abyte2[j1] = abyte1[(abyte0[j] & 3) << 4 | (abyte0[j + 1] & 0xff) >> 4];
            j1 = i + 1;
            abyte2[i] = abyte1[(abyte0[j + 1] & 0xf) << 2 | (abyte0[j + 2] & 0xff) >> 6];
            i = j1 + 1;
            abyte2[j1] = abyte1[abyte0[j + 2] & 0x3f];
        }

        switch (abyte0.length % 3)
        {
        case 1: // '\001'
            int k = i + 1;
            abyte2[i] = abyte1[(abyte0[i1] & 0xff) >> 2];
            i = k + 1;
            abyte2[k] = abyte1[(abyte0[i1] & 3) << 4];
            k = i + 1;
            abyte2[i] = 61;
            i = k + 1;
            abyte2[k] = 61;
            break;

        case 2: // '\002'
            int l = i + 1;
            abyte2[i] = abyte1[(abyte0[i1] & 0xff) >> 2];
            i = l + 1;
            abyte2[l] = abyte1[(abyte0[i1] & 3) << 4 | (abyte0[i1 + 1] & 0xff) >> 4];
            l = i + 1;
            abyte2[i] = abyte1[(abyte0[i1 + 1] & 0xf) << 2];
            i = l + 1;
            abyte2[l] = 61;
            break;
        }
        try
        {
            abyte0 = new String(abyte2, 0, i, "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
    }

    public static byte[] _mth1508(String s)
    {
        int l = s.length();
        do
        {
            if (l <= 0)
            {
                break;
            }
            char c = s.charAt(l - 1);
            if (c != '=' && c != '\n' && c != '\r' && c != ' ' && c != '\t')
            {
                break;
            }
            l--;
        } while (true);
        byte abyte0[] = new byte[(int)(((long)l * 6L) / 8L)];
        int k = 0;
        int i2 = 0;
        int l1 = 0;
        for (int j1 = 0; j1 < l;)
        {
            int i;
            int j2;
            int k2;
label0:
            {
                char c1 = s.charAt(j1);
                if (c1 >= 'A' && c1 <= 'Z')
                {
                    i = c1 - 65;
                } else
                if (c1 >= 'a' && c1 <= 'z')
                {
                    i = c1 - 71;
                } else
                if (c1 >= '0' && c1 <= '9')
                {
                    i = c1 + 4;
                } else
                if (c1 == '+' || c1 == '-')
                {
                    i = 62;
                } else
                if (c1 == '/' || c1 == '_')
                {
                    i = 63;
                } else
                {
                    k2 = k;
                    i = i2;
                    j2 = l1;
                    if (c1 != '\n')
                    {
                        k2 = k;
                        i = i2;
                        j2 = l1;
                        if (c1 != '\r')
                        {
                            k2 = k;
                            i = i2;
                            j2 = l1;
                            if (c1 != ' ')
                            {
                                k2 = k;
                                i = i2;
                                j2 = l1;
                                if (c1 != '\t')
                                {
                                    return null;
                                }
                            }
                        }
                    }
                    break label0;
                }
                l1 = l1 << 6 | (byte)i;
                i2++;
                k2 = k;
                i = i2;
                j2 = l1;
                if (i2 % 4 == 0)
                {
                    i = k + 1;
                    abyte0[k] = (byte)(l1 >> 16);
                    k = i + 1;
                    abyte0[i] = (byte)(l1 >> 8);
                    k2 = k + 1;
                    abyte0[k] = (byte)l1;
                    j2 = l1;
                    i = i2;
                }
            }
            j1++;
            k = k2;
            i2 = i;
            l1 = j2;
        }

        l = i2 % 4;
        if (l == 1)
        {
            return null;
        }
        int j;
        if (l == 2)
        {
            j = k + 1;
            abyte0[k] = (byte)((l1 << 12) >> 16);
        } else
        {
            j = k;
            if (l == 3)
            {
                int i1 = l1 << 6;
                int k1 = k + 1;
                abyte0[k] = (byte)(i1 >> 16);
                j = k1 + 1;
                abyte0[k1] = (byte)(i1 >> 8);
            }
        }
        if (j == abyte0.length)
        {
            return abyte0;
        } else
        {
            s = new byte[j];
            System.arraycopy(abyte0, 0, s, 0, j);
            return s;
        }
    }

}
