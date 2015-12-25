// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import o.wc;
import o.wm;
import o.wn;

// Referenced classes of package com.squareup.okhttp.internal.io:
//            FileSystem

final class 
    implements FileSystem
{

    public final wm appendingSink(File file)
    {
        FileNotFoundException filenotfoundexception;
        wm wm;
        try
        {
            wm = wc.appendingSink(file);
        }
        // Misplaced declaration of an exception variable
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return wc.appendingSink(file);
        }
        return wm;
    }

    public final void delete(File file)
    {
        if (!file.delete() && file.exists())
        {
            throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
        } else
        {
            return;
        }
    }

    public final void deleteContents(File file)
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
                throw new IOException((new StringBuilder("failed to delete ")).append(file).toString());
            }
        }

    }

    public final boolean exists(File file)
    {
        return file.exists();
    }

    public final void rename(File file, File file1)
    {
        delete(file1);
        if (!file.renameTo(file1))
        {
            throw new IOException((new StringBuilder("failed to rename ")).append(file).append(" to ").append(file1).toString());
        } else
        {
            return;
        }
    }

    public final wm sink(File file)
    {
        FileNotFoundException filenotfoundexception;
        wm wm;
        try
        {
            wm = wc.sink(file);
        }
        // Misplaced declaration of an exception variable
        catch (FileNotFoundException filenotfoundexception)
        {
            file.getParentFile().mkdirs();
            return wc.sink(file);
        }
        return wm;
    }

    public final long size(File file)
    {
        return file.length();
    }

    public final wn source(File file)
    {
        return wc.source(file);
    }

    ()
    {
    }
}
