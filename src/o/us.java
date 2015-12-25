// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.content.res.Resources;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package o:
//            rq, uv, ug, rz, 
//            ri, vb, ra, rl, 
//            rk, uj, uf

abstract class us extends rq
{

    public us(ri ri1, String s, String s1, uj uj, uf uf)
    {
        super(ri1, s, s1, uj, uf);
    }

    private ug _mth02CA(ug ug1, uv uv1)
    {
        Object obj;
        ug ug2;
        ug2 = ug1._mth02CB("app[identifier]", null, null, uv1.Ue)._mth02CB("app[name]", null, null, uv1.name)._mth02CB("app[display_version]", null, null, uv1.tN)._mth02CB("app[build_version]", null, null, uv1.tO)._mth02CB("app[source]", Integer.valueOf(uv1.Ug))._mth02CB("app[minimum_sdk_version]", null, null, uv1.Uh)._mth02CB("app[built_sdk_version]", null, null, uv1.Ui);
        if (!rz._mth14A2(uv1.Uf))
        {
            ug2._mth02CB("app[instance_identifier]", null, null, uv1.Uf);
        }
        if (uv1.Uj == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        obj = null;
        ug1 = null;
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(uv1.Uj.Uv);
        ug1 = inputstream;
        obj = inputstream;
        ug2._mth02CB("app[icon][hash]", null, null, uv1.Uj.Ud)._mth02CA("app[icon][data]", "icon.png", "application/octet-stream", inputstream)._mth02CB("app[icon][width]", Integer.valueOf(uv1.Uj.width))._mth02CB("app[icon][height]", Integer.valueOf(uv1.Uj.height));
        rz._mth02CA(inputstream, "Failed to close app icon InputStream.");
        break MISSING_BLOCK_LABEL_266;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        obj = ug1;
        ra._mth0454()._mth02CB("Fabric", (new StringBuilder("Failed to find app icon with resource ID: ")).append(uv1.Uj.Uv).toString(), notfoundexception);
        rz._mth02CA(ug1, "Failed to close app icon InputStream.");
        break MISSING_BLOCK_LABEL_266;
        ug1;
        rz._mth02CA(((java.io.Closeable) (obj)), "Failed to close app icon InputStream.");
        throw ug1;
        if (uv1.Uk != null)
        {
            for (ug1 = uv1.Uk.iterator(); ug1.hasNext(); ug2._mth02CB(String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
    ((rk) (uv1)).identifier
}), null, null, ((rk) (uv1)).QW))
            {
                uv1 = (rk)ug1.next();
                ug2._mth02CB(String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
                    ((rk) (uv1)).identifier
                }), null, null, ((rk) (uv1)).version);
            }

        }
        return ug2;
    }

    public boolean _mth02CA(uv uv1)
    {
        ug ug1 = _mth0629();
        String s = uv1.sX;
        if (ug1.connection == null)
        {
            ug1.connection = ug1._mth1D08();
        }
        ug1.connection.setRequestProperty("X-CRASHLYTICS-API-KEY", s);
        if (ug1.connection == null)
        {
            ug1.connection = ug1._mth1D08();
        }
        ug1.connection.setRequestProperty("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        s = kit.getVersion();
        if (ug1.connection == null)
        {
            ug1.connection = ug1._mth1D08();
        }
        ug1.connection.setRequestProperty("X-CRASHLYTICS-API-CLIENT-VERSION", s);
        ug1 = _mth02CA(ug1, uv1);
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Sending app info to ")).append(super.url).toString());
        if (uv1.Uj != null)
        {
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("App icon hash is ")).append(uv1.Uj.Ud).toString());
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("App icon size is ")).append(uv1.Uj.width).append("x").append(uv1.Uj.height).toString());
        }
        int i = ug1.code();
        if (ug1.connection == null)
        {
            ug1.connection = ug1._mth1D08();
        }
        if ("POST".equals(ug1.connection.getRequestMethod()))
        {
            uv1 = "Create";
        } else
        {
            uv1 = "Update";
        }
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder()).append(uv1).append(" app request ID: ").append(ug1.header("X-REQUEST-ID")).toString());
        ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Result was ")).append(i).toString());
        return android.support.v7.widget.Toolbar.if._mth02B2(i) == 0;
    }
}
