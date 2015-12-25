// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

// Referenced classes of package org.spongycastle.pqc.crypto.rainbow:
//            RainbowPrivateKeyParameters, Layer, RainbowPublicKeyParameters, RainbowKeyParameters

public class RainbowSigner
    implements MessageSigner
{

    private int aNR;
    private short aNS[];
    private ComputeInField aNT;
    private RainbowKeyParameters aNU;
    private SecureRandom amC;

    public RainbowSigner()
    {
        aNT = new ComputeInField();
    }

    private short[] _mth1424(byte abyte0[])
    {
        short aword0[] = new short[aNR];
        int j = 0;
        int i = 0;
        int k;
        do
        {
            if (i >= abyte0.length)
            {
                break;
            }
            aword0[i] = abyte0[j];
            aword0[i] = (short)(aword0[i] & 0xff);
            j++;
            k = i + 1;
            i = k;
        } while (k < aword0.length);
        return aword0;
    }

    public final byte[] _mth02B2(byte abyte0[])
    {
        Layer alayer[];
        byte abyte1[];
        int k1;
        alayer = ((RainbowPrivateKeyParameters)aNU).aKk;
        k1 = alayer.length;
        aNS = new short[((RainbowPrivateKeyParameters)aNU).aNG.length];
        abyte1 = new byte[alayer[k1 - 1].aNu];
        abyte0 = _mth1424(abyte0);
_L34:
        int j;
        boolean flag;
        flag = true;
        j = 0;
        short aword0[];
        aword0 = ComputeInField._mth02CA(((RainbowPrivateKeyParameters)aNU).aNE, abyte0);
        aword0 = ComputeInField._mth02CB(((RainbowPrivateKeyParameters)aNU).aND, aword0);
        int i = 0;
_L2:
        short aword1[];
        if (i >= alayer[0].aNt)
        {
            break; /* Loop/switch isn't completed */
        }
        aNS[i] = (short)amC.nextInt();
        aword1 = aNS;
        aword1[i] = (short)(aword1[i] & 0xff);
        i++;
        if (true) goto _L2; else goto _L1
_L36:
        if (i >= k1) goto _L4; else goto _L3
_L3:
        aword1 = new short[alayer[i].aNv];
        int k = 0;
        while (k < alayer[i].aNv) 
        {
            aword1[k] = aword0[j];
            j++;
            k++;
        }
        ComputeInField computeinfield = aNT;
        Layer layer = alayer[i];
        short aword2[];
        short aword3[][];
        short aword4[];
        aword2 = aNS;
        k = layer.aNv;
        int l = layer.aNv;
        aword3 = (short[][])Array.newInstance(Short.TYPE, new int[] {
            k, l + 1
        });
        aword4 = new short[layer.aNv];
        k = 0;
_L38:
        if (k >= layer.aNv) goto _L6; else goto _L5
_L5:
        int i1 = 0;
_L37:
        if (i1 >= layer.aNt) goto _L8; else goto _L7
_L7:
        int j1 = 0;
_L10:
        if (j1 >= layer.aNt)
        {
            break; /* Loop/switch isn't completed */
        }
        short word0 = GF2Field._mth02CE(GF2Field._mth02CE(layer.aNx[k][i1][j1], aword2[i1]), aword2[j1]);
        aword4[k] = GF2Field._mth02CB(aword4[k], word0);
        j1++;
        if (true) goto _L10; else goto _L9
_L39:
        if (k >= layer.aNv) goto _L12; else goto _L11
_L11:
        i1 = 0;
_L40:
        if (i1 >= layer.aNv) goto _L14; else goto _L13
_L13:
        j1 = 0;
_L16:
        if (j1 >= layer.aNt)
        {
            break; /* Loop/switch isn't completed */
        }
        short word1 = GF2Field._mth02CE(layer.aNw[k][i1][j1], aword2[j1]);
        aword3[k][i1] = GF2Field._mth02CB(aword3[k][i1], word1);
        j1++;
        if (true) goto _L16; else goto _L15
_L41:
        if (k >= layer.aNv) goto _L18; else goto _L17
_L17:
        i1 = 0;
_L20:
        if (i1 >= layer.aNt)
        {
            break; /* Loop/switch isn't completed */
        }
        short word2 = GF2Field._mth02CE(layer.aNy[k][i1], aword2[i1]);
        aword4[k] = GF2Field._mth02CB(aword4[k], word2);
        i1++;
        if (true) goto _L20; else goto _L19
_L42:
        if (k >= layer.aNv) goto _L22; else goto _L21
_L21:
        i1 = layer.aNt;
_L25:
        if (i1 >= layer.aNu) goto _L24; else goto _L23
_L23:
        aword3[k][i1 - layer.aNt] = GF2Field._mth02CB(layer.aNy[k][i1], aword3[k][i1 - layer.aNt]);
        i1++;
          goto _L25
_L28:
        if (k >= layer.aNv) goto _L27; else goto _L26
_L26:
        aword4[k] = GF2Field._mth02CB(aword4[k], layer.aNz[k]);
        k++;
          goto _L28
_L29:
        if (k >= layer.aNv)
        {
            break MISSING_BLOCK_LABEL_674;
        }
        aword3[k][layer.aNv] = aword4[k];
        k++;
          goto _L29
        aword1 = computeinfield._mth02CA(aword3, aword1);
        if (aword1 != null) goto _L31; else goto _L30
_L30:
        throw new Exception("LES is not solveable!");
_L32:
        if (k >= aword1.length)
        {
            break MISSING_BLOCK_LABEL_923;
        }
        aNS[alayer[i].aNt + k] = aword1[k];
        k++;
          goto _L32
_L4:
        aword0 = ComputeInField._mth02CA(((RainbowPrivateKeyParameters)aNU).aNH, aNS);
        aword0 = ComputeInField._mth02CB(((RainbowPrivateKeyParameters)aNU).aNG, aword0);
        i = 0;
        while (i < abyte1.length) 
        {
            abyte1[i] = (byte)aword0[i];
            i++;
        }
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L35:
        i = 0;
        if (i == 0) goto _L34; else goto _L33
_L33:
        return abyte1;
        Exception exception;
        exception;
          goto _L35
_L1:
        i = 0;
          goto _L36
_L9:
        i1++;
          goto _L37
_L8:
        k++;
          goto _L38
_L6:
        k = 0;
          goto _L39
_L15:
        i1++;
          goto _L40
_L14:
        k++;
          goto _L39
_L12:
        k = 0;
          goto _L41
_L19:
        k++;
          goto _L41
_L18:
        k = 0;
          goto _L42
_L24:
        k++;
          goto _L42
_L22:
        k = 0;
          goto _L28
_L27:
        k = 0;
          goto _L29
_L31:
        k = 0;
          goto _L32
        i++;
          goto _L36
    }

    public final boolean _mth02C9(byte abyte0[], byte abyte1[])
    {
        short aword0[] = new short[abyte1.length];
        for (int i = 0; i < abyte1.length; i++)
        {
            aword0[i] = (short)((short)abyte1[i] & 0xff);
        }

        abyte0 = _mth1424(abyte0);
        abyte1 = ((RainbowPublicKeyParameters)aNU).aNO;
        short aword1[][] = ((RainbowPublicKeyParameters)aNU).aNP;
        short aword2[] = ((RainbowPublicKeyParameters)aNU).aNQ;
        short aword3[] = new short[abyte1.length];
        int k1 = aword1[0].length;
        for (int l = 0; l < abyte1.length; l++)
        {
            int i1 = 0;
            for (int j = 0; j < k1; j++)
            {
                for (int j1 = j; j1 < k1; j1++)
                {
                    short word0 = GF2Field._mth02CE(abyte1[l][i1], GF2Field._mth02CE(aword0[j], aword0[j1]));
                    aword3[l] = GF2Field._mth02CB(aword3[l], word0);
                    i1++;
                }

                short word1 = GF2Field._mth02CE(aword1[l][j], aword0[j]);
                aword3[l] = GF2Field._mth02CB(aword3[l], word1);
            }

            aword3[l] = GF2Field._mth02CB(aword3[l], aword2[l]);
        }

        boolean flag = true;
        if (abyte0.length != aword3.length)
        {
            return false;
        }
        for (int k = 0; k < abyte0.length; k++)
        {
            if (flag && abyte0[k] == aword3[k])
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        return flag;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        if (flag)
        {
            if (cipherparameters instanceof ParametersWithRandom)
            {
                cipherparameters = (ParametersWithRandom)cipherparameters;
                amC = ((ParametersWithRandom) (cipherparameters)).amC;
                aNU = (RainbowPrivateKeyParameters)((ParametersWithRandom) (cipherparameters)).axC;
            } else
            {
                amC = new SecureRandom();
                aNU = (RainbowPrivateKeyParameters)cipherparameters;
            }
        } else
        {
            aNU = (RainbowPublicKeyParameters)cipherparameters;
        }
        aNR = aNU.aNM;
    }
}
