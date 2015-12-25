// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

// Referenced classes of package o:
//            ahk, atu

static final class bject
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (atu)obj;
        obj1 = (atu)obj1;
        int i = Long.valueOf(((atu) (obj)).fX()).compareTo(Long.valueOf(((atu) (obj1)).fX()));
        if (i == 0)
        {
            return Integer.valueOf(((atu) (obj)).fY()).compareTo(Integer.valueOf(((atu) (obj1)).fY()));
        } else
        {
            return i;
        }
    }

    bject()
    {
    }
}
