// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            aou

public final class count
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

    public .Object(aou aou1, int i)
    {
        bwd = aou1;
        super();
        bwc = new double[capacity];
        count = 0;
    }
}
