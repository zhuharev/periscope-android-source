// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

// Referenced classes of package o:
//            it, oz, io, iw, 
//            is, nx, ot, or

final class pa
{

    Hashtable NA;
    it NB;

    public pa()
    {
        NA = new Hashtable();
        NB = new it();
    }

    private void _mth02CB(String as[], String s)
    {
        as;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        oz oz1;
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        oz1 = (oz)NA.get(as[i]);
        if (oz1 == null)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        iw iw1;
        io io1;
        if (oz1.connected)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        oz1.connected = true;
        if (oz1.Ny)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        io1 = new io();
        iw1 = new iw(Integer.valueOf(1));
        Object obj;
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw("Subscribe connected");
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw(s);
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj = is.GB;
        io1.GA.add(obj);
        oz1.MI._mth02CA(oz1.name, io1);
        break MISSING_BLOCK_LABEL_324;
        oz1.Ny = true;
        io1 = new io();
        iw1 = new iw(Integer.valueOf(1));
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw("Subscribe reconnected");
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw(s);
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        obj = is.GB;
        io1.GA.add(obj);
        oz1.MI._mth02CB(oz1.name, io1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        s;
        throw s;
    }

    private void _mth02CE(String as[], String s)
    {
        as;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        oz oz1;
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        oz1 = (oz)NA.get(as[i]);
        if (oz1 == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        iw iw1;
        io io1;
        oz1.connected = true;
        if (!oz1.Nz)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        io1 = new io();
        iw1 = new iw(Integer.valueOf(1));
        Object obj;
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw("Subscribe reconnected");
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw(s);
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        obj = is.GB;
        io1.GA.add(obj);
        oz1.MI._mth02CB(oz1.name, io1);
        oz1.Nz = false;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        s;
        throw s;
    }

    private void _mth02CF(String as[], String s)
    {
        as;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        oz oz1;
        if (i >= as.length)
        {
            break; /* Loop/switch isn't completed */
        }
        oz1 = (oz)NA.get(as[i]);
        if (oz1 == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        iw iw1;
        io io1;
        if (!oz1.connected)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        oz1.connected = false;
        io1 = new io();
        iw1 = new iw(Integer.valueOf(0));
        Object obj;
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw("Subscribe unable to connect");
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = is.GB;
        io1.GA.add(obj);
        iw1 = new iw(s);
        obj = iw1;
        if (iw1 != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj = is.GB;
        io1.GA.add(obj);
        oz1.MI._mth02CE(oz1.name, io1);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        s;
        throw s;
    }

    public final void _mth0131(String s)
    {
        _mth02CF(ot._mth141D(NA), s);
    }

    public final void _mth01C3(String s)
    {
        _mth02CE(ot._mth141D(NA), s);
    }

    public final void _mth02CE(or or)
    {
        Hashtable hashtable = NA;
        hashtable;
        JVM INSTR monitorenter ;
        oz oz1;
        for (Enumeration enumeration = NA.elements(); enumeration.hasMoreElements(); oz1.MI._mth02CA(oz1.name, or))
        {
            oz1 = (oz)enumeration.nextElement();
            oz1.Nz = true;
        }

        hashtable;
        JVM INSTR monitorexit ;
        return;
        or;
        throw or;
    }

    public final oz FEEA()
    {
        oz oz1 = null;
        Hashtable hashtable = NA;
        hashtable;
        JVM INSTR monitorenter ;
        if (NA.size() > 0)
        {
            oz1 = (oz)NA.elements().nextElement();
        }
        hashtable;
        JVM INSTR monitorexit ;
        return oz1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void FF9F(String s)
    {
        _mth02CB(ot._mth141D(NA), s);
    }
}
