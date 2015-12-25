// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, mq, ms, kc, 
//            iy, mt

final class lm extends jd
{

    lm()
    {
    }

    public final Object read(mq mq1)
    {
        ms ms1 = mq1._mth13A2();
        switch (lj._cls1.HZ[ms1.ordinal()])
        {
        case 4: // '\004'
            mq1.nextNull();
            return null;

        case 1: // '\001'
            return new kc(mq1.nextString());
        }
        throw new iy((new StringBuilder("Expecting number, got: ")).append(ms1).toString());
    }

    public final void write(mt mt1, Object obj)
    {
        mt1._mth02CA((Number)obj);
    }
}
