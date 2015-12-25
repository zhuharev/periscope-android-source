// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.os.SystemClock;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.upstream.Loader;
import com.google.android.exoplayer.upstream.UriDataSource;
import com.google.android.exoplayer.upstream.UriLoadable;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            UtcTimingElement

public final class UtcTimingElementResolver
    implements com.google.android.exoplayer.upstream.Loader.Callback
{
    static class Iso8601Parser
        implements com.google.android.exoplayer.upstream.UriLoadable.Parser
    {

        public Long parse(String s, InputStream inputstream)
        {
            s = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
            long l;
            try
            {
                inputstream = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                inputstream.setTimeZone(TimeZone.getTimeZone("UTC"));
                l = inputstream.parse(s).getTime();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new ParserException(s);
            }
            return Long.valueOf(l);
        }

        public volatile Object parse(String s, InputStream inputstream)
        {
            return parse(s, inputstream);
        }

        private Iso8601Parser()
        {
        }

    }

    public static interface UtcTimingCallback
    {

        public abstract void onTimestampError(UtcTimingElement utctimingelement, IOException ioexception);

        public abstract void onTimestampResolved(UtcTimingElement utctimingelement, long l);
    }

    static class XsDateTimeParser
        implements com.google.android.exoplayer.upstream.UriLoadable.Parser
    {

        public Long parse(String s, InputStream inputstream)
        {
            s = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
            long l;
            try
            {
                l = Util.parseXsDateTime(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new ParserException(s);
            }
            return Long.valueOf(l);
        }

        public volatile Object parse(String s, InputStream inputstream)
        {
            return parse(s, inputstream);
        }

        private XsDateTimeParser()
        {
        }

    }


    private final UtcTimingCallback callback;
    private UriLoadable singleUseLoadable;
    private Loader singleUseLoader;
    private final UtcTimingElement timingElement;
    private final long timingElementElapsedRealtime;
    private final UriDataSource uriDataSource;

    private UtcTimingElementResolver(UriDataSource uridatasource, UtcTimingElement utctimingelement, long l, UtcTimingCallback utctimingcallback)
    {
        uriDataSource = uridatasource;
        timingElement = (UtcTimingElement)Assertions.checkNotNull(utctimingelement);
        timingElementElapsedRealtime = l;
        callback = (UtcTimingCallback)Assertions.checkNotNull(utctimingcallback);
    }

    private void releaseLoader()
    {
        singleUseLoader.release();
    }

    private void resolve()
    {
        String s = timingElement.schemeIdUri;
        if (Util.areEqual(s, "urn:mpeg:dash:utc:direct:2012"))
        {
            resolveDirect();
            return;
        }
        if (Util.areEqual(s, "urn:mpeg:dash:utc:http-iso:2014"))
        {
            resolveHttp(new Iso8601Parser());
            return;
        }
        if (Util.areEqual(s, "urn:mpeg:dash:utc:http-xsdate:2012") || Util.areEqual(s, "urn:mpeg:dash:utc:http-xsdate:2014"))
        {
            resolveHttp(new XsDateTimeParser());
            return;
        } else
        {
            callback.onTimestampError(timingElement, new IOException("Unsupported utc timing scheme"));
            return;
        }
    }

    private void resolveDirect()
    {
        try
        {
            long l = Util.parseXsDateTime(timingElement.value);
            long l1 = timingElementElapsedRealtime;
            callback.onTimestampResolved(timingElement, l - l1);
            return;
        }
        catch (ParseException parseexception)
        {
            callback.onTimestampError(timingElement, new ParserException(parseexception));
        }
    }

    private void resolveHttp(com.google.android.exoplayer.upstream.UriLoadable.Parser parser)
    {
        singleUseLoader = new Loader("utctiming");
        singleUseLoadable = new UriLoadable(timingElement.value, uriDataSource, parser);
        singleUseLoader.startLoading(singleUseLoadable, this);
    }

    public static void resolveTimingElement(UriDataSource uridatasource, UtcTimingElement utctimingelement, long l, UtcTimingCallback utctimingcallback)
    {
        (new UtcTimingElementResolver(uridatasource, utctimingelement, l, utctimingcallback)).resolve();
    }

    public final void onLoadCanceled(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        onLoadError(loadable, new IOException("Load cancelled", new CancellationException()));
    }

    public final void onLoadCompleted(com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        releaseLoader();
        long l = ((Long)singleUseLoadable.getResult()).longValue();
        long l1 = SystemClock.elapsedRealtime();
        callback.onTimestampResolved(timingElement, l - l1);
    }

    public final void onLoadError(com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        releaseLoader();
        callback.onTimestampError(timingElement, ioexception);
    }
}
