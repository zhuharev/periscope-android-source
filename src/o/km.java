// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Method;

// Referenced classes of package o:
//            kk

final class km extends kk
{

    private Method HE;
    private int HF;

    km(Method method, int i)
    {
        HE = method;
        HF = i;
        super();
    }

    public final Object _mth02BD(Class class1)
    {
        return HE.invoke(null, new Object[] {
            class1, Integer.valueOf(HF)
        });
    }
}
