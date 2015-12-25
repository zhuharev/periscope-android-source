// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

// Referenced classes of package o:
//            agp, ahd

public final class arb
{
    final class if extends Handler
    {

        private arb bBf;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 1: // '\001'
                arb._mth02CB(bBf).onShowPress(arb._mth02CA(bBf));
                return;

            case 2: // '\002'
                arb._mth02CE(bBf);
                return;

            case 3: // '\003'
                if (arb._mth02CF(bBf) != null)
                {
                    if (!arb._mth141D(bBf))
                    {
                        arb._mth02CF(bBf).onSingleTapConfirmed(arb._mth02CA(bBf));
                        return;
                    } else
                    {
                        arb._mth02CA(bBf, true);
                        return;
                    }
                } else
                {
                    return;
                }
            }
            throw new RuntimeException((new StringBuilder("Unknown message ")).append(message).toString());
        }

        if()
        {
            bBf = arb.this;
            super();
        }
    }


    public static final int _fld019A = ViewConfiguration.getTapTimeout();
    public static final int _fld01CF = ViewConfiguration.getDoubleTapTimeout();
    public int bBd;
    public final if bBe;
    public int _fld0140;
    public int _fld0142;
    public int _fld0157;
    public int _fld017F;
    public final android.view.GestureDetector.OnGestureListener _fld01D0;
    public android.view.GestureDetector.OnDoubleTapListener _fld020A;
    public boolean _fld0285;
    public boolean _fld03AF;
    public boolean _fld05D3;
    public boolean _fld05F1;
    public boolean _fld068C;
    public MotionEvent _fld068D;
    public MotionEvent _fld06C3;
    public boolean _fld09F3;
    public float _fld0E2F;
    public float _fld0E45;
    public float _fld141E;
    public float _fld14D0;
    public boolean _fld14ED;
    public VelocityTracker _fld14EF;

    private arb(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        bBe = new if();
        _fld01D0 = ongesturelistener;
        if (ongesturelistener instanceof android.view.GestureDetector.OnDoubleTapListener)
        {
            _fld020A = (android.view.GestureDetector.OnDoubleTapListener)ongesturelistener;
        }
        if (_fld01D0 == null)
        {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        _fld14ED = true;
        int i;
        int j;
        int k;
        if (context == null)
        {
            i = ViewConfiguration.getTouchSlop();
            j = i;
            k = 100;
            _fld0157 = ViewConfiguration.getMinimumFlingVelocity();
            _fld017F = ViewConfiguration.getMaximumFlingVelocity();
        } else
        {
            context = ViewConfiguration.get(context);
            i = context.getScaledTouchSlop();
            j = i;
            k = context.getScaledDoubleTapSlop();
            _fld0157 = context.getScaledMinimumFlingVelocity();
            _fld017F = context.getScaledMaximumFlingVelocity();
        }
        _fld0140 = j * j;
        bBd = i * i;
        _fld0142 = k * k;
    }

    public arb(agp agp, ahd ahd)
    {
        this(((Context) (agp)), ((android.view.GestureDetector.OnGestureListener) (ahd)), null);
    }

    static MotionEvent _mth02CA(arb arb1)
    {
        return arb1._fld068D;
    }

    static boolean _mth02CA(arb arb1, boolean flag)
    {
        arb1._fld03AF = true;
        return true;
    }

    static android.view.GestureDetector.OnGestureListener _mth02CB(arb arb1)
    {
        return arb1._fld01D0;
    }

    static void _mth02CE(arb arb1)
    {
        arb1.bBe.removeMessages(3);
        arb1._fld03AF = false;
        arb1._fld05D3 = true;
        arb1._fld01D0.onLongPress(arb1._fld068D);
    }

    static android.view.GestureDetector.OnDoubleTapListener _mth02CF(arb arb1)
    {
        return arb1._fld020A;
    }

    static boolean _mth141D(arb arb1)
    {
        return arb1._fld0285;
    }

    static 
    {
        ViewConfiguration.getLongPressTimeout();
    }
}
