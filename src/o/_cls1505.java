// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


final class _cls1505
{

    static final int _fld1506[] = new int[0];
    static final Object _fld1D16[] = new Object[0];

    _cls1505()
    {
    }

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static int _mth02BE(int i)
    {
label0:
        {
            int j = i << 2;
            i = 4;
            do
            {
                if (i >= 32)
                {
                    break;
                }
                if (j <= (1 << i) - 12)
                {
                    i = (1 << i) - 12;
                    break label0;
                }
                i++;
            } while (true);
            i = j;
        }
        return i / 4;
    }

    static int _mth02CA(int ai[], int i, int j)
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
