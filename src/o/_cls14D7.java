// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

// Referenced classes of package o:
//            _cls14FA, _cls1D3C, _cls14DA, _cls01AC, 
//            _cls30CE, _cls1D5A, _cls1D33, _cls1D2E, 
//            _cls0287, _cls4EA0, _cls148D

final class _cls14D7
{
    /* member class not found */
    class if {}

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    final Handler handler;
    boolean pI;
    final _cls02CA pU;
    private final _cls30CE pV;
    boolean pW;
    _cls1D2E pX;
    if pY;
    boolean pZ;

    public _cls14D7(Context context, _cls148D _pcls148d, _cls30CE _pcls30ce, int i, int j)
    {
        _cls14FA _lcls14fa = new _cls14FA(_cls1D3C._mth0640(context).je);
        Object obj = new _cls14DA();
        _cls01AC _lcls01ac = _cls01AC._mth1FD1();
        context = new _cls1D5A.if.if(new _cls1D5A.if(_cls1D3C._mth1427(context), ((_cls2110) (obj)), o/30CE), _pcls30ce);
        obj = ((_cls1D5A.if.if) (context)).ki.kg.jm;
        obj = (_cls1D33)new _cls1D33(((_cls1D5A.if.if) (context)).ki.kg.context, ((_cls1D5A.if.if) (context)).ki.kg.jl, ((_cls1D5A.if.if) (context)).jn, ((_cls1D5A.if.if) (context)).ki.jG, ((_cls1D5A.if.if) (context)).ki.jH, android/graphics/Bitmap, ((_cls1D5A.if.if) (context)).ki.kg.jp, ((_cls1D5A.if.if) (context)).ki.kg.jq, ((_cls1D5A.if.if) (context)).ki.kg.jm);
        ((_cls1D33) (obj)).FE7A(((_cls1D5A.if.if) (context)).js);
        this(((_cls02CA) (_pcls148d)), _pcls30ce, null, ((_cls1D33) (obj))._mth02CA(_lcls01ac)._mth02CA(_lcls14fa)._mth02B4(true)._mth02CA(_cls0287.mt)._mth02C6(i, j));
    }

    private _cls14D7(_cls02CA _pcls02ca, _cls30CE _pcls30ce, Handler handler1, _cls1D2E _pcls1d2e)
    {
        pI = false;
        pW = false;
        handler1 = new Handler(Looper.getMainLooper(), new _cls02CB((byte)0));
        pU = _pcls02ca;
        pV = _pcls30ce;
        handler = handler1;
        pX = _pcls1d2e;
    }

    void FE9C()
    {
        if (!pI || pW)
        {
            return;
        }
        pW = true;
        Object obj = pV;
        obj.kB = (((_cls30CE) (obj)).kB + 1) % ((_cls30CE) (obj)).kC.frameCount;
        long l = SystemClock.uptimeMillis();
        obj = pV;
        int i;
        if (((_cls30CE) (obj)).kC.frameCount <= 0 || ((_cls30CE) (obj)).kB < 0)
        {
            i = -1;
        } else
        {
            i = ((_cls30CE) (obj))._mth0E40(((_cls30CE) (obj)).kB);
        }
        long l1 = i;
        obj = new if(handler, pV.kB, l + l1);
        pX._mth02CA(new _cls02CE())._mth02CA(((_cls044C) (obj)));
    }
}
