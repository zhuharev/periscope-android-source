// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            AsymmetricKeyParameter, CramerShoupParameters

public class CramerShoupKeyParameters extends AsymmetricKeyParameter
{

    private CramerShoupParameters awR;

    protected CramerShoupKeyParameters(boolean flag, CramerShoupParameters cramershoupparameters)
    {
        super(flag);
        awR = cramershoupparameters;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof CramerShoupKeyParameters))
        {
            return false;
        }
        obj = (CramerShoupKeyParameters)obj;
        if (awR == null)
        {
            return ((CramerShoupKeyParameters) (obj)).awR == null;
        } else
        {
            return awR.equals(((CramerShoupKeyParameters) (obj)).awR);
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
        if (awR != null)
        {
            i = flag ^ awR.hashCode();
        }
        return i;
    }
}
