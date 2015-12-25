// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.view.ViewGroup;

// Referenced classes of package o:
//            air

final class ais
    implements Runnable
{

    private air boh;

    ais(air air1)
    {
        boh = air1;
        super();
    }

    public final void run()
    {
        boh.boe.removeView(boh.bof);
    }
}
