// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.ws;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import o.vr;
import o.vv;

// Referenced classes of package com.squareup.okhttp.ws:
//            WebSocket

public interface WebSocketListener
{

    public abstract void onClose(int i, String s);

    public abstract void onFailure(IOException ioexception);

    public abstract void onMessage(vv vv, WebSocket.PayloadType payloadtype);

    public abstract void onOpen(WebSocket websocket, Request request, Response response);

    public abstract void onPong(vr vr);
}
