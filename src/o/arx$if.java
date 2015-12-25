// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.View;

// Referenced classes of package o:
//            apw, arx

final class it> extends apw
{

    private arx bCl;

    final boolean ei()
    {
        return bzq && view.getTop() >= bCl.getHeight();
    }

    final boolean ej()
    {
        return view.getTop() < bCl.getHeight();
    }

    iew.View(arx arx1)
    {
        bCl = arx1;
        super();
    }
}
