// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.graphics.Paint;

final class amx extends Paint
{

    private amw.if btu;

    amx(amw.if if1)
    {
        btu = if1;
        super();
        setStyle(android.graphics.Paint.Style.STROKE);
        setStrokeCap(android.graphics.Paint.Cap.ROUND);
        setStrokeWidth(3F);
        setAntiAlias(true);
    }
}
