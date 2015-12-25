// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            aey

final class aez
    implements android.view.View.OnClickListener
{

    private aey big;

    aez(aey aey1)
    {
        big = aey1;
        super();
    }

    public final void onClick(View view)
    {
        switch (aey._cls1.bih[aey._mth02CA(big) - 1])
        {
        default:
            return;

        case 1: // '\001'
            aey._mth02CA(big, 0x7f06005e, 0x7f06005d);
            return;

        case 2: // '\002'
            aey._mth02CA(big, 0x7f060053, 0x7f060052);
            return;

        case 3: // '\003'
            big.bB();
            break;
        }
    }
}
