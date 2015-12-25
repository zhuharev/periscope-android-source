// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2KeyParameters, McElieceCCA2Parameters

public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters
{

    public String Xa;
    public GF2mField aLU;
    public PolynomialGF2mSmallM aLV;
    public Permutation aLW;
    public GF2Matrix aLX;
    public PolynomialGF2mSmallM aLY[];
    public int afK;
    public int axg;

    public McElieceCCA2PrivateKeyParameters(String s, int i, int j, GF2mField gf2mfield, PolynomialGF2mSmallM polynomialgf2msmallm, Permutation permutation, GF2Matrix gf2matrix, 
            PolynomialGF2mSmallM apolynomialgf2msmallm[], McElieceCCA2Parameters mceliececca2parameters)
    {
        super(true, mceliececca2parameters);
        Xa = s;
        axg = i;
        afK = j;
        aLU = gf2mfield;
        aLV = polynomialgf2msmallm;
        aLW = permutation;
        aLX = gf2matrix;
        aLY = apolynomialgf2msmallm;
    }
}
