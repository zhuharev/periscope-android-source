// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;

// Referenced classes of package o:
//            _cls1F30

public final class FB59 extends ContextWrapper
{

    private LayoutInflater _fld04AE;
    public int FF55;
    private android.content.res.Resources.Theme FF5A;

    public FB59(Context context, int i)
    {
        super(context);
        FF55 = i;
    }

    public FB59(Context context, android.content.res.Resources.Theme theme)
    {
        super(context);
        FF5A = theme;
    }

    private void FB35()
    {
        boolean flag;
        if (FF5A == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            FF5A = getResources().newTheme();
            android.content.res.Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null)
            {
                FF5A.setTo(theme);
            }
        }
        FF5A.applyStyle(FF55, true);
    }

    public final Object getSystemService(String s)
    {
        if ("layout_inflater".equals(s))
        {
            if (_fld04AE == null)
            {
                _fld04AE = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return _fld04AE;
        } else
        {
            return getBaseContext().getSystemService(s);
        }
    }

    public final android.content.res.Resources.Theme getTheme()
    {
        if (FF5A != null)
        {
            return FF5A;
        }
        if (FF55 == 0)
        {
            FF55 = _cls1F30.Theme_AppCompat_Light;
        }
        FB35();
        return FF5A;
    }

    public final void setTheme(int i)
    {
        if (FF55 != i)
        {
            FF55 = i;
            FB35();
        }
    }
}
