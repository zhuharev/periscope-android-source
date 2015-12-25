// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class ct
{

    public static final int _fld1506[] = new int[0];
    public static final Object _fld1D16[] = new Object[0];

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static int _mth02CA(int ai[], int i, int j)
    {
        int k = 0;
        for (i--; k <= i;)
        {
            int l = k + i >>> 1;
            int i1 = ai[l];
            if (i1 < j)
            {
                k = l + 1;
            } else
            if (i1 > j)
            {
                i = l - 1;
            } else
            {
                return l;
            }
        }

        return ~k;
    }

}
