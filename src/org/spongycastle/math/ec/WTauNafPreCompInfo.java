// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            PreCompInfo

public class WTauNafPreCompInfo
    implements PreCompInfo
{

    private ECPoint.F2m aJg[];

    public WTauNafPreCompInfo()
    {
        aJg = null;
    }

    public final void _mth02CA(ECPoint.F2m af2m[])
    {
        aJg = af2m;
    }

    public final ECPoint.F2m[] _mth0421()
    {
        return aJg;
    }
}
