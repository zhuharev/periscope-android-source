// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class com.google.android.gms.gcm.zza
{
    class zza extends IllegalArgumentException
    {

        final com.google.android.gms.gcm.zza zzaCj;

        private zza(String s)
        {
            zzaCj = com.google.android.gms.gcm.zza.this;
            super(s);
        }

    }


    static com.google.android.gms.gcm.zza zzaCi;
    private Context mContext;

    private com.google.android.gms.gcm.zza(Context context)
    {
        mContext = context.getApplicationContext();
    }

    private void zza(String s, Notification notification)
    {
        if (Log.isLoggable("GcmNotification", 3))
        {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = (new StringBuilder("GCM-Notification:")).append(SystemClock.uptimeMillis()).toString();
        }
        notificationmanager.notify(s1, 0, notification);
    }

    static com.google.android.gms.gcm.zza zzaz(Context context)
    {
        com/google/android/gms/gcm/zza;
        JVM INSTR monitorenter ;
        if (zzaCi == null)
        {
            zzaCi = new com.google.android.gms.gcm.zza(context);
        }
        context = zzaCi;
        com/google/android/gms/gcm/zza;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static String zzc(Bundle bundle, String s)
    {
        String s2 = bundle.getString(s);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = bundle.getString(s.replace("gcm.n.", "gcm.notification."));
        }
        return s1;
    }

    private String zzd(Bundle bundle, String s)
    {
        JSONException jsonexception;
        String s1 = zzc(bundle, s);
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        }
        s1 = zzc(bundle, (new StringBuilder()).append(s).append("_loc_key").toString());
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        Resources resources = mContext.getResources();
        int j = resources.getIdentifier(s1, "string", mContext.getPackageName());
        if (j == 0)
        {
            throw new zza((new StringBuilder()).append(zzdj((new StringBuilder()).append(s).append("_loc_key").toString())).append(" resource not found: ").append(s1).toString());
        }
        bundle = zzc(bundle, (new StringBuilder()).append(s).append("_loc_args").toString());
        if (TextUtils.isEmpty(bundle))
        {
            return resources.getString(j);
        }
        JSONArray jsonarray;
        try
        {
            jsonarray = new JSONArray(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            throw new zza((new StringBuilder("Malformed ")).append(zzdj((new StringBuilder()).append(s).append("_loc_args").toString())).append(": ").append(bundle).toString());
        }
        bundle = new String[jsonarray.length()];
        for (int i = 0; i < bundle.length; i++)
        {
            bundle[i] = jsonarray.opt(i);
        }

        try
        {
            bundle = resources.getString(j, bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new zza((new StringBuilder("Missing format argument for ")).append(s1).append(": ").append(bundle).toString());
        }
        return bundle;
    }

    private String zzdj(String s)
    {
        return s.substring(6);
    }

    private int zzdk(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new zza("Missing icon");
        }
        Resources resources = mContext.getResources();
        int i = resources.getIdentifier(s, "drawable", mContext.getPackageName());
        if (i != 0)
        {
            return i;
        }
        i = resources.getIdentifier(s, "mipmap", mContext.getPackageName());
        if (i != 0)
        {
            return i;
        } else
        {
            throw new zza((new StringBuilder("Icon resource not found: ")).append(s).toString());
        }
    }

    private Uri zzdl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if ("default".equals(s))
        {
            return RingtoneManager.getDefaultUri(2);
        } else
        {
            throw new zza((new StringBuilder("Invalid sound: ")).append(s).toString());
        }
    }

    static boolean zzu(Bundle bundle)
    {
        return zzc(bundle, "gcm.n.icon") != null;
    }

    private int zzvW()
    {
        return (int)SystemClock.uptimeMillis();
    }

    private Notification zzw(Bundle bundle)
    {
        Object obj = zzd(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new zza("Missing title");
        }
        String s = zzd(bundle, "gcm.n.body");
        int i = zzdk(zzc(bundle, "gcm.n.icon"));
        Uri uri = zzdl(zzc(bundle, "gcm.n.sound"));
        PendingIntent pendingintent = zzx(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            obj = (new android.app.Notification.Builder(mContext)).setAutoCancel(true).setSmallIcon(i).setContentTitle(((CharSequence) (obj))).setContentText(s);
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                bundle = zzc(bundle, "gcm.n.color");
                if (!TextUtils.isEmpty(bundle))
                {
                    ((android.app.Notification.Builder) (obj)).setColor(Color.parseColor(bundle));
                }
            }
            if (uri != null)
            {
                ((android.app.Notification.Builder) (obj)).setSound(uri);
            }
            if (pendingintent != null)
            {
                ((android.app.Notification.Builder) (obj)).setContentIntent(pendingintent);
            }
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                return ((android.app.Notification.Builder) (obj)).build();
            } else
            {
                return ((android.app.Notification.Builder) (obj)).getNotification();
            }
        }
        bundle = pendingintent;
        if (pendingintent == null)
        {
            bundle = new Intent();
            bundle.setPackage("com.google.example.invalidpackage");
            bundle = PendingIntent.getBroadcast(mContext, 0, bundle, 0);
        }
        bundle = (new o._cls06E5._cls02CE(mContext))._mth141D(i)._mth02CE(true)._mth02CA(bundle)._mth02CB(((CharSequence) (obj)))._mth02CE(s);
        if (uri != null)
        {
            bundle._mth02CA(uri);
        }
        return bundle.build();
    }

    private PendingIntent zzx(Bundle bundle)
    {
        Object obj = zzc(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return null;
        }
        obj = new Intent(((String) (obj)));
        ((Intent) (obj)).setPackage(mContext.getPackageName());
        ((Intent) (obj)).setFlags(0x10000000);
        ((Intent) (obj)).putExtras(bundle);
        bundle = bundle.keySet().iterator();
        do
        {
            if (!bundle.hasNext())
            {
                break;
            }
            String s = (String)bundle.next();
            if (s.startsWith("gcm.n.") || s.startsWith("gcm.notification."))
            {
                ((Intent) (obj)).removeExtra(s);
            }
        } while (true);
        return PendingIntent.getActivity(mContext, zzvW(), ((Intent) (obj)), 0x40000000);
    }

    boolean zzv(Bundle bundle)
    {
        try
        {
            Notification notification = zzw(bundle);
            zza(zzc(bundle, "gcm.n.tag"), notification);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.w("GcmNotification", (new StringBuilder("Failed to show notification: ")).append(bundle.getMessage()).toString());
            return false;
        }
        return true;
    }
}
