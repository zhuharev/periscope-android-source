// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.macs;

import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Memoable;

public class HMac
    implements Mac
{

    private static Hashtable auT;
    private Digest amS;
    public int auN;
    private int auO;
    private Memoable auP;
    private Memoable auQ;
    private byte auR[];
    private byte auS[];

    public HMac(Digest digest)
    {
        int i;
        if (digest instanceof ExtendedDigest)
        {
            i = ((ExtendedDigest)digest)._mth14B2();
        } else
        {
            Integer integer = (Integer)auT.get(digest._mth14AC());
            if (integer == null)
            {
                throw new IllegalArgumentException((new StringBuilder("unknown digest passed: ")).append(digest._mth14AC()).toString());
            }
            i = integer.intValue();
        }
        this(digest, i);
    }

    private HMac(Digest digest, int i)
    {
        amS = digest;
        auN = digest._mth14AF();
        auO = i;
        auR = new byte[auO];
        auS = new byte[auO + auN];
    }

    public final int doFinal(byte abyte0[], int i)
    {
        amS.doFinal(auS, auO);
        if (auQ != null)
        {
            ((Memoable)amS)._mth02CA(auQ);
            amS.update(auS, auO, amS._mth14AF());
        } else
        {
            amS.update(auS, 0, auS.length);
        }
        int j = amS.doFinal(abyte0, 0);
        for (i = auO; i < auS.length; i++)
        {
            auS[i] = 0;
        }

        if (auP != null)
        {
            ((Memoable)amS)._mth02CA(auP);
            return j;
        } else
        {
            amS.update(auR, 0, auR.length);
            return j;
        }
    }

    public final void reset()
    {
        amS.reset();
        amS.update(auR, 0, auR.length);
    }

    public final void update(byte byte0)
    {
        amS.update(byte0);
    }

    public final void update(byte abyte0[], int i, int j)
    {
        amS.update(abyte0, i, j);
    }

    public final void _mth02CA(CipherParameters cipherparameters)
    {
        amS.reset();
        cipherparameters = ((KeyParameter)cipherparameters).key;
        int l = cipherparameters.length;
        int i = l;
        if (l > auO)
        {
            amS.update(cipherparameters, 0, i);
            amS.doFinal(auR, 0);
            i = auN;
        } else
        {
            System.arraycopy(cipherparameters, 0, auR, 0, i);
        }
        for (; i < auR.length; i++)
        {
            auR[i] = 0;
        }

        System.arraycopy(auR, 0, auS, 0, auO);
        cipherparameters = auR;
        l = auO;
        for (int j = 0; j < l; j++)
        {
            cipherparameters[j] = (byte)(cipherparameters[j] ^ 0x36);
        }

        cipherparameters = auS;
        l = auO;
        for (int k = 0; k < l; k++)
        {
            cipherparameters[k] = (byte)(cipherparameters[k] ^ 0x5c);
        }

        if (amS instanceof Memoable)
        {
            auQ = ((Memoable)amS)._mth14B7();
            ((Digest)auQ).update(auS, 0, auO);
        }
        amS.update(auR, 0, auR.length);
        if (amS instanceof Memoable)
        {
            auP = ((Memoable)amS)._mth14B7();
        }
    }

    public final String _mth14AC()
    {
        return (new StringBuilder()).append(amS._mth14AC()).append("/HMAC").toString();
    }

    public final int _mth14B3()
    {
        return auN;
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        auT = hashtable;
        hashtable.put("GOST3411", Integers.valueOf(32));
        auT.put("MD2", Integers.valueOf(16));
        auT.put("MD4", Integers.valueOf(64));
        auT.put("MD5", Integers.valueOf(64));
        auT.put("RIPEMD128", Integers.valueOf(64));
        auT.put("RIPEMD160", Integers.valueOf(64));
        auT.put("SHA-1", Integers.valueOf(64));
        auT.put("SHA-224", Integers.valueOf(64));
        auT.put("SHA-256", Integers.valueOf(64));
        auT.put("SHA-384", Integers.valueOf(128));
        auT.put("SHA-512", Integers.valueOf(128));
        auT.put("Tiger", Integers.valueOf(64));
        auT.put("Whirlpool", Integers.valueOf(64));
    }
}
