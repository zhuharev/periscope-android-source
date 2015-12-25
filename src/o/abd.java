// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package o:
//            abk, abe, abh, abg, 
//            abi

public abstract class abd
    implements abk
{
    public static final class if
    {

        public final String bbZ;
        public final String bca;
        public final String bcb;
        public final String prefix;

        public if(String s, String s1, String s2, String s3)
        {
            bbZ = s;
            prefix = s1;
            bca = s2;
            bcb = s3;
        }
    }


    private static final abe bbQ = new abe();
    final if bbR;
    final String bbS;
    final ExecutorService bbT;
    private Writer bbU;
    boolean bbV;
    private boolean mClosed;

    protected abd(if if1, ExecutorService executorservice)
    {
        bbR = if1;
        bbS = (new StringBuilder()).append(if1.bcb).append(File.separator).append(if1.prefix).append("_working.").append(if1.bca).toString();
        bbT = executorservice;
    }

    private File[] aj()
    {
        if (bbU == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        ak();
        File file = new File(bbS);
        File file2 = new File(bbR.bcb, "access");
        if (!file2.exists())
        {
            file2.mkdirs();
        }
        if (file.renameTo(File.createTempFile(bbR.prefix, bbR.bca, file2)))
        {
            bbV = false;
            break MISSING_BLOCK_LABEL_118;
        }
        try
        {
            Log.d("FileBasedLogger", "Failed to rename file", null);
            bbV = true;
        }
        catch (IOException ioexception)
        {
            Log.d("FileBasedLogger", "Failed to prepare log", ioexception);
            bbV = true;
        }
        File file1 = new File(bbR.bcb, "access");
        if (!file1.exists())
        {
            file1.mkdirs();
        }
        if (file1.exists() && file1.isDirectory())
        {
            File afile[] = file1.listFiles();
            Arrays.sort(afile, bbQ);
            return afile;
        } else
        {
            return null;
        }
    }

    private boolean ak()
    {
        bbU.flush();
        Writer writer = bbU;
        Exception exception;
        Writer writer1;
        if (writer != null)
        {
            try
            {
                writer.close();
            }
            catch (IOException ioexception) { }
        }
        bbU = null;
        break MISSING_BLOCK_LABEL_53;
        exception;
        writer1 = bbU;
        if (writer1 != null)
        {
            try
            {
                writer1.close();
            }
            catch (IOException ioexception1) { }
        }
        bbU = null;
        throw exception;
        return true;
    }

    private void _mth02BD(File file)
    {
        if (file.exists() && !file.delete())
        {
            Log.d("FileBasedLogger", (new StringBuilder("Failed to delete log ")).append(file.getName()).toString(), null);
        }
    }

    static Writer _mth02CA(abd abd1, Writer writer)
    {
        abd1.bbU = writer;
        return writer;
    }

    static void _mth02CA(abd abd1, String s)
    {
        abd1._mth02BD(new File(s));
    }

    static void _mth02CA(abd abd1, String s, Exception exception)
    {
        Log.d("FileBasedLogger", s, exception);
    }

    static boolean _mth02CA(abd abd1)
    {
        return abd1.mClosed;
    }

    static boolean _mth02CA(abd abd1, boolean flag)
    {
        abd1.mClosed = true;
        return true;
    }

    static Writer _mth02CB(abd abd1)
    {
        return abd1.bbU;
    }

    static File[] _mth02CE(abd abd1)
    {
        return abd1.aj();
    }

    public void close()
    {
        bbT.execute(new abh(this));
    }

    public String getName()
    {
        return bbR.bbZ;
    }

    public void _mth02CA(abi abi)
    {
        abi = new FutureTask(new abg(this, abi));
        bbT.submit(abi);
        try
        {
            abi.get();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (abi abi)
        {
            Log.d("FileBasedLogger", "Failed to access logs", abi);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (abi abi)
        {
            Log.d("FileBasedLogger", "Failed to access logs", abi);
        }
    }

    final void _mth02CA(File afile[])
    {
        if (afile == null)
        {
            return;
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            if (!file.getName().equals(bbS))
            {
                _mth02BD(file);
            }
        }

    }

}
