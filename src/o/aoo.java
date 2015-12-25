// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aoo
{
    public static interface if
    {

        public abstract void _mth05E0(String s);

        public abstract void _mth05E8(String s);
    }

    /* member class not found */
    class _cls02CA {}


    private final ArrayList bvj = new ArrayList(2);

    public aoo()
    {
        String s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        bvj.add(new _cls02CA((new StringBuilder()).append(s).append(File.separator).append("Screenshots").toString(), 264));
        String s1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        if (!s1.equalsIgnoreCase(s))
        {
            bvj.add(new _cls02CA((new StringBuilder()).append(s1).append(File.separator).append("Screenshots").toString(), 264));
        }
    }

    public final void startWatching()
    {
        for (Iterator iterator = bvj.iterator(); iterator.hasNext(); ((_cls02CA)iterator.next()).startWatching()) { }
    }

    public final void stopWatching()
    {
        for (Iterator iterator = bvj.iterator(); iterator.hasNext(); ((_cls02CA)iterator.next()).stopWatching()) { }
    }

    public final void _mth02CA(if if1)
    {
        for (Iterator iterator = bvj.iterator(); iterator.hasNext();)
        {
            ((_cls02CA)iterator.next()).bvl = if1;
        }

    }
}
