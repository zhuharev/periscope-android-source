// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            FE9C, _cls1646, FE9B, FEA9

public class FE8B
{

    private Interpolator mInterpolator;
    private long _fld0710;
    private FE9B _fld072B;
    private boolean _fld091F;
    private final FEA9 _fld0993 = new FE9C(this);
    private final ArrayList _fld0E08 = new ArrayList();

    public FE8B()
    {
        _fld0710 = -1L;
    }

    static FE9B _mth02CA(FE8B fe8b)
    {
        return fe8b._fld072B;
    }

    static void _mth02CB(FE8B fe8b)
    {
        fe8b.FE7C();
    }

    static ArrayList _mth02CE(FE8B fe8b)
    {
        return fe8b._fld0E08;
    }

    private void FE7C()
    {
        _fld091F = false;
    }

    public void cancel()
    {
        if (!_fld091F)
        {
            return;
        }
        for (Iterator iterator = _fld0E08.iterator(); iterator.hasNext(); ((_cls1646)iterator.next()).cancel()) { }
        _fld091F = false;
    }

    public void start()
    {
        if (_fld091F)
        {
            return;
        }
        _cls1646 _lcls1646;
        for (Iterator iterator = _fld0E08.iterator(); iterator.hasNext(); _lcls1646.start())
        {
            _lcls1646 = (_cls1646)iterator.next();
            if (_fld0710 >= 0L)
            {
                _lcls1646._mth02CB(_fld0710);
            }
            if (mInterpolator != null)
            {
                _lcls1646._mth02CA(mInterpolator);
            }
            if (_fld072B != null)
            {
                _lcls1646._mth02CA(_fld0993);
            }
        }

        _fld091F = true;
    }

    public FE8B _mth02CA(_cls1646 _pcls1646, _cls1646 _pcls1646_1)
    {
        _fld0E08.add(_pcls1646);
        _pcls1646_1._mth02CE(_pcls1646.getDuration());
        _fld0E08.add(_pcls1646_1);
        return this;
    }

    public FE8B _mth02CB(Interpolator interpolator)
    {
        if (!_fld091F)
        {
            mInterpolator = interpolator;
        }
        return this;
    }

    public FE8B _mth02CB(FE9B fe9b)
    {
        if (!_fld091F)
        {
            _fld072B = fe9b;
        }
        return this;
    }

    public FE8B _mth02CF(_cls1646 _pcls1646)
    {
        if (!_fld091F)
        {
            _fld0E08.add(_pcls1646);
        }
        return this;
    }

    public FE8B _mth141D(long l)
    {
        if (!_fld091F)
        {
            _fld0710 = l;
        }
        return this;
    }
}
