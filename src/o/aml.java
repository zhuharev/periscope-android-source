// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package o:
//            amk

final class aml extends WebChromeClient
{

    private amk bsS;

    aml(amk amk)
    {
        bsS = amk;
        super();
    }

    public final boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        message = webview.getHitTestResult().getExtra();
        webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
        return false;
    }
}
