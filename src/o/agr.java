// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.TextView;

// Referenced classes of package o:
//            agp

final class agr
    implements Runnable
{

    private agp ble;
    private String blf;

    agr(agp agp1, String s)
    {
        ble = agp1;
        blf = s;
        super();
    }

    public final void run()
    {
        ((TextView)ble.findViewById(0x7f0d01c0)).setText(blf);
    }
}
