// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.encoders.Hex;

public class GMSSLeaf
{

    private Digest aKA;
    private int aKB;
    private int aKC;
    private GMSSRandom aKD;
    private byte aKE[];
    private byte aKF[];
    private int aKG;
    private int aKH;
    private int aKI;
    private byte aKJ[];
    private int afL;
    private byte aln[];
    private int w;

    GMSSLeaf(Digest digest, int i, int j)
    {
        w = i;
        aKA = digest;
        aKD = new GMSSRandom(aKA);
        aKB = aKA._mth14AF();
        int k = (int)Math.ceil((double)(aKB << 3) / (double)i);
        aKC = (int)Math.ceil((double)_mth1D4F((k << i) + 1) / (double)i) + k;
        aKH = 1 << i;
        aKI = (int)Math.ceil((double)(((1 << i) - 1) * aKC + 1 + aKC) / (double)j);
        aln = new byte[aKB];
        aKE = new byte[aKB];
        aKJ = new byte[aKB];
        aKF = new byte[aKB * aKC];
    }

    public GMSSLeaf(Digest digest, int i, int j, byte abyte0[])
    {
        w = i;
        aKA = digest;
        aKD = new GMSSRandom(aKA);
        aKB = aKA._mth14AF();
        int k = (int)Math.ceil((double)(aKB << 3) / (double)i);
        aKC = (int)Math.ceil((double)_mth1D4F((k << i) + 1) / (double)i) + k;
        aKH = 1 << i;
        aKI = (int)Math.ceil((double)(((1 << i) - 1) * aKC + 1 + aKC) / (double)j);
        aln = new byte[aKB];
        aKE = new byte[aKB];
        aKJ = new byte[aKB];
        aKF = new byte[aKB * aKC];
        aKG = 0;
        afL = 0;
        digest = new byte[aKB];
        System.arraycopy(abyte0, 0, digest, 0, aln.length);
        aln = aKD._mth02D0(digest);
    }

    private static int _mth1D4F(int i)
    {
        int j = 1;
        for (int k = 2; k < i;)
        {
            k <<= 1;
            j++;
        }

        return j;
    }

    public String toString()
    {
        String s = "";
        for (int i = 0; i < 4; i++)
        {
            s = (new StringBuilder()).append(s).append((new int[] {
                0, 0, aKI, w
            })[i]).append(" ").toString();
        }

        s = (new StringBuilder()).append(s).append(" ").append(aKB).append(" ").append(aKC).append(" ").append(aKH).append(" ").toString();
        byte abyte0[][] = new byte[4][];
        abyte0[0] = new byte[aKB];
        abyte0[1] = new byte[aKB];
        abyte0[2] = new byte[aKB * aKC];
        abyte0[3] = new byte[aKB];
        abyte0[0] = aKJ;
        abyte0[1] = aln;
        abyte0[2] = aKF;
        abyte0[3] = aKE;
        for (int j = 0; j < 4; j++)
        {
            if (abyte0[j] != null)
            {
                s = (new StringBuilder()).append(s).append(new String(Hex._mth1D65(abyte0[j]))).append(" ").toString();
            } else
            {
                s = (new StringBuilder()).append(s).append("null ").toString();
            }
        }

        return s;
    }
}
