// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            AsymmetricKeyParameter, DHParameters

public class DHKeyParameters extends AsymmetricKeyParameter
{

    public DHParameters axb;

    protected DHKeyParameters(boolean flag, DHParameters dhparameters)
    {
        super(flag);
        axb = dhparameters;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DHKeyParameters))
        {
            return false;
        }
        obj = (DHKeyParameters)obj;
        if (axb == null)
        {
            return ((DHKeyParameters) (obj)).axb == null;
        } else
        {
            return axb.equals(((DHKeyParameters) (obj)).axb);
        }
    }

    public int hashCode()
    {
        boolean flag;
        if (super.awQ)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        int i = ((flag) ? 1 : 0);
        if (axb != null)
        {
            i = flag ^ axb.hashCode();
        }
        return i;
    }
}
