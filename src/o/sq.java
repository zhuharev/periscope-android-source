// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package o:
//            so

final class sq extends so._cls02CF
{

    private so Sz;

    sq(so so1)
    {
        Sz = so1;
        super((byte)0);
    }

    public final Object call()
    {
        so.access$200(Sz).set(true);
        Process.setThreadPriority(10);
        return so.access$300(Sz, Sz.doInBackground(SK));
    }
}
