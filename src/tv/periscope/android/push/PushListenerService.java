// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.push;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.gcm.GcmListenerService;
import java.util.ArrayList;
import java.util.Map;
import o.0675;
import o.abv;
import o.abx;
import o.aby;
import o.acl;
import o.acm;
import o.xd;
import tv.periscope.android.api.ApiManager;

public class PushListenerService extends GcmListenerService
{

    public PushListenerService()
    {
    }

    public void onMessageReceived(String s, Bundle bundle)
    {
        aby aby1;
        boolean flag;
label0:
        {
            aby1 = xd._mth212A().bcE;
            s = bundle.getString("type");
            if (s == null)
            {
                _cls0675._mth02CB(new IllegalArgumentException((new StringBuilder("shouldIssueNotification: no matching type for push data ")).append(bundle).toString()));
            } else
            if (!Boolean.valueOf(bundle.getString("silent")).booleanValue())
            {
                acl acl1 = (new acm(aby1.mContext)).aH();
                byte byte2 = -1;
                byte byte0 = byte2;
                switch (s.hashCode())
                {
                default:
                    byte0 = byte2;
                    break;

                case 49: // '1'
                    byte0 = byte2;
                    if (s.equals("1"))
                    {
                        byte0 = 0;
                    }
                    break;

                case 53: // '5'
                    byte0 = byte2;
                    if (s.equals("5"))
                    {
                        byte0 = 1;
                    }
                    break;

                case 51: // '3'
                    byte0 = byte2;
                    if (s.equals("3"))
                    {
                        byte0 = 2;
                    }
                    break;

                case 54: // '6'
                    byte0 = byte2;
                    if (s.equals("6"))
                    {
                        byte0 = 3;
                    }
                    break;

                case 50: // '2'
                case 52: // '4'
                    break;
                }
                switch (byte0)
                {
                case 0: // '\0'
                    flag = Boolean.valueOf(bundle.getString("locked")).booleanValue();
                    if (acl1.bdg || flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    break label0;

                case 1: // '\001'
                    flag = acl1.bdh;
                    break label0;

                case 2: // '\002'
                    flag = acl1.bdi;
                    break label0;

                case 3: // '\003'
                    flag = acl1.bdj;
                    break label0;
                }
            }
            flag = false;
        }
        if (flag)
        {
            String s1 = bundle.getString("type");
            Integer integer = (Integer)aby.bcK.get(s1);
            if (integer == null)
            {
                _cls0675._mth02CB(new IllegalArgumentException((new StringBuilder("No matching type for push data ")).append(bundle).toString()));
            } else
            {
                s = (new acm(aby1.mContext)).aH();
                byte byte3 = -1;
                byte byte1 = byte3;
                switch (s1.hashCode())
                {
                default:
                    byte1 = byte3;
                    break;

                case 51: // '3'
                    byte1 = byte3;
                    if (s1.equals("3"))
                    {
                        byte1 = 0;
                    }
                    break;

                case 49: // '1'
                    byte1 = byte3;
                    if (s1.equals("1"))
                    {
                        byte1 = 1;
                    }
                    break;

                case 53: // '5'
                    byte1 = byte3;
                    if (s1.equals("5"))
                    {
                        byte1 = 2;
                    }
                    break;

                case 54: // '6'
                    byte1 = byte3;
                    if (s1.equals("6"))
                    {
                        byte1 = 3;
                    }
                    break;

                case 50: // '2'
                case 52: // '4'
                    break;
                }
                switch (byte1)
                {
                case 0: // '\0'
                    String s2 = bundle.getString("user_id");
                    s = abx._mth02CA(aby1.mContext, integer.intValue(), s2, bundle);
                    ApiManager.get(aby1.mContext).getUserById(s2);
                    bundle = s2;
                    break;

                case 1: // '\001'
                    String s3 = bundle.getString("broadcast_id");
                    if (android.os.Build.VERSION.SDK_INT < 23)
                    {
                        s3 = bundle.getString("broadcast_username");
                    }
                    if (Boolean.valueOf(bundle.getString("locked")).booleanValue())
                    {
                        s = abx._mth02CB(aby1.mContext, integer.intValue(), s3, s, bundle);
                        bundle = s3;
                    } else
                    {
                        s = abx._mth02CA(aby1.mContext, integer.intValue(), s3, s, bundle);
                        bundle = s3;
                    }
                    break;

                case 2: // '\002'
                    String s4 = bundle.getString("broadcast_id");
                    if (android.os.Build.VERSION.SDK_INT < 23)
                    {
                        s4 = bundle.getString("username");
                    }
                    s = abx._mth02CE(aby1.mContext, integer.intValue(), s4, s, bundle);
                    bundle = s4;
                    break;

                case 3: // '\003'
                    String s5 = bundle.getString("broadcast_id");
                    s = abx._mth02CF(aby1.mContext, integer.intValue(), s5, s, bundle);
                    bundle = s5;
                    break;

                default:
                    (new StringBuilder("Failed to issue notification for bundle ")).append(bundle);
                    s = null;
                    bundle = null;
                    break;
                }
                if (s != null)
                {
                    ((NotificationManager)aby1.mContext.getSystemService("notification")).notify(bundle, integer.intValue(), s);
                }
            }
        } else
        {
            (new StringBuilder("User requested to not see notification, dropping ")).append(bundle);
        }
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            s = aby1._mth15EE(aby1.mContext);
            if (!s.isEmpty())
            {
                aby._mth02BD(s);
            }
        }
    }
}
