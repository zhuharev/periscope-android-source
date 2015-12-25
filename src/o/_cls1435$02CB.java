// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls1435

public abstract class yd
{

    Object wo;
    private _cls1435 yc;
    private boolean yd;

    public final void unregister()
    {
        this;
        JVM INSTR monitorenter ;
        wo = null;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        ArrayList arraylist = yc.xU;
        arraylist;
        JVM INSTR monitorenter ;
        yc.xU.remove(this);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        throw exception1;
    }

    protected abstract void _mth02C7(Object obj);

    public final void _mth0694()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = wo;
        if (yd)
        {
            Log.w("GmsClient", (new StringBuilder("Callback proxy ")).append(this).append(" being reused. This is not safe.").toString());
        }
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        if (obj != null)
        {
            try
            {
                _mth02C7(obj);
            }
            catch (RuntimeException runtimeexception)
            {
                throw runtimeexception;
            }
        }
        this;
        JVM INSTR monitorenter ;
        yd = true;
        this;
        JVM INSTR monitorexit ;
          goto _L2
        Exception exception;
        exception;
        throw exception;
_L2:
        unregister();
        return;
    }

    public olean(_cls1435 _pcls1435, Boolean boolean1)
    {
        yc = _pcls1435;
        super();
        wo = boolean1;
        yd = false;
    }
}
