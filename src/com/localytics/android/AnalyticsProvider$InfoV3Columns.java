// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            AnalyticsProvider

static final class 
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

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
