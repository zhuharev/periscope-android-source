// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceKeyParameters, McElieceParameters

public class McEliecePublicKeyParameters extends McElieceKeyParameters
{

    public String Xa;
    public int aJP;
    public GF2Matrix aMk;
    public int axg;

    public McEliecePublicKeyParameters(String s, int i, int j, GF2Matrix gf2matrix, McElieceParameters mcelieceparameters)
    {
        super(false, mcelieceparameters);
        Xa = s;
        axg = i;
        aJP = j;
        aMk = new GF2Matrix(gf2matrix);
    }
}
