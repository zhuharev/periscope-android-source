// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x9;


// Referenced classes of package org.spongycastle.asn1.x9:
//            X9ECParameters

public abstract class X9ECParametersHolder
{

    private X9ECParameters alt;

    public X9ECParametersHolder()
    {
    }

    public X9ECParameters getParameters()
    {
        if (alt == null)
        {
            alt = _mth098C();
        }
        return alt;
    }

    public abstract X9ECParameters _mth098C();
}
