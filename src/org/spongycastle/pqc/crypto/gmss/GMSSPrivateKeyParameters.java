// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSKeyParameters, GMSSDigestProvider, GMSSParameters, GMSSRootCalc, 
//            GMSSLeaf, GMSSRootSig, Treehash

public class GMSSPrivateKeyParameters extends GMSSKeyParameters
{

    private GMSSRandom aKD;
    int aKM[];
    byte aKN[][][];
    private byte aKO[][][];
    private Treehash aKP[][];
    private Treehash aKQ[][];
    private Vector aKR[];
    private Vector aKS[];
    private Vector aKT[][];
    private Vector aKU[][];
    private byte aKV[][][];
    private GMSSLeaf aKW[];
    private GMSSLeaf aKX[];
    private GMSSLeaf aKY[];
    private int aKZ[];
    byte aKs[][];
    private byte aKt[][];
    private int aKv;
    private GMSSParameters aKw;
    private int aKx[];
    private int aKy[];
    private byte aLa[][];
    private GMSSRootCalc aLb[];
    byte aLc[][];
    private GMSSRootSig aLd[];
    private GMSSDigestProvider aLe;
    boolean aLf;
    private Digest aLg;
    private int aLh;
    int aLi[];
    private int anY[];

    private GMSSPrivateKeyParameters(int ai[], byte abyte0[][], byte abyte1[][], byte abyte2[][][], byte abyte3[][][], byte abyte4[][][], Treehash atreehash[][], 
            Treehash atreehash1[][], Vector avector[], Vector avector1[], Vector avector2[][], Vector avector3[][], GMSSLeaf agmssleaf[], GMSSLeaf agmssleaf1[], 
            GMSSLeaf agmssleaf2[], int ai1[], byte abyte5[][], GMSSRootCalc agmssrootcalc[], byte abyte6[][], GMSSRootSig agmssrootsig[], GMSSParameters gmssparameters, 
            GMSSDigestProvider gmssdigestprovider)
    {
        super(true, gmssparameters);
        aLf = false;
        aLg = gmssdigestprovider._mth05EA();
        aLh = aLg._mth14AF();
        aKw = gmssparameters;
        aKy = Arrays._mth02D1(gmssparameters.aKL);
        anY = Arrays._mth02D1(gmssparameters.anY);
        aKx = Arrays._mth02D1(gmssparameters.aKx);
        aKv = aKw.aKK;
        aKM = new int[aKv];
        for (int i = 0; i < aKv; i++)
        {
            aKM[i] = 0;
        }

        aKs = abyte0;
        aKt = abyte1;
        aKN = abyte2;
        aKO = abyte3;
        if (abyte4 == null)
        {
            aKV = new byte[aKv][][];
            for (int j = 0; j < aKv; j++)
            {
                ai = aKV;
                int l2 = aKx[j] / 2;
                int i3 = aLh;
                ai[j] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                    l2, i3
                });
            }

        } else
        {
            aKV = abyte4;
        }
        if (avector == null)
        {
            aKR = new Vector[aKv];
            for (int k = 0; k < aKv; k++)
            {
                aKR[k] = new Vector();
            }

        } else
        {
            aKR = avector;
        }
        if (avector1 == null)
        {
            aKS = new Vector[aKv - 1];
            for (int l = 0; l < aKv - 1; l++)
            {
                aKS[l] = new Vector();
            }

        } else
        {
            aKS = avector1;
        }
        aKP = atreehash;
        aKQ = atreehash1;
        aKT = avector2;
        aKU = avector3;
        aLa = abyte5;
        aLe = gmssdigestprovider;
        aLb = new GMSSRootCalc[aKv - 1];
        for (int i1 = 0; i1 < aKv - 1; i1++)
        {
            aLb[i1] = new GMSSRootCalc(aKx[i1 + 1], anY[i1 + 1], aLe);
        }

        aLc = abyte6;
        aLi = new int[aKv];
        for (int j1 = 0; j1 < aKv; j1++)
        {
            aLi[j1] = 1 << aKx[j1];
        }

        aKD = new GMSSRandom(aLg);
        if (aKv > 1)
        {
            aKW = new GMSSLeaf[aKv - 2];
            for (int k1 = 0; k1 < aKv - 2; k1++)
            {
                aKW[k1] = new GMSSLeaf(gmssdigestprovider._mth05EA(), aKy[k1 + 1], aLi[k1 + 2], aKt[k1]);
            }

        } else
        {
            aKW = new GMSSLeaf[0];
        }
        aKX = new GMSSLeaf[aKv - 1];
        for (int l1 = 0; l1 < aKv - 1; l1++)
        {
            aKX[l1] = new GMSSLeaf(gmssdigestprovider._mth05EA(), aKy[l1], aLi[l1 + 1], aKs[l1]);
        }

        aKY = new GMSSLeaf[aKv - 1];
        for (int i2 = 0; i2 < aKv - 1; i2++)
        {
            aKY[i2] = new GMSSLeaf(gmssdigestprovider._mth05EA(), aKy[i2], aLi[i2 + 1]);
        }

        aKZ = new int[aKv - 1];
        for (int j2 = 0; j2 < aKv - 1; j2++)
        {
            aKZ[j2] = -1;
        }

        ai = new byte[aLh];
        aLd = new GMSSRootSig[aKv - 1];
        for (int k2 = 0; k2 < aKv - 1; k2++)
        {
            System.arraycopy(abyte0[k2], 0, ai, 0, aLh);
            aKD._mth02D0(ai);
            abyte1 = aKD._mth02D0(ai);
            aLd[k2] = new GMSSRootSig(gmssdigestprovider._mth05EA(), aKy[k2], aKx[k2 + 1]);
            aLd[k2]._mth02CC(abyte1, abyte5[k2]);
        }

    }

    public GMSSPrivateKeyParameters(byte abyte0[][], byte abyte1[][], byte abyte2[][][], byte abyte3[][][], Treehash atreehash[][], Treehash atreehash1[][], Vector avector[], 
            Vector avector1[], Vector avector2[][], Vector avector3[][], byte abyte4[][], byte abyte5[][], GMSSParameters gmssparameters, GMSSDigestProvider gmssdigestprovider)
    {
        this(null, abyte0, abyte1, abyte2, abyte3, null, atreehash, atreehash1, avector, avector1, avector2, avector3, null, null, null, null, abyte4, null, abyte5, null, gmssparameters, gmssdigestprovider);
    }
}
