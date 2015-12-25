// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

// Referenced classes of package o:
//            _cls1E8D

final class _cls3035
{

    static final Charset US_ASCII = Charset.forName("US-ASCII");

    static void deleteContents(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder("not a readable directory: ")).append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                deleteContents(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder("failed to delete file: ")).append(file).toString());
            }
        }

    }

    static void _mth02CA(_cls1E8D _pcls1e8d)
    {
        try
        {
            _pcls1e8d.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls1E8D _pcls1e8d)
        {
            throw _pcls1e8d;
        }
        // Misplaced declaration of an exception variable
        catch (_cls1E8D _pcls1e8d)
        {
            return;
        }
    }

    static 
    {
        Charset.forName("UTF-8");
    }
}
