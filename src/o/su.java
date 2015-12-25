// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package o:
//            st

public final class su extends PriorityBlockingQueue
{

    private LinkedList SL;
    private final ReentrantLock SM = new ReentrantLock();

    public su()
    {
        SL = new LinkedList();
    }

    private st _mth02CA(int i, Long long1, TimeUnit timeunit)
    {
        switch (i)
        {
        case 0: // '\0'
            return (st)super.take();

        case 1: // '\001'
            return (st)super.peek();

        case 2: // '\002'
            return (st)super.poll();

        case 3: // '\003'
            return (st)super.poll(long1.longValue(), timeunit);
        }
        return null;
    }

    private boolean _mth02CA(int i, st st1)
    {
        SM.lock();
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        super.remove(st1);
        boolean flag = SL.offer(st1);
        SM.unlock();
        return flag;
        st1;
        SM.unlock();
        throw st1;
    }

    private static Object[] _mth02CA(Object aobj[], Object aobj1[])
    {
        int i = aobj.length;
        int j = aobj1.length;
        Object aobj2[] = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i + j);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 0, i);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), i, j);
        return aobj2;
    }

    private st _mth02CB(int i, Long long1, TimeUnit timeunit)
    {
        do
        {
            st st1 = _mth02CA(i, long1, timeunit);
            if (st1 != null && !st1._mth14DA())
            {
                _mth02CA(i, st1);
            } else
            {
                return st1;
            }
        } while (true);
    }

    private st _mth14FA()
    {
        InterruptedException interruptedexception;
        st st1;
        try
        {
            st1 = _mth02CB(1, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return st1;
    }

    private st _mth14FB()
    {
        InterruptedException interruptedexception;
        st st1;
        try
        {
            st1 = _mth02CB(2, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        return st1;
    }

    public final void clear()
    {
        SM.lock();
        SL.clear();
        super.clear();
        SM.unlock();
        return;
        Exception exception;
        exception;
        SM.unlock();
        throw exception;
    }

    public final boolean contains(Object obj)
    {
        boolean flag;
        SM.lock();
        if (super.contains(obj))
        {
            break MISSING_BLOCK_LABEL_30;
        }
        flag = SL.contains(obj);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag = true;
        break MISSING_BLOCK_LABEL_37;
        flag = false;
        SM.unlock();
        return flag;
        obj;
        SM.unlock();
        throw obj;
    }

    public final int drainTo(Collection collection)
    {
        int i;
        int j;
        SM.lock();
        i = super.drainTo(collection);
        j = SL.size();
        for (; !SL.isEmpty(); collection.add(SL.poll())) { }
        SM.unlock();
        return i + j;
        collection;
        SM.unlock();
        throw collection;
    }

    public final int drainTo(Collection collection, int i)
    {
        int j;
        SM.lock();
        j = super.drainTo(collection, i);
_L2:
        if (SL.isEmpty() || j > i)
        {
            break; /* Loop/switch isn't completed */
        }
        collection.add(SL.poll());
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        SM.unlock();
        return j;
        collection;
        SM.unlock();
        throw collection;
    }

    public final Object peek()
    {
        return _mth14FA();
    }

    public final Object poll()
    {
        return _mth14FB();
    }

    public final Object poll(long l, TimeUnit timeunit)
    {
        return _mth02CB(3, Long.valueOf(l), timeunit);
    }

    public final boolean remove(Object obj)
    {
        boolean flag;
        SM.lock();
        if (super.remove(obj))
        {
            break MISSING_BLOCK_LABEL_30;
        }
        flag = SL.remove(obj);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag = true;
        break MISSING_BLOCK_LABEL_37;
        flag = false;
        SM.unlock();
        return flag;
        obj;
        SM.unlock();
        throw obj;
    }

    public final boolean removeAll(Collection collection)
    {
        boolean flag;
        boolean flag1;
        SM.lock();
        flag = super.removeAll(collection);
        flag1 = SL.removeAll(collection);
        SM.unlock();
        return flag | flag1;
        collection;
        SM.unlock();
        throw collection;
    }

    public final int size()
    {
        int i;
        int j;
        SM.lock();
        i = SL.size();
        j = super.size();
        SM.unlock();
        return i + j;
        Exception exception;
        exception;
        SM.unlock();
        throw exception;
    }

    public final Object take()
    {
        return _mth02CB(0, null, null);
    }

    public final Object[] toArray()
    {
        Object aobj[];
        SM.lock();
        aobj = _mth02CA(super.toArray(), SL.toArray());
        SM.unlock();
        return aobj;
        Exception exception;
        exception;
        SM.unlock();
        throw exception;
    }

    public final Object[] toArray(Object aobj[])
    {
        SM.lock();
        aobj = _mth02CA(super.toArray(aobj), SL.toArray(aobj));
        SM.unlock();
        return aobj;
        aobj;
        SM.unlock();
        throw aobj;
    }

    public final void _mth14FE()
    {
        SM.lock();
        Iterator iterator = SL.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            st st1 = (st)iterator.next();
            if (st1._mth14DA())
            {
                super.offer(st1);
                iterator.remove();
            }
        } while (true);
        SM.unlock();
        return;
        Exception exception;
        exception;
        SM.unlock();
        throw exception;
    }
}
