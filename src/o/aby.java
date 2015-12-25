// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tv.periscope.android.api.ApiClient;
import tv.periscope.android.api.ApiRunnable;
import tv.periscope.android.api.ApiService;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package o:
//            xd, abr, ql, ack, 
//            acj, acn, yv, atn, 
//            ato

public final class aby
{

    private static final ArrayList bcJ = new ArrayList();
    public static final HashMap bcK;
    static final HashMap bcL;
    private final yv mBroadcastCacheManager;
    public final Context mContext;

    public aby(Context context)
    {
        this(context, xd._mth216D());
    }

    private aby(Context context, yv yv1)
    {
        mContext = context;
        mBroadcastCacheManager = yv1;
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            context = new abr(context);
            xd.getEventBus()._mth02CA(context, false, 0);
        }
    }

    public static void _mth02BD(ArrayList arraylist)
    {
        if (arraylist.isEmpty())
        {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("extra_ids", arraylist);
        arraylist = xd._mth1FEB();
        if (((ack) (arraylist)).bde == null)
        {
            arraylist.aG();
        }
        arraylist = ((ack) (arraylist)).bde;
        if (arraylist != null)
        {
            arraylist = ((acj) (arraylist)).bcY;
        } else
        {
            arraylist = null;
        }
        bundle.putString("e_cookie", arraylist);
        (new tv.periscope.android.api.ApiRunnable.Builder()).setEventBus(xd.getEventBus()).setService((ApiService)xd._mth3078().getService()).setSigner((SignerService)xd._mth30A5().getService()).setActionCode(19).setBundle(bundle).setNumRetries(0).setBackoffInterval(0L).build().run();
    }

    public final void _mth02BC(Intent intent)
    {
        if (intent.hasExtra("notif_id") && intent.hasExtra("notif_tag"))
        {
            int i = intent.getIntExtra("notif_id", 0);
            intent = intent.getStringExtra("notif_tag");
            ((NotificationManager)mContext.getSystemService("notification")).cancel(intent, i);
        }
    }

    public ArrayList _mth15EE(Context context)
    {
        context = (NotificationManager)context.getSystemService("notification");
        if (android.os.Build.VERSION.SDK_INT < 23)
        {
            return bcJ;
        }
        context = context.getActiveNotifications();
        ArrayList arraylist = new ArrayList(context.length);
        int j = context.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label0;
                }
                Object obj = context[i];
                Object obj1 = (String)bcL.get(Integer.valueOf(((StatusBarNotification) (obj)).getId()));
                if (obj1 == null)
                {
                    break label1;
                }
                byte byte0 = -1;
                switch (((String) (obj1)).hashCode())
                {
                case 53: // '5'
                    if (((String) (obj1)).equals("5"))
                    {
                        byte0 = 0;
                    }
                    break;

                case 49: // '1'
                    if (((String) (obj1)).equals("1"))
                    {
                        byte0 = 1;
                    }
                    break;
                }
                switch (byte0)
                {
                default:
                    break label1;

                case 0: // '\0'
                case 1: // '\001'
                    obj = ((StatusBarNotification) (obj)).getNotification().extras;
                    break;
                }
                if (obj == null || !((Bundle) (obj)).containsKey("broadcast_id"))
                {
                    break label1;
                }
                obj = ((Bundle) (obj)).getString("broadcast_id");
                obj1 = (atn)mBroadcastCacheManager.aWg.get(obj);
                if (obj1 != null)
                {
                    boolean flag;
                    if (((atn) (obj1)).bDW == ato.bEd)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                }
                arraylist.add(obj);
            }
            i++;
        } while (true);
        return arraylist;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        bcK = hashmap;
        hashmap.put("0", Integer.valueOf(1000));
        bcK.put("1", Integer.valueOf(1100));
        bcK.put("2", Integer.valueOf(1200));
        bcK.put("3", Integer.valueOf(1300));
        bcK.put("4", Integer.valueOf(1400));
        bcK.put("5", Integer.valueOf(1500));
        bcK.put("6", Integer.valueOf(1600));
        bcK.put("1000", Integer.valueOf(10000));
        hashmap = new HashMap();
        bcL = hashmap;
        hashmap.put(Integer.valueOf(1000), "0");
        bcL.put(Integer.valueOf(1100), "1");
        bcL.put(Integer.valueOf(1200), "2");
        bcL.put(Integer.valueOf(1300), "3");
        bcL.put(Integer.valueOf(1400), "4");
        bcL.put(Integer.valueOf(1500), "5");
        bcL.put(Integer.valueOf(1600), "6");
        bcL.put(Integer.valueOf(10000), "1000");
    }
}
