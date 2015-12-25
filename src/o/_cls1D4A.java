// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Canvas;

public class _cls1D4A
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    private static final _cls02CB _fld0696;
    private Object _fld0689;

    public _cls1D4A(Context context)
    {
        _fld0689 = _fld0696._mth02CF(context);
    }

    public boolean draw(Canvas canvas)
    {
        return _fld0696._mth02CA(_fld0689, canvas);
    }

    public void finish()
    {
        _fld0696.finish(_fld0689);
    }

    public boolean isFinished()
    {
        return _fld0696._mth0559(_fld0689);
    }

    public void setSize(int i, int j)
    {
        _fld0696._mth02CA(_fld0689, i, j);
    }

    public boolean _mth02BC(float f)
    {
        return _fld0696._mth02CA(_fld0689, f);
    }

    public boolean _mth02CB(float f, float f1)
    {
        return _fld0696._mth02CA(_fld0689, f, f1);
    }

    public boolean _mth13A5()
    {
        return _fld0696._mth05D9(_fld0689);
    }

    public boolean _mth1D35(int i)
    {
        return _fld0696._mth037A(_fld0689, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            _fld0696 = new _cls02CE();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            _fld0696 = new _cls02CA();
        } else
        {
            _fld0696 = new if();
        }
    }
}
