// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.util.Integers;

class Utils
{

    private static Hashtable ayX;

    Utils()
    {
    }

    static int _mth02CA(Digest digest)
    {
        return ((Integer)ayX.get(digest._mth14AC())).intValue();
    }

    static int _mth02CA(Mac mac)
    {
        mac = mac._mth14AC();
        return ((Integer)ayX.get(mac.substring(0, mac.indexOf("/")))).intValue();
    }

    static byte[] _mth02CA(Digest digest, byte abyte0[], int i)
    {
        byte abyte1[] = new byte[(i + 7) / 8];
        int l1 = abyte1.length / digest._mth14AF();
        int l = 1;
        byte abyte2[] = new byte[digest._mth14AF()];
        for (int j = 0; j <= l1; j++)
        {
            digest.update((byte)l);
            digest.update(i >> 24);
            digest.update((byte)(i >> 16));
            digest.update((byte)(i >> 8));
            digest.update((byte)i);
            digest.update(abyte0, 0, abyte0.length);
            digest.doFinal(abyte2, 0);
            int j1;
            if (abyte1.length - abyte2.length * j > abyte2.length)
            {
                j1 = abyte2.length;
            } else
            {
                j1 = abyte1.length - abyte2.length * j;
            }
            System.arraycopy(abyte2, 0, abyte1, abyte2.length * j, j1);
            l++;
        }

        if (i % 8 != 0)
        {
            int k1 = 8 - i % 8;
            int k = 0;
            for (i = 0; i != abyte1.length; i++)
            {
                int i1 = abyte1[i] & 0xff;
                abyte1[i] = (byte)(i1 >>> k1 | k << 8 - k1);
                k = i1;
            }

        }
        return abyte1;
    }

    static boolean _mth0559(byte abyte0[], int i)
    {
        return abyte0 != null && abyte0.length > i;
    }

    static 
    {
        Hashtable hashtable = new Hashtable();
        ayX = hashtable;
        hashtable.put("SHA-1", Integers.valueOf(128));
        ayX.put("SHA-224", Integers.valueOf(192));
        ayX.put("SHA-256", Integers.valueOf(256));
        ayX.put("SHA-384", Integers.valueOf(256));
        ayX.put("SHA-512", Integers.valueOf(256));
        ayX.put("SHA-512/224", Integers.valueOf(192));
        ayX.put("SHA-512/256", Integers.valueOf(256));
    }
}
