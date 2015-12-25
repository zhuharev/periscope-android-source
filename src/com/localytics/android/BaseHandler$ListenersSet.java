// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.localytics.android:
//            BaseHandler, ReflectionUtils

abstract class this._cls0 extends HashSet
{

    final BaseHandler this$0;

    void callListeners(String s, Class aclass[], Object aobj[])
    {
        this;
        JVM INSTR monitorenter ;
        BaseHandler basehandler = BaseHandler.this;
        basehandler;
        JVM INSTR monitorenter ;
        Iterator iterator;
        BaseHandler.access$002(BaseHandler.this, true);
        iterator = iterator();
_L1:
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = iterator.next();
        try
        {
            ReflectionUtils.tryInvokeInstance(obj, s, aclass, aobj);
        }
        catch (Exception exception) { }
          goto _L1
        BaseHandler.access$002(BaseHandler.this, false);
        basehandler;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    ()
    {
        this$0 = BaseHandler.this;
        super();
    }
}
