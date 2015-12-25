// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.util.Queue;

// Referenced classes of package o:
//            _cls0645

public final class _cls04CC
{

    private static final _cls04CC sc = new _cls04CC();
    private final Queue sb = _cls0645._mth1D5B(0);

    private _cls04CC()
    {
    }

    public static _cls04CC _mth05DB()
    {
        return sc;
    }

    public final byte[] getBytes()
    {
        Queue queue = sb;
        queue;
        JVM INSTR monitorenter ;
        Object obj = (byte[])sb.poll();
        queue;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        byte abyte1[] = ((byte []) (obj));
        if (obj == null)
        {
            byte abyte0[] = new byte[0x10000];
            abyte1 = abyte0;
            if (Log.isLoggable("ByteArrayPool", 3))
            {
                Log.d("ByteArrayPool", "Created temp bytes");
                abyte1 = abyte0;
            }
        }
        return abyte1;
    }

    public final boolean _mth02CF(byte abyte0[])
    {
        boolean flag;
        if (abyte0.length != 0x10000)
        {
            return false;
        }
        flag = false;
        Queue queue = sb;
        queue;
        JVM INSTR monitorenter ;
        if (sb.size() >= 32)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag = true;
        sb.offer(abyte0);
        queue;
        JVM INSTR monitorexit ;
        return flag;
        abyte0;
        throw abyte0;
    }

}
