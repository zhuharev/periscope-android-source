// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, mp, jd, ig

final class mf
    implements jf
{

    private jd Jk;
    private Class Jl;
    private Class Jm;

    mf(Class class1, Class class2, jd jd)
    {
        Jl = class1;
        Jm = class2;
        Jk = jd;
        super();
    }

    public final jd create(ig ig, mp mp1)
    {
        ig = mp1.Js;
        if (ig == Jl || ig == Jm)
        {
            return Jk;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(Jm.getName()).append("+").append(Jl.getName()).append(",adapter=").append(Jk).append("]").toString();
    }
}
