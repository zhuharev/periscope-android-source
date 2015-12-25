// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;


public class ThumbnailPlaylistItem
{

    public int chunk;
    public int rotation;
    public double timeInSecs;
    public String url;

    public ThumbnailPlaylistItem()
    {
    }

    public long getTimeInMs()
    {
        return (long)timeInSecs * 1000L;
    }
}
