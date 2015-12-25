// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            agp, aey

final class ags
    implements Runnable
{

    private agp ble;
    private String blg;

    ags(agp agp1, String s)
    {
        ble = agp1;
        blg = s;
        super();
    }

    public final void run()
    {
        agp._mth02CC(ble).setUpReply((new StringBuilder()).append(blg).append(' ').toString());
    }
}
