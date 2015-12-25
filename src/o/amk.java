// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ada, amm, aml, zu, 
//            ajk, zv

public class amk extends ada
    implements android.view.View.OnClickListener
{

    private ProgressDialog brR;

    public amk()
    {
    }

    static void _mth02CA(amk amk1, zv zv1)
    {
        amk1._mth02CA(zv1);
    }

    public void onBackPressed()
    {
        (new android.app.AlertDialog.Builder(this)).setMessage(getString(0x7f060199)).setPositiveButton(getString(0x7f0600c0), new amm(this)).setNegativeButton(getString(0x7f0600bf), null).show();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558794: 
            view.setEnabled(false);
            break;
        }
        if (!brR.isShowing())
        {
            brR.show();
        }
        ApiManager.get(this).unban();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03007e);
        getWindow().setBackgroundDrawable(null);
        findViewById(0x7f0d018a).setOnClickListener(this);
        bundle = (WebView)findViewById(0x7f0d0188);
        bundle.getSettings().setJavaScriptEnabled(false);
        bundle.getSettings().setSupportMultipleWindows(true);
        bundle.setWebViewClient(new WebViewClient());
        bundle.setWebChromeClient(new aml(this));
        bundle.loadUrl(getString(0x7f0601a5));
        brR = new ProgressDialog(this);
        brR.setMessage(getString(0x7f0601a8));
        brR.setIndeterminate(true);
        brR.setCancelable(false);
    }

    public void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aXy.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            break;
        }
        if (brR.isShowing())
        {
            brR.dismiss();
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
            startActivity((new Intent(this, o/ajk)).putExtra("e_tab", "main"));
            finish();
            return;
        } else
        {
            _mth02CA(zv.aYq);
            return;
        }
    }
}
