// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.Semaphore;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package o:
//            apc, apf, apd, apa

public final class ape
    implements Runnable
{
    public static interface if
    {

        public abstract void dZ();

        public abstract void ea();

        public abstract void _mth02CA(apd apd1);
    }

    /* member class not found */
    class _cls02CA {}


    private Thread aTU;
    private String bwE;
    private int bwF;
    apc bxG;
    private if byg;
    Socket byh;
    private InputStream byi;
    public _cls02CA byj;
    private boolean byk;
    apc byl;

    public ape()
    {
        byk = false;
        bxG = new apc();
        byl = new apc();
    }

    public final void run()
    {
        Object obj = new byte[32768];
label0:
        {
            if (byk)
            {
                SSLSocket sslsocket = (SSLSocket)SSLSocketFactory.getDefault().createSocket(bwE, bwF);
                Semaphore semaphore = new Semaphore(0);
                sslsocket.addHandshakeCompletedListener(new apf(this, semaphore));
                sslsocket.startHandshake();
                semaphore.acquire();
                byh = sslsocket;
                break label0;
            }
            try
            {
                byh = new Socket(bwE, bwF);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                byg.ea();
                return;
            }
        }
        byj = new _cls02CA();
        byg.dZ();
        byh.setSoTimeout(50);
        byi = byh.getInputStream();
_L3:
        IOException ioexception;
        apd apd1;
        int i;
        do
        {
            try
            {
                i = byi.read(((byte []) (obj)), 0, 32768);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                i = 0;
                try
                {
                    byh.setSoTimeout(200);
                }
                // Misplaced declaration of an exception variable
                catch (IOException ioexception)
                {
                    ioexception.printStackTrace();
                    byg.ea();
                    return;
                }
            }
        } while (i <= 0);
        byh.setSoTimeout(50);
_L1:
        apd1 = bxG.FE98(i);
        if (apd1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        apd1._mth02C6(((byte []) (obj)), 0, i);
        byg._mth02CA(apd1);
        continue; /* Loop/switch isn't completed */
        Object obj1;
        Thread.sleep(10L);
          goto _L1
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void send(byte abyte0[], int i, int j)
    {
        if (byj != null)
        {
            byj.send(abyte0, 0, j);
        }
    }

    public final void shutdown()
    {
        _cls02CA _lcls02ca;
        if (byj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        _lcls02ca = byj;
        _lcls02ca.bys = true;
        _lcls02ca.aTU.interrupt();
        _lcls02ca.aTU.join();
        break MISSING_BLOCK_LABEL_39;
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        aTU.interrupt();
        byh.close();
_L2:
        bxG.shutdown();
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void _mth02CA(String s, int i, boolean flag, apa apa)
    {
        byg = apa;
        bwE = s;
        bwF = i;
        byk = flag;
        aTU = new Thread(this);
        aTU.start();
    }
}
