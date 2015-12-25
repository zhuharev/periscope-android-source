// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.util.ArrayEncoder;
import org.spongycastle.pqc.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.pqc.math.ntru.polynomial:
//            Polynomial, BigIntPolynomial, LongPolynomial2, ModularResultant, 
//            Constants, Resultant

public class IntegerPolynomial
    implements Polynomial
{
    class CombineTask
        implements Callable
    {

        public Object call()
        {
            return ModularResultant._mth02CA(null, null);
        }
    }

    class ModResultantTask
        implements Callable
    {

        private IntegerPolynomial aPc;

        public Object call()
        {
            return aPc._mth068A(0);
        }
    }


    private static final int aOZ[] = {
        4507, 4513, 4517, 4519, 4523, 4547, 4549, 4561, 4567, 4583, 
        4591, 4597, 4603, 4621, 4637, 4639, 4643, 4649, 4651, 4657, 
        4663, 4673, 4679, 4691, 4703, 4721, 4723, 4729, 4733, 4751, 
        4759, 4783, 4787, 4789, 4793, 4799, 4801, 4813, 4817, 4831, 
        4861, 4871, 4877, 4889, 4903, 4909, 4919, 4931, 4933, 4937, 
        4943, 4951, 4957, 4967, 4969, 4973, 4987, 4993, 4999, 5003, 
        5009, 5011, 5021, 5023, 5039, 5051, 5059, 5077, 5081, 5087, 
        5099, 5101, 5107, 5113, 5119, 5147, 5153, 5167, 5171, 5179, 
        5189, 5197, 5209, 5227, 5231, 5233, 5237, 5261, 5273, 5279, 
        5281, 5297, 5303, 5309, 5323, 5333, 5347, 5351, 5381, 5387, 
        5393, 5399, 5407, 5413, 5417, 5419, 5431, 5437, 5441, 5443, 
        5449, 5471, 5477, 5479, 5483, 5501, 5503, 5507, 5519, 5521, 
        5527, 5531, 5557, 5563, 5569, 5573, 5581, 5591, 5623, 5639, 
        5641, 5647, 5651, 5653, 5657, 5659, 5669, 5683, 5689, 5693, 
        5701, 5711, 5717, 5737, 5741, 5743, 5749, 5779, 5783, 5791, 
        5801, 5807, 5813, 5821, 5827, 5839, 5843, 5849, 5851, 5857, 
        5861, 5867, 5869, 5879, 5881, 5897, 5903, 5923, 5927, 5939, 
        5953, 5981, 5987, 6007, 6011, 6029, 6037, 6043, 6047, 6053, 
        6067, 6073, 6079, 6089, 6091, 6101, 6113, 6121, 6131, 6133, 
        6143, 6151, 6163, 6173, 6197, 6199, 6203, 6211, 6217, 6221, 
        6229, 6247, 6257, 6263, 6269, 6271, 6277, 6287, 6299, 6301, 
        6311, 6317, 6323, 6329, 6337, 6343, 6353, 6359, 6361, 6367, 
        6373, 6379, 6389, 6397, 6421, 6427, 6449, 6451, 6469, 6473, 
        6481, 6491, 6521, 6529, 6547, 6551, 6553, 6563, 6569, 6571, 
        6577, 6581, 6599, 6607, 6619, 6637, 6653, 6659, 6661, 6673, 
        6679, 6689, 6691, 6701, 6703, 6709, 6719, 6733, 6737, 6761, 
        6763, 6779, 6781, 6791, 6793, 6803, 6823, 6827, 6829, 6833, 
        6841, 6857, 6863, 6869, 6871, 6883, 6899, 6907, 6911, 6917, 
        6947, 6949, 6959, 6961, 6967, 6971, 6977, 6983, 6991, 6997, 
        7001, 7013, 7019, 7027, 7039, 7043, 7057, 7069, 7079, 7103, 
        7109, 7121, 7127, 7129, 7151, 7159, 7177, 7187, 7193, 7207, 
        7211, 7213, 7219, 7229, 7237, 7243, 7247, 7253, 7283, 7297, 
        7307, 7309, 7321, 7331, 7333, 7349, 7351, 7369, 7393, 7411, 
        7417, 7433, 7451, 7457, 7459, 7477, 7481, 7487, 7489, 7499, 
        7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 
        7573, 7577, 7583, 7589, 7591, 7603, 7607, 7621, 7639, 7643, 
        7649, 7669, 7673, 7681, 7687, 7691, 7699, 7703, 7717, 7723, 
        7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823, 7829, 
        7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919, 
        7927, 7933, 7937, 7949, 7951, 7963, 7993, 8009, 8011, 8017, 
        8039, 8053, 8059, 8069, 8081, 8087, 8089, 8093, 8101, 8111, 
        8117, 8123, 8147, 8161, 8167, 8171, 8179, 8191, 8209, 8219, 
        8221, 8231, 8233, 8237, 8243, 8263, 8269, 8273, 8287, 8291, 
        8293, 8297, 8311, 8317, 8329, 8353, 8363, 8369, 8377, 8387, 
        8389, 8419, 8423, 8429, 8431, 8443, 8447, 8461, 8467, 8501, 
        8513, 8521, 8527, 8537, 8539, 8543, 8563, 8573, 8581, 8597, 
        8599, 8609, 8623, 8627, 8629, 8641, 8647, 8663, 8669, 8677, 
        8681, 8689, 8693, 8699, 8707, 8713, 8719, 8731, 8737, 8741, 
        8747, 8753, 8761, 8779, 8783, 8803, 8807, 8819, 8821, 8831, 
        8837, 8839, 8849, 8861, 8863, 8867, 8887, 8893, 8923, 8929, 
        8933, 8941, 8951, 8963, 8969, 8971, 8999, 9001, 9007, 9011, 
        9013, 9029, 9041, 9043, 9049, 9059, 9067, 9091, 9103, 9109, 
        9127, 9133, 9137, 9151, 9157, 9161, 9173, 9181, 9187, 9199, 
        9203, 9209, 9221, 9227, 9239, 9241, 9257, 9277, 9281, 9283, 
        9293, 9311, 9319, 9323, 9337, 9341, 9343, 9349, 9371, 9377, 
        9391, 9397, 9403, 9413, 9419, 9421, 9431, 9433, 9437, 9439, 
        9461, 9463, 9467, 9473, 9479, 9491, 9497, 9511, 9521, 9533, 
        9539, 9547, 9551, 9587, 9601, 9613, 9619, 9623, 9629, 9631, 
        9643, 9649, 9661, 9677, 9679, 9689, 9697, 9719, 9721, 9733, 
        9739, 9743, 9749, 9767, 9769, 9781, 9787, 9791, 9803, 9811, 
        9817, 9829, 9833, 9839, 9851, 9857, 9859, 9871, 9883, 9887, 
        9901, 9907, 9923, 9929, 9931, 9941, 9949, 9967, 9973
    };
    private static final ArrayList aPa;
    public int aPb[];

    public IntegerPolynomial(int i)
    {
        aPb = new int[i];
    }

    public IntegerPolynomial(BigIntPolynomial bigintpolynomial)
    {
        aPb = new int[bigintpolynomial.aOV.length];
        for (int i = 0; i < bigintpolynomial.aOV.length; i++)
        {
            aPb[i] = bigintpolynomial.aOV[i].intValue();
        }

    }

    public IntegerPolynomial(int ai[])
    {
        aPb = ai;
    }

    private static void sort(int ai[])
    {
        for (int i = 1; i != 0;)
        {
            i = 0;
            int j = 0;
            while (j != ai.length - 1) 
            {
                if (ai[j] > ai[j + 1])
                {
                    i = ai[j];
                    ai[j] = ai[j + 1];
                    ai[j + 1] = i;
                    i = 1;
                }
                j++;
            }
        }

    }

    private void _mth02CA(IntegerPolynomial integerpolynomial, int i, int j, int k)
    {
        int i1 = aPb.length;
        for (int l = j; l < i1; l++)
        {
            int ai[] = aPb;
            ai[l] = (ai[l] - integerpolynomial.aPb[l - j] * i) % k;
        }

    }

    private IntegerPolynomial _mth02CB(IntegerPolynomial integerpolynomial)
    {
        int ai1[] = aPb;
        int ai[] = integerpolynomial.aPb;
        int k1 = integerpolynomial.aPb.length;
        if (k1 <= 32)
        {
            int j2 = k1 * 2 - 1;
            integerpolynomial = new IntegerPolynomial(new int[j2]);
            for (int i = 0; i < j2; i++)
            {
                for (int i1 = Math.max(0, (i - k1) + 1); i1 <= Math.min(i, k1 - 1); i1++)
                {
                    int ai2[] = integerpolynomial.aPb;
                    ai2[i] = ai2[i] + ai[i1] * ai1[i - i1];
                }

            }

            return integerpolynomial;
        }
        int j1 = k1 / 2;
        integerpolynomial = new IntegerPolynomial(Arrays.copyOf(ai1, j1));
        IntegerPolynomial integerpolynomial2 = new IntegerPolynomial(Arrays.copyOfRange(ai1, j1, k1));
        IntegerPolynomial integerpolynomial4 = new IntegerPolynomial(Arrays.copyOf(ai, j1));
        IntegerPolynomial integerpolynomial5 = new IntegerPolynomial(Arrays.copyOfRange(ai, j1, k1));
        IntegerPolynomial integerpolynomial1 = (IntegerPolynomial)integerpolynomial.clone();
        integerpolynomial1._mth02CE(integerpolynomial2);
        IntegerPolynomial integerpolynomial3 = (IntegerPolynomial)integerpolynomial4.clone();
        integerpolynomial3._mth02CE(integerpolynomial5);
        integerpolynomial = integerpolynomial._mth02CB(integerpolynomial4);
        integerpolynomial2 = integerpolynomial2._mth02CB(integerpolynomial5);
        integerpolynomial3 = integerpolynomial1._mth02CB(integerpolynomial3);
        integerpolynomial3._mth02CF(integerpolynomial);
        integerpolynomial3._mth02CF(integerpolynomial2);
        integerpolynomial1 = new IntegerPolynomial(k1 * 2 - 1);
        for (int j = 0; j < integerpolynomial.aPb.length; j++)
        {
            integerpolynomial1.aPb[j] = integerpolynomial.aPb[j];
        }

        for (int k = 0; k < integerpolynomial3.aPb.length; k++)
        {
            integerpolynomial = integerpolynomial1.aPb;
            int l1 = j1 + k;
            integerpolynomial[l1] = integerpolynomial[l1] + integerpolynomial3.aPb[k];
        }

        for (int l = 0; l < integerpolynomial2.aPb.length; l++)
        {
            integerpolynomial = integerpolynomial1.aPb;
            int i2 = j1 * 2 + l;
            integerpolynomial[i2] = integerpolynomial[i2] + integerpolynomial2.aPb[l];
        }

        return integerpolynomial1;
    }

    private IntegerPolynomial _mth02CB(IntegerPolynomial integerpolynomial, int i)
    {
        if (Util._mth1E1E() && i == 2048)
        {
            LongPolynomial2 longpolynomial2_1 = new LongPolynomial2(this);
            integerpolynomial = new LongPolynomial2(integerpolynomial);
            for (int j = 2; j < i;)
            {
                j <<= 1;
                LongPolynomial2 longpolynomial2 = (LongPolynomial2)integerpolynomial.clone();
                longpolynomial2._mth1D2C(j - 1);
                longpolynomial2._mth02CA(longpolynomial2_1._mth02CA(integerpolynomial)._mth02CA(integerpolynomial), j - 1);
                integerpolynomial = longpolynomial2;
            }

            return integerpolynomial._mth1D46();
        }
        int l;
        for (int k = 2; k < i; k = l)
        {
            l = k << 1;
            IntegerPolynomial integerpolynomial1 = new IntegerPolynomial(Arrays.copyOf(integerpolynomial.aPb, integerpolynomial.aPb.length));
            integerpolynomial1._mth0E07(l);
            integerpolynomial1._mth02CF(_mth02CA(integerpolynomial, l)._mth02CA(integerpolynomial, l));
            for (k = 0; k < integerpolynomial1.aPb.length; k++)
            {
                integerpolynomial = integerpolynomial1.aPb;
                integerpolynomial[k] = integerpolynomial[k] % l;
            }

            integerpolynomial = integerpolynomial1;
        }

        return integerpolynomial;
    }

    private void _mth0E07(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[] = aPb;
            ai[j] = ai[j] << 1;
            ai = aPb;
            ai[j] = ai[j] % i;
        }

    }

    private void _mth1426(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[] = aPb;
            ai[j] = ai[j] % i;
        }

        for (int k = 0; k < aPb.length; k++)
        {
            int ai1[];
            for (; aPb[k] < i / 2; ai1[k] = ai1[k] + i)
            {
                ai1 = aPb;
            }

            int ai2[];
            for (; aPb[k] >= i / 2; ai2[k] = ai2[k] - i)
            {
                ai2 = aPb;
            }

        }

    }

    private void _mth14D1(int i)
    {
        _mth1426(i);
        int ai[] = Arrays._mth02D1(aPb);
        sort(ai);
        int i1 = 0;
        int j1 = 0;
        for (int j = 0; j < ai.length - 1;)
        {
            int i2 = ai[j + 1] - ai[j];
            int k1 = i1;
            if (i2 > i1)
            {
                k1 = i2;
                j1 = ai[j];
            }
            j++;
            i1 = k1;
        }

        int k = ai[0];
        int l1 = ai[ai.length - 1];
        if ((i - l1) + k > i1)
        {
            i = (l1 + k) / 2;
        } else
        {
            i = i1 / 2 + j1 + i / 2;
        }
        for (int l = 0; l < aPb.length; l++)
        {
            int ai1[] = aPb;
            ai1[l] = ai1[l] - i;
        }

    }

    private boolean _mth15C0()
    {
        for (int i = 1; i < aPb.length; i++)
        {
            if (aPb[i] != 0)
            {
                return false;
            }
        }

        return aPb[0] == 1;
    }

    public static IntegerPolynomial _mth2071(byte abyte0[], int i, int j)
    {
        return new IntegerPolynomial(ArrayEncoder.FE76(abyte0, i, j));
    }

    public static IntegerPolynomial FE7A(byte abyte0[], int i)
    {
        return new IntegerPolynomial(ArrayEncoder.FF70(abyte0, i));
    }

    public Object clone()
    {
        return new IntegerPolynomial((int[])aPb.clone());
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof IntegerPolynomial)
        {
            return Arrays._mth1427(aPb, ((IntegerPolynomial)obj).aPb);
        } else
        {
            return false;
        }
    }

    public final IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial)
    {
        int j = aPb.length;
        if (integerpolynomial.aPb.length != j)
        {
            throw new IllegalArgumentException("Number of coefficients must be the same");
        }
        integerpolynomial = _mth02CB(integerpolynomial);
        if (integerpolynomial.aPb.length > j)
        {
            for (int i = j; i < integerpolynomial.aPb.length; i++)
            {
                int ai[] = integerpolynomial.aPb;
                int k = i - j;
                ai[k] = ai[k] + integerpolynomial.aPb[i];
            }

            integerpolynomial.aPb = Arrays.copyOf(integerpolynomial.aPb, j);
        }
        return integerpolynomial;
    }

    public IntegerPolynomial _mth02CA(IntegerPolynomial integerpolynomial, int i)
    {
        integerpolynomial = _mth02CA(integerpolynomial);
        for (int j = 0; j < integerpolynomial.aPb.length; j++)
        {
            int ai[] = integerpolynomial.aPb;
            ai[j] = ai[j] % i;
        }

        return integerpolynomial;
    }

    public final BigIntPolynomial _mth02CB(BigIntPolynomial bigintpolynomial)
    {
        return (new BigIntPolynomial(this))._mth02CB(bigintpolynomial);
    }

    public final void _mth02CE(IntegerPolynomial integerpolynomial)
    {
        if (integerpolynomial.aPb.length > aPb.length)
        {
            aPb = Arrays.copyOf(aPb, integerpolynomial.aPb.length);
        }
        for (int i = 0; i < integerpolynomial.aPb.length; i++)
        {
            int ai[] = aPb;
            ai[i] = ai[i] + integerpolynomial.aPb[i];
        }

    }

    public final void _mth02CE(IntegerPolynomial integerpolynomial, int i)
    {
        _mth02CE(integerpolynomial);
        for (int j = 0; j < aPb.length; j++)
        {
            integerpolynomial = aPb;
            integerpolynomial[j] = integerpolynomial[j] % i;
        }

    }

    public final void _mth02CF(IntegerPolynomial integerpolynomial)
    {
        if (integerpolynomial.aPb.length > aPb.length)
        {
            aPb = Arrays.copyOf(aPb, integerpolynomial.aPb.length);
        }
        for (int i = 0; i < integerpolynomial.aPb.length; i++)
        {
            int ai[] = aPb;
            ai[i] = ai[i] - integerpolynomial.aPb[i];
        }

    }

    public final IntegerPolynomial _mth0630(int i)
    {
        int j3 = aPb.length;
        boolean flag = false;
        Object obj = new IntegerPolynomial(j3 + 1);
        ((IntegerPolynomial) (obj)).aPb[0] = 1;
        Object obj1 = new IntegerPolynomial(j3 + 1);
        IntegerPolynomial integerpolynomial = new IntegerPolynomial(j3 + 1);
        integerpolynomial.aPb = Arrays.copyOf(aPb, j3 + 1);
        for (int j = 0; j < integerpolynomial.aPb.length; j++)
        {
            int ai[] = integerpolynomial.aPb;
            ai[j] = ai[j] % 2;
        }

        integerpolynomial._mth1484(2);
        IntegerPolynomial integerpolynomial1 = new IntegerPolynomial(j3 + 1);
        integerpolynomial1.aPb[0] = 1;
        integerpolynomial1.aPb[j3] = 1;
        int k = ((flag) ? 1 : 0);
        do
        {
label0:
            {
                boolean flag1;
                int i2;
label1:
                {
                    if (integerpolynomial.aPb[0] != 0)
                    {
                        break label0;
                    }
                    for (int l = 1; l <= j3; l++)
                    {
                        integerpolynomial.aPb[l - 1] = integerpolynomial.aPb[l];
                        ((IntegerPolynomial) (obj1)).aPb[(j3 + 1) - l] = ((IntegerPolynomial) (obj1)).aPb[j3 - l];
                    }

                    integerpolynomial.aPb[j3] = 0;
                    ((IntegerPolynomial) (obj1)).aPb[0] = 0;
                    i2 = k + 1;
                    k = 0;
                    do
                    {
                        if (k >= integerpolynomial.aPb.length)
                        {
                            break;
                        }
                        if (integerpolynomial.aPb[k] != 0)
                        {
                            flag1 = false;
                            break label1;
                        }
                        k++;
                    } while (true);
                    flag1 = true;
                }
                k = i2;
                if (flag1)
                {
                    return null;
                }
                continue;
            }
            if (integerpolynomial._mth15C0())
            {
                break;
            }
            int i1;
            for (i1 = integerpolynomial.aPb.length - 1; i1 > 0 && integerpolynomial.aPb[i1] == 0; i1--) { }
            int j2;
            for (j2 = integerpolynomial1.aPb.length - 1; j2 > 0 && integerpolynomial1.aPb[j2] == 0; j2--) { }
            Object obj3 = obj;
            Object obj2 = obj1;
            IntegerPolynomial integerpolynomial3 = integerpolynomial;
            IntegerPolynomial integerpolynomial2 = integerpolynomial1;
            if (i1 < j2)
            {
                integerpolynomial2 = integerpolynomial;
                integerpolynomial3 = integerpolynomial1;
                obj2 = obj;
                obj3 = obj1;
            }
            integerpolynomial3._mth02CE(integerpolynomial2);
            for (int j1 = 0; j1 < integerpolynomial3.aPb.length; j1++)
            {
                obj = integerpolynomial3.aPb;
                obj[j1] = obj[j1] % 2;
            }

            ((IntegerPolynomial) (obj3))._mth02CE(((IntegerPolynomial) (obj2)));
            for (int k1 = 0; k1 < ((IntegerPolynomial) (obj3)).aPb.length; k1++)
            {
                obj = ((IntegerPolynomial) (obj3)).aPb;
                obj[k1] = obj[k1] % 2;
            }

            obj = obj3;
            obj1 = obj2;
            integerpolynomial = integerpolynomial3;
            integerpolynomial1 = integerpolynomial2;
        } while (true);
        if (((IntegerPolynomial) (obj)).aPb[j3] != 0)
        {
            return null;
        }
        obj1 = new IntegerPolynomial(j3);
        for (int l1 = j3 - 1; l1 >= 0; l1--)
        {
            int i3 = l1 - k % j3;
            int k2 = i3;
            int l2 = k2;
            if (i3 < 0)
            {
                l2 = k2 + j3;
            }
            ((IntegerPolynomial) (obj1)).aPb[l2] = ((IntegerPolynomial) (obj)).aPb[l1];
        }

        return _mth02CB(((IntegerPolynomial) (obj1)), i);
    }

    public final ModularResultant _mth068A(int i)
    {
        int ai[] = Arrays.copyOf(aPb, aPb.length + 1);
        IntegerPolynomial integerpolynomial = new IntegerPolynomial(ai);
        int j = ai.length;
        IntegerPolynomial integerpolynomial2 = new IntegerPolynomial(j);
        integerpolynomial2.aPb[0] = -1;
        integerpolynomial2.aPb[j - 1] = 1;
        IntegerPolynomial integerpolynomial1 = new IntegerPolynomial(integerpolynomial.aPb);
        IntegerPolynomial integerpolynomial3 = new IntegerPolynomial(j);
        integerpolynomial = new IntegerPolynomial(j);
        integerpolynomial.aPb[0] = 1;
        int i2 = j - 1;
        for (j = integerpolynomial1.aPb.length - 1; j > 0 && integerpolynomial1.aPb[j] == 0; j--) { }
        int l2 = i2;
        int i3 = 1;
        do
        {
            IntegerPolynomial integerpolynomial4 = integerpolynomial3;
            IntegerPolynomial integerpolynomial5 = integerpolynomial2;
            if (j <= 0)
            {
                break;
            }
            int k1 = (Util._mth01C3(integerpolynomial1.aPb[j], i) * integerpolynomial5.aPb[i2]) % i;
            integerpolynomial5._mth02CA(integerpolynomial1, k1, i2 - j, i);
            integerpolynomial4._mth02CA(integerpolynomial, k1, i2 - j, i);
            int j2;
            for (j2 = integerpolynomial5.aPb.length - 1; j2 > 0 && integerpolynomial5.aPb[j2] == 0; j2--) { }
            k1 = j2;
            i2 = k1;
            integerpolynomial2 = integerpolynomial5;
            integerpolynomial3 = integerpolynomial4;
            if (j2 < j)
            {
                i2 = (Util.FE73(integerpolynomial1.aPb[j], l2 - k1, i) * i3) % i;
                int k2 = i2;
                if (l2 % 2 == 1)
                {
                    k2 = i2;
                    if (j % 2 == 1)
                    {
                        k2 = -i2 % i;
                    }
                }
                integerpolynomial2 = integerpolynomial1;
                integerpolynomial1 = integerpolynomial5;
                i2 = j;
                l2 = j;
                j = k1;
                integerpolynomial3 = integerpolynomial;
                integerpolynomial = integerpolynomial4;
                i3 = k2;
            }
        } while (true);
        int l1 = (Util.FE73(integerpolynomial1.aPb[0], i2, i) * i3) % i;
        i2 = Util._mth01C3(integerpolynomial1.aPb[0], i);
        for (int k = 0; k < integerpolynomial.aPb.length; k++)
        {
            int ai1[] = integerpolynomial.aPb;
            ai1[k] = ai1[k] * i2;
        }

        for (int l = 0; l < integerpolynomial.aPb.length; l++)
        {
            int ai2[] = integerpolynomial.aPb;
            ai2[l] = ai2[l] % i;
        }

        for (int i1 = 0; i1 < integerpolynomial.aPb.length; i1++)
        {
            int ai3[] = integerpolynomial.aPb;
            ai3[i1] = ai3[i1] * l1;
        }

        for (int j1 = 0; j1 < integerpolynomial.aPb.length; j1++)
        {
            int ai4[] = integerpolynomial.aPb;
            ai4[j1] = ai4[j1] % i;
        }

        integerpolynomial.aPb = Arrays.copyOf(integerpolynomial.aPb, integerpolynomial.aPb.length - 1);
        return new ModularResultant(new BigIntPolynomial(integerpolynomial), BigInteger.valueOf(l1), BigInteger.valueOf(i));
    }

    public final void _mth0719(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[] = aPb;
            ai[j] = ai[j] * i;
        }

    }

    public final void _mth0E27(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[] = aPb;
            ai[j] = ai[j] % i;
        }

        _mth1484(i);
    }

    public final void _mth1484(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[];
            for (; aPb[j] < 0; ai[j] = ai[j] + i)
            {
                ai = aPb;
            }

        }

    }

    public final long _mth14BC(int i)
    {
        int j = aPb.length;
        IntegerPolynomial integerpolynomial = (IntegerPolynomial)clone();
        integerpolynomial._mth14D1(i);
        long l1 = 0L;
        long l = 0L;
        for (i = 0; i != integerpolynomial.aPb.length; i++)
        {
            int k = integerpolynomial.aPb[i];
            l1 += k;
            l += k * k;
        }

        return l - (l1 * l1) / (long)j;
    }

    public final void _mth1506(int i)
    {
        for (int j = 0; j < aPb.length; j++)
        {
            int ai[];
            for (; aPb[j] < -i / 2; ai[j] = ai[j] + i)
            {
                ai = aPb;
            }

            int ai1[];
            for (; aPb[j] > i / 2; ai1[j] = ai1[j] - i)
            {
                ai1 = aPb;
            }

        }

    }

    public final Resultant _mth15B8()
    {
        int l = aPb.length;
        Object obj1 = new LinkedList();
        BigInteger biginteger1 = null;
        BigInteger biginteger3 = Constants.aOX;
        BigInteger biginteger = Constants.aOX;
        int i = 1;
        Iterator iterator = aPa.iterator();
        do
        {
            BigInteger biginteger4 = biginteger;
            if (iterator.hasNext())
            {
                biginteger1 = (BigInteger)iterator.next();
            } else
            {
                biginteger1 = biginteger1.nextProbablePrime();
            }
            Object obj = _mth068A(biginteger1.intValue());
            ((LinkedList) (obj1)).add(obj);
            biginteger = biginteger3.multiply(biginteger1);
            Object obj2 = BigIntEuclidean._mth141D(biginteger1, biginteger3);
            obj = biginteger4.multiply(((BigIntEuclidean) (obj2)).amZ.multiply(biginteger1)).add(((ModularResultant) (obj)).aPj.multiply(((BigIntEuclidean) (obj2)).axe.multiply(biginteger3))).mod(biginteger);
            biginteger3 = biginteger;
            biginteger = biginteger.divide(BigInteger.valueOf(2L));
            obj2 = biginteger.negate();
            if (((BigInteger) (obj)).compareTo(biginteger) > 0)
            {
                biginteger = ((BigInteger) (obj)).subtract(biginteger3);
            } else
            {
                biginteger = ((BigInteger) (obj));
                if (((BigInteger) (obj)).compareTo(((BigInteger) (obj2))) < 0)
                {
                    biginteger = ((BigInteger) (obj)).add(biginteger3);
                }
            }
            if (biginteger.equals(biginteger4))
            {
                int k = i + 1;
                i = k;
                if (k >= 3)
                {
                    break;
                }
            } else
            {
                i = 1;
            }
        } while (true);
        for (; ((LinkedList) (obj1)).size() > 1; ((LinkedList) (obj1)).addLast(ModularResultant._mth02CA((ModularResultant)((LinkedList) (obj1)).removeFirst(), (ModularResultant)((LinkedList) (obj1)).removeFirst()))) { }
        BigIntPolynomial bigintpolynomial = ((ModularResultant)((LinkedList) (obj1)).getFirst()).aPi;
        BigInteger biginteger5 = biginteger3.divide(BigInteger.valueOf(2L));
        obj1 = biginteger5.negate();
        biginteger1 = biginteger;
        if (biginteger.compareTo(biginteger5) > 0)
        {
            biginteger1 = biginteger.subtract(biginteger3);
        }
        biginteger = biginteger1;
        if (biginteger1.compareTo(((BigInteger) (obj1))) < 0)
        {
            biginteger = biginteger1.add(biginteger3);
        }
        for (int j = 0; j < l; j++)
        {
            BigInteger biginteger2 = bigintpolynomial.aOV[j];
            if (biginteger2.compareTo(biginteger5) > 0)
            {
                bigintpolynomial.aOV[j] = biginteger2.subtract(biginteger3);
            }
            if (biginteger2.compareTo(((BigInteger) (obj1))) < 0)
            {
                bigintpolynomial.aOV[j] = biginteger2.add(biginteger3);
            }
        }

        return new Resultant(bigintpolynomial, biginteger);
    }

    public final void _mth15BA()
    {
        for (int i = 0; i < aPb.length; i++)
        {
            int ai[] = aPb;
            ai[i] = ai[i] % 3;
            if (aPb[i] > 1)
            {
                int ai1[] = aPb;
                ai1[i] = ai1[i] - 3;
            }
            if (aPb[i] < -1)
            {
                int ai2[] = aPb;
                ai2[i] = ai2[i] + 3;
            }
        }

    }

    public final void _mth1625()
    {
        int j = aPb[aPb.length - 1];
        for (int i = aPb.length - 1; i > 0; i--)
        {
            int ai[] = aPb;
            ai[i] = ai[i - 1];
        }

        aPb[0] = j;
    }

    public final int _mth1D16(int i)
    {
        int k = 0;
        for (int j = 0; j != aPb.length;)
        {
            int l = k;
            if (aPb[j] == i)
            {
                l = k + 1;
            }
            j++;
            k = l;
        }

        return k;
    }

    public final IntegerPolynomial _mth1D46()
    {
        return (IntegerPolynomial)clone();
    }

    static 
    {
        aPa = new ArrayList();
        for (int i = 0; i != 619; i++)
        {
            aPa.add(BigInteger.valueOf(aOZ[i]));
        }

    }
}
