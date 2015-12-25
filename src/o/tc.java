// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            st, tb, te, sw

public class tc
    implements st, tb, te
{

    private final ArrayList SW = new ArrayList();
    private final AtomicBoolean SX = new AtomicBoolean(false);
    private final AtomicReference SY = new AtomicReference(null);

    public tc()
    {
    }

    public static boolean _mth1540(Object obj)
    {
        st st1;
        te te1;
        try
        {
            st1 = (st)obj;
            te1 = (te)obj;
            obj = (tb)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        return st1 != null && te1 != null && obj != null;
    }

    public int compareTo(Object obj)
    {
        return sw._mth02CA(this, obj);
    }

    public final Collection getDependencies()
    {
        this;
        JVM INSTR monitorenter ;
        Collection collection = Collections.unmodifiableCollection(SW);
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isFinished()
    {
        return SX.get();
    }

    public final void _mth02B2(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        SX.set(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CA(te te1)
    {
        _mth02CB((te)te1);
    }

    public final void _mth02CB(te te1)
    {
        this;
        JVM INSTR monitorenter ;
        SW.add(te1);
        this;
        JVM INSTR monitorexit ;
        return;
        te1;
        throw te1;
    }

    public final void _mth02CE(Throwable throwable)
    {
        SY.set(throwable);
    }

    public final boolean _mth14DA()
    {
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext();)
        {
            if (!((te)iterator.next()).isFinished())
            {
                return false;
            }
        }

        return true;
    }

    public int _mth1FD8()
    {
        return sw.SO;
    }
}
