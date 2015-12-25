// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;


// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            Polynomial

public interface TernaryPolynomial
    extends Polynomial
{

    public abstract int size();

    public abstract int[] _mth15AB();

    public abstract int[] _mth15AD();
}
