// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.app.Fragment;
import android.view.View;

// Referenced classes of package o:
//            _cls02CD

public final class con extends _cls02CD
{

    private Fragment _fld1D55;

    public con(Fragment fragment)
    {
        _fld1D55 = fragment;
        super();
    }

    public final View onFindViewById(int i)
    {
        if (_fld1D55.mView == null)
        {
            throw new IllegalStateException("Fragment does not have a view");
        } else
        {
            return _fld1D55.mView.findViewById(i);
        }
    }

    public final boolean onHasView()
    {
        return _fld1D55.mView != null;
    }
}
