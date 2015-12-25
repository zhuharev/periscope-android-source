// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls02C9, _cls0E45, _cls141E, _cls02B4, 
//            _cls1D36, _cls019A, _cls1D38, if, 
//            _cls6C35

public class _cls0E2F extends _cls02C9
    implements _cls0E45, _cls1D36.if
{

    private _cls141E mDelegate;

    public _cls0E2F()
    {
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

    public _cls141F.if getDrawerToggleDelegate$5c882a3d()
    {
        return getDelegate().getDrawerToggleDelegate$5c882a3d();
    }

    public MenuInflater getMenuInflater()
    {
        return getDelegate().getMenuInflater();
    }

    public _cls019A getSupportActionBar()
    {
        return getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent()
    {
        return _cls02B4._mth02BB(this);
    }

    public void invalidateOptionsMenu()
    {
        getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
    }

    public void onContentChanged()
    {
        onSupportContentChanged();
    }

    public void onCreate(Bundle bundle)
    {
        getDelegate().FE78();
        getDelegate().onCreate(bundle);
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(_cls1D36 _pcls1d36)
    {
        Intent intent = null;
        if (this instanceof _cls1D36.if)
        {
            intent = ((_cls1D36.if)this).getSupportParentActivityIntent();
        }
        Intent intent1 = intent;
        if (intent == null)
        {
            intent1 = _cls02B4._mth02BB(this);
        }
        if (intent1 != null)
        {
            android.content.ComponentName componentname1 = intent1.getComponent();
            android.content.ComponentName componentname = componentname1;
            if (componentname1 == null)
            {
                componentname = intent1.resolveActivity(_pcls1d36.FB58.getPackageManager());
            }
            _pcls1d36._mth02CA(componentname);
            _pcls1d36._fld217C.add(intent1);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i, menuitem))
        {
            return true;
        }
        _cls019A _lcls019a = getSupportActionBar();
        if (menuitem.getItemId() == 0x102002c && _lcls019a != null && (_lcls019a.getDisplayOptions() & 4) != 0)
        {
            return onSupportNavigateUp();
        } else
        {
            return false;
        }
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu)
    {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(_cls1D36 _pcls1d36)
    {
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

    public void onSupportContentChanged()
    {
    }

    public boolean onSupportNavigateUp()
    {
        IllegalStateException illegalstateexception;
        Object obj = getSupportParentActivityIntent();
        if (obj != null)
        {
            if (supportShouldUpRecreateTask(((Intent) (obj))))
            {
                obj = _cls1D36._mth02CA(this);
                onCreateSupportNavigateUpTaskStack(((_cls1D36) (obj)));
                onPrepareSupportNavigateUpTaskStack(((_cls1D36) (obj)));
                if (((_cls1D36) (obj))._fld217C.isEmpty())
                {
                    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
                }
                Intent aintent[] = (Intent[])((_cls1D36) (obj))._fld217C.toArray(new Intent[((_cls1D36) (obj))._fld217C.size()]);
                aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
                if (!_cls1D38._mth02CA(((_cls1D36) (obj)).FB58, aintent, null))
                {
                    Intent intent = new Intent(aintent[aintent.length - 1]);
                    intent.addFlags(0x10000000);
                    ((_cls1D36) (obj)).FB58.startActivity(intent);
                }
                try
                {
                    o.if._mth02CA(this);
                }
                // Misplaced declaration of an exception variable
                catch (IllegalStateException illegalstateexception)
                {
                    finish();
                }
            } else
            {
                supportNavigateUpTo(((Intent) (obj)));
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        getDelegate().setTitle(charsequence);
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

    public void setSupportActionBar(Toolbar toolbar)
    {
        getDelegate().setSupportActionBar(toolbar);
    }

    public void setSupportProgress(int i)
    {
    }

    public void setSupportProgressBarIndeterminate(boolean flag)
    {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean flag)
    {
    }

    public void setSupportProgressBarVisibility(boolean flag)
    {
    }

    public _cls6C35 startSupportActionMode(_cls6C35.if if1)
    {
        return getDelegate().startSupportActionMode(if1);
    }

    public void supportInvalidateOptionsMenu()
    {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent)
    {
        _cls02B4._mth02CB(this, intent);
    }

    public boolean supportRequestWindowFeature(int i)
    {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent)
    {
        return _cls02B4._mth02CA(this, intent);
    }
}
