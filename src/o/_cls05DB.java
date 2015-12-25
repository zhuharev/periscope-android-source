// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

// Referenced classes of package o:
//            _cls0254, _cls1D53

public class _cls05DB extends _cls0254
    implements Menu
{

    public _cls05DB(Context context, _cls1D53 _pcls1d53)
    {
        super(context, _pcls1d53);
    }

    public MenuItem add(int i)
    {
        return _mth141D(((_cls1D53)_fld15A8).add(i));
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        return _mth141D(((_cls1D53)_fld15A8).add(i, j, k, l));
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        return _mth141D(((_cls1D53)_fld15A8).add(i, j, k, charsequence));
    }

    public MenuItem add(CharSequence charsequence)
    {
        return _mth141D(((_cls1D53)_fld15A8).add(charsequence));
    }

    public int addIntentOptions(int i, int j, int k, ComponentName componentname, Intent aintent[], Intent intent, int l, 
            MenuItem amenuitem[])
    {
        MenuItem amenuitem1[] = null;
        if (amenuitem != null)
        {
            amenuitem1 = new MenuItem[amenuitem.length];
        }
        j = ((_cls1D53)_fld15A8).addIntentOptions(i, j, k, componentname, aintent, intent, l, amenuitem1);
        if (amenuitem1 != null)
        {
            i = 0;
            for (k = amenuitem1.length; i < k; i++)
            {
                amenuitem[i] = _mth141D(amenuitem1[i]);
            }

        }
        return j;
    }

    public SubMenu addSubMenu(int i)
    {
        return _mth02CA(((_cls1D53)_fld15A8).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int j, int k, int l)
    {
        return _mth02CA(((_cls1D53)_fld15A8).addSubMenu(i, j, k, l));
    }

    public SubMenu addSubMenu(int i, int j, int k, CharSequence charsequence)
    {
        return _mth02CA(((_cls1D53)_fld15A8).addSubMenu(i, j, k, charsequence));
    }

    public SubMenu addSubMenu(CharSequence charsequence)
    {
        return _mth02CA(((_cls1D53)_fld15A8).addSubMenu(charsequence));
    }

    public void clear()
    {
        _mth1449();
        ((_cls1D53)_fld15A8).clear();
    }

    public void close()
    {
        ((_cls1D53)_fld15A8).close();
    }

    public MenuItem findItem(int i)
    {
        return _mth141D(((_cls1D53)_fld15A8).findItem(i));
    }

    public MenuItem getItem(int i)
    {
        return _mth141D(((_cls1D53)_fld15A8).getItem(i));
    }

    public boolean hasVisibleItems()
    {
        return ((_cls1D53)_fld15A8).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyevent)
    {
        return ((_cls1D53)_fld15A8).isShortcutKey(i, keyevent);
    }

    public boolean performIdentifierAction(int i, int j)
    {
        return ((_cls1D53)_fld15A8).performIdentifierAction(i, j);
    }

    public boolean performShortcut(int i, KeyEvent keyevent, int j)
    {
        return ((_cls1D53)_fld15A8).performShortcut(i, keyevent, j);
    }

    public void removeGroup(int i)
    {
        _mth02C6(i);
        ((_cls1D53)_fld15A8).removeGroup(i);
    }

    public void removeItem(int i)
    {
        _mth02C7(i);
        ((_cls1D53)_fld15A8).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean flag, boolean flag1)
    {
        ((_cls1D53)_fld15A8).setGroupCheckable(i, flag, flag1);
    }

    public void setGroupEnabled(int i, boolean flag)
    {
        ((_cls1D53)_fld15A8).setGroupEnabled(i, flag);
    }

    public void setGroupVisible(int i, boolean flag)
    {
        ((_cls1D53)_fld15A8).setGroupVisible(i, flag);
    }

    public void setQwertyMode(boolean flag)
    {
        ((_cls1D53)_fld15A8).setQwertyMode(flag);
    }

    public int size()
    {
        return ((_cls1D53)_fld15A8).size();
    }
}
