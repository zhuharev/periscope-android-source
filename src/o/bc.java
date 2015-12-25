// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package o:
//            bi, bb

final class bc
    implements bi
{

    private bb zA;

    bc(bb bb1)
    {
        zA = bb1;
        super();
    }

    public final void _mth02CA(ev.if if1)
    {
        zA.zw = if1;
        for (if1 = zA.zy.iterator(); if1.hasNext(); ((bb.if)if1.next())._mth1604()) { }
        zA.zy.clear();
        zA.zx = null;
    }
}
