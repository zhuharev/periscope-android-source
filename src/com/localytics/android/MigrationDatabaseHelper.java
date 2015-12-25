// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorJoiner;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, Constants, DatapointHelper

final class MigrationDatabaseHelper extends SQLiteOpenHelper
{
    static final class AmpConditionValuesDbColumns
        implements BaseColumns
    {

        static final String CONDITION_ID_REF = "condition_id_ref";
        static final String TABLE_NAME = "amp_condition_values";
        static final String VALUE = "value";

        private AmpConditionValuesDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class AmpConditionsDbColumns
        implements BaseColumns
    {

        static final String ATTRIBUTE_NAME = "attribute_name";
        static final String OPERATOR = "operator";
        static final String RULE_ID_REF = "rule_id_ref";
        static final String TABLE_NAME = "amp_conditions";

        private AmpConditionsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class AmpDisplayedDbColumns
        implements BaseColumns
    {

        static final String CAMPAIGN_ID = "campaign_id";
        static final String DISPLAYED = "displayed";
        static final String TABLE_NAME = "amp_displayed";

        private AmpDisplayedDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class AmpRuleEventDbColumns
        implements BaseColumns
    {

        static final String EVENT_NAME = "event_name";
        static final String RULE_ID_REF = "rule_id_ref";
        static final String TABLE_NAME = "amp_ruleevent";

        private AmpRuleEventDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class AmpRulesDbColumns
        implements BaseColumns
    {

        static final String AB_TEST = "ab_test";
        static final String CAMPAIGN_ID = "campaign_id";
        static final String DEVICES = "devices";
        static final String DISPLAY_SECONDS = "display_seconds";
        static final String DISPLAY_SESSION = "display_session";
        static final String EXPIRATION = "expiration";
        static final String INTERNET_REQUIRED = "internet_required";
        static final String LOCATION = "location";
        static final String PHONE_LOCATION = "phone_location";
        static final String PHONE_SIZE_HEIGHT = "phone_size_height";
        static final String PHONE_SIZE_WIDTH = "phone_size_width";
        static final String RULE_NAME = "rule_name";
        static final String TABLET_LOCATION = "tablet_location";
        static final String TABLET_SIZE_HEIGHT = "tablet_size_height";
        static final String TABLET_SIZE_WIDTH = "tablet_size_width";
        static final String TABLE_NAME = "amp_rules";
        static final String TIME_TO_DISPLAY = "time_to_display";
        static final String VERSION = "version";

        private AmpRulesDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class ApiKeysDbColumns
        implements BaseColumns
    {

        static final String API_KEY = "api_key";
        static final String CREATED_TIME = "created_time";
        static final String OPT_OUT = "opt_out";
        static final String TABLE_NAME = "api_keys";
        static final String UUID = "uuid";

        private ApiKeysDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class AttributesDbColumns
        implements BaseColumns
    {

        static final String ATTRIBUTE_CUSTOM_DIMENSION_1 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_0"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_10 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_9"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_2 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_1"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_3 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_2"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_4 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_3"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_5 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_4"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_6 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_5"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_7 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_6"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_8 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_7"
        });
        static final String ATTRIBUTE_CUSTOM_DIMENSION_9 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_8"
        });
        static final String ATTRIBUTE_FORMAT = "%s:%s";
        static final String ATTRIBUTE_KEY = "attribute_key";
        static final String ATTRIBUTE_VALUE = "attribute_value";
        static final String EVENTS_KEY_REF = "events_key_ref";
        static final String TABLE_NAME = "attributes";


        private AttributesDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class CustomDimensionsDbColumns
        implements BaseColumns
    {

        static final String CUSTOM_DIMENSION_1 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_0"
        });
        static final String CUSTOM_DIMENSION_10 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_9"
        });
        static final String CUSTOM_DIMENSION_2 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_1"
        });
        static final String CUSTOM_DIMENSION_3 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_2"
        });
        static final String CUSTOM_DIMENSION_4 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_3"
        });
        static final String CUSTOM_DIMENSION_5 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_4"
        });
        static final String CUSTOM_DIMENSION_6 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_5"
        });
        static final String CUSTOM_DIMENSION_7 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_6"
        });
        static final String CUSTOM_DIMENSION_8 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_7"
        });
        static final String CUSTOM_DIMENSION_9 = String.format("%s:%s", new Object[] {
            "com.localytics.android", "custom_dimension_8"
        });
        static final String CUSTOM_DIMENSION_FORMAT = "%s:%s";
        static final String CUSTOM_DIMENSION_KEY = "custom_dimension_key";
        static final String CUSTOM_DIMENSION_VALUE = "custom_dimension_value";
        static final String TABLE_NAME = "custom_dimensions";


        private CustomDimensionsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventFlow
    {

        static final String KEY_DATA_TYPE = "dt";
        static final String KEY_EVENT_UUID = "u";
        static final String KEY_FLOW_NEW = "nw";
        static final String KEY_FLOW_OLD = "od";
        static final String KEY_SESSION_START_TIME = "ss";
        static final String VALUE_DATA_TYPE = "f";

        private EventFlow()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventFlow.Element
    {

        static final String TYPE_EVENT = "e";
        static final String TYPE_SCREEN = "s";

        private EventFlow.Element()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventHistoryDbColumns
        implements BaseColumns
    {

        static final String NAME = "name";
        static final String PROCESSED_IN_BLOB = "processed_in_blob";
        static final String SESSION_KEY_REF = "session_key_ref";
        static final String TABLE_NAME = "event_history";
        static final String TYPE = "type";
        static final int TYPE_EVENT = 0;
        static final int TYPE_SCREEN = 1;

        private EventHistoryDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventsDbColumns
        implements BaseColumns
    {

        static final String CLV_INCREASE = "clv_increase";
        static final String CUST_ID = "customer_id";
        static final String EVENT_NAME = "event_name";
        static final String IDENTIFIERS = "ids";
        static final String LAT_NAME = "event_lat";
        static final String LNG_NAME = "event_lng";
        static final String REAL_TIME = "real_time";
        static final String SESSION_KEY_REF = "session_key_ref";
        static final String TABLE_NAME = "events";
        static final String USER_TYPE = "user_type";
        static final String UUID = "uuid";
        static final String WALL_TIME = "wall_time";

        private EventsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class IdentifiersDbColumns
        implements BaseColumns
    {

        static final String KEY = "key";
        static final String TABLE_NAME = "identifiers";
        static final String VALUE = "value";

        private IdentifiersDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class InfoDbColumns
        implements BaseColumns
    {

        static final String FB_ATTRIBUTION = "fb_attribution";
        static final String FIRST_ADVERTISING_ID = "first_advertising_id";
        static final String FIRST_ANDROID_ID = "first_android_id";
        static final String FIRST_RUN = "first_run";
        static final String FIRST_TELEPHONY_ID = "first_telephony_id";
        static final String LAST_SESSION_OPEN_TIME = "last_session_open_time";
        static final String PACKAGE_NAME = "package_name";
        static final String PLAY_ATTRIBUTION = "play_attribution";
        static final String PUSH_DISABLED = "push_disabled";
        static final String REGISTRATION_ID = "registration_id";
        static final String REGISTRATION_VERSION = "registration_version";
        static final String SENDER_ID = "sender_id";
        static final String TABLE_NAME = "info";

        private InfoDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class ProfileDbColumns
        implements BaseColumns
    {

        static final String ACTION = "action";
        static final String ATTRIBUTE = "attribute";
        static final String CUSTOMER_ID = "customer_id";
        static final String TABLE_NAME = "profile";
        static final String USER_ID = "id";

        private ProfileDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class SessionsDbColumns
        implements BaseColumns
    {

        static final String ANDROID_SDK = "android_sdk";
        static final String ANDROID_VERSION = "android_version";
        static final String API_KEY_REF = "api_key_ref";
        static final String APP_VERSION = "app_version";
        static final String DEVICE_ADVERTISING_ID = "device_advertising_id";
        static final String DEVICE_ANDROID_ID = "device_android_id";
        static final String DEVICE_ANDROID_ID_HASH = "device_android_id_hash";
        static final String DEVICE_COUNTRY = "device_country";
        static final String DEVICE_MANUFACTURER = "device_manufacturer";
        static final String DEVICE_MODEL = "device_model";
        static final String DEVICE_SERIAL_NUMBER_HASH = "device_serial_number_hash";
        static final String DEVICE_TELEPHONY_ID = "device_telephony_id";
        static final String DEVICE_TELEPHONY_ID_HASH = "device_telephony_id_hash";
        static final String DEVICE_WIFI_MAC_HASH = "device_wifi_mac_hash";
        static final String ELAPSED_TIME_SINCE_LAST_SESSION = "elapsed";
        static final String LATITUDE = "latitude";
        static final String LOCALE_COUNTRY = "locale_country";
        static final String LOCALE_LANGUAGE = "locale_language";
        static final String LOCALYTICS_INSTALLATION_ID = "iu";
        static final String LOCALYTICS_LIBRARY_VERSION = "localytics_library_version";
        static final String LONGITUDE = "longitude";
        static final String NETWORK_CARRIER = "network_carrier";
        static final String NETWORK_COUNTRY = "network_country";
        static final String NETWORK_TYPE = "network_type";
        static final String SESSION_START_WALL_TIME = "session_start_wall_time";
        static final String TABLE_NAME = "sessions";
        static final String UUID = "uuid";

        private SessionsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class UploadBlobEventsDbColumns
        implements BaseColumns
    {

        static final String EVENTS_KEY_REF = "events_key_ref";
        static final String TABLE_NAME = "upload_blob_events";
        static final String UPLOAD_BLOBS_KEY_REF = "upload_blobs_key_ref";

        private UploadBlobEventsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class UploadBlobsDbColumns
        implements BaseColumns
    {

        static final String TABLE_NAME = "upload_blobs";
        static final String UUID = "uuid";

        private UploadBlobsDbColumns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }


    private static final String CLOSE_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "close"
    });
    private static final String EVENTS_SORT_ORDER = String.format("CAST(%s as TEXT)", new Object[] {
        "_id"
    });
    private static final String EVENT_FORMAT = "%s:%s";
    private static final String FLOW_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "flow"
    });
    private static final String JOINER_ARG_UPLOAD_EVENTS_COLUMNS[] = {
        "_id"
    };
    private static final String OPEN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "open"
    });
    private static final String OPT_IN_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_in"
    });
    private static final String OPT_OUT_EVENT = String.format("%s:%s", new Object[] {
        "com.localytics.android", "opt_out"
    });
    private static final String PROJECTION_UPLOAD_BLOBS[] = {
        "events_key_ref"
    };
    private static final String PROJECTION_UPLOAD_EVENTS[] = {
        "_id", "event_name", "wall_time"
    };
    private static final String SELECTION_UPLOAD_NULL_BLOBS = String.format("%s IS NULL", new Object[] {
        "processed_in_blob"
    });
    private static final String UPLOAD_BLOBS_EVENTS_SORT_ORDER = String.format("CAST(%s AS TEXT)", new Object[] {
        "events_key_ref"
    });
    private LocalyticsDao mLocalyticsDao;

    MigrationDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
    {
        super(localyticsdao.getAppContext(), s, null, i);
        mLocalyticsDao = localyticsdao;
    }

    private static JSONObject convertAttributesToJson(SQLiteDatabase sqlitedatabase, Context context, long l)
    {
        SQLiteDatabase sqlitedatabase1 = null;
        Object obj = sqlitedatabase.query("attributes", null, String.format("%s = ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ? AND %s != ?", new Object[] {
            "events_key_ref", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", "attribute_key", 
            "attribute_key"
        }), new String[] {
            Long.toString(l), AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8, AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9, 
            AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10
        }, null, null, null);
        sqlitedatabase = ((SQLiteDatabase) (obj));
        sqlitedatabase1 = sqlitedatabase;
        int i = ((Cursor) (obj)).getCount();
        if (i == 0)
        {
            if (sqlitedatabase != null)
            {
                sqlitedatabase.close();
            }
            return null;
        }
        sqlitedatabase1 = sqlitedatabase;
        obj = new JSONObject();
        sqlitedatabase1 = sqlitedatabase;
        i = sqlitedatabase.getColumnIndexOrThrow("attribute_key");
        sqlitedatabase1 = sqlitedatabase;
        int j = sqlitedatabase.getColumnIndexOrThrow("attribute_value");
_L2:
        sqlitedatabase1 = sqlitedatabase;
        if (!sqlitedatabase.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        sqlitedatabase1 = sqlitedatabase;
        String s = sqlitedatabase.getString(i);
        sqlitedatabase1 = sqlitedatabase;
        String s1 = sqlitedatabase.getString(j);
        sqlitedatabase1 = sqlitedatabase;
        ((JSONObject) (obj)).put(s.substring(context.getPackageName().length() + 1, s.length()), s1);
        if (true) goto _L2; else goto _L1
_L1:
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return ((JSONObject) (obj));
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    static List convertDatabaseToJson(Context context, SQLiteDatabase sqlitedatabase, String s)
    {
        Cursor cursor;
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        cursor = null;
        Cursor cursor1 = sqlitedatabase.query("upload_blobs", null, null, null, null, null, null);
        cursor = cursor1;
        long l = getApiKeyCreationTime(sqlitedatabase, s);
        cursor = cursor1;
        int i = cursor1.getColumnIndexOrThrow("_id");
        cursor = cursor1;
        int j = cursor1.getColumnIndexOrThrow("uuid");
_L4:
        cursor = cursor1;
        boolean flag = cursor1.moveToNext();
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        Object obj = new JSONObject();
        cursor = cursor1;
        ((JSONObject) (obj)).put("dt", "h");
        cursor = cursor1;
        ((JSONObject) (obj)).put("pa", l);
        cursor = cursor1;
        ((JSONObject) (obj)).put("seq", cursor1.getLong(i));
        cursor = cursor1;
        ((JSONObject) (obj)).put("u", cursor1.getString(j));
        cursor = cursor1;
        Object obj1 = getAttributesFromSession(sqlitedatabase, s, getSessionIdForBlobId(sqlitedatabase, cursor1.getLong(i)));
        if (obj1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        ((JSONObject) (obj)).put("attrs", obj1);
        cursor = cursor1;
        obj1 = getIdentifiers(sqlitedatabase);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        cursor = cursor1;
        ((JSONObject) (obj)).put("ids", obj1);
        cursor = cursor1;
        linkedlist.add(obj);
        cursor = cursor1;
        Localytics.Log.w(linkedlist.toString());
        cursor = null;
        obj = cursor;
        obj1 = String.format("%s = ?", new Object[] {
            "upload_blobs_key_ref"
        });
        obj = cursor;
        String s1 = Long.toString(cursor1.getLong(i));
        obj = cursor;
        cursor = sqlitedatabase.query("upload_blob_events", new String[] {
            "_id", "events_key_ref"
        }, ((String) (obj1)), new String[] {
            s1
        }, null, null, "events_key_ref");
        obj1 = cursor;
        obj = obj1;
        int k = cursor.getColumnIndexOrThrow("events_key_ref");
_L2:
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (linkedlist.size() >= 100)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        linkedlist.add(convertEventToJson(sqlitedatabase, context, ((Cursor) (obj1)).getLong(k), cursor1.getLong(i), s));
        obj = obj1;
        sqlitedatabase.delete("upload_blob_events", String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Integer.toString(((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("_id")))
        });
        if (true) goto _L2; else goto _L1
_L1:
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        ((Cursor) (obj1)).close();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_516;
        }
        cursor = cursor1;
        ((Cursor) (obj)).close();
        cursor = cursor1;
        throw exception;
        JSONException jsonexception;
        jsonexception;
        cursor = cursor1;
        Localytics.Log.w("Caught exception", jsonexception);
        if (true) goto _L4; else goto _L3
_L3:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_570;
        context;
        if (cursor != null)
        {
            cursor.close();
        }
        throw context;
        Localytics.Log.v(String.format("JSON result is %s", new Object[] {
            linkedlist.toString()
        }));
        return linkedlist;
    }

    private static JSONObject convertEventToJson(SQLiteDatabase sqlitedatabase, Context context, long l, long l1, String s)
    {
        Object obj;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        obj = null;
        Object obj1 = sqlitedatabase.query("events", null, String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Long.toString(l)
        }, null, null, "_id");
        Cursor cursor;
        cursor = ((Cursor) (obj1));
        obj = cursor;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_3904;
        }
        obj = cursor;
        obj1 = cursor.getString(cursor.getColumnIndexOrThrow("event_name"));
        obj = cursor;
        long l2 = getSessionIdForEventId(sqlitedatabase, l);
        obj = cursor;
        String s1 = getSessionUuid(sqlitedatabase, l2);
        obj = cursor;
        long l3 = getSessionStartTime(sqlitedatabase, l2);
        obj = cursor;
        if (!OPEN_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_1010;
        }
        obj = cursor;
        jsonobject.put("dt", "s");
        obj = cursor;
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        obj = cursor;
        jsonobject.put("u", s1);
        obj = cursor;
        l1 = getElapsedTimeSinceLastSession(sqlitedatabase, l2);
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = cursor;
        jsonobject.put("sl", Math.round(l1 / 1000L));
        obj = cursor;
        jsonobject.put("nth", l2);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")))
        {
            break MISSING_BLOCK_LABEL_405;
        }
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_405;
        }
        obj = cursor;
        double d = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        obj = cursor;
        double d2 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d == 0.0D || d2 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        obj = cursor;
        jsonobject.put("lat", d);
        obj = cursor;
        jsonobject.put("lng", d2);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            break MISSING_BLOCK_LABEL_503;
        }
        obj = cursor;
        context = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
        obj = cursor;
        s = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
        obj = cursor;
        jsonobject.put("cid", context);
        obj = cursor;
        jsonobject.put("utp", s);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            break MISSING_BLOCK_LABEL_564;
        }
        obj = cursor;
        jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        context = null;
        s = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        sqlitedatabase = s;
        context = sqlitedatabase;
        int i = s.getColumnIndexOrThrow("attribute_key");
        context = sqlitedatabase;
        int k = sqlitedatabase.getColumnIndexOrThrow("attribute_value");
_L2:
        context = sqlitedatabase;
        if (!sqlitedatabase.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context = sqlitedatabase;
        s = sqlitedatabase.getString(i);
        context = sqlitedatabase;
        obj = sqlitedatabase.getString(k);
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(s))
        {
            break MISSING_BLOCK_LABEL_697;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(1), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(s))
        {
            break MISSING_BLOCK_LABEL_727;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(2), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(s))
        {
            break MISSING_BLOCK_LABEL_757;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(3), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(s))
        {
            break MISSING_BLOCK_LABEL_787;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(4), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(s))
        {
            break MISSING_BLOCK_LABEL_817;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(5), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(s))
        {
            break MISSING_BLOCK_LABEL_848;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(6), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(s))
        {
            break MISSING_BLOCK_LABEL_879;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(7), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(s))
        {
            break MISSING_BLOCK_LABEL_910;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(8), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(s))
        {
            break MISSING_BLOCK_LABEL_941;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(9), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(10), obj);
        if (true) goto _L2; else goto _L1
_L1:
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_3916;
        }
        obj = cursor;
        sqlitedatabase.close();
        break MISSING_BLOCK_LABEL_3916;
        sqlitedatabase;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1004;
        }
        obj = cursor;
        context.close();
        obj = cursor;
        throw sqlitedatabase;
        obj = cursor;
        if (!CLOSE_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_2319;
        }
        obj = cursor;
        jsonobject.put("dt", "c");
        obj = cursor;
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        obj = cursor;
        jsonobject.put("su", s1);
        obj = cursor;
        jsonobject.put("ss", Math.round((double)l3 / 1000D));
        obj = cursor;
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        s = null;
        context = s;
        obj = String.format("%s = ?", new Object[] {
            "_id"
        });
        context = s;
        obj1 = Long.toString(cursor.getLong(cursor.getColumnIndexOrThrow("session_key_ref")));
        context = s;
        obj = sqlitedatabase.query("sessions", new String[] {
            "session_start_wall_time"
        }, ((String) (obj)), new String[] {
            obj1
        }, null, null, null);
        s = ((String) (obj));
        context = s;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_1312;
        }
        context = s;
        jsonobject.put("ctl", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D) - Math.round((double)s.getLong(s.getColumnIndexOrThrow("session_start_wall_time")) / 1000D));
        break MISSING_BLOCK_LABEL_1326;
        context = s;
        throw new RuntimeException("Session didn't exist");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1366;
        }
        obj = cursor;
        s.close();
        break MISSING_BLOCK_LABEL_1366;
        sqlitedatabase;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1360;
        }
        obj = cursor;
        context.close();
        obj = cursor;
        throw sqlitedatabase;
        s = null;
        context = s;
        obj = String.format("%s = ? AND %s = ?", new Object[] {
            "session_key_ref", "type"
        });
        context = s;
        obj1 = Long.toString(l2);
        context = s;
        s1 = Integer.toString(1);
        context = s;
        s = sqlitedatabase.query("event_history", new String[] {
            "name"
        }, ((String) (obj)), new String[] {
            obj1, s1
        }, null, null, "_id");
        context = s;
        obj = new JSONArray();
_L4:
        context = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context = s;
        ((JSONArray) (obj)).put(s.getString(s.getColumnIndexOrThrow("name")));
        if (true) goto _L4; else goto _L3
_L3:
        context = s;
        if (((JSONArray) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_1536;
        }
        context = s;
        jsonobject.put("fl", obj);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_1576;
        }
        obj = cursor;
        s.close();
        break MISSING_BLOCK_LABEL_1576;
        sqlitedatabase;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_1570;
        }
        obj = cursor;
        context.close();
        obj = cursor;
        throw sqlitedatabase;
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")))
        {
            break MISSING_BLOCK_LABEL_1714;
        }
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_1714;
        }
        obj = cursor;
        d = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        obj = cursor;
        d2 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d == 0.0D || d2 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_1714;
        }
        obj = cursor;
        jsonobject.put("lat", d);
        obj = cursor;
        jsonobject.put("lng", d2);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            break MISSING_BLOCK_LABEL_1812;
        }
        obj = cursor;
        context = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
        obj = cursor;
        s = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
        obj = cursor;
        jsonobject.put("cid", context);
        obj = cursor;
        jsonobject.put("utp", s);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            break MISSING_BLOCK_LABEL_1873;
        }
        obj = cursor;
        jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        context = null;
        s = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        sqlitedatabase = s;
        context = sqlitedatabase;
        i = s.getColumnIndexOrThrow("attribute_key");
        context = sqlitedatabase;
        k = sqlitedatabase.getColumnIndexOrThrow("attribute_value");
_L6:
        context = sqlitedatabase;
        if (!sqlitedatabase.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context = sqlitedatabase;
        s = sqlitedatabase.getString(i);
        context = sqlitedatabase;
        obj = sqlitedatabase.getString(k);
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(s))
        {
            break MISSING_BLOCK_LABEL_2006;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(1), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(s))
        {
            break MISSING_BLOCK_LABEL_2036;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(2), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(s))
        {
            break MISSING_BLOCK_LABEL_2066;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(3), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(s))
        {
            break MISSING_BLOCK_LABEL_2096;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(4), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(s))
        {
            break MISSING_BLOCK_LABEL_2126;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(5), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(s))
        {
            break MISSING_BLOCK_LABEL_2157;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(6), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(s))
        {
            break MISSING_BLOCK_LABEL_2188;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(7), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(s))
        {
            break MISSING_BLOCK_LABEL_2219;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(8), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(s))
        {
            break MISSING_BLOCK_LABEL_2250;
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(9), obj);
        continue; /* Loop/switch isn't completed */
        context = sqlitedatabase;
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = sqlitedatabase;
        jsonobject.put(getCustomDimensionKey(10), obj);
        if (true) goto _L6; else goto _L5
_L5:
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_3916;
        }
        obj = cursor;
        sqlitedatabase.close();
        break MISSING_BLOCK_LABEL_3916;
        sqlitedatabase;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_2313;
        }
        obj = cursor;
        context.close();
        obj = cursor;
        throw sqlitedatabase;
        obj = cursor;
        if (OPT_IN_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_2349;
        }
        obj = cursor;
        if (!OPT_OUT_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_2474;
        }
        obj = cursor;
        jsonobject.put("dt", "o");
        obj = cursor;
        jsonobject.put("u", s);
        obj = cursor;
        if (!OPT_OUT_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_2409;
        }
        obj = cursor;
        sqlitedatabase = Boolean.TRUE.toString();
        break MISSING_BLOCK_LABEL_2420;
        obj = cursor;
        sqlitedatabase = Boolean.FALSE.toString();
        obj = cursor;
        jsonobject.put("out", sqlitedatabase);
        obj = cursor;
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        break MISSING_BLOCK_LABEL_3916;
        obj = cursor;
        if (!FLOW_EVENT.equals(obj1))
        {
            break MISSING_BLOCK_LABEL_2892;
        }
        obj = cursor;
        jsonobject.put("dt", "f");
        obj = cursor;
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        obj = cursor;
        jsonobject.put("ss", Math.round((double)l3 / 1000D));
        s = null;
        context = s;
        obj = String.format("%s = ? AND %s <= ?", new Object[] {
            "session_key_ref", "processed_in_blob"
        });
        context = s;
        obj1 = Long.toString(l2);
        context = s;
        s1 = Long.toString(l1);
        context = s;
        s = sqlitedatabase.query("event_history", new String[] {
            "type", "processed_in_blob", "name"
        }, ((String) (obj)), new String[] {
            obj1, s1
        }, null, null, "_id");
        context = s;
        obj = new JSONArray();
        context = s;
        obj1 = new JSONArray();
_L8:
        context = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context = s;
        s1 = s.getString(s.getColumnIndexOrThrow("name"));
        context = s;
        double d1;
        double d3;
        int j;
        int i1;
        if (s.getInt(s.getColumnIndexOrThrow("type")) == 0)
        {
            sqlitedatabase = "e";
        } else
        {
            sqlitedatabase = "s";
        }
        context = s;
        if (l1 != s.getLong(s.getColumnIndexOrThrow("processed_in_blob")))
        {
            break MISSING_BLOCK_LABEL_2799;
        }
        context = s;
        ((JSONArray) (obj)).put((new JSONObject()).put(sqlitedatabase, s1));
        continue; /* Loop/switch isn't completed */
        context = s;
        ((JSONArray) (obj1)).put((new JSONObject()).put(sqlitedatabase, s1));
        if (true) goto _L8; else goto _L7
_L7:
        context = s;
        jsonobject.put("nw", obj);
        context = s;
        jsonobject.put("od", obj1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_3916;
        }
        obj = cursor;
        s.close();
        break MISSING_BLOCK_LABEL_3916;
        sqlitedatabase;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_2886;
        }
        obj = cursor;
        context.close();
        obj = cursor;
        throw sqlitedatabase;
        obj = cursor;
        jsonobject.put("dt", "e");
        obj = cursor;
        jsonobject.put("ct", Math.round((double)cursor.getLong(cursor.getColumnIndex("wall_time")) / 1000D));
        obj = cursor;
        jsonobject.put("u", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        obj = cursor;
        jsonobject.put("su", s1);
        obj = cursor;
        jsonobject.put("n", ((String) (obj1)).substring(context.getPackageName().length() + 1, ((String) (obj1)).length()));
        obj = cursor;
        l1 = cursor.getLong(cursor.getColumnIndex("clv_increase"));
        if (l1 == 0L)
        {
            break MISSING_BLOCK_LABEL_3067;
        }
        obj = cursor;
        jsonobject.put("v", l1);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lat")))
        {
            break MISSING_BLOCK_LABEL_3205;
        }
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("event_lng")))
        {
            break MISSING_BLOCK_LABEL_3205;
        }
        obj = cursor;
        d1 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lat"));
        obj = cursor;
        d3 = cursor.getDouble(cursor.getColumnIndexOrThrow("event_lng"));
        if (d1 == 0.0D || d3 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_3205;
        }
        obj = cursor;
        jsonobject.put("lat", d1);
        obj = cursor;
        jsonobject.put("lng", d3);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("customer_id")))
        {
            break MISSING_BLOCK_LABEL_3305;
        }
        obj = cursor;
        s = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
        obj = cursor;
        obj1 = cursor.getString(cursor.getColumnIndexOrThrow("user_type"));
        obj = cursor;
        jsonobject.put("cid", s);
        obj = cursor;
        jsonobject.put("utp", obj1);
        obj = cursor;
        if (cursor.isNull(cursor.getColumnIndexOrThrow("ids")))
        {
            break MISSING_BLOCK_LABEL_3366;
        }
        obj = cursor;
        jsonobject.put("ids", new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("ids"))));
        s = null;
        obj = sqlitedatabase.query("attributes", null, String.format("%s = ?", new Object[] {
            "events_key_ref"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        obj1 = obj;
        s = ((String) (obj1));
        j = ((Cursor) (obj)).getColumnIndexOrThrow("attribute_key");
        s = ((String) (obj1));
        i1 = ((Cursor) (obj1)).getColumnIndexOrThrow("attribute_value");
_L10:
        s = ((String) (obj1));
        if (!((Cursor) (obj1)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String) (obj1));
        obj = ((Cursor) (obj1)).getString(j);
        s = ((String) (obj1));
        s1 = ((Cursor) (obj1)).getString(i1);
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_1.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3519;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(1), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_2.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3553;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(2), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_3.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3587;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(3), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_4.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3621;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(4), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_5.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3655;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(5), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_6.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3690;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(6), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_7.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3725;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(7), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_8.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3760;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(8), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_9.equals(obj))
        {
            break MISSING_BLOCK_LABEL_3795;
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(9), s1);
        continue; /* Loop/switch isn't completed */
        s = ((String) (obj1));
        if (!AttributesDbColumns.ATTRIBUTE_CUSTOM_DIMENSION_10.equals(obj))
        {
            continue; /* Loop/switch isn't completed */
        }
        s = ((String) (obj1));
        jsonobject.put(getCustomDimensionKey(10), s1);
        if (true) goto _L10; else goto _L9
_L9:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_3872;
        }
        obj = cursor;
        ((Cursor) (obj1)).close();
        break MISSING_BLOCK_LABEL_3872;
        sqlitedatabase;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_3866;
        }
        obj = cursor;
        s.close();
        obj = cursor;
        throw sqlitedatabase;
        obj = cursor;
        sqlitedatabase = convertAttributesToJson(sqlitedatabase, context, l);
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_3916;
        }
        obj = cursor;
        jsonobject.put("attrs", sqlitedatabase);
        break MISSING_BLOCK_LABEL_3916;
        obj = cursor;
        throw new RuntimeException();
        if (cursor != null)
        {
            cursor.close();
            return jsonobject;
        } else
        {
            return jsonobject;
        }
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
    }

    private static long getApiKeyCreationTime(SQLiteDatabase sqlitedatabase, String s)
    {
        SQLiteDatabase sqlitedatabase1 = null;
        s = sqlitedatabase.query("api_keys", null, String.format("%s = ?", new Object[] {
            "api_key"
        }), new String[] {
            s
        }, null, null, null);
        sqlitedatabase = s;
        sqlitedatabase1 = sqlitedatabase;
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        sqlitedatabase1 = sqlitedatabase;
        int i = Math.round((float)sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("created_time")) / 1000F);
        long l = i;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return l;
        sqlitedatabase1 = sqlitedatabase;
        throw new RuntimeException("API key entry couldn't be found");
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private static JSONObject getAttributesFromSession(SQLiteDatabase sqlitedatabase, String s, long l)
    {
        Cursor cursor = null;
        Object obj = sqlitedatabase.query("sessions", null, String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Long.toString(l)
        }, null, null, null);
        Cursor cursor1;
        cursor1 = ((Cursor) (obj));
        cursor = cursor1;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_983;
        }
        cursor = cursor1;
        JSONObject jsonobject = new JSONObject();
        cursor = cursor1;
        jsonobject.put("av", cursor1.getString(cursor1.getColumnIndexOrThrow("app_version")));
        cursor = cursor1;
        jsonobject.put("dac", cursor1.getString(cursor1.getColumnIndexOrThrow("network_type")));
        cursor = cursor1;
        obj = cursor1.getString(cursor1.getColumnIndexOrThrow("device_android_id_hash"));
        cursor = cursor1;
        if ("".equals(obj))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        cursor = cursor1;
        jsonobject.put("du", obj);
        cursor = cursor1;
        jsonobject.put("dc", cursor1.getString(cursor1.getColumnIndexOrThrow("device_country")));
        cursor = cursor1;
        jsonobject.put("dma", cursor1.getString(cursor1.getColumnIndexOrThrow("device_manufacturer")));
        cursor = cursor1;
        jsonobject.put("dmo", cursor1.getString(cursor1.getColumnIndexOrThrow("device_model")));
        cursor = cursor1;
        jsonobject.put("dov", cursor1.getString(cursor1.getColumnIndexOrThrow("android_version")));
        cursor = cursor1;
        jsonobject.put("dp", "Android");
        cursor = cursor1;
        if (!cursor1.isNull(cursor1.getColumnIndexOrThrow("device_serial_number_hash")))
        {
            break MISSING_BLOCK_LABEL_358;
        }
        cursor = cursor1;
        obj = JSONObject.NULL;
        break MISSING_BLOCK_LABEL_381;
        cursor = cursor1;
        obj = cursor1.getString(cursor1.getColumnIndexOrThrow("device_serial_number_hash"));
        cursor = cursor1;
        jsonobject.put("dms", obj);
        cursor = cursor1;
        jsonobject.put("dsdk", cursor1.getString(cursor1.getColumnIndexOrThrow("android_sdk")));
        cursor = cursor1;
        jsonobject.put("au", s);
        cursor = cursor1;
        jsonobject.put("lv", cursor1.getString(cursor1.getColumnIndexOrThrow("localytics_library_version")));
        cursor = cursor1;
        jsonobject.put("dt", "a");
        cursor = cursor1;
        if (!cursor1.isNull(cursor1.getColumnIndexOrThrow("device_android_id")))
        {
            break MISSING_BLOCK_LABEL_521;
        }
        cursor = cursor1;
        s = ((String) (JSONObject.NULL));
        break MISSING_BLOCK_LABEL_543;
        cursor = cursor1;
        s = cursor1.getString(cursor1.getColumnIndexOrThrow("device_android_id"));
        cursor = cursor1;
        jsonobject.put("caid", s);
        cursor = cursor1;
        if (!cursor1.isNull(cursor1.getColumnIndexOrThrow("device_advertising_id")))
        {
            break MISSING_BLOCK_LABEL_592;
        }
        cursor = cursor1;
        s = ((String) (JSONObject.NULL));
        break MISSING_BLOCK_LABEL_614;
        cursor = cursor1;
        s = cursor1.getString(cursor1.getColumnIndexOrThrow("device_advertising_id"));
        cursor = cursor1;
        jsonobject.put("gcadid", s);
        cursor = cursor1;
        s = cursor1.getString(cursor1.getColumnIndexOrThrow("iu"));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_668;
        }
        cursor = cursor1;
        jsonobject.put("iu", s);
        cursor = cursor1;
        jsonobject.put("dlc", cursor1.getString(cursor1.getColumnIndexOrThrow("locale_country")));
        cursor = cursor1;
        jsonobject.put("dll", cursor1.getString(cursor1.getColumnIndexOrThrow("locale_language")));
        cursor = cursor1;
        jsonobject.put("nca", cursor1.getString(cursor1.getColumnIndexOrThrow("network_carrier")));
        cursor = cursor1;
        jsonobject.put("nc", cursor1.getString(cursor1.getColumnIndexOrThrow("network_country")));
        cursor = cursor1;
        s = getStringFromAppInfo(sqlitedatabase, "fb_attribution");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_818;
        }
        cursor = cursor1;
        jsonobject.put("fbat", s);
        cursor = cursor1;
        s = getStringFromAppInfo(sqlitedatabase, "play_attribution");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_848;
        }
        cursor = cursor1;
        jsonobject.put("aurl", s);
        cursor = cursor1;
        s = getStringFromAppInfo(sqlitedatabase, "registration_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_878;
        }
        cursor = cursor1;
        jsonobject.put("push", s);
        cursor = cursor1;
        s = getStringFromAppInfo(sqlitedatabase, "first_android_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_908;
        }
        cursor = cursor1;
        jsonobject.put("aid", s);
        cursor = cursor1;
        s = getStringFromAppInfo(sqlitedatabase, "first_advertising_id");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_938;
        }
        cursor = cursor1;
        jsonobject.put("gadid", s);
        cursor = cursor1;
        sqlitedatabase = getStringFromAppInfo(sqlitedatabase, "package_name");
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_968;
        }
        cursor = cursor1;
        jsonobject.put("pkg", sqlitedatabase);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return jsonobject;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return null;
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
    }

    private static String getCustomDimensionKey(int i)
    {
        return String.format("%s%s", new Object[] {
            "c", String.valueOf(i - 1)
        });
    }

    private static long getElapsedTimeSinceLastSession(SQLiteDatabase sqlitedatabase, long l)
    {
        SQLiteDatabase sqlitedatabase1;
        Cursor cursor;
        cursor = null;
        sqlitedatabase1 = cursor;
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        sqlitedatabase1 = cursor;
        String s1 = Long.toString(l);
        sqlitedatabase1 = cursor;
        cursor = sqlitedatabase.query("sessions", new String[] {
            "elapsed"
        }, s, new String[] {
            s1
        }, null, null, null);
        sqlitedatabase = cursor;
        sqlitedatabase1 = sqlitedatabase;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        sqlitedatabase1 = sqlitedatabase;
        l = sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("elapsed"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return l;
        sqlitedatabase1 = sqlitedatabase;
        throw new RuntimeException();
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private static JSONObject getIdentifiers(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = null;
        Cursor cursor1 = sqlitedatabase.query("identifiers", null, null, null, null, null, null);
        sqlitedatabase = null;
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        obj = sqlitedatabase;
        if (sqlitedatabase != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        cursor = cursor1;
        obj = new JSONObject();
        cursor = cursor1;
        ((JSONObject) (obj)).put(cursor1.getString(cursor1.getColumnIndexOrThrow("key")), cursor1.getString(cursor1.getColumnIndexOrThrow("value")));
        sqlitedatabase = ((SQLiteDatabase) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return sqlitedatabase;
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
    }

    private static long getSessionIdForBlobId(SQLiteDatabase sqlitedatabase, long l)
    {
        Object obj;
        Cursor cursor;
        cursor = null;
        obj = cursor;
        Object obj1 = String.format("%s = ?", new Object[] {
            "upload_blobs_key_ref"
        });
        obj = cursor;
        String s = Long.toString(l);
        obj = cursor;
        obj1 = sqlitedatabase.query("upload_blob_events", new String[] {
            "events_key_ref"
        }, ((String) (obj1)), new String[] {
            s
        }, null, null, null);
        cursor = ((Cursor) (obj1));
        obj = cursor;
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        obj = cursor;
        l = cursor.getLong(cursor.getColumnIndexOrThrow("events_key_ref"));
        break MISSING_BLOCK_LABEL_124;
        if (cursor != null)
        {
            cursor.close();
        }
        return -1L;
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_152;
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        cursor = null;
        obj = cursor;
        obj1 = String.format("%s = ?", new Object[] {
            "_id"
        });
        obj = cursor;
        s = Long.toString(l);
        obj = cursor;
        cursor = sqlitedatabase.query("events", new String[] {
            "session_key_ref"
        }, ((String) (obj1)), new String[] {
            s
        }, null, null, null);
        sqlitedatabase = cursor;
        obj = sqlitedatabase;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_256;
        }
        obj = sqlitedatabase;
        l = sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("session_key_ref"));
        break MISSING_BLOCK_LABEL_269;
        obj = sqlitedatabase;
        throw new RuntimeException("No session associated with event");
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
            return l;
        } else
        {
            return l;
        }
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
    }

    private static long getSessionIdForEventId(SQLiteDatabase sqlitedatabase, long l)
    {
        SQLiteDatabase sqlitedatabase1;
        Cursor cursor;
        cursor = null;
        sqlitedatabase1 = cursor;
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        sqlitedatabase1 = cursor;
        String s1 = Long.toString(l);
        sqlitedatabase1 = cursor;
        cursor = sqlitedatabase.query("events", new String[] {
            "session_key_ref"
        }, s, new String[] {
            s1
        }, null, null, null);
        sqlitedatabase = cursor;
        sqlitedatabase1 = sqlitedatabase;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        sqlitedatabase1 = sqlitedatabase;
        l = sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("session_key_ref"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return l;
        sqlitedatabase1 = sqlitedatabase;
        throw new RuntimeException();
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private static long getSessionStartTime(SQLiteDatabase sqlitedatabase, long l)
    {
        SQLiteDatabase sqlitedatabase1;
        Cursor cursor;
        cursor = null;
        sqlitedatabase1 = cursor;
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        sqlitedatabase1 = cursor;
        String s1 = Long.toString(l);
        sqlitedatabase1 = cursor;
        cursor = sqlitedatabase.query("sessions", new String[] {
            "session_start_wall_time"
        }, s, new String[] {
            s1
        }, null, null, null);
        sqlitedatabase = cursor;
        sqlitedatabase1 = sqlitedatabase;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        sqlitedatabase1 = sqlitedatabase;
        l = sqlitedatabase.getLong(sqlitedatabase.getColumnIndexOrThrow("session_start_wall_time"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return l;
        sqlitedatabase1 = sqlitedatabase;
        throw new RuntimeException();
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private static String getSessionUuid(SQLiteDatabase sqlitedatabase, long l)
    {
        SQLiteDatabase sqlitedatabase1;
        Object obj;
        obj = null;
        sqlitedatabase1 = ((SQLiteDatabase) (obj));
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        sqlitedatabase1 = ((SQLiteDatabase) (obj));
        String s1 = Long.toString(l);
        sqlitedatabase1 = ((SQLiteDatabase) (obj));
        obj = sqlitedatabase.query("sessions", new String[] {
            "uuid"
        }, s, new String[] {
            s1
        }, null, null, null);
        sqlitedatabase = ((SQLiteDatabase) (obj));
        sqlitedatabase1 = sqlitedatabase;
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        sqlitedatabase1 = sqlitedatabase;
        obj = sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow("uuid"));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return ((String) (obj));
        sqlitedatabase1 = sqlitedatabase;
        throw new RuntimeException();
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
    }

    private static String getStringFromAppInfo(SQLiteDatabase sqlitedatabase, String s)
    {
        SQLiteDatabase sqlitedatabase1 = null;
        Cursor cursor = sqlitedatabase.query("info", null, null, null, null, null, null);
        sqlitedatabase = cursor;
        sqlitedatabase1 = sqlitedatabase;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_57;
        }
        sqlitedatabase1 = sqlitedatabase;
        s = sqlitedatabase.getString(sqlitedatabase.getColumnIndexOrThrow(s));
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        return s;
        if (sqlitedatabase != null)
        {
            sqlitedatabase.close();
        }
        break MISSING_BLOCK_LABEL_83;
        sqlitedatabase;
        if (sqlitedatabase1 != null)
        {
            sqlitedatabase1.close();
        }
        throw sqlitedatabase;
        return null;
    }

    static void preUploadBuildBlobs(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        Cursor cursor1;
        Cursor cursor3;
        HashSet hashset;
        hashset = new HashSet();
        cursor = null;
        cursor3 = null;
        cursor1 = cursor3;
        Cursor cursor2 = sqlitedatabase.query("events", PROJECTION_UPLOAD_EVENTS, null, null, null, null, EVENTS_SORT_ORDER);
        cursor = cursor2;
        cursor1 = cursor3;
        cursor3 = sqlitedatabase.query("upload_blob_events", PROJECTION_UPLOAD_BLOBS, null, null, null, null, UPLOAD_BLOBS_EVENTS_SORT_ORDER);
        cursor = cursor2;
        cursor1 = cursor3;
        int i = cursor2.getColumnIndexOrThrow("_id");
        cursor = cursor2;
        cursor1 = cursor3;
        Iterator iterator1 = (new CursorJoiner(cursor2, JOINER_ARG_UPLOAD_EVENTS_COLUMNS, cursor3, PROJECTION_UPLOAD_BLOBS)).iterator();
_L6:
        cursor = cursor2;
        cursor1 = cursor3;
        if (!iterator1.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor2;
        cursor1 = cursor3;
        android.database.CursorJoiner.Result result = (android.database.CursorJoiner.Result)iterator1.next();
        cursor = cursor2;
        cursor1 = cursor3;
        static class _cls1
        {

            static final int $SwitchMap$android$database$CursorJoiner$Result[];

            static 
            {
                $SwitchMap$android$database$CursorJoiner$Result = new int[android.database.CursorJoiner.Result.values().length];
                try
                {
                    $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.LEFT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.BOTH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$database$CursorJoiner$Result[android.database.CursorJoiner.Result.RIGHT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
            }
        }

        _cls1..SwitchMap.android.database.CursorJoiner.Result[result.ordinal()];
        JVM INSTR tableswitch 1 2: default 434
    //                   1 168
    //                   2 250;
           goto _L1 _L2 _L1
_L1:
        continue; /* Loop/switch isn't completed */
_L2:
        cursor = cursor2;
        cursor1 = cursor3;
        if (!CLOSE_EVENT.equals(cursor2.getString(cursor2.getColumnIndexOrThrow("event_name")))) goto _L4; else goto _L3
_L3:
        cursor = cursor2;
        cursor1 = cursor3;
        if (System.currentTimeMillis() - cursor2.getLong(cursor2.getColumnIndexOrThrow("wall_time")) < Constants.SESSION_EXPIRATION)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        cursor = cursor2;
        cursor1 = cursor3;
        hashset.add(Long.valueOf(cursor2.getLong(i)));
        if (true) goto _L6; else goto _L5
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw sqlitedatabase;
_L5:
        if (cursor2 != null)
        {
            cursor2.close();
        }
        if (cursor3 != null)
        {
            cursor3.close();
        }
        if (hashset.size() > 0)
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("uuid", UUID.randomUUID().toString());
            Long long1 = Long.valueOf(sqlitedatabase.insert("upload_blobs", null, contentvalues));
            contentvalues.clear();
            for (Iterator iterator = hashset.iterator(); iterator.hasNext(); contentvalues.clear())
            {
                Long long2 = (Long)iterator.next();
                contentvalues.put("upload_blobs_key_ref", long1);
                contentvalues.put("events_key_ref", long2);
                sqlitedatabase.insert("upload_blob_events", null, contentvalues);
            }

            contentvalues.put("processed_in_blob", long1);
            sqlitedatabase.update("event_history", contentvalues, SELECTION_UPLOAD_NULL_BLOBS, null);
            contentvalues.clear();
        }
        return;
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            throw new IllegalArgumentException("db cannot be null");
        } else
        {
            return;
        }
    }

    public final void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        Localytics.Log.v(String.format("SQLite library version is: %s", new Object[] {
            DatabaseUtils.stringForQuery(sqlitedatabase, "select sqlite_version()", null)
        }));
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Object obj;
        if (i < 3)
        {
            sqlitedatabase.delete("upload_blob_events", null, null);
            sqlitedatabase.delete("event_history", null, null);
            sqlitedatabase.delete("upload_blobs", null, null);
            sqlitedatabase.delete("attributes", null, null);
            sqlitedatabase.delete("events", null, null);
            sqlitedatabase.delete("sessions", null, null);
        }
        if (i < 4)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "iu"
            }));
        }
        if (i < 5)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_wifi_mac_hash"
            }));
        }
        if (i >= 6)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        obj = null;
        Object obj1 = sqlitedatabase.query("attributes", new String[] {
            "_id", "attribute_key"
        }, null, null, null, null, null);
        Cursor cursor;
        cursor = ((Cursor) (obj1));
        obj = cursor;
        j = ((Cursor) (obj1)).getColumnIndexOrThrow("_id");
        obj = cursor;
        int k = cursor.getColumnIndexOrThrow("attribute_key");
        obj = cursor;
        obj1 = new ContentValues();
        obj = cursor;
        String s = String.format("%s = ?", new Object[] {
            "_id"
        });
        obj = cursor;
        String as[] = new String[1];
        obj = cursor;
        cursor.moveToPosition(-1);
_L2:
        obj = cursor;
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor;
        ((ContentValues) (obj1)).put("attribute_key", String.format("%s:%s", new Object[] {
            mLocalyticsDao.getAppContext().getPackageName(), cursor.getString(k)
        }));
        obj = cursor;
        as[0] = Long.toString(cursor.getLong(j));
        obj = cursor;
        sqlitedatabase.update("attributes", ((ContentValues) (obj1)), s, as);
        obj = cursor;
        ((ContentValues) (obj1)).clear();
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        break MISSING_BLOCK_LABEL_390;
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
        if (i < 7)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT, %s INTEGER);", new Object[] {
                "info", "fb_attribution", "first_run"
            }));
            obj = new ContentValues();
            ((ContentValues) (obj)).putNull("fb_attribution");
            ((ContentValues) (obj)).put("first_run", Boolean.FALSE);
            sqlitedatabase.insertOrThrow("info", null, ((ContentValues) (obj)));
        }
        if (i < 8)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);", new Object[] {
                "identifiers", "_id", "key", "value"
            }));
        }
        if (i < 9)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL DEFAULT 0;", new Object[] {
                "events", "clv_increase"
            }));
        }
        if (i < 10)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "play_attribution"
            }));
        }
        if (i < 11)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "registration_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "registration_version"
            }));
        }
        if (i < 12)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_android_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_telephony_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "package_name"
            }));
            obj = new ContentValues();
            ((ContentValues) (obj)).put("first_android_id", DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext()));
            ((ContentValues) (obj)).put("first_telephony_id", DatapointHelper.getTelephonyDeviceIdOrNull(mLocalyticsDao.getAppContext()));
            ((ContentValues) (obj)).put("package_name", mLocalyticsDao.getAppContext().getPackageName());
            sqlitedatabase.update("info", ((ContentValues) (obj)), null, null);
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_android_id"
            }));
        }
        if (i < 13)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s REAL;", new Object[] {
                "events", "event_lat"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s REAL;", new Object[] {
                "events", "event_lng"
            }));
        }
        if (i < 14)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
                "amp_rules", "_id", "campaign_id", "expiration", "display_seconds", "display_session", "version", "phone_location", "phone_size_width", "phone_size_height", 
                "tablet_location", "tablet_size_width", "tablet_size_height", "time_to_display", "internet_required", "ab_test", "rule_name", "location", "devices"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_ruleevent", "_id", "event_name", "rule_id_ref", "amp_rules", "_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL);", new Object[] {
                "amp_displayed", "_id", "displayed", "campaign_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_conditions", "_id", "attribute_name", "operator", "rule_id_ref", "amp_rules", "_id"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
                "amp_condition_values", "_id", "value", "condition_id_ref", "amp_conditions", "_id"
            }));
        }
        if (i < 15)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL);", new Object[] {
                "custom_dimensions", "_id", "custom_dimension_key", "custom_dimension_value"
            }));
        }
        if (i < 16)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_advertising_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "sessions", "device_advertising_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER;", new Object[] {
                "info", "push_disabled"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "sender_id"
            }));
        }
        if (i < 17)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER)", new Object[] {
                "profile", "_id", "attribute", "action"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "customer_id"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "user_type"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "events", "ids"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER", new Object[] {
                "info", "last_session_open_time"
            }));
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER NOT NULL CHECK (%s >= 0) DEFAULT 0", new Object[] {
                "sessions", "elapsed", "elapsed"
            }));
        }
        if (i >= 18) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", new Object[] {
            "profile", "customer_id"
        }));
        obj = null;
        obj1 = new ContentValues();
        cursor = sqlitedatabase.query("profile", null, null, null, null, null, null);
_L7:
        obj = cursor;
        if (!cursor.moveToNext()) goto _L6; else goto _L5
_L5:
        obj = cursor;
        s = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        obj = cursor;
        JSONObject jsonobject = new JSONObject(cursor.getString(cursor.getColumnIndexOrThrow("attribute")));
        obj = cursor;
        ((ContentValues) (obj1)).put("attribute", jsonobject.getString("attributes"));
        obj = cursor;
        ((ContentValues) (obj1)).put("customer_id", jsonobject.getString("id"));
        obj = cursor;
        sqlitedatabase.update("profile", ((ContentValues) (obj1)), String.format("%s = %s", new Object[] {
            "_id", s
        }), null);
        obj = cursor;
        ((ContentValues) (obj1)).clear();
          goto _L7
_L8:
        obj = cursor;
        sqlitedatabase.delete("profile", String.format("%s = %s", new Object[] {
            "_id", s
        }), null);
          goto _L7
_L6:
        if (cursor != null)
        {
            cursor.close();
            return;
        }
          goto _L4
        sqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw sqlitedatabase;
_L4:
        return;
        Exception exception;
        exception;
          goto _L8
    }

}
