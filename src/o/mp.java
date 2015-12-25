// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// Referenced classes of package o:
//            jl

public final class mp
{

    public final Type Io;
    public final Class Js;
    private int hashCode;

    protected mp()
    {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        } else
        {
            Io = jl._mth02CA(((ParameterizedType)type).getActualTypeArguments()[0]);
            Js = jl.getRawType(Io);
            hashCode = Io.hashCode();
            return;
        }
    }

    public mp(Type type)
    {
        Io = jl._mth02CA((Type)_cls1D10.aux.checkNotNull(type));
        Js = jl.getRawType(Io);
        hashCode = Io.hashCode();
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof mp) && jl.equals(Io, ((mp)obj).Io);
    }

    public final int hashCode()
    {
        return hashCode;
    }

    public final String toString()
    {
        return jl.typeToString(Io);
    }
}
