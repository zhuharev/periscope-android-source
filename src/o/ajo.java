// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            ajk

public final class ajo
    implements android.content.DialogInterface.OnDismissListener
{

    private ajk bpC;

    ajo(ajk ajk1)
    {
        bpC = ajk1;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        ajk._mth02CA(bpC, null);
    }
}
