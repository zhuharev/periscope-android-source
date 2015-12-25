// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

class DigestInputBuffer extends ByteArrayOutputStream
{

    DigestInputBuffer()
    {
    }

    final void _mth02CB(Digest digest)
    {
        digest.update(buf, 0, count);
    }
}
