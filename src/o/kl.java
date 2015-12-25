// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Method;

// Referenced classes of package o:
//            kk

final class kl extends kk
{

    private Method HC;
    private Object HD;

    kl(Method method, Object obj)
    {
        HC = method;
        HD = obj;
        super();
    }

    public final Object _mth02BD(Class class1)
    {
        return HC.invoke(HD, new Object[] {
            class1
        });
    }
}
