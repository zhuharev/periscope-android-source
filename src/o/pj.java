// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            ph

final class pj
    implements android.view.View.OnClickListener
{

    private ph NX;

    pj(ph ph1)
    {
        NX = ph1;
        super();
    }

    public final void onClick(View view)
    {
        NX.setResult(0);
        NX.finish();
    }
}
