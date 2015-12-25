// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

// Referenced classes of package org.spongycastle.pqc.crypto.rainbow:
//            Layer, RainbowKeyGenerationParameters, RainbowParameters, RainbowPrivateKeyParameters, 
//            RainbowPublicKeyParameters

public class RainbowKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private int aKK;
    private Layer aKk[];
    private RainbowKeyGenerationParameters aNB;
    private short aNC[][];
    private short aND[][];
    private short aNE[];
    private short aNF[][];
    private short aNG[][];
    private short aNH[];
    private int aNI[];
    private short aNJ[][];
    private short aNK[][];
    private short aNL[];
    private SecureRandom asp;
    private boolean initialized;

    public RainbowKeyPairGenerator()
    {
        initialized = false;
    }

    private void _mth02CA(short aword0[][][])
    {
        int j1 = aword0.length;
        int k1 = aword0[0].length;
        int i = (k1 * (k1 + 1)) / 2;
        aNJ = (short[][])Array.newInstance(Short.TYPE, new int[] {
            j1, i
        });
        for (int k = 0; k < j1; k++)
        {
            int l = 0;
            for (int j = 0; j < k1; j++)
            {
                for (int i1 = j; i1 < k1; i1++)
                {
                    if (i1 == j)
                    {
                        aNJ[k][l] = aword0[k][j][i1];
                    } else
                    {
                        aNJ[k][l] = GF2Field._mth02CB(aword0[k][j][i1], aword0[k][i1][j]);
                    }
                    l++;
                }

            }

        }

    }

    private void _mth0718()
    {
        int l = aNI[aNI.length - 1] - aNI[0];
        aNC = (short[][])Array.newInstance(Short.TYPE, new int[] {
            l, l
        });
        aND = null;
        ComputeInField computeinfield = new ComputeInField();
        for (; aND == null; aND = computeinfield._mth02CA(aNC))
        {
            for (int i = 0; i < l; i++)
            {
                for (int k = 0; k < l; k++)
                {
                    aNC[i][k] = (short)(asp.nextInt() & 0xff);
                }

            }

        }

        aNE = new short[l];
        for (int j = 0; j < l; j++)
        {
            aNE[j] = (short)(asp.nextInt() & 0xff);
        }

    }

    private void _mth071F()
    {
        int l = aNI[aNI.length - 1];
        aNF = (short[][])Array.newInstance(Short.TYPE, new int[] {
            l, l
        });
        aNG = null;
        ComputeInField computeinfield = new ComputeInField();
        for (; aNG == null; aNG = computeinfield._mth02CA(aNF))
        {
            for (int i = 0; i < l; i++)
            {
                for (int k = 0; k < l; k++)
                {
                    aNF[i][k] = (short)(asp.nextInt() & 0xff);
                }

            }

        }

        aNH = new short[l];
        for (int j = 0; j < l; j++)
        {
            aNH[j] = (short)(asp.nextInt() & 0xff);
        }

    }

    private void _mth0931()
    {
        aKk = new Layer[aKK];
        for (int i = 0; i < aKK; i++)
        {
            aKk[i] = new Layer(aNI[i], aNI[i + 1], asp);
        }

    }

    private void _mth098F()
    {
        new ComputeInField();
        int k2 = aNI[aNI.length - 1] - aNI[0];
        int l2 = aNI[aNI.length - 1];
        short aword0[][][] = (short[][][])Array.newInstance(Short.TYPE, new int[] {
            k2, l2, l2
        });
        aNK = (short[][])Array.newInstance(Short.TYPE, new int[] {
            k2, l2
        });
        aNL = new short[k2];
        int k = 0;
        for (int i = 0; i < aKk.length; i++)
        {
            short aword1[][][] = aKk[i].aNw;
            short aword3[][][] = aKk[i].aNx;
            short aword5[][] = aKk[i].aNy;
            short aword7[] = aKk[i].aNz;
            int i3 = aword1[0].length;
            int j3 = aword3[0].length;
            for (int i1 = 0; i1 < i3; i1++)
            {
                for (int j1 = 0; j1 < i3; j1++)
                {
                    for (int i2 = 0; i2 < j3; i2++)
                    {
                        short aword8[] = ComputeInField._mth02CA(aword1[i1][j1][i2], aNF[j1 + j3]);
                        aword0[k + i1] = ComputeInField._mth02CA(aword0[k + i1], ComputeInField._mth02CB(aword8, aNF[i2]));
                        aword8 = ComputeInField._mth02CA(aNH[i2], aword8);
                        aNK[k + i1] = ComputeInField._mth02CA(aword8, aNK[k + i1]);
                        aword8 = ComputeInField._mth02CA(aword1[i1][j1][i2], aNF[i2]);
                        aword8 = ComputeInField._mth02CA(aNH[j1 + j3], aword8);
                        aNK[k + i1] = ComputeInField._mth02CA(aword8, aNK[k + i1]);
                        short word0 = GF2Field._mth02CE(aword1[i1][j1][i2], aNH[j1 + j3]);
                        aNL[k + i1] = GF2Field._mth02CB(aNL[k + i1], GF2Field._mth02CE(word0, aNH[i2]));
                    }

                }

                for (int k1 = 0; k1 < j3; k1++)
                {
                    for (int j2 = 0; j2 < j3; j2++)
                    {
                        short aword9[] = ComputeInField._mth02CA(aword3[i1][k1][j2], aNF[k1]);
                        aword0[k + i1] = ComputeInField._mth02CA(aword0[k + i1], ComputeInField._mth02CB(aword9, aNF[j2]));
                        aword9 = ComputeInField._mth02CA(aNH[j2], aword9);
                        aNK[k + i1] = ComputeInField._mth02CA(aword9, aNK[k + i1]);
                        aword9 = ComputeInField._mth02CA(aword3[i1][k1][j2], aNF[j2]);
                        aword9 = ComputeInField._mth02CA(aNH[k1], aword9);
                        aNK[k + i1] = ComputeInField._mth02CA(aword9, aNK[k + i1]);
                        short word1 = GF2Field._mth02CE(aword3[i1][k1][j2], aNH[k1]);
                        aNL[k + i1] = GF2Field._mth02CB(aNL[k + i1], GF2Field._mth02CE(word1, aNH[j2]));
                    }

                }

                for (int l1 = 0; l1 < j3 + i3; l1++)
                {
                    short aword10[] = ComputeInField._mth02CA(aword5[i1][l1], aNF[l1]);
                    aNK[k + i1] = ComputeInField._mth02CA(aword10, aNK[k + i1]);
                    aNL[k + i1] = GF2Field._mth02CB(aNL[k + i1], GF2Field._mth02CE(aword5[i1][l1], aNH[l1]));
                }

                aNL[k + i1] = GF2Field._mth02CB(aNL[k + i1], aword7[i1]);
            }

            k += i3;
        }

        short aword2[][][] = (short[][][])Array.newInstance(Short.TYPE, new int[] {
            k2, l2, l2
        });
        short aword4[][] = (short[][])Array.newInstance(Short.TYPE, new int[] {
            k2, l2
        });
        short aword6[] = new short[k2];
        for (int j = 0; j < k2; j++)
        {
            for (int l = 0; l < aNC.length; l++)
            {
                aword2[j] = ComputeInField._mth02CA(aword2[j], ComputeInField._mth02CA(aNC[j][l], aword0[l]));
                aword4[j] = ComputeInField._mth02CA(aword4[j], ComputeInField._mth02CA(aNC[j][l], aNK[l]));
                aword6[j] = GF2Field._mth02CB(aword6[j], GF2Field._mth02CE(aNC[j][l], aNL[l]));
            }

            aword6[j] = GF2Field._mth02CB(aword6[j], aNE[j]);
        }

        aNK = aword4;
        aNL = aword6;
        _mth02CA(aword2);
    }

    public final void _mth02CB(KeyGenerationParameters keygenerationparameters)
    {
        aNB = (RainbowKeyGenerationParameters)keygenerationparameters;
        asp = new SecureRandom();
        aNI = aNB.aNA.aNI;
        aKK = aNB.aNA.aNI.length - 1;
        initialized = true;
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        if (!initialized)
        {
            _mth02CB(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
        }
        _mth0718();
        _mth071F();
        _mth0931();
        _mth098F();
        RainbowPrivateKeyParameters rainbowprivatekeyparameters = new RainbowPrivateKeyParameters(aND, aNE, aNG, aNH, aNI, aKk);
        return new AsymmetricCipherKeyPair(new RainbowPublicKeyParameters(aNI[aNI.length - 1] - aNI[0], aNJ, aNK, aNL), rainbowprivatekeyparameters);
    }
}
