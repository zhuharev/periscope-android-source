// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.Handler;

// Referenced classes of package o:
//            pu

final class pw
    implements Runnable
{

    private pu OZ;
    private float Pa;
    private long Pb;
    private float Pc;
    private float Pd;
    private float Pe;
    private float Pf;

    pw(pu pu1, float f, long l, float f1, float f2, float f3, 
            float f4)
    {
        OZ = pu1;
        Pa = f;
        Pb = l;
        Pc = f1;
        Pd = f2;
        Pe = f3;
        Pf = f4;
        super();
    }

    public final void run()
    {
        long l = System.currentTimeMillis();
        float f = Math.min(Pa, l - Pb);
        float f1 = Pc;
        float f2 = Pd;
        OZ._mth02CE(f1 + f2 * f, Pe, Pf);
        if (f < Pa)
        {
            OZ.handler.post(this);
        }
    }
}
