// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;

// Referenced classes of package o:
//            _cls13D0, _cls14A9, _cls1501, _cls1D66, 
//            FEAE

public final class _cls14F7
    implements _cls13D0
{

    private static _cls14F7 oa = null;
    private final File directory;
    private final _cls14A9 ob = new _cls14A9();
    private final _cls1501 oc = new _cls1501();
    private _cls1D66 od;
    private final int _fld1D31;

    private _cls14F7(File file, int i)
    {
        directory = file;
        _fld1D31 = i;
    }

    public static _cls14F7 _mth02CA(File file, int i)
    {
        o/14F7;
        JVM INSTR monitorenter ;
        if (oa == null)
        {
            oa = new _cls14F7(file, i);
        }
        file = oa;
        o/14F7;
        JVM INSTR monitorexit ;
        return file;
        file;
        throw file;
    }

    private _cls1D66 _mth1F76()
    {
        this;
        JVM INSTR monitorenter ;
        _cls1D66 _lcls1d66;
        if (od == null)
        {
            od = _cls1D66._mth02CA(directory, 1, 1, _fld1D31);
        }
        _lcls1d66 = od;
        this;
        JVM INSTR monitorexit ;
        return _lcls1d66;
        Exception exception;
        exception;
        throw exception;
    }

    public final void _mth02CA(FEAE feae, _cls026B._cls02CB _pcls02cb)
    {
        String s = oc._mth02BD(feae);
        _cls14A9 _lcls14a9 = ob;
        _lcls14a9;
        JVM INSTR monitorenter ;
        _cls14A9.if if1 = (_cls14A9.if)_lcls14a9.nV.get(feae);
        Object obj;
        obj = if1;
        if (if1 != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = _lcls14a9.nW._mth1F30();
        _lcls14a9.nV.put(feae, obj);
        obj.nY = ((_cls14A9.if) (obj)).nY + 1;
        _lcls14a9;
        JVM INSTR monitorexit ;
          goto _L1
        feae;
        throw feae;
_L1:
        ((_cls14A9.if) (obj)).nX.lock();
        obj = _mth1F76()._mth02CA(s, -1L);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        if (_pcls02cb._mth02CF(((_cls1D66.if) (obj))._mth06E6(0)))
        {
            ((_cls1D66.if) (obj)).km._mth02CA(((_cls1D66.if) (obj)), true);
            obj.committed = true;
        }
        ((_cls1D66.if) (obj)).abortUnlessCommitted();
        break MISSING_BLOCK_LABEL_155;
        _pcls02cb;
        try
        {
            ((_cls1D66.if) (obj)).abortUnlessCommitted();
            throw _pcls02cb;
        }
        // Misplaced declaration of an exception variable
        catch (_cls026B._cls02CB _pcls02cb) { }
        finally
        {
            ob._mth02BB(feae);
        }
        break MISSING_BLOCK_LABEL_165;
        ob._mth02BB(feae);
        return;
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
        {
            Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", _pcls02cb);
        }
        ob._mth02BB(feae);
        return;
    }

    public final File _mth02CF(FEAE feae)
    {
        Object obj = oc._mth02BD(feae);
        feae = null;
        try
        {
            obj = _mth1F76()._mth02C8(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (FEAE feae)
        {
            if (Log.isLoggable("DiskLruCacheWrapper", 5))
            {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", feae);
            }
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        feae = ((_cls1D66._cls02CB) (obj)).kp[0];
        return feae;
    }

    public final void _mth141D(FEAE feae)
    {
        feae = oc._mth02BD(feae);
        try
        {
            _mth1F76().remove(feae);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FEAE feae) { }
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
        {
            Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", feae);
        }
    }

}
