// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.sql.Date;

// Referenced classes of package o:
//            jf, mp, le, ig, 
//            jd

final class lf
    implements jf
{

    lf()
    {
    }

    public final jd create(ig ig, mp mp1)
    {
        if (mp1.Js == java/sql/Date)
        {
            return new le();
        } else
        {
            return null;
        }
    }
}
