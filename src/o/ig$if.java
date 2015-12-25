// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jd, ig, mq, mt

static final class  extends jd
{

    jd Gq;

    public final Object read(mq mq)
    {
        if (Gq == null)
        {
            throw new IllegalStateException();
        } else
        {
            return Gq.read(mq);
        }
    }

    public final void write(mt mt, Object obj)
    {
        if (Gq == null)
        {
            throw new IllegalStateException();
        } else
        {
            Gq.write(mt, obj);
            return;
        }
    }

    ()
    {
    }
}
