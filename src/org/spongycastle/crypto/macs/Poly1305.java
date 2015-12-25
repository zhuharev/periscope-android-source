// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.Poly1305KeyGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class Poly1305
    implements Mac
{

    private final BlockCipher amz;
    private final byte aoK[];
    private final byte aoM[];
    private int auZ;
    private int ava;
    private int avb;
    private int avc;
    private int avd;
    private int ave;
    private int avf;
    private int avg;
    private int avh;
    private int avi;
    private int avj;
    private int avk;
    private int avl;
    private int avm;
    private int avn;
    private int avo;
    private int avp;
    private int avq;
    private int avr;

    public Poly1305()
    {
        aoK = new byte[1];
        aoM = new byte[16];
        avm = 0;
        amz = null;
    }

    public Poly1305(BlockCipher blockcipher)
    {
        aoK = new byte[1];
        aoM = new byte[16];
        avm = 0;
        if (blockcipher.getBlockSize() != 16)
        {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        } else
        {
            amz = blockcipher;
            return;
        }
    }

    private void _mth14BA()
    {
        if (avm < 16)
        {
            aoM[avm] = 1;
            for (int i = avm + 1; i < 16; i++)
            {
                aoM[i] = 0;
            }

        }
        long l = 0xffffffffL & (long)Pack._mth02C6(aoM, 0);
        long l1 = 0xffffffffL & (long)Pack._mth02C6(aoM, 4);
        long l2 = 0xffffffffL & (long)Pack._mth02C6(aoM, 8);
        long l3 = 0xffffffffL & (long)Pack._mth02C6(aoM, 12);
        avn = (int)((long)avn + (0x3ffffffL & l));
        avo = (int)((long)avo + ((l1 << 32 | l) >>> 26 & 0x3ffffffL));
        avp = (int)((long)avp + ((l2 << 32 | l1) >>> 20 & 0x3ffffffL));
        avq = (int)((long)avq + ((l3 << 32 | l2) >>> 14 & 0x3ffffffL));
        avr = (int)((long)avr + (l3 >>> 8));
        if (avm == 16)
        {
            avr = avr + 0x1000000;
        }
        int j = avn;
        int k = auZ;
        l = j;
        l1 = k;
        j = avo;
        k = avh;
        l2 = j;
        l3 = k;
        j = avp;
        k = avg;
        long l4 = j;
        long l5 = k;
        j = avq;
        k = avf;
        long l6 = j;
        long l7 = k;
        j = avr;
        k = ave;
        long l30 = l * l1 + l2 * l3 + l4 * l5 + l6 * l7 + (long)j * (long)k;
        j = avn;
        k = ava;
        long l31 = j;
        long l32 = k;
        j = avo;
        k = auZ;
        long l33 = j;
        long l34 = k;
        j = avp;
        k = avh;
        long l35 = j;
        long l36 = k;
        j = avq;
        k = avg;
        long l37 = j;
        long l38 = k;
        j = avr;
        k = avf;
        long l39 = j;
        long l40 = k;
        j = avn;
        k = avb;
        long l20 = j;
        long l21 = k;
        j = avo;
        k = ava;
        long l22 = j;
        long l23 = k;
        j = avp;
        k = auZ;
        long l24 = j;
        long l25 = k;
        j = avq;
        k = avh;
        long l26 = j;
        long l27 = k;
        j = avr;
        k = avg;
        long l28 = j;
        long l29 = k;
        j = avn;
        k = avc;
        long l10 = j;
        long l11 = k;
        j = avo;
        k = avb;
        long l12 = j;
        long l13 = k;
        j = avp;
        k = ava;
        long l14 = j;
        long l15 = k;
        j = avq;
        k = auZ;
        long l16 = j;
        long l17 = k;
        j = avr;
        k = avh;
        long l18 = j;
        long l19 = k;
        j = avn;
        k = avd;
        l = j;
        l1 = k;
        j = avo;
        k = avc;
        l2 = j;
        l3 = k;
        j = avp;
        k = avb;
        l4 = j;
        l5 = k;
        j = avq;
        k = ava;
        l6 = j;
        l7 = k;
        j = avr;
        k = auZ;
        long l8 = j;
        long l9 = k;
        avn = (int)l30 & 0x3ffffff;
        l30 = l31 * l32 + l33 * l34 + l35 * l36 + l37 * l38 + l39 * l40 + (l30 >>> 26);
        avo = (int)l30 & 0x3ffffff;
        l20 = l20 * l21 + l22 * l23 + l24 * l25 + l26 * l27 + l28 * l29 + (l30 >>> 26);
        avp = (int)l20 & 0x3ffffff;
        l10 = l10 * l11 + l12 * l13 + l14 * l15 + l16 * l17 + l18 * l19 + (l20 >>> 26);
        avq = (int)l10 & 0x3ffffff;
        l = l * l1 + l2 * l3 + l4 * l5 + l6 * l7 + l8 * l9 + (l10 >>> 26);
        avr = (int)l & 0x3ffffff;
        avn = (int)((long)avn + 5L * (l >>> 26));
    }

    public final int doFinal(byte abyte0[], int i)
    {
        if (16 > abyte0.length)
        {
            throw new DataLengthException("Output buffer is too short.");
        }
        if (avm > 0)
        {
            _mth14BA();
        }
        i = avn;
        avn = avn & 0x3ffffff;
        avo = avo + (i >>> 26);
        i = avo;
        avo = avo & 0x3ffffff;
        avp = avp + (i >>> 26);
        i = avp;
        avp = avp & 0x3ffffff;
        avq = avq + (i >>> 26);
        i = avq;
        avq = avq & 0x3ffffff;
        avr = avr + (i >>> 26);
        i = avr;
        avr = avr & 0x3ffffff;
        avn = avn + (i >>> 26) * 5;
        i = avn + 5;
        int j = avo + (i >>> 26);
        int k = avp + (j >>> 26);
        int l = avq + (k >>> 26);
        int i1 = (avr + (l >>> 26)) - 0x4000000;
        int j1 = (i1 >>> 31) - 1;
        int k1 = ~j1;
        avn = avn & k1 | i & 0x3ffffff & j1;
        avo = avo & k1 | j & 0x3ffffff & j1;
        avp = avp & k1 | k & 0x3ffffff & j1;
        avq = avq & k1 | l & 0x3ffffff & j1;
        avr = avr & k1 | i1 & j1;
        long l5 = ((long)(avn | avo << 26) & 0xffffffffL) + ((long)avi & 0xffffffffL);
        long l6 = avo >>> 6 | avp << 20;
        long l7 = avj;
        long l3 = avp >>> 12 | avq << 14;
        long l4 = avk;
        long l1 = avq >>> 18 | avr << 8;
        long l2 = avl;
        Pack._mth02BE((int)l5, abyte0, 0);
        l5 = (l5 >>> 32) + ((l6 & 0xffffffffL) + (l7 & 0xffffffffL));
        Pack._mth02BE((int)l5, abyte0, 4);
        l3 = (l5 >>> 32) + ((l3 & 0xffffffffL) + (l4 & 0xffffffffL));
        Pack._mth02BE((int)l3, abyte0, 8);
        Pack._mth02BE((int)((l3 >>> 32) + ((l1 & 0xffffffffL) + (l2 & 0xffffffffL))), abyte0, 12);
        avm = 0;
        avr = 0;
        avq = 0;
        avp = 0;
        avo = 0;
        avn = 0;
        return 16;
    }

    public final void reset()
    {
        avm = 0;
        avr = 0;
        avq = 0;
        avp = 0;
        avo = 0;
        avn = 0;
    }

    public final void update(byte byte0)
    {
        aoK[0] = byte0;
        update(aoK, 0, 1);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        for (int k = 0; j > k;)
        {
            if (avm == 16)
            {
                _mth14BA();
                avm = 0;
            }
            int l = Math.min(j - k, 16 - avm);
            System.arraycopy(abyte0, k + i, aoM, avm, l);
            k += l;
            avm = avm + l;
        }

    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        byte abyte0[] = null;
        CipherParameters cipherparameters1 = cipherparameters;
        if (amz != null)
        {
            if (!(cipherparameters instanceof ParametersWithIV))
            {
                throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
            }
            cipherparameters = (ParametersWithIV)cipherparameters;
            abyte0 = ((ParametersWithIV) (cipherparameters)).iv;
            cipherparameters1 = ((ParametersWithIV) (cipherparameters)).axC;
        }
        if (!(cipherparameters1 instanceof KeyParameter))
        {
            throw new IllegalArgumentException("Poly1305 requires a key.");
        }
        cipherparameters = ((KeyParameter)cipherparameters1).key;
        if (amz != null && (abyte0 == null || abyte0.length != 16))
        {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        Poly1305KeyGenerator._mth02C7(cipherparameters);
        int i = Pack._mth02C6(cipherparameters, 16);
        int j = Pack._mth02C6(cipherparameters, 20);
        int k = Pack._mth02C6(cipherparameters, 24);
        int l = Pack._mth02C6(cipherparameters, 28);
        auZ = 0x3ffffff & i;
        ava = 0x3ffff03 & (i >>> 26 | j << 6);
        avb = 0x3ffc0ff & (j >>> 20 | k << 12);
        avc = 0x3f03fff & (k >>> 14 | l << 18);
        avd = 0xfffff & l >>> 8;
        ave = ava * 5;
        avf = avb * 5;
        avg = avc * 5;
        avh = avd * 5;
        if (amz != null)
        {
            byte abyte1[] = new byte[16];
            amz._mth02CA(true, new KeyParameter(cipherparameters, 0, 16));
            amz._mth02CA(abyte0, 0, abyte1, 0);
            cipherparameters = abyte1;
        }
        avi = Pack._mth02C6(cipherparameters, 0);
        avj = Pack._mth02C6(cipherparameters, 4);
        avk = Pack._mth02C6(cipherparameters, 8);
        avl = Pack._mth02C6(cipherparameters, 12);
        reset();
    }

    public final String _mth14AC()
    {
        if (amz == null)
        {
            return "Poly1305";
        } else
        {
            return (new StringBuilder("Poly1305-")).append(amz._mth14AC()).toString();
        }
    }

    public final int _mth14B3()
    {
        return 16;
    }
}
