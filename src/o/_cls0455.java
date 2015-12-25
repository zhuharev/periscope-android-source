// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package o:
//            _cls05E1, rz, ra, rl

final class _cls0455
{

    static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File uH;

    public _cls0455(File file)
    {
        uH = file;
    }

    static String _mth02CA(Map map)
    {
        return (new JSONObject(map)).toString();
    }

    private static HashMap FE76(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        HashMap hashmap = new HashMap();
        String s1;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s1, s))
        {
            s1 = (String)iterator.next();
            if (!jsonobject.isNull(s1))
            {
                s = jsonobject.optString(s1, null);
            } else
            {
                s = null;
            }
        }

        return hashmap;
    }

    public final _cls05E1 _mth1D54(String s)
    {
        String s1;
        String s2;
        s = new File(uH, (new StringBuilder()).append(s).append("user.meta").toString());
        if (!s.exists())
        {
            return _cls05E1.vZ;
        }
        s2 = null;
        s1 = null;
        Object obj = new FileInputStream(s);
        s = ((String) (obj));
        s1 = s;
        s2 = s;
        Object obj1 = new JSONObject(rz._mth02CA(((FileInputStream) (obj))));
        s1 = s;
        s2 = s;
        if (((JSONObject) (obj1)).isNull("userId")) goto _L2; else goto _L1
_L1:
        s1 = s;
        s2 = s;
        obj = ((JSONObject) (obj1)).optString("userId", null);
_L5:
        s1 = s;
        s2 = s;
        if (((JSONObject) (obj1)).isNull("userName")) goto _L4; else goto _L3
_L3:
        s1 = s;
        s2 = s;
        String s3 = ((JSONObject) (obj1)).optString("userName", null);
_L6:
        s1 = s;
        s2 = s;
        if (((JSONObject) (obj1)).isNull("userEmail"))
        {
            break MISSING_BLOCK_LABEL_246;
        }
        s1 = s;
        s2 = s;
        obj1 = ((JSONObject) (obj1)).optString("userEmail", null);
_L7:
        s1 = s;
        s2 = s;
        obj = new _cls05E1(((String) (obj)), s3, ((String) (obj1)));
        rz._mth02CA(s, "Failed to close user metadata file.");
        return ((_cls05E1) (obj));
        s;
        s2 = s1;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Error deserializing user metadata.", s);
        rz._mth02CA(s1, "Failed to close user metadata file.");
        break MISSING_BLOCK_LABEL_230;
        s;
        rz._mth02CA(s2, "Failed to close user metadata file.");
        throw s;
        return _cls05E1.vZ;
_L2:
        obj = null;
          goto _L5
_L4:
        s3 = null;
          goto _L6
        obj1 = null;
          goto _L7
    }

    public final Map _mth1D62(String s)
    {
        Object obj;
        Object obj1;
        obj1 = _mth2071(s);
        if (!((File) (obj1)).exists())
        {
            return Collections.emptyMap();
        }
        obj = null;
        s = null;
        Object obj2 = new FileInputStream(((File) (obj1)));
        obj1 = obj2;
        s = ((String) (obj1));
        obj = obj1;
        obj2 = FE76(rz._mth02CA(((FileInputStream) (obj2))));
        rz._mth02CA(((java.io.Closeable) (obj1)), "Failed to close user metadata file.");
        return ((Map) (obj2));
        Exception exception;
        exception;
        obj = s;
        ra._mth0454()._mth02CB("CrashlyticsCore", "Error deserializing user metadata.", exception);
        rz._mth02CA(s, "Failed to close user metadata file.");
        break MISSING_BLOCK_LABEL_89;
        s;
        rz._mth02CA(((java.io.Closeable) (obj)), "Failed to close user metadata file.");
        throw s;
        return Collections.emptyMap();
    }

    File _mth2071(String s)
    {
        return new File(uH, (new StringBuilder()).append(s).append("keys.meta").toString());
    }

}
