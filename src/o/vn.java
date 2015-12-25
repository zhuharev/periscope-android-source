// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package o:
//            wo, vo, vp, wm, 
//            wn

public class vn extends wo
{
    static final class if extends Thread
    {

        public final void run()
        {
            do
            {
                vn vn1;
                do
                {
                    vn1 = vn.awaitTimeout();
                } while (vn1 == null);
                try
                {
                    vn1.timedOut();
                }
                catch (InterruptedException interruptedexception) { }
            } while (true);
        }

        public if()
        {
            super("Okio Watchdog");
            setDaemon(true);
        }
    }


    private static vn head;
    private boolean inQueue;
    private vn next;
    private long timeoutAt;

    public vn()
    {
    }

    private static vn awaitTimeout()
    {
        o/vn;
        JVM INSTR monitorenter ;
        vn vn1 = head.next;
        if (vn1 != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        o/vn.wait();
        o/vn;
        JVM INSTR monitorexit ;
        return null;
        long l = vn1.remainingNanos(System.nanoTime());
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        long l1 = l / 0xf4240L;
        o/vn.wait(l1, (int)(l - 0xf4240L * l1));
        o/vn;
        JVM INSTR monitorexit ;
        return null;
        head.next = vn1.next;
        vn1.next = null;
        o/vn;
        JVM INSTR monitorexit ;
        return vn1;
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean cancelScheduledTimeout(vn vn1)
    {
        o/vn;
        JVM INSTR monitorenter ;
        vn vn2 = head;
_L2:
        if (vn2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (vn2.next != vn1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        vn2.next = vn1.next;
        vn1.next = null;
        o/vn;
        JVM INSTR monitorexit ;
        return false;
        vn2 = vn2.next;
        if (true) goto _L2; else goto _L1
_L1:
        o/vn;
        JVM INSTR monitorexit ;
        return true;
        vn1;
        throw vn1;
    }

    private long remainingNanos(long l)
    {
        return timeoutAt - l;
    }

    private static void scheduleTimeout(vn vn1, long l, boolean flag)
    {
        o/vn;
        JVM INSTR monitorenter ;
        long l1;
        if (head == null)
        {
            head = new vn();
            (new if()).start();
        }
        l1 = System.nanoTime();
        if (l == 0L || !flag)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        vn1.timeoutAt = Math.min(l, vn1.deadlineNanoTime() - l1) + l1;
        break MISSING_BLOCK_LABEL_105;
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        vn1.timeoutAt = l1 + l;
        break MISSING_BLOCK_LABEL_105;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        vn1.timeoutAt = vn1.deadlineNanoTime();
        break MISSING_BLOCK_LABEL_105;
        throw new AssertionError();
        vn vn2;
        l = vn1.remainingNanos(l1);
        vn2 = head;
_L2:
        if (vn2.next != null && l >= vn2.next.remainingNanos(l1))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        vn1.next = vn2.next;
        vn2.next = vn1;
        if (vn2 != head)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        o/vn.notify();
        o/vn;
        JVM INSTR monitorexit ;
        return;
        vn2 = vn2.next;
        if (true) goto _L2; else goto _L1
_L1:
        o/vn;
        JVM INSTR monitorexit ;
        return;
        vn1;
        throw vn1;
    }

    public final void enter()
    {
        if (inQueue)
        {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l = timeoutNanos();
        boolean flag = hasDeadline();
        if (l == 0L && !flag)
        {
            return;
        } else
        {
            inQueue = true;
            scheduleTimeout(this, l, flag);
            return;
        }
    }

    final IOException exit(IOException ioexception)
    {
        if (!exit())
        {
            return ioexception;
        } else
        {
            InterruptedIOException interruptedioexception = new InterruptedIOException("timeout");
            interruptedioexception.initCause(ioexception);
            return interruptedioexception;
        }
    }

    final void exit(boolean flag)
    {
        if (exit() && flag)
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    public final boolean exit()
    {
        if (!inQueue)
        {
            return false;
        } else
        {
            inQueue = false;
            return cancelScheduledTimeout(this);
        }
    }

    public final wm sink(wm wm)
    {
        return new vo(this, wm);
    }

    public final wn source(wn wn)
    {
        return new vp(this, wn);
    }

    public void timedOut()
    {
    }

}
