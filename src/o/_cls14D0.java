// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

// Referenced classes of package o:
//            _cls141E, _cls019A, FE7D, _cls0E45, 
//            _cls6C35

abstract class _cls14D0 extends _cls141E
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}


    final Context mContext;
    private CharSequence mTitle;
    final Window _fld0422;
    final android.view.Window.Callback FB34;
    final android.view.Window.Callback FB4D;
    final _cls0E45 FB88;
    _cls019A FE93;
    MenuInflater FEE4;
    boolean FEE5;
    boolean FF46;
    boolean FF49;
    boolean FF54;
    boolean FF56;
    private boolean FF6C;

    _cls14D0(Context context, Window window, _cls0E45 _pcls0e45)
    {
        mContext = context;
        _fld0422 = window;
        FB88 = _pcls0e45;
        FB34 = _fld0422.getCallback();
        if (FB34 instanceof _cls02CA)
        {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        } else
        {
            FB4D = _mth02CA(FB34);
            _fld0422.setCallback(FB4D);
            return;
        }
    }

    abstract boolean dispatchKeyEvent(KeyEvent keyevent);

    public final _cls141F.if getDrawerToggleDelegate$5c882a3d()
    {
        return new if(null);
    }

    public MenuInflater getMenuInflater()
    {
        if (FEE4 == null)
        {
            FE7E();
            Context context;
            if (FE93 != null)
            {
                context = FE93.getThemedContext();
            } else
            {
                context = mContext;
            }
            FEE4 = new FE7D(context);
        }
        return FEE4;
    }

    public _cls019A getSupportActionBar()
    {
        FE7E();
        return FE93;
    }

    final CharSequence getTitle()
    {
        if (FB34 instanceof Activity)
        {
            return ((Activity)FB34).getTitle();
        } else
        {
            return mTitle;
        }
    }

    final boolean isDestroyed()
    {
        return FF6C;
    }

    public final void onDestroy()
    {
        FF6C = true;
    }

    abstract boolean onKeyShortcut(int i, KeyEvent keyevent);

    abstract boolean onMenuOpened(int i, Menu menu);

    abstract void onPanelClosed(int i, Menu menu);

    public final void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        _mth02BD(charsequence);
    }

    final _cls019A _mth0269()
    {
        return FE93;
    }

    final Context _mth02B5()
    {
        Context context = null;
        Object obj = getSupportActionBar();
        if (obj != null)
        {
            context = ((_cls019A) (obj)).getThemedContext();
        }
        obj = context;
        if (context == null)
        {
            obj = mContext;
        }
        return ((Context) (obj));
    }

    public boolean _mth02B8()
    {
        return false;
    }

    abstract void _mth02BD(CharSequence charsequence);

    final android.view.Window.Callback _mth02C0()
    {
        return _fld0422.getCallback();
    }

    android.view.Window.Callback _mth02CA(android.view.Window.Callback callback)
    {
        return new _cls02CA(callback);
    }

    abstract _cls6C35 _mth02CA(_cls6C35.if if1);

    abstract void FE7E();
}
