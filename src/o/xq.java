// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.SurfaceTexture;
import tv.periscope.android.util.Size;

// Referenced classes of package o:
//            xm, aax, aav, _cls0675

final class xq
    implements aar._cls02CB
{

    private xm aTI;
    private SurfaceTexture aTK;

    xq(xm xm1, SurfaceTexture surfacetexture)
    {
        aTI = xm1;
        aTK = surfacetexture;
        super();
    }

    public final void FB8C()
    {
        Object obj1;
        if (xm._mth02CE(aTI)._mth1D54(aTK.getTimestamp()))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        obj1 = xm._mth141D(aTI);
        Object obj = ((aax) (obj1)).bbE;
        obj;
        JVM INSTR monitorenter ;
        ((aax) (obj1)).bbE.updateTexImage();
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_99;
        Exception exception;
        exception;
        throw exception;
        int i = xm._mth02BC(aTI).orientation;
        xm._mth141D(aTI)._mth02CA(Size._mth05D5(xm._mth02BD(aTI).bac, xm._mth02BD(aTI)._fld0575), i);
        obj = xm._mth037A(aTI);
        if (((aav) (obj)).baN == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        exception = ((aav) (obj)).baN;
        obj = aav.V();
        obj;
        JVM INSTR monitorenter ;
        exception.bbt = true;
        aav.V().notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public final void FB90()
    {
        _cls0675._mth02CB(new RuntimeException("Dropped frame, failed to acquire video context."));
    }
}
