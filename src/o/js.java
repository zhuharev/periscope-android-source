// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package o:
//            kh, jm

final class js
    implements kh
{

    private jm GS;
    private Constructor GW;

    js(jm jm, Constructor constructor)
    {
        GS = jm;
        GW = constructor;
        super();
    }

    public final Object _mth0725()
    {
        Object obj;
        try
        {
            obj = GW.newInstance(null);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RuntimeException((new StringBuilder("Failed to invoke ")).append(GW).append(" with no args").toString(), instantiationexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RuntimeException((new StringBuilder("Failed to invoke ")).append(GW).append(" with no args").toString(), invocationtargetexception.getTargetException());
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new AssertionError(illegalaccessexception);
        }
        return obj;
    }
}
