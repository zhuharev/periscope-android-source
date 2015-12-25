// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package o:
//            _cls6C35, _cls02E0, _cls14F0

public final class FB82 extends _cls6C35
    implements _cls02E0.if
{

    private Context mContext;
    private _cls14F0 _fld14D6;
    private _cls02E0 FB30;
    private _cls6C35.if FB8B;
    private WeakReference FE8F;
    private boolean FF6B;
    private boolean FF6E;

    public FB82(Context context, _cls14F0 _pcls14f0, _cls14F4._cls02CA _pcls02ca, boolean flag)
    {
        mContext = context;
        _fld14D6 = _pcls14f0;
        FB8B = _pcls02ca;
        context = new _cls02E0(_pcls14f0.getContext());
        context._fld2137 = 1;
        FB30 = context;
        FB30._mth02CA(this);
        FF6E = flag;
    }

    public final void finish()
    {
        if (FF6B)
        {
            return;
        } else
        {
            FF6B = true;
            _fld14D6.sendAccessibilityEvent(32);
            FB8B._mth02CA(this);
            return;
        }
    }

    public final View getCustomView()
    {
        if (FE8F != null)
        {
            return (View)FE8F.get();
        } else
        {
            return null;
        }
    }

    public final MenuInflater getMenuInflater()
    {
        return new MenuInflater(_fld14D6.getContext());
    }

    public final CharSequence getSubtitle()
    {
        return _fld14D6._fld0578;
    }

    public final CharSequence getTitle()
    {
        return _fld14D6.mTitle;
    }

    public final void invalidate()
    {
        FB8B._mth02CB(this, FB30);
    }

    public final boolean isTitleOptional()
    {
        return _fld14D6._fld067E;
    }

    public final void setCustomView(View view)
    {
        _fld14D6.setCustomView(view);
        if (view != null)
        {
            view = new WeakReference(view);
        } else
        {
            view = null;
        }
        FE8F = view;
    }

    public final void setSubtitle(int i)
    {
        String s = mContext.getString(i);
        _fld14D6.setSubtitle(s);
    }

    public final void setSubtitle(CharSequence charsequence)
    {
        _fld14D6.setSubtitle(charsequence);
    }

    public final void setTitle(int i)
    {
        String s = mContext.getString(i);
        _fld14D6.setTitle(s);
    }

    public final void setTitle(CharSequence charsequence)
    {
        _fld14D6.setTitle(charsequence);
    }

    public final void setTitleOptionalHint(boolean flag)
    {
        super.setTitleOptionalHint(flag);
        _fld14D6.setTitleOptional(flag);
    }

    public final void _mth02CA(_cls02E0 _pcls02e0)
    {
        FB8B._mth02CB(this, FB30);
        _fld14D6.showOverflowMenu();
    }

    public final boolean _mth02CA(_cls02E0 _pcls02e0, MenuItem menuitem)
    {
        return FB8B._mth02CA(this, menuitem);
    }

    public final _cls02E0 _mth1601()
    {
        return FB30;
    }
}
