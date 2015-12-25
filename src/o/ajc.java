// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewPropertyAnimator;
import android.widget.ProgressBar;

// Referenced classes of package o:
//            ajd, ajb

final class ajc
    implements aka.if.if
{

    final ProgressBar boT;
    private ajb boU;

    ajc(ajb ajb, ProgressBar progressbar)
    {
        boU = ajb;
        boT = progressbar;
        super();
    }

    public final void cJ()
    {
        boT.animate().alpha(0.0F).setListener(new ajd(this));
    }
}
