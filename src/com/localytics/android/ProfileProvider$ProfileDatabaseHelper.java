// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            ProfileProvider, LocalyticsDao

static final class <init> extends <init>
{

    protected final void migrateV2ToV3(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL)", new Object[] {
            "changes", "_id", "scope", "change", "customer_id"
        }));
        if (oldDB == null)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        SQLiteDatabase sqlitedatabase1 = oldDB;
        sqlitedatabase1;
        JVM INSTR monitorenter ;
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = cursor1;
        ContentValues contentvalues = new ContentValues();
        cursor = cursor1;
        cursor1 = oldDB.query("profile", null, null, null, null, null, "_id ASC");
_L2:
        cursor = cursor1;
        boolean flag = cursor1.moveToNext();
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        JSONObject jsonobject = new JSONObject(cursor1.getString(cursor1.getColumnIndexOrThrow("attribute")));
        cursor = cursor1;
        JSONObject jsonobject1 = new JSONObject();
        cursor = cursor1;
        jsonobject1.put("op", .rationString());
        cursor = cursor1;
        String s = (String)jsonobject.keys().next();
        cursor = cursor1;
        jsonobject1.put("attr", s);
        cursor = cursor1;
        jsonobject1.put("value", jsonobject.get(s));
        cursor = cursor1;
        contentvalues.put("scope", rationString.rationString());
        cursor = cursor1;
        contentvalues.put("change", jsonobject1.toString());
        cursor = cursor1;
        contentvalues.put("customer_id", cursor1.getString(cursor1.getColumnIndexOrThrow("customer_id")));
        cursor = cursor1;
        sqlitedatabase.insert("changes", null, contentvalues);
        cursor = cursor1;
        contentvalues.clear();
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        cursor = cursor1;
        rationString("Caught JSON exception", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
        cursor = cursor1;
        cleanUpOldDB();
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        cursor1.close();
        break MISSING_BLOCK_LABEL_316;
        sqlitedatabase;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        cursor.close();
        throw sqlitedatabase;
        sqlitedatabase1;
        JVM INSTR monitorexit ;
        return;
        sqlitedatabase;
        throw sqlitedatabase;
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase == null)
        {
            throw new IllegalArgumentException("db cannot be null");
        } else
        {
            sqlitedatabase.execSQL("PRAGMA auto_vacuum = INCREMENTAL;");
            onUpgrade(sqlitedatabase, 0, 1);
            return;
        }
    }

    public final void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        onOpen(String.format("SQLite library version is: %s", new Object[] {
            DatabaseUtils.stringForQuery(sqlitedatabase, "select sqlite_version()", null)
        }));
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i <= 0)
        {
            migrateV2ToV3(sqlitedatabase);
        }
    }

    (String s, int i, LocalyticsDao localyticsdao)
    {
        super(s, i, localyticsdao);
    }
}
