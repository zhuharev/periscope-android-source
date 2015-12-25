// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.engines.ThreefishEngine;

// Referenced classes of package org.spongycastle.crypto.digests:
//            SkeinEngine

static class bytes
{

    byte bytes[];

    public (long l)
    {
        bytes = new byte[32];
        bytes[0] = 83;
        bytes[1] = 72;
        bytes[2] = 65;
        bytes[3] = 51;
        bytes[4] = 1;
        bytes[5] = 0;
        ThreefishEngine._mth02CB(l, bytes, 8);
    }
}
