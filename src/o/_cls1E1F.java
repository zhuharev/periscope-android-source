// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package o:
//            _cls1E39, _cls2110, _cls3031

public final class _cls1E1F
{

    private static final _cls1E39 oy = new _cls1E39();
    private final Context context;
    private final HashMap ow = new HashMap();
    private final HashMap ox = new HashMap();

    public _cls1E1F(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private void _mth02CA(Class class1, Class class2, _cls2110 _pcls2110)
    {
        Map map = (Map)ox.get(class1);
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            ox.put(class1, obj);
        }
        ((Map) (obj)).put(class2, _pcls2110);
    }

    public final _cls2110 _mth02CA(Class class1, Class class2)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = (Map)ox.get(class1);
        Object obj;
        obj = null;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = (_cls2110)((Map) (obj1)).get(class2);
        _cls2110 _lcls2110;
        _lcls2110 = ((_cls2110) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        if (oy.equals(_lcls2110))
        {
            return null;
        }
        this;
        JVM INSTR monitorexit ;
        return _lcls2110;
        obj1 = (Map)ow.get(class1);
        obj = null;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = (_cls3031)((Map) (obj1)).get(class2);
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L1
_L1:
        Iterator iterator = ow.keySet().iterator();
_L9:
        obj1 = obj;
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj2 = (Class)iterator.next();
        obj1 = obj;
        if (!((Class) (obj2)).isAssignableFrom(class1)) goto _L5; else goto _L4
_L4:
        obj2 = (Map)ow.get(obj2);
        obj1 = obj;
        if (obj2 == null) goto _L5; else goto _L6
_L6:
        obj = (_cls3031)((Map) (obj2)).get(class2);
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L7
_L7:
        obj1 = obj;
          goto _L5
_L2:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        _lcls2110 = ((_cls3031) (obj1))._mth02CA(context, this);
        _mth02CA(class1, class2, _lcls2110);
        break MISSING_BLOCK_LABEL_245;
        _mth02CA(class1, class2, ((_cls2110) (oy)));
        this;
        JVM INSTR monitorexit ;
        return _lcls2110;
        class1;
        throw class1;
_L5:
        obj = obj1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final _cls3031 _mth02CA(Class class1, Class class2, _cls3031 _pcls3031)
    {
        this;
        JVM INSTR monitorenter ;
        Map map;
        ox.clear();
        map = (Map)ow.get(class1);
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new HashMap();
        ow.put(class1, obj);
        class2 = (_cls3031)((Map) (obj)).put(class2, _pcls3031);
        class1 = class2;
        if (class2 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        _pcls3031 = ow.values().iterator();
_L2:
        class1 = class2;
        boolean flag;
        if (!_pcls3031.hasNext())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        flag = ((Map)_pcls3031.next()).containsValue(class2);
        if (!flag) goto _L2; else goto _L1
_L1:
        class1 = null;
        return class1;
        class1;
        throw class1;
    }

}
