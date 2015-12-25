// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class NaccacheSternEngine
    implements AsymmetricBlockCipher
{

    private static BigInteger ONE = BigInteger.valueOf(1L);
    private static BigInteger ZERO = BigInteger.valueOf(0L);
    private boolean amy;
    private NaccacheSternKeyParameters ase;
    private Vector asf[];
    private boolean asg;

    public NaccacheSternEngine()
    {
        asf = null;
        asg = false;
    }

    private static BigInteger _mth02CA(Vector vector, Vector vector1)
    {
        BigInteger biginteger1 = ZERO;
        BigInteger biginteger = ONE;
        for (int i = 0; i < vector1.size(); i++)
        {
            biginteger = biginteger.multiply((BigInteger)vector1.elementAt(i));
        }

        for (int j = 0; j < vector1.size(); j++)
        {
            BigInteger biginteger2 = (BigInteger)vector1.elementAt(j);
            BigInteger biginteger3 = biginteger.divide(biginteger2);
            biginteger1 = biginteger1.add(biginteger3.multiply(biginteger3.modInverse(biginteger2)).multiply((BigInteger)vector.elementAt(j)));
        }

        return biginteger1.mod(biginteger);
    }

    public final void _mth02CA(boolean flag, CipherParameters cipherparameters)
    {
        amy = flag;
        CipherParameters cipherparameters1 = cipherparameters;
        if (cipherparameters instanceof ParametersWithRandom)
        {
            cipherparameters1 = ((ParametersWithRandom)cipherparameters).axC;
        }
        ase = (NaccacheSternKeyParameters)cipherparameters1;
        if (!amy)
        {
            NaccacheSternPrivateKeyParameters naccachesternprivatekeyparameters = (NaccacheSternPrivateKeyParameters)ase;
            Vector vector = naccachesternprivatekeyparameters.axB;
            asf = new Vector[vector.size()];
            for (int i = 0; i < vector.size(); i++)
            {
                BigInteger biginteger = (BigInteger)vector.elementAt(i);
                int k = biginteger.intValue();
                asf[i] = new Vector();
                asf[i].addElement(ONE);
                cipherparameters = ZERO;
                for (int j = 1; j < k; j++)
                {
                    cipherparameters = cipherparameters.add(naccachesternprivatekeyparameters.axA);
                    BigInteger biginteger1 = cipherparameters.divide(biginteger);
                    asf[i].addElement(((NaccacheSternKeyParameters) (naccachesternprivatekeyparameters)).amO.modPow(biginteger1, ((NaccacheSternKeyParameters) (naccachesternprivatekeyparameters)).alr));
                }

            }

        }
    }

    public final int _mth148C()
    {
        if (amy)
        {
            return (ase.axz + 7) / 8 - 1;
        } else
        {
            return ase.alr.toByteArray().length;
        }
    }

    public final int _mth148E()
    {
        if (amy)
        {
            return ase.alr.toByteArray().length;
        } else
        {
            return (ase.axz + 7) / 8 - 1;
        }
    }

    public final byte[] _mth1FBE(byte abyte0[], int i, int j)
    {
        if (ase == null)
        {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        }
        if (j > _mth148C() + 1)
        {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
        if (!amy && j < _mth148C())
        {
            throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
        if (i != 0 || j != abyte0.length)
        {
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
            abyte0 = abyte1;
        }
        abyte0 = new BigInteger(1, abyte0);
        if (amy)
        {
            byte abyte2[] = ase.alr.toByteArray();
            Arrays.fill(abyte2, (byte)0);
            abyte0 = ase.amO.modPow(abyte0, ase.alr).toByteArray();
            System.arraycopy(abyte0, 0, abyte2, abyte2.length - abyte0.length, abyte0.length);
            return abyte2;
        }
        Vector vector = new Vector();
        NaccacheSternPrivateKeyParameters naccachesternprivatekeyparameters = (NaccacheSternPrivateKeyParameters)ase;
        Vector vector1 = naccachesternprivatekeyparameters.axB;
        for (i = 0; i < vector1.size(); i++)
        {
            BigInteger biginteger = abyte0.modPow(naccachesternprivatekeyparameters.axA.divide((BigInteger)vector1.elementAt(i)), ((NaccacheSternKeyParameters) (naccachesternprivatekeyparameters)).alr);
            Vector vector2 = asf[i];
            if (asf[i].size() != ((BigInteger)vector1.elementAt(i)).intValue())
            {
                throw new InvalidCipherTextException((new StringBuilder("Error in lookup Array for ")).append(((BigInteger)vector1.elementAt(i)).intValue()).append(": Size mismatch. Expected ArrayList with length ").append(((BigInteger)vector1.elementAt(i)).intValue()).append(" but found ArrayList of length ").append(asf[i].size()).toString());
            }
            j = vector2.indexOf(biginteger);
            if (j == -1)
            {
                throw new InvalidCipherTextException("Lookup failed");
            }
            vector.addElement(BigInteger.valueOf(j));
        }

        return _mth02CA(vector, vector1).toByteArray();
    }

}
