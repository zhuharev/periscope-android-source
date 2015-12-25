// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            AnalyticsProvider

static final class UploadFormat.value
    implements BaseColumns
{
    static final class UploadFormat extends Enum
    {

        private static final UploadFormat $VALUES[];
        public static final UploadFormat V2;
        public static final UploadFormat V3;
        private final int value;

        public static UploadFormat valueOf(String s)
        {
            return (UploadFormat)Enum.valueOf(com/localytics/android/AnalyticsProvider$EventsV3Columns$UploadFormat, s);
        }

        public static UploadFormat[] values()
        {
            return (UploadFormat[])$VALUES.clone();
        }

        public final int getValue()
        {
            return value;
        }

        static 
        {
            V2 = new UploadFormat("V2", 0, 2);
            V3 = new UploadFormat("V3", 1, 3);
            $VALUES = (new UploadFormat[] {
                V2, V3
            });
        }

        private UploadFormat(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    static final String BLOB = "blob";
    static final String TABLE_NAME = "events";
    static final String UPLOAD_FORMAT = "upload_format";

    private UploadFormat.value()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
