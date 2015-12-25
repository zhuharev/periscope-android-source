// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

public class CipherOutputStream extends FilterOutputStream
{

    private final Cipher aCE;
    private final byte aoj[];

    public void close()
    {
        Object obj = null;
        byte abyte0[] = aCE.doFinal();
        if (abyte0 != null)
        {
            try
            {
                out.write(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = new InvalidCipherTextIOException("Error during cipher finalisation", ((Exception) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = new IOException((new StringBuilder("Error closing stream: ")).append(obj).toString());
            }
        }
        flush();
        out.close();
        Object obj1;
        obj1 = obj;
        break MISSING_BLOCK_LABEL_90;
        IOException ioexception;
        ioexception;
        obj1 = obj;
        if (obj == null)
        {
            obj1 = ioexception;
        }
        if (obj1 != null)
        {
            throw obj1;
        } else
        {
            return;
        }
    }

    public void flush()
    {
        out.flush();
    }

    public void write(int i)
    {
        aoj[0] = (byte)i;
        write(aoj, 0, 1);
    }

    public void write(byte abyte0[], int i, int j)
    {
        abyte0 = aCE.update(abyte0, i, j);
        if (abyte0 != null)
        {
            out.write(abyte0);
        }
    }
}
