// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

// Referenced classes of package o:
//            _cls0E45, _cls141E, _cls1541, _cls6C35

public class _cls1E37 extends Dialog
    implements _cls0E45
{

    private _cls141E mDelegate;

    public _cls1E37(Context context, int i)
    {
        super(context, _mth02CF(context, i));
        getDelegate().onCreate(null);
    }

    private static int _mth02CF(Context context, int i)
    {
        int j = i;
        if (i == 0)
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().resolveAttribute(_cls1541.dialogTheme, typedvalue, true);
            j = typedvalue.resourceId;
        }
        return j;
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().addContentView(view, layoutparams);
    }

    public _cls141E getDelegate()
    {
        if (mDelegate == null)
        {
            mDelegate = _cls141E._mth02CA(this, this);
        }
        return mDelegate;
    }

    public void invalidateOptionsMenu()
    {
        getDelegate().invalidateOptionsMenu();
    }

    protected void onCreate(Bundle bundle)
    {
        getDelegate().FE78();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    protected void onStop()
    {
        super.onStop();
        getDelegate().onStop();
    }

    public void onSupportActionModeFinished(_cls6C35 _pcls6c35)
    {
    }

    public void onSupportActionModeStarted(_cls6C35 _pcls6c35)
    {
    }

    public _cls6C35 onWindowStartingSupportActionMode(_cls6C35.if if1)
    {
        return null;
    }

    public void setContentView(int i)
    {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view)
    {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().setContentView(view, layoutparams);
    }

    public void setTitle(int i)
    {
        super.setTitle(i);
        getDelegate().setTitle(getContext().getString(i));
    }

    public void setTitle(CharSequence charsequence)
    {
        super.setTitle(charsequence);
        getDelegate().setTitle(charsequence);
    }

    public boolean supportRequestWindowFeature(int i)
    {
        return getDelegate().requestWindowFeature(i);
    }
}
