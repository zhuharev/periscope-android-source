// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.animation.ValueAnimator;
import android.os.Handler;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

// Referenced classes of package o:
//            ahk, atu

final class .Object
{

    final int blI = 4;
    final TreeMap blJ = new TreeMap(new A());
    final LinkedList blK = new LinkedList();
    final ahk blL;

    final void _mth02CA(atu atu)
    {
        atu = (.Runnable)blJ.remove(atu);
        if (atu != null)
        {
            blL.mHandler.removeCallbacks(atu);
            if (((.Runnable) (atu)).bme != null)
            {
                ((bme) (atu)).bme.cancel();
            }
            atu.bme = null;
            atu.bmc = null;
            atu.bmd = null;
        }
    }

    .Comparator(ahk ahk1, int i)
    {
        blL = ahk1;
        super();
    }
}
