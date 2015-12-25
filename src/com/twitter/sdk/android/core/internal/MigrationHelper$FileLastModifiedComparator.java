// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            MigrationHelper

static class 
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

    ()
    {
    }
}
