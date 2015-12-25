// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSourceInputStream;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class Aes128DataSource
    implements DataSource
{

    private CipherInputStream cipherInputStream;
    private final byte encryptionIv[];
    private final byte encryptionKey[];
    private final DataSource upstream;

    public Aes128DataSource(DataSource datasource, byte abyte0[], byte abyte1[])
    {
        upstream = datasource;
        encryptionKey = abyte0;
        encryptionIv = abyte1;
    }

    public final void close()
    {
        cipherInputStream = null;
        upstream.close();
    }

    public final long open(DataSpec dataspec)
    {
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        SecretKeySpec secretkeyspec = new SecretKeySpec(encryptionKey, "AES");
        IvParameterSpec ivparameterspec = new IvParameterSpec(encryptionIv);
        try
        {
            cipher.init(2, secretkeyspec, ivparameterspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        cipherInputStream = new CipherInputStream(new DataSourceInputStream(upstream, dataspec), cipher);
        return -1L;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        boolean flag;
        if (cipherInputStream != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        i = cipherInputStream.read(abyte0, i, j);
        if (i < 0)
        {
            return -1;
        } else
        {
            return i;
        }
    }
}
