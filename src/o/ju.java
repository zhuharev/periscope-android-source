// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

// Referenced classes of package o:
//            kh, ir, jm

final class ju
    implements kh
{

    private Type GR;
    private jm GS;

    ju(jm jm, Type type)
    {
        GS = jm;
        GR = type;
        super();
    }

    public final Object _mth0725()
    {
        if (GR instanceof ParameterizedType)
        {
            Type type = ((ParameterizedType)GR).getActualTypeArguments()[0];
            if (type instanceof Class)
            {
                return EnumSet.noneOf((Class)type);
            } else
            {
                throw new ir((new StringBuilder("Invalid EnumSet type: ")).append(GR.toString()).toString());
            }
        } else
        {
            throw new ir((new StringBuilder("Invalid EnumSet type: ")).append(GR.toString()).toString());
        }
    }
}
