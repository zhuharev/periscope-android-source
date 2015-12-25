// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.AsyncTask;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

// Referenced classes of package o:
//            my, mz, nd

final class <init> extends AsyncTask
{

    private my Ko;

    private transient Set _mth02CA(Float afloat[])
    {
        Ko.Kg.readLock().lock();
        afloat = Ko.Kf._mth02CB(afloat[0].floatValue());
        Ko.Kg.readLock().unlock();
        return afloat;
        afloat;
        Ko.Kg.readLock().unlock();
        throw afloat;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return _mth02CA((Float[])aobj);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Set)obj;
        Ko.Kh._mth02CE(((Set) (obj)));
    }

    private (my my1)
    {
        Ko = my1;
        super();
    }

    Task(my my1, byte byte0)
    {
        this(my1);
    }
}
