// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package o:
//            aos, aix

public abstract class aip
{

    final Random bnU = aos.dE();
    private final int bnV;
    private final int bnW;
    private final int bnX;
    private final int bnY;
    private final int bnZ;
    private final int boa;
    private final int mLength;

    public aip(Context context)
    {
        context = context.getResources();
        bnV = context.getDimensionPixelOffset(0x7f090013);
        bnW = context.getDimensionPixelOffset(0x7f09007c);
        bnX = context.getDimensionPixelOffset(0x7f09007b);
        mLength = context.getDimensionPixelOffset(0x7f09007d);
        bnY = context.getDimensionPixelOffset(0x7f09007e);
        bnZ = context.getInteger(0x7f0b0006);
        boa = context.getDimensionPixelOffset(0x7f090014);
    }

    public final Path _mth02CA(AtomicInteger atomicinteger, aix aix1, ViewGroup viewgroup, int i)
    {
        Random random = bnU;
        int l = random.nextInt(bnX);
        int i1 = random.nextInt(bnX);
        int j = viewgroup.getHeight() - bnW - aix1.bov / 4;
        int k = atomicinteger.intValue() * 15 + mLength * i + random.nextInt(bnY);
        i = (int)((float)k / (float)bnZ);
        l = boa + l;
        i1 = boa + i1;
        int j1 = j - k;
        k = j - k / 2;
        atomicinteger = new Path();
        atomicinteger.moveTo(bnV, j);
        atomicinteger.cubicTo(bnV, j - i, l, k + i, l, k);
        atomicinteger.moveTo(l, k);
        atomicinteger.cubicTo(l, k - i, i1, j1 + i, i1, j1);
        return atomicinteger;
    }

    public abstract void _mth02CA(aix aix1, RelativeLayout relativelayout, boolean flag);
}
