// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer.text:
//            SubtitleParser, PlayableSubtitle

final class SubtitleParserHelper
    implements android.os.Handler.Callback
{

    private static final int MSG_FORMAT = 0;
    private static final int MSG_SAMPLE = 1;
    private IOException error;
    private final Handler handler;
    private final SubtitleParser parser;
    private boolean parsing;
    private PlayableSubtitle result;
    private RuntimeException runtimeError;
    private SampleHolder sampleHolder;
    private long subtitleOffsetUs;
    private boolean subtitlesAreRelative;

    public SubtitleParserHelper(Looper looper, SubtitleParser subtitleparser)
    {
        handler = new Handler(looper, this);
        parser = subtitleparser;
        flush();
    }

    private void handleFormat(MediaFormat mediaformat)
    {
        boolean flag;
        if (mediaformat.subsampleOffsetUs == 0x7fffffffffffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        subtitlesAreRelative = flag;
        long l;
        if (subtitlesAreRelative)
        {
            l = 0L;
        } else
        {
            l = mediaformat.subsampleOffsetUs;
        }
        subtitleOffsetUs = l;
    }

    private void handleSample(long l, SampleHolder sampleholder)
    {
        Subtitle subtitle;
        IOException ioexception;
        RuntimeException runtimeexception;
        subtitle = null;
        ioexception = null;
        runtimeexception = null;
        Object obj;
        obj = new ByteArrayInputStream(sampleholder.data.array(), 0, sampleholder.size);
        obj = parser.parse(((java.io.InputStream) (obj)));
        subtitle = ((Subtitle) (obj));
        break MISSING_BLOCK_LABEL_57;
        ioexception;
        break MISSING_BLOCK_LABEL_57;
        runtimeexception;
        this;
        JVM INSTR monitorenter ;
        if (sampleHolder == sampleholder)
        {
            result = new PlayableSubtitle(subtitle, subtitlesAreRelative, l, subtitleOffsetUs);
            error = ioexception;
            runtimeError = runtimeexception;
            parsing = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        sampleholder;
        throw sampleholder;
    }

    public final void flush()
    {
        this;
        JVM INSTR monitorenter ;
        sampleHolder = new SampleHolder(1);
        parsing = false;
        result = null;
        error = null;
        runtimeError = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final PlayableSubtitle getAndClearResult()
    {
        this;
        JVM INSTR monitorenter ;
        PlayableSubtitle playablesubtitle;
        if (error != null)
        {
            throw error;
        }
        if (runtimeError != null)
        {
            throw runtimeError;
        }
        playablesubtitle = result;
        result = null;
        error = null;
        runtimeError = null;
        this;
        JVM INSTR monitorexit ;
        return playablesubtitle;
        Exception exception;
        exception;
        result = null;
        error = null;
        runtimeError = null;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final SampleHolder getSampleHolder()
    {
        this;
        JVM INSTR monitorenter ;
        SampleHolder sampleholder = sampleHolder;
        this;
        JVM INSTR monitorexit ;
        return sampleholder;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        case 0: // '\0'
            handleFormat((MediaFormat)message.obj);
            break;

        case 1: // '\001'
            handleSample(Util.getLong(message.arg1, message.arg2), (SampleHolder)message.obj);
            break;
        }
        return true;
    }

    public final boolean isParsing()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = parsing;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final void setFormat(MediaFormat mediaformat)
    {
        handler.obtainMessage(0, mediaformat).sendToTarget();
    }

    public final void startParseOperation()
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (!parsing)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        parsing = true;
        result = null;
        error = null;
        runtimeError = null;
        handler.obtainMessage(1, Util.getTopInt(sampleHolder.timeUs), Util.getBottomInt(sampleHolder.timeUs), sampleHolder).sendToTarget();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }
}
