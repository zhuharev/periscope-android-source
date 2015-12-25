// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            sx, sn, ri, rg, 
//            rf, tf, ra, rl, 
//            sw

final class rh extends sx
{

    private ri kit;

    public rh(ri ri1)
    {
        kit = ri1;
    }

    private sn _mth13A5(String s)
    {
        s = new sn((new StringBuilder()).append(kit.getIdentifier()).append(".").append(s).toString(), "KitInitialization");
        s._mth1490();
        return s;
    }

    protected final Object doInBackground(Object aobj[])
    {
        sn sn1 = _mth13A5("doInBackground");
        aobj = null;
        if (!isCancelled())
        {
            aobj = ((Object []) (kit.doInBackground()));
        }
        sn1._mth14D3();
        return ((Object) (aobj));
    }

    protected final void onCancelled(Object obj)
    {
        kit.onCancelled(obj);
        obj = new rg((new StringBuilder()).append(kit.getIdentifier()).append(" Initialization was cancelled").toString());
        kit.initializationCallback._mth02CE(((Exception) (obj)));
    }

    protected final void onPostExecute(Object obj)
    {
        kit.onPostExecute(obj);
        kit.initializationCallback._mth050D();
    }

    protected final void onPreExecute()
    {
        sn sn1;
        super.onPreExecute();
        sn1 = _mth13A5("onPreExecute");
        boolean flag = kit.onPreExecute();
        sn1._mth14D3();
        Object obj;
        if (!flag)
        {
            cancel(true);
            return;
        } else
        {
            return;
        }
        obj;
        throw obj;
        obj;
        ra._mth0454()._mth02CB("Fabric", "Failure onPreExecute()", ((Exception) (obj)));
        sn1._mth14D3();
        cancel(true);
        return;
        obj;
        sn1._mth14D3();
        cancel(true);
        throw obj;
    }

    public final int _mth1FD8()
    {
        return sw.SP;
    }
}
