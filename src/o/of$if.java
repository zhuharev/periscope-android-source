// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Hashtable;

// Referenced classes of package o:
//            pb, of, ot, oa, 
//            on, nx

final class MI extends pb
{

    final of ME;
    nx MI;

    public final void run()
    {
        String as[] = ME._mth4E3F();
        if (as == null)
        {
            return;
        }
        Hashtable hashtable = ot._mth02BB(ME.Ma);
        if (hashtable.get("uuid") == null)
        {
            hashtable.put("uuid", ME.UUID);
        }
        String s = of._mth02CA(ME);
        if (s != null)
        {
            hashtable.put("state", s);
        }
        if (of._mth02CB(ME) > 0 && of._mth02CB(ME) < 320)
        {
            hashtable.put("heartbeat", String.valueOf(of._mth02CB(ME)));
        }
        oa oa1 = new oa(as, hashtable, new on(this));
        ME._mth02CA(oa1, ME.Mu);
    }

    (of of1, int i, nx nx)
    {
        ME = of1;
        super(i);
        MI = nx;
    }
}
