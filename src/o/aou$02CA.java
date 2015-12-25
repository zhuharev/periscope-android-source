// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Vector;

// Referenced classes of package o:
//            aou

public final class ector
{

    private aou bwd;
    private final double bwe = 5D;
    public double bwf;
    public long bwg;
    public Vector bwh;

    public final void _mth02CA(double d, int i)
    {
        bwh.add(new <init>(bwd, d, i));
        bwg = bwg + (long)i;
        do
        {
            if (bwh.size() <= 1)
            {
                break;
            }
            bject bject = (ector.size)bwh.get(0);
            bwf = d - bject.bwi;
            if (bwf < bwe)
            {
                break;
            }
            bwg = bwg - (long)bject.bwj;
            bwh.remove(0);
        } while (true);
    }

    public ector(aou aou1, double d)
    {
        bwd = aou1;
        super();
        bwf = 0.0D;
        bwg = 0L;
        bwh = new Vector();
    }
}
