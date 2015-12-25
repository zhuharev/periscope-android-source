// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

public class CipherInputStream extends FilterInputStream
{

    private final Cipher aCE;
    private final byte aCF[];
    private int amw;
    private int auy;
    private boolean auz;
    private byte buf[];

    private byte[] _mth14D9()
    {
        byte abyte0[];
        try
        {
            auz = true;
            abyte0 = aCE.doFinal();
        }
        catch (GeneralSecurityException generalsecurityexception)
        {
            throw new InvalidCipherTextIOException("Error finalising cipher", generalsecurityexception);
        }
        return abyte0;
    }

    private int FF71()
    {
        if (auz)
        {
            return -1;
        }
        amw = 0;
        auy = 0;
        do
        {
            if (auy != 0)
            {
                break;
            }
            int i = in.read(aCF);
            if (i == -1)
            {
                buf = _mth14D9();
                if (buf == null || buf.length == 0)
                {
                    return -1;
                } else
                {
                    auy = buf.length;
                    return auy;
                }
            }
            buf = aCE.update(aCF, 0, i);
            if (buf != null)
            {
                auy = buf.length;
            }
        } while (true);
        return auy;
    }

    public int available()
    {
        return auy - amw;
    }

    public void close()
    {
        in.close();
        if (!auz)
        {
            _mth14D9();
        }
        break MISSING_BLOCK_LABEL_37;
        Exception exception;
        exception;
        if (!auz)
        {
            _mth14D9();
        }
        throw exception;
        amw = 0;
        auy = 0;
        return;
    }

    public void mark(int i)
    {
    }

    public boolean markSupported()
    {
        return false;
    }

    public int read()
    {
        if (amw >= auy && FF71() < 0)
        {
            return -1;
        } else
        {
            byte abyte0[] = buf;
            int i = amw;
            amw = i + 1;
            return abyte0[i] & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (amw >= auy && FF71() < 0)
        {
            return -1;
        } else
        {
            j = Math.min(j, available());
            System.arraycopy(buf, amw, abyte0, i, j);
            amw = amw + j;
            return j;
        }
    }

    public void reset()
    {
    }

    public long skip(long l)
    {
        if (l <= 0L)
        {
            return 0L;
        } else
        {
            int i = (int)Math.min(l, available());
            amw = amw + i;
            return (long)i;
        }
    }
}
