// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package o:
//            mz, _cls150A, mx

public final class nb
    implements mz
{
    final class if
        implements Runnable
    {

        private nb KA;
        private final int Kz;

        public final void run()
        {
            try
            {
                Thread.sleep((long)(Math.random() * 500D + 500D));
            }
            catch (InterruptedException interruptedexception) { }
            KA._mth157D(Kz);
        }

        public if(int i)
        {
            KA = nb.this;
            super();
            Kz = i;
        }
    }


    private final mz Kw;
    private final _cls150A Kx = new _cls150A(5);
    private final ReentrantReadWriteLock Ky = new ReentrantReadWriteLock();

    public nb(mz mz1)
    {
        Kw = mz1;
    }

    public final void _mth02CA(Collection collection)
    {
        Kw._mth02CA(collection);
        Kx.evictAll();
    }

    public final Set _mth02CB(double d)
    {
        int i = (int)d;
        Set set = _mth157D(i);
        if (Kx._mth02CA(Integer.valueOf(i + 1)) == null)
        {
            (new Thread(new if(i + 1))).start();
        }
        if (Kx._mth02CA(Integer.valueOf(i - 1)) == null)
        {
            (new Thread(new if(i - 1))).start();
        }
        return set;
    }

    public final void _mth02CB(mx mx)
    {
        Kw._mth02CB(mx);
        Kx.evictAll();
    }

    Set _mth157D(int i)
    {
        Ky.readLock().lock();
        Set set1 = (Set)Kx._mth02CA(Integer.valueOf(i));
        Ky.readLock().unlock();
        Set set = set1;
        if (set1 == null)
        {
            Ky.writeLock().lock();
            Set set2 = (Set)Kx._mth02CA(Integer.valueOf(i));
            set = set2;
            if (set2 == null)
            {
                set = Kw._mth02CB(i);
                Kx._mth02CA(Integer.valueOf(i), set);
            }
            Ky.writeLock().unlock();
        }
        return set;
    }

    public final Collection _mth1595()
    {
        return Kw._mth1595();
    }

    public final void _mth1606()
    {
        Kw._mth1606();
        Kx.evictAll();
    }
}
