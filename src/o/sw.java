// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            tb

public final class sw extends Enum
{

    private static int SN = 1;
    public static final int SO = 2;
    public static final int SP = 3;
    public static final int SQ = 4;
    private static final int SR[] = {
        1, 2, 3, 4
    };

    static int _mth02CA(tb tb1, Object obj)
    {
        int i;
        if (obj instanceof tb)
        {
            i = ((tb)obj)._mth1FD8();
        } else
        {
            i = 2;
        }
        return i - 1 - (tb1._mth1FD8() - 1);
    }

}
