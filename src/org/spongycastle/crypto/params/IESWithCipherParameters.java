// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;


// Referenced classes of package org.spongycastle.crypto.params:
//            IESParameters

public class IESWithCipherParameters extends IESParameters
{

    public int axs;

    public IESWithCipherParameters(byte abyte0[], byte abyte1[], int i, int j)
    {
        super(abyte0, abyte1, i);
        axs = j;
    }
}
