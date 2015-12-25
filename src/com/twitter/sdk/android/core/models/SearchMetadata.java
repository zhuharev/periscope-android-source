// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;


public class SearchMetadata
{

    public final double completedIn;
    public final long count;
    public final long maxId;
    public final String maxIdStr;
    public final String nextResults;
    public final String query;
    public final String refreshUrl;
    public final long sinceId;
    public final String sinceIdStr;

    public SearchMetadata(int i, int j, String s, String s1, int k, double d, 
            String s2, String s3, String s4)
    {
        maxId = i;
        sinceId = j;
        refreshUrl = s;
        nextResults = s1;
        count = k;
        completedIn = d;
        sinceIdStr = s2;
        query = s3;
        maxIdStr = s4;
    }
}
