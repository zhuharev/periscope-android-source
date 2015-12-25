// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package o:
//            FB85, FB83

public final class FB3C
{

    public int delay;
    private int height;
    private int kM;
    private int kN;
    private Integer kZ;
    private int la;
    private Bitmap lb;
    private byte lc[];
    private byte ld[];
    private int le;
    private byte lf[];
    private boolean lg[];
    private int lh;
    private boolean li;
    private boolean lj;
    private boolean lk;
    private int ll;
    private boolean lm;
    private OutputStream out;
    private boolean started;
    private int width;

    public FB3C()
    {
        kZ = null;
        la = -1;
        delay = 0;
        started = false;
        lg = new boolean[256];
        lh = 7;
        kM = -1;
        li = false;
        lj = true;
        lk = false;
        ll = 10;
    }

    private void writeString(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            out.write((byte)s.charAt(i));
        }

    }

    private void _mth0E2F()
    {
        int i = lc.length;
        int k1 = i / 3;
        ld = new byte[k1];
        FB85 fb85 = new FB85(lc, i, ll);
        fb85._mth14EF();
        fb85._mth14F1();
        fb85._mth14ED();
        lf = fb85._mth14D0();
        for (int j = 0; j < lf.length; j += 3)
        {
            byte byte0 = lf[j];
            byte abyte1[] = lf;
            abyte1[j] = abyte1[j + 2];
            lf[j + 2] = byte0;
            lg[j / 3] = false;
        }

        int i1 = 0;
        for (int k = 0; k < k1; k++)
        {
            byte abyte2[] = lc;
            int i3 = i1 + 1;
            int i2 = abyte2[i1];
            abyte2 = lc;
            int k2 = i3 + 1;
            i3 = abyte2[i3];
            abyte2 = lc;
            i1 = k2 + 1;
            i2 = fb85._mth037A(i2 & 0xff, i3 & 0xff, abyte2[k2] & 0xff);
            lg[i2] = true;
            ld[k] = (byte)i2;
        }

        lc = null;
        le = 8;
        lh = 7;
        if (lm)
        {
            int l;
            if (lf == null)
            {
                l = -1;
            } else
            {
                int k3 = Color.red(0);
                int l3 = Color.green(0);
                int i4 = Color.blue(0);
                l = 0;
                int j1 = 0x1000000;
                int j4 = lf.length;
                int l2;
                for (int l1 = 0; l1 < j4; l1 = l2)
                {
                    byte abyte0[] = lf;
                    int j2 = l1 + 1;
                    l1 = k3 - (abyte0[l1] & 0xff);
                    abyte0 = lf;
                    int k4 = j2 + 1;
                    j2 = l3 - (abyte0[j2] & 0xff);
                    l2 = i4 - (lf[k4] & 0xff);
                    int j3 = l1 * l1 + j2 * j2 + l2 * l2;
                    l2 = k4 / 3;
                    j2 = l;
                    l1 = j1;
                    if (lg[l2])
                    {
                        j2 = l;
                        l1 = j1;
                        if (j3 < j1)
                        {
                            l1 = j3;
                            j2 = l2;
                        }
                    }
                    l2 = k4 + 1;
                    l = j2;
                    j1 = l1;
                }

            }
            kN = l;
        }
    }

    private void _mth0E45()
    {
        out.write(lf, 0, lf.length);
        int j = lf.length;
        for (int i = 0; i < 768 - j; i++)
        {
            out.write(0);
        }

    }

    public final boolean _mth02CA(OutputStream outputstream)
    {
        int i;
        boolean flag;
        if (outputstream == null)
        {
            return false;
        }
        flag = true;
        li = false;
        out = outputstream;
        i = 0;
_L2:
        if (i >= "GIF89a".length())
        {
            break; /* Loop/switch isn't completed */
        }
        out.write((byte)"GIF89a".charAt(i));
        i++;
        if (true) goto _L2; else goto _L1
_L4:
        flag = false;
_L1:
        started = flag;
        return flag;
        outputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean _mth02CF(Bitmap bitmap)
    {
        int k;
        int j1;
        int l1;
        int i2;
        int j2;
        boolean flag;
        if (bitmap == null || !started)
        {
            return false;
        }
        double d;
        byte abyte0[];
        OutputStream outputstream;
        int k1;
        int k2;
        try
        {
            if (!lk)
            {
                int i = bitmap.getWidth();
                int l = bitmap.getHeight();
                if (!started || lj)
                {
                    width = i;
                    height = l;
                    if (width <= 0)
                    {
                        width = 320;
                    }
                    if (height <= 0)
                    {
                        height = 240;
                    }
                    lk = true;
                }
            }
            lb = bitmap;
            int j = lb.getWidth();
            int i1 = lb.getHeight();
            if (j != width || i1 != height)
            {
                bitmap = Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
                (new Canvas(bitmap)).drawBitmap(bitmap, 0.0F, 0.0F, null);
                lb = bitmap;
            }
            bitmap = new int[j * i1];
            lb.getPixels(bitmap, 0, j, 0, 0, j, i1);
            lc = new byte[bitmap.length * 3];
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return false;
        }
        k1 = 0;
        lm = false;
        j1 = 0;
        i2 = bitmap.length;
        l1 = 0;
          goto _L1
_L5:
        abyte0 = lc;
        j1 = k1 + 1;
        abyte0[k1] = (byte)j2;
        abyte0 = lc;
        k2 = j1 + 1;
        abyte0[j1] = (byte)(j2 >> 8);
        abyte0 = lc;
        k1 = k2 + 1;
        abyte0[k2] = (byte)(j2 >> 16);
        l1++;
        j1 = k;
          goto _L1
_L3:
        d = (double)(j1 * 100) / (double)i2;
        if (d > 4D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lm = flag;
        if (Log.isLoggable("AnimatedGifEncoder", 3))
        {
            Log.d("AnimatedGifEncoder", (new StringBuilder("got pixels for frame with ")).append(d).append("% transparent pixels").toString());
        }
        _mth0E2F();
        if (lj)
        {
            k = width;
            out.write(k & 0xff);
            out.write(k >> 8 & 0xff);
            k = height;
            out.write(k & 0xff);
            out.write(k >> 8 & 0xff);
            out.write(lh | 0xf0);
            out.write(0);
            out.write(0);
            _mth0E45();
            if (la >= 0)
            {
                out.write(33);
                out.write(255);
                out.write(11);
                writeString("NETSCAPE2.0");
                out.write(3);
                out.write(1);
                k = la;
                out.write(k & 0xff);
                out.write(k >> 8 & 0xff);
                out.write(0);
            }
        }
        out.write(33);
        out.write(249);
        out.write(4);
        if (!lm)
        {
            j1 = 0;
            k = 0;
        } else
        {
            j1 = 1;
            k = 2;
        }
        if (kM >= 0)
        {
            k = kM & 7;
        }
        out.write(k << 2 | 0 | j1);
        k = delay;
        out.write(k & 0xff);
        out.write(k >> 8 & 0xff);
        out.write(kN);
        out.write(0);
        out.write(44);
        out.write(0);
        out.write(0);
        out.write(0);
        out.write(0);
        k = width;
        out.write(k & 0xff);
        out.write(k >> 8 & 0xff);
        k = height;
        out.write(k & 0xff);
        out.write(k >> 8 & 0xff);
        if (lj)
        {
            out.write(0);
            break MISSING_BLOCK_LABEL_858;
        }
        out.write(lh | 0x80);
        if (!lj)
        {
            _mth0E45();
        }
        bitmap = new FB83(width, height, ld, le);
        outputstream = out;
        outputstream.write(((FB83) (bitmap)).lq);
        bitmap.lr = ((FB83) (bitmap)).ln * ((FB83) (bitmap)).lo;
        bitmap.ls = 0;
        bitmap._mth02CA(((FB83) (bitmap)).lq + 1, outputstream);
        outputstream.write(0);
        lj = false;
        return true;
_L1:
        if (l1 >= i2) goto _L3; else goto _L2
_L2:
        j2 = bitmap[l1];
        k = j1;
        if (j2 == 0)
        {
            k = j1 + 1;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final boolean _mth09F3()
    {
        IOException ioexception;
        if (!started)
        {
            return false;
        }
        boolean flag = true;
        started = false;
        try
        {
            out.write(59);
            out.flush();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            flag = false;
        }
        kN = 0;
        out = null;
        lb = null;
        lc = null;
        ld = null;
        lf = null;
        li = false;
        lj = true;
        return flag;
    }
}
