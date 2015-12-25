// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.util.io.pem;


public class PemHeader
{

    public boolean equals(Object obj)
    {
        if (!(obj instanceof PemHeader))
        {
            return false;
        } else
        {
            if ((PemHeader)obj == this);
            return true;
        }
    }

    public int hashCode()
    {
        return 32;
    }
}
