// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package o:
//            acp, ash, ade

public class add extends acp
    implements android.view.View.OnClickListener
{

    public add()
    {
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(0x7f04000a, 0x7f040010);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558656: 
            onBackPressed();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030099);
        getWindow().setBackgroundDrawable(null);
        Object obj = getIntent().getExtras();
        bundle = ((Bundle) (obj)).getString("e_title");
        obj = ((Bundle) (obj)).getString("e_url");
        ((ash)findViewById(0x7f0d009c)).setTitle(bundle);
        findViewById(0x7f0d0100).setOnClickListener(this);
        bundle = (WebView)findViewById(0x7f0d01c4);
        bundle.getSettings().setJavaScriptEnabled(false);
        bundle.setWebViewClient(new ade(this));
        bundle.setWebChromeClient(new WebChromeClient());
        bundle.loadUrl(((String) (obj)));
    }
}
