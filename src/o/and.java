// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.EditText;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            anb, aui

final class and
    implements Runnable
{

    private anb btJ;

    and(anb anb1)
    {
        btJ = anb1;
        super();
    }

    public final void run()
    {
        String s = anb._mth02CB(btJ).getText().toString();
        if (aui._mth02BF(s))
        {
            anb._mth02CE(btJ).userSearch(s);
        }
    }
}
