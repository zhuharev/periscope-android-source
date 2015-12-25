// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.math.BigInteger;

// Referenced classes of package o:
//            auf, aug

public final class ym
{

    public final aug aVk;
    public final auf aVl;
    long aVm;
    public final long timestamp;

    public ym(auf auf1, long l)
    {
        timestamp = l;
        aVl = auf1;
        aVk = aVl.go();
    }

    public final long e()
    {
        BigInteger biginteger = aVl.gB();
        if (biginteger != null && BigInteger.ZERO.compareTo(biginteger) < 0)
        {
            return _cls141D.if._mth02CA(biginteger);
        } else
        {
            return _cls141D.if._mth02CA(aVl.gq());
        }
    }
}
