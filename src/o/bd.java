// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Bundle;

// Referenced classes of package o:
//            bb, ba

public final class bd
    implements bb.if
{

    private bb zA;
    private Bundle zB;

    public bd(bb bb1, Bundle bundle)
    {
        zA = bb1;
        zB = bundle;
        super();
    }

    public final int getState()
    {
        return 1;
    }

    public final void _mth1604()
    {
        zA.zw.onCreate(zB);
    }
}
