// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Method;

// Referenced classes of package o:
//            qx

final class qu
{

    final qx Qk;
    final Class Ql;
    String Qm;
    final Method method;

    qu(Method method1, qx qx, Class class1)
    {
        method = method1;
        Qk = qx;
        Ql = class1;
    }

    private void _mth044D()
    {
        this;
        JVM INSTR monitorenter ;
        if (Qm == null)
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append(method.getDeclaringClass().getName());
            stringbuilder.append('#').append(method.getName());
            stringbuilder.append('(').append(Ql.getName());
            Qm = stringbuilder.toString();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof qu)
        {
            _mth044D();
            obj = (qu)obj;
            ((qu) (obj))._mth044D();
            return Qm.equals(((qu) (obj)).Qm);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return method.hashCode();
    }
}
