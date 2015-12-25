// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            _cls0628, _cls1D22, _cls1D08

public final class _cls1D0F
{

    private static final _cls0628 qD = new _cls0628();
    public final HashMap qE = new HashMap();

    public _cls1D0F()
    {
    }

    public final _cls1D08 _mth02CB(Class class1, Class class2)
    {
        if (class1.equals(class2))
        {
            return _cls1D22.FEDF();
        }
        _cls0628 _lcls0628 = qD;
        _lcls0628;
        JVM INSTR monitorenter ;
        Object obj;
        obj = qD;
        obj.sk = class1;
        obj.sl = class2;
        obj = (_cls1D08)qE.get(qD);
        _lcls0628;
        JVM INSTR monitorexit ;
          goto _L1
        class1;
        throw class1;
_L1:
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder("No transcoder registered for ")).append(class1).append(" and ").append(class2).toString());
        } else
        {
            return ((_cls1D08) (obj));
        }
    }

}
