// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yu, zs, zp

public final class zq extends yu
{

    private final String aUN = "";
    public final zp.if aWU;
    public zs aWV;

    public zq(zp zp1)
    {
        super(zp1);
        aWV = zs.aWX;
        aWU = new zp.if(aWV);
    }

    public final String id()
    {
        return null;
    }

    public final int v()
    {
        return mUserManager._mth02CA(aUN, aWV) + 1;
    }

    public final Object _mth1D4A(int i)
    {
        if (i == 0)
        {
            return aWU;
        } else
        {
            return mUserManager._mth02CA(aWV, aUN, i - 1);
        }
    }
}
