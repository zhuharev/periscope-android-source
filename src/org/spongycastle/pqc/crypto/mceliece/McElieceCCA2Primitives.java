// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2Vector;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.Vector;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2PublicKeyParameters, McElieceCCA2PrivateKeyParameters

public final class McElieceCCA2Primitives
{

    private McElieceCCA2Primitives()
    {
    }

    public static GF2Vector _mth02CA(McElieceCCA2PublicKeyParameters mceliececca2publickeyparameters, GF2Vector gf2vector, GF2Vector gf2vector1)
    {
        return (GF2Vector)mceliececca2publickeyparameters.aLZ._mth02CE(gf2vector)._mth141D(gf2vector1);
    }

    public static GF2Vector[] _mth02CA(McElieceCCA2PrivateKeyParameters mceliececca2privatekeyparameters, GF2Vector gf2vector)
    {
        int i = mceliececca2privatekeyparameters.afK;
        Permutation permutation = mceliececca2privatekeyparameters.aLW;
        org.spongycastle.pqc.math.linearalgebra.GF2mField gf2mfield = mceliececca2privatekeyparameters.aLU;
        org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM polynomialgf2msmallm = mceliececca2privatekeyparameters.aLV;
        GF2Matrix gf2matrix = mceliececca2privatekeyparameters.aLX;
        mceliececca2privatekeyparameters = mceliececca2privatekeyparameters.aLY;
        gf2vector = (GF2Vector)gf2vector._mth02CB(permutation._mth1539());
        mceliececca2privatekeyparameters = GoppaCode._mth02CA((GF2Vector)gf2matrix._mth02CF(gf2vector), gf2mfield, polynomialgf2msmallm, mceliececca2privatekeyparameters);
        gf2vector = (GF2Vector)((GF2Vector)gf2vector._mth141D(mceliececca2privatekeyparameters))._mth02CB(permutation);
        mceliececca2privatekeyparameters = (GF2Vector)mceliececca2privatekeyparameters._mth02CB(permutation);
        return (new GF2Vector[] {
            gf2vector.FEE8(i), mceliececca2privatekeyparameters
        });
    }
}
