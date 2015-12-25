// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;

import java.util.List;

public class HistoryResponse
{

    public final String cursor;
    public final List messages;
    public transient String prevCursor;

    public HistoryResponse(List list, String s)
    {
        messages = list;
        cursor = s;
    }
}
