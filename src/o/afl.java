// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.DialogInterface;

// Referenced classes of package o:
//            afk

public final class afl
    implements android.content.DialogInterface.OnClickListener
{

    private afk biA;

    afl(afk afk)
    {
        biA = afk;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }
}
