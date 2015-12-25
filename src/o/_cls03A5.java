// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package o:
//            _cls05D4, _cls04AD, _cls03DF, FF9A, 
//            _cls0645, FEAE, _cls04AE

public final class _cls03A5
    implements _cls04AE.if
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    private static final if mO = new if();
    private static final Handler mP = new Handler(Looper.getMainLooper(), new _cls02CA((byte)0));
    private final boolean jy;
    final ExecutorService mH;
    private final ExecutorService mI;
    public final _cls03DF mJ;
    public final FEAE mN;
    public final ArrayList mQ;
    private final if mR;
    private _cls05D4 mS;
    public boolean mT;
    private Exception mU;
    public boolean mV;
    public HashSet mW;
    public _cls04AE mX;
    private _cls04AD mY;
    public volatile Future mZ;
    public boolean mg;

    public _cls03A5(FEAE feae, ExecutorService executorservice, ExecutorService executorservice1, boolean flag, _cls03DF _pcls03df)
    {
        this(feae, executorservice, executorservice1, flag, _pcls03df, mO);
    }

    private _cls03A5(FEAE feae, ExecutorService executorservice, ExecutorService executorservice1, boolean flag, _cls03DF _pcls03df, if if1)
    {
        mQ = new ArrayList();
        mN = feae;
        mH = executorservice;
        mI = executorservice1;
        jy = flag;
        mJ = _pcls03df;
        mR = if1;
    }

    static void _mth02CA(_cls03A5 _pcls03a5)
    {
        if (_pcls03a5.mg)
        {
            _pcls03a5.mS.recycle();
            return;
        }
        if (_pcls03a5.mQ.isEmpty())
        {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        _pcls03a5.mY = new _cls04AD(_pcls03a5.mS, _pcls03a5.jy);
        _pcls03a5.mT = true;
        _pcls03a5.mY.acquire();
        _pcls03a5.mJ._mth02CA(_pcls03a5.mN, _pcls03a5.mY);
        Iterator iterator = _pcls03a5.mQ.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FF9A ff9a = (FF9A)iterator.next();
            boolean flag;
            if (_pcls03a5.mW != null && _pcls03a5.mW.contains(ff9a))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                _pcls03a5.mY.acquire();
                ff9a._mth141D(_pcls03a5.mY);
            }
        } while (true);
        _pcls03a5.mY.release();
    }

    static void _mth02CB(_cls03A5 _pcls03a5)
    {
        if (!_pcls03a5.mg)
        {
            if (_pcls03a5.mQ.isEmpty())
            {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            _pcls03a5.mV = true;
            _pcls03a5.mJ._mth02CA(_pcls03a5.mN, null);
            Iterator iterator = _pcls03a5.mQ.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                FF9A ff9a = (FF9A)iterator.next();
                boolean flag;
                if (_pcls03a5.mW != null && _pcls03a5.mW.contains(ff9a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    ff9a._mth02CA(_pcls03a5.mU);
                }
            } while (true);
        }
    }

    public final void _mth02CA(Exception exception)
    {
        mU = exception;
        mP.obtainMessage(2, this).sendToTarget();
    }

    public final void _mth02CA(_cls04AE _pcls04ae)
    {
        mZ = mI.submit(_pcls04ae);
    }

    public final void _mth02CA(FF9A ff9a)
    {
        _cls0645._mth0631();
        if (mT)
        {
            ff9a._mth141D(mY);
            return;
        }
        if (mV)
        {
            ff9a._mth02CA(mU);
            return;
        } else
        {
            mQ.add(ff9a);
            return;
        }
    }

    public final void _mth141D(_cls05D4 _pcls05d4)
    {
        mS = _pcls05d4;
        mP.obtainMessage(1, this).sendToTarget();
    }

}
