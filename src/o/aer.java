// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.OrientationEventListener;

// Referenced classes of package o:
//            aed, xl, aov, FF6A

final class aer extends OrientationEventListener
{

    private aed bhH;

    aer(aed aed1, aed aed2, int i)
    {
        bhH = aed1;
        super(aed2, 2);
    }

    public final void onOrientationChanged(int i)
    {
        if (i != -1 && aed.FF9E(bhH) != null)
        {
            boolean flag;
            if (aed.FF9E(bhH).FB24() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            int j = aed._mth02CA(bhH, i);
            aed._mth02CA(bhH, aed._mth02B9(bhH));
            if (flag)
            {
                aed._mth02CB(bhH, 360 - i);
            } else
            {
                aed._mth02CB(bhH, i);
            }
            double d;
            if (aed._mth0559(bhH) == null)
            {
                d = 0.0D;
            } else
            {
                d = aed._mth0559(bhH).dO();
            }
            double d2 = Math.abs(d - aed._mth02B9(bhH));
            d = d2;
            double d1 = d;
            if (d2 > 180D)
            {
                d1 = Math.abs(d - 360D);
            }
            boolean flag1;
            if (d1 > 15D)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                FF6A._mth02CB("RTMP", (new StringBuilder("Rotation: ")).append(aed._mth02B9(bhH)).append(" front facing ").append(flag).toString());
                i = aed._mth05D9(bhH);
                j = aed.bz()[j];
                if (i == 1 && j == 3)
                {
                    aed._mth02CA(bhH, j);
                } else
                if (i == 3 && j == 1)
                {
                    aed._mth02CA(bhH, j);
                }
            }
            aed._mth02CB(bhH, flag1);
        }
    }
}
