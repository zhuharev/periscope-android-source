// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.reflect.Field;
import o.0993;
import o.FF6A;
import o.abv;
import o.abw;
import o.ach;
import o.acp;
import o.ajk;
import o.alk;
import o.alu;
import o.aos;
import o.xc;
import o.xd;
import o.xf;
import o.zp;
import tv.periscope.android.api.ApiManager;

public class LaunchActivity extends acp
{

    private SharedPreferences aQC;

    public LaunchActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        boolean flag2;
label0:
        {
            super.onCreate(bundle);
            flag2 = true;
            aQC = getPreferences(0);
            if (xd._mth1FEA().aQC.getBoolean((String)o.yp.CON._mth02CA("o.yp").getField("aVP").get(null), false))
            {
                try
                {
                    (new ach(xd._mth1FEB(), xd._mth1FEA(), ApiManager.get(this)))._mth02CA(this);
                    xd._mth212A().aD();
                    if (!o._cls1D66.if._mth02CA(this, getIntent()))
                    {
                        startActivity(new Intent(this, o/ajk));
                        finish();
                    }
                    break label0;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    flag2 = false;
                    FF6A._mth02CA("LaunchActivity", "Failed to register push.", bundle);
                }
                if (_cls0993._mth02C0(((abw) (bundle)).bcF))
                {
                    SharedPreferences sharedpreferences = aQC;
                    boolean flag3 = sharedpreferences.getBoolean("error_dialog_shown", false);
                    int i = sharedpreferences.getInt("app_version", 0x80000000);
                    int j = aos._mth0131(this);
                    boolean flag;
                    if (!flag3 || i != j)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        bundle = _cls0993._mth02CA(((abw) (bundle)).bcF, this, 9000);
                        bundle.setOnDismissListener(new xc(this));
                        bundle.show();
                        aQC.edit().putBoolean("error_dialog_shown", true).putInt("app_version", aos._mth0131(this)).apply();
                        break label0;
                    }
                }
                startActivity(new Intent(this, o/ajk));
                finish();
            } else
            {
                boolean flag1;
                if (!aQC.getBoolean("walkthrough_shown", false))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    startActivity(new Intent(this, o/alu));
                    finish();
                    aQC.edit().putBoolean("walkthrough_shown", true).apply();
                } else
                {
                    startActivity(new Intent(this, o/alk));
                    finish();
                }
            }
        }
        xf._mth02CB("Direct", flag2);
        ApiManager.get(this).hello();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        o._cls1D66.if._mth02CA(this, intent);
    }
}
