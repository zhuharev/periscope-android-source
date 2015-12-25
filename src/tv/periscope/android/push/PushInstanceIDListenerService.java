// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.push;

import o.abv;
import o.acj;
import o.ack;
import o.bk;
import o.xd;

public class PushInstanceIDListenerService extends bk
{

    public PushInstanceIDListenerService()
    {
    }

    public final void _mth1E3B()
    {
        abv abv1 = xd._mth212A();
        Object obj = abv1.mSessionManager;
        if (((ack) (obj)).bde == null)
        {
            ((ack) (obj)).aG();
        }
        obj = ((ack) (obj)).bde;
        if (obj != null)
        {
            obj = ((acj) (obj)).bcY;
        } else
        {
            obj = null;
        }
        abv1._mth02BB("register", ((String) (obj)), null);
    }
}
