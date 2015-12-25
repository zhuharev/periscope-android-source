// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Set;

// Referenced classes of package o:
//            _cls09AC, _cls142F, _cls1491, _cls14AC

final class _cls10D9
    implements _cls09AC
{

    private static _cls142F sV = new _cls142F();
    private int samplingRate;

    public _cls10D9(int i)
    {
        samplingRate = i;
    }

    public final boolean _mth02CA(_cls1491 _pcls1491)
    {
        boolean flag;
        if (sV.contains(_pcls1491.ta) && _pcls1491.sZ.tz == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean flag1;
        if (Math.abs(_pcls1491.sZ.tw.hashCode() % samplingRate) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag1;
    }

}
