// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class _cls1540
{

    _cls1540()
    {
    }

    public static Notification _mth02CA(Notification notification, Context context, CharSequence charsequence, CharSequence charsequence1, PendingIntent pendingintent, PendingIntent pendingintent1)
    {
        notification.setLatestEventInfo(context, charsequence, charsequence1, pendingintent);
        notification.fullScreenIntent = pendingintent1;
        return notification;
    }
}
