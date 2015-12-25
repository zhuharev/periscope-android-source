// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            ImageHeaderParser

public static final class data
{

    final ByteBuffer data;

    public (byte abyte0[])
    {
        data = ByteBuffer.wrap(abyte0);
        data.order(ByteOrder.BIG_ENDIAN);
    }
}
