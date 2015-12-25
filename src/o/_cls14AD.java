// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package o:
//            tp, _cls1491, _cls14AC

final class _cls14AD
    implements tp
{

    _cls14AD()
    {
    }

    private static JSONObject _mth02CB(_cls1491 _pcls1491)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            _cls14AC _lcls14ac = _pcls1491.sZ;
            jsonobject.put("appBundleId", _lcls14ac.tu);
            jsonobject.put("executionId", _lcls14ac.tv);
            jsonobject.put("installationId", _lcls14ac.tw);
            jsonobject.put("androidId", _lcls14ac.tx);
            jsonobject.put("advertisingId", _lcls14ac.advertisingId);
            jsonobject.put("limitAdTrackingEnabled", _lcls14ac.ty);
            jsonobject.put("betaDeviceToken", _lcls14ac.tz);
            jsonobject.put("buildId", _lcls14ac.tA);
            jsonobject.put("osVersion", _lcls14ac.tB);
            jsonobject.put("deviceModel", _lcls14ac.tC);
            jsonobject.put("appVersionCode", _lcls14ac.tD);
            jsonobject.put("appVersionName", _lcls14ac.tE);
            jsonobject.put("timestamp", _pcls1491.timestamp);
            jsonobject.put("type", _pcls1491.ta.toString());
            jsonobject.put("details", new JSONObject(_pcls1491.tb));
            jsonobject.put("customType", _pcls1491.tc);
            jsonobject.put("customAttributes", new JSONObject(_pcls1491.td));
            jsonobject.put("predefinedType", _pcls1491.te);
            jsonobject.put("predefinedAttributes", new JSONObject(_pcls1491.tf));
        }
        // Misplaced declaration of an exception variable
        catch (_cls1491 _pcls1491)
        {
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                throw new IOException(_pcls1491.getMessage(), _pcls1491);
            } else
            {
                throw new IOException(_pcls1491.getMessage());
            }
        }
        return jsonobject;
    }

    public final byte[] toBytes(Object obj)
    {
        return _mth02CB((_cls1491)obj).toString().getBytes("UTF-8");
    }
}
