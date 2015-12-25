// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigInteger;
import java.util.Comparator;

// Referenced classes of package o:
//            yh, auf

static final class 
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (auf)obj;
        obj1 = (auf)obj1;
        obj = ((auf) (obj)).gq();
        obj1 = ((auf) (obj1)).gq();
        if (obj == null && obj1 == null)
        {
            return 0;
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        } else
        {
            return ((BigInteger) (obj)).compareTo(((BigInteger) (obj1)));
        }
    }

    ()
    {
    }
}
