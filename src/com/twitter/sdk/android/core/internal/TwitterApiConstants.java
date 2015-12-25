// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal;


public class TwitterApiConstants
{
    public static class Base
    {

        public static final String FIELD_ID = "id";
        public static final String PARAM_ID = "id";

        public Base()
        {
        }
    }

    public static class Errors extends Base
    {

        public static final int ALREADY_FAVORITED = 139;
        public static final int ALREADY_UNFAVORITED = 144;
        public static final int APP_AUTH_ERROR_CODE = 89;
        public static final String ERRORS = "errors";
        public static final int GUEST_AUTH_ERROR_CODE = 239;
        public static final int LEGACY_ERROR = 0;

        public Errors()
        {
        }
    }


    public TwitterApiConstants()
    {
    }
}
