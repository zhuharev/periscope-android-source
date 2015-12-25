// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2nElement, GF2nONBField

public class GF2nONBElement extends GF2nElement
{

    private static final long aOF[] = {
        1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 
        1024L, 2048L, 4096L, 8192L, 16384L, 32768L, 0x10000L, 0x20000L, 0x40000L, 0x80000L, 
        0x100000L, 0x200000L, 0x400000L, 0x800000L, 0x1000000L, 0x2000000L, 0x4000000L, 0x8000000L, 0x10000000L, 0x20000000L, 
        0x40000000L, 0x80000000L, 0x100000000L, 0x200000000L, 0x400000000L, 0x800000000L, 0x1000000000L, 0x2000000000L, 0x4000000000L, 0x8000000000L, 
        0x10000000000L, 0x20000000000L, 0x40000000000L, 0x80000000000L, 0x100000000000L, 0x200000000000L, 0x400000000000L, 0x800000000000L, 0x1000000000000L, 0x2000000000000L, 
        0x4000000000000L, 0x8000000000000L, 0x10000000000000L, 0x20000000000000L, 0x40000000000000L, 0x80000000000000L, 0x100000000000000L, 0x200000000000000L, 0x400000000000000L, 0x800000000000000L, 
        0x1000000000000000L, 0x2000000000000000L, 0x4000000000000000L, 0x8000000000000000L
    };
    private int aOG;
    private long aOH[];
    private int mLength;

    private GF2nONBElement(GF2nONBElement gf2nonbelement)
    {
        aOC = gf2nonbelement.aOC;
        Object obj = aOC;
        aOD = 0;
        obj = (GF2nONBField)aOC;
        mLength = 0;
        obj = (GF2nONBField)aOC;
        aOG = 0;
        aOH = new long[mLength];
        long al[] = new long[gf2nonbelement.aOH.length];
        System.arraycopy(gf2nonbelement.aOH, 0, al, 0, gf2nonbelement.aOH.length);
        System.arraycopy(al, 0, aOH, 0, mLength);
    }

    public Object clone()
    {
        return new GF2nONBElement(this);
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2nONBElement))
        {
            return false;
        }
        obj = (GF2nONBElement)obj;
        for (int i = 0; i < mLength; i++)
        {
            if (aOH[i] != ((GF2nONBElement) (obj)).aOH[i])
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        return aOH.hashCode();
    }

    public String toString()
    {
        String s = "";
        long al[] = new long[aOH.length];
        System.arraycopy(aOH, 0, al, 0, aOH.length);
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        for (int i = al.length - 1; i >= 0; i--)
        {
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 60) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 56) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 52) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 48) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 44) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 40) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 36) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 32) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 28) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 24) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 20) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 16) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 12) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 8) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)(al[i] >>> 4) & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[(int)al[i] & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(" ").toString();
        }

        return s;
    }

}
