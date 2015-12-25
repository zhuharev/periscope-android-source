// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

public final class _cls0710 extends DialogFragment
{

    private Dialog mDialog;
    private android.content.DialogInterface.OnCancelListener wE;

    public _cls0710()
    {
        mDialog = null;
        wE = null;
    }

    public static _cls0710 _mth02CA(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        _cls0710 _lcls0710 = new _cls0710();
        if (dialog == null)
        {
            throw new NullPointerException(String.valueOf("Cannot display null dialog"));
        }
        dialog = (Dialog)dialog;
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        _lcls0710.mDialog = dialog;
        if (oncancellistener != null)
        {
            _lcls0710.wE = oncancellistener;
        }
        return _lcls0710;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        if (wE != null)
        {
            wE.onCancel(dialoginterface);
        }
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        if (mDialog == null)
        {
            setShowsDialog(false);
        }
        return mDialog;
    }

    public final void show(FragmentManager fragmentmanager, String s)
    {
        super.show(fragmentmanager, s);
    }
}
