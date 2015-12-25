// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

// Referenced classes of package o:
//            anj, anl, zc, atv

final class ank
    implements android.view.ActionMode.Callback
{

    final anj.if bug;

    ank(anj.if if1)
    {
        bug = if1;
        super();
    }

    public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        case 2131558854: 
            int i = bug.bmZ.bnd.size();
            (new android.app.AlertDialog.Builder(bug.bue)).setMessage(bug.bue.getString(0x7f06008e, new Object[] {
                Integer.valueOf(i)
            })).setPositiveButton(bug.bue.getString(0x7f06008d, new Object[] {
                Integer.valueOf(i)
            }), new anl(this, actionmode)).setNegativeButton(0x7f060074, null).show();
            return true;
        }
        return false;
    }

    public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        actionmode.getMenuInflater().inflate(0x7f0e0001, menu);
        if (bug.buc == null)
        {
            bug.buc = (TextView)LayoutInflater.from(bug.bue).inflate(0x7f030089, null, false);
        }
        actionmode.setCustomView(bug.buc);
        return true;
    }

    public final void onDestroyActionMode(ActionMode actionmode)
    {
        anj._mth02CA(bug.bue, bug.bua);
        actionmode = bug.bmZ;
        String as[] = new String[((aig.if) (actionmode)).bnd.size()];
        ((aig.if) (actionmode)).bnd.toArray(as);
        ((aig.if) (actionmode)).bnd.clear();
        int k = as.length;
label0:
        for (int i = 0; i < k; i++)
        {
            String s = as[i];
            zc zc1 = ((aig.if) (actionmode)).bmU;
            int j = zc1.FF89.size() - 1;
            do
            {
                if (j < 0)
                {
                    continue label0;
                }
                if (Objects.equals(((atv)zc1.FF89.get(j)).ga(), s))
                {
                    for (Iterator iterator = zc1.aWu.iterator(); iterator.hasNext(); ((zg.if)iterator.next())._mth2071(j, 1)) { }
                    continue label0;
                }
                j--;
            } while (true);
        }

        bug.bub = null;
    }

    public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        bug.buc.setText(String.valueOf(bug.bmZ.bnd.size()));
        return false;
    }
}
