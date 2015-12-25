// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import o.vr;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            RealWebSocket, WebSocketWriter

class val.buffer extends NamedRunnable
{

    final val.buffer this$1;
    final vr val$buffer;

    protected void execute()
    {
        try
        {
            RealWebSocket.access$000(_fld0).writePong(val$buffer);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (Object aobj[], vr vr)
    {
        this$1 = final_;
        val$buffer = vr;
        super(String.this, aobj);
    }
}
