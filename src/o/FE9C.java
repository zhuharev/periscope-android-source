// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            FEA9, FE8B, FE9B

class FE9C extends FEA9
{

    private boolean _fld099A;
    private int _fld09A6;
    final FE8B _fld09A8;

    FE9C(FE8B fe8b)
    {
        _fld09A8 = fe8b;
        super();
        _fld099A = false;
        _fld09A6 = 0;
    }

    public void _mth02B3(View view)
    {
        int i = _fld09A6 + 1;
        _fld09A6 = i;
        if (i == FE8B._mth02CE(_fld09A8).size())
        {
            if (FE8B._mth02CA(_fld09A8) != null)
            {
                FE8B._mth02CA(_fld09A8)._mth02B3(null);
            }
            FE91();
        }
    }

    void FE91()
    {
        _fld09A6 = 0;
        _fld099A = false;
        FE8B._mth02CB(_fld09A8);
    }

    public void FF70(View view)
    {
        if (_fld099A)
        {
            return;
        }
        _fld099A = true;
        if (FE8B._mth02CA(_fld09A8) != null)
        {
            FE8B._mth02CA(_fld09A8).FF70(null);
        }
    }
}
