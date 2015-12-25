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

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
