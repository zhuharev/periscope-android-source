// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import java.math.BigInteger;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

// Referenced classes of package org.spongycastle.crypto.prng.drbg:
//            SP80090DRBG, DualECPoints, Utils

public class DualECSP800DRBG
    implements SP80090DRBG
{

    private static final BigInteger ayA;
    private static final BigInteger ayB;
    private static final BigInteger ayC;
    private static final BigInteger ayD;
    private static final BigInteger ayE;
    private static final BigInteger ayF;
    private static final BigInteger ayG;
    private static final BigInteger ayH;
    private static final DualECPoints ayI[];
    private static final BigInteger ayw;
    private static final BigInteger ayx;
    private static final BigInteger ayy;
    private static final BigInteger ayz;
    private Digest ayJ;
    private int ayK;
    private int ayL;
    private int ayM;
    private ECPoint ayN;
    private ECPoint ayO;
    private byte ayP[];
    private int ayQ;
    private FixedPointCombMultiplier ayR;
    private EntropySource ayl;
    private long ayr;

    public DualECSP800DRBG(Digest digest, int i, EntropySource entropysource, byte abyte0[], byte abyte1[])
    {
        this(ayI, digest, i, entropysource, abyte0, abyte1);
    }

    public DualECSP800DRBG(DualECPoints adualecpoints[], Digest digest, int i, EntropySource entropysource, byte abyte0[], byte abyte1[])
    {
        ayR = new FixedPointCombMultiplier();
        ayJ = digest;
        ayl = entropysource;
        ayK = i;
        if (Utils._mth0559(abyte0, 512))
        {
            throw new IllegalArgumentException("Personalization string too large");
        }
        if (entropysource._mth021A() < i || entropysource._mth021A() > 4096)
        {
            throw new IllegalArgumentException((new StringBuilder("EntropySource must provide between ")).append(i).append(" and 4096").append(" bits").toString());
        }
        entropysource = Arrays._mth02CE(entropysource._mth01B3(), abyte1, abyte0);
        int j = 0;
        do
        {
            if (j == adualecpoints.length)
            {
                break;
            }
            if (i <= adualecpoints[j].ayd)
            {
                if (Utils._mth02CA(digest) < adualecpoints[j].ayd)
                {
                    throw new IllegalArgumentException("Requested security strength is not supported by digest");
                }
                ayL = adualecpoints[j].alu.FF79().getFieldSize();
                ayM = adualecpoints[j]._mth028E() / 8;
                ayN = adualecpoints[j].alu;
                ayO = adualecpoints[j].ayu;
                break;
            }
            j++;
        } while (true);
        if (ayN == null)
        {
            throw new IllegalArgumentException("security strength cannot be greater than 256 bits");
        } else
        {
            ayP = Utils._mth02CA(ayJ, entropysource, ayL);
            ayQ = ayP.length;
            ayr = 0L;
            return;
        }
    }

    private static byte[] FF9E(byte abyte0[], int i)
    {
        if (i % 8 == 0)
        {
            return abyte0;
        }
        int l = 8 - i % 8;
        int j = 0;
        for (i = abyte0.length - 1; i >= 0; i--)
        {
            int k = abyte0[i] & 0xff;
            abyte0[i] = (byte)(k << l | j >> 8 - l);
            j = k;
        }

        return abyte0;
    }

    public final int _mth02CA(byte abyte0[], byte abyte1[], boolean flag)
    {
        int l = abyte0.length;
        int i1 = abyte0.length / ayM;
        if (Utils._mth0559(null, 512))
        {
            throw new IllegalArgumentException("Additional input too large");
        }
        if (ayr + (long)i1 > 0x80000000L)
        {
            return -1;
        }
        if (flag)
        {
            _mth141F(null);
        }
        abyte1 = new BigInteger(1, ayP);
        Arrays.fill(abyte0, (byte)0);
        int i = 0;
        for (int j = 0; j < i1; j++)
        {
            ECPoint ecpoint = ayN;
            abyte1 = ayR._mth02CA(ecpoint, abyte1)._mth0188().FF8A().toBigInteger();
            ecpoint = ayO;
            byte abyte2[] = ayR._mth02CA(ecpoint, abyte1)._mth0188().FF8A().toBigInteger().toByteArray();
            if (abyte2.length > ayM)
            {
                System.arraycopy(abyte2, abyte2.length - ayM, abyte0, i, ayM);
            } else
            {
                System.arraycopy(abyte2, 0, abyte0, (ayM - abyte2.length) + i, abyte2.length);
            }
            i += ayM;
            ayr = ayr + 1L;
        }

        Object obj = abyte1;
        if (i < abyte0.length)
        {
            obj = ayN;
            obj = ayR._mth02CA(((ECPoint) (obj)), abyte1)._mth0188().FF8A().toBigInteger();
            abyte1 = ayO;
            abyte1 = ayR._mth02CA(abyte1, ((BigInteger) (obj)))._mth0188().FF8A().toBigInteger().toByteArray();
            int k = abyte0.length - i;
            if (abyte1.length > ayM)
            {
                System.arraycopy(abyte1, abyte1.length - ayM, abyte0, i, k);
            } else
            {
                System.arraycopy(abyte1, 0, abyte0, (ayM - abyte1.length) + i, k);
            }
            ayr = ayr + 1L;
        }
        i = ayQ;
        abyte0 = ayN;
        ayP = BigIntegers._mth02BB(i, ayR._mth02CA(abyte0, ((BigInteger) (obj)))._mth0188().FF8A().toBigInteger());
        return l << 3;
    }

    public final void _mth141F(byte abyte0[])
    {
        if (Utils._mth0559(abyte0, 512))
        {
            throw new IllegalArgumentException("Additional input string too large");
        } else
        {
            byte abyte1[] = ayl._mth01B3();
            abyte0 = Arrays._mth02CE(FF9E(ayP, ayL), abyte1, abyte0);
            ayP = Utils._mth02CA(ayJ, abyte0, ayL);
            ayr = 0L;
            return;
        }
    }

    static 
    {
        ayw = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        ayx = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        ayy = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        ayz = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        ayA = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        ayB = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        ayC = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        ayD = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        ayE = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        ayF = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        ayG = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        ayH = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        ayI = new DualECPoints[3];
        org.spongycastle.math.ec.ECCurve.Fp fp = (org.spongycastle.math.ec.ECCurve.Fp)NISTNamedCurves._mth14BB("P-256").alm;
        ayI[0] = new DualECPoints(128, fp._mth02CA(ayw, ayx, false), fp._mth02CA(ayy, ayz, false), 1);
        fp = (org.spongycastle.math.ec.ECCurve.Fp)NISTNamedCurves._mth14BB("P-384").alm;
        ayI[1] = new DualECPoints(192, fp._mth02CA(ayA, ayB, false), fp._mth02CA(ayC, ayD, false), 1);
        fp = (org.spongycastle.math.ec.ECCurve.Fp)NISTNamedCurves._mth14BB("P-521").alm;
        ayI[2] = new DualECPoints(256, fp._mth02CA(ayE, ayF, false), fp._mth02CA(ayG, ayH, false), 1);
    }
}
