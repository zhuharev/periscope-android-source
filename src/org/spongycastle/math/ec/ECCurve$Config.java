// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.math.ec;

import org.spongycastle.math.ec.endo.ECEndomorphism;
import org.spongycastle.math.ec.endo.GLVTypeBEndomorphism;

// Referenced classes of package org.spongycastle.math.ec:
//            ECCurve, ECMultiplier

public class aIx
{

    private int aIv;
    private ECEndomorphism aIw;
    private ECMultiplier aIx;
    private ECCurve aIy;

    public final domorphism _mth02CA(GLVTypeBEndomorphism glvtypebendomorphism)
    {
        aIw = glvtypebendomorphism;
        return this;
    }

    public final aIw _mth0E32(int i)
    {
        aIv = i;
        return this;
    }

    public final ECCurve FEA7()
    {
        if (!aIy._mth071D(aIv))
        {
            throw new IllegalStateException("unsupported coordinate system");
        }
        ECCurve eccurve = aIy._mth30FE();
        if (eccurve == aIy)
        {
            throw new IllegalStateException("implementation returned current curve");
        } else
        {
            eccurve.aIv = aIv;
            eccurve.aIw = aIw;
            eccurve.aIx = aIx;
            return eccurve;
        }
    }

    hism(ECCurve eccurve, int i, ECEndomorphism ecendomorphism, ECMultiplier ecmultiplier)
    {
        aIy = eccurve;
        super();
        aIv = i;
        aIw = ecendomorphism;
        aIx = ecmultiplier;
    }
}
