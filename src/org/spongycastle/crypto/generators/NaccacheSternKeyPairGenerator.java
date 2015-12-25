// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;

public class NaccacheSternKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{

    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static int aur[] = {
        3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
        37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 
        79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 
        131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 
        181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 
        239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 
        293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 
        359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 
        421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 
        479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 
        557
    };

    public NaccacheSternKeyPairGenerator()
    {
    }

    private static int _mth02CA(SecureRandom securerandom, int i)
    {
        if ((-i & i) == i)
        {
            return (int)((long)i * (long)(securerandom.nextInt() & 0x7fffffff) >> 31);
        }
        int j;
        int k;
        do
        {
            j = securerandom.nextInt() & 0x7fffffff;
            k = j % i;
        } while ((j - k) + (i - 1) < 0);
        return k;
    }

    private static Vector _mth02CA(Vector vector, SecureRandom securerandom)
    {
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        for (int i = 0; i < vector.size(); i++)
        {
            vector2.addElement(vector.elementAt(i));
        }

        vector1.addElement(vector2.elementAt(0));
        vector2.removeElementAt(0);
        for (; vector2.size() != 0; vector2.removeElementAt(0))
        {
            vector1.insertElementAt(vector2.elementAt(0), _mth02CA(securerandom, vector1.size() + 1));
        }

        return vector1;
    }

    private static BigInteger _mth02CE(int i, int j, SecureRandom securerandom)
    {
        BigInteger biginteger;
        for (biginteger = new BigInteger(i, j, securerandom); biginteger.bitLength() != i; biginteger = new BigInteger(i, j, securerandom)) { }
        return biginteger;
    }

    private static Vector FE97(int i)
    {
        Vector vector = new Vector(i);
        for (int j = 0; j != i; j++)
        {
            vector.addElement(BigInteger.valueOf(aur[j]));
        }

        return vector;
    }

    public final AsymmetricCipherKeyPair _mth1491()
    {
        throw new NullPointerException();
    }

}
