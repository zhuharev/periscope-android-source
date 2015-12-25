// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

// Referenced classes of package org.spongycastle.pqc.crypto.ntru:
//            NTRUEncryptionParameters

public class NTRUEncryptionKeyGenerationParameters extends KeyGenerationParameters
    implements Cloneable
{

    private int aMA;
    public int aMB;
    private int aMC;
    private int aMD;
    private int aME;
    private int aMF;
    private int aMG;
    private int aMH;
    private int aMI;
    private int aMJ;
    private boolean aMK;
    private byte aML[];
    public boolean aMM;
    public boolean aMN;
    public int aMO;
    private int aMl;
    private Digest aMp;
    public int aMs;
    public int aMt;
    public int aMu;
    public int aMv;
    public int aMw;
    private int aMx;
    private int aMy;
    private int aMz;
    private int asc;
    public int atY;

    private NTRUEncryptionKeyGenerationParameters(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, boolean flag, byte abyte0[], boolean flag1, boolean flag2, 
            Digest digest)
    {
        super(new SecureRandom(), k1);
        atY = i;
        aMs = j;
        aMu = k;
        aMv = l;
        aMw = i1;
        aME = k1;
        aMH = j1;
        asc = l1;
        aMl = i2;
        aMJ = j2;
        aMK = flag;
        aML = abyte0;
        aMM = flag1;
        aMN = flag2;
        aMO = 1;
        aMp = digest;
        init();
    }

    private NTRUEncryptionKeyGenerationParameters(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag, byte abyte0[], boolean flag1, boolean flag2, Digest digest)
    {
        super(new SecureRandom(), i1);
        atY = i;
        aMs = j;
        aMt = k;
        aME = i1;
        aMH = l;
        asc = j1;
        aMl = k1;
        aMJ = l1;
        aMK = flag;
        aML = abyte0;
        aMM = flag1;
        aMN = flag2;
        aMO = 0;
        aMp = digest;
        init();
    }

    private void init()
    {
        aMx = aMt;
        aMy = aMu;
        aMz = aMv;
        aMA = aMw;
        aMB = atY / 3;
        aMC = 1;
        aMD = (atY * 3) / 2 / 8 - aMC - aME / 8 - 1;
        aMF = (((atY * 3) / 2 + 7) / 8 << 3) + 1;
        aMG = atY - 1;
        aMI = aME;
    }

    public Object clone()
    {
        if (aMO == 0)
        {
            return new NTRUEncryptionKeyGenerationParameters(atY, aMs, aMt, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
        } else
        {
            return new NTRUEncryptionKeyGenerationParameters(atY, aMs, aMu, aMv, aMw, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (NTRUEncryptionKeyGenerationParameters)obj;
        if (atY != ((NTRUEncryptionKeyGenerationParameters) (obj)).atY)
        {
            return false;
        }
        if (aMF != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMF)
        {
            return false;
        }
        if (aMG != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMG)
        {
            return false;
        }
        if (asc != ((NTRUEncryptionKeyGenerationParameters) (obj)).asc)
        {
            return false;
        }
        if (aME != ((NTRUEncryptionKeyGenerationParameters) (obj)).aME)
        {
            return false;
        }
        if (aMt != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMt)
        {
            return false;
        }
        if (aMu != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMu)
        {
            return false;
        }
        if (aMv != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMv)
        {
            return false;
        }
        if (aMw != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMw)
        {
            return false;
        }
        if (aMB != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMB)
        {
            return false;
        }
        if (aMH != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMH)
        {
            return false;
        }
        if (aMx != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMx)
        {
            return false;
        }
        if (aMy != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMy)
        {
            return false;
        }
        if (aMz != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMz)
        {
            return false;
        }
        if (aMA != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMA)
        {
            return false;
        }
        if (aMN != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMN)
        {
            return false;
        }
        if (aMp == null)
        {
            if (((NTRUEncryptionKeyGenerationParameters) (obj)).aMp != null)
            {
                return false;
            }
        } else
        if (!aMp._mth14AC().equals(((NTRUEncryptionKeyGenerationParameters) (obj)).aMp._mth14AC()))
        {
            return false;
        }
        if (aMK != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMK)
        {
            return false;
        }
        if (aMC != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMC)
        {
            return false;
        }
        if (aMD != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMD)
        {
            return false;
        }
        if (aMJ != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMJ)
        {
            return false;
        }
        if (aMl != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMl)
        {
            return false;
        }
        if (!Arrays.equals(aML, ((NTRUEncryptionKeyGenerationParameters) (obj)).aML))
        {
            return false;
        }
        if (aMI != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMI)
        {
            return false;
        }
        if (aMO != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMO)
        {
            return false;
        }
        if (aMs != ((NTRUEncryptionKeyGenerationParameters) (obj)).aMs)
        {
            return false;
        }
        return aMM == ((NTRUEncryptionKeyGenerationParameters) (obj)).aMM;
    }

    public int hashCode()
    {
        int j = atY;
        int k = aMF;
        int l = aMG;
        int i1 = asc;
        int j1 = aME;
        int k1 = aMt;
        int l1 = aMu;
        int i2 = aMv;
        int j2 = aMw;
        int k2 = aMB;
        int l2 = aMH;
        int i3 = aMx;
        int j3 = aMy;
        int k3 = aMz;
        int l3 = aMA;
        char c;
        if (aMN)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        int i;
        if (aMp == null)
        {
            i = 0;
        } else
        {
            i = aMp._mth14AC().hashCode();
        }
        char c1;
        if (aMK)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        int i4 = aMC;
        int j4 = aMD;
        int k4 = aMJ;
        int l4 = aMl;
        int i5 = Arrays.hashCode(aML);
        int j5 = aMI;
        int k5 = aMO;
        int l5 = aMs;
        char c2;
        if (aMM)
        {
            c2 = '\u04CF';
        } else
        {
            c2 = '\u04D5';
        }
        return ((((((((((((((((((((((((((j + 31) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + c) * 31 + i) * 31 + c1) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + l4) * 31 + i5) * 31 + j5) * 31 + k5) * 31 + l5) * 31 + c2;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder("EncryptionParameters(N=")).append(atY).append(" q=").append(aMs).toString());
        if (aMO == 0)
        {
            stringbuilder.append((new StringBuilder(" polyType=SIMPLE df=")).append(aMt).toString());
        } else
        {
            stringbuilder.append((new StringBuilder(" polyType=PRODUCT df1=")).append(aMu).append(" df2=").append(aMv).append(" df3=").append(aMw).toString());
        }
        stringbuilder.append((new StringBuilder(" dm0=")).append(aMH).append(" db=").append(aME).append(" c=").append(asc).append(" minCallsR=").append(aMl).append(" minCallsMask=").append(aMJ).append(" hashSeed=").append(aMK).append(" hashAlg=").append(aMp).append(" oid=").append(Arrays.toString(aML)).append(" sparse=").append(aMM).append(")").toString());
        return stringbuilder.toString();
    }

    public final NTRUEncryptionParameters _mth06C9()
    {
        if (aMO == 0)
        {
            return new NTRUEncryptionParameters(atY, aMs, aMt, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
        } else
        {
            return new NTRUEncryptionParameters(atY, aMs, aMu, aMv, aMw, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
        }
    }

    static 
    {
        Object obj = new SHA512Digest();
        new NTRUEncryptionKeyGenerationParameters(1087, 2048, 120, 120, 256, 13, 25, 14, true, new byte[] {
            0, 6, 3
        }, true, false, ((Digest) (obj)));
        obj = new SHA512Digest();
        new NTRUEncryptionKeyGenerationParameters(1171, 2048, 106, 106, 256, 13, 20, 15, true, new byte[] {
            0, 6, 4
        }, true, false, ((Digest) (obj)));
        obj = new SHA512Digest();
        new NTRUEncryptionKeyGenerationParameters(1499, 2048, 79, 79, 256, 13, 17, 19, true, new byte[] {
            0, 6, 5
        }, true, false, ((Digest) (obj)));
        obj = new SHA256Digest();
        new NTRUEncryptionKeyGenerationParameters(439, 2048, 146, 130, 128, 9, 32, 9, true, new byte[] {
            0, 7, 101
        }, true, false, ((Digest) (obj)));
        obj = new SHA256Digest();
        new NTRUEncryptionKeyGenerationParameters(439, 2048, 9, 8, 5, 130, 128, 9, 32, 9, true, new byte[] {
            0, 7, 101
        }, true, true, ((Digest) (obj)));
        obj = new SHA512Digest();
        new NTRUEncryptionKeyGenerationParameters(743, 2048, 248, 220, 256, 10, 27, 14, true, new byte[] {
            0, 7, 105
        }, false, false, ((Digest) (obj)));
        obj = new SHA512Digest();
        new NTRUEncryptionKeyGenerationParameters(743, 2048, 11, 11, 15, 220, 256, 10, 27, 14, true, new byte[] {
            0, 7, 105
        }, false, true, ((Digest) (obj)));
    }
}
