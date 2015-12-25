// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.GenericArrayType;

// Referenced classes of package o:
//            jf, mp, jl, kp, 
//            ig, jd

final class kq
    implements jf
{

    kq()
    {
    }

    public final jd create(ig ig1, mp mp1)
    {
        mp1 = mp1.Io;
        if (!(mp1 instanceof GenericArrayType) && (!(mp1 instanceof Class) || !((Class)mp1).isArray()))
        {
            return null;
        } else
        {
            mp1 = jl._mth02CB(mp1);
            return new kp(ig1, ig1._mth02CA(new mp(mp1)), jl.getRawType(mp1));
        }
    }
}
