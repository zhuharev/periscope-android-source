// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package o:
//            nz, oa, ny

abstract class pf
    implements Runnable
{

    Thread NH;
    protected volatile boolean NI;
    private Vector NJ;
    protected ny NK;

    pf(Vector vector, int i, int j, Hashtable hashtable)
    {
        NJ = vector;
        NK = new nz(i, j, hashtable);
    }

    public void run()
    {
_L6:
        Object obj1 = null;
_L2:
        Object obj;
        obj = obj1;
        if (NI)
        {
            break; /* Loop/switch isn't completed */
        }
        Vector vector = NJ;
        vector;
        JVM INSTR monitorenter ;
        if (NJ.size() == 0)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        obj = (oa)NJ.firstElement();
        NJ.removeElementAt(0);
        vector;
        JVM INSTR monitorexit ;
        break; /* Loop/switch isn't completed */
        try
        {
            NJ.wait(1000L);
        }
        catch (InterruptedException interruptedexception) { }
        finally
        {
            vector;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (false) goto _L4; else goto _L3
_L4:
        JVM INSTR monitorexit ;
        throw obj;
_L3:
        if (obj != null && !NI)
        {
            _mth02CB(((oa) (obj)));
        }
        if (NI)
        {
            shutdown();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract void shutdown();

    abstract void _mth02CB(oa oa1);

    final void FF6F()
    {
        NI = true;
    }

    final void FF7C()
    {
        NK.shutdown();
    }
}
