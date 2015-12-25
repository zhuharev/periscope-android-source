// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package o:
//            ada, zv, amk

final class <init>
{

    private ada bdT;

    public final void onEventMainThread(zv zv1)
    {
        switch ([zv1.ordinal()])
        {
        case 1: // '\001'
            if (!ada.aP())
            {
                ada.FBE8(true);
                zv1 = bdT;
                Intent intent = new Intent(zv1, o/amk);
                intent.setFlags(0x4008000);
                zv1.finish();
                zv1.startActivity(intent);
                return;
            }
            break;

        default:
            ada.FBE8(false);
            break;
        }
    }

    private .Activity(ada ada1)
    {
        bdT = ada1;
        super();
    }

    bject(ada ada1, byte byte0)
    {
        this(ada1);
    }
}
