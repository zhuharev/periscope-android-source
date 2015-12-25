// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.api.Status;

// Referenced classes of package o:
//            _cls0E04, _cls09F0, _cls09B9

public class _cls0E1B
    implements _cls0E04
{

    public final Object xm;

    public void _mth02CA(Status status)
    {
        status = ((Status) (xm));
        status;
        JVM INSTR monitorenter ;
    }

    public void _mth02CA(_cls09F0 _pcls09f0)
    {
        Object obj = xm;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (_pcls09f0._mth0390().wC <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        _mth02CA(_pcls09f0._mth0390());
        if (!(_pcls09f0 instanceof _cls09B9));
        obj;
        JVM INSTR monitorexit ;
        return;
        _pcls09f0;
        throw _pcls09f0;
    }
}
