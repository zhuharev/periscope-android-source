// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package o:
//            hr

final class hv
    implements Runnable
{

    private String FR;
    private hr FS;
    private ht.if FT;
    private String FU;

    hv(ht.if if1, String s, String s1, hr hr1)
    {
        FT = if1;
        FR = s;
        FU = s1;
        FS = hr1;
        super();
    }

    public final void run()
    {
        try
        {
            boolean flag = ht.if._mth02CA(FT)._mth02CC();
            FS._mth1D57(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", remoteexception);
        }
    }
}
