// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.util.Arrays;

public class Layer
{

    int aNt;
    int aNu;
    int aNv;
    public short aNw[][][];
    public short aNx[][][];
    public short aNy[][];
    public short aNz[];

    public Layer(byte byte0, byte byte1, short aword0[][][], short aword1[][][], short aword2[][], short aword3[])
    {
        aNt = byte0 & 0xff;
        aNu = byte1 & 0xff;
        aNv = aNu - aNt;
        aNw = aword0;
        aNx = aword1;
        aNy = aword2;
        aNz = aword3;
    }

    public Layer(int i, int j, SecureRandom securerandom)
    {
        aNt = i;
        aNu = j;
        aNv = j - i;
        i = aNv;
        j = aNv;
        int k = aNt;
        aNw = (short[][][])Array.newInstance(Short.TYPE, new int[] {
            i, j, k
        });
        i = aNv;
        j = aNt;
        k = aNt;
        aNx = (short[][][])Array.newInstance(Short.TYPE, new int[] {
            i, j, k
        });
        i = aNv;
        j = aNu;
        aNy = (short[][])Array.newInstance(Short.TYPE, new int[] {
            i, j
        });
        aNz = new short[aNv];
        int j1 = aNv;
        for (i = 0; i < j1; i++)
        {
            for (j = 0; j < aNv; j++)
            {
                for (int l = 0; l < aNt; l++)
                {
                    aNw[i][j][l] = (short)(securerandom.nextInt() & 0xff);
                }

            }

        }

        for (i = 0; i < j1; i++)
        {
            for (j = 0; j < aNt; j++)
            {
                for (int i1 = 0; i1 < aNt; i1++)
                {
                    aNx[i][j][i1] = (short)(securerandom.nextInt() & 0xff);
                }

            }

        }

        for (i = 0; i < j1; i++)
        {
            for (j = 0; j < aNu; j++)
            {
                aNy[i][j] = (short)(securerandom.nextInt() & 0xff);
            }

        }

        for (i = 0; i < j1; i++)
        {
            aNz[i] = (short)(securerandom.nextInt() & 0xff);
        }

    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Layer))
        {
            return false;
        }
        obj = (Layer)obj;
        return aNt == ((Layer) (obj)).aNt && aNu == ((Layer) (obj)).aNu && aNv == ((Layer) (obj)).aNv && RainbowUtil._mth02CA(aNw, ((Layer) (obj)).aNw) && RainbowUtil._mth02CA(aNx, ((Layer) (obj)).aNx) && RainbowUtil._mth02CB(aNy, ((Layer) (obj)).aNy) && RainbowUtil.equals(aNz, ((Layer) (obj)).aNz);
    }

    public int hashCode()
    {
        return (((((aNt * 37 + aNu) * 37 + aNv) * 37 + Arrays._mth02CE(aNw)) * 37 + Arrays._mth02CE(aNx)) * 37 + Arrays._mth02CE(aNy)) * 37 + Arrays.hashCode(aNz);
    }
}
