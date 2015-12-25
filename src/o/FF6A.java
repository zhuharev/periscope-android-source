// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            FF83, abk

public class FF6A
    implements FF83
{

    public static final AtomicReference ma = new AtomicReference();
    public static boolean mb = false;
    private final byte bytes[];
    private final String id;

    public FF6A()
    {
    }

    public FF6A(byte abyte0[], String s)
    {
        bytes = abyte0;
        id = s;
    }

    public static void _mth02CA(String s, String s1)
    {
        if (mb)
        {
            Log.e(s, s1);
        }
        boolean flag;
        if ("RTMP".equals(s) && ma.get() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((abk)ma.get()).log(s1);
        }
    }

    public static void _mth02CA(String s, String s1, Throwable throwable)
    {
        if (mb)
        {
            Log.e(s, s1, throwable);
        }
        boolean flag;
        if ("RTMP".equals(s) && ma.get() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((abk)ma.get()).log(s1);
        }
    }

    public static void _mth02CB(String s, String s1)
    {
        if (mb)
        {
            Log.i(s, s1);
        }
        boolean flag;
        if ("RTMP".equals(s) && ma.get() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((abk)ma.get()).log(s1);
        }
    }

    public static void _mth02CE(String s, String s1)
    {
        if (mb)
        {
            Log.w(s, s1);
        }
        boolean flag;
        if ("RTMP".equals(s) && ma.get() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            ((abk)ma.get()).log(s1);
        }
    }

    public final void cancel()
    {
    }

    public final String getId()
    {
        return id;
    }

    public final Object _mth1424(int i)
    {
        return new ByteArrayInputStream(bytes);
    }

    public final void _mth14F4()
    {
    }

}
