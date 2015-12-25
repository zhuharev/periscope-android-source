// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

// Referenced classes of package o:
//            wo, wd, we, wg, 
//            wf, vn, wi, wm, 
//            wn

public final class wc
{

    private static final Logger logger = Logger.getLogger(o/wc.getName());

    private wc()
    {
    }

    public static wm appendingSink(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return _mth02CA(new FileOutputStream(file, true), new wo());
        }
    }

    public static wm sink(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return _mth02CA(new FileOutputStream(file), new wo());
        }
    }

    public static wn source(File file)
    {
        if (file == null)
        {
            throw new IllegalArgumentException("file == null");
        } else
        {
            return _mth02CA(new FileInputStream(file), new wo());
        }
    }

    static Logger _mth0284()
    {
        return logger;
    }

    private static wd _mth02CA(OutputStream outputstream, wo wo1)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("out == null");
        }
        if (wo1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new wd(wo1, outputstream);
        }
    }

    private static we _mth02CA(InputStream inputstream, wo wo1)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("in == null");
        }
        if (wo1 == null)
        {
            throw new IllegalArgumentException("timeout == null");
        } else
        {
            return new we(wo1, inputstream);
        }
    }

    public static wg _mth02CA(wm wm)
    {
        if (wm == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            return new wg(wm);
        }
    }

    public static wm _mth02CA(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            wf wf1 = new wf(socket);
            return wf1.sink(_mth02CA(socket.getOutputStream(), ((wo) (wf1))));
        }
    }

    public static wi _mth02CB(wn wn)
    {
        if (wn == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            return new wi(wn);
        }
    }

    public static wn _mth02CB(Socket socket)
    {
        if (socket == null)
        {
            throw new IllegalArgumentException("socket == null");
        } else
        {
            wf wf1 = new wf(socket);
            return wf1.source(_mth02CA(socket.getInputStream(), wf1));
        }
    }

}
