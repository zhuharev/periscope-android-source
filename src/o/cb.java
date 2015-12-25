// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package o:
//            bx

final class cb extends cd._cls02CA
{

    private ConnectionResult AW;
    private bx._cls02CF AX;

    cb(bx._cls02CF _pcls02cf, bx bx1, ConnectionResult connectionresult)
    {
        AX = _pcls02cf;
        AW = connectionresult;
        super(bx1);
    }

    public final void _mth216C()
    {
        AX.AM._mth02BC(AW);
    }
}
