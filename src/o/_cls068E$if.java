// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FE9B, _cls068E, _cls1646

public final class _cls03F9
    implements FE9B
{

    private boolean _fld03F9;
    private int _fld0421;
    private _cls068E _fld0423;

    public final void _mth02B3(View view)
    {
        if (_fld03F9)
        {
            return;
        } else
        {
            _fld0423._fld03EE = null;
            _cls068E._mth02CB(_fld0423, _fld0421);
            return;
        }
    }

    public final void _mth02B4(View view)
    {
        _fld03F9 = true;
    }

    public final _cls03F9 _mth02CB(_cls1646 _pcls1646, int i)
    {
        _fld0423._fld03EE = _pcls1646;
        _fld0421 = i;
        return this;
    }

    public final void FF70(View view)
    {
        _cls068E._mth02CA(_fld0423, 0);
        _fld03F9 = false;
    }

    protected ew.View(_cls068E _pcls068e)
    {
        _fld0423 = _pcls068e;
        super();
        _fld03F9 = false;
    }
}
