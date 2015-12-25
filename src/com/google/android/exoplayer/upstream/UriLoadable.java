// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import android.net.Uri;
import java.io.InputStream;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            DataSpec, DataSourceInputStream, UriDataSource

public final class UriLoadable
    implements Loader.Loadable
{
    public static interface Parser
    {

        public abstract Object parse(String s, InputStream inputstream);
    }


    private final DataSpec dataSpec;
    private volatile boolean isCanceled;
    private final Parser parser;
    private volatile Object result;
    private final UriDataSource uriDataSource;

    public UriLoadable(String s, UriDataSource uridatasource, Parser parser1)
    {
        uriDataSource = uridatasource;
        parser = parser1;
        dataSpec = new DataSpec(Uri.parse(s), 1);
    }

    public final void cancelLoad()
    {
        isCanceled = true;
    }

    public final Object getResult()
    {
        return result;
    }

    public final boolean isLoadCanceled()
    {
        return isCanceled;
    }

    public final void load()
    {
        DataSourceInputStream datasourceinputstream = new DataSourceInputStream(uriDataSource, dataSpec);
        datasourceinputstream.open();
        result = parser.parse(uriDataSource.getUri(), datasourceinputstream);
        datasourceinputstream.close();
        return;
        Exception exception;
        exception;
        datasourceinputstream.close();
        throw exception;
    }
}
