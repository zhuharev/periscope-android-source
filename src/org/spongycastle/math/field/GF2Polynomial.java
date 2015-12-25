// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.field;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.math.field:
//            Polynomial

class GF2Polynomial
    implements Polynomial
{

    private int aJF[];

    GF2Polynomial(int ai[])
    {
        aJF = Arrays._mth02D1(ai);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof GF2Polynomial))
        {
            return false;
        } else
        {
            obj = (GF2Polynomial)obj;
            return Arrays._mth1427(aJF, ((GF2Polynomial) (obj)).aJF);
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(aJF);
    }

    public final int _mth0575()
    {
        return aJF[aJF.length - 1];
    }

    public final int[] _mth0578()
    {
        return Arrays._mth02D1(aJF);
    }
}
