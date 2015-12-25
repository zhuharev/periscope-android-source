// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            PreCompInfo, ECPoint

public class FixedPointPreCompInfo
    implements PreCompInfo
{

    private ECPoint aIM[];
    private int width;

    public FixedPointPreCompInfo()
    {
        aIM = null;
        width = -1;
    }

    public final int getWidth()
    {
        return width;
    }

    public final void setWidth(int i)
    {
        width = i;
    }

    public final void _mth02CB(ECPoint aecpoint[])
    {
        aIM = aecpoint;
    }

    public final ECPoint[] _mth03D9()
    {
        return aIM;
    }
}
