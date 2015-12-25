// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text.eia608;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSourceTrackRenderer;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.TextRenderer;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Collections;
import java.util.TreeSet;

// Referenced classes of package com.google.android.exoplayer.text.eia608:
//            Eia608Parser, ClosedCaptionList, ClosedCaption, ClosedCaptionCtrl, 
//            ClosedCaptionText

public final class Eia608TrackRenderer extends SampleSourceTrackRenderer
    implements android.os.Handler.Callback
{

    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int MAX_SAMPLE_READAHEAD_US = 0x4c4b40;
    private static final int MSG_INVOKE_RENDERER = 0;
    private String caption;
    private int captionMode;
    private int captionRowCount;
    private final StringBuilder captionStringBuilder = new StringBuilder();
    private final Eia608Parser eia608Parser = new Eia608Parser();
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private boolean inputStreamEnded;
    private String lastRenderedCaption;
    private final TreeSet pendingCaptionLists = new TreeSet();
    private final SampleHolder sampleHolder = new SampleHolder(1);
    private final TextRenderer textRenderer;
    private final Handler textRendererHandler;

    public Eia608TrackRenderer(SampleSource samplesource, TextRenderer textrenderer, Looper looper)
    {
        super(new SampleSource[] {
            samplesource
        });
        textRenderer = (TextRenderer)Assertions.checkNotNull(textrenderer);
        if (looper == null)
        {
            samplesource = null;
        } else
        {
            samplesource = new Handler(looper, this);
        }
        textRendererHandler = samplesource;
    }

    private void clearPendingSample()
    {
        sampleHolder.timeUs = -1L;
        sampleHolder.clearData();
    }

    private void consumeCaptionList(ClosedCaptionList closedcaptionlist)
    {
        int j = closedcaptionlist.captions.length;
        if (j == 0)
        {
            return;
        }
        for (int i = 0; i < j; i++)
        {
            Object obj = closedcaptionlist.captions[i];
            if (((ClosedCaption) (obj)).type == 0)
            {
                obj = (ClosedCaptionCtrl)obj;
                if (((ClosedCaptionCtrl) (obj)).isMiscCode())
                {
                    handleMiscCode(((ClosedCaptionCtrl) (obj)));
                    continue;
                }
                if (((ClosedCaptionCtrl) (obj)).isPreambleAddressCode())
                {
                    handlePreambleAddressCode();
                }
            } else
            {
                handleText((ClosedCaptionText)obj);
            }
        }

        if (captionMode == 1 || captionMode == 3)
        {
            caption = getDisplayCaption();
        }
    }

    private String getDisplayCaption()
    {
        int j = captionStringBuilder.length();
        if (j == 0)
        {
            return null;
        }
        boolean flag;
        if (captionStringBuilder.charAt(j - 1) == '\n')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j == 1 && flag)
        {
            return null;
        }
        int i;
        if (flag)
        {
            i = j - 1;
        } else
        {
            i = j;
        }
        if (captionMode != 1)
        {
            return captionStringBuilder.substring(0, i);
        }
        boolean flag1 = false;
        j = i;
        for (int k = 0; k < captionRowCount && j != -1; k++)
        {
            j = captionStringBuilder.lastIndexOf("\n", j - 1);
        }

        int l = ((flag1) ? 1 : 0);
        if (j != -1)
        {
            l = j + 1;
        }
        captionStringBuilder.delete(0, l);
        return captionStringBuilder.substring(0, i - l);
    }

    private void handleMiscCode(ClosedCaptionCtrl closedcaptionctrl)
    {
        switch (closedcaptionctrl.cc2)
        {
        case 37: // '%'
            captionRowCount = 2;
            setCaptionMode(1);
            return;

        case 38: // '&'
            captionRowCount = 3;
            setCaptionMode(1);
            return;

        case 39: // '\''
            captionRowCount = 4;
            setCaptionMode(1);
            return;

        case 32: // ' '
            setCaptionMode(2);
            return;

        case 41: // ')'
            setCaptionMode(3);
            return;
        }
        if (captionMode == 0)
        {
            return;
        }
        switch (closedcaptionctrl.cc2)
        {
        default:
            return;

        case 44: // ','
            caption = null;
            if (captionMode == 1 || captionMode == 3)
            {
                captionStringBuilder.setLength(0);
            }
            return;

        case 46: // '.'
            captionStringBuilder.setLength(0);
            return;

        case 47: // '/'
            caption = getDisplayCaption();
            captionStringBuilder.setLength(0);
            return;

        case 45: // '-'
            maybeAppendNewline();
            return;

        case 33: // '!'
            if (captionStringBuilder.length() > 0)
            {
                captionStringBuilder.setLength(captionStringBuilder.length() - 1);
            }
            return;

        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
            return;
        }
    }

    private void handlePreambleAddressCode()
    {
        maybeAppendNewline();
    }

    private void handleText(ClosedCaptionText closedcaptiontext)
    {
        if (captionMode != 0)
        {
            captionStringBuilder.append(closedcaptiontext.text);
        }
    }

    private void invokeRenderer(String s)
    {
        if (Util.areEqual(lastRenderedCaption, s))
        {
            return;
        }
        lastRenderedCaption = s;
        if (textRendererHandler != null)
        {
            textRendererHandler.obtainMessage(0, s).sendToTarget();
            return;
        } else
        {
            invokeRendererInternal(s);
            return;
        }
    }

    private void invokeRendererInternal(String s)
    {
        if (s == null)
        {
            textRenderer.onCues(Collections.emptyList());
            return;
        } else
        {
            textRenderer.onCues(Collections.singletonList(new Cue(s)));
            return;
        }
    }

    private boolean isSamplePending()
    {
        return sampleHolder.timeUs != -1L;
    }

    private void maybeAppendNewline()
    {
        int i = captionStringBuilder.length();
        if (i > 0 && captionStringBuilder.charAt(i - 1) != '\n')
        {
            captionStringBuilder.append('\n');
        }
    }

    private void maybeParsePendingSample(long l)
    {
        if (sampleHolder.timeUs > 0x4c4b40L + l)
        {
            return;
        }
        ClosedCaptionList closedcaptionlist = eia608Parser.parse(sampleHolder);
        clearPendingSample();
        if (closedcaptionlist != null)
        {
            pendingCaptionLists.add(closedcaptionlist);
        }
    }

    private void seekToInternal()
    {
        inputStreamEnded = false;
        pendingCaptionLists.clear();
        clearPendingSample();
        captionRowCount = 4;
        setCaptionMode(0);
        invokeRenderer(null);
    }

    private void setCaptionMode(int i)
    {
        if (captionMode == i)
        {
            return;
        }
        captionMode = i;
        captionStringBuilder.setLength(0);
        if (i == 1 || i == 0)
        {
            caption = null;
        }
    }

    protected final void doSomeWork(long l, long l1)
    {
        continueBufferingSource(l);
        if (isSamplePending())
        {
            maybeParsePendingSample(l);
        }
        int i;
        if (inputStreamEnded)
        {
            i = -1;
        } else
        {
            i = -3;
        }
        do
        {
            if (isSamplePending() || i != -3)
            {
                break;
            }
            i = readSource(l, formatHolder, sampleHolder, false);
            int j = i;
            if (i == -3)
            {
                maybeParsePendingSample(l);
                i = j;
            } else
            {
                i = j;
                if (j == -1)
                {
                    inputStreamEnded = true;
                    i = j;
                }
            }
        } while (true);
        do
        {
            if (pendingCaptionLists.isEmpty())
            {
                break;
            }
            if (((ClosedCaptionList)pendingCaptionLists.first()).timeUs > l)
            {
                return;
            }
            ClosedCaptionList closedcaptionlist = (ClosedCaptionList)pendingCaptionLists.pollFirst();
            consumeCaptionList(closedcaptionlist);
            if (!closedcaptionlist.decodeOnly)
            {
                invokeRenderer(caption);
            }
        } while (true);
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
            invokeRendererInternal((String)message.obj);
            return true;
        }
        return false;
    }

    protected final boolean handlesTrack(MediaFormat mediaformat)
    {
        return eia608Parser.canParse(mediaformat.mimeType);
    }

    protected final boolean isEnded()
    {
        return inputStreamEnded;
    }

    protected final boolean isReady()
    {
        return true;
    }

    protected final void onEnabled(int i, long l, boolean flag)
    {
        super.onEnabled(i, l, flag);
        seekToInternal();
    }

    protected final void seekTo(long l)
    {
        super.seekTo(l);
        seekToInternal();
    }
}
