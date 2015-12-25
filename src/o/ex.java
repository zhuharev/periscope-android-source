// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.RemoteException;

// Referenced classes of package o:
//            _cls091F, gh, fm, fb, 
//            gm

public final class ex
{

    private static boolean Ey = false;

    public static int _mth02C6(Context context)
    {
        o/ex;
        JVM INSTR monitorenter ;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        throw new NullPointerException(String.valueOf("Context is null"));
        boolean flag = Ey;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        o/ex;
        JVM INSTR monitorexit ;
        return 0;
        context = gh._mth02C7(context);
        break MISSING_BLOCK_LABEL_52;
        context;
        int i = ((_cls091F) (context)).errorCode;
        o/ex;
        JVM INSTR monitorexit ;
        return i;
        fb fb1 = context._mth4EA0();
        if (fb1 != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new NullPointerException("null reference");
        _cls141D.if._fld02EE = (fb)fb1;
        context = context._mth51AB();
        if (_cls141D.if._fld06E5 != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        throw new NullPointerException("null reference");
        _cls141D.if._fld06E5 = (gm)context;
        break MISSING_BLOCK_LABEL_127;
        context;
        throw new android.support.v4.app.Fragment.if(context);
        Ey = true;
        o/ex;
        JVM INSTR monitorexit ;
        return 0;
        context;
        throw context;
    }

}
