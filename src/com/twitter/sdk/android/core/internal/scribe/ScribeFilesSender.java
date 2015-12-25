// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import android.text.TextUtils;
import com.twitter.sdk.android.core.AuthenticatedClient;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import o.rz;
import o.si;
import o.sl;
import o.ub;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.MainThreadExecutor;
import retrofit.client.Response;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeConfig

class ScribeFilesSender
    implements ub
{
    static class ConfigRequestInterceptor
        implements RequestInterceptor
    {

        private static final String CLIENT_UUID_HEADER = "X-Client-UUID";
        private static final String POLLING_HEADER = "X-Twitter-Polling";
        private static final String POLLING_HEADER_VALUE = "true";
        private static final String USER_AGENT_HEADER = "User-Agent";
        private final si idManager;
        private final ScribeConfig scribeConfig;

        public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
        {
            if (!TextUtils.isEmpty(scribeConfig.userAgent))
            {
                requestfacade.addHeader("User-Agent", scribeConfig.userAgent);
            }
            if (!TextUtils.isEmpty(idManager._mth0E30()))
            {
                requestfacade.addHeader("X-Client-UUID", idManager._mth0E30());
            }
            requestfacade.addHeader("X-Twitter-Polling", "true");
        }

        ConfigRequestInterceptor(ScribeConfig scribeconfig, si si1)
        {
            scribeConfig = scribeconfig;
            idManager = si1;
        }
    }

    static interface ScribeService
    {

        public abstract Response upload(String s, String s1, String s2);

        public abstract Response uploadSequence(String s, String s1);
    }


    private static final byte COMMA[] = {
        44
    };
    private static final byte END_JSON_ARRAY[] = {
        93
    };
    private static final String SEND_FILE_FAILURE_ERROR = "Failed sending files";
    private static final byte START_JSON_ARRAY[] = {
        91
    };
    private final AtomicReference apiAdapter = new AtomicReference();
    private final TwitterAuthConfig authConfig;
    private final Context context;
    private final ExecutorService executorService;
    private final si idManager;
    private final long ownerId;
    private final ScribeConfig scribeConfig;
    private final List sessionManagers;
    private final SSLSocketFactory sslSocketFactory;

    public ScribeFilesSender(Context context1, ScribeConfig scribeconfig, long l, TwitterAuthConfig twitterauthconfig, List list, SSLSocketFactory sslsocketfactory, 
            ExecutorService executorservice, si si)
    {
        context = context1;
        scribeConfig = scribeconfig;
        ownerId = l;
        authConfig = twitterauthconfig;
        sessionManagers = list;
        sslSocketFactory = sslsocketfactory;
        executorService = executorservice;
        idManager = si;
    }

    private Session getSession(long l)
    {
        Session session = null;
        Iterator iterator = sessionManagers.iterator();
        Session session1;
        do
        {
            session1 = session;
            if (!iterator.hasNext())
            {
                break;
            }
            session = ((SessionManager)iterator.next()).getSession(l);
            session1 = session;
        } while (session == null);
        return session1;
    }

    private boolean hasApiAdapter()
    {
        return getApiAdapter() != null;
    }

    private boolean isValidSession(Session session)
    {
        return session != null && session.getAuthToken() != null;
    }

    RestAdapter getApiAdapter()
    {
        this;
        JVM INSTR monitorenter ;
        if (apiAdapter.get() != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        Session session = getSession(ownerId);
        ConfigRequestInterceptor configrequestinterceptor = new ConfigRequestInterceptor(scribeConfig, idManager);
        if (isValidSession(session))
        {
            apiAdapter.compareAndSet(null, (new retrofit.RestAdapter.Builder()).setEndpoint(scribeConfig.baseUrl).setExecutors(executorService, new MainThreadExecutor()).setRequestInterceptor(configrequestinterceptor).setClient(new AuthenticatedClient(authConfig, session, sslSocketFactory)).build());
            break MISSING_BLOCK_LABEL_123;
        }
        rz._mth02BD(context, "No valid session at this time");
        RestAdapter restadapter = (RestAdapter)apiAdapter.get();
        this;
        JVM INSTR monitorexit ;
        return restadapter;
        Exception exception;
        exception;
        throw exception;
    }

    String getScribeEventsAsJsonArrayString(List list)
    {
        final ByteArrayOutputStream out;
        final boolean appendComma[];
        Iterator iterator;
        out = new ByteArrayOutputStream(1024);
        appendComma = new boolean[1];
        out.write(START_JSON_ARRAY);
        iterator = list.iterator();
_L2:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (File)iterator.next();
        list = null;
        sl sl1 = new sl(((File) (obj)));
        obj = sl1;
        list = ((List) (obj));
        sl1._mth02CA(new _cls1());
        rz.closeQuietly(((java.io.Closeable) (obj)));
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        rz.closeQuietly(list);
        throw exception;
_L1:
        out.write(END_JSON_ARRAY);
        return out.toString("UTF-8");
    }

    public boolean send(List list)
    {
        if (!hasApiAdapter())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        int i;
        list = getScribeEventsAsJsonArrayString(list);
        rz._mth02BD(context, list);
        i = upload(list).getStatus();
        if (i == 200)
        {
            return true;
        }
        try
        {
            rz._mth037A(context, "Failed sending files");
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            rz._mth037A(context, "Failed sending files");
            if (list.getResponse() != null && (list.getResponse().getStatus() == 500 || list.getResponse().getStatus() == 400))
            {
                return true;
            }
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            rz._mth037A(context, "Failed sending files");
        }
        break MISSING_BLOCK_LABEL_120;
        rz._mth02BD(context, "Cannot attempt upload at this time");
        return false;
    }

    void setApiAdapter(RestAdapter restadapter)
    {
        apiAdapter.set(restadapter);
    }

    Response upload(String s)
    {
        ScribeService scribeservice = (ScribeService)((RestAdapter)apiAdapter.get()).create(com/twitter/sdk/android/core/internal/scribe/ScribeFilesSender$ScribeService);
        if (!TextUtils.isEmpty(scribeConfig.sequence))
        {
            return scribeservice.uploadSequence(scribeConfig.sequence, s);
        } else
        {
            return scribeservice.upload(scribeConfig.pathVersion, scribeConfig.pathType, s);
        }
    }



    private class _cls1
        implements o.sl._cls02CB
    {

        final ScribeFilesSender this$0;
        final boolean val$appendComma[];
        final ByteArrayOutputStream val$out;

        public void read(InputStream inputstream, int i)
        {
            byte abyte0[] = new byte[i];
            inputstream.read(abyte0);
            if (appendComma[0])
            {
                out.write(ScribeFilesSender.COMMA);
            } else
            {
                appendComma[0] = true;
            }
            out.write(abyte0);
        }

        _cls1()
        {
            this$0 = ScribeFilesSender.this;
            appendComma = aflag;
            out = bytearrayoutputstream;
            super();
        }
    }

}
