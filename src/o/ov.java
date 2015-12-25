// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package o:
//            pf, aul, oa

abstract class ov
{
    final class if
        implements Runnable
    {

        private pf Nv;
        private ov Nw;

        public final void run()
        {
            if (Nv != null)
            {
                Nv.FF7C();
            }
        }

        if(pf pf1)
        {
            Nw = ov.this;
            super();
            Nv = pf1;
        }
    }


    private static int Nr = 1;
    private static int count = 0;
    protected volatile int LW;
    protected volatile int LX;
    protected Vector Ns;
    private pf Nt[];
    protected Hashtable Nu;
    private String name;

    public ov(String s, int i, int j)
    {
        Ns = new Vector();
        LX = i;
        LW = j;
        _mth02CB(Nr, s);
    }

    private void _mth02CB(int i, String s)
    {
        int j;
        j = i;
        if (i <= 0)
        {
            j = 1;
        }
        name = s;
        Nu = new Hashtable();
        Nt = new pf[j];
        pf apf[] = Nt;
        apf;
        JVM INSTR monitorenter ;
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        pf pf1 = _mth1F33();
        StringBuilder stringbuilder = (new StringBuilder()).append(s).append("-");
        int k = count + 1;
        count = k;
        pf1.NH = new Thread(pf1, stringbuilder.append(k).toString());
        Nt[i] = pf1;
        aul._mth02BF("PubNub", (new StringBuilder("Starting new worker ")).append(Nt[i].NH.getName()).toString());
        pf1.NH.start();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        s;
        throw s;
    }

    public void _mth02CA(oa oa1)
    {
        aul._mth02BE("PubNub", (new StringBuilder("Queued : ")).append(oa1.getUrl()).toString());
        Vector vector = Ns;
        vector;
        JVM INSTR monitorenter ;
        Ns.addElement(oa1);
        Ns.notifyAll();
        vector;
        JVM INSTR monitorexit ;
        return;
        oa1;
        throw oa1;
    }

    public abstract pf _mth1F33();

    public abstract void _mth1F34();

    public final void _mth1FBE(String s, String s1)
    {
        Nu.put(s, s1);
    }

    public final void FBA3()
    {
        pf apf[] = Nt;
        apf;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if (i >= Nt.length)
        {
            break; /* Loop/switch isn't completed */
        }
        aul._mth02BF("PubNub", (new StringBuilder("Sending DIE to ")).append(Nt[i].NH.getName()).toString());
        Nt[i].FF6F();
        (new Thread(new if(Nt[i]))).start();
        Nt[i].NH.interrupt();
        pf pf1 = _mth1F33();
        StringBuilder stringbuilder = (new StringBuilder()).append(name).append("-");
        int j = count + 1;
        count = j;
        pf1.NH = new Thread(pf1, stringbuilder.append(j).toString());
        Nt[i] = pf1;
        aul._mth02BF("PubNub", (new StringBuilder("Starting new worker ")).append(Nt[i].NH.getName()).toString());
        pf1.NH.start();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void FEB0()
    {
        _mth1F34();
        FBA3();
    }

}
