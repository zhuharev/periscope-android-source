// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            agp

final class aha
    implements Runnable
{

    private agp ble;

    aha(agp agp1)
    {
        ble = agp1;
        super();
    }

    public final void run()
    {
        if (ble.isFinishing())
        {
            return;
        } else
        {
            agp._mth02CE(ble);
            return;
        }
    }
}
