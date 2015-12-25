// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceCCA2KeyParameters, McElieceCCA2Parameters

public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters
{

    public String Xa;
    public int aJP;
    public GF2Matrix aLZ;
    public int axg;

    public McElieceCCA2PublicKeyParameters(String s, int i, int j, GF2Matrix gf2matrix, McElieceCCA2Parameters mceliececca2parameters)
    {
        super(false, mceliececca2parameters);
        Xa = s;
        axg = i;
        aJP = j;
        aLZ = new GF2Matrix(gf2matrix);
    }
}
