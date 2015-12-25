// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Looper;

// Referenced classes of package o:
//            _cls05D4, FEAE

public final class _cls04AD
    implements _cls05D4
{
    /* member class not found */
    class if {}


    final boolean jy;
    FEAE mN;
    private final _cls05D4 mS;
    if ng;
    private int nh;
    private boolean ni;

    _cls04AD(_cls05D4 _pcls05d4, boolean flag)
    {
        if (_pcls05d4 == null)
        {
            throw new NullPointerException("Wrapped resource must not be null");
        } else
        {
            mS = _pcls05d4;
            jy = flag;
            return;
        }
    }

    final void acquire()
    {
        if (ni)
        {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        } else
        {
            nh = nh + 1;
            return;
        }
    }

    public final Object get()
    {
        return mS.get();
    }

    public final int getSize()
    {
        return mS.getSize();
    }

    public final void recycle()
    {
        if (nh > 0)
        {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (ni)
        {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else
        {
            ni = true;
            mS.recycle();
            return;
        }
    }

    public final void release()
    {
        if (nh <= 0)
        {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
        int i = nh - 1;
        nh = i;
        if (i == 0)
        {
            ng._mth02CB(mN, this);
        }
    }
}
