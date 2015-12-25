// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package o:
//            rq, uf, _cls14B7, ug, 
//            ri, ra, rl, _cls14D6, 
//            _cls14D8, _cls14B6, uj

final class _cls14BA extends rq
{

    private final _cls14D8 tL;

    public _cls14BA(_cls14B6 _pcls14b6, String s, String s1, uj uj, _cls14D8 _pcls14d8)
    {
        super(_pcls14b6, s, s1, uj, uf.Tr);
        tL = _pcls14d8;
    }

    public final _cls14D6 _mth02CA(String s, String s1, _cls14B7 _pcls14b7)
    {
        Object obj;
        Object obj1;
        String s2;
        Object obj2;
        obj2 = null;
        s2 = null;
        obj1 = s2;
        obj = obj2;
        HashMap hashmap = new HashMap();
        obj1 = s2;
        obj = obj2;
        hashmap.put("build_version", _pcls14b7.st);
        obj1 = s2;
        obj = obj2;
        hashmap.put("display_version", _pcls14b7.versionName);
        obj1 = s2;
        obj = obj2;
        hashmap.put("instance", _pcls14b7.tA);
        obj1 = s2;
        obj = obj2;
        hashmap.put("source", "3");
        obj1 = s2;
        obj = obj2;
        _pcls14b7 = _mth02CB(hashmap);
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("Accept", "application/json");
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        s2 = (new StringBuilder("Crashlytics Android SDK/")).append(kit.getVersion()).toString();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("User-Agent", s2);
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        s2 = kit.getVersion();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("X-CRASHLYTICS-API-CLIENT-VERSION", s2);
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_416;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("X-CRASHLYTICS-API-KEY", s);
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        if (((ug) (_pcls14b7)).connection != null)
        {
            break MISSING_BLOCK_LABEL_459;
        }
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        _pcls14b7.connection = _pcls14b7._mth1D08();
        obj1 = _pcls14b7;
        obj = _pcls14b7;
        ((ug) (_pcls14b7)).connection.setRequestProperty("X-CRASHLYTICS-D", s1);
        s = _pcls14b7;
        obj1 = s;
        obj = s;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Checking for updates from ")).append(super.url).toString());
        obj1 = s;
        obj = s;
        ra._mth0454()._mth02BE("Beta", (new StringBuilder("Checking for updates query params are: ")).append(hashmap).toString());
        obj1 = s;
        obj = s;
        String s3;
        String s4;
        boolean flag;
        if (200 == s.code())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_727;
        }
        obj1 = s;
        obj = s;
        ra._mth0454()._mth02BE("Beta", "Checking for updates was successful");
        obj1 = s;
        obj = s;
        s1 = new JSONObject(s.FBE8(s._mth1D22()));
        obj1 = s;
        obj = s;
        _pcls14b7 = s1.optString("url", null);
        obj1 = s;
        obj = s;
        s3 = s1.optString("version_string", null);
        obj1 = s;
        obj = s;
        s4 = s1.optString("build_version", null);
        obj1 = s;
        obj = s;
        s1 = new _cls14D6(_pcls14b7, s3, s1.optString("display_version", null), s4, s1.optString("identifier", null), s1.optString("instance_identifier", null));
        if (s != null)
        {
            s = s.header("X-REQUEST-ID");
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
        }
        return s1;
        obj1 = s;
        obj = s;
        ra._mth0454()._mth02CA("Beta", (new StringBuilder("Checking for updates failed. Response code: ")).append(s.code()).toString());
        if (s != null)
        {
            s = s.header("X-REQUEST-ID");
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
        }
        break MISSING_BLOCK_LABEL_911;
        s;
        obj = obj1;
        ra._mth0454()._mth02CB("Beta", (new StringBuilder("Error while checking for updates from ")).append(super.url).toString(), s);
        if (obj1 != null)
        {
            s = ((ug) (obj1)).header("X-REQUEST-ID");
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s).toString());
        }
        break MISSING_BLOCK_LABEL_911;
        s;
        if (obj != null)
        {
            s1 = ((ug) (obj)).header("X-REQUEST-ID");
            ra._mth0454()._mth02BE("Fabric", (new StringBuilder("Checking for updates request ID: ")).append(s1).toString());
        }
        throw s;
        return null;
    }
}
