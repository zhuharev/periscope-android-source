// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.modes:
//            CFBBlockCipher

public class GCFBBlockCipher extends StreamBlockCipher
{

    private static final byte anK[] = {
        105, 0, 114, 34, 100, -55, 4, 35, -115, 58, 
        -37, -106, 70, -23, 42, -60, 24, -2, -84, -108, 
        0, -19, 7, 18, -64, -122, -36, -62, -17, 76, 
        -87, 43
    };
    private boolean amy;
    private final CFBBlockCipher avY;
    private KeyParameter avZ;
    private long awa;

    public GCFBBlockCipher(BlockCipher blockcipher)
    {
        super(blockcipher);
        awa = 0L;
        avY = new CFBBlockCipher(blockcipher, blockcipher.getBlockSize() << 3);
    }

    public final int getBlockSize()
    {
        return avY.kY;
    }

    public final void reset()
    {
        awa = 0L;
        avY.reset();
    }

    public final int _mth02CA(byte abyte0[], int i, byte abyte1[], int j)
    {
        _mth02CB(abyte0, i, avY.kY, abyte1, j);
        return avY.kY;
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        awa = 0L;
        avY._mth02CA(flag, cipherparameters);
        amy = flag;
        CipherParameters cipherparameters1 = cipherparameters;
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters1 = ((ParametersWithIV)cipherparameters).axC;
        }
        cipherparameters = cipherparameters1;
        if (cipherparameters1 instanceof ParametersWithRandom)
        {
            cipherparameters = ((ParametersWithRandom)cipherparameters1).axC;
        }
        cipherparameters1 = cipherparameters;
        if (cipherparameters instanceof ParametersWithSBox)
        {
            cipherparameters1 = ((ParametersWithSBox)cipherparameters).axC;
        }
        avZ = (KeyParameter)cipherparameters1;
    }

    protected final byte _mth02CF(byte byte0)
    {
        if (awa > 0L && awa % 1024L == 0L)
        {
            BlockCipher blockcipher = ((StreamBlockCipher) (avY)).amz;
            blockcipher._mth02CA(false, avZ);
            byte abyte0[] = new byte[32];
            blockcipher._mth02CA(anK, 0, abyte0, 0);
            blockcipher._mth02CA(anK, 8, abyte0, 8);
            blockcipher._mth02CA(anK, 16, abyte0, 16);
            blockcipher._mth02CA(anK, 24, abyte0, 24);
            avZ = new KeyParameter(abyte0);
            blockcipher._mth02CA(true, avZ);
            abyte0 = Arrays._mth1D4C(avY.auW);
            blockcipher._mth02CA(abyte0, 0, abyte0, 0);
            avY._mth02CA(amy, new ParametersWithIV(avZ, abyte0));
        }
        awa = awa + 1L;
        return avY._mth02CF(byte0);
    }

    public final String _mth14AC()
    {
        String s = avY._mth14AC();
        return (new StringBuilder()).append(s.substring(0, s.indexOf('/') - 1)).append("/G").append(s.substring(s.indexOf('/') + 1)).toString();
    }

}
