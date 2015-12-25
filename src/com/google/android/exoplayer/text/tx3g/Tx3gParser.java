// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.tx3g;

import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.Subtitle;
import com.google.android.exoplayer.text.SubtitleParser;
import java.io.DataInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.text.tx3g:
//            Tx3gSubtitle

public final class Tx3gParser
    implements SubtitleParser
{

    public Tx3gParser()
    {
    }

    public final boolean canParse(String s)
    {
        return "application/x-quicktime-tx3g".equals(s);
    }

    public final Subtitle parse(InputStream inputstream)
    {
        return new Tx3gSubtitle(new Cue((new DataInputStream(inputstream)).readUTF()));
    }
}
