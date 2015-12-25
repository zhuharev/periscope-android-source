// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;
import tv.periscope.android.api.PsUser;

// Referenced classes of package o:
//            aqf, aqo

final class aql
    implements android.content.DialogInterface.OnClickListener
{

    private aqf bAJ;

    aql(aqf aqf1)
    {
        bAJ = aqf1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (aqf._mth02BB(bAJ) == null)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            aqf._mth02BC(bAJ).FBFE(aqf._mth02BB(bAJ).username);
            return;

        case 1: // '\001'
            break;
        }
        if (aqf._mth02BB(bAJ).isBlocked)
        {
            aqf._mth02BC(bAJ).FBE9(aqf._mth02BB(bAJ).id);
            return;
        } else
        {
            aqf._mth02BC(bAJ)._mth02CA(aqf._mth02BB(bAJ).id, aqf._mth02BB(bAJ).username, null, null, null);
            return;
        }
    }
}
