// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package o:
//            aoa, zs, atn, ajk, 
//            agp, xd, abz, acl

public final class abx
{

    private static Uri bcG = Uri.parse("periscope://user");
    private static Uri bcH = Uri.parse("periscope://broadcast");

    public static Notification _mth02CA(Context context, int i, String s, Bundle bundle)
    {
        Object obj1 = bundle.getString("user_display_name");
        String s1 = bundle.getString("username");
        Object obj = bundle.getString("user_id");
        bundle = context.getString(0x7f0600f6, new Object[] {
            obj1, s1
        });
        obj1 = bcG.buildUpon().appendPath(((String) (obj))).build();
        obj = (new Intent(context, o/aoa)).setData(((Uri) (obj1))).putExtra("e_user_type", zs.aWX).putExtra("e_sheet_user_id", ((String) (obj))).putExtra("e_from_push", true).putExtra("notif_id", i).putExtra("notif_tag", s);
        obj = TaskStackBuilder.create(context).addParentStack(o/aoa).addParentStack(o/aoa).addNextIntent(((Intent) (obj))).getPendingIntent(i, 0x8000000);
        s = _mth02CA(context, i, s, ((Uri) (obj1)));
        obj1 = context.getString(0x7f060108);
        return (new _cls06E5._cls02CE(context))._mth141D(0x7f0200ee)._mth02BD(context.getResources().getColor(0x7f0c006a))._mth02CB(((CharSequence) (obj1)))._mth02CE(bundle)._mth02CF(((CharSequence) (obj1)))._mth02CA((new _cls06E5._cls02CB())._mth02CA(bundle))._mth02CA(((PendingIntent) (obj)))._mth02CB(s)._mth02CE(true).build();
    }

    static Notification _mth02CA(Context context, int i, String s, ArrayList arraylist, ArrayList arraylist1)
    {
        int l = arraylist.size();
        ArrayList arraylist2 = new ArrayList(l + arraylist1.size());
        for (int j = 0; j < l; j++)
        {
            Pair pair = (Pair)arraylist.get(j);
            String s3 = ((atn)pair.first).eS();
            String s1 = s3;
            if (TextUtils.isEmpty(s3))
            {
                s1 = context.getString(0x7f06016f);
            }
            s3 = (String)pair.second;
            if (TextUtils.isEmpty(s3))
            {
                arraylist2.add(context.getString(0x7f06019f, new Object[] {
                    ((atn)pair.first).fh(), s1
                }));
            } else
            {
                arraylist2.add(context.getString(0x7f0601a0, new Object[] {
                    s3, s1
                }));
            }
        }

        arraylist2.addAll(arraylist1);
        arraylist1 = new _cls06E5.aux();
        for (arraylist = arraylist2.iterator(); arraylist.hasNext(); arraylist1._mth02BC((String)arraylist.next())) { }
        int k = arraylist2.size();
        String s2 = context.getResources().getQuantityString(0x7f070005, k, new Object[] {
            Integer.valueOf(k)
        });
        arraylist1._mth02BB(s2);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("replay_broadcasts_lines", arraylist2);
        arraylist = _mth02CA(context, i, s, Uri.EMPTY);
        if (k > 1)
        {
            k = 0x7f0200f0;
        } else
        {
            k = 0x7f0200ee;
        }
        arraylist1 = (new _cls06E5._cls02CE(context))._mth141D(k)._mth02CB(s2)._mth02CE((CharSequence)arraylist2.get(0))._mth02BD(context.getResources().getColor(0x7f0c006a))._mth02BC(0)._mth02CA(arraylist1)._mth02BD(s)._mth02CF(true)._mth02CB(bundle)._mth02BB(4);
        s = (new Intent(context, o/ajk)).putExtra("notif_id", i).putExtra("notif_tag", s).setFlags(0x14000000);
        return arraylist1._mth02CA(TaskStackBuilder.create(context).addParentStack(o/ajk).addNextIntent(s).getPendingIntent(i, 0x8000000))._mth02CB(arraylist)._mth02CE(true).build();
    }

    public static Notification _mth02CA(Context context, int i, String s, acl acl1, Bundle bundle)
    {
        String s2 = bundle.getString("broadcast_id");
        String s3 = bundle.getString("broadcast_user_display_name");
        String s1 = bundle.getString("broadcast_title");
        s3 = context.getString(0x7f060107, new Object[] {
            s3
        });
        bundle = s1;
        if (TextUtils.isEmpty(s1))
        {
            bundle = context.getString(0x7f06016f);
        }
        return _mth02CA(context, i, s, acl1, s3, ((String) (bundle)), s2, s3, null);
    }

    private static Notification _mth02CA(Context context, int i, String s, acl acl1, String s1, String s2, String s3, String s4, 
            Bundle bundle)
    {
        Object obj1 = bcH.buildUpon().appendPath(s3).build();
        Object obj = (new Intent(context, o/agp)).setData(((Uri) (obj1))).putExtra("e_b_id", s3).putExtra("e_from_push", true).putExtra("notif_id", i).putExtra("notif_tag", s).setFlags(0x14000000);
        obj = TaskStackBuilder.create(context).addParentStack(o/agp).addNextIntent(((Intent) (obj))).getPendingIntent(i, 0x8000000);
        obj1 = _mth02CA(context, i, s, ((Uri) (obj1)));
        s = bundle;
        if (bundle == null)
        {
            s = new Bundle();
        }
        s.putString("broadcast_id", s3);
        s = (new _cls06E5._cls02CE(context))._mth141D(0x7f0200ee)._mth02BD(context.getResources().getColor(0x7f0c006a))._mth02CB(s1)._mth02CE(s2)._mth02CF(s4)._mth02CA((new _cls06E5._cls02CB())._mth02CA(s2))._mth02CA(((PendingIntent) (obj)))._mth02CA(0x7f0200f1, context.getString(0x7f0600f0), ((PendingIntent) (obj1)))._mth02CA(0x7f0200f4, context.getString(0x7f0600f3), ((PendingIntent) (obj)))._mth02CB(((PendingIntent) (obj1)))._mth02CB(s)._mth02CE(true);
        _mth02CA(context, acl1, ((_cls06E5._cls02CE) (s)));
        if (xd._mth1FE9())
        {
            s._mth02BC(1);
        }
        return s.build();
    }

    private static PendingIntent _mth02CA(Context context, int i, String s, Uri uri)
    {
        ComponentName componentname = new ComponentName(context.getPackageName(), o/abz.getName());
        return PendingIntent.getBroadcast(context, i, (new Intent("dismiss")).setData(uri).putExtra("notif_id", i).putExtra("notif_tag", s).setComponent(componentname), 0x8000000);
    }

    private static void _mth02CA(Context context, acl acl1, _cls06E5._cls02CE _pcls02ce)
    {
        static final class _cls1
        {

            static final int bcI[];

            static 
            {
                bcI = new int[acl.if.values().length];
                try
                {
                    bcI[acl.if.bdm.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bcI[acl.if.bdn.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    bcI[acl.if.bdo.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch (_cls1.bcI[acl1.bdf.ordinal()])
        {
        case 1: // '\001'
            _pcls02ce._mth02CA(_mth1508(context))._mth02BB(6);
            return;

        case 2: // '\002'
            _pcls02ce._mth02BB(6);
            return;
        }
        _pcls02ce._mth02BB(4);
    }

    public static Notification _mth02CB(Context context, int i, String s, acl acl1, Bundle bundle)
    {
        String s1 = bundle.getString("broadcast_id");
        String s3 = bundle.getString("broadcast_username");
        String s2 = bundle.getString("broadcast_user_display_name");
        bundle = bundle.getString("broadcast_title");
        if (TextUtils.isEmpty(bundle))
        {
            bundle = context.getString(0x7f0600f7, new Object[] {
                s3
            });
        } else
        {
            bundle = context.getString(0x7f0600f8, new Object[] {
                s3, bundle
            });
        }
        return _mth02CA(context, i, s, acl1, s2, bundle, s1, bundle, null);
    }

    public static Notification _mth02CE(Context context, int i, String s, acl acl1, Bundle bundle)
    {
        String s1 = bundle.getString("username");
        String s2 = bundle.getString("broadcast_id");
        Object obj = bundle.getString("broadcast_user_display_name");
        bundle = bundle.getString("broadcast_title");
        if (TextUtils.isEmpty(bundle))
        {
            bundle = context.getString(0x7f0600f9, new Object[] {
                s1, obj
            });
        } else
        {
            bundle = context.getString(0x7f0600fa, new Object[] {
                s1, obj, bundle
            });
        }
        obj = new Bundle();
        ((Bundle) (obj)).putString("username", s1);
        return _mth02CA(context, i, s, acl1, s1, bundle, s2, bundle, ((Bundle) (obj)));
    }

    public static Notification _mth02CF(Context context, int i, String s, acl acl1, Bundle bundle)
    {
        String s1 = bundle.getString("broadcast_id");
        String s2 = bundle.getString("broadcast_user_display_name");
        String s3 = bundle.getString("broadcast_title");
        bundle = bundle.getString("broadcaster_twitter_username");
        if (TextUtils.isEmpty(s3))
        {
            bundle = context.getString(0x7f0600f4, new Object[] {
                bundle
            });
        } else
        {
            bundle = context.getString(0x7f0600f5, new Object[] {
                bundle, s3
            });
        }
        return _mth02CA(context, i, s, acl1, s2, bundle, s1, bundle, null);
    }

    private static Uri _mth1508(Context context)
    {
        return Uri.parse((new StringBuilder("android.resource://")).append(context.getPackageName()).append("/2131034112").toString());
    }

}
