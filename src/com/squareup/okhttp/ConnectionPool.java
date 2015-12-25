// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp:
//            Connection, Route, Address

public final class ConnectionPool
{

    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 0x493e0L;
    private static final ConnectionPool systemDefault;
    private final LinkedList connections = new LinkedList();
    private final Runnable connectionsCleanupRunnable = new _cls1();
    private Executor executor;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public ConnectionPool(int i, long l)
    {
        executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
        maxIdleConnections = i;
        keepAliveDurationNs = 1000L * l * 1000L;
    }

    private void addConnection(Connection connection)
    {
        boolean flag = connections.isEmpty();
        connections.addFirst(connection);
        if (flag)
        {
            executor.execute(connectionsCleanupRunnable);
            return;
        } else
        {
            notifyAll();
            return;
        }
    }

    public static ConnectionPool getDefault()
    {
        return systemDefault;
    }

    private void runCleanupUntilPoolIsEmpty()
    {
        while (performCleanup()) ;
    }

    public final void evictAll()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new ArrayList(connections);
        connections.clear();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
          goto _L1
        obj;
        throw obj;
_L1:
        int i = 0;
        for (int j = ((List) (obj)).size(); i < j; i++)
        {
            Util.closeQuietly(((Connection)((List) (obj)).get(i)).getSocket());
        }

        return;
    }

    public final Connection get(Address address)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        ListIterator listiterator = connections.listIterator(connections.size());
_L2:
        Connection connection = obj;
        boolean flag;
        if (!listiterator.hasPrevious())
        {
            break; /* Loop/switch isn't completed */
        }
        connection = (Connection)listiterator.previous();
        if (!connection.getRoute().getAddress().equals(address) || !connection.isAlive() || System.nanoTime() - connection.getIdleStartTimeNs() >= keepAliveDurationNs)
        {
            continue; /* Loop/switch isn't completed */
        }
        listiterator.remove();
        flag = connection.isSpdy();
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        Platform.get().tagSocket(connection.getSocket());
        break; /* Loop/switch isn't completed */
        SocketException socketexception;
        socketexception;
        Util.closeQuietly(connection.getSocket());
        Platform.get().logW((new StringBuilder("Unable to tagSocket(): ")).append(socketexception).toString());
        if (true) goto _L2; else goto _L1
_L1:
        if (connection == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (connection.isSpdy())
        {
            connections.addFirst(connection);
        }
        this;
        JVM INSTR monitorexit ;
        return connection;
        address;
        throw address;
    }

    public final int getConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = connections.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final List getConnections()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = new ArrayList(connections);
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getHttpConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = connections.size();
        j = getMultiplexedConnectionCount();
        this;
        JVM INSTR monitorexit ;
        return i - j;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getMultiplexedConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        Iterator iterator = connections.iterator();
_L1:
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        flag = ((Connection)iterator.next()).isSpdy();
        int j = i;
        if (flag)
        {
            j = i + 1;
        }
        i = j;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getSpdyConnectionCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = getMultiplexedConnectionCount();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean performCleanup()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = connections.isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        Object obj = new ArrayList();
        int i = 0;
        ListIterator listiterator;
        long l;
        long l2;
        l2 = System.nanoTime();
        l = keepAliveDurationNs;
        listiterator = connections.listIterator(connections.size());
_L3:
        if (!listiterator.hasPrevious()) goto _L2; else goto _L1
_L1:
        Connection connection;
        long l3;
        connection = (Connection)listiterator.previous();
        l3 = (connection.getIdleStartTimeNs() + keepAliveDurationNs) - l2;
        if (l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (connection.isAlive())
        {
            break MISSING_BLOCK_LABEL_121;
        }
        listiterator.remove();
        ((List) (obj)).add(connection);
          goto _L3
        int j;
        long l1;
        j = i;
        l1 = l;
        if (!connection.isIdle()) goto _L5; else goto _L4
_L4:
        j = i + 1;
        l1 = Math.min(l, l3);
          goto _L5
_L2:
        listiterator = connections.listIterator(connections.size());
_L8:
        if (!listiterator.hasPrevious() || i <= maxIdleConnections) goto _L7; else goto _L6
_L6:
        connection = (Connection)listiterator.previous();
        j = i;
        if (!connection.isIdle())
        {
            break MISSING_BLOCK_LABEL_343;
        }
        ((List) (obj)).add(connection);
        listiterator.remove();
        j = i - 1;
        break MISSING_BLOCK_LABEL_343;
_L7:
        flag = ((List) (obj)).isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        try
        {
            l1 = l / 0xf4240L;
            wait(l1, (int)(l - 0xf4240L * l1));
        }
        // Misplaced declaration of an exception variable
        catch (InterruptedException interruptedexception)
        {
            i = 0;
            for (j = ((List) (obj)).size(); i < j; i++)
            {
                Util.closeQuietly(((Connection)((List) (obj)).get(i)).getSocket());
            }

            return true;
        }
        finally
        {
            throw obj;
        }
        this;
        JVM INSTR monitorexit ;
        InterruptedException interruptedexception;
        return true;
_L5:
        i = j;
        l = l1;
          goto _L3
        i = j;
          goto _L8
    }

    final void recycle(Connection connection)
    {
        if (connection.isSpdy())
        {
            return;
        }
        if (!connection.clearOwner())
        {
            return;
        }
        if (!connection.isAlive())
        {
            Util.closeQuietly(connection.getSocket());
            return;
        }
        try
        {
            Platform.get().untagSocket(connection.getSocket());
        }
        catch (SocketException socketexception)
        {
            Platform.get().logW((new StringBuilder("Unable to untagSocket(): ")).append(socketexception).toString());
            Util.closeQuietly(connection.getSocket());
            return;
        }
        this;
        JVM INSTR monitorenter ;
        addConnection(connection);
        connection.incrementRecycleCount();
        connection.resetIdleStartTime();
        this;
        JVM INSTR monitorexit ;
        return;
        connection;
        throw connection;
    }

    final void replaceCleanupExecutorForTests(Executor executor1)
    {
        executor = executor1;
    }

    final void share(Connection connection)
    {
        if (!connection.isSpdy())
        {
            throw new IllegalArgumentException();
        }
        if (!connection.isAlive())
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        addConnection(connection);
        this;
        JVM INSTR monitorexit ;
        return;
        connection;
        throw connection;
    }

    static 
    {
        String s = System.getProperty("http.keepAlive");
        String s1 = System.getProperty("http.keepAliveDuration");
        String s2 = System.getProperty("http.maxConnections");
        long l;
        if (s1 != null)
        {
            l = Long.parseLong(s1);
        } else
        {
            l = 0x493e0L;
        }
        if (s != null && !Boolean.parseBoolean(s))
        {
            systemDefault = new ConnectionPool(0, l);
        } else
        if (s2 != null)
        {
            systemDefault = new ConnectionPool(Integer.parseInt(s2), l);
        } else
        {
            systemDefault = new ConnectionPool(5, l);
        }
    }


    private class _cls1
        implements Runnable
    {

        final ConnectionPool this$0;

        public void run()
        {
            runCleanupUntilPoolIsEmpty();
        }

        _cls1()
        {
            this$0 = ConnectionPool.this;
            super();
        }
    }

}
