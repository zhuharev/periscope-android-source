// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;

// Referenced classes of package o:
//            agp, agl, ask

final class agu
    implements Runnable
{

    private agp ble;
    private String blh;

    agu(agp agp1, String s)
    {
        ble = agp1;
        blh = s;
        super();
    }

    public final void run()
    {
        if (agp._mth0640(ble) != null && agp._mth0640(ble).bjX)
        {
            agl agl1 = agp._mth0640(ble);
            File file = new File(blh);
            agl1.bjY = file.getAbsolutePath();
            agl1.bjP._mth1FBE(file);
        }
    }
}
