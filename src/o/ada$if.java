// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.Toast;

// Referenced classes of package o:
//            ada, zv, aco

final class <init>
{

    private ada bdT;

    public final void onEventMainThread(zv zv1)
    {
        switch (dS[zv1.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            ada.FE74(false);
            return;

        case 3: // '\003'
            if (!ada.access$300())
            {
                ada.FE74(true);
                Toast.makeText(bdT, 0x7f0600d8, 0).show();
                aco._mth02BB(bdT);
                return;
            }
            break;

        case 4: // '\004'
            if (!ada.access$300())
            {
                ada.FE74(true);
                Toast.makeText(bdT, 0x7f060046, 1).show();
                aco._mth02BB(bdT);
                return;
            }
            break;

        case 5: // '\005'
            if (!ada.access$300())
            {
                ada.FE74(true);
                Toast.makeText(bdT, 0x7f060181, 1).show();
                aco._mth02BB(bdT);
            }
            break;
        }
    }

    private st(ada ada1)
    {
        bdT = ada1;
        super();
    }

    .Object(ada ada1, byte byte0)
    {
        this(ada1);
    }
}
