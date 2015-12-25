// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package o:
//            rz, uj, ug, ri, 
//            uf

public abstract class rq
{

    private static final Pattern Rg = Pattern.compile("http(s?)://[^\\/]+", 2);
    private final uf Rh;
    private final String Ri;
    public final ri kit;
    private final uj sA;
    public final String url;

    public rq(ri ri1, String s, String s1, uj uj1, uf uf)
    {
        if (s1 == null)
        {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (uj1 == null)
        {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        kit = ri1;
        Ri = s;
        ri1 = s1;
        if (!rz._mth14A2(Ri))
        {
            ri1 = Rg.matcher(s1).replaceFirst(Ri);
        }
        url = ri1;
        sA = uj1;
        Rh = uf;
    }

    public final ug _mth02CB(Map map)
    {
        map = sA._mth02CA(Rh, url, map);
        if (((ug) (map)).connection == null)
        {
            map.connection = map._mth1D08();
        }
        ((ug) (map)).connection.setUseCaches(false);
        if (((ug) (map)).connection == null)
        {
            map.connection = map._mth1D08();
        }
        ((ug) (map)).connection.setConnectTimeout(10000);
        String s = (new StringBuilder("Crashlytics Android SDK/")).append(kit.getVersion()).toString();
        if (((ug) (map)).connection == null)
        {
            map.connection = map._mth1D08();
        }
        ((ug) (map)).connection.setRequestProperty("User-Agent", s);
        if (((ug) (map)).connection == null)
        {
            map.connection = map._mth1D08();
        }
        ((ug) (map)).connection.setRequestProperty("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return map;
    }

    public final ug _mth0629()
    {
        return _mth02CB(Collections.emptyMap());
    }

}
