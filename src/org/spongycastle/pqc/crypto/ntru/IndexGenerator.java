// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.Digest;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionParameters

public class IndexGenerator
{
    public static class BitString
    {

        int aMq;
        int aMr;
        byte bytes[];

        public final void _mth141D(byte byte0)
        {
            if (aMq == bytes.length)
            {
                bytes = IndexGenerator._mth1D62(bytes, bytes.length * 2);
            }
            if (aMq == 0)
            {
                aMq = 1;
                bytes[0] = byte0;
                aMr = 8;
                return;
            }
            if (aMr == 8)
            {
                byte abyte0[] = bytes;
                int i = aMq;
                aMq = i + 1;
                abyte0[i] = byte0;
                return;
            } else
            {
                int j = aMr;
                byte abyte1[] = bytes;
                int k = aMq - 1;
                abyte1[k] = (byte)(abyte1[k] | (byte0 & 0xff) << aMr);
                abyte1 = bytes;
                k = aMq;
                aMq = k + 1;
                abyte1[k] = (byte)((byte0 & 0xff) >> 8 - j);
                return;
            }
        }

        public BitString()
        {
            bytes = new byte[4];
        }
    }


    private int Wr;
    private int aMl;
    private int aMm;
    private int aMn;
    private BitString aMo;
    private Digest aMp;
    private byte aln[];
    private int asc;
    private int atY;
    private int azt;
    private boolean initialized;

    IndexGenerator(byte abyte0[], NTRUEncryptionParameters ntruencryptionparameters)
    {
        aln = abyte0;
        atY = ntruencryptionparameters.atY;
        asc = ntruencryptionparameters.asc;
        aMl = ntruencryptionparameters.aMl;
        aMm = 0;
        aMn = 0;
        Wr = 0;
        aMp = ntruencryptionparameters.aMp;
        azt = aMp._mth14AF();
        initialized = false;
    }

    private static void _mth02CA(Digest digest, int i)
    {
        digest.update(i >> 24);
        digest.update((byte)(i >> 16));
        digest.update((byte)(i >> 8));
        digest.update((byte)i);
    }

    private void _mth02CA(BitString bitstring, byte abyte0[])
    {
        aMp.update(aln, 0, aln.length);
        _mth02CA(aMp, Wr);
        aMp.doFinal(abyte0, 0);
        for (int i = 0; i != abyte0.length; i++)
        {
            bitstring._mth141D(abyte0[i]);
        }

    }

    static byte[] _mth1D62(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[i];
        if (i >= abyte0.length)
        {
            i = abyte0.length;
        }
        System.arraycopy(abyte0, 0, abyte1, 0, i);
        return abyte1;
    }

    final int nextIndex()
    {
        if (!initialized)
        {
            aMo = new BitString();
            byte abyte0[] = new byte[aMp._mth14AF()];
            for (; Wr < aMl; Wr = Wr + 1)
            {
                _mth02CA(aMo, abyte0);
            }

            aMm = (aMl << 3) * azt;
            aMn = aMm;
            initialized = true;
        }
        int l1;
        do
        {
            aMm = aMm + asc;
            BitString bitstring1 = aMo;
            int j1 = aMn;
            BitString bitstring = new BitString();
            bitstring.aMq = (j1 + 7) / 8;
            bitstring.bytes = new byte[bitstring.aMq];
            for (int i = 0; i < bitstring.aMq; i++)
            {
                bitstring.bytes[i] = bitstring1.bytes[i];
            }

            bitstring.aMr = j1 % 8;
            if (bitstring.aMr == 0)
            {
                bitstring.aMr = 8;
            } else
            {
                int j = 32 - bitstring.aMr;
                bitstring.bytes[bitstring.aMq - 1] = (byte)((bitstring.bytes[bitstring.aMq - 1] << j) >>> j);
            }
            if (aMn < asc)
            {
                int k = asc - aMn;
                j1 = Wr;
                int k1 = ((azt + k) - 1) / azt;
                byte abyte1[] = new byte[aMp._mth14AF()];
                do
                {
                    if (Wr >= j1 + k1)
                    {
                        break;
                    }
                    _mth02CA(bitstring, abyte1);
                    Wr = Wr + 1;
                    if (k > azt * 8)
                    {
                        k -= azt * 8;
                    }
                } while (true);
                aMn = azt * 8 - k;
                aMo = new BitString();
                BitString bitstring2 = aMo;
                for (int l = 0; l != abyte1.length; l++)
                {
                    bitstring2._mth141D(abyte1[l]);
                }

            } else
            {
                aMn = aMn - asc;
            }
            int i1 = asc;
            j1 = ((bitstring.aMq - 1 << 3) + bitstring.aMr) - i1;
            i1 = j1 / 8;
            j1 %= 8;
            l1 = (bitstring.bytes[i1] & 0xff) >>> j1;
            j1 = 8 - j1;
            for (i1++; i1 < bitstring.aMq; i1++)
            {
                l1 |= (bitstring.bytes[i1] & 0xff) << j1;
                j1 += 8;
            }

        } while (l1 >= (1 << asc) - (1 << asc) % atY);
        return l1 % atY;
    }
}
