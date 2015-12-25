// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.params.ParametersWithIV;

// Referenced classes of package org.spongycastle.crypto.macs:
//            MacCFBBlockCipher

public class CFBBlockCipherMac
    implements Mac
{

    private int amw;
    private byte auC[];
    private BlockCipherPadding auE;
    private int auF;
    private MacCFBBlockCipher auG;
    private byte buf[];

    public CFBBlockCipherMac(BlockCipher blockcipher)
    {
        this(blockcipher, 8, (blockcipher.getBlockSize() << 3) / 2, null);
    }

    private CFBBlockCipherMac(BlockCipher blockcipher, int i, int j, BlockCipherPadding blockcipherpadding)
    {
        auE = null;
        if (j % 8 != 0)
        {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else
        {
            auC = new byte[blockcipher.getBlockSize()];
            auG = new MacCFBBlockCipher(blockcipher, 8);
            auE = null;
            auF = j / 8;
            buf = new byte[auG.kY];
            amw = 0;
            return;
        }
    }

    public final int doFinal(byte abyte0[], int i)
    {
        i = auG.kY;
        if (auE == null)
        {
            for (; amw < i; amw = amw + 1)
            {
                buf[amw] = 0;
            }

        } else
        {
            auE._mth1427(buf, amw);
        }
        auG._mth02CA(buf, 0, auC, 0);
        MacCFBBlockCipher maccfbblockcipher = auG;
        byte abyte1[] = auC;
        maccfbblockcipher.amz._mth02CA(maccfbblockcipher.auW, 0, abyte1, 0);
        System.arraycopy(auC, 0, abyte0, 0, auF);
        reset();
        return auF;
    }

    public final void reset()
    {
        for (int i = 0; i < buf.length; i++)
        {
            buf[i] = 0;
        }

        amw = 0;
        MacCFBBlockCipher maccfbblockcipher = auG;
        System.arraycopy(maccfbblockcipher.arV, 0, maccfbblockcipher.auW, 0, maccfbblockcipher.arV.length);
        maccfbblockcipher.amz.reset();
    }

    public final void update(byte byte0)
    {
        if (amw == buf.length)
        {
            auG._mth02CA(buf, 0, auC, 0);
            amw = 0;
        }
        byte abyte0[] = buf;
        int i = amw;
        amw = i + 1;
        abyte0[i] = byte0;
    }

    public final void update(byte abyte0[], int i, int j)
    {
        if (j < 0)
        {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i1 = auG.kY;
        int j1 = i1 - amw;
        int k = i;
        int l = j;
        if (j > j1)
        {
            System.arraycopy(abyte0, i, buf, amw, j1);
            auG._mth02CA(buf, 0, auC, 0);
            amw = 0;
            j -= j1;
            i += j1;
            do
            {
                k = i;
                l = j;
                if (j <= i1)
                {
                    break;
                }
                auG._mth02CA(abyte0, i, auC, 0);
                j -= i1;
                i += i1;
            } while (true);
        }
        System.arraycopy(abyte0, k, buf, amw, l);
        amw = amw + l;
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        reset();
        MacCFBBlockCipher maccfbblockcipher = auG;
        if (cipherparameters instanceof ParametersWithIV)
        {
            cipherparameters = (ParametersWithIV)cipherparameters;
            byte abyte0[] = ((ParametersWithIV) (cipherparameters)).iv;
            if (abyte0.length < maccfbblockcipher.arV.length)
            {
                System.arraycopy(abyte0, 0, maccfbblockcipher.arV, maccfbblockcipher.arV.length - abyte0.length, abyte0.length);
            } else
            {
                System.arraycopy(abyte0, 0, maccfbblockcipher.arV, 0, maccfbblockcipher.arV.length);
            }
            System.arraycopy(maccfbblockcipher.arV, 0, maccfbblockcipher.auW, 0, maccfbblockcipher.arV.length);
            maccfbblockcipher.amz.reset();
            maccfbblockcipher.amz._mth02CA(true, ((ParametersWithIV) (cipherparameters)).axC);
            return;
        } else
        {
            System.arraycopy(maccfbblockcipher.arV, 0, maccfbblockcipher.auW, 0, maccfbblockcipher.arV.length);
            maccfbblockcipher.amz.reset();
            maccfbblockcipher.amz._mth02CA(true, cipherparameters);
            return;
        }
    }

    public final String _mth14AC()
    {
        MacCFBBlockCipher maccfbblockcipher = auG;
        return (new StringBuilder()).append(maccfbblockcipher.amz._mth14AC()).append("/CFB").append(maccfbblockcipher.kY << 3).toString();
    }

    public final int _mth14B3()
    {
        return auF;
    }
}
