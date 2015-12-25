// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Vector;

// Referenced classes of package o:
//            pd, pe, aul, pb

public final class pc
{

    private static int count = 0;
    private Vector ND;
    private pd NE;

    public pc()
    {
        ND = new Vector();
        NE = new pd(this, 1);
    }

    public final int _mth02CA(String s, of.if if1)
    {
        if1 = new pe(s, if1);
        s = (new StringBuilder()).append(s).append("-");
        int i = count + 1;
        count = i;
        if1.NH = new Thread(if1, s.append(i).toString());
        ND.add(if1);
        aul._mth02BF("PubNub", (new StringBuilder("Starting new worker ")).append(((pe) (if1)).NH.getName()).toString());
        ((pe) (if1)).NH.start();
        return if1.hashCode();
    }

    public final void _mth1540(int i, int j)
    {
        Vector vector = ND;
        vector;
        JVM INSTR monitorenter ;
        int k = 0;
_L2:
        if (k >= ND.size())
        {
            break; /* Loop/switch isn't completed */
        }
        pe pe1 = (pe)ND.elementAt(k);
        if (pe1.hashCode() == i)
        {
            pe1.NG._mth1D44(j);
            pe1.NH.interrupt();
        }
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth1D5E(int i)
    {
        Vector vector = ND;
        vector;
        JVM INSTR monitorenter ;
        int j = 0;
_L2:
        if (j >= ND.size())
        {
            break; /* Loop/switch isn't completed */
        }
        pe pe1 = (pe)ND.elementAt(j);
        if (pe1.hashCode() == i)
        {
            pe1.NG = NE;
            pe1.FF6F();
            pe1.NH.interrupt();
            ND.remove(pe1);
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
