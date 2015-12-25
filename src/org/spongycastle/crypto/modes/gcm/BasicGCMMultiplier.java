// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes.gcm:
//            GCMMultiplier, GCMUtil

public class BasicGCMMultiplier
    implements GCMMultiplier
{

    private byte anc[];

    public BasicGCMMultiplier()
    {
    }

    public final void init(byte abyte0[])
    {
        anc = Arrays._mth1D4C(abyte0);
    }

    public final void _mth1429(byte abyte0[])
    {
        GCMUtil._mth02BC(abyte0, anc);
    }
}
