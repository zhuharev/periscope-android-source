// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import org.spongycastle.math.field.FiniteFields;

// Referenced classes of package org.spongycastle.math.ec:
//            ECCurve

public static abstract class  extends ECCurve
{

    protected ExtensionField(int i, int j, int k, int l)
    {
        if (j == 0)
        {
            throw new IllegalArgumentException("k1 must be > 0");
        }
        org.spongycastle.math.field.GenericPolynomialExtensionField genericpolynomialextensionfield;
        if (k == 0)
        {
            if (l != 0)
            {
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            }
            genericpolynomialextensionfield = FiniteFields._mth1FBE(new int[] {
                0, j, i
            });
        } else
        {
            if (k <= j)
            {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (l <= k)
            {
                throw new IllegalArgumentException("k3 must be > k2");
            }
            genericpolynomialextensionfield = FiniteFields._mth1FBE(new int[] {
                0, j, k, l, i
            });
        }
        super(genericpolynomialextensionfield);
    }
}
