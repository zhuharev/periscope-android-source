// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

// Referenced classes of package org.spongycastle.crypto.modes.gcm:
//            GCMMultiplier, GCMUtil

public class Tables8kGCMMultiplier
    implements GCMMultiplier
{

    private byte anc[];
    private int awO[][][];

    public Tables8kGCMMultiplier()
    {
    }

    public final void init(byte abyte0[])
    {
        if (awO == null)
        {
            awO = (int[][][])Array.newInstance(Integer.TYPE, new int[] {
                32, 16, 4
            });
        } else
        if (Arrays._mth1427(anc, abyte0))
        {
            return;
        }
        anc = Arrays._mth1D4C(abyte0);
        GCMUtil._mth02CB(abyte0, awO[1][8]);
        for (int i = 4; i > 0; i >>= 1)
        {
            GCMUtil._mth02CE(awO[1][i + i], awO[1][i]);
        }

        GCMUtil._mth02CE(awO[1][1], awO[0][8]);
        for (int j = 4; j > 0; j >>= 1)
        {
            GCMUtil._mth02CE(awO[0][j + j], awO[0][j]);
        }

        int k = 0;
        do
        {
            int i1;
            do
            {
                for (int l = 2; l < 16; l += l)
                {
                    for (int j1 = 1; j1 < l; j1++)
                    {
                        GCMUtil._mth02CA(awO[k][l], awO[k][j1], awO[k][l + j1]);
                    }

                }

                i1 = k + 1;
                if (i1 == 32)
                {
                    return;
                }
                k = i1;
            } while (i1 <= 1);
            for (k = 8; k > 0; k >>= 1)
            {
                GCMUtil._mth02CF(awO[i1 - 2][k], awO[i1][k]);
            }

            k = i1;
        } while (true);
    }

    public final void _mth1429(byte abyte0[])
    {
        int ai[] = new int[4];
        for (int i = 15; i >= 0; i--)
        {
            int ai1[] = awO[i + i][abyte0[i] & 0xf];
            ai[0] = ai[0] ^ ai1[0];
            ai[1] = ai[1] ^ ai1[1];
            ai[2] = ai[2] ^ ai1[2];
            ai[3] = ai[3] ^ ai1[3];
            ai1 = awO[i + i + 1][(abyte0[i] & 0xf0) >>> 4];
            ai[0] = ai[0] ^ ai1[0];
            ai[1] = ai[1] ^ ai1[1];
            ai[2] = ai[2] ^ ai1[2];
            ai[3] = ai[3] ^ ai1[3];
        }

        Pack._mth02CB(ai, abyte0, 0);
    }
}
