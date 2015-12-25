// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.sql.Timestamp;
import java.util.Date;

// Referenced classes of package o:
//            jf, mp, lz, ig, 
//            jd

final class ly
    implements jf
{

    ly()
    {
    }

    public final jd create(ig ig1, mp mp1)
    {
        if (mp1.Js != java/sql/Timestamp)
        {
            return null;
        } else
        {
            return new lz(this, ig1._mth02CA(new mp(java/util/Date)));
        }
    }
}
