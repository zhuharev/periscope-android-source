// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

// Referenced classes of package o:
//            apb, _cls028B, apa, FF6A

final class .Thread.start
    implements Runnable
{

    private final Thread aTU = new Thread(this);
    public boolean bxX;
    private DatagramSocket bxY;
    private apb bxZ;

    private static long _mth02E1(byte abyte0[], int i)
    {
        return 1000L * (_cls028B._mth02CB(abyte0, i) - 0x83aa7e80L) + (1000L * _cls028B._mth02CB(abyte0, i + 4)) / 0x100000000L;
    }

    public final void run()
    {
_L8:
        byte abyte0[];
        Object obj1;
        long l;
        long l1;
        bxY = new DatagramSocket();
        bxY.setSoTimeout(800);
        obj1 = new InetSocketAddress("pool.ntp.org", 123);
        l = System.currentTimeMillis();
        l1 = System.nanoTime();
        abyte0 = new byte[48];
        abyte0[0] = 27;
        long l2 = l / 1000L + 0x83aa7e80L;
        apa._mth02BB(l2, abyte0, 40);
        apa._mth02BB((l - 1000L * l2 << 32) / 1000L, abyte0, 44);
        obj1 = new DatagramPacket(abyte0, 48, ((java.net.SocketAddress) (obj1)));
        bxY.send(((DatagramPacket) (obj1)));
        obj1 = new DatagramPacket(abyte0, 48);
        bxY.receive(((DatagramPacket) (obj1)));
        boolean flag = true;
          goto _L1
_L9:
        flag = false;
_L1:
        if (!flag) goto _L3; else goto _L2
_L2:
        long l3;
        long l4;
        long l5;
        l1 = l + (System.nanoTime() - l1) / 0xf4240L;
        l3 = _mth02E1(abyte0, 24);
        l4 = _mth02E1(abyte0, 32);
        l5 = _mth02E1(abyte0, 40);
        l = l1 - l - (l5 - l4);
        if (l >= 250L) goto _L5; else goto _L4
_L4:
        l1 = ((l4 - l3) + (l5 - l1)) / 2L;
        apb apb1 = bxZ;
        apb1;
        JVM INSTR monitorenter ;
        apb._mth02CA(bxZ, l1);
        apb._mth02CB(bxZ, System.currentTimeMillis());
        apb1;
        JVM INSTR monitorexit ;
          goto _L6
        Object obj2;
        obj2;
        throw obj2;
_L6:
        FF6A._mth02CB("RTMP", (new StringBuilder("Clock offset: ")).append(l1).append(" roundtrip: ").append(l).append(" msecs").toString());
        bxY.close();
        bxY = null;
          goto _L7
_L5:
        FF6A._mth02CB("RTMP", (new StringBuilder("Round-trip msecs: ")).append(l).toString());
_L3:
        Thread.sleep(500L);
          goto _L8
_L7:
        bxX = false;
        return;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        bxX = false;
        return;
        obj;
        bxX = false;
        throw obj;
        obj2;
          goto _L9
    }

    public .Runnable(apb apb1)
    {
        bxZ = apb1;
        super();
        bxX = true;
        bxY = null;
        aTU.start();
    }
}
