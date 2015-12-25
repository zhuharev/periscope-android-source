// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import java.io.File;

// Referenced classes of package o:
//            un, ri, ra, rl

public final class uo
    implements un
{

    private final String TR;
    private final String TS;
    public final Context context;

    public uo(ri ri1)
    {
        if (ri1.getContext() == null)
        {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        } else
        {
            context = ri1.getContext();
            TR = ri1.getPath();
            TS = (new StringBuilder("Android/")).append(context.getPackageName()).toString();
            return;
        }
    }

    public static File _mth02BC(File file)
    {
        if (file != null)
        {
            if (file.exists() || file.mkdirs())
            {
                return file;
            }
            ra._mth0454()._mth02CE("Fabric", "Couldn't create file");
        } else
        {
            ra._mth0454()._mth02BE("Fabric", "Null File");
        }
        return null;
    }

    public final File getFilesDir()
    {
        return _mth02BC(context.getFilesDir());
    }
}
