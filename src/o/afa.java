// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package o:
//            aey

final class afa
    implements android.view.View.OnClickListener
{

    private aey big;

    afa(aey aey1)
    {
        big = aey1;
        super();
    }

    public final void onClick(View view)
    {
        switch (aey._cls1.bii[aey._mth02CB(big) - 1])
        {
        default:
            return;

        case 1: // '\001'
            aey._mth02CE(big).clearFocus();
            return;

        case 2: // '\002'
            break;
        }
        if (aey._mth02CE(big).length() > 0)
        {
            view = aey._mth02CE(big).getText().toString();
            if (aey._mth02CF(big) != null)
            {
                aey._mth02CF(big)._mth062F(view);
            }
            aey._mth02CE(big).setText("");
        }
    }
}
