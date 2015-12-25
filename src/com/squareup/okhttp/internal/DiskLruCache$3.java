// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

// Referenced classes of package com.squareup.okhttp.internal:
//            DiskLruCache

class this._cls0
    implements Iterator
{

    final Iterator _flddelegate;
    apshot nextSnapshot;
    apshot removeSnapshot;
    final DiskLruCache this$0;

    public boolean hasNext()
    {
        if (nextSnapshot != null)
        {
            return true;
        }
        DiskLruCache disklrucache = DiskLruCache.this;
        disklrucache;
        JVM INSTR monitorenter ;
        boolean flag = DiskLruCache.access$100(DiskLruCache.this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return false;
        apshot apshot;
        do
        {
            if (!_flddelegate.hasNext())
            {
                break MISSING_BLOCK_LABEL_73;
            }
            apshot = ((try)_flddelegate.next()).snapshot();
        } while (apshot == null);
        nextSnapshot = apshot;
        disklrucache;
        JVM INSTR monitorexit ;
        return true;
        disklrucache;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return false;
    }

    public apshot next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            removeSnapshot = nextSnapshot;
            nextSnapshot = null;
            return removeSnapshot;
        }
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        Object obj;
        if (removeSnapshot == null)
        {
            throw new IllegalStateException("remove() before next()");
        }
        try
        {
            DiskLruCache.this.remove(apshot.access._mth2100(removeSnapshot));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            removeSnapshot = null;
            return;
        }
        finally
        {
            removeSnapshot = null;
        }
        removeSnapshot = null;
        return;
        throw obj;
    }

    apshot()
    {
        this$0 = DiskLruCache.this;
        super();
        _flddelegate = (new ArrayList(DiskLruCache.access$2000(DiskLruCache.this).values())).iterator();
    }
}
