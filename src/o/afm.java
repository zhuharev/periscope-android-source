// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            afk

public final class afm
    implements android.content.DialogInterface.OnDismissListener
{

    private afk biA;

    afm(afk afk1)
    {
        biA = afk1;
        super();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        afk._mth02CA(biA, null);
        biA.finish();
    }
}
