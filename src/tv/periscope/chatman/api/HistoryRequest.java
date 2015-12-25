// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;


public class HistoryRequest
{

    private final String accessToken;
    private final String cursor;
    private final Integer limit;

    public HistoryRequest(String s, String s1, Integer integer)
    {
        accessToken = s;
        cursor = s1;
        limit = integer;
    }
}
