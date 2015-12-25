// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

// Referenced classes of package o:
//            yk, ym

static final class Object
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (ym)obj;
        obj1 = (ym)obj1;
        return Long.compare(((ym) (obj)).e(), ((ym) (obj1)).e());
    }

    Object()
    {
    }
}
