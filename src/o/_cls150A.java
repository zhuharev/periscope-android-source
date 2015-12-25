// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class _cls150A
{

    private int hitCount;
    private int size;
    private final LinkedHashMap _fld1D2C;
    private int _fld1D31;
    private int _fld1D32;
    private int _fld1D3E;
    private int _fld1D41;

    public _cls150A(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            _fld1D31 = i;
            _fld1D2C = new LinkedHashMap(0, 0.75F, true);
            return;
        }
    }

    private void trimToSize(int i)
    {
_L2:
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (size < 0 || _fld1D2C.isEmpty() && size != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getName()).append(".sizeOf() is reporting inconsistent results!").toString());
        }
        if (size <= i)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        flag = _fld1D2C.isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        java.util.Map.Entry entry = (java.util.Map.Entry)_fld1D2C.entrySet().iterator().next();
        Object obj = entry.getKey();
        entry.getValue();
        _fld1D2C.remove(obj);
        size = size - 1;
        _fld1D3E = _fld1D3E + 1;
        this;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void evictAll()
    {
        trimToSize(-1);
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        int i = hitCount + _fld1D41;
        if (i == 0) goto _L2; else goto _L1
_L1:
        i = (hitCount * 100) / i;
_L4:
        String s = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] {
            Integer.valueOf(_fld1D31), Integer.valueOf(hitCount), Integer.valueOf(_fld1D41), Integer.valueOf(i)
        });
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Object _mth02CA(Integer integer)
    {
        if (integer == null)
        {
            throw new NullPointerException("key == null");
        }
        this;
        JVM INSTR monitorenter ;
        integer = ((Integer) (_fld1D2C.get(integer)));
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        hitCount = hitCount + 1;
        this;
        JVM INSTR monitorexit ;
        return integer;
        _fld1D41 = _fld1D41 + 1;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        integer;
        throw integer;
_L1:
        return null;
    }

    public final Object _mth02CA(Integer integer, Object obj)
    {
        if (integer == null || obj == null)
        {
            throw new NullPointerException("key == null || value == null");
        }
        this;
        JVM INSTR monitorenter ;
        _fld1D32 = _fld1D32 + 1;
        size = size + 1;
        integer = ((Integer) (_fld1D2C.put(integer, obj)));
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        size = size - 1;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        integer;
        throw integer;
_L1:
        trimToSize(_fld1D31);
        return integer;
    }
}
