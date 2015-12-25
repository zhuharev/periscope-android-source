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

static final class <init>
    implements FilenameFilter
{

    public final boolean accept(File file, String s)
    {
        return !FF6B.uz.accept(file, s) && FF6B._mth2179().matcher(s).matches();
    }

    private String()
    {
    }

    String(byte byte0)
    {
        this();
    }
}
