// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes.gcm:
//            GCMExponentiator, GCMUtil

public class BasicGCMExponentiator
    implements GCMExponentiator
{

    private int asZ[];

    public BasicGCMExponentiator()
    {
    }

    public final void init(byte abyte0[])
    {
        asZ = GCMUtil._mth144A(abyte0);
    }

    public final void _mth02CB(long l, byte abyte0[])
    {
        int ai[] = GCMUtil._mth01AB();
        if (l > 0L)
        {
            int ai1[] = Arrays._mth02D1(asZ);
            long l1;
            do
            {
                if ((1L & l) != 0L)
                {
                    GCMUtil._mth02CB(ai, ai1);
                }
                GCMUtil._mth02CB(ai1, ai1);
                l1 = l >>> 1;
                l = l1;
            } while (l1 > 0L);
        }
        GCMUtil._mth02CA(ai, abyte0);
    }
}
