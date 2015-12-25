// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.maps.model.CameraPosition;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package o:
//            mv, ne, nb, na, 
//            nd, er, mz, akv, 
//            gj

public class my
    implements er.if, er._cls02CB, _cls141F.if
{
    final class if extends AsyncTask
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

        private if()
        {
            Ko = my.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    private er JV;
    public final mv Kc;
    public final mv.if Kd;
    public final mv.if Ke;
    public nb Kf;
    public final ReentrantReadWriteLock Kg;
    public nd Kh;
    private CameraPosition Ki;
    private if Kj;
    private final ReentrantReadWriteLock Kk;
    public _cls02CB Kl;
    public _cls141F.if Km;
    public _cls02CA Kn;

    public my(Context context, er er1)
    {
        this(context, er1, new mv(er1));
    }

    private my(Context context, er er1, mv mv1)
    {
        Kg = new ReentrantReadWriteLock();
        Kk = new ReentrantReadWriteLock();
        JV = er1;
        Kc = mv1;
        Ke = new mv.if(mv1);
        Kd = new mv.if(mv1);
        Kh = new ne(context, er1, this);
        Kf = new nb(new na());
        Kj = new if((byte)0);
        Kh._mth1E1F();
    }

    public void _mth02CA(CameraPosition cameraposition)
    {
        if (Kh instanceof er.if)
        {
            ((er.if)Kh)._mth02CA(cameraposition);
        }
        cameraposition = JV._mth0447();
        if (Ki != null && Ki.EL == cameraposition.EL)
        {
            return;
        } else
        {
            Ki = JV._mth0447();
            _mth1D0B();
            return;
        }
    }

    public final void _mth02CA(akv akv)
    {
        Kg.writeLock().lock();
        Kf._mth02CB(akv);
        Kg.writeLock().unlock();
        return;
        akv;
        Kg.writeLock().unlock();
        throw akv;
    }

    public boolean _mth02CA(gj gj)
    {
        return Kc._mth02CA(gj);
    }

    public final void _mth1606()
    {
        Kg.writeLock().lock();
        Kf._mth1606();
        Kg.writeLock().unlock();
        return;
        Exception exception;
        exception;
        Kg.writeLock().unlock();
        throw exception;
    }

    public final void _mth1D0B()
    {
        Kk.writeLock().lock();
        Kj.cancel(true);
        Kj = new if((byte)0);
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            Kj.execute(new Float[] {
                Float.valueOf(JV._mth0447().EL)
            });
            break MISSING_BLOCK_LABEL_106;
        }
        Kj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Float[] {
            Float.valueOf(JV._mth0447().EL)
        });
        Kk.writeLock().unlock();
        return;
        Exception exception;
        exception;
        Kk.writeLock().unlock();
        throw exception;
    }
}
