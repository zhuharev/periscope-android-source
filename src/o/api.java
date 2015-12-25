// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package o:
//            apc, aoy, aoz, apg, 
//            ape

public final class api
{

    private apc bxG;
    private int bxn;
    private final ape bxr;
    private final int byG = 128;
    int byH;
    private HashMap byI;
    HashMap byJ;
    aoy byK;
    private final int byL = 15;
    byte byM[];
    int byN;
    int byO;
    private LinkedList byP;

    public api(ape ape)
    {
        byH = 128;
        bxn = 128;
        byI = new HashMap();
        byJ = new HashMap();
        byK = null;
        byM = new byte[15];
        byN = 0;
        byO = 0;
        byP = new LinkedList();
        bxG = new apc();
        bxr = ape;
    }

    public final int dY()
    {
        if (byK != null)
        {
            return byK.dY();
        }
        if (byO == 0)
        {
            return 1;
        }
        if (byN < byO)
        {
            return byO - byN;
        } else
        {
            byO = 0;
            return 1;
        }
    }

    public final void _mth012B(int i)
    {
        bxn = i;
        for (Iterator iterator = byI.values().iterator(); iterator.hasNext();)
        {
            ((aoz)iterator.next()).bxn = i;
        }

    }

    public final void _mth02CE(apg apg1)
    {
        this;
        JVM INSTR monitorenter ;
        apd apd = apg1.byA;
        apg1.byA = null;
        byP.add(apg1);
        bxG._mth02CB(apd);
        this;
        JVM INSTR monitorexit ;
        return;
        apg1;
        throw apg1;
    }

    public final apg _mth0559(int i, int j, int k, int l)
    {
        this;
        JVM INSTR monitorenter ;
        if (byP.size() <= 0) goto _L2; else goto _L1
_L1:
        Object obj = (apg)byP.remove(0);
        apg apg1 = ((apg) (obj));
        obj.byw = j;
        obj.byx = k;
        obj.byy = i;
          goto _L3
_L2:
        apg1 = new apg(i, j, k);
          goto _L3
_L5:
        obj = bxG.FE98(l);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        apg1.byA = ((apd) (obj));
        this;
        JVM INSTR monitorexit ;
        return apg1;
        Thread.sleep(10L);
        if (true) goto _L5; else goto _L4
_L4:
        this;
        JVM INSTR monitorexit ;
        return apg1;
        Exception exception;
        exception;
        throw exception;
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L4; else goto _L3
_L3:
        if (l <= 0) goto _L4; else goto _L5
    }

    public final boolean _mth141D(apg apg1)
    {
        aoz aoz2 = (aoz)byI.get(Integer.valueOf(apg1.byw));
        aoz aoz1 = aoz2;
        if (aoz2 == null)
        {
            aoz1 = new aoz(apg1.byw, bxn);
            byI.put(Integer.valueOf(apg1.byw), aoz1);
        }
        return aoz1._mth02CA(apg1, bxr);
    }

    public final void FEF4(int i)
    {
        byH = i;
        for (Iterator iterator = byJ.values().iterator(); iterator.hasNext();)
        {
            ((aoy)iterator.next()).bwZ = i;
        }

    }
}
