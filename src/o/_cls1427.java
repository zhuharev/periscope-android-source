// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.support.v4.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

// Referenced classes of package o:
//            _cls141D

public abstract class _cls1427
{
    /* member class not found */
    class if {}


    public _cls1427()
    {
    }

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract boolean executePendingTransactions();

    public abstract Fragment findFragmentById(int i);

    public abstract Fragment findFragmentByTag(String s);

    public abstract boolean isDestroyed();

    public abstract void popBackStack(int i, int j);

    public abstract boolean popBackStackImmediate();

    public abstract _cls141D _mth02BB();

    public abstract ArrayList _mth02BC();
}
