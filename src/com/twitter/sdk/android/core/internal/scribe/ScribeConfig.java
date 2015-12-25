// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;


public class ScribeConfig
{

    public static final String BASE_URL = "https://api.twitter.com";
    public static final int DEFAULT_MAX_FILES_TO_KEEP = 100;
    public static final int DEFAULT_SEND_INTERVAL_SECONDS = 600;
    public final String baseUrl;
    public final boolean isEnabled;
    public final int maxFilesToKeep;
    public final String pathType;
    public final String pathVersion;
    public final int sendIntervalSeconds;
    public final String sequence;
    public final String userAgent;

    public ScribeConfig(boolean flag, String s, String s1, String s2, String s3, String s4, int i, 
            int j)
    {
        isEnabled = flag;
        baseUrl = s;
        pathVersion = s1;
        pathType = s2;
        sequence = s3;
        userAgent = s4;
        maxFilesToKeep = i;
        sendIntervalSeconds = j;
    }
}
