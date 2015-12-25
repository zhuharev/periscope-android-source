// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

// Referenced classes of package o:
//            _cls1623, _cls0993

public final class az
{

    private static final az zv = new az();

    private az()
    {
    }

    static transient _cls1623.if _mth02CA(PackageInfo packageinfo, _cls1623.if aif[])
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        packageinfo = new _cls1623._cls05D9(packageinfo.signatures[0].toByteArray());
        for (int i = 0; i < aif.length; i++)
        {
            if (aif[i].equals(packageinfo))
            {
                return aif[i];
            }
        }

        if (Log.isLoggable("GoogleSignatureVerifier", 2))
        {
            Log.v("GoogleSignatureVerifier", (new StringBuilder("Signature not valid.  Found: \n")).append(Base64.encodeToString(packageinfo.getBytes(), 0)).toString());
        }
        return null;
    }

    private static boolean _mth02CA(PackageInfo packageinfo, boolean flag)
    {
        if (packageinfo.signatures.length != 1)
        {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        _cls1623._cls05D9 _lcls05d9 = new _cls1623._cls05D9(packageinfo.signatures[0].toByteArray());
        if (flag)
        {
            packageinfo = _cls1623._mth14A5();
        } else
        {
            packageinfo = _cls1623._mth14A7();
        }
        if (packageinfo.contains(_lcls05d9))
        {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2))
        {
            Log.v("GoogleSignatureVerifier", (new StringBuilder("Signature not valid.  Found: \n")).append(Base64.encodeToString(_lcls05d9.getBytes(), 0)).toString());
        }
        return false;
    }

    public static az _mth14F3()
    {
        return zv;
    }

    public final boolean _mth02CA(PackageManager packagemanager, String s)
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = packagemanager.getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            if (Log.isLoggable("GoogleSignatureVerifier", 3))
            {
                Log.d("GoogleSignatureVerifier", (new StringBuilder("Package manager can't find package ")).append(s).append(", defaulting to false").toString());
            }
            return false;
        }
        if (packageinfo == null)
        {
            return false;
        }
        if (_cls0993._mth02CB(packagemanager))
        {
            return _mth02CA(packageinfo, true);
        }
        boolean flag = _mth02CA(packageinfo, false);
        if (!flag && _mth02CA(packageinfo, true))
        {
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return flag;
    }

}
