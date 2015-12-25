// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.provider.keystore.bc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.io.DigestInputStream;
import org.spongycastle.crypto.io.DigestOutputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;
import org.spongycastle.util.io.TeeOutputStream;

// Referenced classes of package org.spongycastle.jcajce.provider.keystore.bc:
//            BcKeyStoreSpi

public static class  extends BcKeyStoreSpi
{

    public void engineLoad(InputStream inputstream, char ac[])
    {
        aiq.clear();
        if (inputstream == null)
        {
            return;
        }
        Object obj = new DataInputStream(inputstream);
        int i = ((DataInputStream) (obj)).readInt();
        if (i != 2 && i != 0 && i != 1)
        {
            throw new IOException("Wrong version of key store.");
        }
        byte abyte1[] = new byte[((DataInputStream) (obj)).readInt()];
        if (abyte1.length != 20)
        {
            throw new IOException("Key store corrupted.");
        }
        ((DataInputStream) (obj)).readFully(abyte1);
        int j = ((DataInputStream) (obj)).readInt();
        if (j < 0 || j > 4096)
        {
            throw new IOException("Key store corrupted.");
        }
        if (i == 0)
        {
            inputstream = "OldPBEWithSHAAndTwofish-CBC";
        } else
        {
            inputstream = "PBEWithSHAAndTwofish-CBC";
        }
        inputstream = new CipherInputStream(((InputStream) (obj)), _mth02CA(inputstream, 2, ac, abyte1, j));
        obj = new SHA1Digest();
        _mth02CA(new DigestInputStream(inputstream, ((SHA1Digest) (obj))));
        ac = new byte[((Digest) (obj))._mth14AF()];
        ((Digest) (obj)).doFinal(ac, 0);
        byte abyte0[] = new byte[((Digest) (obj))._mth14AF()];
        Streams._mth02CB(inputstream, abyte0);
        if (!Arrays._mth1428(ac, abyte0))
        {
            aiq.clear();
            throw new IOException("KeyStore integrity check failed.");
        } else
        {
            return;
        }
    }

    public void engineStore(OutputStream outputstream, char ac[])
    {
        outputstream = new DataOutputStream(outputstream);
        byte abyte0[] = new byte[20];
        int i = (amC.nextInt() & 0x3ff) + 1024;
        amC.nextBytes(abyte0);
        outputstream.writeInt(version);
        outputstream.writeInt(20);
        outputstream.write(abyte0);
        outputstream.writeInt(i);
        outputstream = new CipherOutputStream(outputstream, _mth02CA("PBEWithSHAAndTwofish-CBC", 1, ac, abyte0, i));
        ac = new DigestOutputStream(new SHA1Digest());
        _mth02CA(new TeeOutputStream(outputstream, ac));
        outputstream.write(ac.FF97());
        outputstream.close();
    }

    public ()
    {
        super(1);
    }
}
