// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceKeyParameters, McElieceParameters

public class McEliecePrivateKeyParameters extends McElieceKeyParameters
{

    public String Xa;
    public GF2mField aLU;
    public PolynomialGF2mSmallM aLV;
    public GF2Matrix aLX;
    public PolynomialGF2mSmallM aLY[];
    public GF2Matrix aMh;
    public Permutation aMi;
    public Permutation aMj;
    public int afK;
    public int axg;

    public McEliecePrivateKeyParameters(String s, int i, int j, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, GF2Matrix gf2matrix, Permutation permutation, 
            Permutation permutation1, GF2Matrix gf2matrix1, PolynomialGF2mSmallM apolynomialgf2msmallm[], McElieceParameters mcelieceparameters)
    {
        super(true, mcelieceparameters);
        Xa = s;
        afK = j;
        axg = i;
        aLU = gf2mfield;
        aLV = polynomialgf2msmallm;
        aMh = gf2matrix;
        aMi = permutation;
        aMj = permutation1;
        aLX = gf2matrix1;
        aLY = apolynomialgf2msmallm;
    }
}
