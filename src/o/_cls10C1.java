// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public final class _cls10C1
    implements android.content.DialogInterface.OnClickListener
{

    private final Activity mActivity;
    private final Fragment xM;
    private final int xN;
    private final Intent _fld0E04;

    public _cls10C1(Activity activity, Intent intent, int i)
    {
        mActivity = activity;
        xM = null;
        _fld0E04 = intent;
        xN = i;
    }

    public _cls10C1(Fragment fragment, Intent intent, int i)
    {
        mActivity = null;
        xM = fragment;
        _fld0E04 = intent;
        xN = i;
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            if (_fld0E04 != null && xM != null)
            {
                xM.startActivityForResult(_fld0E04, xN);
                break MISSING_BLOCK_LABEL_54;
            }
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
            return;
        }
        if (_fld0E04 != null)
        {
            mActivity.startActivityForResult(_fld0E04, xN);
        }
        dialoginterface.dismiss();
        return;
    }
}
