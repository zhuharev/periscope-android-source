// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.concurrent.Callable;

// Referenced classes of package o:
//            abd, abi

final class abg
    implements Callable
{

    private abd bbX;
    private abi bbY;

    abg(abd abd1, abi abi1)
    {
        bbX = abd1;
        bbY = abi1;
        super();
    }

    private Void _mth01CF()
    {
        if (abd._mth02CA(bbX))
        {
            bbY.onError(new Exception("Logger is closed!!!"));
            return null;
        }
        Object obj;
        try
        {
            obj = abd._mth02CE(bbX);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bbY.onError(((Exception) (obj)));
            return null;
        }
        if (bbY.onReceive(((java.io.File []) (obj))))
        {
            bbX._mth02CA(((java.io.File []) (obj)));
        }
        return null;
    }

    public final Object call()
    {
        return _mth01CF();
    }
}
