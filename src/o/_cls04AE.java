// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;

// Referenced classes of package o:
//            _cls1606, _cls026B, _cls0287, _cls0582, 
//            _cls1D08, _cls0481, _cls0507, _cls05D4, 
//            _cls03A5

public final class _cls04AE
    implements Runnable, _cls1606
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private final int jx;
    public volatile boolean mg;
    private final if nj;
    public final _cls026B nk;
    private int nl;

    public _cls04AE(_cls03A5 _pcls03a5, _cls026B _pcls026b, int i)
    {
        nj = _pcls03a5;
        nk = _pcls026b;
        nl = _cls02CA.nm;
        jx = i;
    }

    private _cls05D4 _mth1D3F()
    {
        Object obj = null;
        _cls026B _lcls026b1 = nk;
        _cls05D4 _lcls05d4;
        if (!_lcls026b1.jC.mx)
        {
            _lcls05d4 = null;
            break MISSING_BLOCK_LABEL_134;
        }
        long l;
        l = _cls0582._mth0621();
        _lcls05d4 = _lcls026b1._mth02CE(_lcls026b1.mi);
        if (Log.isLoggable("DecodeJob", 2))
        {
            _lcls026b1._mth02CB("Decoded transformed from cache", l);
        }
        l = _cls0582._mth0621();
        if (_lcls05d4 == null)
        {
            _lcls05d4 = null;
            break MISSING_BLOCK_LABEL_78;
        }
        _lcls05d4 = _lcls026b1.ml._mth02BC(_lcls05d4);
        if (Log.isLoggable("DecodeJob", 2))
        {
            _lcls026b1._mth02CB("Transcoded transformed from cache", l);
        }
        break MISSING_BLOCK_LABEL_134;
        Exception exception;
        exception;
        _lcls05d4 = obj;
        if (Log.isLoggable("EngineRunnable", 3))
        {
            Log.d("EngineRunnable", (new StringBuilder("Exception decoding result from cache: ")).append(exception).toString());
            _lcls05d4 = obj;
        }
        Object obj1 = _lcls05d4;
        if (_lcls05d4 == null)
        {
            _cls026B _lcls026b = nk;
            if (!_lcls026b.jC.mw)
            {
                return null;
            }
            long l1 = _cls0582._mth0621();
            obj1 = _lcls026b.mi;
            if (((_cls0481) (obj1)).nf == null)
            {
                obj1.nf = new _cls0507(((_cls0481) (obj1)).id, ((_cls0481) (obj1)).jt);
            }
            obj1 = _lcls026b._mth02CE(((_cls0481) (obj1)).nf);
            if (Log.isLoggable("DecodeJob", 2))
            {
                _lcls026b._mth02CB("Decoded source from cache", l1);
            }
            obj1 = _lcls026b._mth02CA(((_cls05D4) (obj1)));
        }
        return ((_cls05D4) (obj1));
    }

    public final int getPriority()
    {
        return jx - 1;
    }

    public final void run()
    {
        Object obj2;
        Object obj3;
        if (mg)
        {
            return;
        }
        obj2 = null;
        obj3 = null;
        Object obj;
        Object obj1;
        boolean flag;
        if (nl == _cls02CA.nm)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        try
        {
            obj = _mth1D3F();
            break MISSING_BLOCK_LABEL_56;
        }
        catch (Exception exception)
        {
            obj = exception;
            obj1 = obj3;
            if (Log.isLoggable("EngineRunnable", 2))
            {
                Log.v("EngineRunnable", "Exception decoding", exception);
                obj1 = obj3;
                obj = exception;
            }
        }
          goto _L3
_L2:
        obj = nk;
        obj = ((_cls026B) (obj))._mth02CA(((_cls026B) (obj))._mth1525());
        obj1 = obj;
        obj = obj2;
        break MISSING_BLOCK_LABEL_92;
_L3:
        if (mg)
        {
            if (obj1 != null)
            {
                ((_cls05D4) (obj1)).recycle();
            }
            return;
        }
        if (obj1 == null)
        {
            if (nl == _cls02CA.nm)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                nl = _cls02CA.nn;
                nj._mth02CA(this);
                return;
            } else
            {
                nj._mth02CA(((Exception) (obj)));
                return;
            }
        } else
        {
            nj._mth141D(((_cls05D4) (obj1)));
            return;
        }
    }
}
