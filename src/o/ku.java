// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, jh, jd, mp, 
//            jm, kh, ig

public final class ku
    implements jf
{

    private final jm Gi;

    public ku(jm jm1)
    {
        Gi = jm1;
    }

    static jd _mth02CA(jm jm1, ig ig, mp mp1, jh jh1)
    {
        jh1 = jh1.value();
        if (o/jd.isAssignableFrom(jh1))
        {
            return (jd)jm1._mth02CB(new mp(jh1))._mth0725();
        }
        if (o/jf.isAssignableFrom(jh1))
        {
            return ((jf)jm1._mth02CB(new mp(jh1))._mth0725()).create(ig, mp1);
        } else
        {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
    }

    public final jd create(ig ig, mp mp1)
    {
        jh jh1 = (jh)mp1.Js.getAnnotation(o/jh);
        if (jh1 == null)
        {
            return null;
        } else
        {
            return _mth02CA(Gi, ig, mp1, jh1);
        }
    }
}
