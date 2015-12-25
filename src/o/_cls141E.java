// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package o:
//            _cls14F1, _cls14EF, _cls14ED, _cls14F4, 
//            _cls0E45, _cls019A, _cls6C35

public abstract class _cls141E
{

    _cls141E()
    {
    }

    public static _cls141E _mth02CA(Activity activity, _cls0E45 _pcls0e45)
    {
        return _mth02CA(((Context) (activity)), activity.getWindow(), _pcls0e45);
    }

    public static _cls141E _mth02CA(Dialog dialog, _cls0E45 _pcls0e45)
    {
        return _mth02CA(dialog.getContext(), dialog.getWindow(), _pcls0e45);
    }

    private static _cls141E _mth02CA(Context context, Window window, _cls0E45 _pcls0e45)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 23)
        {
            return new _cls14F1(context, window, _pcls0e45);
        }
        if (i >= 14)
        {
            return new _cls14EF(context, window, _pcls0e45);
        }
        if (i >= 11)
        {
            return new _cls14ED(context, window, _pcls0e45);
        } else
        {
            return new _cls14F4(context, window, _pcls0e45);
        }
    }

    public abstract void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract _cls141F.if getDrawerToggleDelegate$5c882a3d();

    public abstract MenuInflater getMenuInflater();

    public abstract _cls019A getSupportActionBar();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charsequence);

    public abstract _cls6C35 startSupportActionMode(_cls6C35.if if1);

    public abstract void FE78();
}
