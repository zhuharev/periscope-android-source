// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package o:
//            _cls1D45

public abstract class FB5C extends _cls1D45
{

    private int _fld0493;
    private int _fld04AD;
    private LayoutInflater _fld04AE;

    public FB5C(Context context, int i, Cursor cursor, boolean flag)
    {
        super(context, null, true);
        _fld04AD = i;
        _fld0493 = i;
        _fld04AE = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return _fld04AE.inflate(_fld04AD, viewgroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return _fld04AE.inflate(_fld0493, viewgroup, false);
    }
}
