// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.widget.TextView;

// Referenced classes of package o:
//            agp

final class ahh
    implements Runnable
{

    private agp ble;
    private String bln;

    ahh(agp agp1, String s)
    {
        ble = agp1;
        bln = s;
        super();
    }

    public final void run()
    {
        ((TextView)ble.findViewById(0x7f0d01c1)).setText(bln);
    }
}
