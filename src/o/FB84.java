// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

// Referenced classes of package o:
//            _cls6C35, _cls1D53, _cls05DB

public final class FB84 extends ActionMode
{
    /* member class not found */
    class if {}


    private Context mContext;
    final _cls6C35 FF71;

    public FB84(Context context, _cls6C35 _pcls6c35)
    {
        mContext = context;
        FF71 = _pcls6c35;
    }

    public final void finish()
    {
        FF71.finish();
    }

    public final View getCustomView()
    {
        return FF71.getCustomView();
    }

    public final Menu getMenu()
    {
        Context context = mContext;
        _cls1D53 _lcls1d53 = (_cls1D53)FF71._mth1601();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new _cls05DB(context, _lcls1d53);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public final MenuInflater getMenuInflater()
    {
        return FF71.getMenuInflater();
    }

    public final CharSequence getSubtitle()
    {
        return FF71.getSubtitle();
    }

    public final Object getTag()
    {
        return FF71.FEA3;
    }

    public final CharSequence getTitle()
    {
        return FF71.getTitle();
    }

    public final boolean getTitleOptionalHint()
    {
        return FF71.FEE1;
    }

    public final void invalidate()
    {
        FF71.invalidate();
    }

    public final boolean isTitleOptional()
    {
        return FF71.isTitleOptional();
    }

    public final void setCustomView(View view)
    {
        FF71.setCustomView(view);
    }

    public final void setSubtitle(int i)
    {
        FF71.setSubtitle(i);
    }

    public final void setSubtitle(CharSequence charsequence)
    {
        FF71.setSubtitle(charsequence);
    }

    public final void setTag(Object obj)
    {
        FF71.FEA3 = obj;
    }

    public final void setTitle(int i)
    {
        FF71.setTitle(i);
    }

    public final void setTitle(CharSequence charsequence)
    {
        FF71.setTitle(charsequence);
    }

    public final void setTitleOptionalHint(boolean flag)
    {
        FF71.setTitleOptionalHint(flag);
    }
}
