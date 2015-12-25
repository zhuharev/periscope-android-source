// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;

// Referenced classes of package o:
//            FB30, _cls1EF4, _cls03D2, vc, 
//            rz, FB8B, FE8F

final class _cls5FC4
    implements Runnable
{

    final _cls1EF4 uq;
    final _cls1EF4._cls02CA ur;
    private _cls03D2 us;
    private vc ut;
    private Activity val$activity;

    _cls5FC4(_cls1EF4 _pcls1ef4, Activity activity, _cls1EF4._cls02CA _pcls02ca, _cls03D2 _pcls03d2, vc vc1)
    {
        uq = _pcls1ef4;
        val$activity = activity;
        ur = _pcls02ca;
        us = _pcls03d2;
        ut = vc1;
        super();
    }

    public final void run()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(val$activity);
        FB30 fb30 = new FB30(this);
        float f = val$activity.getResources().getDisplayMetrics().density;
        int i = _cls1EF4._mth02CA(uq, f, 5);
        Object obj4 = new TextView(val$activity);
        ((TextView) (obj4)).setAutoLinkMask(15);
        Object obj1 = us;
        Object obj = ((_cls03D2) (obj1)).vb.message;
        obj1 = rz._mth1FBE(((_cls03D2) (obj1)).context, "com.crashlytics.CrashSubmissionPromptMessage");
        boolean flag;
        if (obj1 == null || ((String) (obj1)).length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            obj = obj1;
        }
        ((TextView) (obj4)).setText(((CharSequence) (obj)));
        ((TextView) (obj4)).setTextAppearance(val$activity, 0x1030044);
        ((TextView) (obj4)).setPadding(i, i, i, i);
        ((TextView) (obj4)).setFocusable(false);
        obj = new ScrollView(val$activity);
        ((ScrollView) (obj)).setPadding(_cls1EF4._mth02CA(uq, f, 14), _cls1EF4._mth02CA(uq, f, 2), _cls1EF4._mth02CA(uq, f, 10), _cls1EF4._mth02CA(uq, f, 12));
        ((ScrollView) (obj)).addView(((android.view.View) (obj4)));
        obj4 = builder.setView(((android.view.View) (obj)));
        obj1 = us;
        obj = ((_cls03D2) (obj1)).vb.title;
        obj1 = rz._mth1FBE(((_cls03D2) (obj1)).context, "com.crashlytics.CrashSubmissionPromptTitle");
        if (obj1 == null || ((String) (obj1)).length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            obj = obj1;
        }
        obj4 = ((android.app.AlertDialog.Builder) (obj4)).setTitle(((CharSequence) (obj))).setCancelable(false);
        obj1 = us;
        obj = ((_cls03D2) (obj1)).vb.Uw;
        obj1 = rz._mth1FBE(((_cls03D2) (obj1)).context, "com.crashlytics.CrashSubmissionSendTitle");
        if (obj1 == null || ((String) (obj1)).length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            obj = obj1;
        }
        ((android.app.AlertDialog.Builder) (obj4)).setNeutralButton(((CharSequence) (obj)), fb30);
        if (ut.Ux)
        {
            FB8B fb8b = new FB8B(this);
            Object obj2 = us;
            String s = ((_cls03D2) (obj2)).vb.Uy;
            obj2 = rz._mth1FBE(((_cls03D2) (obj2)).context, "com.crashlytics.CrashSubmissionCancelTitle");
            boolean flag1;
            if (obj2 == null || ((String) (obj2)).length() == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1)
            {
                s = ((String) (obj2));
            }
            builder.setNegativeButton(s, fb8b);
        }
        if (ut.Uz)
        {
            FE8F fe8f = new FE8F(this);
            Object obj3 = us;
            String s1 = ((_cls03D2) (obj3)).vb.UA;
            obj3 = rz._mth1FBE(((_cls03D2) (obj3)).context, "com.crashlytics.CrashSubmissionAlwaysSendTitle");
            boolean flag2;
            if (obj3 == null || ((String) (obj3)).length() == 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!flag2)
            {
                s1 = ((String) (obj3));
            }
            builder.setPositiveButton(s1, fe8f);
        }
        builder.show();
    }
}
