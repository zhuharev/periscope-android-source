// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package o:
//            aby, atn, ato, abx, 
//            xd, yv, zu, zw

final class abr
{

    private final Context mContext;

    abr(Context context)
    {
        mContext = context;
    }

    private void _mth02BC(ArrayList arraylist)
    {
        NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
        StatusBarNotification astatusbarnotification[];
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            astatusbarnotification = notificationmanager.getActiveNotifications();
        } else
        {
            astatusbarnotification = null;
        }
        if (astatusbarnotification == null || astatusbarnotification.length == 0)
        {
            return;
        }
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        int k = astatusbarnotification.length;
        for (int j = 0; j < k; j++)
        {
            StatusBarNotification statusbarnotification = astatusbarnotification[j];
            String s = (String)aby.bcL.get(Integer.valueOf(statusbarnotification.getId()));
            if (s != null)
            {
                byte byte0 = -1;
                switch (s.hashCode())
                {
                case 49: // '1'
                    if (s.equals("1"))
                    {
                        byte0 = 0;
                    }
                    break;

                case 53: // '5'
                    if (s.equals("5"))
                    {
                        byte0 = 1;
                    }
                    break;

                case 1507423: 
                    if (s.equals("1000"))
                    {
                        byte0 = 2;
                    }
                    break;
                }
                switch (byte0)
                {
                default:
                    break;

                case 0: // '\0'
                case 1: // '\001'
                    atn atn1 = _mth02CA(statusbarnotification.getNotification(), arraylist);
                    if (atn1 == null)
                    {
                        break;
                    }
                    Pair pair = new Pair(atn1, statusbarnotification.getNotification().extras.getString("username"));
                    boolean flag;
                    if (((atn)pair.first).bDW == ato.bEd)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        arraylist1.add(pair);
                    }
                    if (atn1.bDW == ato.bEd)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        notificationmanager.cancel(statusbarnotification.getTag(), statusbarnotification.getId());
                    }
                    break;

                case 2: // '\002'
                    _mth02CA(arraylist2, statusbarnotification.getNotification());
                    break;
                }
            }
        }

        if (arraylist1.size() > 0)
        {
            int i = ((Integer)aby.bcK.get("1000")).intValue();
            arraylist = abx._mth02CA(mContext, i, "replay_broadcast", arraylist1, arraylist2);
            if (arraylist != null)
            {
                notificationmanager.notify("replay_broadcast", i, arraylist);
            }
        }
    }

    private static atn _mth02CA(Notification notification, ArrayList arraylist)
    {
label0:
        {
            notification = notification.extras;
            if (notification == null || !notification.containsKey("broadcast_id"))
            {
                return null;
            }
            notification = notification.getString("broadcast_id");
            if (TextUtils.isEmpty(notification))
            {
                return null;
            }
            if (arraylist == null)
            {
                break label0;
            }
            arraylist = arraylist.iterator();
            atn atn1;
            do
            {
                if (!arraylist.hasNext())
                {
                    break label0;
                }
                atn1 = (atn)arraylist.next();
            } while (!notification.equals(atn1.id()));
            return atn1;
        }
        return (atn)xd._mth216D().aWg.get(notification);
    }

    private static void _mth02CA(ArrayList arraylist, Notification notification)
    {
        notification = notification.extras;
        if (notification == null || !notification.containsKey("replay_broadcasts_lines"))
        {
            return;
        }
        notification = notification.getStringArrayList("replay_broadcasts_lines");
        if (notification != null)
        {
            arraylist.addAll(notification);
        }
    }

    public final void onEvent(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];
            static final int bcB[];

            static 
            {
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYI.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        boolean flag;
        if (zu1.aXl == null && zu1.mU == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            zu1 = (ArrayList)zu1.data;
            if (zu1 != null)
            {
                _mth02BC(zu1);
            }
        }
    }

    public final void onEvent(zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            _mth02BC(null);
            break;
        }
    }
}
