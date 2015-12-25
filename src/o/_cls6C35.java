// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.MenuInflater;
import android.view.View;

// Referenced classes of package o:
//            _cls02E0

public abstract class _cls6C35
{
    /* member class not found */
    class if {}


    Object FEA3;
    boolean FEE1;

    public _cls6C35()
    {
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public boolean isTitleOptional()
    {
        return false;
    }

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charsequence);

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charsequence);

    public void setTitleOptionalHint(boolean flag)
    {
        FEE1 = flag;
    }

    public abstract _cls02E0 _mth1601();
}
