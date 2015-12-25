// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;

// Referenced classes of package org.spongycastle.crypto.modes:
//            CCMBlockCipher

class avP extends ByteArrayOutputStream
{

    private CCMBlockCipher avP;

    public final byte[] _mth0109()
    {
        return buf;
    }

    public (CCMBlockCipher ccmblockcipher)
    {
        avP = ccmblockcipher;
        super();
    }
}
