// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

// Referenced classes of package o:
//            _cls1435, dp, _cls0E44

public class do extends _cls1435
{

    private final String DA;
    protected final dp DB = new dp(this);

    public do(Context context, Looper looper, _cls09AA._cls02CA _pcls02ca, _cls09AA._cls02CB _pcls02cb, String s, _cls0E44 _pcls0e44)
    {
        super(context, looper, 23, _pcls0e44, _pcls02ca, _pcls02cb);
        DA = s;
    }

    static void _mth02CA(do do1)
    {
        if (!do1.isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    protected final IInterface _mth02CA(IBinder ibinder)
    {
        return dz.if._mth037A(ibinder);
    }

    protected final String _mth03C4()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String _mth0413()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected final Bundle _mth05DC()
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", DA);
        return bundle;
    }
}
