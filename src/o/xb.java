// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package o:
//            ws, xa, wt

public final class xb
    implements ws
{

    public final ConcurrentHashMap VM = new ConcurrentHashMap();

    public xb()
    {
    }

    public final wt _mth02E4(String s)
    {
        xa xa1 = (xa)VM.get(s);
        Object obj = xa1;
        if (xa1 == null)
        {
            obj = new xa(s);
            s = (xa)VM.putIfAbsent(s, obj);
            if (s != null)
            {
                obj = s;
            }
        }
        return ((wt) (obj));
    }
}
