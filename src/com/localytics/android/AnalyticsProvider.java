// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseProvider, LocalyticsDao, DatapointHelper, Constants, 
//            MigrationDatabaseHelper

class AnalyticsProvider extends BaseProvider
{
    static class AnalyticsDatabaseHelper extends BaseProvider.LocalyticsDatabaseHelper
    {

        protected void addFirstOpenEventToInfoTable(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
                "info", "first_open_event_blob"
            }));
        }

        protected void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
        {
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL);", new Object[] {
                "events", "_id", "blob", "upload_format"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);", new Object[] {
                "identifiers", "key", "value"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT NOT NULL);", new Object[] {
                "custom_dimensions", "custom_dimension_key", "custom_dimension_value"
            }));
            sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT UNIQUE NOT NULL, %s TEXT UNIQUE NOT NULL, %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s INTEGER NOT NULL CHECK(%s IN (%s, %s)), %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER CHECK (%s >= 0), %s INTEGER CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s INTEGER NOT NULL CHECK (%s >= 0), %s TEXT, %s INTEGER);", new Object[] {
                "info", "_id", "api_key", "uuid", "created_time", "created_time", "opt_out", "opt_out", "0", "1", 
                "push_disabled", "push_disabled", "0", "1", "sender_id", "registration_id", "registration_version", "customer_id", "user_type", "fb_attribution", 
                "play_attribution", "first_android_id", "first_advertising_id", "package_name", "app_version", "current_session_uuid", "last_session_open_time", "last_session_open_time", "last_session_close_time", "last_session_close_time", 
                "next_session_number", "next_session_number", "next_header_number", "next_header_number", "queued_close_session_blob", "queued_close_session_blob_upload_format"
            }));
            if (oldDB == null) goto _L2; else goto _L1
_L1:
            SQLiteDatabase sqlitedatabase1 = oldDB;
            sqlitedatabase1;
            JVM INSTR monitorenter ;
            Object obj1 = null;
            ContentValues contentvalues = new ContentValues();
            String s;
            String s1;
            String s2;
            String s3;
            List list;
            String s4;
            String s5;
            String s6;
            JSONObject jsonobject;
            long l;
            long l1;
            long l2;
            long l6;
            boolean flag;
            s4 = null;
            s5 = null;
            l6 = 0L;
            flag = false;
            l2 = 1L;
            l = 1L;
            s1 = null;
            s = null;
            l1 = 0L;
            s2 = null;
            list = null;
            s6 = null;
            s3 = null;
            jsonobject = null;
            Object obj2 = oldDB.query("api_keys", null, null, null, null, null, null);
            Object obj;
            obj = obj2;
            obj1 = obj;
            if (!((Cursor) (obj2)).moveToFirst())
            {
                break MISSING_BLOCK_LABEL_511;
            }
            obj1 = obj;
            s4 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("api_key"));
            obj1 = obj;
            s5 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("uuid"));
            obj1 = obj;
            l6 = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("created_time"));
            obj1 = obj;
            int i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("opt_out"));
            obj1 = obj;
            int j = Integer.valueOf("1").intValue();
            if (i == j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = obj;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_541;
            }
            ((Cursor) (obj)).close();
            obj1 = null;
            break MISSING_BLOCK_LABEL_541;
            sqlitedatabase;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_539;
            }
            ((Cursor) (obj1)).close();
            throw sqlitedatabase;
            obj = obj1;
            obj1 = oldDB.query("identifiers", null, null, null, null, null, null);
_L4:
            obj = obj1;
            if (!((Cursor) (obj1)).moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            Object obj3 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("key"));
            obj = obj1;
            obj2 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("value"));
            obj = obj1;
            if (((String) (obj3)).equals("customer_id"))
            {
                s6 = ((String) (obj2));
            }
            obj = obj1;
            contentvalues.put("key", ((String) (obj3)));
            obj = obj1;
            contentvalues.put("value", ((String) (obj2)));
            obj = obj1;
            sqlitedatabase.insert("identifiers", null, contentvalues);
            obj = obj1;
            contentvalues.clear();
            if (true) goto _L4; else goto _L3
_L3:
            obj = obj1;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_695;
            }
            ((Cursor) (obj1)).close();
            obj = null;
            break MISSING_BLOCK_LABEL_695;
            sqlitedatabase;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_693;
            }
            ((Cursor) (obj)).close();
            throw sqlitedatabase;
            obj1 = obj;
            obj = oldDB.query("custom_dimensions", null, null, null, null, null, null);
_L6:
            obj1 = obj;
            if (!((Cursor) (obj)).moveToNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = obj;
            contentvalues.put("custom_dimension_key", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("custom_dimension_key")).replace("com.localytics.android:", ""));
            obj1 = obj;
            contentvalues.put("custom_dimension_value", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("custom_dimension_value")));
            obj1 = obj;
            sqlitedatabase.insert("custom_dimensions", null, contentvalues);
            obj1 = obj;
            contentvalues.clear();
            if (true) goto _L6; else goto _L5
_L5:
            obj2 = obj;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_830;
            }
            ((Cursor) (obj)).close();
            obj2 = null;
            break MISSING_BLOCK_LABEL_830;
            sqlitedatabase;
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_828;
            }
            ((Cursor) (obj1)).close();
            throw sqlitedatabase;
            long l3;
            long l4;
            long l5;
            l3 = l2;
            l4 = l;
            l5 = l1;
            if (s4 == null) goto _L8; else goto _L7
_L7:
            MigrationDatabaseHelper.preUploadBuildBlobs(oldDB);
            obj3 = null;
            obj1 = jsonobject;
            obj = list;
_L22:
            list = MigrationDatabaseHelper.convertDatabaseToJson(mLocalyticsDao.getAppContext(), oldDB, s4);
            l3 = l2;
            l4 = l;
            s1 = s;
            l5 = l1;
            s2 = ((String) (obj));
            s3 = ((String) (obj1));
            if (list.isEmpty()) goto _L8; else goto _L9
_L9:
            StringBuilder stringbuilder;
            Iterator iterator;
            stringbuilder = new StringBuilder();
            iterator = list.iterator();
_L21:
            l4 = l2;
            if (!iterator.hasNext()) goto _L11; else goto _L10
_L10:
            jsonobject = (JSONObject)iterator.next();
            l5 = l4;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            if (!jsonobject.getString("dt").equals("h")) goto _L13; else goto _L12
_L12:
            l5 = l4;
            if (obj3 != null) goto _L15; else goto _L14
_L14:
            l5 = l4;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            l4 = jsonobject.getLong("seq");
            l5 = l4;
              goto _L15
_L13:
            long l7;
            l7 = 1L + l4;
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            ((JSONObject) (obj3)).put("seq", l4);
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            ((JSONObject) (obj3)).put("u", UUID.randomUUID().toString());
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            stringbuilder.append(((JSONObject) (obj3)).toString()).append("\n").append(jsonobject.toString());
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            if (!jsonobject.getString("dt").equals("c")) goto _L17; else goto _L16
_L16:
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            s3 = stringbuilder.toString();
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            l4 = ((Long)jsonobject.get("ct")).longValue() * 1000L;
            if (s == null) goto _L19; else goto _L18
_L18:
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            ContentValues contentvalues1 = new ContentValues();
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            contentvalues1.put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            if (l4 <= l1)
            {
                break MISSING_BLOCK_LABEL_1427;
            }
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            contentvalues1.put("blob", s);
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            sqlitedatabase.insert("events", null, contentvalues1);
            s = s3;
            l1 = l4;
            break MISSING_BLOCK_LABEL_1493;
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            contentvalues1.put("blob", s3);
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            sqlitedatabase.insert("events", null, contentvalues1);
_L23:
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            s3 = ((String) (obj1));
            if (!jsonobject.has("fl"))
            {
                break MISSING_BLOCK_LABEL_2581;
            }
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            try
            {
                s3 = jsonobject.getJSONArray("fl").join(",");
                break MISSING_BLOCK_LABEL_2581;
            }
            catch (Exception exception)
            {
                l = l2;
                s = s2;
                l1 = l3;
                exception = s1;
                obj1 = list;
            }
            finally
            {
                throw sqlitedatabase;
            }
              goto _L20
_L17:
            l4 = l;
            s3 = ((String) (obj));
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            if (!jsonobject.getString("dt").equals("s"))
            {
                break MISSING_BLOCK_LABEL_1678;
            }
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            l4 = jsonobject.getLong("nth");
            l5 = l7;
            l2 = l4;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            s3 = jsonobject.getString("u");
            l5 = l7;
            l2 = l4;
            s2 = s;
            l3 = l1;
            s1 = s3;
            list = ((List) (obj1));
            contentvalues.put("blob", stringbuilder.toString());
            l5 = l7;
            l2 = l4;
            s2 = s;
            l3 = l1;
            s1 = s3;
            list = ((List) (obj1));
            contentvalues.put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            l5 = l7;
            l2 = l4;
            s2 = s;
            l3 = l1;
            s1 = s3;
            list = ((List) (obj1));
            sqlitedatabase.insert("events", null, contentvalues);
            obj = s3;
            l = l4;
_L24:
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            contentvalues.clear();
            l5 = l7;
            l2 = l;
            s2 = s;
            l3 = l1;
            s1 = ((String) (obj));
            list = ((List) (obj1));
            stringbuilder.delete(0, stringbuilder.length());
            l2 = l7;
              goto _L21
_L20:
            l2 = l5;
              goto _L21
_L11:
            l2 = l4;
              goto _L22
_L8:
            obj1 = oldDB.query("info", null, null, null, null, null, null);
            obj = obj1;
            obj2 = obj;
            if (!((Cursor) (obj1)).moveToFirst())
            {
                break MISSING_BLOCK_LABEL_2499;
            }
            obj2 = obj;
            contentvalues.put("api_key", s4);
            obj2 = obj;
            contentvalues.put("uuid", s5);
            obj2 = obj;
            contentvalues.put("created_time", Long.valueOf(l6));
            obj2 = obj;
            contentvalues.put("opt_out", Boolean.valueOf(flag));
            obj2 = obj;
            contentvalues.put("push_disabled", Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("push_disabled"))));
            obj2 = obj;
            contentvalues.put("sender_id", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("sender_id")));
            obj2 = obj;
            contentvalues.put("registration_id", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("registration_id")));
            obj2 = obj;
            contentvalues.put("registration_version", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("registration_version")));
            if (s6 == null)
            {
                break MISSING_BLOCK_LABEL_2089;
            }
            obj2 = obj;
            contentvalues.put("customer_id", s6);
            obj2 = obj;
            contentvalues.put("user_type", "known");
            break MISSING_BLOCK_LABEL_2114;
            obj2 = obj;
            contentvalues.put("customer_id", s5);
            obj2 = obj;
            contentvalues.put("user_type", "anonymous");
            obj2 = obj;
            contentvalues.put("fb_attribution", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("fb_attribution")));
            obj2 = obj;
            contentvalues.put("play_attribution", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("play_attribution")));
            obj2 = obj;
            contentvalues.put("first_android_id", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("first_android_id")));
            obj2 = obj;
            contentvalues.put("first_advertising_id", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("first_advertising_id")));
            obj2 = obj;
            contentvalues.put("app_version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
            obj2 = obj;
            contentvalues.put("package_name", ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("package_name")));
            obj2 = obj;
            contentvalues.put("current_session_uuid", s2);
            obj2 = obj;
            l = ((Cursor) (obj)).getLong(((Cursor) (obj)).getColumnIndexOrThrow("last_session_open_time"));
            obj2 = obj;
            contentvalues.put("last_session_open_time", Long.valueOf(l));
            obj2 = obj;
            contentvalues.put("last_session_close_time", Long.valueOf(l5));
            obj2 = obj;
            contentvalues.put("next_header_number", Long.valueOf(1L + l3));
            obj2 = obj;
            contentvalues.put("next_session_number", Long.valueOf(1L + l4));
            if (l5 <= l)
            {
                break MISSING_BLOCK_LABEL_2421;
            }
            obj2 = obj;
            contentvalues.put("queued_close_session_blob", s1);
            obj2 = obj;
            contentvalues.put("queued_close_session_blob_upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            if (s3 == null)
            {
                break MISSING_BLOCK_LABEL_2478;
            }
            obj2 = obj;
            mLocalyticsDao.setScreenFlow(Arrays.asList(s3.split(",")));
            break MISSING_BLOCK_LABEL_2478;
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_2478;
            }
            obj2 = obj;
            obj1 = new ContentValues();
            obj2 = obj;
            ((ContentValues) (obj1)).put("blob", s1);
            obj2 = obj;
            ((ContentValues) (obj1)).put("upload_format", Integer.valueOf(EventsV3Columns.UploadFormat.V2.getValue()));
            obj2 = obj;
            sqlitedatabase.insert("events", null, ((ContentValues) (obj1)));
            obj2 = obj;
            sqlitedatabase.insert("info", null, contentvalues);
            obj2 = obj;
            contentvalues.clear();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_2527;
            }
            ((Cursor) (obj)).close();
            break MISSING_BLOCK_LABEL_2527;
            sqlitedatabase;
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_2525;
            }
            ((Cursor) (obj2)).close();
            throw sqlitedatabase;
            cleanUpOldDB();
            sqlitedatabase1;
            JVM INSTR monitorexit ;
            return;
_L2:
            return;
_L15:
            obj3 = jsonobject;
              goto _L20
_L19:
            s = s3;
            l1 = l4;
              goto _L23
            obj1 = s3;
              goto _L24
        }

        public void onCreate(SQLiteDatabase sqlitedatabase)
        {
            if (sqlitedatabase == null)
            {
                throw new IllegalArgumentException("db cannot be null");
            } else
            {
                sqlitedatabase.execSQL("PRAGMA auto_vacuum = INCREMENTAL;");
                onUpgrade(sqlitedatabase, 0, 2);
                return;
            }
        }

        public void onOpen(SQLiteDatabase sqlitedatabase)
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

        public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
        {
            if (i <= 0)
            {
                migrateV2ToV3(sqlitedatabase);
            }
            if (i < 2)
            {
                addFirstOpenEventToInfoTable(sqlitedatabase);
            }
        }

        AnalyticsDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
        {
            super(s, i, localyticsdao);
        }
    }

    static final class CustomDimensionsV3Columns
        implements BaseColumns
    {

        static final String CUSTOM_DIMENSION_KEY = "custom_dimension_key";
        static final String CUSTOM_DIMENSION_VALUE = "custom_dimension_value";
        static final String TABLE_NAME = "custom_dimensions";

        private CustomDimensionsV3Columns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventsV3Columns
        implements BaseColumns
    {

        static final String BLOB = "blob";
        static final String TABLE_NAME = "events";
        static final String UPLOAD_FORMAT = "upload_format";

        private EventsV3Columns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class EventsV3Columns.UploadFormat extends Enum
    {

        private static final EventsV3Columns.UploadFormat $VALUES[];
        public static final EventsV3Columns.UploadFormat V2;
        public static final EventsV3Columns.UploadFormat V3;
        private final int value;

        public static EventsV3Columns.UploadFormat valueOf(String s)
        {
            return (EventsV3Columns.UploadFormat)Enum.valueOf(com/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat, s);
        }

        public static EventsV3Columns.UploadFormat[] values()
        {
            return (EventsV3Columns.UploadFormat[])$VALUES.clone();
        }

        public final int getValue()
        {
            return value;
        }

        static 
        {
            V2 = new EventsV3Columns.UploadFormat("V2", 0, 2);
            V3 = new EventsV3Columns.UploadFormat("V3", 1, 3);
            $VALUES = (new EventsV3Columns.UploadFormat[] {
                V2, V3
            });
        }

        private EventsV3Columns.UploadFormat(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    static final class IdentifiersV3Columns
        implements BaseColumns
    {

        static final String KEY = "key";
        static final String TABLE_NAME = "identifiers";
        static final String VALUE = "value";

        IdentifiersV3Columns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }

    static final class InfoV3Columns
        implements BaseColumns
    {

        static final String API_KEY = "api_key";
        static final String APP_VERSION = "app_version";
        static final String CREATED_TIME = "created_time";
        static final String CURRENT_SESSION_UUID = "current_session_uuid";
        static final String CUSTOMER_ID = "customer_id";
        static final String FB_ATTRIBUTION = "fb_attribution";
        static final String FIRST_ADVERTISING_ID = "first_advertising_id";
        static final String FIRST_ANDROID_ID = "first_android_id";
        static final String FIRST_OPEN_EVENT_BLOB = "first_open_event_blob";
        static final String LAST_SESSION_CLOSE_TIME = "last_session_close_time";
        static final String LAST_SESSION_OPEN_TIME = "last_session_open_time";
        static final String NEXT_HEADER_NUMBER = "next_header_number";
        static final String NEXT_SESSION_NUMBER = "next_session_number";
        static final String OPT_OUT = "opt_out";
        static final String PACKAGE_NAME = "package_name";
        static final String PLAY_ATTRIBUTION = "play_attribution";
        static final String PUSH_DISABLED = "push_disabled";
        static final String QUEUED_CLOSE_SESSION_BLOB = "queued_close_session_blob";
        static final String QUEUED_CLOSE_SESSION_BLOB_UPLOAD_FORMAT = "queued_close_session_blob_upload_format";
        static final String REGISTRATION_ID = "registration_id";
        static final String REGISTRATION_VERSION = "registration_version";
        static final String SENDER_ID = "sender_id";
        static final String TABLE_NAME = "info";
        static final String USER_TYPE = "user_type";
        static final String UUID = "uuid";

        private InfoV3Columns()
        {
            throw new UnsupportedOperationException("This class is non-instantiable");
        }
    }


    static final int DATABASE_VERSION = 2;

    AnalyticsProvider(LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
    }

    AnalyticsProvider(String s, LocalyticsDao localyticsdao)
    {
        super(localyticsdao);
        mDb = (new AnalyticsDatabaseHelper(String.format("com.localytics.android.%s.%s.sqlite", new Object[] {
            DatapointHelper.getSha256_buggy(localyticsdao.getApiKey()), s
        }), 2, localyticsdao)).getWritableDatabase();
    }

    boolean canAddToDB()
    {
        return (new File(mDb.getPath())).length() < maxSiloDbSize();
    }

    long maxSiloDbSize()
    {
        return Constants.dbMaxSizeForAnalytics;
    }
}
