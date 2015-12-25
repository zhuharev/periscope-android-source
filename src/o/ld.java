// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Field;

// Referenced classes of package o:
//            lc, li, mp, jd, 
//            ig, mt, mq

final class ld extends lc._cls02CA
{

    private jd Ib;
    private ig Ic;
    private Field Id;
    private mp Ie;
    private boolean If;
    private lc Ig;

    ld(lc lc1, String s, boolean flag, boolean flag1, ig ig, Field field, mp mp1, 
            boolean flag2)
    {
        Ig = lc1;
        Ic = ig;
        Id = field;
        Ie = mp1;
        If = flag2;
        super(s, flag, flag1);
        Ib = lc._mth02CA(Ig, Ic, Id, Ie);
    }

    final void write(mt mt, Object obj)
    {
        obj = Id.get(obj);
        (new li(Ic, Ib, Ie.Io)).write(mt, obj);
    }

    final void _mth02CA(mq mq, Object obj)
    {
        mq = ((mq) (Ib.read(mq)));
        if (mq != null || !If)
        {
            Id.set(obj, mq);
        }
    }

    public final boolean _mth1423(Object obj)
    {
        if (!Ii)
        {
            return false;
        }
        return Id.get(obj) != obj;
    }
}
