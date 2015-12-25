// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.prng.RandomGenerator;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.tls:
//            TlsCipher, TlsContext, TlsUtils, SecurityParameters, 
//            TlsMac, TlsFatalAlert, ProtocolVersion

public class TlsBlockCipher
    implements TlsCipher
{

    private BlockCipher aBA;
    private BlockCipher aBB;
    private TlsMac aBC;
    private TlsMac aBD;
    private boolean aBm;
    private byte aBy[];
    private boolean aBz;
    private TlsContext azJ;

    public TlsBlockCipher(TlsContext tlscontext, BlockCipher blockcipher, BlockCipher blockcipher1, Digest digest, Digest digest1, int i)
    {
        azJ = tlscontext;
        aBy = new byte[256];
        tlscontext._mth03CB().nextBytes(aBy);
        aBz = TlsUtils._mth02CE(tlscontext);
        aBm = tlscontext._mth03DC().aBm;
        int k = i * 2 + digest._mth14AF() + digest1._mth14AF();
        int j = k;
        if (!aBz)
        {
            j = k + (blockcipher.getBlockSize() + blockcipher1.getBlockSize());
        }
        byte abyte0[] = TlsUtils._mth02CA(tlscontext, j);
        TlsMac tlsmac = new TlsMac(tlscontext, digest, abyte0, 0, digest._mth14AF());
        k = digest._mth14AF() + 0;
        TlsMac tlsmac1 = new TlsMac(tlscontext, digest1, abyte0, k, digest1._mth14AF());
        k += digest1._mth14AF();
        KeyParameter keyparameter = new KeyParameter(abyte0, k, i);
        k += i;
        KeyParameter keyparameter1 = new KeyParameter(abyte0, k, i);
        i = k + i;
        if (aBz)
        {
            digest1 = new byte[blockcipher.getBlockSize()];
            digest = new byte[blockcipher1.getBlockSize()];
        } else
        {
            digest1 = Arrays.copyOfRange(abyte0, i, blockcipher.getBlockSize() + i);
            i += blockcipher.getBlockSize();
            digest = Arrays.copyOfRange(abyte0, i, blockcipher1.getBlockSize() + i);
            i += blockcipher1.getBlockSize();
        }
        if (i != j)
        {
            throw new TlsFatalAlert((short)80);
        }
        if (tlscontext._mth09B0())
        {
            aBC = tlsmac1;
            aBD = tlsmac;
            aBA = blockcipher1;
            aBB = blockcipher;
            tlscontext = new ParametersWithIV(keyparameter1, digest);
            blockcipher = new ParametersWithIV(keyparameter, digest1);
        } else
        {
            aBC = tlsmac;
            aBD = tlsmac1;
            aBA = blockcipher;
            aBB = blockcipher1;
            tlscontext = new ParametersWithIV(keyparameter, digest1);
            blockcipher = new ParametersWithIV(keyparameter1, digest);
        }
        aBA._mth02CA(true, tlscontext);
        aBB._mth02CA(false, blockcipher);
    }

    public final byte[] _mth02CA(long l, short word0, byte abyte0[], int i, int j)
    {
        int l1 = aBA.getBlockSize();
        int i2 = aBC.getSize();
        ProtocolVersion protocolversion = azJ._mth0455();
        int k = j;
        int i1 = k;
        if (!aBm)
        {
            i1 = k + i2;
        }
        int k1 = l1 - 1 - i1 % l1;
        boolean flag;
        if (protocolversion.version >> 8 == 254)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        int j1 = k1;
        if (!flag)
        {
            boolean flag1;
            if (protocolversion == ProtocolVersion.aAF)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            j1 = k1;
            if (!flag1)
            {
                j1 = (255 - k1) / l1;
                flag1 = azJ._mth03D2().nextInt();
                i1 = ((flag1) ? 1 : 0);
                if (flag1 == 0)
                {
                    flag1 = 32;
                } else
                {
                    flag1 = false;
                    for (; (i1 & 1) == 0; i1 >>= 1)
                    {
                        flag1++;
                    }

                }
                j1 = k1 + Math.min(flag1, j1) * l1;
            }
        }
        i1 = j + i2 + j1 + 1;
        flag1 = i1;
        if (aBz)
        {
            flag1 = i1 + l1;
        }
        byte abyte1[] = new byte[flag1];
        flag1 = false;
        if (aBz)
        {
            byte abyte2[] = new byte[l1];
            azJ._mth03CB().nextBytes(abyte2);
            aBA._mth02CA(true, new ParametersWithIV(null, abyte2));
            System.arraycopy(abyte2, 0, abyte1, 0, l1);
            flag1 = l1 + 0;
        }
        System.arraycopy(abyte0, i, abyte1, flag1, j);
        k1 = flag1 + j;
        i1 = k1;
        if (!aBm)
        {
            abyte0 = aBC._mth02CE(l, word0, abyte0, i, j);
            System.arraycopy(abyte0, 0, abyte1, k1, abyte0.length);
            i1 = k1 + abyte0.length;
        }
        for (i = 0; i <= j1;)
        {
            j = i1 + 1;
            abyte1[i1] = (byte)j1;
            i++;
            i1 = j;
        }

        for (; flag1 < i1; flag1 += l1)
        {
            aBA._mth02CA(abyte1, flag1, abyte1, flag1);
        }

        if (aBm)
        {
            abyte0 = aBC._mth02CE(l, word0, abyte1, 0, i1);
            System.arraycopy(abyte0, 0, abyte1, i1, abyte0.length);
        }
        return abyte1;
    }

    public final byte[] _mth02CB(long l, short word0, byte abyte0[], int i, int j)
    {
        int k2 = aBB.getBlockSize();
        int j2 = aBD.getSize();
        int k;
        if (aBm)
        {
            k = k2 + j2;
        } else
        {
            k = Math.max(k2, j2 + 1);
        }
        int i1 = k;
        if (aBz)
        {
            i1 = k + k2;
        }
        if (j < i1)
        {
            throw new TlsFatalAlert((short)50);
        }
        i1 = j;
        k = i1;
        if (aBm)
        {
            k = i1 - j2;
        }
        if (k % k2 != 0)
        {
            throw new TlsFatalAlert((short)21);
        }
        if (aBm)
        {
            i1 = j + 0;
            byte abyte1[] = Arrays.copyOfRange(abyte0, i1 - j2, i1);
            if (!Arrays._mth1428(aBD._mth02CE(l, word0, abyte0, 0, j - j2), abyte1))
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                throw new TlsFatalAlert((short)20);
            }
        }
        int j1 = k;
        i1 = i;
        if (aBz)
        {
            aBB._mth02CA(false, new ParametersWithIV(null, abyte0, 0, k2));
            i1 = k2 + 0;
            j1 = k - k2;
        }
        for (i = 0; i < j1; i += k2)
        {
            aBB._mth02CA(abyte0, i1 + i, abyte0, i1 + i);
        }

        if (aBm)
        {
            i = 0;
        } else
        {
            i = j2;
        }
        int l2 = i1 + j1;
        byte byte1 = abyte0[l2 - 1];
        j = (byte1 & 0xff) + 1;
        boolean flag1 = false;
        k = 0;
        int i2 = 0;
        if (TlsUtils._mth02CB(azJ) && j > k2 || i + j > j1)
        {
            i = 0;
            j = ((flag1) ? 1 : 0);
        } else
        {
            i = l2 - j;
            k = i2;
            byte byte0;
            do
            {
                i2 = i + 1;
                byte0 = (byte)(abyte0[i] ^ byte1 | k);
                i = i2;
                k = byte0;
            } while (i2 < l2);
            i2 = j;
            i = j;
            j = i2;
            k = byte0;
            if (byte0 != 0)
            {
                i = 0;
                k = byte0;
                j = i2;
            }
        }
        byte abyte2[] = aBy;
        do
        {
            int k1 = j;
            if (k1 >= 256)
            {
                break;
            }
            j = k1 + 1;
            k = (byte)(abyte2[k1] ^ byte1 | k);
        } while (true);
        abyte2[0] = (byte)(abyte2[0] ^ k);
        k = j1 - i;
        j = k;
        if (!aBm)
        {
            k -= j2;
            j = k;
            int l1 = i1 + k;
            byte abyte3[] = Arrays.copyOfRange(abyte0, l1, l1 + j2);
            boolean flag;
            if (!Arrays._mth1428(aBD._mth02CA(l, word0, abyte0, i1, k, j1 - j2, aBy), abyte3))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || i == 0)
            {
                throw new TlsFatalAlert((short)20);
            }
        }
        return Arrays.copyOfRange(abyte0, i1, i1 + j);
    }
}
