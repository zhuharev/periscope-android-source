// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, mp, jd, ig

final class mh
    implements jf
{

    private jd Jk;
    private Class Jn;
    private Class Jo;

    mh(Class class1, Class class2, jd jd)
    {
        Jn = class1;
        Jo = class2;
        Jk = jd;
        super();
    }

    public final jd create(ig ig, mp mp1)
    {
        ig = mp1.Js;
        if (ig == Jn || ig == Jo)
        {
            return Jk;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(Jn.getName()).append("+").append(Jo.getName()).append(",adapter=").append(Jk).append("]").toString();
    }
}
