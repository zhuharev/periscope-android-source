// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.SystemClock;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.VerboseLogUtil;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

// Referenced classes of package o:
//            FF6A

public final class aaa
    implements aad._cls02CF, aad._cls02CB, aad._cls02CE
{

    private static final NumberFormat aYU;
    public long aYV;
    private long aYW[];

    public aaa()
    {
        aYW = new long[4];
    }

    private void _mth02CA(String s, Exception exception)
    {
        StringBuilder stringbuilder = new StringBuilder("internalError [");
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        FF6A._mth02CA("EventLogger", stringbuilder.append(aYU.format((float)(l - l1) / 1000F)).append(", ").append(s).append("]").toString(), exception);
    }

    public final void M()
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
    }

    public final void onAudioTrackInitializationError(com.google.android.exoplayer.audio.AudioTrack.InitializationException initializationexception)
    {
        _mth02CA("audioTrackInitializationError", initializationexception);
    }

    public final void onAudioTrackWriteError(com.google.android.exoplayer.audio.AudioTrack.WriteException writeexception)
    {
        _mth02CA("audioTrackWriteError", writeexception);
    }

    public final void onAvailableRangeChanged(TimeRange timerange)
    {
        (new StringBuilder("availableRangeChanged ")).append(timerange);
    }

    public final void onBandwidthSample(int i, long l, long l1)
    {
        l = SystemClock.elapsedRealtime();
        l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
        l = i;
        aYU.format((float)l / 1000F);
    }

    public final void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception)
    {
        _mth02CA("cryptoError", cryptoexception);
    }

    public final void onDecoderInitializationError(com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException decoderinitializationexception)
    {
        _mth02CA("decoderInitializationError", decoderinitializationexception);
    }

    public final void onDrmSessionManagerError(Exception exception)
    {
        _mth02CA("drmSessionManagerError", exception);
    }

    public final void onError(Exception exception)
    {
        StringBuilder stringbuilder = new StringBuilder("playerFailed [");
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        FF6A._mth02CA("EventLogger", stringbuilder.append(aYU.format((float)(l - l1) / 1000F)).append("]").toString(), exception);
    }

    public final void onPlayerSeekComplete()
    {
    }

    public final void _mth02CA(int i, int j, float f)
    {
    }

    public final void _mth02CA(int i, int j, long l, long l1)
    {
        aYW[i] = SystemClock.elapsedRealtime();
        if (VerboseLogUtil.isTagEnabled("EventLogger"))
        {
            l = SystemClock.elapsedRealtime();
            l1 = aYV;
            aYU.format((float)(l - l1) / 1000F);
        }
    }

    public final void _mth02CA(Format format, int i)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
    }

    public final void _mth02CA(IOException ioexception)
    {
        _mth02CA("loadError", ((Exception) (ioexception)));
    }

    public final void _mth02CB(Format format, int i)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
    }

    public final void _mth02CB(boolean flag, int i)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
        switch (i)
        {
        default:
            return;

        case 3: // '\003'
            return;

        case 5: // '\005'
            return;

        case 1: // '\001'
            return;

        case 2: // '\002'
            return;

        case 4: // '\004'
            return;
        }
    }

    public final void _mth02CF(Exception exception)
    {
        _mth02CA("rendererInitError", exception);
    }

    public final void _mth1ECA(int i)
    {
        long l = SystemClock.elapsedRealtime();
        long l1 = aYV;
        aYU.format((float)(l - l1) / 1000F);
    }

    public final void _mth1ECB(int i)
    {
        if (VerboseLogUtil.isTagEnabled("EventLogger"))
        {
            SystemClock.elapsedRealtime();
            long l = SystemClock.elapsedRealtime();
            long l1 = aYV;
            aYU.format((float)(l - l1) / 1000F);
        }
    }

    static 
    {
        NumberFormat numberformat = NumberFormat.getInstance(Locale.US);
        aYU = numberformat;
        numberformat.setMinimumFractionDigits(2);
        aYU.setMaximumFractionDigits(2);
    }
}
