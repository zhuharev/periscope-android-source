// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;

// Referenced classes of package o:
//            FF6B, _cls1EF4, rz, ra, 
//            rl, ve, _cls0534, _cls050F

final class _cls010D
    implements Runnable
{

    private FF6B uQ;
    private File uS;

    _cls010D(FF6B ff6b, File file)
    {
        uQ = ff6b;
        uS = file;
        super();
    }

    public final void run()
    {
        if (rz._mth14BD(FF6B._mth02BB(uQ).getContext()))
        {
            ra._mth0454()._mth02BE("CrashlyticsCore", "Attempting to send crash report at time of crash...");
            Object obj = ve.if._mth2148()._mth1F3B();
            obj = FF6B._mth02BB(uQ)._mth02CA(((vh) (obj)));
            if (obj != null)
            {
                (new _cls0534(((_cls02AD) (obj))))._mth02CA(new _cls050F(uS, FF6B._mth217D()));
            }
        }
    }
}
