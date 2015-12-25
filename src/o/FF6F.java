// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.LinkedHashMap;
import java.util.Queue;

// Referenced classes of package o:
//            _cls2110, _cls1E3D, _cls1F35, _cls05D7, 
//            _cls0135, FF83

public final class FF6F
    implements _cls2110
{
    /* member class not found */
    class if {}


    private final _cls1F35 oR;

    public FF6F()
    {
        this(null);
    }

    public FF6F(_cls1F35 _pcls1f35)
    {
        oR = _pcls1f35;
    }

    public final FF83 _mth02CE(Object obj, int i, int j)
    {
        _cls1E3D _lcls1e3d = (_cls1E3D)obj;
        obj = _lcls1e3d;
        if (oR != null)
        {
            Object obj1 = oR;
            obj = _cls1F35.if._mth02CF(_lcls1e3d, 0, 0);
            obj1 = ((_cls05D7) (((_cls1F35) (obj1)).oM)).si.get(obj);
            _cls1F35.if.oO.offer(obj);
            obj1 = (_cls1E3D)obj1;
            obj = obj1;
            if (obj1 == null)
            {
                obj = oR;
                _cls1F35.if if1 = _cls1F35.if._mth02CF(_lcls1e3d, 0, 0);
                ((_cls1F35) (obj)).oM.put(if1, _lcls1e3d);
                obj = _lcls1e3d;
            }
        }
        return new _cls0135(((_cls1E3D) (obj)));
    }
}
