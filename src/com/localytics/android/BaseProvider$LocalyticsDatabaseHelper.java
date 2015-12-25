// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

// Referenced classes of package com.localytics.android:
//            BaseProvider, LocalyticsDao, DatapointHelper, MigrationDatabaseHelper

static abstract class abase extends SQLiteOpenHelper
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


    (String s, int i, LocalyticsDao localyticsdao)
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
        abase("Error opening old database; old data will not be retained.");
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
