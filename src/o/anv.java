// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;

// Referenced classes of package o:
//            ans, ann

final class anv
    implements TextWatcher
{

    private ans buK;

    anv(ans ans1)
    {
        buK = ans1;
        super();
    }

    public final void afterTextChanged(Editable editable)
    {
        ans._mth02CB(buK).getFilter().filter(editable.toString());
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ans._mth02CB(buK).getFilter().filter(charsequence);
    }
}
