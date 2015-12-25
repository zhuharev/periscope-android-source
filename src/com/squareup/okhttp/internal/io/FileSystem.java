// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.io;

import java.io.File;
import o.wm;
import o.wn;

public interface FileSystem
{

    public static final FileSystem SYSTEM = new _cls1();

    public abstract wm appendingSink(File file);

    public abstract void delete(File file);

    public abstract void deleteContents(File file);

    public abstract boolean exists(File file);

    public abstract void rename(File file, File file1);

    public abstract wm sink(File file);

    public abstract long size(File file);

    public abstract wn source(File file);


    private class _cls1
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

        _cls1()
        {
        }
    }

}
