// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package o:
//            _cls010B

final class _cls0283
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private _cls010B hb;

    _cls0283(_cls010B _pcls010b)
    {
        hb = _pcls010b;
        super();
    }

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        _cls010B._mth02CA(hb, i);
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }
}
