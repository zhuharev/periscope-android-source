// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.reflect.Field;

// Referenced classes of package o:
//            ahz, ahy, xd, zp, 
//            auf

public abstract class aia
    implements android.view.View.OnClickListener, android.content.DialogInterface.OnDismissListener
{

    private final auf ben;
    private final android.content.DialogInterface.OnDismissListener biu;
    public AlertDialog biv;
    private final android.content.DialogInterface.OnClickListener bmF;
    private final android.content.DialogInterface.OnClickListener bmG;
    public boolean bmH;
    private final Context mContext;

    protected aia(Context context, auf auf, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnClickListener onclicklistener1, android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        mContext = context;
        ben = auf;
        bmF = onclicklistener;
        bmG = onclicklistener1;
        biu = ondismisslistener;
    }

    private AlertDialog _mth02CA(Context context, auf auf)
    {
        View view = _mth1D40(context);
        ahz ahz1 = new ahz(view.findViewById(0x7f0d00aa), null, null);
        (new ahy(xd._mth1FEA().aQC.getString((String)yp.CON._mth02CA("o.yp").getField("aVB").get(null), null), false, false))._mth02CA(ahz1, auf);
        ahz1.fy.setBackground(context.getResources().getDrawable(0x7f020061));
        ahz1.bmr.setVisibility(8);
        ahz1.bmt.setGravity(17);
        auf = (Button)view.findViewById(0x7f0d00ab);
        if (auf != null)
        {
            auf.setOnClickListener(this);
        }
        auf = (Button)view.findViewById(0x7f0d00c7);
        if (auf != null)
        {
            auf.setOnClickListener(this);
        }
        return (new android.app.AlertDialog.Builder(context)).setView(view).setOnDismissListener(this).setCancelable(false).create();
    }

    public void onClick(View view)
    {
        if (biv != null)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131558571: 
                if (bmF != null)
                {
                    bmF.onClick(biv, -1);
                    return;
                }
                break;

            case 2131558599: 
                if (bmG != null)
                {
                    bmG.onClick(biv, -2);
                }
                break;
            }
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!bmH && biu != null)
        {
            biu.onDismiss(dialoginterface);
        }
        bmH = false;
    }

    public final void show()
    {
        if (biv == null)
        {
            biv = _mth02CA(mContext, ben);
        }
        if (!biv.isShowing())
        {
            biv.show();
        }
    }

    protected abstract View _mth1D40(Context context);
}
