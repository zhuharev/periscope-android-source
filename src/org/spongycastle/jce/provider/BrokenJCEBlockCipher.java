// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jce.provider;

import java.security.AlgorithmParameters;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.TwofishEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;

// Referenced classes of package org.spongycastle.jce.provider:
//            BrokenPBE

public class BrokenJCEBlockCipher
    implements BrokenPBE
{
    public static class BrokePBEWithMD5AndDES extends BrokenJCEBlockCipher
    {

        public BrokePBEWithMD5AndDES()
        {
            super(new CBCBlockCipher(new DESEngine()), 0, 0, 64, 64);
        }
    }

    public static class BrokePBEWithSHA1AndDES extends BrokenJCEBlockCipher
    {

        public BrokePBEWithSHA1AndDES()
        {
            super(new CBCBlockCipher(new DESEngine()), 0, 1, 64, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES2Key extends BrokenJCEBlockCipher
    {

        public BrokePBEWithSHAAndDES2Key()
        {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 128, 64);
        }
    }

    public static class BrokePBEWithSHAAndDES3Key extends BrokenJCEBlockCipher
    {

        public BrokePBEWithSHAAndDES3Key()
        {
            super(new CBCBlockCipher(new DESedeEngine()), 2, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndDES3Key extends BrokenJCEBlockCipher
    {

        public OldPBEWithSHAAndDES3Key()
        {
            super(new CBCBlockCipher(new DESedeEngine()), 3, 1, 192, 64);
        }
    }

    public static class OldPBEWithSHAAndTwofish extends BrokenJCEBlockCipher
    {

        public OldPBEWithSHAAndTwofish()
        {
            super(new CBCBlockCipher(new TwofishEngine()), 3, 1, 256, 128);
        }
    }


    private AlgorithmParameters aDC;
    private Class aDN[] = {
        javax/crypto/spec/IvParameterSpec, javax/crypto/spec/PBEParameterSpec, javax/crypto/spec/RC2ParameterSpec, javax/crypto/spec/RC5ParameterSpec
    };
    private int aDn;
    private int aFX;
    private int aFY;
    private PaddedBufferedBlockCipher aHn;
    private int aHo;
    private int aHp;

    protected BrokenJCEBlockCipher(CBCBlockCipher cbcblockcipher, int i, int j, int k, int l)
    {
        aFX = 2;
        aFY = 1;
        aDn = 0;
        aDC = null;
        aHn = new PaddedBufferedBlockCipher(cbcblockcipher);
        aFX = i;
        aFY = j;
        aHo = k;
        aHp = l;
    }
}
