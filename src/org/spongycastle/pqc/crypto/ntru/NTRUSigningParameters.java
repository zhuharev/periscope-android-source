// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.crypto.ntru;

import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;

public class NTRUSigningParameters
    implements Cloneable
{

    private int aMY;
    private double aMZ;
    private Digest aMp;
    private int aMs;
    private double aNa;
    private double aNb;
    private double aNc;
    private int aNd;
    private int aNi;
    private int atY;
    private int avs;

    public NTRUSigningParameters(int i, int j, int k, int l, double d, double d1, Digest digest)
    {
        aNd = 100;
        aNi = 6;
        atY = i;
        aMs = j;
        avs = k;
        aMY = l;
        aMZ = d;
        aNb = d1;
        aMp = digest;
        aNa = aMZ * aMZ;
        aNc = aNb * aNb;
    }

    public Object clone()
    {
        return new NTRUSigningParameters(atY, aMs, avs, aMY, aMZ, aNb, aMp);
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
        if (!(obj instanceof NTRUSigningParameters))
        {
            return false;
        }
        obj = (NTRUSigningParameters)obj;
        if (aMY != ((NTRUSigningParameters) (obj)).aMY)
        {
            return false;
        }
        if (atY != ((NTRUSigningParameters) (obj)).atY)
        {
            return false;
        }
        if (Double.doubleToLongBits(aMZ) != Double.doubleToLongBits(((NTRUSigningParameters) (obj)).aMZ))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNa) != Double.doubleToLongBits(((NTRUSigningParameters) (obj)).aNa))
        {
            return false;
        }
        if (aNi != ((NTRUSigningParameters) (obj)).aNi)
        {
            return false;
        }
        if (avs != ((NTRUSigningParameters) (obj)).avs)
        {
            return false;
        }
        if (aMp == null)
        {
            if (((NTRUSigningParameters) (obj)).aMp != null)
            {
                return false;
            }
        } else
        if (!aMp._mth14AC().equals(((NTRUSigningParameters) (obj)).aMp._mth14AC()))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNb) != Double.doubleToLongBits(((NTRUSigningParameters) (obj)).aNb))
        {
            return false;
        }
        if (Double.doubleToLongBits(aNc) != Double.doubleToLongBits(((NTRUSigningParameters) (obj)).aNc))
        {
            return false;
        }
        if (aMs != ((NTRUSigningParameters) (obj)).aMs)
        {
            return false;
        }
        return aNd == ((NTRUSigningParameters) (obj)).aNd;
    }

    public int hashCode()
    {
        int j = aMY;
        int k = atY;
        long l2 = Double.doubleToLongBits(aMZ);
        int l = (int)(l2 >>> 32 ^ l2);
        l2 = Double.doubleToLongBits(aNa);
        int i1 = (int)(l2 >>> 32 ^ l2);
        int j1 = aNi;
        int k1 = avs;
        int i;
        if (aMp == null)
        {
            i = 0;
        } else
        {
            i = aMp._mth14AC().hashCode();
        }
        l2 = Double.doubleToLongBits(aNb);
        int l1 = (int)(l2 >>> 32 ^ l2);
        l2 = Double.doubleToLongBits(aNc);
        return ((((((((((j + 31) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 * 31 * 31 * 31 + i) * 31 + l1) * 31 + (int)(l2 >>> 32 ^ l2)) * 31 + aMs) * 31 + aNd;
    }

    public String toString()
    {
        DecimalFormat decimalformat = new DecimalFormat("0.00");
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder("SignatureParameters(N=")).append(atY).append(" q=").append(aMs).toString());
        stringbuilder.append((new StringBuilder(" B=")).append(aMY).append(" beta=").append(decimalformat.format(aMZ)).append(" normBound=").append(decimalformat.format(aNb)).append(" hashAlg=").append(aMp).append(")").toString());
        return stringbuilder.toString();
    }
}
