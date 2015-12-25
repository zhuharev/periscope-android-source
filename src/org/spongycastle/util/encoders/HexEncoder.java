// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.spongycastle.util.encoders:
//            Encoder

public class HexEncoder
    implements Encoder
{

    private byte aPw[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    private byte aPy[];

    public HexEncoder()
    {
        aPy = new byte[128];
        _mth1E38();
    }

    private void _mth1E38()
    {
        for (int i = 0; i < 128; i++)
        {
            aPy[i] = -1;
        }

        for (int j = 0; j < 16; j++)
        {
            aPy[aPw[j]] = (byte)j;
        }

        aPy[65] = aPy[97];
        aPy[66] = aPy[98];
        aPy[67] = aPy[99];
        aPy[68] = aPy[100];
        aPy[69] = aPy[101];
        aPy[70] = aPy[102];
    }

    public final int _mth02CA(byte abyte0[], int i, int j, ByteArrayOutputStream bytearrayoutputstream)
    {
        for (int k = i; k < i + j; k++)
        {
            int l = abyte0[k] & 0xff;
            bytearrayoutputstream.write(aPw[l >>> 4]);
            bytearrayoutputstream.write(aPw[l & 0xf]);
        }

        return j << 1;
    }

    public final int _mth02CB(String s, ByteArrayOutputStream bytearrayoutputstream)
    {
        int k = 0;
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
        int l;
        for (int i = 0; i < j; i = l)
        {
            do
            {
                if (i >= j)
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
            byte abyte0[] = aPy;
            l = i + 1;
            byte byte0 = abyte0[s.charAt(i)];
            i = l;
            do
            {
                if (i >= j)
                {
                    break;
                }
                l = s.charAt(i);
                if (l == '\n' || l == '\r' || l == '\t' || l == ' ')
                {
                    l = 1;
                } else
                {
                    l = 0;
                }
                if (!l)
                {
                    break;
                }
                i++;
            } while (true);
            abyte0 = aPy;
            l = i + 1;
            i = abyte0[s.charAt(i)];
            if ((byte0 | i) < 0)
            {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bytearrayoutputstream.write(byte0 << 4 | i);
            k++;
        }

        return k;
    }
}
