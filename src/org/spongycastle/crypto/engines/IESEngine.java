// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.EphemeralKeyPair;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Pack;

public class IESEngine
{

    public boolean amy;
    public byte anr[];
    private BasicAgreement arL;
    private DerivationFunction arM;
    public Mac arN;
    public BufferedBlockCipher arO;
    private byte arP[];
    public CipherParameters arQ;
    public CipherParameters arR;
    private IESParameters arS;
    public EphemeralKeyPairGenerator arT;
    public KeyParser arU;
    private byte arV[];

    public IESEngine(BasicAgreement basicagreement, KDF2BytesGenerator kdf2bytesgenerator, HMac hmac)
    {
        arL = basicagreement;
        arM = kdf2bytesgenerator;
        arN = hmac;
        arP = new byte[hmac._mth14B3()];
        arO = null;
    }

    public IESEngine(BasicAgreement basicagreement, KDF2BytesGenerator kdf2bytesgenerator, HMac hmac, PaddedBufferedBlockCipher paddedbufferedblockcipher)
    {
        arL = basicagreement;
        arM = kdf2bytesgenerator;
        arN = hmac;
        arP = new byte[hmac._mth14B3()];
        arO = paddedbufferedblockcipher;
    }

    private byte[] _mth02CD(byte abyte0[], int i, int j)
    {
        byte abyte1[];
        if (arO == null)
        {
            byte abyte5[] = new byte[j];
            abyte1 = new byte[arS.axr / 8];
            byte abyte2[] = new byte[abyte5.length + abyte1.length];
            arM._mth02BF(abyte2, 0, abyte2.length);
            if (anr.length != 0)
            {
                System.arraycopy(abyte2, 0, abyte1, 0, abyte1.length);
                System.arraycopy(abyte2, abyte1.length, abyte5, 0, abyte5.length);
            } else
            {
                System.arraycopy(abyte2, 0, abyte5, 0, abyte5.length);
                System.arraycopy(abyte2, j, abyte1, 0, abyte1.length);
            }
            abyte2 = new byte[j];
            for (int k = 0; k != j; k++)
            {
                abyte2[k] = (byte)(abyte0[i + k] ^ abyte5[k]);
            }

            abyte0 = abyte2;
        } else
        {
            byte abyte3[] = new byte[((IESWithCipherParameters)arS).axs / 8];
            abyte1 = new byte[arS.axr / 8];
            byte abyte6[] = new byte[abyte3.length + abyte1.length];
            arM._mth02BF(abyte6, 0, abyte6.length);
            System.arraycopy(abyte6, 0, abyte3, 0, abyte3.length);
            System.arraycopy(abyte6, abyte3.length, abyte1, 0, abyte1.length);
            if (arV != null)
            {
                arO._mth02CA(true, new ParametersWithIV(new KeyParameter(abyte3), arV));
            } else
            {
                arO._mth02CA(true, new KeyParameter(abyte3));
            }
            abyte3 = new byte[arO.getOutputSize(j)];
            i = arO._mth02CB(abyte0, i, j, abyte3, 0);
            j = i + arO.doFinal(abyte3, i);
            abyte0 = abyte3;
        }
        byte abyte7[] = arS.axq;
        byte abyte8[] = new byte[4];
        if (anr.length != 0 && abyte7 != null)
        {
            Pack._mth1FBE(abyte7.length << 3, abyte8, 0);
        }
        byte abyte4[] = new byte[arN._mth14B3()];
        arN._mth02CA(new KeyParameter(abyte1));
        arN.update(abyte0, 0, abyte0.length);
        if (abyte7 != null)
        {
            arN.update(abyte7, 0, abyte7.length);
        }
        if (anr.length != 0)
        {
            arN.update(abyte8, 0, 4);
        }
        arN.doFinal(abyte4, 0);
        abyte1 = new byte[anr.length + j + abyte4.length];
        System.arraycopy(anr, 0, abyte1, 0, anr.length);
        System.arraycopy(abyte0, 0, abyte1, anr.length, j);
        System.arraycopy(abyte4, 0, abyte1, anr.length + j, abyte4.length);
        return abyte1;
    }

    private byte[] _mth02D1(byte abyte0[], int i, int j)
    {
        if (j <= arS.axr / 8)
        {
            throw new InvalidCipherTextException("Length of input must be greater than the MAC");
        }
        byte abyte1[];
        byte abyte2[];
        int l;
        if (arO == null)
        {
            byte abyte3[] = new byte[j - anr.length - arN._mth14B3()];
            abyte2 = new byte[arS.axr / 8];
            abyte1 = new byte[abyte3.length + abyte2.length];
            arM._mth02BF(abyte1, 0, abyte1.length);
            if (anr.length != 0)
            {
                System.arraycopy(abyte1, 0, abyte2, 0, abyte2.length);
                System.arraycopy(abyte1, abyte2.length, abyte3, 0, abyte3.length);
            } else
            {
                System.arraycopy(abyte1, 0, abyte3, 0, abyte3.length);
                System.arraycopy(abyte1, abyte3.length, abyte2, 0, abyte2.length);
            }
            abyte1 = new byte[abyte3.length];
            for (int k = 0; k != abyte3.length; k++)
            {
                abyte1[k] = (byte)(abyte0[anr.length + i + k] ^ abyte3[k]);
            }

            l = abyte3.length;
        } else
        {
            abyte1 = new byte[((IESWithCipherParameters)arS).axs / 8];
            abyte2 = new byte[arS.axr / 8];
            byte abyte4[] = new byte[abyte1.length + abyte2.length];
            arM._mth02BF(abyte4, 0, abyte4.length);
            System.arraycopy(abyte4, 0, abyte1, 0, abyte1.length);
            System.arraycopy(abyte4, abyte1.length, abyte2, 0, abyte2.length);
            if (arV != null)
            {
                arO._mth02CA(false, new ParametersWithIV(new KeyParameter(abyte1), arV));
            } else
            {
                arO._mth02CA(false, new KeyParameter(abyte1));
            }
            abyte1 = new byte[arO.getOutputSize(j - anr.length - arN._mth14B3())];
            l = arO._mth02CB(abyte0, anr.length + i, j - anr.length - arN._mth14B3(), abyte1, 0);
            l += arO.doFinal(abyte1, l);
        }
        byte abyte5[] = arS.axq;
        byte abyte6[] = new byte[4];
        if (anr.length != 0 && abyte5 != null)
        {
            Pack._mth1FBE(abyte5.length << 3, abyte6, 0);
        }
        int i1 = i + j;
        byte abyte7[] = Arrays.copyOfRange(abyte0, i1 - arN._mth14B3(), i1);
        byte abyte8[] = new byte[abyte7.length];
        arN._mth02CA(new KeyParameter(abyte2));
        arN.update(abyte0, anr.length + i, j - anr.length - abyte8.length);
        if (abyte5 != null)
        {
            arN.update(abyte5, 0, abyte5.length);
        }
        if (anr.length != 0)
        {
            arN.update(abyte6, 0, 4);
        }
        arN.doFinal(abyte8, 0);
        if (!Arrays._mth1428(abyte7, abyte8))
        {
            throw new InvalidCipherTextException("Invalid MAC.");
        } else
        {
            return Arrays.copyOfRange(abyte1, 0, l);
        }
    }

    public void _mth02CE(CipherParameters cipherparameters)
    {
        if (cipherparameters instanceof ParametersWithIV)
        {
            arV = ((ParametersWithIV)cipherparameters).iv;
            arS = (IESParameters)((ParametersWithIV)cipherparameters).axC;
            return;
        } else
        {
            arV = null;
            arS = (IESParameters)cipherparameters;
            return;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (amy)
        {
            if (arT != null)
            {
                Object obj = arT;
                obj = new EphemeralKeyPair(((EphemeralKeyPairGenerator) (obj)).aud._mth1491(), ((EphemeralKeyPairGenerator) (obj)).aue);
                arQ = ((EphemeralKeyPair) (obj)).amE.amv;
                anr = ((EphemeralKeyPair) (obj)).amF._mth02CA(((EphemeralKeyPair) (obj)).amE.amu);
            }
        } else
        if (arU != null)
        {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0, 0, j);
            try
            {
                arR = arU._mth02CA(bytearrayinputstream);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new InvalidCipherTextException((new StringBuilder("unable to recover ephemeral public key: ")).append(abyte0.getMessage()).toString(), abyte0);
            }
            anr = Arrays.copyOfRange(abyte0, 0, (j - bytearrayinputstream.available()) + 0);
        }
        arL._mth02CA(arQ);
        Object obj1 = arL._mth02CB(arR);
        byte abyte1[] = BigIntegers._mth02BB(arL.getFieldSize(), ((java.math.BigInteger) (obj1)));
        if (anr.length != 0)
        {
            byte abyte2[] = new byte[anr.length + abyte1.length];
            System.arraycopy(anr, 0, abyte2, 0, anr.length);
            System.arraycopy(abyte1, 0, abyte2, anr.length, abyte1.length);
            abyte1 = abyte2;
        }
        abyte1 = new KDFParameters(abyte1, arS.axp);
        arM._mth02CA(abyte1);
        if (amy)
        {
            return _mth02CD(abyte0, 0, j);
        } else
        {
            return _mth02D1(abyte0, 0, j);
        }
    }
}
