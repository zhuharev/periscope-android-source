// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.database.DataSetObserver;

// Referenced classes of package o:
//            _cls1D51

final class _cls217D extends DataSetObserver
{

    private _cls1D51 l;

    _cls217D(_cls1D51 _pcls1d51)
    {
        l = _pcls1d51;
        super();
    }

    public final void onChanged()
    {
        super.onChanged();
        _cls1D51._mth02CE(l);
    }
}
