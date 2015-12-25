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

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
