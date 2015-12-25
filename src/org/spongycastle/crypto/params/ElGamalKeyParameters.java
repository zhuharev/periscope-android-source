// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            AsymmetricKeyParameter, ElGamalParameters

public class ElGamalKeyParameters extends AsymmetricKeyParameter
{

    public ElGamalParameters axl;

    protected ElGamalKeyParameters(boolean flag, ElGamalParameters elgamalparameters)
    {
        super(flag);
        axl = elgamalparameters;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ElGamalKeyParameters))
        {
            return false;
        }
        obj = (ElGamalKeyParameters)obj;
        if (axl == null)
        {
            return ((ElGamalKeyParameters) (obj)).axl == null;
        } else
        {
            return axl.equals(((ElGamalKeyParameters) (obj)).axl);
        }
    }

    public int hashCode()
    {
        if (axl != null)
        {
            return axl.hashCode();
        } else
        {
            return 0;
        }
    }
}
