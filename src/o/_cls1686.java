// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package o:
//            si, rz

final class _cls1686
{

    private static final AtomicLong tX = new AtomicLong(0L);
    private static String tY;

    public _cls1686(si si1)
    {
        long l = (new Date()).getTime();
        long l1 = l / 1000L;
        Object obj = ByteBuffer.allocate(4);
        ((ByteBuffer) (obj)).putInt((int)l1);
        ((ByteBuffer) (obj)).order(ByteOrder.BIG_ENDIAN);
        ((ByteBuffer) (obj)).position(0);
        byte abyte0[] = ((ByteBuffer) (obj)).array();
        byte byte0 = abyte0[0];
        byte byte1 = abyte0[1];
        byte byte2 = abyte0[2];
        byte byte3 = abyte0[3];
        abyte0 = ByteBuffer.allocate(2);
        abyte0.putShort((short)(int)(l % 1000L));
        abyte0.order(ByteOrder.BIG_ENDIAN);
        abyte0.position(0);
        abyte0 = abyte0.array();
        byte byte4 = abyte0[0];
        byte byte5 = abyte0[1];
        l = tX.incrementAndGet();
        abyte0 = ByteBuffer.allocate(2);
        abyte0.putShort((short)(int)l);
        abyte0.order(ByteOrder.BIG_ENDIAN);
        abyte0.position(0);
        abyte0 = abyte0.array();
        byte byte6 = abyte0[0];
        byte byte7 = abyte0[1];
        l = Integer.valueOf(Process.myPid()).shortValue();
        abyte0 = ByteBuffer.allocate(2);
        abyte0.putShort((short)(int)l);
        abyte0.order(ByteOrder.BIG_ENDIAN);
        abyte0.position(0);
        abyte0 = abyte0.array();
        byte byte8 = abyte0[0];
        byte byte9 = abyte0[1];
        si1 = rz._mth1424(si1._mth0E22());
        abyte0 = rz._mth1FBE(new byte[] {
            byte0, byte1, byte2, byte3, byte4, byte5, byte6, byte7, byte8, byte9
        });
        tY = String.format(Locale.US, "%s-%s-%s-%s", new Object[] {
            abyte0.substring(0, 12), abyte0.substring(12, 16), abyte0.subSequence(16, 20), si1.substring(0, 12)
        }).toUpperCase(Locale.US);
    }

    public final String toString()
    {
        return tY;
    }

}
