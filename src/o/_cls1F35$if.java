// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Queue;

// Referenced classes of package o:
//            _cls1F35, _cls0645

public static final class Object
{

    public static final Queue oO = _cls0645._mth1D5B(0);
    private int height;
    private Object js;
    private int width;

    public static Object _mth02CF(Object obj, int i, int j)
    {
        Object obj2 = (Object)oO.poll();
        Object obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = new <init>();
        }
        obj1.js = obj;
        obj1.width = i;
        obj1.height = j;
        return obj1;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Object)
        {
            obj = (Object)obj;
            return width == ((width) (obj)).width && height == ((height) (obj)).height && js.equals(((Object) (obj)).js);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return (height * 31 + width) * 31 + js.hashCode();
    }


    private Object()
    {
    }
}
