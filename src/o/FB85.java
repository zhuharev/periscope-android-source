// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.ScriptIntrinsicBlur;

// Referenced classes of package o:
//            aos

public class FB85
{

    private int lK;
    private byte lL[];
    private int lM;
    private int lN;
    private int lO[][];
    private int lP[];
    private int lQ[];
    private int lR[];
    private int lS[];

    public FB85()
    {
    }

    public FB85(byte abyte0[], int i, int j)
    {
        lP = new int[256];
        lQ = new int[256];
        lR = new int[256];
        lS = new int[32];
        lL = abyte0;
        lM = i;
        lN = j;
        lO = new int[256][];
        for (i = 0; i < 256; i++)
        {
            lO[i] = new int[4];
            abyte0 = lO[i];
            j = (i << 12) / 256;
            abyte0[2] = j;
            abyte0[1] = j;
            abyte0[0] = j;
            lR[i] = 256;
            lQ[i] = 0;
        }

    }

    public static Bitmap _mth02CA(Context context, Bitmap bitmap, int i)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("Don't blur on the main thread.");
        } else
        {
            Bitmap bitmap1 = bitmap.copy(bitmap.getConfig(), true);
            context = aos._mth01C3(context);
            bitmap = Allocation.createFromBitmap(context, bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocation = Allocation.createFromBitmap(context, bitmap1);
            context = ScriptIntrinsicBlur.create(context, Element.U8_4(context));
            context.setRadius(i);
            context.setInput(bitmap);
            context.forEach(allocation);
            allocation.copyTo(bitmap1);
            return bitmap1;
        }
    }

    public final int _mth037A(int i, int j, int k)
    {
        int i1 = 1000;
        int j1 = -1;
        int l = lP[j];
        int j2 = l;
        l--;
        do
        {
            if (j2 >= 256 && l < 0)
            {
                break;
            }
            int k1 = j2;
            int i2 = i1;
            int l1 = j1;
            if (j2 < 256)
            {
                int ai[] = lO[j2];
                k1 = ai[1] - j;
                l1 = k1;
                if (k1 >= i1)
                {
                    k1 = 256;
                    i2 = i1;
                    l1 = j1;
                } else
                {
                    j2++;
                    k1 = l1;
                    if (l1 < 0)
                    {
                        k1 = -l1;
                    }
                    int k2 = ai[0] - i;
                    l1 = k2;
                    i2 = l1;
                    if (k2 < 0)
                    {
                        i2 = -l1;
                    }
                    k2 = k1 + i2;
                    k1 = j2;
                    i2 = i1;
                    l1 = j1;
                    if (k2 < i1)
                    {
                        i2 = ai[2] - k;
                        k1 = i2;
                        l1 = k1;
                        if (i2 < 0)
                        {
                            l1 = -k1;
                        }
                        k2 += l1;
                        k1 = j2;
                        i2 = i1;
                        l1 = j1;
                        if (k2 < i1)
                        {
                            i2 = k2;
                            l1 = ai[3];
                            k1 = j2;
                        }
                    }
                }
            }
            j2 = k1;
            i1 = i2;
            j1 = l1;
            if (l >= 0)
            {
                int ai1[] = lO[l];
                j1 = j - ai1[1];
                i1 = j1;
                if (j1 >= i2)
                {
                    l = -1;
                    j2 = k1;
                    i1 = i2;
                    j1 = l1;
                } else
                {
                    int l2 = l - 1;
                    l = i1;
                    if (i1 < 0)
                    {
                        l = -i1;
                    }
                    j2 = ai1[0] - i;
                    i1 = j2;
                    j1 = i1;
                    if (j2 < 0)
                    {
                        j1 = -i1;
                    }
                    int i3 = l + j1;
                    j2 = k1;
                    l = l2;
                    i1 = i2;
                    j1 = l1;
                    if (i3 < i2)
                    {
                        j1 = ai1[2] - k;
                        l = j1;
                        i1 = l;
                        if (j1 < 0)
                        {
                            i1 = -l;
                        }
                        i3 += i1;
                        j2 = k1;
                        l = l2;
                        i1 = i2;
                        j1 = l1;
                        if (i3 < i2)
                        {
                            i1 = i3;
                            j1 = ai1[3];
                            j2 = k1;
                            l = l2;
                        }
                    }
                }
            }
        } while (true);
        return j1;
    }

    public final byte[] _mth14D0()
    {
        byte abyte0[] = new byte[768];
        int ai[] = new int[256];
        for (int i = 0; i < 256; i++)
        {
            ai[lO[i][3]] = i;
        }

        int k = 0;
        for (int j = 0; j < 256; j++)
        {
            int l = ai[j];
            int i1 = k + 1;
            abyte0[k] = (byte)lO[l][0];
            int j1 = i1 + 1;
            abyte0[i1] = (byte)lO[l][1];
            k = j1 + 1;
            abyte0[j1] = (byte)lO[l][2];
        }

        return abyte0;
    }

    public final void _mth14ED()
    {
        int l1 = 0;
        int k1 = 0;
        for (int i = 0; i < 256;)
        {
            int ai[] = lO[i];
            int k2 = i;
            int k = ai[1];
            for (int l = i + 1; l < 256;)
            {
                int ai1[] = lO[l];
                int i2 = k;
                if (ai1[1] < k)
                {
                    k2 = l;
                    i2 = ai1[1];
                }
                l++;
                k = i2;
            }

            int ai2[] = lO[k2];
            if (i != k2)
            {
                int i1 = ai2[0];
                ai2[0] = ai[0];
                ai[0] = i1;
                i1 = ai2[1];
                ai2[1] = ai[1];
                ai[1] = i1;
                i1 = ai2[2];
                ai2[2] = ai[2];
                ai[2] = i1;
                i1 = ai2[3];
                ai2[3] = ai[3];
                ai[3] = i1;
            }
            int j2 = l1;
            int j1 = k1;
            if (k != l1)
            {
                lP[l1] = k1 + i >> 1;
                for (j1 = l1 + 1; j1 < k; j1++)
                {
                    lP[j1] = i;
                }

                j1 = i;
                j2 = k;
            }
            i++;
            l1 = j2;
            k1 = j1;
        }

        lP[l1] = k1 + 255 >> 1;
        for (int j = l1 + 1; j < 256; j++)
        {
            lP[j] = 255;
        }

    }

    public final void _mth14EF()
    {
        byte abyte0[];
        char c;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k6;
        int l6;
        if (lM < 1509)
        {
            lN = 1;
        }
        lK = (lN - 1) / 3 + 30;
        abyte0 = lL;
        i2 = 0;
        k6 = lM;
        l6 = lM / (lN * 3);
        j1 = l6 / 100;
        i1 = 1024;
        l1 = 2048;
        k1 = 32;
        for (int i = 0; i < 32; i++)
        {
            lS[i] = ((1024 - i * i << 8) / 1024) * 1024;
        }

        if (lM < 1509)
        {
            c = '\003';
        } else
        if (lM % 499 != 0)
        {
            c = '\u05D9';
        } else
        if (lM % 491 != 0)
        {
            c = '\u05C1';
        } else
        if (lM % 487 != 0)
        {
            c = '\u05B5';
        } else
        {
            c = '\u05E5';
        }
        j2 = 0;
_L7:
        if (j2 >= l6) goto _L2; else goto _L1
_L1:
        int l;
        int i7;
        int j7;
        int k7;
        i7 = (abyte0[i2] & 0xff) << 4;
        j7 = (abyte0[i2 + 1] & 0xff) << 4;
        k7 = (abyte0[i2 + 2] & 0xff) << 4;
        int i3 = 0x7fffffff;
        int k2 = 0x7fffffff;
        int l3 = -1;
        l = -1;
        for (int j = 0; j < 256;)
        {
            int ai[] = lO[j];
            int j5 = ai[0] - i7;
            int l4 = j5;
            int j4 = l4;
            if (j5 < 0)
            {
                j4 = -l4;
            }
            int l5 = ai[1] - j7;
            j5 = l5;
            l4 = j5;
            if (l5 < 0)
            {
                l4 = -j5;
            }
            int j6 = ai[2] - k7;
            j5 = j6;
            l5 = j5;
            if (j6 < 0)
            {
                l5 = -j5;
            }
            l4 = j4 + l4 + l5;
            j4 = i3;
            if (l4 < i3)
            {
                j4 = l4;
                l3 = j;
            }
            i3 = l4 - (lQ[j] >> 12);
            l4 = k2;
            if (i3 < k2)
            {
                l4 = i3;
                l = j;
            }
            k2 = lR[j] >> 10;
            ai = lR;
            ai[j] = ai[j] - k2;
            ai = lQ;
            ai[j] = ai[j] + (k2 << 10);
            j++;
            i3 = j4;
            k2 = l4;
        }

        int ai1[] = lR;
        ai1[l3] = ai1[l3] + 64;
        ai1 = lQ;
        ai1[l3] = ai1[l3] - 0x10000;
        ai1 = lO[l];
        ai1[0] = ai1[0] - ((ai1[0] - i7) * i1) / 1024;
        ai1[1] = ai1[1] - ((ai1[1] - j7) * i1) / 1024;
        ai1[2] = ai1[2] - ((ai1[2] - k7) * i1) / 1024;
        if (k1 == 0) goto _L4; else goto _L3
_L3:
        int k;
        int l2;
        int j3;
        int i4;
        k = l - k1;
        l2 = k;
        if (k < -1)
        {
            l2 = -1;
        }
        k = l + k1;
        j3 = k;
        if (k > 256)
        {
            j3 = 256;
        }
        i4 = l + 1;
        l--;
        k = 1;
_L5:
        int i5 = l;
        if (i4 >= j3 && i5 <= l2)
        {
            break; /* Loop/switch isn't completed */
        }
        int ai2[] = lS;
        int k5 = k + 1;
        int i6 = ai2[k];
        int k4 = i4;
        if (i4 < j3)
        {
            Object obj = lO;
            k4 = i4 + 1;
            obj = obj[i4];
            int k3;
            try
            {
                obj[0] = obj[0] - ((obj[0] - i7) * i6) / 0x40000;
                obj[1] = obj[1] - ((obj[1] - j7) * i6) / 0x40000;
                obj[2] = obj[2] - ((obj[2] - k7) * i6) / 0x40000;
            }
            catch (Exception exception) { }
        }
        l = i5;
        i4 = k4;
        k = k5;
        if (i5 <= l2)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = lO;
        l = i5 - 1;
        obj = obj[i5];
        obj[0] = obj[0] - ((obj[0] - i7) * i6) / 0x40000;
        obj[1] = obj[1] - ((obj[1] - j7) * i6) / 0x40000;
        obj[2] = obj[2] - ((obj[2] - k7) * i6) / 0x40000;
        i4 = k4;
        k = k5;
        continue; /* Loop/switch isn't completed */
_L10:
        i4 = k4;
        k = k5;
        if (true) goto _L5; else goto _L4
_L4:
        i2 += c;
        l = i2;
        k = l;
        if (i2 >= k6)
        {
            k = l - lM;
        }
        k4 = j2 + 1;
        l2 = j1;
        if (j1 == 0)
        {
            l2 = 1;
        }
        j2 = k4;
        j1 = l2;
        i2 = k;
        if (k4 % l2 != 0) goto _L7; else goto _L6
_L6:
        i5 = i1 - i1 / lK;
        l = l1 - l1 / 30;
        k3 = l;
        i1 = l >> 6;
        l = i1;
        if (i1 <= 1)
        {
            l = 0;
        }
        i4 = 0;
_L9:
        j2 = k4;
        l1 = k3;
        k1 = l;
        i1 = i5;
        j1 = l2;
        i2 = k;
        if (i4 >= l) goto _L7; else goto _L8
_L8:
        lS[i4] = ((l * l - i4 * i4 << 8) / (l * l)) * i5;
        i4++;
          goto _L9
          goto _L7
_L2:
        return;
        Exception exception1;
        exception1;
          goto _L10
    }

    public final void _mth14F1()
    {
        for (int i = 0; i < 256; i++)
        {
            int ai[] = lO[i];
            ai[0] = ai[0] >> 4;
            ai = lO[i];
            ai[1] = ai[1] >> 4;
            ai = lO[i];
            ai[2] = ai[2] >> 4;
            lO[i][3] = i;
        }

    }
}
