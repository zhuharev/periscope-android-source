// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.AlertDialog;
import android.view.View;

// Referenced classes of package o:
//            afg, atn, ato

public final class afh
    implements android.view.View.OnClickListener
{

    private atn biw;
    private afg bix;

    public afh(afg afg1, atn atn1)
    {
        bix = afg1;
        biw = atn1;
        super();
    }

    public final void onClick(View view)
    {
        if (bix.bit != null)
        {
            boolean flag;
            if (biw.bDW == ato.bEd)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                bix.bit._mth1D64(biw.id());
            } else
            {
                bix.bit._mth02CE(biw.id(), false);
            }
        }
        view = bix;
        if (((afg) (view)).biv != null && ((afg) (view)).biv.isShowing())
        {
            ((afg) (view)).biv.dismiss();
        }
    }
}
