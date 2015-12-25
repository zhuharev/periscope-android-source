// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, ig, mq, mt, 
//            mp, jz

final class ka extends jd
{

    private jd Gq;
    private boolean Hd;
    private boolean He;
    private ig Hf;
    private mp Hg;
    private jz Hh;

    ka(jz jz, boolean flag, boolean flag1, ig ig1, mp mp)
    {
        Hh = jz;
        Hd = flag;
        He = flag1;
        Hf = ig1;
        Hg = mp;
        super();
    }

    private jd _mth0698()
    {
        jd jd1 = Gq;
        if (jd1 != null)
        {
            return jd1;
        } else
        {
            jd jd2 = Hf._mth02CA(Hh, Hg);
            Gq = jd2;
            return jd2;
        }
    }

    public final Object read(mq mq1)
    {
        if (Hd)
        {
            mq1.skipValue();
            return null;
        } else
        {
            return _mth0698().read(mq1);
        }
    }

    public final void write(mt mt1, Object obj)
    {
        if (He)
        {
            mt1._mth14F7();
            return;
        } else
        {
            _mth0698().write(mt1, obj);
            return;
        }
    }
}
