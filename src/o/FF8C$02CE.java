// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            FE9B, FF8C

public final class _cls03F9
    implements FE9B
{

    private FF8C gb;
    private boolean _fld03F9;

    public final void _mth02B3(View view)
    {
        if (_fld03F9)
        {
            return;
        } else
        {
            gb._fld03EE = null;
            gb.setVisibility(0);
            return;
        }
    }

    public final void _mth02B4(View view)
    {
        _fld03F9 = true;
    }

    public final void FF70(View view)
    {
        gb.setVisibility(0);
        _fld03F9 = false;
    }

    protected .View(FF8C ff8c)
    {
        gb = ff8c;
        super();
        _fld03F9 = false;
    }
}
