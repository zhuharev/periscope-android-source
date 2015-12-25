// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.IOException;
import o.wm;

// Referenced classes of package com.squareup.okhttp.internal:
//            FaultHidingSink

class  extends FaultHidingSink
{

    final this._cls1 this$1;

    protected void onException(IOException ioexception)
    {
        ioexception = _fld0;
        ioexception;
        JVM INSTR monitorenter ;
        cess._mth1902(this._cls1.this, true);
        ioexception;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    (wm wm)
    {
        this$1 = this._cls1.this;
        super(wm);
    }
}
