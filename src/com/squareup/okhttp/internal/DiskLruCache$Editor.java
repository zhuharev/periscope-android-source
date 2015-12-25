// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import o.wm;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache

public final class <init>
{

    private boolean committed;
    private final entry entry;
    private boolean hasErrors;
    final DiskLruCache this$0;
    private final boolean written[];

    public final void abort()
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        DiskLruCache.access$2600(DiskLruCache.this, this, false);
        disklrucache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void abortUnlessCommitted()
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        boolean flag = committed;
        Exception exception;
        if (!flag)
        {
            try
            {
                DiskLruCache.access$2600(DiskLruCache.this, this, false);
            }
            catch (IOException ioexception) { }
            finally
            {
                disklrucache;
            }
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    public final void commit()
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        if (hasErrors)
        {
            DiskLruCache.access$2600(DiskLruCache.this, this, false);
            DiskLruCache.access$2700(DiskLruCache.this, entry);
            break MISSING_BLOCK_LABEL_47;
        }
        DiskLruCache.access$2600(DiskLruCache.this, this, true);
        committed = true;
        disklrucache;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final wm newSink(int i)
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        Object obj;
        if (ccess._mth900(entry) != this)
        {
            throw new IllegalStateException();
        }
        if (!ccess._mth800(entry))
        {
            written[i] = true;
        }
        obj = ccess._mth1400(entry)[i];
        obj = DiskLruCache.access$2400(DiskLruCache.this).sink(((java.io.File) (obj)));
          goto _L1
_L3:
        obj = DiskLruCache.access$2500();
        disklrucache;
        JVM INSTR monitorexit ;
        return ((wm) (obj));
_L1:
        class _cls1 extends FaultHidingSink
        {

            final DiskLruCache.Editor this$1;

            protected void onException(IOException ioexception)
            {
                ioexception = this$0;
                ioexception;
                JVM INSTR monitorenter ;
                hasErrors = true;
                ioexception;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                throw exception;
            }

            _cls1(wm wm)
            {
                this$1 = DiskLruCache.Editor.this;
                super(wm);
            }
        }

        obj = new _cls1(((wm) (obj)));
        disklrucache;
        JVM INSTR monitorexit ;
        return ((wm) (obj));
        Object obj1;
        obj1;
        throw obj1;
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final wn newSource(int i)
    {
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        boolean flag;
        if (ccess._mth900(entry) != this)
        {
            throw new IllegalStateException();
        }
        flag = ccess._mth800(entry);
        Object obj;
        if (!flag)
        {
            return null;
        }
        wn wn;
        try
        {
            wn = DiskLruCache.access$2400(DiskLruCache.this).source(ccess._mth1300(entry)[i]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        finally
        {
            disklrucache;
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return wn;
        throw obj;
    }




/*
    static boolean access$1902(_cls1 _pcls1, boolean flag)
    {
        _pcls1.hasErrors = flag;
        return flag;
    }

*/

    private hasErrors(hasErrors haserrors)
    {
        this$0 = DiskLruCache.this;
        super();
        entry = haserrors;
        if (ccess._mth800(haserrors))
        {
            disklrucache = null;
        } else
        {
            disklrucache = new boolean[DiskLruCache.access$2300(DiskLruCache.this)];
        }
        written = DiskLruCache.this;
    }

    written(written written1, written written2)
    {
        this(written1);
    }
}
