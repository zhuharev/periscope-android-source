// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

// Referenced classes of package o:
//            acq

final class acr
    implements FileFilter
{

    private acq bds;

    acr(acq acq)
    {
        bds = acq;
        super();
    }

    public final boolean accept(File file)
    {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
