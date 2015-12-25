// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            PreCompInfo, ECPoint

public class WNafPreCompInfo
    implements PreCompInfo
{

    private ECPoint aIM[];
    private ECPoint aJd[];
    private ECPoint aJe;

    public WNafPreCompInfo()
    {
        aIM = null;
        aJd = null;
        aJe = null;
    }

    public final void _mth02BD(ECPoint ecpoint)
    {
        aJe = ecpoint;
    }

    public final void _mth02CB(ECPoint aecpoint[])
    {
        aIM = aecpoint;
    }

    public final void _mth02CE(ECPoint aecpoint[])
    {
        aJd = aecpoint;
    }

    public final ECPoint[] _mth03D9()
    {
        return aIM;
    }

    public final ECPoint[] _mth03F5()
    {
        return aJd;
    }

    public final ECPoint _mth03F9()
    {
        return aJe;
    }
}
