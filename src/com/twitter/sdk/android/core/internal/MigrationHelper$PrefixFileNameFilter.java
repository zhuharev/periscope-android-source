// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.twitter.sdk.android.core.internal:
//            MigrationHelper

static class prefix
    implements FilenameFilter
{

    final String prefix;

    public boolean accept(File file, String s)
    {
        return s.startsWith(prefix);
    }

    public (String s)
    {
        prefix = s;
    }
}
