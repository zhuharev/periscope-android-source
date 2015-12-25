// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.util.Arrays;
import org.spongycastle.crypto.Digest;

public class NTRUEncryptionParameters
    implements Cloneable
{

    public int aMA;
    private int aMB;
    private int aMC;
    public int aMD;
    public int aME;
    public int aMF;
    private int aMG;
    public int aMH;
    public int aMI;
    public int aMJ;
    public boolean aMK;
    public byte aML[];
    public boolean aMM;
    public boolean aMN;
    public int aMO;
    public int aMl;
    public Digest aMp;
    public int aMs;
    private int aMt;
    private int aMu;
    private int aMv;
    private int aMw;
    public int aMx;
    public int aMy;
    public int aMz;
    public int asc;
    public int atY;

    public NTRUEncryptionParameters(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, boolean flag, byte abyte0[], boolean flag1, boolean flag2, 
            Digest digest)
    {
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

    public NTRUEncryptionParameters(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag, byte abyte0[], boolean flag1, boolean flag2, Digest digest)
    {
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
            return new NTRUEncryptionParameters(atY, aMs, aMt, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
        } else
        {
            return new NTRUEncryptionParameters(atY, aMs, aMu, aMv, aMw, aMH, aME, asc, aMl, aMJ, aMK, aML, aMM, aMN, aMp);
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
        obj = (NTRUEncryptionParameters)obj;
        if (atY != ((NTRUEncryptionParameters) (obj)).atY)
        {
            return false;
        }
        if (aMF != ((NTRUEncryptionParameters) (obj)).aMF)
        {
            return false;
        }
        if (aMG != ((NTRUEncryptionParameters) (obj)).aMG)
        {
            return false;
        }
        if (asc != ((NTRUEncryptionParameters) (obj)).asc)
        {
            return false;
        }
        if (aME != ((NTRUEncryptionParameters) (obj)).aME)
        {
            return false;
        }
        if (aMt != ((NTRUEncryptionParameters) (obj)).aMt)
        {
            return false;
        }
        if (aMu != ((NTRUEncryptionParameters) (obj)).aMu)
        {
            return false;
        }
        if (aMv != ((NTRUEncryptionParameters) (obj)).aMv)
        {
            return false;
        }
        if (aMw != ((NTRUEncryptionParameters) (obj)).aMw)
        {
            return false;
        }
        if (aMB != ((NTRUEncryptionParameters) (obj)).aMB)
        {
            return false;
        }
        if (aMH != ((NTRUEncryptionParameters) (obj)).aMH)
        {
            return false;
        }
        if (aMx != ((NTRUEncryptionParameters) (obj)).aMx)
        {
            return false;
        }
        if (aMy != ((NTRUEncryptionParameters) (obj)).aMy)
        {
            return false;
        }
        if (aMz != ((NTRUEncryptionParameters) (obj)).aMz)
        {
            return false;
        }
        if (aMA != ((NTRUEncryptionParameters) (obj)).aMA)
        {
            return false;
        }
        if (aMN != ((NTRUEncryptionParameters) (obj)).aMN)
        {
            return false;
        }
        if (aMp == null)
        {
            if (((NTRUEncryptionParameters) (obj)).aMp != null)
            {
                return false;
            }
        } else
        if (!aMp._mth14AC().equals(((NTRUEncryptionParameters) (obj)).aMp._mth14AC()))
        {
            return false;
        }
        if (aMK != ((NTRUEncryptionParameters) (obj)).aMK)
        {
            return false;
        }
        if (aMC != ((NTRUEncryptionParameters) (obj)).aMC)
        {
            return false;
        }
        if (aMD != ((NTRUEncryptionParameters) (obj)).aMD)
        {
            return false;
        }
        if (aMJ != ((NTRUEncryptionParameters) (obj)).aMJ)
        {
            return false;
        }
        if (aMl != ((NTRUEncryptionParameters) (obj)).aMl)
        {
            return false;
        }
        if (!Arrays.equals(aML, ((NTRUEncryptionParameters) (obj)).aML))
        {
            return false;
        }
        if (aMI != ((NTRUEncryptionParameters) (obj)).aMI)
        {
            return false;
        }
        if (aMO != ((NTRUEncryptionParameters) (obj)).aMO)
        {
            return false;
        }
        if (aMs != ((NTRUEncryptionParameters) (obj)).aMs)
        {
            return false;
        }
        return aMM == ((NTRUEncryptionParameters) (obj)).aMM;
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
}
