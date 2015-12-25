// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            pu, pz

final class pv
    implements Runnable
{

    private pz OX;
    private boolean OY;
    private pu OZ;

    pv(pu pu1, pz pz, boolean flag)
    {
        OZ = pu1;
        OX = pz;
        OY = flag;
        super();
    }

    public final void run()
    {
        OZ.setImageRotateBitmapResetBase(OX, OY);
    }
}
