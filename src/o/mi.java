// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, mp, jd, ig

final class mi
    implements jf
{

    private jd Jk;
    private Class Jp;

    mi(Class class1, jd jd)
    {
        Jp = class1;
        Jk = jd;
        super();
    }

    public final jd create(ig ig, mp mp1)
    {
        if (Jp.isAssignableFrom(mp1.Js))
        {
            return Jk;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[typeHierarchy=")).append(Jp.getName()).append(",adapter=").append(Jk).append("]").toString();
    }
}
