// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters
    implements Cloneable
{

    private boolean aMM;
    public int aMO;
    public int aMV;
    public int aMW;
    public int aMX;
    public int aMY;
    double aMZ;
    public Digest aMp;
    public int aMs;
    private double aNa;
    double aNb;
    private double aNc;
    private int aNd;
    private double aNe;
    public double aNf;
    public boolean aNg;
    public int aNh;
    private int aNi;
    public int aNj;
    public int atY;
    public int avs;

    private NTRUSigningKeyGenerationParameters(int i, int j, int k, int l, int i1, double d, 
            double d1, double d2, boolean flag, boolean flag1, int j1, 
            Digest digest)
    {
        super(new SecureRandom(), i);
        aNd = 100;
        aNi = 6;
        atY = i;
        aMs = j;
        avs = k;
        aMY = l;
        aNh = i1;
        aMZ = d;
        aNb = d1;
        aNe = d2;
        aNg = flag;
        aMM = flag1;
        aNj = j1;
        aMp = digest;
        aMO = 0;
        init();
    }

    private NTRUSigningKeyGenerationParameters(int i, int j, int k, int l, int i1, int j1, int k1, 
            double d, double d1, double d2, boolean flag, 
            boolean flag1, int l1, Digest digest)
    {
        super(new SecureRandom(), i);
        aNd = 100;
        aNi = 6;
        atY = i;
        aMs = j;
        aMV = k;
        aMW = l;
        aMX = i1;
        aMY = j1;
        aNh = k1;
        aMZ = d;
        aNb = d1;
        aNe = d2;
        aNg = flag;
        aMM = flag1;
        aNj = l1;
        aMp = digest;
        aMO = 1;
        init();
    }

    private void init()
    {
        aNa = aMZ * aMZ;
        aNc = aNb * aNb;
        aNf = aNe * aNe;
    }

    public Object clone()
    {
        if (aMO == 0)
        {
            return new NTRUSigningKeyGenerationParameters(atY, aMs, avs, aMY, aNh, aMZ, aNb, aNe, aNg, aMM, aNj, aMp);
        } else
        {
            return new NTRUSigningKeyGenerationParameters(atY, aMs, aMV, aMW, aMX, aMY, aNh, aMZ, aNb, aNe, aNg, aMM, aNj, aMp);
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
        if (!(obj instanceof NTRUSigningKeyGenerationParameters))
        {
            return false;
        }
        obj = (NTRUSigningKeyGenerationParameters)obj;
        if (aMY != ((NTRUSigningKeyGenerationParameters) (obj)).aMY)
        {
            return false;
        }
        if (atY != ((NTRUSigningKeyGenerationParameters) (obj)).atY)
        {
            return false;
        }
        if (aNh != ((NTRUSigningKeyGenerationParameters) (obj)).aNh)
        {
            return false;
        }
        if (Double.doubleToLongBits(aMZ) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aMZ))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNa) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aNa))
        {
            return false;
        }
        if (aNi != ((NTRUSigningKeyGenerationParameters) (obj)).aNi)
        {
            return false;
        }
        if (avs != ((NTRUSigningKeyGenerationParameters) (obj)).avs)
        {
            return false;
        }
        if (aMV != ((NTRUSigningKeyGenerationParameters) (obj)).aMV)
        {
            return false;
        }
        if (aMW != ((NTRUSigningKeyGenerationParameters) (obj)).aMW)
        {
            return false;
        }
        if (aMX != ((NTRUSigningKeyGenerationParameters) (obj)).aMX)
        {
            return false;
        }
        if (aMp == null)
        {
            if (((NTRUSigningKeyGenerationParameters) (obj)).aMp != null)
            {
                return false;
            }
        } else
        if (!aMp._mth14AC().equals(((NTRUSigningKeyGenerationParameters) (obj)).aMp._mth14AC()))
        {
            return false;
        }
        if (aNj != ((NTRUSigningKeyGenerationParameters) (obj)).aNj)
        {
            return false;
        }
        if (Double.doubleToLongBits(aNe) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aNe))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNf) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aNf))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNb) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aNb))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNc) != Double.doubleToLongBits(((NTRUSigningKeyGenerationParameters) (obj)).aNc))
        {
            return false;
        }
        if (aMO != ((NTRUSigningKeyGenerationParameters) (obj)).aMO)
        {
            return false;
        }
        if (aNg != ((NTRUSigningKeyGenerationParameters) (obj)).aNg)
        {
            return false;
        }
        if (aMs != ((NTRUSigningKeyGenerationParameters) (obj)).aMs)
        {
            return false;
        }
        if (aNd != ((NTRUSigningKeyGenerationParameters) (obj)).aNd)
        {
            return false;
        }
        return aMM == ((NTRUSigningKeyGenerationParameters) (obj)).aMM;
    }

    public int hashCode()
    {
        int j = aMY;
        int k = atY;
        int l = aNh;
        long l4 = Double.doubleToLongBits(aMZ);
        int i1 = (int)(l4 >>> 32 ^ l4);
        l4 = Double.doubleToLongBits(aNa);
        int j1 = (int)(l4 >>> 32 ^ l4);
        int k1 = aNi;
        int l1 = avs;
        int i2 = aMV;
        int j2 = aMW;
        int k2 = aMX;
        int i;
        if (aMp == null)
        {
            i = 0;
        } else
        {
            i = aMp._mth14AC().hashCode();
        }
        int l2 = aNj;
        l4 = Double.doubleToLongBits(aNe);
        int i3 = (int)(l4 >>> 32 ^ l4);
        l4 = Double.doubleToLongBits(aNf);
        int j3 = (int)(l4 >>> 32 ^ l4);
        l4 = Double.doubleToLongBits(aNb);
        int k3 = (int)(l4 >>> 32 ^ l4);
        l4 = Double.doubleToLongBits(aNc);
        int l3 = (int)(l4 >>> 32 ^ l4);
        int i4 = aMO;
        char c;
        if (aNg)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        int j4 = aMs;
        int k4 = aNd;
        char c1;
        if (aMM)
        {
            c1 = '\u04CF';
        } else
        {
            c1 = '\u04D5';
        }
        return ((((((((((((((((((((j + 31) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + i) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31 + l3) * 31 + i4) * 31 + c) * 31 + j4) * 31 + k4) * 31 + c1;
    }

    public String toString()
    {
        DecimalFormat decimalformat = new DecimalFormat("0.00");
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder("SignatureParameters(N=")).append(atY).append(" q=").append(aMs).toString());
        if (aMO == 0)
        {
            stringbuilder.append((new StringBuilder(" polyType=SIMPLE d=")).append(avs).toString());
        } else
        {
            stringbuilder.append((new StringBuilder(" polyType=PRODUCT d1=")).append(aMV).append(" d2=").append(aMW).append(" d3=").append(aMX).toString());
        }
        stringbuilder.append((new StringBuilder(" B=")).append(aMY).append(" basisType=").append(aNh).append(" beta=").append(decimalformat.format(aMZ)).append(" normBound=").append(decimalformat.format(aNb)).append(" keyNormBound=").append(decimalformat.format(aNe)).append(" prime=").append(aNg).append(" sparse=").append(aMM).append(" keyGenAlg=").append(aNj).append(" hashAlg=").append(aMp).append(")").toString());
        return stringbuilder.toString();
    }

    static 
    {
        new NTRUSigningKeyGenerationParameters(439, 2048, 146, 1, 1, 0.16500000000000001D, 490D, 280D, false, true, 0, new SHA256Digest());
        new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.16500000000000001D, 490D, 280D, false, true, 0, new SHA256Digest());
        new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127D, 560D, 360D, true, false, 0, new SHA512Digest());
        new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127D, 560D, 360D, true, false, 0, new SHA512Digest());
        new NTRUSigningKeyGenerationParameters(157, 256, 29, 1, 1, 0.38D, 200D, 80D, false, false, 0, new SHA256Digest());
        new NTRUSigningKeyGenerationParameters(157, 256, 5, 5, 8, 1, 1, 0.38D, 200D, 80D, false, false, 0, new SHA256Digest());
    }
}
