// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.spongycastle.util.encoders:
//            Encoder

public class Base64Encoder
    implements Encoder
{

    protected final byte aPw[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    protected byte aPx;
    private byte aPy[];

    public Base64Encoder()
    {
        aPx = 61;
        aPy = new byte[128];
        _mth1E38();
    }

    private int _mth02CE(String s, int i, int j)
    {
        do
        {
            if (i >= j)
            {
                break;
            }
            char c = s.charAt(i);
            if (c == '\n' || c == '\r' || c == '\t' || c == ' ')
            {
                c = '\001';
            } else
            {
                c = '\0';
            }
            if (!c)
            {
                break;
            }
            i++;
        } while (true);
        return i;
    }

    public final int _mth02CA(byte abyte0[], int i, int j, ByteArrayOutputStream bytearrayoutputstream)
    {
        int k = j % 3;
        int l = j - k;
        for (j = i; j < i + l; j += 3)
        {
            int i1 = abyte0[j] & 0xff;
            int j1 = abyte0[j + 1] & 0xff;
            int k1 = abyte0[j + 2] & 0xff;
            bytearrayoutputstream.write(aPw[i1 >>> 2 & 0x3f]);
            bytearrayoutputstream.write(aPw[(i1 << 4 | j1 >>> 4) & 0x3f]);
            bytearrayoutputstream.write(aPw[(j1 << 2 | k1 >>> 6) & 0x3f]);
            bytearrayoutputstream.write(aPw[k1 & 0x3f]);
        }

        switch (k)
        {
        case 1: // '\001'
            i = abyte0[i + l] & 0xff;
            bytearrayoutputstream.write(aPw[i >>> 2 & 0x3f]);
            bytearrayoutputstream.write(aPw[i << 4 & 0x3f]);
            bytearrayoutputstream.write(aPx);
            bytearrayoutputstream.write(aPx);
            break;

        case 2: // '\002'
            j = abyte0[i + l] & 0xff;
            i = abyte0[i + l + 1] & 0xff;
            bytearrayoutputstream.write(aPw[j >>> 2 & 0x3f]);
            bytearrayoutputstream.write(aPw[(j << 4 | i >>> 4) & 0x3f]);
            bytearrayoutputstream.write(aPw[i << 2 & 0x3f]);
            bytearrayoutputstream.write(aPx);
            break;
        }
        j = l / 3;
        if (k == 0)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        return (j << 2) + i;
    }

    public final int _mth02CB(String s, ByteArrayOutputStream bytearrayoutputstream)
    {
        char c2 = '\0';
        int j = s.length();
        do
        {
            if (j <= 0)
            {
                break;
            }
            char c = s.charAt(j - 1);
            if (c == '\n' || c == '\r' || c == '\t' || c == ' ')
            {
                c = '\001';
            } else
            {
                c = '\0';
            }
            if (!c)
            {
                break;
            }
            j--;
        } while (true);
        int l = j - 4;
        int i = 0;
        do
        {
            if (i >= l)
            {
                break;
            }
            char c1 = s.charAt(i);
            if (c1 == '\n' || c1 == '\r' || c1 == '\t' || c1 == ' ')
            {
                c1 = '\001';
            } else
            {
                c1 = '\0';
            }
            if (!c1)
            {
                break;
            }
            i++;
        } while (true);
        int k = c2;
        for (; i < l; i = _mth02CE(s, i + 1, l))
        {
            byte byte0 = aPy[s.charAt(i)];
            i++;
            do
            {
                if (i >= l)
                {
                    break;
                }
                c2 = s.charAt(i);
                if (c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == ' ')
                {
                    c2 = '\001';
                } else
                {
                    c2 = '\0';
                }
                if (!c2)
                {
                    break;
                }
                i++;
            } while (true);
            byte byte1 = aPy[s.charAt(i)];
            i++;
            do
            {
                if (i >= l)
                {
                    break;
                }
                c2 = s.charAt(i);
                if (c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == ' ')
                {
                    c2 = '\001';
                } else
                {
                    c2 = '\0';
                }
                if (!c2)
                {
                    break;
                }
                i++;
            } while (true);
            byte byte2 = aPy[s.charAt(i)];
            i++;
            do
            {
                if (i >= l)
                {
                    break;
                }
                c2 = s.charAt(i);
                if (c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == ' ')
                {
                    c2 = '\001';
                } else
                {
                    c2 = '\0';
                }
                if (!c2)
                {
                    break;
                }
                i++;
            } while (true);
            c2 = aPy[s.charAt(i)];
            if ((byte0 | byte1 | byte2 | c2) < 0)
            {
                throw new IOException("invalid characters encountered in base64 data");
            }
            bytearrayoutputstream.write(byte0 << 2 | byte1 >> 4);
            bytearrayoutputstream.write(byte1 << 4 | byte2 >> 2);
            bytearrayoutputstream.write(byte2 << 6 | c2);
            k += 3;
        }

        l = s.charAt(j - 4);
        c2 = s.charAt(j - 3);
        i = s.charAt(j - 2);
        j = s.charAt(j - 1);
        if (i == aPx)
        {
            i = aPy[l];
            j = aPy[c2];
            if ((i | j) < 0)
            {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            bytearrayoutputstream.write(i << 2 | j >> 4);
            i = 1;
        } else
        if (j == aPx)
        {
            j = aPy[l];
            c2 = aPy[c2];
            i = aPy[i];
            if ((j | c2 | i) < 0)
            {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            bytearrayoutputstream.write(j << 2 | c2 >> 4);
            bytearrayoutputstream.write(c2 << 4 | i >> 2);
            i = 2;
        } else
        {
            l = aPy[l];
            c2 = aPy[c2];
            i = aPy[i];
            j = aPy[j];
            if ((l | c2 | i | j) < 0)
            {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            bytearrayoutputstream.write(l << 2 | c2 >> 4);
            bytearrayoutputstream.write(c2 << 4 | i >> 2);
            bytearrayoutputstream.write(i << 6 | j);
            i = 3;
        }
        return i + k;
    }

    protected final void _mth1E38()
    {
        for (int i = 0; i < 128; i++)
        {
            aPy[i] = -1;
        }

        for (int j = 0; j < 64; j++)
        {
            aPy[aPw[j]] = (byte)j;
        }

    }
}
