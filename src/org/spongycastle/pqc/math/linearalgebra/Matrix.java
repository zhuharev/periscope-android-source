// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


public abstract class Matrix
{

    protected int aOK;
    protected int numColumns;

    public Matrix()
    {
    }

    public final int getNumColumns()
    {
        return numColumns;
    }

    public final int getNumRows()
    {
        return aOK;
    }
}
