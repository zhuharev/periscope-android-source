// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.UUID;

// Referenced classes of package o:
//            of

abstract class oo extends of
{

    public oo(String s, String s1, String s2, String s3, boolean flag)
    {
        super(s, s1, s2, s3, flag);
    }

    public String _mth1F35()
    {
        return UUID.randomUUID().toString();
    }
}
