// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package o:
//            ty

public final class uc extends ty
{

    public uc(Context context, File file, String s, String s1)
    {
        super(context, file, s, s1);
    }

    public final OutputStream _mth02BB(File file)
    {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
