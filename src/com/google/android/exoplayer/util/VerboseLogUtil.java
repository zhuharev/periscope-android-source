// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;


public final class VerboseLogUtil
{

    private static volatile boolean enableAllTags;
    private static volatile String enabledTags[];

    private VerboseLogUtil()
    {
    }

    public static boolean areAllTagsEnabled()
    {
        return enableAllTags;
    }

    public static boolean isTagEnabled(String s)
    {
        if (enableAllTags)
        {
            return true;
        }
        String as[] = enabledTags;
        if (as == null || as.length == 0)
        {
            return false;
        }
        for (int i = 0; i < as.length; i++)
        {
            if (as[i].equals(s))
            {
                return true;
            }
        }

        return false;
    }

    public static void setEnableAllTags(boolean flag)
    {
        enableAllTags = flag;
    }

    public static transient void setEnabledTags(String as[])
    {
        enabledTags = as;
        enableAllTags = false;
    }
}
