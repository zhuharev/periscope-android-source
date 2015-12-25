// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package o:
//            abk, abc

public final class abj
{
    public static final class if
    {

        private static final abj bce = new abj();

        public static abj al()
        {
            return bce;
        }

    }


    public final ConcurrentHashMap bcc = new ConcurrentHashMap();
    public boolean bcd;

    abj()
    {
    }

    public final abk _mth02CA(abc abc)
    {
        if ((abk)bcc.put(abc.getName(), abc) != null && bcd)
        {
            throw new IllegalStateException((new StringBuilder("Logger with ")).append(abc.getName()).append(" already exists").toString());
        } else
        {
            return abc;
        }
    }
}
