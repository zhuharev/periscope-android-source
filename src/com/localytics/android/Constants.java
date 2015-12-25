// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.localytics.android:
//            DatapointHelper

final class Constants
{

    static final String AB_ATTRIBUTE = "ab";
    static final String ACTION_CLICK = "click";
    static final String ACTION_CONTROL = "control";
    static final String ACTION_DISMISS = "X";
    static final String ADID_STRING = "adid";
    static final String AMP_KEY = "amp";
    static String ANALYTICS_HOST = "analytics.localytics.com";
    static final String BLACKOUT_RULES_KEY = "blackout_rules";
    static final String CAMPAIGN_ID_KEY = "campaign_id";
    static final String CLOSE_EVENT = "close";
    static final String CONDITIONS_KEY = "conditions";
    static final String CONFIG_KEY = "config";
    static final String COUNT_KEY = "count";
    static final int CURRENT_API_LEVEL = DatapointHelper.getApiLevel();
    static final String CUSTOMER_EMAIL = "email";
    static final String CUSTOMER_FIRST_NAME = "first_name";
    static final String CUSTOMER_FULL_NAME = "full_name";
    static final String CUSTOMER_ID = "customer_id";
    static final String CUSTOMER_LAST_NAME = "last_name";
    static final String CUSTOM_DIMENSION_DB_KEY = "custom_dimension_";
    static final String CUSTOM_DIMENSION_UPLOAD_KEY = "c";
    static final String DATES_KEY = "dates";
    static final String DAYS_KEY = "days";
    static final double DB_VACUUM_THRESHOLD = 0.80000000000000004D;
    static final String DEFAULT_HTML_PAGE = "index.html";
    static final String DEFAULT_ZIP_PAGE = "amp_rule_%d.zip";
    static final String DEVICE_BOTH = "both";
    static final String DEVICE_PHONE = "phone";
    static final String DEVICE_TABLET = "tablet";
    static final float DISMISS_BUTTON_SIDE = 40F;
    static final String DISPLAY_EVENTS_KEY = "display_events";
    static final String DISPLAY_FREQUENCIES_KEY = "display_frequencies";
    static final String END_KEY = "end";
    static final String EVENT_FORMAT = "%s:%s";
    static final String FREQUENCY_CAPPING_KEY = "frequency_capping";
    static final String HEIGHT_KEY = "height";
    static final String IGNORE_GLOBAL_KEY = "ignore_global";
    static final boolean IS_DEVICE_IDENTIFIER_UPLOADED = true;
    static final boolean IS_EXCEPTION_SUPPRESSION_ENABLED = true;
    static boolean IS_LOGGING_ENABLED = false;
    static final boolean IS_PARAMETER_CHECKING_ENABLED = false;
    static final String KEY_BASE_PATH = "base_path";
    static final String KEY_DISPLAY_HEIGHT = "display_height";
    static final String KEY_DISPLAY_WIDTH = "display_width";
    static final String KEY_HTML_URL = "html_url";
    static final String LOCALYTICS_CLIENT_LIBRARY_VERSION = "androida_3.5.0";
    static final String LOCALYTICS_DIR = ".localytics";
    static final String LOCALYTICS_METADATA_APP_KEY = "LOCALYTICS_APP_KEY";
    static final String LOCALYTICS_METADATA_NOTIFICATION_ICON = "LOCALYTICS_NOTIFICATION_ICON";
    static final String LOCALYTICS_METADATA_ROLLUP_KEY = "LOCALYTICS_ROLLUP_KEY";
    static final String LOCALYTICS_PACKAGE_NAME = "com.localytics.android";
    static final String LOG_TAG = "Localytics";
    static final String MARKETING_AB_KEY = "ampAB";
    static final String MARKETING_ACTION_KEY = "ampAction";
    static final String MARKETING_ACTION_STRING = "ampAction";
    static final String MARKETING_CAMPAIGN_ID_KEY = "ampCampaignId";
    static final String MARKETING_CAMPAIGN_KEY = "ampCampaign";
    static final int MARKETING_CLIENT_SCHEMA_VERSION = 3;
    static final String MARKETING_DURATION_KEY = "ampDuration";
    static final String MARKETING_EVENT_NAME_KEY = "ampView";
    static final String MARKETING_FIRST_RUN_TRIGGER = "AMP First Run";
    static String MARKETING_HOST = "analytics.localytics.com";
    static final String MARKETING_START_TRIGGER = "AMP Loaded";
    static final String MARKETING_TYPE_KEY = "type";
    static final String MARKETING_UPGRADE_TRIGGER = "AMP upgrade";
    static final int MAXIMUM_ROWS_PER_UPLOAD = 100;
    static final int MAX_CUSTOM_DIMENSIONS = 10;
    static final String MAX_DISPLAY_COUNT_KEY = "max_display_count";
    static final int MAX_NAME_LENGTH = 128;
    static final int MAX_NUMBER_OF_UPLOAD_RETRIES = 3;
    static final int MAX_NUM_ATTRIBUTES = 50;
    static final int MAX_VALUE_LENGTH = 255;
    static final int NUMBER_OF_EOF_ATTEMPTS = 3;
    static final String OPEN_EVENT = "open";
    static final String OPEN_EXTERNAL = "ampExternalOpen";
    static final String OPT_IN_EVENT = "opt_in";
    static final String OPT_OUT_EVENT = "opt_out";
    static final String PHONE_SIZE_KEY = "phone_size";
    static String PROFILES_HOST = "profile.localytics.com";
    static final String PROTOCOL_FILE = "file";
    static final String PROTOCOL_HTTP = "http";
    static final String PROTOCOL_HTTPS = "https";
    static final String SCHEMA_VERSION_CLIENT_ATTRIBUTE = "Schema Version - Client";
    static final String SCHEMA_VERSION_SERVER_ATTRIBUTE = "Schema Version - Server";
    static final String SERVER_SCHEMA_VERSION_KEY = "schema_version";
    static long SESSION_EXPIRATION = 0L;
    static final long SESSION_START_MARKETING_MESSAGE_DELAY = 10000L;
    static final String SPECIAL_PROFILE_ATTRIBUTE_PREFIX = "$";
    static final String START_KEY = "start";
    static final String TABLET_SIZE_KEY = "tablet_size";
    static final String TEST_MODE_UPDATE_DATA = "Test Mode Update Data";
    static final String TIMES_KEY = "times";
    static final String TYPE_CONTROL = "Control";
    static final String TYPE_IN_APP = "In-App";
    static final long UPLOAD_BACKOFF = 10000L;
    static final String USER_TYPE = "type";
    static final String USER_TYPE_ANONYMOUS = "anonymous";
    static final String USER_TYPE_KNOWN = "known";
    static final boolean USE_EXTERNAL_DIRECTORY = false;
    static boolean USE_HTTPS = false;
    static final String WEEKDAYS_KEY = "weekdays";
    static final String WIDTH_KEY = "width";
    static long dbMaxSizeForAnalytics = 0L;
    static long dbMaxSizeForProfiles = 0L;
    private static final AtomicBoolean sTestModeEnabled = new AtomicBoolean(false);

    Constants()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static boolean isTestModeEnabled()
    {
        return sTestModeEnabled.get();
    }

    public static void setTestModeEnabled(boolean flag)
    {
        sTestModeEnabled.set(flag);
    }

    static 
    {
        dbMaxSizeForProfiles = (long)Math.pow(2D, 20D);
        dbMaxSizeForAnalytics = (long)Math.pow(2D, 24D);
        SESSION_EXPIRATION = 15000L;
        IS_LOGGING_ENABLED = false;
        USE_HTTPS = true;
    }
}
