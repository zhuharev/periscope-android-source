// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            iq

public final class io extends iq
    implements Iterable
{

    public final ArrayList GA = new ArrayList();

    public io()
    {
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof io) && ((io)obj).GA.equals(GA);
    }

    public final int hashCode()
    {
        return GA.hashCode();
    }

    public final Iterator iterator()
    {
        return GA.iterator();
    }

    public final Number _mth04AD()
    {
        if (GA.size() == 1)
        {
            return ((iq)GA.get(0))._mth04AD();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final String _mth04AE()
    {
        if (GA.size() == 1)
        {
            return ((iq)GA.get(0))._mth04AE();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final long _mth0507()
    {
        if (GA.size() == 1)
        {
            return ((iq)GA.get(0))._mth0507();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final int _mth05D4()
    {
        if (GA.size() == 1)
        {
            return ((iq)GA.get(0))._mth05D4();
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final boolean _mth0672()
    {
        if (GA.size() == 1)
        {
            return ((iq)GA.get(0))._mth0672();
        } else
        {
            throw new IllegalStateException();
        }
    }
}
