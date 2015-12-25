// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.util.Arrays;

// Referenced classes of package org.spongycastle.crypto.io:
//            CipherIOException, InvalidCipherTextIOException

public class CipherInputStream extends FilterInputStream
{

    private int amw;
    private long auA;
    private int auB;
    private byte aux[];
    private int auy;
    private boolean auz;
    private byte buf[];

    private int FF71()
    {
        if (auz)
        {
            return -1;
        }
        amw = 0;
        auy = 0;
        if (auy == 0)
        {
            int i = in.read(null);
            if (i == -1)
            {
                FF8F();
                if (auy == 0)
                {
                    return -1;
                } else
                {
                    return auy;
                }
            }
            try
            {
                if (buf == null || buf.length < i)
                {
                    buf = new byte[i];
                }
                byte abyte0[] = buf;
                throw new NullPointerException();
            }
            catch (Exception exception)
            {
                throw new CipherIOException("Error processing stream ", exception);
            }
        } else
        {
            return auy;
        }
    }

    private void FF8F()
    {
        try
        {
            auz = true;
            if (buf == null || buf.length < 0)
            {
                buf = new byte[0];
            }
            auy = 0;
            return;
        }
        catch (InvalidCipherTextException invalidciphertextexception)
        {
            throw new InvalidCipherTextIOException("Error finalising cipher", invalidciphertextexception);
        }
        catch (Exception exception)
        {
            throw new IOException((new StringBuilder("Error finalising cipher ")).append(exception).toString());
        }
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
            FF8F();
        }
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        if (!auz)
        {
            FF8F();
        }
        throw exception;
        amw = 0;
        auy = 0;
        auB = 0;
        auA = 0L;
        if (aux != null)
        {
            Arrays.fill(aux, (byte)0);
            aux = null;
        }
        if (buf != null)
        {
            Arrays.fill(buf, (byte)0);
            buf = null;
        }
        Arrays.fill(null, (byte)0);
        return;
    }

    public void mark(int i)
    {
        in.mark(i);
        if (buf != null)
        {
            aux = new byte[buf.length];
            System.arraycopy(buf, 0, aux, 0, buf.length);
        }
        auB = amw;
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

    public int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
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
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
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
