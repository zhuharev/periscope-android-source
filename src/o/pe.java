// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            pb

final class pe
    implements Runnable
{

    pb NG;
    Thread NH;
    private volatile boolean NI;
    private String name;

    pe(String s, pb pb1)
    {
        NG = pb1;
        name = s;
    }

    public final void run()
    {
        do
        {
            NG.run();
            try
            {
                Thread.sleep(NG.getInterval() * 1000);
            }
            catch (InterruptedException interruptedexception) { }
        } while (!NI);
    }

    final void FF6F()
    {
        NI = true;
    }
}
