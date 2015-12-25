// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            _cls1EF4, ra, vh

final class _cls30A4
    implements ve._cls02CA
{

    private _cls1EF4 uq;

    _cls30A4(_cls1EF4 _pcls1ef4)
    {
        uq = _pcls1ef4;
        super();
    }

    public final Boolean _mth02CB(vh vh1)
    {
        boolean flag1 = true;
        Object obj = uq.getFabric();
        if (((ra) (obj)).QI != null)
        {
            obj = (Activity)((ra) (obj)).QI.get();
        } else
        {
            obj = null;
        }
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (!((Activity) (obj)).isFinishing())
            {
                flag = flag1;
                if (uq._mth1F38())
                {
                    flag = _cls1EF4._mth02CA(uq, ((Activity) (obj)), vh1.vb);
                }
            }
        }
        return Boolean.valueOf(flag);
    }
}
