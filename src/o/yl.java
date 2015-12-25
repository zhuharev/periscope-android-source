// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yk, zz, xw, _cls0675, 
//            xx

final class yl
    implements Runnable
{

    private String aVd;
    private String aVe;
    private xx aVf;
    private String aVg;
    private yk aVh;

    yl(yk yk1, String s, String s1, xx xx, String s2)
    {
        aVh = yk1;
        aVd = s;
        aVe = s1;
        aVf = xx;
        aVg = s2;
        super();
    }

    public final void run()
    {
        if (yk._mth02CA(aVh)._mth02CE(aVf))
        {
            try
            {
                yk._mth02CB(aVh)._mth02CA(aVf, aVg, aVd, aVe);
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                _cls0675.log((new StringBuilder("Could not call history on: ")).append(aVf).append(" with cursor ").append(aVe).toString());
                throw illegalstateexception;
            }
        } else
        {
            return;
        }
    }
}
