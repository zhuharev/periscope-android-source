// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer:
//            CryptoInfo

public final class SampleHolder
{

    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public int flags;
    public int size;
    public long timeUs;

    public SampleHolder(int i)
    {
        bufferReplacementMode = i;
    }

    private ByteBuffer createReplacementBuffer(int i)
    {
        if (bufferReplacementMode == 1)
        {
            return ByteBuffer.allocate(i);
        }
        if (bufferReplacementMode == 2)
        {
            return ByteBuffer.allocateDirect(i);
        }
        int j;
        if (data == null)
        {
            j = 0;
        } else
        {
            j = data.capacity();
        }
        throw new IllegalStateException((new StringBuilder("Buffer too small (")).append(j).append(" < ").append(i).append(")").toString());
    }

    public final void clearData()
    {
        if (data != null)
        {
            data.clear();
        }
    }

    public final void ensureSpaceForWrite(int i)
    {
        if (data == null)
        {
            data = createReplacementBuffer(i);
            return;
        }
        int j = data.capacity();
        int k = data.position();
        i += k;
        if (j >= i)
        {
            return;
        }
        ByteBuffer bytebuffer = createReplacementBuffer(i);
        if (k > 0)
        {
            data.position(0);
            data.limit(k);
            bytebuffer.put(data);
        }
        data = bytebuffer;
    }

    public final boolean isDecodeOnly()
    {
        return (flags & 0x8000000) != 0;
    }

    public final boolean isEncrypted()
    {
        return (flags & 2) != 0;
    }

    public final boolean isSyncFrame()
    {
        return (flags & 1) != 0;
    }
}
