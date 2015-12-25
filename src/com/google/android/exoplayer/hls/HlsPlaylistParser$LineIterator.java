// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import java.io.BufferedReader;
import java.util.Queue;

// Referenced classes of package com.google.android.exoplayer.hls:
//            HlsPlaylistParser

static class reader
{

    private final Queue extraLines;
    private String next;
    private final BufferedReader reader;

    public boolean hasNext()
    {
        if (next != null)
        {
            return true;
        }
        if (!extraLines.isEmpty())
        {
            next = (String)extraLines.poll();
            return true;
        }
        do
        {
            String s = reader.readLine();
            next = s;
            if (s != null)
            {
                next = next.trim();
                if (!next.isEmpty())
                {
                    return true;
                }
            } else
            {
                return false;
            }
        } while (true);
    }

    public String next()
    {
        String s = null;
        if (hasNext())
        {
            s = next;
            next = null;
        }
        return s;
    }

    public (Queue queue, BufferedReader bufferedreader)
    {
        extraLines = queue;
        reader = bufferedreader;
    }
}
