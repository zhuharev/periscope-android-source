// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;


// Referenced classes of package org.spongycastle.math.ec:
//            ECPointMap, ECPoint, ECFieldElement

public class ScaleXPointMap
    implements ECPointMap
{

    private ECFieldElement aIT;

    public ScaleXPointMap(ECFieldElement ecfieldelement)
    {
        aIT = ecfieldelement;
    }

    public final ECPoint _mth02BC(ECPoint ecpoint)
    {
        return ecpoint._mth02BD(aIT);
    }
}
