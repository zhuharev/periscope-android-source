// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package o:
//            dv, bs, eh

public abstract class _cls09AA
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    public _cls09AA()
    {
    }

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public Looper getLooper()
    {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public bs _mth02CA(dv dv)
    {
        throw new UnsupportedOperationException();
    }

    public bs _mth02CA(eh eh)
    {
        throw new UnsupportedOperationException();
    }

    public _cls09A8._cls02CA _mth02CA(_cls09A8._cls02CB _pcls02cb)
    {
        throw new UnsupportedOperationException();
    }

    public abstract void _mth02CA(cl.if if1);

    public abstract void _mth02CB(cl.if if1);
}
