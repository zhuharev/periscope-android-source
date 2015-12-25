// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{

    private int beg;
    private char chars[];
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500principal)
    {
        dn = x500principal.getName("RFC2253");
        length = dn.length();
    }

    private String escapedAV()
    {
        beg = pos;
        end = pos;
        do
        {
            if (pos >= length)
            {
                return new String(chars, beg, end - beg);
            }
            switch (chars[pos])
            {
            case 43: // '+'
            case 44: // ','
            case 59: // ';'
                return new String(chars, beg, end - beg);

            case 92: // '\\'
                char ac[] = chars;
                int i = end;
                end = i + 1;
                ac[i] = getEscaped();
                pos = pos + 1;
                break;

            case 32: // ' '
                cur = end;
                pos = pos + 1;
                char ac1[] = chars;
                int j = end;
                end = j + 1;
                for (ac1[j] = ' '; pos < length && chars[pos] == ' '; pos = pos + 1)
                {
                    char ac2[] = chars;
                    int k = end;
                    end = k + 1;
                    ac2[k] = ' ';
                }

                if (pos == length || chars[pos] == ',' || chars[pos] == '+' || chars[pos] == ';')
                {
                    return new String(chars, beg, cur - beg);
                }
                break;

            default:
                char ac3[] = chars;
                int l = end;
                end = l + 1;
                ac3[l] = chars[pos];
                pos = pos + 1;
                break;
            }
        } while (true);
    }

    private int getByte(int i)
    {
        if (i + 1 >= length)
        {
            throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(dn).toString());
        }
        int j = chars[i];
        if (j >= 48 && j <= 57)
        {
            j -= 48;
        } else
        if (j >= 97 && j <= 102)
        {
            j -= 87;
        } else
        if (j >= 65 && j <= 70)
        {
            j -= 55;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(dn).toString());
        }
        i = chars[i + 1];
        if (i >= 48 && i <= 57)
        {
            i -= 48;
        } else
        if (i >= 97 && i <= 102)
        {
            i -= 87;
        } else
        if (i >= 65 && i <= 70)
        {
            i -= 55;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(dn).toString());
        }
        return (j << 4) + i;
    }

    private char getEscaped()
    {
        pos = pos + 1;
        if (pos == length)
        {
            throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
        }
        switch (chars[pos])
        {
        case 32: // ' '
        case 34: // '"'
        case 35: // '#'
        case 37: // '%'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 92: // '\\'
        case 95: // '_'
            return chars[pos];
        }
        return getUTF8();
    }

    private char getUTF8()
    {
        int i = getByte(pos);
        pos = pos + 1;
        if (i < 128)
        {
            return (char)i;
        }
        if (i >= 192 && i <= 247)
        {
            byte byte0;
            if (i <= 223)
            {
                byte0 = 1;
                i &= 0x1f;
            } else
            if (i <= 239)
            {
                byte0 = 2;
                i &= 0xf;
            } else
            {
                byte0 = 3;
                i &= 7;
            }
            for (int j = 0; j < byte0; j++)
            {
                pos = pos + 1;
                if (pos == length || chars[pos] != '\\')
                {
                    return '?';
                }
                pos = pos + 1;
                int k = getByte(pos);
                pos = pos + 1;
                if ((k & 0xc0) != 128)
                {
                    return '?';
                }
                i = (i << 6) + (k & 0x3f);
            }

            return (char)i;
        } else
        {
            return '?';
        }
    }

    private String hexAV()
    {
        if (pos + 4 >= length)
        {
            throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
        }
        beg = pos;
        pos = pos + 1;
        do
        {
            if (pos == length || chars[pos] == '+' || chars[pos] == ',' || chars[pos] == ';')
            {
                end = pos;
                break;
            }
            if (chars[pos] == ' ')
            {
                end = pos;
                for (pos = pos + 1; pos < length && chars[pos] == ' '; pos = pos + 1) { }
                break;
            }
            if (chars[pos] >= 'A' && chars[pos] <= 'F')
            {
                char ac[] = chars;
                int i = pos;
                ac[i] = (char)(ac[i] + 32);
            }
            pos = pos + 1;
        } while (true);
        int l = end - beg;
        if (l < 5 || (l & 1) == 0)
        {
            throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
        }
        byte abyte0[] = new byte[l / 2];
        int j = 0;
        int k = beg + 1;
        for (; j < abyte0.length; j++)
        {
            abyte0[j] = (byte)getByte(k);
            k += 2;
        }

        return new String(chars, beg, l);
    }

    private String nextAT()
    {
        for (; pos < length && chars[pos] == ' '; pos = pos + 1) { }
        if (pos == length)
        {
            return null;
        }
        beg = pos;
        for (pos = pos + 1; pos < length && chars[pos] != '=' && chars[pos] != ' '; pos = pos + 1) { }
        if (pos >= length)
        {
            throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
        }
        end = pos;
        if (chars[pos] == ' ')
        {
            for (; pos < length && chars[pos] != '=' && chars[pos] == ' '; pos = pos + 1) { }
            if (chars[pos] != '=' || pos == length)
            {
                throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
            }
        }
        do
        {
            pos = pos + 1;
        } while (pos < length && chars[pos] == ' ');
        if (end - beg > 4 && chars[beg + 3] == '.' && (chars[beg] == 'O' || chars[beg] == 'o') && (chars[beg + 1] == 'I' || chars[beg + 1] == 'i') && (chars[beg + 2] == 'D' || chars[beg + 2] == 'd'))
        {
            beg = beg + 4;
        }
        return new String(chars, beg, end - beg);
    }

    private String quotedAV()
    {
        pos = pos + 1;
        beg = pos;
        end = beg;
        do
        {
            if (pos == length)
            {
                throw new IllegalStateException((new StringBuilder("Unexpected end of DN: ")).append(dn).toString());
            }
            if (chars[pos] == '"')
            {
                pos = pos + 1;
                break;
            }
            if (chars[pos] == '\\')
            {
                chars[end] = getEscaped();
            } else
            {
                chars[end] = chars[pos];
            }
            pos = pos + 1;
            end = end + 1;
        } while (true);
        for (; pos < length && chars[pos] == ' '; pos = pos + 1) { }
        return new String(chars, beg, end - beg);
    }

    public final String findMostSpecific(String s)
    {
        pos = 0;
        beg = 0;
        end = 0;
        cur = 0;
        chars = dn.toCharArray();
        String s1 = nextAT();
        String s3 = s1;
        if (s1 == null)
        {
            return null;
        }
        do
        {
            String s2 = "";
            if (pos == length)
            {
                return null;
            }
            switch (chars[pos])
            {
            case 34: // '"'
                s2 = quotedAV();
                break;

            case 35: // '#'
                s2 = hexAV();
                break;

            default:
                s2 = escapedAV();
                break;

            case 43: // '+'
            case 44: // ','
            case 59: // ';'
                break;
            }
            if (s.equalsIgnoreCase(s3))
            {
                return s2;
            }
            if (pos >= length)
            {
                return null;
            }
            if (chars[pos] != ',' && chars[pos] != ';' && chars[pos] != '+')
            {
                throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(dn).toString());
            }
            pos = pos + 1;
            s3 = nextAT();
        } while (s3 != null);
        throw new IllegalStateException((new StringBuilder("Malformed DN: ")).append(dn).toString());
    }
}
