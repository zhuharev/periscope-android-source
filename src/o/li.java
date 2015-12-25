// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package o:
//            jd, mp, ig, mq, 
//            mt

final class li extends jd
{

    private final jd Gq;
    private final ig In;
    private final Type Io;

    li(ig ig1, jd jd1, Type type)
    {
        In = ig1;
        Gq = jd1;
        Io = type;
    }

    public final Object read(mq mq)
    {
        return Gq.read(mq);
    }

    public final void write(mt mt, Object obj)
    {
        jd jd1;
        Object obj1;
label0:
        {
            jd1 = Gq;
            Type type = Io;
            obj1 = type;
            if (obj == null)
            {
                break label0;
            }
            if (type != java/lang/Object && !(type instanceof TypeVariable))
            {
                obj1 = type;
                if (!(type instanceof Class))
                {
                    break label0;
                }
            }
            obj1 = obj.getClass();
        }
        if (obj1 != Io)
        {
            obj1 = In._mth02CA(new mp(((Type) (obj1))));
            jd1 = ((jd) (obj1));
            if (obj1 instanceof lc.if)
            {
                jd1 = ((jd) (obj1));
                if (!(Gq instanceof lc.if))
                {
                    jd1 = Gq;
                }
            }
        }
        jd1.write(mt, obj);
    }
}
