// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.ws:
//            WebSocketListener, WebSocketCall

class r
    implements Callback
{

    final WebSocketCall this$0;
    final WebSocketListener val$listener;

    public void onFailure(Request request, IOException ioexception)
    {
        val$listener.onFailure(ioexception);
    }

    public void onResponse(Response response)
    {
        try
        {
            WebSocketCall.access$000(WebSocketCall.this, response, val$listener);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            val$listener.onFailure(response);
        }
    }

    r()
    {
        this$0 = final_websocketcall;
        val$listener = WebSocketListener.this;
        super();
    }
}
