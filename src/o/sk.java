// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.pm.PackageManager;

// Referenced classes of package o:
//            rp, sj

final class sk
    implements rp
{

    private sj Sn;

    sk(sj sj)
    {
        Sn = sj;
        super();
    }

    public final String _mth0674(Context context)
    {
        context = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (context == null)
        {
            return "";
        } else
        {
            return context;
        }
    }
}
