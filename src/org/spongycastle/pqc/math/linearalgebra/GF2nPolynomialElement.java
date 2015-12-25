// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.linearalgebra;


// Referenced classes of package org.spongycastle.pqc.math.linearalgebra:
//            GF2nElement, GF2Polynomial, GF2nField

public class GF2nPolynomialElement extends GF2nElement
{

    private GF2Polynomial aOI;

    private GF2nPolynomialElement(GF2nPolynomialElement gf2npolynomialelement)
    {
        aOC = gf2npolynomialelement.aOC;
        aOD = gf2npolynomialelement.aOD;
        aOI = new GF2Polynomial(gf2npolynomialelement.aOI);
    }

    public Object clone()
    {
        return new GF2nPolynomialElement(this);
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof GF2nPolynomialElement))
        {
            return false;
        }
        obj = (GF2nPolynomialElement)obj;
        if (aOC != ((GF2nPolynomialElement) (obj)).aOC && !aOC._mth1531().equals(((GF2nPolynomialElement) (obj)).aOC._mth1531()))
        {
            return false;
        } else
        {
            return aOI.equals(((GF2nPolynomialElement) (obj)).aOI);
        }
    }

    public int hashCode()
    {
        return aOC.hashCode() + aOI.hashCode();
    }

    public String toString()
    {
        GF2Polynomial gf2polynomial = aOI;
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
        String s = new String();
        for (int i = gf2polynomial.aOs - 1; i >= 0; i--)
        {
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 28 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 24 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 20 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 16 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 12 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 8 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] >>> 4 & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(ac[gf2polynomial.aOt[i] & 0xf]).toString();
            s = (new StringBuilder()).append(s).append(" ").toString();
        }

        return s;
    }
}
