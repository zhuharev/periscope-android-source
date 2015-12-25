// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            MigrationDatabaseHelper

static final class 
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

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
