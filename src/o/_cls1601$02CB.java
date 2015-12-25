// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package o:
//            _cls1601, _cls1D5E, FB4B, _cls0433

static class .View extends .View
{

    public Object _mth02CA(_cls1601 _pcls1601)
    {
        return FB4B._mth02CA(new _cls1D5E(this, _pcls1601));
    }

    public boolean _mth02CA(Object obj, View view, int i, Bundle bundle)
    {
        return FB4B._mth02CA(obj, view, i, bundle);
    }

    public _cls0433 _mth02CB(Object obj, View view)
    {
        obj = FB4B._mth02CE(obj, view);
        if (obj != null)
        {
            return new _cls0433(obj);
        } else
        {
            return null;
        }
    }

    .View()
    {
    }
}
