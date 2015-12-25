// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import java.io.IOException;
import o.vy;
import o.wm;

// Referenced classes of package com.squareup.okhttp:
//            Cache

final class ditor
    implements CacheRequest
{

    private wm body;
    private wm cacheOut;
    private boolean done;
    private final com.squareup.okhttp.internal.rt editor;
    final Cache this$0;

    public final void abort()
    {
        Cache cache = Cache.this;
        cache;
        JVM INSTR monitorenter ;
        boolean flag = done;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        cache;
        JVM INSTR monitorexit ;
        return;
        done = true;
        Cache.access$908(Cache.this);
        cache;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        Util.closeQuietly(cacheOut);
        try
        {
            editor.rt();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public final wm body()
    {
        return body;
    }



/*
    static boolean access$702(ditor ditor, boolean flag)
    {
        ditor.done = flag;
        return flag;
    }

*/

    public ditor(com.squareup.okhttp.internal._cls1 _pcls1)
    {
        this$0 = Cache.this;
        super();
        editor = _pcls1;
        cacheOut = _pcls1.Sink(1);
        class _cls1 extends vy
        {

            final Cache.CacheRequestImpl this$1;
            final com.squareup.okhttp.internal.DiskLruCache.Editor val$editor;
            final Cache val$this$0;

            public void close()
            {
                Cache cache1 = Cache.CacheRequestImpl.this.this$0;
                cache1;
                JVM INSTR monitorenter ;
                boolean flag = done;
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_25;
                }
                cache1;
                JVM INSTR monitorexit ;
                return;
                done = true;
                Cache.access$808(Cache.CacheRequestImpl.this.this$0);
                cache1;
                JVM INSTR monitorexit ;
                  goto _L1
                Exception exception;
                exception;
                throw exception;
_L1:
                super.close();
                editor.commit();
                return;
            }

            _cls1(com.squareup.okhttp.internal.DiskLruCache.Editor editor1)
            {
                this$1 = Cache.CacheRequestImpl.this;
                this$0 = cache;
                editor = editor1;
                super(final_wm);
            }
        }

        body = new _cls1(_pcls1);
    }
}
