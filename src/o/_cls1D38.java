// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.File;

// Referenced classes of package o:
//            _cls1D57, _cls1D4B, _cls1D40

public class _cls1D38
{

    public _cls1D38()
    {
    }

    private static File _mth02CA(File file)
    {
        o/1D38;
        JVM INSTR monitorenter ;
        if (file.exists() || file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_29;
        }
        o/1D38;
        JVM INSTR monitorexit ;
        return file;
        Log.w("ContextCompat", (new StringBuilder("Unable to create files subdir ")).append(file.getPath()).toString());
        o/1D38;
        JVM INSTR monitorexit ;
        return null;
        o/1D38;
        JVM INSTR monitorexit ;
        return file;
        file;
        throw file;
    }

    public static boolean _mth02CA(Context context, Intent aintent[], Bundle bundle)
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 16)
        {
            _cls1D57._mth02CB(context, aintent, bundle);
            return true;
        }
        if (i >= 11)
        {
            _cls1D4B._mth02CA(context, aintent);
            return true;
        } else
        {
            return false;
        }
    }

    public static int _mth02CB(Context context, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("permission is null");
        } else
        {
            return context.checkPermission(s, Process.myPid(), Process.myUid());
        }
    }

    public static final Drawable _mth02CB(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return _cls1D40._mth02CB(context, i);
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }

    public final File _mth02CE(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return _cls1D40._mth02CE(context);
        } else
        {
            return _mth02CA(new File(context.getApplicationInfo().dataDir, "no_backup"));
        }
    }
}
