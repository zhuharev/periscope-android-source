// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Date;
import java.util.HashMap;

// Referenced classes of package o:
//            aph, FF6A

public final class aou
{
    public final class if
    {

        public double bwc[];
        private aou bwd;
        public final int capacity = 10;
        public int count;

        public final double dM()
        {
            double d = 0.0D;
            for (int i = 0; i < capacity;)
            {
                double d1 = d;
                if (bwc[i] < d)
                {
                    d1 = bwc[i];
                }
                i++;
                d = d1;
            }

            return d;
        }

        public if(int i)
        {
            bwd = aou.this;
            super();
            bwc = new double[capacity];
            count = 0;
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private final int bvA = 640;
    private final double bvB = 24D;
    private final long bvC = 10000L;
    private final int bvD = 46080;
    private final int bvE = 0x10000;
    private final int bvF = 32768;
    public _cls02CA bvG;
    public _cls02CA bvH;
    public aph bvI;
    public aph bvJ;
    public aph bvK;
    public aph bvL;
    public aph bvM;
    public int bvN;
    public aph bvO;
    public if bvP;
    public int bvQ;
    public int bvR;
    public boolean bvS;
    public boolean bvT;
    private boolean bvU;
    private int bvV;
    public int bvW;
    public double bvX;
    public double bvY;
    private Date bvZ;
    private final int bvw = 56320;
    private final int bvx = 40960;
    private final int bvy = 10240;
    private final double bvz = 8D;
    public boolean bwa;
    public boolean bwb;

    public aou()
    {
        bvG = new _cls02CA(5D);
        bvH = new _cls02CA(5D);
        bvI = new aph();
        bvJ = new aph();
        bvK = new aph();
        bvL = new aph();
        bvM = new aph();
        bvN = 0;
        bvO = new aph();
        bvP = new if(10);
        bvQ = 0;
        bvR = 0;
        bvS = true;
        bvT = false;
        bvU = false;
        bvV = 0;
        bvW = 25600;
        bvX = 24D;
        bvY = 0.0D;
        bvZ = null;
        bwa = false;
        bwb = false;
    }

    private void dJ()
    {
        int i;
        if (bvS)
        {
            i = 40960;
        } else
        {
            i = 56320;
        }
        if (bvW > i)
        {
            bvW = i;
        }
        if (bvW < 10240)
        {
            bvW = 10240;
        }
    }

    private void dK()
    {
        if ((!bvS || bvR > 0) && (double)bvW < 15360D)
        {
            bvX = bvW / 640;
            if (bvX < 8D)
            {
                bvX = 8D;
            }
        }
    }

    public final HashMap O()
    {
        HashMap hashmap = new HashMap();
        bvI._mth02CA(hashmap, "UploadRate");
        bvK._mth02CA(hashmap, "VideoIndexRatio");
        bvJ._mth02CA(hashmap, "FrameRate");
        bvL._mth02CA(hashmap, "VideoOutput");
        bvO._mth02CA(hashmap, "BitsPerPixel");
        bvM._mth02CA(hashmap, "AudioOutputRate");
        return hashmap;
    }

    public void dI()
    {
        if (!bvS)
        {
            int k = bvQ;
            int i;
            if (bvT && bvR > 0 && bvR < bvQ)
            {
                if (bvU)
                {
                    bvS = true;
                    i = bvR;
                } else
                {
                    bvU = true;
                    bvV = 0;
                    i = k;
                }
            } else
            {
                i = k;
                if (bvU)
                {
                    int j1 = bvV + 1;
                    bvV = j1;
                    i = k;
                    if (j1 > 2)
                    {
                        bvU = false;
                        i = k;
                    }
                }
            }
            k = (i << 3) / 10;
            _cls02CA _lcls02ca = bvH;
            i = 0;
            if (_lcls02ca.bwf > 0.0D)
            {
                i = (int)((double)_lcls02ca.bwg / _lcls02ca.bwf);
            }
            bvW = ((k - i) * 65) / 100;
            dJ();
            dK();
            return;
        }
        Date date = new Date();
        if (bvZ == null)
        {
            bvZ = date;
            return;
        }
        if (date.getTime() - bvZ.getTime() > 10000L)
        {
            int l = bvR;
            int j = l;
            if (bvQ > 0)
            {
                j = l;
                if (bvQ < bvR)
                {
                    j = bvQ;
                }
            }
            _cls02CA _lcls02ca1 = bvH;
            l = 0;
            if (_lcls02ca1.bwf > 0.0D)
            {
                l = (int)((double)_lcls02ca1.bwg / _lcls02ca1.bwf);
            }
            l = ((j - l) * 5) / 10;
            j = l;
            if (l <= 0)
            {
                j = bvW;
            }
            int k1 = bvW;
            _lcls02ca1 = bvG;
            l = 0;
            if (_lcls02ca1.bwf > 0.0D)
            {
                l = (int)((double)_lcls02ca1.bwg / _lcls02ca1.bwf);
            }
            if (l < (k1 * 7) / 10 && bvX >= 24D)
            {
                FF6A._mth02CB("RTMP", (new StringBuilder("Target/Actual kbits/s ")).append((k1 << 3) / 1024).append("/").append((l << 3) / 1024).toString());
            } else
            if (!bwa && j <= bvW)
            {
                int i1 = j + 10240;
                j = i1;
                if (bvQ > 0)
                {
                    int l1 = (bvQ << 3) / 10;
                    _cls02CA _lcls02ca2 = bvH;
                    j = 0;
                    if (_lcls02ca2.bwf > 0.0D)
                    {
                        j = (int)((double)_lcls02ca2.bwg / _lcls02ca2.bwf);
                    }
                    l1 = ((l1 - j) * 65) / 100;
                    j = i1;
                    if (i1 > l1)
                    {
                        j = l1;
                    }
                }
                bvW = j;
                dJ();
                dK();
            }
            bvZ = date;
            bwa = false;
        }
    }

    public final void dL()
    {
        FF6A._mth02CB("RTMP", (new StringBuilder("Upload rate (kbits/s): ")).append(bvI).toString());
        FF6A._mth02CB("RTMP", (new StringBuilder("FPS: ")).append(bvJ).toString());
        FF6A._mth02CB("RTMP", (new StringBuilder("Encoder ratio: ")).append(bvK).toString());
    }
}
