// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

class _cls1D40
{

    _cls1D40()
    {
    }

    public static Drawable _mth02CB(Context context, int i)
    {
        return context.getDrawable(i);
    }

    public static File _mth02CE(Context context)
    {
        return context.getNoBackupFilesDir();
    }
}
