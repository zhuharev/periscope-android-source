// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp3;

import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.extractor.Extractor;
import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.extractor.ExtractorOutput;
import com.google.android.exoplayer.extractor.PositionHolder;
import com.google.android.exoplayer.extractor.SeekMap;
import com.google.android.exoplayer.extractor.TrackOutput;
import com.google.android.exoplayer.util.MpegAudioHeader;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.EOFException;

// Referenced classes of package com.google.android.exoplayer.extractor.mp3:
//            BufferingInput, XingSeeker, VbriSeeker, ConstantBitrateSeeker

public final class Mp3Extractor
    implements Extractor
{
    static interface Seeker
        extends SeekMap
    {

        public abstract long getDurationUs();

        public abstract long getTimeUs(long l);
    }


    private static final int HEADER_MASK = 0xfffe0c00;
    private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int INFO_HEADER = Util.getIntegerCodeForString("Info");
    private static final int MAX_SNIFF_BYTES = 4096;
    private static final int MAX_SYNC_BYTES = 0x20000;
    private static final int VBRI_HEADER = Util.getIntegerCodeForString("VBRI");
    private static final int XING_HEADER = Util.getIntegerCodeForString("Xing");
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final long forcedFirstSampleTimestampUs;
    private final BufferingInput inputBuffer;
    private int sampleBytesRemaining;
    private int samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    public Mp3Extractor()
    {
        this(-1L);
    }

    public Mp3Extractor(long l)
    {
        forcedFirstSampleTimestampUs = l;
        inputBuffer = new BufferingInput(12288);
        scratch = new ParsableByteArray(4);
        synchronizedHeader = new MpegAudioHeader();
        basisTimeUs = -1L;
    }

    private static long getPosition(ExtractorInput extractorinput, BufferingInput bufferinginput)
    {
        return extractorinput.getPosition() - (long)bufferinginput.getAvailableByteCount();
    }

    private long maybeResynchronize(ExtractorInput extractorinput)
    {
        inputBuffer.mark();
        if (!inputBuffer.readAllowingEndOfInput(extractorinput, scratch.data, 0, 4))
        {
            return -1L;
        }
        inputBuffer.returnToMark();
        scratch.setPosition(0);
        int i = scratch.readInt();
        if ((i & 0xfffe0c00) == (synchronizedHeaderData & 0xfffe0c00) && MpegAudioHeader.getFrameSize(i) != -1)
        {
            MpegAudioHeader.populateHeader(i, synchronizedHeader);
            return 0L;
        } else
        {
            synchronizedHeaderData = 0;
            inputBuffer.skip(extractorinput, 1);
            return synchronizeCatchingEndOfInput(extractorinput);
        }
    }

    private boolean parseSeekerFrame(ExtractorInput extractorinput, long l, long l1)
    {
        inputBuffer.mark();
        seeker = null;
        extractorinput = inputBuffer.getParsableByteArray(extractorinput, synchronizedHeader.frameSize);
        int i;
        if ((synchronizedHeader.version & 1) == 1)
        {
            if (synchronizedHeader.channels != 1)
            {
                i = 32;
            } else
            {
                i = 17;
            }
        } else
        if (synchronizedHeader.channels != 1)
        {
            i = 17;
        } else
        {
            i = 9;
        }
        extractorinput.setPosition(i + 4);
        i = extractorinput.readInt();
        if (i == XING_HEADER || i == INFO_HEADER)
        {
            seeker = XingSeeker.create(synchronizedHeader, extractorinput, l, l1);
            return true;
        }
        extractorinput.setPosition(36);
        if (extractorinput.readInt() == VBRI_HEADER)
        {
            seeker = VbriSeeker.create(synchronizedHeader, extractorinput, l);
            return true;
        } else
        {
            return false;
        }
    }

    private int readSample(ExtractorInput extractorinput)
    {
        if (sampleBytesRemaining == 0)
        {
            if (maybeResynchronize(extractorinput) == -1L)
            {
                return -1;
            }
            if (basisTimeUs == -1L)
            {
                basisTimeUs = seeker.getTimeUs(getPosition(extractorinput, inputBuffer));
                if (forcedFirstSampleTimestampUs != -1L)
                {
                    long l = seeker.getTimeUs(0L);
                    basisTimeUs = basisTimeUs + (forcedFirstSampleTimestampUs - l);
                }
            }
            sampleBytesRemaining = synchronizedHeader.frameSize;
        }
        long l1 = basisTimeUs;
        long l2 = ((long)samplesRead * 0xf4240L) / (long)synchronizedHeader.sampleRate;
        sampleBytesRemaining = sampleBytesRemaining - inputBuffer.drainToOutput(trackOutput, sampleBytesRemaining);
        if (sampleBytesRemaining > 0)
        {
            inputBuffer.mark();
            int i = trackOutput.sampleData(extractorinput, sampleBytesRemaining, true);
            if (i == -1)
            {
                return -1;
            }
            sampleBytesRemaining = sampleBytesRemaining - i;
            if (sampleBytesRemaining > 0)
            {
                return 0;
            }
        }
        trackOutput.sampleMetadata(l1 + l2, 1, synchronizedHeader.frameSize, 0, null);
        samplesRead = samplesRead + synchronizedHeader.samplesPerFrame;
        sampleBytesRemaining = 0;
        return 0;
    }

    private void setupSeeker(ExtractorInput extractorinput, long l)
    {
        long l1 = l;
        if (parseSeekerFrame(extractorinput, l, extractorinput.getLength()))
        {
            inputBuffer.mark();
            if (seeker != null)
            {
                return;
            }
            inputBuffer.read(extractorinput, scratch.data, 0, 4);
            scratch.setPosition(0);
            l1 = l + (long)synchronizedHeader.frameSize;
            MpegAudioHeader.populateHeader(scratch.readInt(), synchronizedHeader);
        }
        inputBuffer.returnToMark();
        seeker = new ConstantBitrateSeeker(l1, synchronizedHeader.bitrate * 1000, extractorinput.getLength());
    }

    private long synchronize(ExtractorInput extractorinput)
    {
        if (extractorinput.getPosition() == 0L)
        {
            inputBuffer.reset();
        } else
        {
            inputBuffer.returnToMark();
        }
        long l3 = getPosition(extractorinput, inputBuffer);
        long l2 = l3;
        long l1 = l2;
        if (l3 == 0L)
        {
            l1 = l2;
            do
            {
                inputBuffer.read(extractorinput, scratch.data, 0, 3);
                scratch.setPosition(0);
                if (scratch.readUnsignedInt24() != ID3_TAG)
                {
                    break;
                }
                extractorinput.skipFully(3);
                extractorinput.readFully(scratch.data, 0, 4);
                extractorinput.skipFully((scratch.data[0] & 0x7f) << 21 | (scratch.data[1] & 0x7f) << 14 | (scratch.data[2] & 0x7f) << 7 | scratch.data[3] & 0x7f);
                inputBuffer.reset();
                l1 = getPosition(extractorinput, inputBuffer);
            } while (true);
            inputBuffer.returnToMark();
        }
        inputBuffer.mark();
        l2 = l1;
        int i = 0;
        int j = 0;
        do
        {
            int k;
            int l;
label0:
            {
                if (l2 - l1 >= 0x20000L)
                {
                    throw new ParserException("Searched too many bytes while resynchronizing.");
                }
                if (!inputBuffer.readAllowingEndOfInput(extractorinput, scratch.data, 0, 4))
                {
                    return -1L;
                }
                scratch.setPosition(0);
                k = scratch.readInt();
                if (j == 0 || (0xfffe0c00 & k) == (0xfffe0c00 & j))
                {
                    l = MpegAudioHeader.getFrameSize(k);
                    if (l != -1)
                    {
                        break label0;
                    }
                }
                i = 0;
                j = 0;
                inputBuffer.returnToMark();
                inputBuffer.skip(extractorinput, 1);
                inputBuffer.mark();
                l2++;
                continue;
            }
            if (i == 0)
            {
                MpegAudioHeader.populateHeader(k, synchronizedHeader);
                j = k;
            }
            i++;
            if (i == 4)
            {
                break;
            }
            inputBuffer.skip(extractorinput, l - 4);
        } while (true);
        inputBuffer.returnToMark();
        synchronizedHeaderData = j;
        if (seeker == null)
        {
            setupSeeker(extractorinput, l2);
            extractorOutput.seekMap(seeker);
            trackOutput.format(MediaFormat.createAudioFormat(-1, synchronizedHeader.mimeType, -1, 4096, seeker.getDurationUs(), synchronizedHeader.channels, synchronizedHeader.sampleRate, null, null));
        }
        return l2;
    }

    private long synchronizeCatchingEndOfInput(ExtractorInput extractorinput)
    {
        long l;
        try
        {
            l = synchronize(extractorinput);
        }
        // Misplaced declaration of an exception variable
        catch (ExtractorInput extractorinput)
        {
            return -1L;
        }
        return l;
    }

    public final void init(ExtractorOutput extractoroutput)
    {
        extractorOutput = extractoroutput;
        trackOutput = extractoroutput.track(0);
        extractoroutput.endTracks();
    }

    public final int read(ExtractorInput extractorinput, PositionHolder positionholder)
    {
        if (synchronizedHeaderData == 0 && synchronizeCatchingEndOfInput(extractorinput) == -1L)
        {
            return -1;
        } else
        {
            return readSample(extractorinput);
        }
    }

    public final void seek()
    {
        synchronizedHeaderData = 0;
        samplesRead = 0;
        basisTimeUs = -1L;
        sampleBytesRemaining = 0;
        inputBuffer.reset();
    }

    public final boolean sniff(ExtractorInput extractorinput)
    {
        ParsableByteArray parsablebytearray = new ParsableByteArray(4);
        int i = 0;
        do
        {
            extractorinput.peekFully(parsablebytearray.data, 0, 3);
            parsablebytearray.setPosition(0);
            if (parsablebytearray.readUnsignedInt24() != ID3_TAG)
            {
                break;
            }
            extractorinput.advancePeekPosition(3);
            extractorinput.peekFully(parsablebytearray.data, 0, 4);
            int j = (parsablebytearray.data[0] & 0x7f) << 21 | (parsablebytearray.data[1] & 0x7f) << 14 | (parsablebytearray.data[2] & 0x7f) << 7 | parsablebytearray.data[3] & 0x7f;
            extractorinput.advancePeekPosition(j);
            i += j + 10;
        } while (true);
        extractorinput.resetPeekPosition();
        extractorinput.advancePeekPosition(i);
        int i1 = i;
        int k = 0;
        int l = 0;
        do
        {
            int j1;
            int k1;
label0:
            {
                if (i1 - i >= 4096)
                {
                    return false;
                }
                extractorinput.peekFully(parsablebytearray.data, 0, 4);
                parsablebytearray.setPosition(0);
                j1 = parsablebytearray.readInt();
                if (l == 0 || (0xfffe0c00 & j1) == (0xfffe0c00 & l))
                {
                    k1 = MpegAudioHeader.getFrameSize(j1);
                    if (k1 != -1)
                    {
                        break label0;
                    }
                }
                k = 0;
                l = 0;
                extractorinput.resetPeekPosition();
                i1++;
                extractorinput.advancePeekPosition(i1);
                continue;
            }
            if (k == 0)
            {
                l = j1;
            }
            k++;
            if (k == 4)
            {
                return true;
            }
            extractorinput.advancePeekPosition(k1 - 4);
        } while (true);
    }

}
