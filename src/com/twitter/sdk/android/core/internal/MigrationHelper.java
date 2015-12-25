// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class MigrationHelper
{
    static class FileLastModifiedComparator
        implements Comparator
    {

        public int compare(File file, File file1)
        {
            return Long.valueOf(file1.lastModified()).compareTo(Long.valueOf(file.lastModified()));
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        FileLastModifiedComparator()
        {
        }
    }

    static class PrefixFileNameFilter
        implements FilenameFilter
    {

        final String prefix;

        public boolean accept(File file, String s)
        {
            return s.startsWith(prefix);
        }

        public PrefixFileNameFilter(String s)
        {
            prefix = s;
        }
    }


    private static final String SHARED_PREFS_DIR = "shared_prefs";

    public MigrationHelper()
    {
    }

    File getLatestFile(File file, String s)
    {
        file = file.listFiles(new PrefixFileNameFilter(s));
        Arrays.sort(file, new FileLastModifiedComparator());
        if (file.length > 0)
        {
            return file[0];
        } else
        {
            return null;
        }
    }

    File getSharedPreferencesDir(Context context)
    {
        return new File(context.getApplicationInfo().dataDir, "shared_prefs");
    }

    public void migrateSessionStore(Context context, String s, String s1)
    {
        context = getSharedPreferencesDir(context);
        if (!context.exists() || !context.isDirectory())
        {
            return;
        }
        s1 = new File(context, s1);
        if (s1.exists())
        {
            return;
        }
        context = getLatestFile(context, s);
        if (context != null)
        {
            context.renameTo(s1);
        }
    }
}
