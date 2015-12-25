// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;

// Referenced classes of package o:
//            rp

public abstract class ro
{

    final ro Rf;

    public ro()
    {
        this(null);
    }

    public ro(ro ro1)
    {
        Rf = ro1;
    }

    public Object _mth02CA(Context context, rp rp1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = _mth05E2();
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (Rf != null)
        {
            rp1 = ((rp) (Rf._mth02CA(context, rp1)));
            break MISSING_BLOCK_LABEL_44;
        }
        rp1 = rp1._mth0674(context);
        _mth02CA(context, rp1);
        obj = rp1;
        this;
        JVM INSTR monitorexit ;
        return obj;
        context;
        throw context;
    }

    void _mth02CA(Context context, Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        } else
        {
            _mth144A(obj);
            return;
        }
    }

    protected abstract Object _mth05E2();

    protected abstract void _mth144A(Object obj);
}
