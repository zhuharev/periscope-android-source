// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package o:
//            FF6B

final class _cls01A8
    implements FilenameFilter
{

    _cls01A8()
    {
    }

    public final boolean accept(File file, String s)
    {
        return FF6B._mth2179().matcher(s).matches();
    }
}
