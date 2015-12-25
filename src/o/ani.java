// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            anz, asm, adc

final class ani
    implements anz
{

    private asm btX;

    ani(asm asm1)
    {
        btX = asm1;
        super();
    }

    public final void _mth02CA(boolean flag, PsUser psuser)
    {
        if (flag)
        {
            btX._mth4E36(psuser.id);
            return;
        } else
        {
            btX.FBE6(psuser.id);
            return;
        }
    }

    public final void _mth02CE(PsUser psuser)
    {
        btX._mth1D65(new adc(psuser.id, null));
    }
}
