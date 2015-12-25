// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import tv.periscope.android.api.ApiRunnable;

// Referenced classes of package o:
//            acf, aui

public final class acg
    implements ServiceConnection
{

    private acf bcT;
    private final HashMap bcU = new HashMap();
    private final int bcV[] = new int[0];

    public acg()
    {
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        componentname = bcV;
        componentname;
        JVM INSTR monitorenter ;
        bcT = ((acf.if)ibinder).bcS;
        Runnable runnable;
        for (ibinder = bcU.values().iterator(); ibinder.hasNext(); bcT.bcQ.execute(runnable))
        {
            runnable = (Runnable)ibinder.next();
        }

        bcU.clear();
        componentname;
        JVM INSTR monitorexit ;
        return;
        ibinder;
        throw ibinder;
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        componentname = bcV;
        componentname;
        JVM INSTR monitorenter ;
        bcT = null;
        componentname;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final String _mth02CA(ApiRunnable apirunnable)
    {
        String s = aui._mth0157(6);
        int ai[] = bcV;
        ai;
        JVM INSTR monitorenter ;
        if (bcT != null)
        {
            bcT.bcQ.execute(apirunnable);
            break MISSING_BLOCK_LABEL_46;
        }
        bcU.put(s, apirunnable);
        ai;
        JVM INSTR monitorexit ;
        return s;
        apirunnable;
        throw apirunnable;
    }
}
