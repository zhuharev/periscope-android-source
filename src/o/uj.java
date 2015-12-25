// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package o:
//            rl, ue, uf, ug, 
//            uk, FF5A

public class uj
{

    final rl QJ;
    uk TI;
    boolean TJ;
    SSLSocketFactory sslSocketFactory;

    public uj()
    {
        this(new rl());
    }

    public uj(rl rl1)
    {
        QJ = rl1;
    }

    SSLSocketFactory getSSLSocketFactory()
    {
        this;
        JVM INSTR monitorenter ;
        SSLSocketFactory sslsocketfactory;
        if (sslSocketFactory == null && !TJ)
        {
            sslSocketFactory = _mth1E8E();
        }
        sslsocketfactory = sslSocketFactory;
        this;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public ug _mth02CA(uf uf1, String s, Map map)
    {
        switch (ue.Tq[uf1.ordinal()])
        {
        case 1: // '\001'
            uf1 = ug._mth02CA(s, map, true);
            break;

        case 2: // '\002'
            uf1 = ug._mth02CB(s, map, true);
            break;

        case 3: // '\003'
            uf1 = ug._mth1D5B(s);
            break;

        case 4: // '\004'
            uf1 = ug._mth1D65(s);
            break;

        default:
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        boolean flag;
        if (s != null && s.toLowerCase(Locale.US).startsWith("https"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && TI != null)
        {
            s = getSSLSocketFactory();
            if (s != null)
            {
                if (((ug) (uf1)).connection == null)
                {
                    uf1.connection = uf1._mth1D08();
                }
                ((HttpsURLConnection)((ug) (uf1)).connection).setSSLSocketFactory(s);
            }
        }
        return uf1;
    }

    public void _mth02CA(FF5A ff5a)
    {
        if (TI != ff5a)
        {
            TI = ff5a;
            _mth1E6D();
        }
    }

    void _mth1E6D()
    {
        this;
        JVM INSTR monitorenter ;
        TJ = false;
        sslSocketFactory = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    SSLSocketFactory _mth1E8E()
    {
        this;
        JVM INSTR monitorenter ;
        TJ = true;
        SSLSocketFactory sslsocketfactory;
        sslsocketfactory = _cls141D.if._mth02CA(TI);
        QJ._mth02BE("Fabric", "Custom SSL pinning enabled");
        this;
        JVM INSTR monitorexit ;
        return sslsocketfactory;
        Object obj;
        obj;
        QJ._mth02CB("Fabric", "Exception while validating pinned certs", ((Exception) (obj)));
        this;
        JVM INSTR monitorexit ;
        return null;
        obj;
        throw obj;
    }
}
