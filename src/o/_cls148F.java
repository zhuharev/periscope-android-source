// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            _cls14B0

public abstract class _cls148F
{

    private static final Object yo = new Object();
    private static _cls14B0 yp;

    public _cls148F()
    {
    }

    public static _cls148F FE76(Context context)
    {
        Object obj = yo;
        obj;
        JVM INSTR monitorenter ;
        if (yp == null)
        {
            yp = new _cls14B0(context.getApplicationContext());
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        context;
        throw context;
_L1:
        return yp;
    }

    public abstract boolean _mth02CA(String s, _cls1435._cls02CF _pcls02cf, String s1);

    public abstract void _mth02CB(String s, _cls1435._cls02CF _pcls02cf, String s1);

}
