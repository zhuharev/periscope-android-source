// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import tv.periscope.android.LaunchActivity;

// Referenced classes of package o:
//            agp, ada

public final class aco
    implements aig._cls02CB
{

    private final Activity mActivity;

    public aco(Activity activity)
    {
        mActivity = activity;
    }

    public static void _mth02BB(ada ada)
    {
        Intent intent = new Intent(ada, tv/periscope/android/LaunchActivity);
        intent.setFlags(0x4008000);
        Intent intent1 = new Intent();
        intent1.setAction("action_logout");
        ada.setResult(-1, intent1);
        ada.finish();
        ada.startActivity(intent);
    }

    public final void _mth02CE(String s, boolean flag)
    {
        Intent intent = (new Intent(mActivity, o/agp)).putExtra("e_b_id", s);
        if (flag)
        {
            s = ahi.if.blw;
        } else
        {
            s = ahi.if.blv;
        }
        s = intent.putExtra("e_p_mode", s);
        mActivity.startActivity(s, ActivityOptions.makeCustomAnimation(mActivity, 0x7f04000d, 0x7f04000c).toBundle());
    }

    public final void _mth1D64(String s)
    {
        s = (new Intent(mActivity, o/agp)).putExtra("e_b_id", s).putExtra("e_p_mode", ahi.if.blu);
        mActivity.startActivity(s, ActivityOptions.makeCustomAnimation(mActivity, 0x7f04000d, 0x7f04000c).toBundle());
    }
}
