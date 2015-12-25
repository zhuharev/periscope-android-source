// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class nw
{

    private static char LT[];
    private static byte LU[];

    public static char[] _mth02BC(byte abyte0[])
    {
        int k1 = abyte0.length;
        int l1 = ((k1 << 2) + 2) / 3;
        char ac[] = new char[(k1 + 2) / 3 << 2];
        int i = 0;
        for (int j = 0; i < k1; j++)
        {
            int l = i + 1;
            int i2 = abyte0[i] & 0xff;
            int k;
            if (l < k1)
            {
                i = l + 1;
                k = abyte0[l] & 0xff;
            } else
            {
                k = 0;
                i = l;
            }
            if (i < k1)
            {
                l = i + 1;
                int i1 = abyte0[i] & 0xff;
                i = l;
                l = i1;
            } else
            {
                l = 0;
            }
            int j1 = j + 1;
            ac[j] = LT[i2 >>> 2];
            j = j1 + 1;
            ac[j1] = LT[(i2 & 3) << 4 | k >>> 4];
            char c;
            if (j < l1)
            {
                c = LT[(k & 0xf) << 2 | l >>> 6];
            } else
            {
                c = '=';
            }
            ac[j] = c;
            j++;
            if (j < l1)
            {
                c = LT[l & 0x3f];
            } else
            {
                c = '=';
            }
            ac[j] = c;
        }

        return ac;
    }

    private static byte[] _mth02CA(char ac[])
    {
        int i = ac.length;
        int l = i;
        if (i % 4 != 0)
        {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        for (; l > 0 && ac[l - 1] == '='; l--) { }
        int j1 = (l * 3) / 4;
        byte abyte0[] = new byte[j1];
        i = 0;
        int k = 0;
        do
        {
            if (i >= l)
            {
                break;
            }
            int j = i + 1;
            char c2 = ac[i];
            i = j + 1;
            char c3 = ac[j];
            if (i < l)
            {
                j = i + 1;
                char c = ac[i];
                i = j;
                j = c;
            } else
            {
                j = 65;
            }
            int i1;
            if (i < l)
            {
                i1 = i + 1;
                char c1 = ac[i];
                i = i1;
                i1 = c1;
            } else
            {
                i1 = 65;
            }
            if (c2 > '\177' || c3 > '\177' || j > '\177' || i1 > '\177')
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte byte1 = LU[c2];
            c2 = LU[c3];
            byte byte0 = LU[j];
            c3 = LU[i1];
            if (byte1 < 0 || c2 < 0 || byte0 < 0 || c3 < 0)
            {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i1 = k + 1;
            abyte0[k] = (byte)(byte1 << 2 | c2 >>> 4);
            j = i1;
            if (i1 < j1)
            {
                j = i1 + 1;
                abyte0[i1] = (byte)((c2 & 0xf) << 4 | byte0 >>> 2);
            }
            k = j;
            if (j < j1)
            {
                k = j + 1;
                abyte0[j] = (byte)((byte0 & 3) << 6 | c3);
            }
        } while (true);
        return abyte0;
    }

    public static byte[] _mth1508(String s)
    {
        char ac[] = new char[s.length()];
        int i = 0;
        for (int j = 0; j < s.length();)
        {
            int k = i;
            if (s.charAt(j) != '\n')
            {
                k = i;
                if (s.charAt(j) != ' ')
                {
                    k = i + 1;
                    ac[i] = s.charAt(j);
                }
            }
            j++;
            i = k;
        }

        return _mth02CA((new String(ac)).trim().toCharArray());
    }

    static 
    {
        LT = new char[64];
        int i = 0;
        for (char c = 'A'; c <= 'Z';)
        {
            char ac[] = LT;
            int l = i + 1;
            ac[i] = c;
            c++;
            i = l;
        }

        for (char c1 = 'a'; c1 <= 'z';)
        {
            char ac1[] = LT;
            int i1 = i + 1;
            ac1[i] = c1;
            c1++;
            i = i1;
        }

        for (char c2 = '0'; c2 <= '9';)
        {
            char ac2[] = LT;
            int j1 = i + 1;
            ac2[i] = c2;
            c2++;
            i = j1;
        }

        LT[i] = '+';
        LT[i + 1] = '/';
        LU = new byte[128];
        for (int j = 0; j < LU.length; j++)
        {
            LU[j] = -1;
        }

        for (int k = 0; k < 64; k++)
        {
            LU[LT[k]] = (byte)k;
        }

    }
}
