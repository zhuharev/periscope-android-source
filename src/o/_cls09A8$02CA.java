// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.IBinder;
import java.io.PrintWriter;
import java.util.Set;

// Referenced classes of package o:
//            _cls09A8, _cls14B4

public static interface t
{

    public abstract void disconnect();

    public abstract boolean isConnected();

    public abstract boolean _mth0294();

    public abstract IBinder _mth0295();

    public abstract void _mth02CA(String s, PrintWriter printwriter);

    public abstract void _mth02CA(tWriter twriter);

    public abstract void _mth02CA(_cls14B4 _pcls14b4);

    public abstract void _mth02CA(_cls14B4 _pcls14b4, Set set);
}
