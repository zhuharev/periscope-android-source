// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

// Referenced classes of package o:
//            _cls02BF, _cls1427

public final class _cls099A extends _cls02BF
{

    private Dialog mDialog;
    private android.content.DialogInterface.OnCancelListener wE;

    public _cls099A()
    {
        mDialog = null;
        wE = null;
    }

    public static _cls099A _mth02CB(Dialog dialog, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        _cls099A _lcls099a = new _cls099A();
        if (dialog == null)
        {
            throw new NullPointerException(String.valueOf("Cannot display null dialog"));
        }
        dialog = (Dialog)dialog;
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        _lcls099a.mDialog = dialog;
        if (oncancellistener != null)
        {
            _lcls099a.wE = oncancellistener;
        }
        return _lcls099a;
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

    public final void show(_cls1427 _pcls1427, String s)
    {
        super.show(_pcls1427, s);
    }
}
