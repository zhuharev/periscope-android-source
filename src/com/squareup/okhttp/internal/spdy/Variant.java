// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import o.vu;
import o.vv;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, FrameWriter

public interface Variant
{

    public abstract Protocol getProtocol();

    public abstract FrameReader newReader(vv vv, boolean flag);

    public abstract FrameWriter newWriter(vu vu, boolean flag);
}
