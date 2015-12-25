// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package o:
//            FF6B

static final class uY
    implements FilenameFilter
{

    private final String uY;

    public final boolean accept(File file, String s)
    {
        return s.contains(uY) && !s.endsWith(".cls_temp");
    }

    public ring(String s)
    {
        uY = s;
    }
}
