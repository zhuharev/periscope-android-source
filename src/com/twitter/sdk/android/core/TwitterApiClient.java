// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.models.SafeListAdapter;
import com.twitter.sdk.android.core.models.SafeMapAdapter;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.core.services.CollectionService;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.core.services.ListService;
import com.twitter.sdk.android.core.services.MediaService;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.core.services.StatusesService;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLSocketFactory;
import o.im;
import o.ra;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;
import retrofit.converter.GsonConverter;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterCore, AuthenticatedClient, Session, TwitterAuthConfig

public class TwitterApiClient
{

    private static final String UPLOAD_ENDPOINT = "https://upload.twitter.com";
    final RestAdapter apiAdapter;
    final ConcurrentHashMap services;
    final RestAdapter uploadAdapter;

    public TwitterApiClient(Session session)
    {
        this(TwitterCore.getInstance().getAuthConfig(), session, new TwitterApi(), TwitterCore.getInstance().getSSLSocketFactory(), ((ExecutorService) (TwitterCore.getInstance().getFabric().QF)));
    }

    TwitterApiClient(TwitterAuthConfig twitterauthconfig, Session session, TwitterApi twitterapi, SSLSocketFactory sslsocketfactory, ExecutorService executorservice)
    {
        if (session == null)
        {
            throw new IllegalArgumentException("Session must not be null.");
        } else
        {
            services = new ConcurrentHashMap();
            Object obj = new im();
            Object obj1 = new SafeListAdapter();
            ((im) (obj)).Gv.add(obj1);
            obj1 = new SafeMapAdapter();
            ((im) (obj)).Gv.add(obj1);
            obj = ((im) (obj))._mth0490();
            apiAdapter = (new retrofit.RestAdapter.Builder()).setClient(new AuthenticatedClient(twitterauthconfig, session, sslsocketfactory)).setEndpoint(twitterapi.getBaseHostUrl()).setConverter(new GsonConverter(((o.ig) (obj)))).setExecutors(executorservice, new MainThreadExecutor()).build();
            uploadAdapter = (new retrofit.RestAdapter.Builder()).setClient(new AuthenticatedClient(twitterauthconfig, session, sslsocketfactory)).setEndpoint("https://upload.twitter.com").setConverter(new GsonConverter(((o.ig) (obj)))).setExecutors(executorservice, new MainThreadExecutor()).build();
            return;
        }
    }

    public AccountService getAccountService()
    {
        return (AccountService)getService(com/twitter/sdk/android/core/services/AccountService);
    }

    Object getAdapterService(RestAdapter restadapter, Class class1)
    {
        if (!services.contains(class1))
        {
            services.putIfAbsent(class1, restadapter.create(class1));
        }
        return services.get(class1);
    }

    public CollectionService getCollectionService()
    {
        return (CollectionService)getService(com/twitter/sdk/android/core/services/CollectionService);
    }

    public FavoriteService getFavoriteService()
    {
        return (FavoriteService)getService(com/twitter/sdk/android/core/services/FavoriteService);
    }

    public ListService getListService()
    {
        return (ListService)getService(com/twitter/sdk/android/core/services/ListService);
    }

    public MediaService getMediaService()
    {
        return (MediaService)getAdapterService(uploadAdapter, com/twitter/sdk/android/core/services/MediaService);
    }

    public SearchService getSearchService()
    {
        return (SearchService)getService(com/twitter/sdk/android/core/services/SearchService);
    }

    public Object getService(Class class1)
    {
        return getAdapterService(apiAdapter, class1);
    }

    public StatusesService getStatusesService()
    {
        return (StatusesService)getService(com/twitter/sdk/android/core/services/StatusesService);
    }
}
