// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            Matrix

public class GF2mMatrix extends Matrix
{

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2mMatrix))
        {
            return false;
        } else
        {
            obj = (GF2mMatrix)obj;
            throw new NullPointerException();
        }
    }

    public int hashCode()
    {
        throw new NullPointerException();
    }

    public String toString()
    {
        (new StringBuilder()).append(aOK).append(" x ").append(numColumns).append(" Matrix over ");
        throw new NullPointerException();
    }
}
