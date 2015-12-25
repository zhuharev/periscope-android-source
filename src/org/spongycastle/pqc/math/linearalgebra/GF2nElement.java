// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GFElement, GF2nField

public abstract class GF2nElement
    implements GFElement
{

    protected GF2nField aOC;
    protected int aOD;

    public GF2nElement()
    {
    }

    public abstract Object clone();
}
