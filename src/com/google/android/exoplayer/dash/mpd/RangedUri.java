// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;

public final class RangedUri
{

    private final String baseUri;
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String s, String s1, long l, long l1)
    {
        boolean flag;
        if (s != null || s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        baseUri = s;
        referenceUri = s1;
        start = l;
        length = l1;
    }

    public final RangedUri attemptMerge(RangedUri rangeduri)
    {
        if (rangeduri == null || !getUriString().equals(rangeduri.getUriString()))
        {
            return null;
        }
        if (length != -1L && start + length == rangeduri.start)
        {
            String s = baseUri;
            String s2 = referenceUri;
            long l2 = start;
            long l;
            if (rangeduri.length == -1L)
            {
                l = -1L;
            } else
            {
                l = length + rangeduri.length;
            }
            return new RangedUri(s, s2, l2, l);
        }
        if (rangeduri.length != -1L && rangeduri.start + rangeduri.length == start)
        {
            String s1 = baseUri;
            String s3 = referenceUri;
            long l3 = rangeduri.start;
            long l1;
            if (length == -1L)
            {
                l1 = -1L;
            } else
            {
                l1 = rangeduri.length + length;
            }
            return new RangedUri(s1, s3, l3, l1);
        } else
        {
            return null;
        }
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (RangedUri)obj;
        return start == ((RangedUri) (obj)).start && length == ((RangedUri) (obj)).length && getUriString().equals(((RangedUri) (obj)).getUriString());
    }

    public final Uri getUri()
    {
        return UriUtil.resolveToUri(baseUri, referenceUri);
    }

    public final String getUriString()
    {
        return UriUtil.resolve(baseUri, referenceUri);
    }

    public final int hashCode()
    {
        if (hashCode == 0)
        {
            hashCode = (((int)start + 527) * 31 + (int)length) * 31 + getUriString().hashCode();
        }
        return hashCode;
    }
}
