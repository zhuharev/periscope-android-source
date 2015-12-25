// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ExecutorService;

// Referenced classes of package o:
//            _cls1602, _cls14B2, qy

final class _cls14AF extends _cls1602
{

    final ExecutorService executorService;
    private final _cls14B2 tF = new _cls14B2(this);

    public _cls14AF(qy qy1, ExecutorService executorservice)
    {
        executorService = executorservice;
        executorservice = tF;
        if (qy1.Qy != null)
        {
            if (!qy1.Qy._mth02CB(executorservice));
        }
    }
}
