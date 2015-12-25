// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.ws.WebSocketListener;
import java.util.concurrent.Executor;
import o.vr;
import o.vv;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            RealWebSocket

class val.url
    implements FrameCallback
{

    final RealWebSocket this$0;
    final WebSocketListener val$listener;
    final Executor val$replyExecutor;
    final String val$url;

    public void onClose(int i, String s)
    {
        class _cls2 extends NamedRunnable
        {

            final RealWebSocket._cls1 this$1;
            final int val$code;
            final String val$reason;

            protected void execute()
            {
                RealWebSocket.access$100(this$0, code, reason);
            }

            transient _cls2(int i, String s1)
            {
                this$1 = RealWebSocket._cls1.this;
                code = i;
                reason = s1;
                super(final_s, final_aobj);
            }
        }

        val$replyExecutor.execute(new _cls2(i, s));
    }

    public void onMessage(vv vv, com.squareup.okhttp.ws.dType dtype)
    {
        val$listener.onMessage(vv, dtype);
    }

    public void onPing(vr vr)
    {
        class _cls1 extends NamedRunnable
        {

            final RealWebSocket._cls1 this$1;
            final vr val$buffer;

            protected void execute()
            {
                try
                {
                    RealWebSocket.access$000(this$0).writePong(buffer);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient _cls1(Object aobj[], vr vr)
            {
                this$1 = RealWebSocket._cls1.this;
                buffer = vr;
                super(final_s, aobj);
            }
        }

        val$replyExecutor.execute(new _cls1(new Object[] {
            val$url
        }, vr));
    }

    public void onPong(vr vr)
    {
        val$listener.onPong(vr);
    }

    _cls1()
    {
        this$0 = final_realwebsocket;
        val$listener = websocketlistener;
        val$replyExecutor = executor;
        val$url = String.this;
        super();
    }
}
