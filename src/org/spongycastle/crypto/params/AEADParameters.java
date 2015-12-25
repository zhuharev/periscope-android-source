// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

// Referenced classes of package org.spongycastle.crypto.params:
//            KeyParameter

public class AEADParameters
    implements CipherParameters
{

    public byte XD[];
    public int auF;
    public KeyParameter avZ;
    public byte awP[];

    public AEADParameters(KeyParameter keyparameter, int i, byte abyte0[])
    {
        this(keyparameter, i, abyte0, null);
    }

    public AEADParameters(KeyParameter keyparameter, int i, byte abyte0[], byte abyte1[])
    {
        avZ = keyparameter;
        XD = abyte0;
        auF = i;
        awP = abyte1;
    }
}
