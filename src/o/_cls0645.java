// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class _cls0645
{

    private static final char sm[] = "0123456789abcdef".toCharArray();
    private static final char sn[] = new char[64];

    public static int _mth02BC(int i, int j, android.graphics.Bitmap.Config config)
    {
        android.graphics.Bitmap.Config config1 = config;
        if (config == null)
        {
            config1 = android.graphics.Bitmap.Config.ARGB_8888;
        }
    /* anonymous class not found */
    class _anm1 {}

        byte byte0;
        switch (_cls1.nR[config1.ordinal()])
        {
        case 1: // '\001'
            byte0 = 1;
            break;

        case 2: // '\002'
        case 3: // '\003'
            byte0 = 2;
            break;

        default:
            byte0 = 4;
            break;
        }
        return i * j * byte0;
    }

    public static ArrayList _mth02CA(Set set)
    {
        ArrayList arraylist = new ArrayList(set.size());
        for (set = set.iterator(); set.hasNext(); arraylist.add(set.next())) { }
        return arraylist;
    }

    public static boolean _mth02E1(int i, int j)
    {
        if (i > 0 || i == 0x80000000)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            if (j > 0 || j == 0x80000000)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                return true;
            }
        }
        return false;
    }

    public static int _mth037A(Bitmap bitmap)
    {
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        int i = bitmap.getAllocationByteCount();
        return i;
_L2:
        return bitmap.getHeight() * bitmap.getRowBytes();
        NullPointerException nullpointerexception;
        nullpointerexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void _mth0631()
    {
        boolean flag;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException("You must call this method on the main thread");
        } else
        {
            return;
        }
    }

    public static boolean _mth068E()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean _mth068F()
    {
        boolean flag;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return !flag;
    }

    public static String _mth141D(byte abyte0[])
    {
        char ac[] = sn;
        ac;
        JVM INSTR monitorenter ;
        char ac1[] = sn;
        int i = 0;
_L2:
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        int j = abyte0[i] & 0xff;
        ac1[i << 1] = sm[j >>> 4];
        ac1[(i << 1) + 1] = sm[j & 0xf];
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        abyte0 = new String(ac1);
        ac;
        JVM INSTR monitorexit ;
        return abyte0;
        abyte0;
        throw abyte0;
    }

    public static ArrayDeque _mth1D5B(int i)
    {
        return new ArrayDeque(i);
    }

}
