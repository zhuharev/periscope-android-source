// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.TimerTask;

// Referenced classes of package o:
//            aaf, FF6A, apa

final class aag extends TimerTask
{

    private aaf aZS;

    aag(aaf aaf1)
    {
        aZS = aaf1;
        super();
    }

    public final void run()
    {
        aaf aaf1;
        long l;
        aaf1 = aZS;
        l = System.currentTimeMillis();
        boolean flag1 = false;
        aaf1;
        JVM INSTR monitorenter ;
        if (aaf1.aZx <= 0L)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        boolean flag = flag1;
        if (l - aaf1.aZx <= 9000L)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        FF6A._mth02CB("RTMP", "Connect timeout");
        aaf1.aZx = 0L;
        aaf1.aZz = 0L;
        flag = true;
        break MISSING_BLOCK_LABEL_106;
        flag = flag1;
        if (aaf1.aZz <= 0L)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        flag = flag1;
        if (l - aaf1.aZz <= 9000L)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        FF6A._mth02CB("RTMP", "No data timeout");
        flag = true;
        aaf1.aZz = 0L;
        aaf1;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        if (aaf1.P())
        {
            flag = true;
        }
        if (flag)
        {
            aaf1.aZs.shutdown();
            aaf1.reconnect();
        }
        return;
    }
}
