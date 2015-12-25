// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2Vector

public abstract class Vector
{

    protected int length;

    public Vector()
    {
    }

    public final int getLength()
    {
        return length;
    }

    public abstract GF2Vector _mth141D(GF2Vector gf2vector);
}
