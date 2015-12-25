// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class px extends Activity
{
    public static class if
    {

        public void _mth0107()
        {
        }

        public void FF84()
        {
        }

        public void FF95()
        {
        }

        public if()
        {
        }
    }


    private final ArrayList Pg = new ArrayList();

    px()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        for (bundle = Pg.iterator(); bundle.hasNext(); bundle.next()) { }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        for (Iterator iterator = Pg.iterator(); iterator.hasNext(); ((if)iterator.next()).FF84()) { }
    }

    protected void onStart()
    {
        super.onStart();
        for (Iterator iterator = Pg.iterator(); iterator.hasNext(); ((if)iterator.next())._mth0107()) { }
    }

    protected void onStop()
    {
        super.onStop();
        for (Iterator iterator = Pg.iterator(); iterator.hasNext(); ((if)iterator.next()).FF95()) { }
    }

    public void _mth02CA(if if1)
    {
        Pg.remove(if1);
    }

    public void _mth02CB(if if1)
    {
        if (Pg.contains(if1))
        {
            return;
        } else
        {
            Pg.add(if1);
            return;
        }
    }
}
