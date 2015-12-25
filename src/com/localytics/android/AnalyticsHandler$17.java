// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler, BaseProvider

class val.key
    implements Callable
{

    final AnalyticsHandler this$0;
    final String val$key;

    public volatile Object call()
    {
        return call();
    }

    public String call()
    {
        Cursor cursor1;
        String s;
        cursor1 = null;
        s = null;
        Cursor cursor2 = mProvider.query("identifiers", AnalyticsHandler.access$1600(), AnalyticsHandler.access$1700(), new String[] {
            val$key
        }, null);
        Cursor cursor;
        cursor = cursor2;
        cursor1 = cursor;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        cursor1 = cursor;
        s = cursor.getString(cursor.getColumnIndexOrThrow("value"));
        Exception exception;
        if (cursor != null)
        {
            cursor.close();
            return s;
        } else
        {
            return s;
        }
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    ()
    {
        this$0 = final_analyticshandler;
        val$key = String.this;
        super();
    }
}
