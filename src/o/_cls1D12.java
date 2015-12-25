// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package o:
//            _cls1D2B

public final class _cls1D12 extends FileOutputStream
{

    public static final _cls1D2B uc = new _cls1D2B();
    private boolean closed;
    private final String tZ;
    private File ua;
    private File ub;

    public _cls1D12(File file, String s)
    {
        super(new File(file, (new StringBuilder()).append(s).append(".cls_temp").toString()));
        closed = false;
        tZ = (new StringBuilder()).append(file).append(File.separator).append(s).toString();
        ua = new File((new StringBuilder()).append(tZ).append(".cls_temp").toString());
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        File file;
        closed = true;
        super.flush();
        super.close();
        file = new File((new StringBuilder()).append(tZ).append(".cls").toString());
        if (!ua.renameTo(file))
        {
            break MISSING_BLOCK_LABEL_79;
        }
        ua = null;
        ub = file;
        this;
        JVM INSTR monitorexit ;
        return;
        String s = "";
        if (file.exists())
        {
            s = " (target already exists)";
            break MISSING_BLOCK_LABEL_108;
        }
        if (!ua.exists())
        {
            s = " (source does not exist)";
        }
        throw new IOException((new StringBuilder("Could not rename temp file: ")).append(ua).append(" -> ").append(file).append(s).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void _mth1D10()
    {
        if (closed)
        {
            return;
        } else
        {
            closed = true;
            super.flush();
            super.close();
            return;
        }
    }

}
