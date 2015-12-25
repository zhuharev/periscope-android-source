// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.logging.Level;
import java.util.logging.Logger;
import o.vr;
import o.vv;
import o.wn;
import o.wo;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Http2

static final class source
    implements wn
{

    byte flags;
    int left;
    int length;
    short padding;
    private final vv source;
    int streamId;

    private void readContinuationHeader()
    {
        int i = streamId;
        int j = Http2.access$300(source);
        left = j;
        length = j;
        byte byte0 = source.readByte();
        flags = source.readByte();
        if (Http2.access$100().isLoggable(Level.FINE))
        {
            Http2.access$100().fine(eader(true, streamId, length, byte0, flags));
        }
        streamId = source.readInt() & 0x7fffffff;
        if (byte0 != 9)
        {
            throw Http2.access$200("%s != TYPE_CONTINUATION", new Object[] {
                Byte.valueOf(byte0)
            });
        }
        if (streamId != i)
        {
            throw Http2.access$200("TYPE_CONTINUATION streamId changed", new Object[0]);
        } else
        {
            return;
        }
    }

    public final void close()
    {
    }

    public final long read(vr vr, long l)
    {
        while (left == 0) 
        {
            source._mth02D1(padding);
            padding = 0;
            if ((flags & 4) != 0)
            {
                return -1L;
            }
            readContinuationHeader();
        }
        l = source.read(vr, Math.min(l, left));
        if (l == -1L)
        {
            return -1L;
        } else
        {
            left = (int)((long)left - l);
            return l;
        }
    }

    public final wo timeout()
    {
        return source.timeout();
    }

    public (vv vv1)
    {
        source = vv1;
    }
}
