// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            amh

final class ami
    implements android.content.DialogInterface.OnClickListener
{

    private amh bsR;

    ami(amh amh1)
    {
        bsR = amh1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            amh._mth02CA(bsR);
        }
    }
}
