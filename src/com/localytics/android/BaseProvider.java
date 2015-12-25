// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, DatapointHelper, MigrationDatabaseHelper

abstract class BaseProvider
{
    static abstract class LocalyticsDatabaseHelper extends SQLiteOpenHelper
    {

        static final String SQLITE_BOOLEAN_FALSE = "0";
        static final String SQLITE_BOOLEAN_TRUE = "1";
        private static int completedMigrations = 0;
        static SQLiteDatabase oldDB;
        private static File oldDBFile = null;
        LocalyticsDao mLocalyticsDao;

        static void cleanUpOldDB()
        {
            int i = completedMigrations + 1;
            completedMigrations = i;
            if (i == 3)
            {
                oldDB.close();
                oldDBFile.delete();
            }
        }

        protected abstract void migrateV2ToV3(SQLiteDatabase sqlitedatabase);


        LocalyticsDatabaseHelper(String s, int i, LocalyticsDao localyticsdao)
        {
            super(localyticsdao.getAppContext(), s, null, i);
            mLocalyticsDao = localyticsdao;
            com/localytics/android/BaseProvider$LocalyticsDatabaseHelper;
            JVM INSTR monitorenter ;
            if (oldDBFile != null) goto _L2; else goto _L1
_L1:
            File file;
            s = String.format("com.localytics.android.%s.sqlite", new Object[] {
                DatapointHelper.getSha256_buggy(localyticsdao.getApiKey())
            });
            file = new File(localyticsdao.getAppContext().getDatabasePath(s).getPath());
            oldDBFile = file;
            if (!file.exists()) goto _L2; else goto _L3
_L3:
            completedMigrations = 0;
            s = new MigrationDatabaseHelper(s, 18, localyticsdao);
            oldDB = s.getWritableDatabase();
              goto _L2
_L5:
            Localytics.Log.w("Error opening old database; old data will not be retained.");
_L2:
            com/localytics/android/BaseProvider$LocalyticsDatabaseHelper;
            JVM INSTR monitorexit ;
            return;
            s;
            throw s;
            s;
            if (true) goto _L5; else goto _L4
_L4:
        }
    }


    static final String DATABASE_FILE = "com.localytics.android.%s.%s.sqlite";
    private static final String OLD_DATABASE_FILE = "com.localytics.android.%s.sqlite";
    private static final Map sCountProjectionMap = Collections.unmodifiableMap(getCountProjectionMap());
    private static final Set sValidTables = Collections.unmodifiableSet(getValidTables());
    SQLiteDatabase mDb;
    LocalyticsDao mLocalyticsDao;

    BaseProvider(LocalyticsDao localyticsdao)
    {
        mLocalyticsDao = localyticsdao;
    }

    static boolean deleteDirectory(File file)
    {
        if (file.exists() && file.isDirectory())
        {
            String as[] = file.list();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                if (!deleteDirectory(new File(file, as[i])))
                {
                    return false;
                }
            }

        }
        return file.delete();
    }

    static void deleteOldFiles(Context context)
    {
        deleteDirectory(new File(context.getFilesDir(), "localytics"));
    }

    private static HashMap getCountProjectionMap()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_count", "COUNT(*)");
        return hashmap;
    }

    private int getNumberOfRows(String s)
    {
        return query(s, null, null, null, null).getCount();
    }

    private static Set getValidTables()
    {
        HashSet hashset = new HashSet();
        hashset.add("events");
        hashset.add("custom_dimensions");
        hashset.add("info");
        hashset.add("identifiers");
        hashset.add("changes");
        hashset.add("marketing_rules");
        hashset.add("marketing_ruleevent");
        hashset.add("marketing_conditions");
        hashset.add("marketing_condition_values");
        hashset.add("marketing_displayed");
        return hashset;
    }

    private static boolean isValidTable(String s)
    {
        return s != null && sValidTables.contains(s);
    }

    abstract boolean canAddToDB();

    void close()
    {
        mDb.close();
    }

    long insert(String s, ContentValues contentvalues)
    {
        Localytics.Log.v(String.format("Insert table: %s, values: %s", new Object[] {
            s, contentvalues.toString()
        }));
        if (!canAddToDB())
        {
            Localytics.Log.v("Database is full; data not inserted");
            return -1L;
        } else
        {
            long l = mDb.insertOrThrow(s, null, contentvalues);
            Localytics.Log.v(String.format("Inserted row with new id %d", new Object[] {
                Long.valueOf(l)
            }));
            return l;
        }
    }

    abstract long maxSiloDbSize();

    Cursor query(String s, String as[], String s1, String as1[], String s2)
    {
        Localytics.Log.v(String.format("Query table: %s, projection: %s, selection: %s, selectionArgs: %s", new Object[] {
            s, Arrays.toString(as), s1, Arrays.toString(as1)
        }));
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables(s);
        if (as != null && 1 == as.length && "_count".equals(as[0]))
        {
            sqlitequerybuilder.setProjectionMap(sCountProjectionMap);
        }
        s = sqlitequerybuilder.query(mDb, as, s1, as1, null, null, s2);
        Localytics.Log.v((new StringBuilder("Query result is: ")).append(DatabaseUtils.dumpCursorToString(s)).toString());
        return s;
    }

    int remove(String s, String s1, String as[])
    {
        Localytics.Log.v(String.format("Delete table: %s, selection: %s, selectionArgs: %s", new Object[] {
            s, s1, Arrays.toString(as)
        }));
        int i;
        if (s1 == null)
        {
            i = mDb.delete(s, "1", null);
        } else
        {
            i = mDb.delete(s, s1, as);
        }
        Localytics.Log.v(String.format("Deleted %d rows", new Object[] {
            Integer.valueOf(i)
        }));
        return i;
    }

    public void runBatchTransaction(Runnable runnable)
    {
        mDb.beginTransaction();
        runnable.run();
        mDb.setTransactionSuccessful();
        mDb.endTransaction();
        return;
        runnable;
        mDb.endTransaction();
        throw runnable;
    }

    int update(String s, ContentValues contentvalues, String s1, String as[])
    {
        Localytics.Log.v(String.format("Update table: %s, values: %s, selection: %s, selectionArgs: %s", new Object[] {
            s, contentvalues.toString(), s1, Arrays.toString(as)
        }));
        return mDb.update(s, contentvalues, s1, as);
    }

    void vacuumIfNecessary()
    {
        if ((double)(new File(mDb.getPath())).length() >= (double)maxSiloDbSize() * 0.80000000000000004D)
        {
            runBatchTransaction(new _cls1());
        }
    }


    private class _cls1
        implements Runnable
    {

        final BaseProvider this$0;

        public void run()
        {
            Cursor cursor;
            Cursor cursor1;
            cursor1 = null;
            cursor = null;
            Cursor cursor2 = mDb.rawQuery("PRAGMA incremental_vacuum(0);", null);
_L2:
            cursor = cursor2;
            cursor1 = cursor2;
            boolean flag = cursor2.moveToNext();
            if (!flag)
            {
                if (cursor2 != null)
                {
                    cursor2.close();
                    return;
                }
                break MISSING_BLOCK_LABEL_80;
            }
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception1;
            exception1;
            cursor1 = cursor;
            Localytics.Log.w("Auto-vacuum error", exception1);
            if (cursor != null)
            {
                cursor.close();
                return;
            }
            break MISSING_BLOCK_LABEL_80;
            Exception exception;
            exception;
            if (cursor1 != null)
            {
                cursor1.close();
            }
            throw exception;
        }

        _cls1()
        {
            this$0 = BaseProvider.this;
            super();
        }
    }

}
