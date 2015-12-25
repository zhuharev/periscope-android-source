// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSourceTrackRenderer;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.text:
//            SubtitleParser, TextRenderer, PlayableSubtitle, SubtitleParserHelper

public final class TextTrackRenderer extends SampleSourceTrackRenderer
    implements android.os.Handler.Callback
{

    private static final List DEFAULT_PARSER_CLASSES;
    private static final int MSG_UPDATE_OVERLAY = 0;
    private final MediaFormatHolder formatHolder;
    private boolean inputStreamEnded;
    private PlayableSubtitle nextSubtitle;
    private int nextSubtitleEventIndex;
    private SubtitleParserHelper parserHelper;
    private int parserIndex;
    private HandlerThread parserThread;
    private PlayableSubtitle subtitle;
    private final SubtitleParser subtitleParsers[];
    private final TextRenderer textRenderer;
    private final Handler textRendererHandler;

    public transient TextTrackRenderer(SampleSource samplesource, TextRenderer textrenderer, Looper looper, SubtitleParser asubtitleparser[])
    {
        this(new SampleSource[] {
            samplesource
        }, textrenderer, looper, asubtitleparser);
    }

    public transient TextTrackRenderer(SampleSource asamplesource[], TextRenderer textrenderer, Looper looper, SubtitleParser asubtitleparser[])
    {
label0:
        {
            super(asamplesource);
            textRenderer = (TextRenderer)Assertions.checkNotNull(textrenderer);
            if (looper == null)
            {
                asamplesource = null;
            } else
            {
                asamplesource = new Handler(looper, this);
            }
            textRendererHandler = asamplesource;
            if (asubtitleparser != null)
            {
                asamplesource = asubtitleparser;
                if (asubtitleparser.length != 0)
                {
                    break label0;
                }
            }
            textrenderer = new SubtitleParser[DEFAULT_PARSER_CLASSES.size()];
            int i = 0;
            do
            {
                asamplesource = textrenderer;
                if (i >= textrenderer.length)
                {
                    break;
                }
                try
                {
                    textrenderer[i] = (SubtitleParser)((Class)DEFAULT_PARSER_CLASSES.get(i)).newInstance();
                }
                // Misplaced declaration of an exception variable
                catch (SampleSource asamplesource[])
                {
                    throw new IllegalStateException("Unexpected error creating default parser", asamplesource);
                }
                // Misplaced declaration of an exception variable
                catch (SampleSource asamplesource[])
                {
                    throw new IllegalStateException("Unexpected error creating default parser", asamplesource);
                }
                i++;
            } while (true);
        }
        subtitleParsers = asamplesource;
        formatHolder = new MediaFormatHolder();
    }

    private void clearTextRenderer()
    {
        updateTextRenderer(Collections.emptyList());
    }

    private long getNextEventTime()
    {
        if (nextSubtitleEventIndex == -1 || nextSubtitleEventIndex >= subtitle.getEventTimeCount())
        {
            return 0x7fffffffffffffffL;
        } else
        {
            return subtitle.getEventTime(nextSubtitleEventIndex);
        }
    }

    private int getParserIndex(MediaFormat mediaformat)
    {
        for (int i = 0; i < subtitleParsers.length; i++)
        {
            if (subtitleParsers[i].canParse(mediaformat.mimeType))
            {
                return i;
            }
        }

        return -1;
    }

    private void invokeRendererInternalCues(List list)
    {
        textRenderer.onCues(list);
    }

    private void seekToInternal()
    {
        inputStreamEnded = false;
        subtitle = null;
        nextSubtitle = null;
        parserHelper.flush();
        clearTextRenderer();
    }

    private void updateTextRenderer(List list)
    {
        if (textRendererHandler != null)
        {
            textRendererHandler.obtainMessage(0, list).sendToTarget();
            return;
        } else
        {
            invokeRendererInternalCues(list);
            return;
        }
    }

    protected final void doSomeWork(long l, long l1)
    {
        continueBufferingSource(l);
        if (nextSubtitle == null)
        {
            try
            {
                nextSubtitle = parserHelper.getAndClearResult();
            }
            catch (IOException ioexception)
            {
                throw new ExoPlaybackException(ioexception);
            }
        }
        if (getState() != 3)
        {
            return;
        }
        boolean flag = false;
        boolean flag1 = false;
        if (subtitle != null)
        {
            l1 = getNextEventTime();
            for (flag = flag1; l1 <= l; flag = true)
            {
                nextSubtitleEventIndex = nextSubtitleEventIndex + 1;
                l1 = getNextEventTime();
            }

        }
        flag1 = flag;
        if (nextSubtitle != null)
        {
            flag1 = flag;
            if (nextSubtitle.startTimeUs <= l)
            {
                subtitle = nextSubtitle;
                nextSubtitle = null;
                nextSubtitleEventIndex = subtitle.getNextEventTimeIndex(l);
                flag1 = true;
            }
        }
        if (flag1)
        {
            updateTextRenderer(subtitle.getCues(l));
        }
        if (!inputStreamEnded && nextSubtitle == null && !parserHelper.isParsing())
        {
            SampleHolder sampleholder = parserHelper.getSampleHolder();
            sampleholder.clearData();
            int i = readSource(l, formatHolder, sampleholder, false);
            if (i == -4)
            {
                parserHelper.setFormat(formatHolder.format);
                return;
            }
            if (i == -3)
            {
                parserHelper.startParseOperation();
                return;
            }
            if (i == -1)
            {
                inputStreamEnded = true;
            }
        }
    }

    protected final long getBufferedPositionUs()
    {
        return -3L;
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        case 0: // '\0'
            invokeRendererInternalCues((List)message.obj);
            return true;
        }
        return false;
    }

    protected final boolean handlesTrack(MediaFormat mediaformat)
    {
        return getParserIndex(mediaformat) != -1;
    }

    protected final boolean isEnded()
    {
        return inputStreamEnded && (subtitle == null || getNextEventTime() == 0x7fffffffffffffffL);
    }

    protected final boolean isReady()
    {
        return true;
    }

    protected final void onDisabled()
    {
        subtitle = null;
        nextSubtitle = null;
        parserThread.quit();
        parserThread = null;
        parserHelper = null;
        clearTextRenderer();
        super.onDisabled();
    }

    protected final void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        parserIndex = getParserIndex(getFormat(i));
        parserThread = new HandlerThread("textParser");
        parserThread.start();
        parserHelper = new SubtitleParserHelper(parserThread.getLooper(), subtitleParsers[parserIndex]);
        seekToInternal();
    }

    protected final void seekTo(long l)
    {
        super.seekTo(l);
        seekToInternal();
    }

    static 
    {
        DEFAULT_PARSER_CLASSES = new ArrayList();
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.webvtt.WebvttParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.ttml.TtmlParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception1) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.subrip.SubripParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception2) { }
        try
        {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.tx3g.Tx3gParser").asSubclass(com/google/android/exoplayer/text/SubtitleParser));
        }
        catch (ClassNotFoundException classnotfoundexception3) { }
    }
}
