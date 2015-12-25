// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package o:
//            FF6B

static final class uZ
    implements FilenameFilter
{

    private final String uZ;

    public final boolean accept(File file, String s)
    {
        if (s.equals((new StringBuilder()).append(uZ).append(".cls").toString()))
        {
            return false;
        }
        return s.contains(uZ) && !s.endsWith(".cls_temp");
    }

    public ring(String s)
    {
        uZ = s;
    }
}
