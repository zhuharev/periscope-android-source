// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Dialog;

// Referenced classes of package o:
//            ck, cl

final class cm extends ck
{

    private Dialog BS;
    private cl._cls02CA BT;

    cm(cl._cls02CA _pcls02ca, Dialog dialog)
    {
        BT = _pcls02ca;
        BS = dialog;
        super();
    }

    protected final void FF67()
    {
        cl._mth02CE(BT.BP);
        BS.dismiss();
    }
}
