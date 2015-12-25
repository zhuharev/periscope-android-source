// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.database.DataSetObservable;
import android.support.v4.view.ViewPager;
import android.view.View;

public abstract class FB54
{

    public DataSetObservable _fld1F76;

    public FB54()
    {
        _fld1F76 = new DataSetObservable();
    }

    public abstract int getCount();

    public Object _mth02CA(ViewPager viewpager, int i)
    {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void _mth02CA(ViewPager viewpager, int i, Object obj)
    {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public abstract boolean _mth02CB(View view, Object obj);
}
