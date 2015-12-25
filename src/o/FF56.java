// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            _cls0628, FF54, FF6C

public final class FF56
{

    private static final _cls0628 qD = new _cls0628();
    public final HashMap rf = new HashMap();

    public FF56()
    {
    }

    public final FF54 _mth02CE(Class class1, Class class2)
    {
        _cls0628 _lcls0628 = qD;
        _lcls0628;
        JVM INSTR monitorenter ;
        _cls0628 _lcls0628_1 = qD;
        _lcls0628_1.sk = class1;
        _lcls0628_1.sl = class2;
        class1 = (FF54)rf.get(qD);
        _lcls0628;
        JVM INSTR monitorexit ;
          goto _L1
        class1;
        throw class1;
_L1:
        class2 = class1;
        if (class1 == null)
        {
            class2 = FF6C._mth027A();
        }
        return class2;
    }

}
