// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FilenameFilter;

final class FF6E
    implements FilenameFilter
{

    FF6E()
    {
    }

    public final boolean accept(File file, String s)
    {
        return s.length() == 39 && s.endsWith(".cls");
    }
}
