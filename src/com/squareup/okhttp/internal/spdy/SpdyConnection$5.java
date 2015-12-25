// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, PushObserver, ErrorCode, FrameWriter

class val.inFinished extends NamedRunnable
{

    final SpdyConnection this$0;
    final boolean val$inFinished;
    final List val$requestHeaders;
    final int val$streamId;

    public void execute()
    {
        boolean flag = SpdyConnection.access$2500(SpdyConnection.this).onHeaders(val$streamId, val$requestHeaders, val$inFinished);
        SpdyConnection spdyconnection;
        Exception exception;
        if (flag)
        {
            try
            {
                frameWriter.rstStream(val$streamId, ErrorCode.CANCEL);
            }
            catch (IOException ioexception)
            {
                return;
            }
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!val$inFinished)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        spdyconnection = SpdyConnection.this;
        spdyconnection;
        JVM INSTR monitorenter ;
        SpdyConnection.access$2600(SpdyConnection.this).remove(Integer.valueOf(val$streamId));
        spdyconnection;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    transient (List list, boolean flag)
    {
        this$0 = final_spdyconnection;
        val$streamId = I.this;
        val$requestHeaders = list;
        val$inFinished = flag;
        super(final_s, final_aobj);
    }
}
