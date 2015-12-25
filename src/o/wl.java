// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            wk

final class wl
{

    private static wk VB;
    private static long VD;

    private wl()
    {
    }

    static wk _mth02A1()
    {
        o/wl;
        JVM INSTR monitorenter ;
        wk wk1;
        if (VB == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        wk1 = VB;
        VB = wk1.VB;
        wk1.VB = null;
        VD -= 2048L;
        o/wl;
        JVM INSTR monitorexit ;
        return wk1;
        o/wl;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return new wk();
    }

    static void _mth02CA(wk wk1)
    {
        if (wk1.VB != null || wk1.VC != null)
        {
            throw new IllegalArgumentException();
        }
        if (wk1.Vz)
        {
            return;
        }
        o/wl;
        JVM INSTR monitorenter ;
        long l = VD;
        if (l + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        o/wl;
        JVM INSTR monitorexit ;
        return;
        VD += 2048L;
        wk1.VB = VB;
        wk1.limit = 0;
        wk1.pos = 0;
        VB = wk1;
        o/wl;
        JVM INSTR monitorexit ;
        return;
        wk1;
        throw wk1;
    }
}
