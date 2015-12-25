// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.pm.PackageManager;

final class _cls02CA
    implements Runnable
{

    final Activity val$activity;
    final String _fld02CA[];
    final int _fld02CB;

    _cls02CA(String as[], Activity activity, int i)
    {
        _fld02CA = as;
        val$activity = activity;
        _fld02CB = i;
        super();
    }

    public final void run()
    {
        int ai[] = new int[_fld02CA.length];
        PackageManager packagemanager = val$activity.getPackageManager();
        String s = val$activity.getPackageName();
        int j = _fld02CA.length;
        for (int i = 0; i < j; i++)
        {
            ai[i] = packagemanager.checkPermission(_fld02CA[i], s);
        }

        ((if.if)val$activity).onRequestPermissionsResult(_fld02CB, _fld02CA, ai);
    }
}
