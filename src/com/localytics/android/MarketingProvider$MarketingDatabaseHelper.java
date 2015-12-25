// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.localytics.android:
//            MarketingProvider, LocalyticsDao, MarketingDownloader, BaseProvider

static class t> extends t>
{

    protected void addControlGroup(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 0;", new Object[] {
            "marketing_rules", "control_group"
        }));
    }

    protected void addNonUniqueRuleName(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT;", new Object[] {
            "marketing_rules", "rule_name_non_unique"
        }));
        sqlitedatabase.execSQL(String.format("UPDATE %s SET %s = %s;", new Object[] {
            "marketing_rules", "rule_name_non_unique", "rule_name"
        }));
    }

    protected void addSchemaVersion(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT 1;", new Object[] {
            "marketing_rules", "schema_version"
        }));
    }

    protected void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER, %s INTEGER NOT NULL, %s TEXT, %s TEXT UNIQUE NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
            "marketing_rules", "_id", "campaign_id", "expiration", "display_seconds", "display_session", "version", "phone_location", "phone_size_width", "phone_size_height", 
            "tablet_location", "tablet_size_width", "tablet_size_height", "time_to_display", "internet_required", "ab_test", "rule_name", "location", "devices"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_ruleevent", "_id", "event_name", "rule_id_ref", "marketing_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY);", new Object[] {
            "marketing_displayed", "campaign_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_conditions", "_id", "attribute_name", "operator", "rule_id_ref", "marketing_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER REFERENCES %s(%s) NOT NULL);", new Object[] {
            "marketing_condition_values", "_id", "value", "condition_id_ref", "marketing_conditions", "_id"
        }));
        if (oldDB == null)
        {
            break MISSING_BLOCK_LABEL_1453;
        }
        SQLiteDatabase sqlitedatabase1 = oldDB;
        sqlitedatabase1;
        JVM INSTR monitorenter ;
        Cursor cursor = null;
        ContentValues contentvalues = new ContentValues();
        Cursor cursor1 = oldDB.query("amp_rules", null, null, null, null, null, "_id ASC");
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        contentvalues.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
        cursor = cursor1;
        contentvalues.put("campaign_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("campaign_id"))));
        cursor = cursor1;
        contentvalues.put("expiration", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("expiration"))));
        cursor = cursor1;
        contentvalues.put("display_seconds", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_seconds"))));
        cursor = cursor1;
        contentvalues.put("display_session", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_session"))));
        cursor = cursor1;
        contentvalues.put("version", cursor1.getString(cursor1.getColumnIndexOrThrow("version")));
        cursor = cursor1;
        contentvalues.put("phone_location", cursor1.getString(cursor1.getColumnIndexOrThrow("phone_location")));
        cursor = cursor1;
        contentvalues.put("phone_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_width"))));
        cursor = cursor1;
        contentvalues.put("phone_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_height"))));
        cursor = cursor1;
        contentvalues.put("tablet_location", cursor1.getString(cursor1.getColumnIndexOrThrow("tablet_location")));
        cursor = cursor1;
        contentvalues.put("tablet_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_width"))));
        cursor = cursor1;
        contentvalues.put("tablet_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_height"))));
        cursor = cursor1;
        contentvalues.put("time_to_display", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("time_to_display"))));
        cursor = cursor1;
        contentvalues.put("internet_required", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("internet_required"))));
        cursor = cursor1;
        contentvalues.put("ab_test", cursor1.getString(cursor1.getColumnIndexOrThrow("ab_test")));
        cursor = cursor1;
        contentvalues.put("rule_name", cursor1.getString(cursor1.getColumnIndexOrThrow("rule_name")));
        cursor = cursor1;
        contentvalues.put("location", cursor1.getString(cursor1.getColumnIndexOrThrow("location")));
        cursor = cursor1;
        contentvalues.put("devices", cursor1.getString(cursor1.getColumnIndexOrThrow("devices")));
        cursor = cursor1;
        sqlitedatabase.insert("marketing_rules", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        if (true) goto _L2; else goto _L1
_L1:
        cursor = cursor1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_834;
        }
        cursor1.close();
        cursor = null;
        break MISSING_BLOCK_LABEL_834;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_832;
        }
        cursor.close();
        throw sqlitedatabase;
        cursor1 = oldDB.query("amp_ruleevent", null, null, null, null, null, "_id ASC");
_L4:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        contentvalues.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
        cursor = cursor1;
        contentvalues.put("event_name", cursor1.getString(cursor1.getColumnIndexOrThrow("event_name")));
        cursor = cursor1;
        contentvalues.put("rule_id_ref", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("rule_id_ref"))));
        cursor = cursor1;
        sqlitedatabase.insert("marketing_ruleevent", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        if (true) goto _L4; else goto _L3
_L3:
        cursor = cursor1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_988;
        }
        cursor1.close();
        cursor = null;
        break MISSING_BLOCK_LABEL_988;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_986;
        }
        cursor.close();
        throw sqlitedatabase;
        cursor1 = oldDB.query("amp_displayed", null, null, null, null, null, "_id ASC");
_L6:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        if (cursor1.getInt(cursor1.getColumnIndexOrThrow("displayed")) != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        contentvalues.put("campaign_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("campaign_id"))));
        cursor = cursor1;
        sqlitedatabase.insert("marketing_displayed", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        if (true) goto _L6; else goto _L5
_L5:
        cursor = cursor1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_1113;
        }
        cursor1.close();
        cursor = null;
        break MISSING_BLOCK_LABEL_1113;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1111;
        }
        cursor.close();
        throw sqlitedatabase;
        cursor1 = oldDB.query("amp_conditions", null, null, null, null, null, "_id ASC");
_L8:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        contentvalues.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
        cursor = cursor1;
        contentvalues.put("attribute_name", cursor1.getString(cursor1.getColumnIndexOrThrow("attribute_name")));
        cursor = cursor1;
        contentvalues.put("operator", cursor1.getString(cursor1.getColumnIndexOrThrow("operator")));
        cursor = cursor1;
        contentvalues.put("rule_id_ref", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("rule_id_ref"))));
        cursor = cursor1;
        sqlitedatabase.insert("marketing_conditions", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        if (true) goto _L8; else goto _L7
_L7:
        cursor = cursor1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_1290;
        }
        cursor1.close();
        cursor = null;
        break MISSING_BLOCK_LABEL_1290;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1288;
        }
        cursor.close();
        throw sqlitedatabase;
        cursor1 = oldDB.query("amp_condition_values", null, null, null, null, null, "_id ASC");
_L10:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        contentvalues.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
        cursor = cursor1;
        contentvalues.put("value", cursor1.getString(cursor1.getColumnIndexOrThrow("value")));
        cursor = cursor1;
        contentvalues.put("condition_id_ref", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("condition_id_ref"))));
        cursor = cursor1;
        sqlitedatabase.insert("marketing_condition_values", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        if (true) goto _L10; else goto _L9
_L9:
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_1440;
        }
        cursor1.close();
        break MISSING_BLOCK_LABEL_1440;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_1438;
        }
        cursor.close();
        throw sqlitedatabase;
        cleanUpOldDB();
        sqlitedatabase1;
        JVM INSTR monitorexit ;
        return;
        sqlitedatabase;
        throw sqlitedatabase;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            throw new IllegalArgumentException("db cannot be null");
        } else
        {
            onUpgrade(sqlitedatabase, 0, 3);
            return;
        }
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.en(sqlitedatabase);
        en(String.format("SQLite library version is: %s", new Object[] {
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
            addNonUniqueRuleName(sqlitedatabase);
        }
        if (i < 3)
        {
            setUpFrequencyCappingTables(sqlitedatabase);
            addControlGroup(sqlitedatabase);
            addSchemaVersion(sqlitedatabase);
        }
    }

    protected void setUpFrequencyCappingTables(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor;
        ArrayList arraylist;
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER UNIQUE, %s INTEGER, %s INTEGER);", new Object[] {
            "frequency_capping_rules", "_id", "campaign_id", "max_display_count", "ignore_global"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_display_frequencies", "_id", "frequency_id", "count", "days", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_dates", "frequency_id", "rule_group_id", "start", "end", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_weekdays", "frequency_id", "rule_group_id", "day", "frequency_id", "frequency_capping_rules", "_id"
        }));
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE);", new Object[] {
            "frequency_capping_blackout_times", "frequency_id", "rule_group_id", "start", "end", "frequency_id", "frequency_capping_rules", "_id"
        }));
        arraylist = new ArrayList();
        cursor = null;
        Cursor cursor1 = sqlitedatabase.query("marketing_displayed", new String[] {
            "campaign_id"
        }, null, null, null, null, null);
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        arraylist.add(Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("campaign_id"))));
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        break MISSING_BLOCK_LABEL_359;
        sqlitedatabase;
        if (cursor != null)
        {
            cursor.close();
        }
        throw sqlitedatabase;
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL);", new Object[] {
            "campaigns_displayed", "campaign_id", "date", "ignore_global"
        }));
        Integer integer;
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); sqlitedatabase.execSQL(String.format("INSERT INTO %s VALUES (?, datetime(0,'unixepoch'), ?);", new Object[] {
    "campaigns_displayed"
}), new Integer[] {
    integer, Integer.valueOf(1)
}))
        {
            integer = (Integer)iterator.next();
        }

        sqlitedatabase.execSQL(String.format("DROP TABLE %s", new Object[] {
            "marketing_displayed"
        }));
        sqlitedatabase.execSQL(String.format("DELETE FROM %s", new Object[] {
            "marketing_rules"
        }));
        BaseProvider.deleteDirectory(new File(MarketingDownloader.getMarketingDataDirectory(mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey())));
        return;
    }

    (String s, int i, LocalyticsDao localyticsdao)
    {
        super(s, i, localyticsdao);
    }
}
