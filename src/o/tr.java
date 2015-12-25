// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

// Referenced classes of package o:
//            tq

final class tr
    implements Comparator
{

    private tq Th;

    tr(tq tq)
    {
        Th = tq;
        super();
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (tq.if)obj;
        obj1 = (tq.if)obj1;
        return (int)(((tq.if) (obj)).timestamp - ((tq.if) (obj1)).timestamp);
    }
}
