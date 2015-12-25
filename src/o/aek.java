// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

// Referenced classes of package o:
//            aed, aov, apa, ape, 
//            FF6A, xl, aou, aph

final class aek
    implements Runnable
{

    private aed bhH;

    aek(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        Object obj2;
        long l1;
        long l2;
        long l4;
label0:
        {
            if (aed.FF9E(bhH) == null || bhH.isFinishing())
            {
                return;
            }
            Object obj = aed._mth0559(bhH);
            if (((aov) (obj)).aZs != null)
            {
                obj = ((aov) (obj)).aZs.bxr;
                if (((ape) (obj)).byj != null)
                {
                    l1 = ((ape) (obj)).byj.eg();
                    break label0;
                }
            }
            l1 = 0L;
        }
label1:
        {
            Object obj1 = aed._mth0559(bhH);
            if (((aov) (obj1)).aZs != null)
            {
                obj1 = ((aov) (obj1)).aZs.bxr;
                if (((ape) (obj1)).byj != null)
                {
                    l4 = ((ape) (obj1)).byj.byt;
                    break label1;
                }
            }
            l4 = 0L;
        }
        obj2 = aed._mth0559(bhH);
        if (((aov) (obj2)).aZs == null)
        {
            obj2 = new Date();
        } else
        {
            obj2 = ((aov) (obj2)).aZs.bxr;
            if (((ape) (obj2)).byj != null)
            {
                obj2 = ((ape) (obj2)).byj.byv;
            } else
            {
                obj2 = null;
            }
        }
        if (obj2 == null)
        {
            bhH.bhF.postDelayed(this, 5000L);
            return;
        }
        l2 = System.currentTimeMillis();
        if (l1 == 0L)
        {
            if (aed._mth02B4(bhH) > 0L && l2 - aed._mth02B4(bhH) > 12000L && aed._mth0559(bhH) != null)
            {
                FF6A._mth02CB("RTMP", "Reconnect on zero-send timeout");
                aed._mth02CA(bhH, 0L);
                aed._mth0559(bhH).dV();
            }
        } else
        {
            aed._mth02CA(bhH, l2);
        }
        boolean flag2 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag2;
        if (aed._mth02C6(bhH) <= 0L)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        flag = flag2;
        if (l2 - aed._mth02C6(bhH) <= 3000L)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        FF6A._mth02CB("RTMP", "Restart encoder on video output timeout");
        aed._mth02CB(bhH, 0L);
        flag = true;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj2;
        throw obj2;
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        aed.FF9E(bhH).FB38();
        aov aov1 = aed._mth0559(bhH);
        aov1;
        JVM INSTR monitorenter ;
        aov1.bwA = 0L;
        aov1.bwz = 0L;
        aov1;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_425;
        obj2;
        throw obj2;
        double d = (double)((new Date()).getTime() - ((Date) (obj2)).getTime()) / 1000D;
        long l3 = 0L;
        if (l4 > aed._mth02C7(bhH))
        {
            l3 = l4 - aed._mth02C7(bhH);
        }
        long l6 = l1;
        long l5 = l3;
        if (d > 0.0D)
        {
            l6 = (long)((double)l1 / d);
            l5 = (long)((double)l3 / d);
        }
        obj2 = aed._mth02E1(bhH);
        int i = (int)l6;
        int k = (int)l5;
        int l = ((aou) (obj2)).bvW;
        double d1 = ((aou) (obj2)).bvX;
        Object obj3 = ((aou) (obj2)).bvP;
        d = i;
        int j = ((aou.if) (obj3)).count;
        int i1 = ((aou.if) (obj3)).capacity;
        ((aou.if) (obj3)).bwc[j % i1] = d;
        obj3.count = ((aou.if) (obj3)).count + 1;
        d = ((double)i * 8D) / 1024D;
        ((aou) (obj2)).bvI._mth02CE(d);
        obj3 = ((aou) (obj2)).bvG;
        d = 0.0D;
        if (((aou._cls02CA) (obj3)).bwh.size() > 1)
        {
            d = ((aou._cls02CA) (obj3)).bwf / (double)(((aou._cls02CA) (obj3)).bwh.size() - 1);
        }
        d = 1.0D / d;
        ((aou) (obj2)).bvJ._mth02CE(d);
        obj3 = ((aou) (obj2)).bvG;
        i = 0;
        if (((aou._cls02CA) (obj3)).bwf > 0.0D)
        {
            i = (int)((double)((aou._cls02CA) (obj3)).bwg / ((aou._cls02CA) (obj3)).bwf);
        }
        ((aou) (obj2)).bvL._mth02CE(((double)i * 8D) / 1024D);
        obj3 = ((aou) (obj2)).bvH;
        j = 0;
        if (((aou._cls02CA) (obj3)).bwf > 0.0D)
        {
            j = (int)((double)((aou._cls02CA) (obj3)).bwg / ((aou._cls02CA) (obj3)).bwf);
        }
        ((aou) (obj2)).bvM._mth02CE(((double)j * 8D) / 1024D);
        if (((aou) (obj2)).bvN > 0)
        {
            d = (double)(i << 3) / ((double)((aou) (obj2)).bvN * d);
            ((aou) (obj2)).bvO._mth02CE(d);
        }
        obj2.bvR = (int)((aou) (obj2)).bvP.dM();
        obj2.bvT = true;
        if (k > 0)
        {
            obj2.bvT = false;
            obj2.bwa = true;
            obj2.bwb = true;
        }
        ((aou) (obj2)).dI();
        boolean flag1;
        if (Math.abs(((aou) (obj2)).bvW - l) > 1024 || d1 != ((aou) (obj2)).bvX)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            FF6A._mth02CB("RTMP", (new StringBuilder("Change video rate: ")).append((aed._mth02E1(bhH).bvW << 3) / 1024).toString());
            aed.FF9E(bhH)._mth1D3E(aed._mth02E1(bhH).bvW << 3);
        }
        aed._mth02CE(bhH, l4);
        if (aed._mth02E1(bhH).bwb)
        {
            aed._mth02EE(bhH).put("BadConnection", Integer.valueOf(1));
        }
        aed._mth02CB(bhH, false);
        flag1 = ((int)l6 << 3) / 1024;
        j = ((int)l5 << 3) / 1024;
        k = aed.FF9E(bhH)._mth722B() / 1024;
        obj2 = new DecimalFormat("#.#");
        obj3 = (new StringBuilder("Rate/Sent/Not Sent ")).append(k).append("/").append(flag1).append("/").append(j).append(" kbits/s fps req/actual:").append(((DecimalFormat) (obj2)).format(aed._mth02E1(bhH).bvX)).append("/");
        aou._cls02CA _lcls02ca = aed._mth02E1(bhH).bvG;
        d = 0.0D;
        if (_lcls02ca.bwh.size() > 1)
        {
            d = _lcls02ca.bwf / (double)(_lcls02ca.bwh.size() - 1);
        }
        FF6A._mth02CB("RTMP", ((StringBuilder) (obj3)).append(((DecimalFormat) (obj2)).format(1.0D / d)).toString());
        obj2 = new StringBuilder("Audio kbits/s: ");
        obj3 = aed._mth02E1(bhH).bvH;
        flag1 = false;
        if (((aou._cls02CA) (obj3)).bwf > 0.0D)
        {
            flag1 = (int)((double)((aou._cls02CA) (obj3)).bwg / ((aou._cls02CA) (obj3)).bwf);
        }
        FF6A._mth02CB("RTMP", ((StringBuilder) (obj2)).append((flag1 << 3) / 1024).toString());
        bhH.bhF.postDelayed(this, 5000L);
        return;
    }
}
