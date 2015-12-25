// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import java.util.Iterator;
import java.util.List;
import o.sc;
import retrofit.client.Header;

class TwitterRateLimit
{

    private static final String LIMIT_KEY = "x-rate-limit-limit";
    private static final String REMAINING_KEY = "x-rate-limit-remaining";
    private static final String RESET_KEY = "x-rate-limit-reset";
    private final long epochSeconds;
    private int remainingRequest;
    private int requestLimit;
    private long resetSeconds;

    TwitterRateLimit(List list)
    {
        this(list, new sc());
    }

    TwitterRateLimit(List list, sc sc1)
    {
        if (list == null)
        {
            throw new IllegalArgumentException("headers must not be null");
        }
        epochSeconds = sc1.getCurrentTimeMillis() / 1000L;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            sc1 = (Header)list.next();
            if ("x-rate-limit-limit".equals(sc1.getName()))
            {
                requestLimit = Integer.valueOf(sc1.getValue()).intValue();
            } else
            if ("x-rate-limit-remaining".equals(sc1.getName()))
            {
                remainingRequest = Integer.valueOf(sc1.getValue()).intValue();
            } else
            if ("x-rate-limit-reset".equals(sc1.getName()))
            {
                resetSeconds = Long.valueOf(sc1.getValue()).longValue();
            }
        } while (true);
    }

    public int getLimit()
    {
        return requestLimit;
    }

    public int getRemaining()
    {
        return remainingRequest;
    }

    public long getRemainingTime()
    {
        if (epochSeconds > resetSeconds)
        {
            return 0L;
        } else
        {
            return resetSeconds - epochSeconds;
        }
    }

    public long getRequestedTime()
    {
        return epochSeconds;
    }

    public long getReset()
    {
        return resetSeconds;
    }
}
