// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package o:
//            rw, ra, rl, rr

final class rv
    implements rw
{
    static final class if
        implements ServiceConnection
    {

        private boolean Rn;
        private final LinkedBlockingQueue Ro;

        public final IBinder getBinder()
        {
            InterruptedException interruptedexception;
            if (Rn)
            {
                ra._mth0454()._mth02CA("Fabric", "getBinder already called");
            }
            Rn = true;
            IBinder ibinder;
            try
            {
                ibinder = (IBinder)Ro.poll(200L, TimeUnit.MILLISECONDS);
            }
            // Misplaced declaration of an exception variable
            catch (InterruptedException interruptedexception)
            {
                return null;
            }
            return ibinder;
        }

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            try
            {
                Ro.put(ibinder);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ComponentName componentname)
            {
                return;
            }
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            Ro.clear();
        }

        private if()
        {
            Rn = false;
            Ro = new LinkedBlockingQueue(1);
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}


    private final Context context;

    public rv(Context context1)
    {
        context = context1.getApplicationContext();
    }

    public final rr _mth0646()
    {
        if if1;
        Object obj;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            ra._mth0454()._mth02BE("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try
        {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        // Misplaced declaration of an exception variable
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            ra._mth0454()._mth02BE("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        catch (Exception exception)
        {
            ra._mth0454()._mth02CB("Fabric", "Unable to determine if Google Play Services is available", exception);
            return null;
        }
        if1 = new if((byte)0);
        obj = new Intent("com.google.android.gms.ads.identifier.service.START");
        ((Intent) (obj)).setPackage("com.google.android.gms");
        boolean flag = context.bindService(((Intent) (obj)), if1, 1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        obj = new _cls02CA(if1.getBinder());
        obj = new rr(((_cls02CA) (obj)).getId(), ((_cls02CA) (obj))._mth0688());
        context.unbindService(if1);
        return ((rr) (obj));
        Exception exception1;
        exception1;
        ra._mth0454()._mth02CA("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", exception1);
        Exception exception2;
        try
        {
            context.unbindService(if1);
        }
        catch (Throwable throwable)
        {
            ra._mth0454()._mth02CB("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", throwable);
        }
        break MISSING_BLOCK_LABEL_202;
        exception2;
        context.unbindService(if1);
        throw exception2;
        ra._mth0454()._mth02BE("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        return null;
    }
}
