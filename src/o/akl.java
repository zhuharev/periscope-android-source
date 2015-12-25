// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewTreeObserver;

// Referenced classes of package o:
//            akk, arx

final class akl
    implements android.view.ViewTreeObserver.OnPreDrawListener
{

    private ViewTreeObserver bqG;
    private akk bqH;

    akl(akk akk1, ViewTreeObserver viewtreeobserver)
    {
        bqH = akk1;
        bqG = viewtreeobserver;
        super();
    }

    public final boolean onPreDraw()
    {
        bqH.bgt._mth14A1(bqH.bpy);
        bqG.removeOnPreDrawListener(this);
        return true;
    }
}
