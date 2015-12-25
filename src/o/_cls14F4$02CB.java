// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;

// Referenced classes of package o:
//            _cls0694, _cls14F4, _cls0715

class ent.Context extends _cls0694
{

    final _cls14F4 _fld04BA;

    private boolean _mth1FBE(int i, int j)
    {
        return i < -5 || j < -5 || i > getWidth() + 5 || j > getHeight() + 5;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return _fld04BA.dispatchKeyEvent(keyevent) || super.dispatchKeyEvent(keyevent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && _mth1FBE((int)motionevent.getX(), (int)motionevent.getY()))
        {
            _cls14F4._mth02CF(_fld04BA, 0);
            return true;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public void setBackgroundResource(int i)
    {
        setBackgroundDrawable(_cls0715._mth02CB(getContext(), i));
    }

    public ent.Context(_cls14F4 _pcls14f4, Context context)
    {
        _fld04BA = _pcls14f4;
        super(context);
    }
}
