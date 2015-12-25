// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

// Referenced classes of package o:
//            _cls3035, _cls3033

final class _cls1E8D
    implements Closeable
{

    private byte buf[];
    int end;
    private final InputStream in;
    final Charset kq;
    private int pos;

    public _cls1E8D(FileInputStream fileinputstream, Charset charset)
    {
        this(((InputStream) (fileinputstream)), 8192, charset);
    }

    private _cls1E8D(InputStream inputstream, int i, Charset charset)
    {
        if (inputstream == null || charset == null)
        {
            throw new NullPointerException();
        }
        if (!charset.equals(_cls3035.US_ASCII))
        {
            throw new IllegalArgumentException("Unsupported encoding");
        } else
        {
            in = inputstream;
            kq = charset;
            buf = new byte[8192];
            return;
        }
    }

    private void _mth020A()
    {
        int i = in.read(buf, 0, buf.length);
        if (i == -1)
        {
            throw new EOFException();
        } else
        {
            pos = 0;
            end = i;
            return;
        }
    }

    public final void close()
    {
        InputStream inputstream = in;
        inputstream;
        JVM INSTR monitorenter ;
        if (buf != null)
        {
            buf = null;
            in.close();
        }
        inputstream;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final String readLine()
    {
        InputStream inputstream = in;
        inputstream;
        JVM INSTR monitorenter ;
        int i;
        if (buf == null)
        {
            throw new IOException("LineReader is closed");
        }
        if (pos >= end)
        {
            _mth020A();
        }
        i = pos;
_L1:
        if (i == end)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (buf[i] != 10)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        Object obj;
        Exception exception;
        int j;
        if (i != pos && buf[i - 1] == 13)
        {
            j = i - 1;
        } else
        {
            j = i;
        }
        obj = new String(buf, pos, j - pos, kq.name());
        pos = i + 1;
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        i++;
          goto _L1
        obj = new _cls3033(this, (end - pos) + 80);
_L7:
        ((ByteArrayOutputStream) (obj)).write(buf, pos, end - pos);
        end = -1;
        _mth020A();
        i = pos;
_L5:
        if (i == end)
        {
            break; /* Loop/switch isn't completed */
        }
        if (buf[i] != 10) goto _L3; else goto _L2
_L2:
        if (i != pos)
        {
            ((ByteArrayOutputStream) (obj)).write(buf, pos, i - pos);
        }
        pos = i + 1;
        obj = ((ByteArrayOutputStream) (obj)).toString();
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
        exception;
        throw exception;
    }
}
