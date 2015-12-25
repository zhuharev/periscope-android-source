// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            jf, mp, ig, jd

final class md
    implements jf
{

    md()
    {
    }

    public final jd create(ig ig, mp mp1)
    {
        mp1 = mp1.Js;
        if (!java/lang/Enum.isAssignableFrom(mp1) || mp1 == java/lang/Enum)
        {
            return null;
        }
        ig = mp1;
        if (!mp1.isEnum())
        {
            ig = mp1.getSuperclass();
        }
        return new lj.if(ig);
    }
}
