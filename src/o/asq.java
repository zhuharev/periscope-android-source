// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.squareup.okhttp.ws.WebSocket;
import java.io.Closeable;
import java.io.IOException;
import tv.periscope.chatman.api.WireMessage;

// Referenced classes of package o:
//            ast, aul

public final class asq
    implements Closeable
{
    public static interface if
    {

        public abstract void eB();

        public abstract void _mth02CA(asq asq1, IOException ioexception);

        public abstract void _mth02CA(asq asq1, String s);

        public abstract void _mth02CA(WireMessage wiremessage);
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}

    /* member class not found */
    class _cls02CE {}


    public final String accessToken;
    final if bDo;
    final _cls02CE bDp = new _cls02CE();
    volatile WebSocket bDq;
    volatile _cls02CA bDr;
    public volatile boolean bDs;
    volatile long bDt;
    public final String endpoint;

    asq(if if1, ast ast1)
    {
        bDo = if1;
        String s = ast1.eF();
        if1 = s;
        if (s.equals("127.0.0.1:8088"))
        {
            if1 = "10.0.2.2:8088";
        }
        if (if1.startsWith("http://"))
        {
            if1 = (new StringBuilder("ws://")).append(if1.substring(7)).toString();
        } else
        if (if1.startsWith("https://"))
        {
            if1 = (new StringBuilder("wss://")).append(if1.substring(8)).toString();
        } else
        {
            if1 = (new StringBuilder("ws://")).append(if1).toString();
        }
        endpoint = if1;
        accessToken = ast1.eG();
    }

    public final void close()
    {
        IllegalStateException illegalstateexception;
        WebSocket websocket = bDq;
        if (websocket == null)
        {
            aul._mth02BF("ChatMan", "already closed");
            return;
        }
        bDq = null;
        aul._mth02BF("ChatMan", (new StringBuilder("close by self ws=")).append(websocket).toString());
        try
        {
            websocket.close(1000, "close by self");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IllegalStateException illegalstateexception)
        {
            aul._mth02BF("ChatMan", "the underlying websocket is already closed");
        }
    }
}
