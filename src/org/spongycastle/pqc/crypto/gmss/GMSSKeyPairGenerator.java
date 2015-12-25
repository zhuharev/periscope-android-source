// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.crypto.gmss:
//            GMSSRootCalc, Treehash, GMSSKeyGenerationParameters, GMSSParameters, 
//            GMSSUtils, GMSSPublicKeyParameters, GMSSPrivateKeyParameters

public class GMSSKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private byte aKs[][];
    private byte aKt[][];
    private byte aKu[][];
    private int aKv;
    private GMSSParameters aKw;
    private int aKx[];
    private int aKy[];
    private GMSSKeyGenerationParameters aKz;
    private int anY[];
    private boolean initialized;

    private GMSSRootCalc _mth02CA(Vector vector, byte abyte0[], int i)
    {
        GMSSRootCalc gmssrootcalc = new GMSSRootCalc(aKx[i], anY[i], null);
        gmssrootcalc._mth02CF(vector);
        byte byte0 = 3;
        int j = 0;
        if (1 << aKx[i] < 0)
        {
            int k = byte0;
            k = j;
            if (byte0 == 0)
            {
                int l = byte0;
                l = j;
                if (j < aKx[i] - anY[i])
                {
                    vector = gmssrootcalc.aLl[j];
                    System.arraycopy(abyte0, 0, ((Treehash) (vector)).aLK, 0, ((Treehash) (vector)).aLs._mth14AF());
                    vector.aLN = true;
                    i = byte0 << 1;
                    int i1 = j + 1;
                    i1 = i;
                }
            }
            throw new NullPointerException();
        }
        if (gmssrootcalc.aLu)
        {
            return gmssrootcalc;
        } else
        {
            System.err.println("N\uFFFDchster Baum noch nicht fertig konstruiert!!!");
            return null;
        }
    }

    private GMSSRootCalc _mth02CA(byte abyte0[], Vector vector, byte abyte1[], int i)
    {
        throw new NullPointerException();
    }

    private void _mth02CA(GMSSKeyGenerationParameters gmsskeygenerationparameters)
    {
        aKz = (GMSSKeyGenerationParameters)gmsskeygenerationparameters;
        aKw = new GMSSParameters(aKz.aKr.aKK, Arrays._mth02D1(aKz.aKr.aKx), Arrays._mth02D1(aKz.aKr.aKL), Arrays._mth02D1(aKz.aKr.anY));
        aKv = aKw.aKK;
        aKx = Arrays._mth02D1(aKw.aKx);
        aKy = Arrays._mth02D1(aKw.aKL);
        anY = Arrays._mth02D1(aKw.anY);
        int i = aKv;
        aKs = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            i, 0
        });
        i = aKv;
        aKt = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            i - 1, 0
        });
        gmsskeygenerationparameters = new SecureRandom();
        if (aKv < 0)
        {
            gmsskeygenerationparameters.nextBytes(aKs[0]);
            gmsskeygenerationparameters = aKs[0];
            throw new NullPointerException();
        } else
        {
            initialized = true;
            return;
        }
    }

    private AsymmetricCipherKeyPair _mth062B()
    {
        byte abyte0[][][];
        byte abyte1[][][];
        Treehash atreehash[][];
        Treehash atreehash1[][];
        Vector avector[];
        Vector avector1[];
        Vector avector2[][];
        Vector avector3[][];
        byte abyte2[][];
        byte abyte3[][];
        byte abyte4[][];
        int j;
        if (!initialized)
        {
            _mth02CA(new GMSSKeyGenerationParameters(new SecureRandom(), new GMSSParameters(4, new int[] {
                10, 10, 10, 10
            }, new int[] {
                3, 3, 3, 3
            }, new int[] {
                2, 2, 2, 2
            })));
        }
        abyte0 = new byte[aKv][][];
        abyte1 = new byte[aKv - 1][][];
        atreehash = new Treehash[aKv][];
        atreehash1 = new Treehash[aKv - 1][];
        avector = new Vector[aKv];
        avector1 = new Vector[aKv - 1];
        avector2 = new Vector[aKv][];
        avector3 = new Vector[aKv - 1][];
        for (int i = 0; i < aKv; i++)
        {
            int l = aKx[i];
            abyte0[i] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                l, 0
            });
            atreehash[i] = new Treehash[aKx[i] - anY[i]];
            if (i > 0)
            {
                int i1 = aKx[i];
                abyte1[i - 1] = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                    i1, 0
                });
                atreehash1[i - 1] = new Treehash[aKx[i] - anY[i]];
            }
            avector[i] = new Vector();
            if (i > 0)
            {
                avector1[i - 1] = new Vector();
            }
        }

        j = aKv;
        abyte2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j, 0
        });
        j = aKv;
        abyte3 = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j - 1, 0
        });
        j = aKv;
        abyte4 = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j, 0
        });
        for (j = 0; j < aKv; j++)
        {
            System.arraycopy(aKs[j], 0, abyte4[j], 0, 0);
        }

        j = aKv;
        aKu = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
            j - 1, 0
        });
        j = aKv - 1;
_L3:
        if (j < 0) goto _L2; else goto _L1
_L1:
        GMSSRootCalc gmssrootcalc = new GMSSRootCalc(aKx[j], anY[j], null);
        GMSSRootCalc gmssrootcalc2;
        if (j != aKv - 1)
        {
            break MISSING_BLOCK_LABEL_580;
        }
        gmssrootcalc2 = _mth02CA(null, avector[j], abyte4[j], j);
        gmssrootcalc = gmssrootcalc2;
        break MISSING_BLOCK_LABEL_614;
        gmssrootcalc2 = _mth02CA(abyte2[j + 1], avector[j], abyte4[j], j);
        gmssrootcalc = gmssrootcalc2;
        break MISSING_BLOCK_LABEL_614;
        Exception exception;
        exception;
        exception.printStackTrace();
        for (int j1 = 0; j1 < aKx[j]; j1++)
        {
            System.arraycopy(GMSSUtils._mth02CA(gmssrootcalc.aLo)[j1], 0, abyte0[j][j1], 0, 0);
        }

        avector2[j] = GMSSUtils._mth02CA(gmssrootcalc.aLm);
        atreehash[j] = GMSSUtils._mth02CA(gmssrootcalc.aLl);
        System.arraycopy(Arrays._mth1D4C(gmssrootcalc.aLn), 0, abyte2[j], 0, 0);
        j--;
          goto _L3
_L2:
        for (int k = aKv - 2; k >= 0; k--)
        {
            GMSSRootCalc gmssrootcalc1 = _mth02CA(avector1[k], abyte4[k + 1], k + 1);
            for (int k1 = 0; k1 < aKx[k + 1]; k1++)
            {
                System.arraycopy(GMSSUtils._mth02CA(gmssrootcalc1.aLo)[k1], 0, abyte1[k][k1], 0, 0);
            }

            avector3[k] = GMSSUtils._mth02CA(gmssrootcalc1.aLm);
            atreehash1[k] = GMSSUtils._mth02CA(gmssrootcalc1.aLl);
            System.arraycopy(Arrays._mth1D4C(gmssrootcalc1.aLn), 0, abyte3[k], 0, 0);
            System.arraycopy(abyte4[k + 1], 0, aKt[k], 0, 0);
        }

        return new AsymmetricCipherKeyPair(new GMSSPublicKeyParameters(abyte2[0], aKw), new GMSSPrivateKeyParameters(aKs, aKt, abyte0, abyte1, atreehash, atreehash1, avector, avector1, avector2, avector3, abyte3, aKu, aKw, null));
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        return _mth062B();
    }
}
