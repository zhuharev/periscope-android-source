// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package o:
//            _cls06BA, _cls13A8, _cls0673, _cls0E43

public final class _cls0E23
    implements _cls06BA
{
    /* member class not found */
    class if {}


    private static final android.graphics.Bitmap.Config nB;
    private final _cls0E43 nC;
    private final Set nD;
    private final int nE;
    private final if nF;
    private int nG;
    private int nH;
    private int nI;
    private int nJ;
    private int nK;
    private int _fld1D31;

    public _cls0E23(int i)
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            obj = new _cls13A8();
        } else
        {
            obj = new _cls0673();
        }
        HashSet hashset = new HashSet();
        hashset.addAll(Arrays.asList(android.graphics.Bitmap.Config.values()));
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            hashset.add(null);
        }
        this(i, ((_cls0E43) (obj)), Collections.unmodifiableSet(hashset));
    }

    private _cls0E23(int i, _cls0E43 _pcls0e43, Set set)
    {
        nE = i;
        _fld1D31 = i;
        nC = _pcls0e43;
        nD = set;
        nF = new if((byte)0);
    }

    private void trimToSize(int i)
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        Bitmap bitmap;
        if (nG <= i)
        {
            break; /* Loop/switch isn't completed */
        }
        bitmap = nC._mth1D47();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (Log.isLoggable("LruBitmapPool", 5))
        {
            Log.w("LruBitmapPool", "Size mismatch, resetting");
            _mth1E5B();
        }
        nG = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        nG = nG - nC._mth02BC(bitmap);
        bitmap.recycle();
        nK = nK + 1;
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", (new StringBuilder("Evicting bitmap=")).append(nC._mth02BB(bitmap)).toString());
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            _mth1E5B();
        }
        if (true) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void _mth1E5B()
    {
        Log.v("LruBitmapPool", (new StringBuilder("Hits=")).append(nH).append(", misses=").append(nI).append(", puts=").append(nJ).append(", evictions=").append(nK).append(", currentSize=").append(nG).append(", maxSize=").append(_fld1D31).append("\nStrategy=").append(nC).toString());
    }

    public final Bitmap _mth02BB(int i, int j, android.graphics.Bitmap.Config config)
    {
        this;
        JVM INSTR monitorenter ;
        _cls0E43 _lcls0e43 = nC;
        Object obj;
        if (config != null)
        {
            obj = config;
            break MISSING_BLOCK_LABEL_23;
        }
        obj = nB;
        obj = _lcls0e43._mth02CB(i, j, ((android.graphics.Bitmap.Config) (obj)));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", (new StringBuilder("Missing bitmap=")).append(nC._mth02CE(i, j, config)).toString());
        }
        nI = nI + 1;
        break MISSING_BLOCK_LABEL_140;
        nH = nH + 1;
        nG = nG - nC._mth02BC(((Bitmap) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            ((Bitmap) (obj)).setHasAlpha(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder("Get bitmap=")).append(nC._mth02CE(i, j, config)).toString());
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            _mth1E5B();
        }
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
        config;
        throw config;
    }

    public final boolean _mth02BD(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        throw new NullPointerException("Bitmap must not be null");
        if (bitmap.isMutable() && nC._mth02BC(bitmap) <= _fld1D31 && nD.contains(bitmap.getConfig()))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder("Reject bitmap from pool, bitmap: ")).append(nC._mth02BB(bitmap)).append(", is mutable: ").append(bitmap.isMutable()).append(", is allowed config: ").append(nD.contains(bitmap.getConfig())).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        int i = nC._mth02BC(bitmap);
        nC._mth141D(bitmap);
        nJ = nJ + 1;
        nG = nG + i;
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            Log.v("LruBitmapPool", (new StringBuilder("Put bitmap in pool=")).append(nC._mth02BB(bitmap)).toString());
        }
        if (Log.isLoggable("LruBitmapPool", 2))
        {
            _mth1E5B();
        }
        trimToSize(_fld1D31);
        this;
        JVM INSTR monitorexit ;
        return true;
        bitmap;
        throw bitmap;
    }

    public final Bitmap _mth02CB(int i, int j, android.graphics.Bitmap.Config config)
    {
        this;
        JVM INSTR monitorenter ;
        config = _mth02BB(i, j, config);
        if (config == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        config.eraseColor(0);
        this;
        JVM INSTR monitorexit ;
        return config;
        config;
        throw config;
    }

    public final void _mth14A1(int i)
    {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", (new StringBuilder("trimMemory, level=")).append(i).toString());
        }
        if (i >= 60)
        {
            if (Log.isLoggable("LruBitmapPool", 3))
            {
                Log.d("LruBitmapPool", "clearMemory");
            }
            trimToSize(0);
            return;
        }
        if (i >= 40)
        {
            trimToSize(_fld1D31 / 2);
        }
    }

    public final void _mth1E59()
    {
        if (Log.isLoggable("LruBitmapPool", 3))
        {
            Log.d("LruBitmapPool", "clearMemory");
        }
        trimToSize(0);
    }

    static 
    {
        nB = android.graphics.Bitmap.Config.ARGB_8888;
    }
}
