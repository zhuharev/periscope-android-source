// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import org.json.JSONObject;

// Referenced classes of package o:
//            vd, vc, va, ut, 
//            ux, vi, sc, vh, 
//            uu, uw

public class vj
{

    vj()
    {
    }

    public vh _mth02CA(sc sc1, JSONObject jsonobject)
    {
        int i = jsonobject.optInt("settings_version", 0);
        int j = jsonobject.optInt("cache_duration", 3600);
        uw uw1 = _mth02CB(jsonobject.getJSONObject("app"));
        Object obj = jsonobject.getJSONObject("session");
        obj = new vd(((JSONObject) (obj)).optInt("log_buffer_size", 64000), ((JSONObject) (obj)).optInt("max_chained_exception_depth", 8), ((JSONObject) (obj)).optInt("max_custom_exception_events", 64), ((JSONObject) (obj)).optInt("max_custom_key_value_pairs", 64), ((JSONObject) (obj)).optInt("identifier_mask", 255), ((JSONObject) (obj)).optBoolean("send_session_without_crash", false));
        Object obj1 = jsonobject.getJSONObject("prompt");
        obj1 = new vc(((JSONObject) (obj1)).optString("title", "Send Crash Report?"), ((JSONObject) (obj1)).optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), ((JSONObject) (obj1)).optString("send_button_title", "Send"), ((JSONObject) (obj1)).optBoolean("show_cancel_button", true), ((JSONObject) (obj1)).optString("cancel_button_title", "Don't Send"), ((JSONObject) (obj1)).optBoolean("show_always_send_button", true), ((JSONObject) (obj1)).optString("always_send_button_title", "Always Send"));
        Object obj2 = jsonobject.getJSONObject("features");
        obj2 = new va(((JSONObject) (obj2)).optBoolean("prompt_enabled", false), ((JSONObject) (obj2)).optBoolean("collect_logged_exceptions", true), ((JSONObject) (obj2)).optBoolean("collect_reports", true), ((JSONObject) (obj2)).optBoolean("collect_analytics", false));
        Object obj3 = jsonobject.getJSONObject("analytics");
        obj3 = new ut(((JSONObject) (obj3)).optString("url", "https://e.crashlytics.com/spi/v2/events"), ((JSONObject) (obj3)).optInt("flush_interval_secs", 600), ((JSONObject) (obj3)).optInt("max_byte_size_per_file", 8000), ((JSONObject) (obj3)).optInt("max_file_count_per_send", 1), ((JSONObject) (obj3)).optInt("max_pending_send_file_count", 100), ((JSONObject) (obj3)).optBoolean("track_custom_events", true), ((JSONObject) (obj3)).optBoolean("track_predefined_events", true), ((JSONObject) (obj3)).optInt("sampling_rate", 1));
        Object obj4 = jsonobject.getJSONObject("beta");
        obj4 = new ux(((JSONObject) (obj4)).optString("update_endpoint", vi.Va), ((JSONObject) (obj4)).optInt("update_suspend_duration", 3600));
        long l = j;
        if (jsonobject.has("expires_at"))
        {
            l = jsonobject.getLong("expires_at");
        } else
        {
            l = sc1.getCurrentTimeMillis() + 1000L * l;
        }
        return new vh(l, uw1, ((vd) (obj)), ((vc) (obj1)), ((va) (obj2)), ((ut) (obj3)), ((ux) (obj4)), i, j);
    }

    uw _mth02CB(JSONObject jsonobject)
    {
        String s = jsonobject.getString("identifier");
        String s1 = jsonobject.getString("status");
        String s2 = jsonobject.getString("url");
        String s3 = jsonobject.getString("reports_url");
        boolean flag = jsonobject.optBoolean("update_required", false);
        Object obj = null;
        uu uu1 = obj;
        if (jsonobject.has("icon"))
        {
            uu1 = obj;
            if (jsonobject.getJSONObject("icon").has("hash"))
            {
                jsonobject = jsonobject.getJSONObject("icon");
                uu1 = new uu(jsonobject.getString("hash"), jsonobject.getInt("width"), jsonobject.getInt("height"));
            }
        }
        return new uw(s, s1, s2, s3, flag, uu1);
    }
}
