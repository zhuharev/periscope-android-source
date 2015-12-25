// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.modes.gcm:
//            GCMMultiplier, GCMUtil

public class Tables64kGCMMultiplier
    implements GCMMultiplier
{

    private byte anc[];
    private int awO[][][];

    public Tables64kGCMMultiplier()
    {
    }

    public final void init(byte abyte0[])
    {
        if (awO == null)
        {
            awO = (int[][][])Array.newInstance(Integer.TYPE, new int[] {
                16, 256, 4
            });
        } else
        if (Arrays._mth1427(anc, abyte0))
        {
            return;
        }
        anc = Arrays._mth1D4C(abyte0);
        GCMUtil._mth02CB(abyte0, awO[0][128]);
        for (int i = 64; i > 0; i >>= 1)
        {
            GCMUtil._mth02CE(awO[0][i + i], awO[0][i]);
        }

        int j = 0;
        do
        {
            for (int k = 2; k < 256; k += k)
            {
                for (int i1 = 1; i1 < k; i1++)
                {
                    GCMUtil._mth02CA(awO[j][k], awO[j][i1], awO[j][k + i1]);
                }

            }

            int l = j + 1;
            if (l == 16)
            {
                return;
            }
            for (j = 128; j > 0; j >>= 1)
            {
                GCMUtil._mth02CF(awO[l - 1][j], awO[l][j]);
            }

            j = l;
        } while (true);
    }

    public final void _mth1429(byte abyte0[])
    {
        int ai[] = new int[4];
        for (int i = 15; i >= 0; i--)
        {
            int ai1[] = awO[i][abyte0[i] & 0xff];
            ai[0] = ai[0] ^ ai1[0];
            ai[1] = ai[1] ^ ai1[1];
            ai[2] = ai[2] ^ ai1[2];
            ai[3] = ai[3] ^ ai1[3];
        }

        Pack._mth02CB(ai, abyte0, 0);
    }
}
