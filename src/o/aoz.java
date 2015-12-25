// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            apg, apd, FF6A, apa, 
//            ape

public final class aoz
{

    private final int bwY;
    private int bxh;
    private long bxk;
    private long bxl;
    int bxn;
    private int bxo;
    private int bxp;

    public aoz(int i, int j)
    {
        bxk = 0L;
        bxl = 0L;
        bxo = 0;
        bxp = 0;
        bxh = -1;
        bwY = i;
        bxn = j;
    }

    public final boolean _mth02CA(apg apg1, ape ape1)
    {
        if (apg1.byA == null)
        {
            apg1.byA = new apd();
        }
        byte abyte1[] = apg1.byA.buffer;
        int i1 = 0;
        if (apg1.byA == null)
        {
            apg1.byA = new apd();
        }
        int j1;
        for (int l1 = apg1.byA.length; i1 < l1; i1 += j1)
        {
            int i = l1 - i1;
            j1 = i;
            if (i > bxn)
            {
                j1 = bxn;
            }
            byte abyte0[];
            if (i1 == 0)
            {
                byte abyte2[] = new byte[18];
                i = 3;
                if (bxh != apg1.byx)
                {
                    i = 0;
                } else
                if (l1 != bxp || bxo != apg1.byy)
                {
                    i = 1;
                } else
                if (apg1.bxk - bxk != bxl)
                {
                    i = 2;
                }
                int j;
                if (bwY < 64)
                {
                    j = 0 + 1;
                    abyte2[0] = (byte)(i << 6 | bwY);
                } else
                if (bwY < 320)
                {
                    abyte2[0] = (byte)(i << 6);
                    j = 0 + 1 + 1;
                    abyte2[1] = (byte)(bwY - 64);
                } else
                {
                    abyte2[0] = (byte)(i << 6 | 1);
                    int k = bwY - 64;
                    abyte2[1] = (byte)(k >> 8);
                    j = 0 + 1 + 1 + 1;
                    abyte2[2] = (byte)k;
                }
                long l3 = apg1.bxk;
                long l2 = l3;
                if (l3 < bxk)
                {
                    FF6A._mth02CB("RTMP", "Ignore negative time delta");
                    l2 = bxk;
                }
                l3 = l2;
                if (i != 0)
                {
                    l3 = l2 - bxk;
                }
                bxp = l1;
                bxh = apg1.byx;
                bxo = apg1.byy;
                bxk = apg1.bxk;
                bxl = l3;
                boolean flag1 = false;
                int l = j;
                boolean flag = flag1;
                if (i < 3)
                {
                    if (l3 > 0xffffffL)
                    {
                        flag = true;
                        l = j + 1;
                        abyte2[j] = -1;
                        j = l + 1;
                        abyte2[l] = -1;
                        l = j + 1;
                        abyte2[j] = -1;
                    } else
                    {
                        l = j + 1;
                        abyte2[j] = (byte)(int)(l3 >> 16);
                        j = l + 1;
                        abyte2[l] = (byte)(int)(l3 >> 8);
                        l = j + 1;
                        abyte2[j] = (byte)(int)l3;
                        flag = flag1;
                    }
                }
                j = l;
                if (i < 2)
                {
                    j = l + 1;
                    abyte2[l] = (byte)(l1 >> 16);
                    l = j + 1;
                    abyte2[j] = (byte)(l1 >> 8);
                    int k1 = l + 1;
                    abyte2[l] = (byte)l1;
                    j = k1 + 1;
                    abyte2[k1] = (byte)apg1.byy;
                }
                l = j;
                if (i == 0)
                {
                    i = j + 1;
                    abyte2[j] = (byte)bxh;
                    j = i + 1;
                    abyte2[i] = (byte)(bxh >> 8);
                    i = j + 1;
                    abyte2[j] = (byte)(bxh >> 16);
                    l = i + 1;
                    abyte2[i] = bxh >> 24;
                }
                i = l;
                if (flag)
                {
                    apa._mth02BB(l3, abyte2, l);
                    i = l + 4;
                }
                abyte0 = new byte[i + j1];
                System.arraycopy(abyte2, 0, abyte0, 0, i);
                System.arraycopy(abyte1, i1, abyte0, i, j1);
            } else
            {
                byte byte0 = (byte)(bwY | 0xc0);
                abyte0 = new byte[j1 + 1];
                abyte0[0] = byte0;
                System.arraycopy(abyte1, i1, abyte0, 1, j1);
            }
            i = abyte0.length;
            if (ape1.byj != null)
            {
                ape1.byj.send(abyte0, 0, i);
            }
        }

        return false;
    }
}
