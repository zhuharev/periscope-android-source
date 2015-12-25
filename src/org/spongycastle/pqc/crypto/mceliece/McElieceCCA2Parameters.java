// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.digests.SHA256Digest;

// Referenced classes of package org.spongycastle.pqc.crypto.mceliece:
//            McElieceParameters

public class McElieceCCA2Parameters extends McElieceParameters
{

    public SHA256Digest aLT;

    public McElieceCCA2Parameters()
    {
        aLT = new SHA256Digest();
    }

    public McElieceCCA2Parameters(int i, int j)
    {
        super(i, j);
        aLT = new SHA256Digest();
    }
}
