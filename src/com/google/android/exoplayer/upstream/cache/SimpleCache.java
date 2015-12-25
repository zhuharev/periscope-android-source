// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer.util.Assertions;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.upstream.cache:
//            Cache, CacheSpan, CacheEvictor

public final class SimpleCache
    implements Cache
{

    private final File cacheDir;
    private final HashMap cachedSpans = new HashMap();
    private final CacheEvictor evictor;
    private final HashMap listeners = new HashMap();
    private final HashMap lockedSpans = new HashMap();
    private long totalSpace;

    public SimpleCache(final File conditionVariable, CacheEvictor cacheevictor)
    {
        totalSpace = 0L;
        cacheDir = conditionVariable;
        evictor = cacheevictor;
        conditionVariable = new ConditionVariable();
        (new _cls1()).start();
        conditionVariable.block();
    }

    private void addSpan(CacheSpan cachespan)
    {
        TreeSet treeset1 = (TreeSet)cachedSpans.get(cachespan.key);
        TreeSet treeset = treeset1;
        if (treeset1 == null)
        {
            treeset = new TreeSet();
            cachedSpans.put(cachespan.key, treeset);
        }
        treeset.add(cachespan);
        totalSpace = totalSpace + cachespan.length;
        notifySpanAdded(cachespan);
    }

    private CacheSpan getSpan(CacheSpan cachespan)
    {
        String s;
        Object obj;
        do
        {
            s = cachespan.key;
            long l = cachespan.position;
            obj = (TreeSet)cachedSpans.get(s);
            if (obj == null)
            {
                return CacheSpan.createOpenHole(s, cachespan.position);
            }
            CacheSpan cachespan1 = (CacheSpan)((TreeSet) (obj)).floor(cachespan);
            if (cachespan1 == null || cachespan1.position > l || l >= cachespan1.position + cachespan1.length)
            {
                break;
            }
            if (cachespan1.file.exists())
            {
                return cachespan1;
            }
            removeStaleSpans();
        } while (true);
        obj = (CacheSpan)((TreeSet) (obj)).ceiling(cachespan);
        if (obj == null)
        {
            return CacheSpan.createOpenHole(s, cachespan.position);
        } else
        {
            return CacheSpan.createClosedHole(s, cachespan.position, ((CacheSpan) (obj)).position - cachespan.position);
        }
    }

    private void initialize()
    {
        if (!cacheDir.exists())
        {
            cacheDir.mkdirs();
        }
        File afile[] = cacheDir.listFiles();
        if (afile == null)
        {
            return;
        }
        for (int i = 0; i < afile.length; i++)
        {
            File file = afile[i];
            if (file.length() == 0L)
            {
                file.delete();
                continue;
            }
            CacheSpan cachespan = CacheSpan.createCacheEntry(file);
            if (cachespan == null)
            {
                file.delete();
            } else
            {
                addSpan(cachespan);
            }
        }

    }

    private void notifySpanAdded(CacheSpan cachespan)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanAdded(this, cachespan);
            }

        }
        evictor.onSpanAdded(this, cachespan);
    }

    private void notifySpanRemoved(CacheSpan cachespan)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanRemoved(this, cachespan);
            }

        }
        evictor.onSpanRemoved(this, cachespan);
    }

    private void notifySpanTouched(CacheSpan cachespan, CacheSpan cachespan1)
    {
        ArrayList arraylist = (ArrayList)listeners.get(cachespan.key);
        if (arraylist != null)
        {
            for (int i = arraylist.size() - 1; i >= 0; i--)
            {
                ((Cache.Listener)arraylist.get(i)).onSpanTouched(this, cachespan, cachespan1);
            }

        }
        evictor.onSpanTouched(this, cachespan, cachespan1);
    }

    private void removeStaleSpans()
    {
        Iterator iterator = cachedSpans.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Iterator iterator1 = ((TreeSet)((java.util.Map.Entry)iterator.next()).getValue()).iterator();
            boolean flag = true;
            while (iterator1.hasNext()) 
            {
                CacheSpan cachespan = (CacheSpan)iterator1.next();
                if (!cachespan.file.exists())
                {
                    iterator1.remove();
                    if (cachespan.isCached)
                    {
                        totalSpace = totalSpace - cachespan.length;
                    }
                    notifySpanRemoved(cachespan);
                } else
                {
                    flag = false;
                }
            }
            if (flag)
            {
                iterator.remove();
            }
        } while (true);
    }

    private CacheSpan startReadWriteNonBlocking(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        CacheSpan cachespan1;
        CacheSpan cachespan2;
        cachespan1 = getSpan(cachespan);
        if (!cachespan1.isCached)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        cachespan = (TreeSet)cachedSpans.get(cachespan1.key);
        Assertions.checkState(cachespan.remove(cachespan1));
        cachespan2 = cachespan1.touch();
        cachespan.add(cachespan2);
        notifySpanTouched(cachespan1, cachespan2);
        this;
        JVM INSTR monitorexit ;
        return cachespan2;
        if (lockedSpans.containsKey(cachespan.key))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        lockedSpans.put(cachespan.key, cachespan1);
        return cachespan1;
        this;
        JVM INSTR monitorexit ;
        return null;
        cachespan;
        throw cachespan;
    }

    public final NavigableSet addListener(String s, Cache.Listener listener)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist1 = (ArrayList)listeners.get(s);
        ArrayList arraylist;
        arraylist = arraylist1;
        if (arraylist1 != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        arraylist = new ArrayList();
        listeners.put(s, arraylist);
        arraylist.add(listener);
        s = getCachedSpans(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final void commitFile(File file)
    {
        this;
        JVM INSTR monitorenter ;
        CacheSpan cachespan = CacheSpan.createCacheEntry(file);
        boolean flag;
        if (cachespan != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        Assertions.checkState(lockedSpans.containsKey(cachespan.key));
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (file.length() != 0L)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        file.delete();
        this;
        JVM INSTR monitorexit ;
        return;
        addSpan(cachespan);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        file;
        throw file;
    }

    public final long getCacheSpace()
    {
        this;
        JVM INSTR monitorenter ;
        long l = totalSpace;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public final NavigableSet getCachedSpans(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (TreeSet)cachedSpans.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        s = new TreeSet(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final Set getKeys()
    {
        this;
        JVM INSTR monitorenter ;
        HashSet hashset = new HashSet(cachedSpans.keySet());
        this;
        JVM INSTR monitorexit ;
        return hashset;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean isCached(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = (TreeSet)cachedSpans.get(s);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        s = (CacheSpan)((TreeSet) (obj)).floor(CacheSpan.createLookup(s, l));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (((CacheSpan) (s)).position + ((CacheSpan) (s)).length > l)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        long l2 = l + l1;
        l1 = ((CacheSpan) (s)).position + ((CacheSpan) (s)).length;
        l = l1;
        if (l1 < l2)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        s = ((TreeSet) (obj)).tailSet(s, false).iterator();
_L3:
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        obj = (CacheSpan)s.next();
        if (((CacheSpan) (obj)).position <= l) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return false;
_L2:
        l1 = Math.max(l, ((CacheSpan) (obj)).position + ((CacheSpan) (obj)).length);
        l = l1;
        if (l1 >= l2)
        {
            return true;
        }
          goto _L3
        this;
        JVM INSTR monitorexit ;
        return false;
        s;
        throw s;
    }

    public final void releaseHoleSpan(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (cachespan == lockedSpans.remove(cachespan.key))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        cachespan;
        throw cachespan;
    }

    public final void removeListener(String s, Cache.Listener listener)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist = (ArrayList)listeners.get(s);
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        arraylist.remove(listener);
        if (arraylist.isEmpty())
        {
            listeners.remove(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void removeSpan(CacheSpan cachespan)
    {
        this;
        JVM INSTR monitorenter ;
        TreeSet treeset = (TreeSet)cachedSpans.get(cachespan.key);
        totalSpace = totalSpace - cachespan.length;
        Assertions.checkState(treeset.remove(cachespan));
        cachespan.file.delete();
        if (treeset.isEmpty())
        {
            cachedSpans.remove(cachespan.key);
        }
        notifySpanRemoved(cachespan);
        this;
        JVM INSTR monitorexit ;
        return;
        cachespan;
        throw cachespan;
    }

    public final File startFile(String s, long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Assertions.checkState(lockedSpans.containsKey(s));
        if (!cacheDir.exists())
        {
            removeStaleSpans();
            cacheDir.mkdirs();
        }
        evictor.onStartFile(this, s, l, l1);
        s = CacheSpan.getCacheFileName(cacheDir, s, l, System.currentTimeMillis());
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final CacheSpan startReadWrite(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = CacheSpan.createLookup(s, l);
_L1:
        CacheSpan cachespan = startReadWriteNonBlocking(s);
        if (cachespan == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorexit ;
        return cachespan;
        wait();
          goto _L1
        s;
        throw s;
    }

    public final CacheSpan startReadWriteNonBlocking(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        s = startReadWriteNonBlocking(CacheSpan.createLookup(s, l));
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }


    private class _cls1 extends Thread
    {

        final SimpleCache this$0;
        final ConditionVariable val$conditionVariable;

        public void run()
        {
            SimpleCache simplecache = SimpleCache.this;
            simplecache;
            JVM INSTR monitorenter ;
            conditionVariable.open();
            initialize();
            simplecache;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        _cls1()
        {
            this$0 = SimpleCache.this;
            conditionVariable = conditionvariable;
            super();
        }
    }

}
