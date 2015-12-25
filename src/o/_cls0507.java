// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.security.MessageDigest;

// Referenced classes of package o:
//            FEAE

final class _cls0507
    implements FEAE
{

    private final String id;
    private final FEAE jt;

    public _cls0507(String s, FEAE feae)
    {
        id = s;
        jt = feae;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (_cls0507)obj;
        if (!id.equals(((_cls0507) (obj)).id))
        {
            return false;
        }
        return jt.equals(((_cls0507) (obj)).jt);
    }

    public final int hashCode()
    {
        return id.hashCode() * 31 + jt.hashCode();
    }

    public final void _mth02CA(MessageDigest messagedigest)
    {
        messagedigest.update(id.getBytes("UTF-8"));
        jt._mth02CA(messagedigest);
    }
}
