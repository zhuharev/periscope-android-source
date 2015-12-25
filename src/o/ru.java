// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.lang.reflect.Method;

// Referenced classes of package o:
//            rw, ra, rl, rr

final class ru
    implements rw
{

    private final Context context;

    public ru(Context context1)
    {
        context = context1.getApplicationContext();
    }

    private Object _mth01C3()
    {
        Exception exception;
        Object obj;
        try
        {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context
            });
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            ra._mth0454()._mth02CE("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
        return obj;
    }

    private static boolean _mth02EE(Context context1)
    {
        int i;
        try
        {
            i = ((Integer)Class.forName("o.\u0993").getMethod("isGooglePlayServicesAvailable", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context1
            })).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return false;
        }
        return i == 0;
    }

    private String _mth0671()
    {
        Exception exception;
        String s;
        try
        {
            s = (String)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(_mth01C3(), new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            ra._mth0454()._mth02CE("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
        return s;
    }

    private boolean _mth0688()
    {
        Exception exception;
        boolean flag;
        try
        {
            flag = ((Boolean)Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(_mth01C3(), new Object[0])).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            ra._mth0454()._mth02CE("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
        return flag;
    }

    public final rr _mth0646()
    {
        if (_mth02EE(context))
        {
            return new rr(_mth0671(), _mth0688());
        } else
        {
            return null;
        }
    }
}
