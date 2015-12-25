// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package o:
//            _cls03F3

public final class _cls0E46
    implements android.view.View.OnClickListener
{

    private Toolbar iF;

    public _cls0E46(Toolbar toolbar)
    {
        iF = toolbar;
        super();
    }

    public final void onClick(View view)
    {
        view = iF;
        if (((Toolbar) (view)).iC == null)
        {
            view = null;
        } else
        {
            view = ((Toolbar) (view)).iC.iG;
        }
        if (view != null)
        {
            view.collapseActionView();
        }
    }
}
