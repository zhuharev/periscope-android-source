// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.ws.WebSocketCall;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package o:
//            asq, aul, asr

static final class bDn
    implements Runnable
{

    private final asq bDn;
    private final Condition bDv;
    private int bDw;
    private final ReentrantLock nX = new ReentrantLock();
    private final String room;

    public final void run()
    {
        Object obj1;
        Object obj3;
        Random random;
        aul._mth02BF("ChatMan", (new StringBuilder("Connecting to ")).append(bDn.endpoint).toString());
        bDn.bDs = true;
        obj3 = null;
        obj1 = null;
        random = new Random();
_L2:
        Object obj;
        Object obj2;
        obj2 = obj3;
        obj = obj1;
        if (!bDn.bDs)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = bDn;
            aul._mth02BF("ChatMan", (new StringBuilder("open ep=")).append(((asq) (obj)).endpoint).toString());
            obj.bDr = new <init>(new asr(((asq) (obj))));
            obj1 = new OkHttpClient();
            WebSocketCall.create(((OkHttpClient) (obj1)), (new com.squareup.okhttp.uilder()).url((new StringBuilder()).append(((asq) (obj)).endpoint).append("/chatapi/v1/chatnow").toString()).build()).enqueue(((asq) (obj)).bDp);
            ((OkHttpClient) (obj1)).getDispatcher().getExecutorService().shutdown();
            obj = ((asq) (obj)).bDr;
        }
        obj1 = obj;
        obj2 = (Boolean)((Future) (obj)).get(5L, TimeUnit.SECONDS);
        break; /* Loop/switch isn't completed */
        obj2;
        obj1 = obj;
        int i = bDw;
        obj1 = obj;
        bDw = i + 1;
        obj1 = obj;
        i = random.nextInt(Math.min(i, 10) * 3000);
        obj1 = obj;
        aul._mth02CA("ChatMan", (new StringBuilder("open chatconn to ")).append(bDn.endpoint).append(" error, retry after sleep=").append(i).toString(), ((Throwable) (obj2)));
        obj = null;
        obj2 = null;
        obj1 = obj;
        nX.lock();
        bDv.await(i, TimeUnit.MILLISECONDS);
        obj1 = obj;
        nX.unlock();
        obj = obj2;
        break MISSING_BLOCK_LABEL_352;
        obj2;
        obj1 = obj;
        nX.unlock();
        obj1 = obj;
        TimeoutException timeoutexception;
        try
        {
            throw obj2;
        }
        catch (InterruptedException interruptedexception) { }
        continue; /* Loop/switch isn't completed */
        obj1 = obj;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Future) (obj)).cancel(true);
        }
        bDn.bDs = false;
        if (obj2 != null && ((Boolean) (obj2)).booleanValue())
        {
            bDn.bDo.CA(bDn, room);
        }
        return;
        timeoutexception;
        break MISSING_BLOCK_LABEL_352;
    }

    public tring(asq asq1, String s)
    {
        bDv = nX.newCondition();
        bDw = 1;
        room = s;
        bDn = asq1;
    }
}
