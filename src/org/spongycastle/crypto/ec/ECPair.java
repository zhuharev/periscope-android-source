// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.ec;

import org.spongycastle.math.ec.ECPoint;

public class ECPair
{

    private final ECPoint apI;
    private final ECPoint apJ;

    public boolean equals(Object obj)
    {
        if (obj instanceof ECPair)
        {
            obj = (ECPair)obj;
            return ((ECPair) (obj)).apI._mth02CF(apI) && ((ECPair) (obj)).apJ._mth02CF(apJ);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return apI.hashCode() + apJ.hashCode() * 37;
    }
}
