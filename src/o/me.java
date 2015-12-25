// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, mp, jd, ig

final class me
    implements jf
{

    private Class Jj;
    private jd Jk;

    me(Class class1, jd jd)
    {
        Jj = class1;
        Jk = jd;
        super();
    }

    public final jd create(ig ig, mp mp1)
    {
        if (mp1.Js == Jj)
        {
            return Jk;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(Jj.getName()).append(",adapter=").append(Jk).append("]").toString();
    }
}
