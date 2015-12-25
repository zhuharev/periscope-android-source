// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package o:
//            FF6B

final class _cls0109
    implements FilenameFilter
{

    private FF6B uQ;
    private String uR;

    _cls0109(FF6B ff6b, String s)
    {
        uQ = ff6b;
        uR = s;
        super();
    }

    public final boolean accept(File file, String s)
    {
        return s.startsWith(uR);
    }
}
