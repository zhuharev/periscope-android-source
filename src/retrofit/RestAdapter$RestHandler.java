// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;

// Referenced classes of package retrofit:
//            RestAdapter, RetrofitError, RestMethodInfo, Endpoint, 
//            RequestBuilder, RequestInterceptor, Profiler, Utils, 
//            ResponseWrapper, ExceptionCatchingTypedInput, ErrorHandler, Platform, 
//            RxSupport, RequestInterceptorTape, Callback

class methodDetailsCache
    implements InvocationHandler
{

    private final Map methodDetailsCache;
    final RestAdapter this$0;

    private Object invokeRequest(RequestInterceptor requestinterceptor, RestMethodInfo restmethodinfo, Object aobj[])
    {
        String s;
        String s1;
        String s2;
        Object obj1;
        obj1 = null;
        s2 = null;
        s = s2;
        s1 = ((String) (obj1));
        restmethodinfo.init();
        s = s2;
        s1 = ((String) (obj1));
        Object obj2 = server.getUrl();
        s = s2;
        s1 = ((String) (obj1));
        Object obj = new RequestBuilder(((String) (obj2)), restmethodinfo, converter);
        s = s2;
        s1 = ((String) (obj1));
        ((RequestBuilder) (obj)).setArguments(aobj);
        s = s2;
        s1 = ((String) (obj1));
        requestinterceptor.intercept(((stFacade) (obj)));
        s = s2;
        s1 = ((String) (obj1));
        obj = ((RequestBuilder) (obj)).build();
        s = s2;
        s1 = ((String) (obj1));
        s2 = ((Request) (obj)).getUrl();
        s = s2;
        s1 = s2;
        if (restmethodinfo.isSynchronous)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        s = s2;
        s1 = s2;
        int j = s2.indexOf("?", ((String) (obj2)).length());
        int i;
        i = j;
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        s = s2;
        s1 = s2;
        i = s2.length();
        s = s2;
        s1 = s2;
        Thread.currentThread().setName((new StringBuilder("Retrofit-")).append(s2.substring(((String) (obj2)).length(), i)).toString());
        requestinterceptor = ((RequestInterceptor) (obj));
        s = s2;
        s1 = s2;
        if (!logLevel.())
        {
            break MISSING_BLOCK_LABEL_275;
        }
        s = s2;
        s1 = s2;
        requestinterceptor = logAndReplaceRequest("HTTP", ((Request) (obj)), aobj);
        aobj = null;
        s = s2;
        s1 = s2;
        if (RestAdapter.access$200(RestAdapter.this) == null)
        {
            break MISSING_BLOCK_LABEL_316;
        }
        s = s2;
        s1 = s2;
        aobj = ((Object []) (RestAdapter.access$200(RestAdapter.this).beforeCall()));
        s = s2;
        s1 = s2;
        long l = System.nanoTime();
        s = s2;
        s1 = s2;
        obj = RestAdapter.access$300(RestAdapter.this).t().execute(requestinterceptor);
        s = s2;
        s1 = s2;
        l = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
        s = s2;
        s1 = s2;
        i = ((Response) (obj)).getStatus();
        s = s2;
        s1 = s2;
        if (RestAdapter.access$200(RestAdapter.this) == null)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        s = s2;
        s1 = s2;
        requestinterceptor = RestAdapter.access$400(((String) (obj2)), restmethodinfo, requestinterceptor);
        s = s2;
        s1 = s2;
        RestAdapter.access$200(RestAdapter.this).afterCall(requestinterceptor, l, i, ((Object) (aobj)));
        requestinterceptor = ((RequestInterceptor) (obj));
        s = s2;
        s1 = s2;
        if (!logLevel.())
        {
            break MISSING_BLOCK_LABEL_500;
        }
        s = s2;
        s1 = s2;
        requestinterceptor = RestAdapter.access$500(RestAdapter.this, s2, ((Response) (obj)), l);
        s = s2;
        s1 = s2;
        aobj = restmethodinfo.responseObjectType;
        if (i < 200 || i >= 300)
        {
            break MISSING_BLOCK_LABEL_936;
        }
        s = s2;
        s1 = s2;
        if (!((Object) (aobj)).equals(retrofit/client/Response))
        {
            break MISSING_BLOCK_LABEL_647;
        }
        aobj = requestinterceptor;
        s = s2;
        s1 = s2;
        if (restmethodinfo.isStreaming)
        {
            break MISSING_BLOCK_LABEL_576;
        }
        s = s2;
        s1 = s2;
        aobj = Utils.readBodyToBytesIfNecessary(requestinterceptor);
        s = s2;
        s1 = s2;
        boolean flag = restmethodinfo.isSynchronous;
        if (flag)
        {
            if (!restmethodinfo.isSynchronous)
            {
                Thread.currentThread().setName("Retrofit-Idle");
            }
            return ((Object) (aobj));
        }
        s = s2;
        s1 = s2;
        requestinterceptor = new ResponseWrapper(((Response) (aobj)), ((Object) (aobj)));
        if (!restmethodinfo.isSynchronous)
        {
            Thread.currentThread().setName("Retrofit-Idle");
        }
        return requestinterceptor;
        s = s2;
        s1 = s2;
        obj1 = requestinterceptor.getBody();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_737;
        }
        s = s2;
        s1 = s2;
        flag = restmethodinfo.isSynchronous;
        if (flag)
        {
            if (!restmethodinfo.isSynchronous)
            {
                Thread.currentThread().setName("Retrofit-Idle");
            }
            return null;
        }
        s = s2;
        s1 = s2;
        requestinterceptor = new ResponseWrapper(requestinterceptor, null);
        if (!restmethodinfo.isSynchronous)
        {
            Thread.currentThread().setName("Retrofit-Idle");
        }
        return requestinterceptor;
        s = s2;
        s1 = s2;
        obj = new ExceptionCatchingTypedInput(((retrofit.mime.TypedInput) (obj1)));
        s = s2;
        s1 = s2;
        obj2 = converter.fromBody(((retrofit.mime.TypedInput) (obj)), ((java.lang.reflect.Type) (aobj)));
        s = s2;
        s1 = s2;
        RestAdapter.access$600(RestAdapter.this, ((retrofit.mime.TypedInput) (obj1)), obj2);
        s = s2;
        s1 = s2;
        flag = restmethodinfo.isSynchronous;
        if (flag)
        {
            if (!restmethodinfo.isSynchronous)
            {
                Thread.currentThread().setName("Retrofit-Idle");
            }
            return obj2;
        }
        s = s2;
        s1 = s2;
        obj1 = new ResponseWrapper(requestinterceptor, obj2);
        if (!restmethodinfo.isSynchronous)
        {
            Thread.currentThread().setName("Retrofit-Idle");
        }
        return obj1;
        ConversionException conversionexception;
        conversionexception;
        s = s2;
        s1 = s2;
        if (!((ExceptionCatchingTypedInput) (obj)).threwException())
        {
            break MISSING_BLOCK_LABEL_907;
        }
        s = s2;
        s1 = s2;
        throw ((ExceptionCatchingTypedInput) (obj)).getThrownException();
        s = s2;
        s1 = s2;
        throw RetrofitError.conversionError(s2, Utils.replaceResponseBody(requestinterceptor, null), converter, ((java.lang.reflect.Type) (aobj)), conversionexception);
        s = s2;
        s1 = s2;
        throw RetrofitError.httpError(s2, Utils.readBodyToBytesIfNecessary(requestinterceptor), converter, ((java.lang.reflect.Type) (aobj)));
        requestinterceptor;
        throw requestinterceptor;
        requestinterceptor;
        if (logLevel.())
        {
            logException(requestinterceptor, s);
        }
        throw RetrofitError.networkError(s, requestinterceptor);
        requestinterceptor;
        if (logLevel.())
        {
            logException(requestinterceptor, s1);
        }
        throw RetrofitError.unexpectedError(s1, requestinterceptor);
        requestinterceptor;
        if (!restmethodinfo.isSynchronous)
        {
            Thread.currentThread().setName("Retrofit-Idle");
        }
        throw requestinterceptor;
    }

    public Object invoke(final Object methodInfo, Method method, final Object args[])
    {
        if (method.getDeclaringClass() == java/lang/Object)
        {
            return method.invoke(this, args);
        }
        methodInfo = RestAdapter.getMethodInfo(methodDetailsCache, method);
        if (((RestMethodInfo) (methodInfo)).isSynchronous)
        {
            try
            {
                methodInfo = invokeRequest(requestInterceptor, ((RestMethodInfo) (methodInfo)), args);
            }
            // Misplaced declaration of an exception variable
            catch (final Object methodInfo)
            {
                method = errorHandler.handleError(((RetrofitError) (methodInfo)));
                if (method == null)
                {
                    throw new IllegalStateException("Error handler returned null for wrapped exception.", ((Throwable) (methodInfo)));
                } else
                {
                    throw method;
                }
            }
            return methodInfo;
        }
        if (httpExecutor == null || callbackExecutor == null)
        {
            throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
        }
        if (((RestMethodInfo) (methodInfo)).isObservable)
        {
            if (RestAdapter.access$000(RestAdapter.this) == null)
            {
                if (Platform.HAS_RX_JAVA)
                {
                    RestAdapter.access$002(RestAdapter.this, new RxSupport(httpExecutor, errorHandler, requestInterceptor));
                } else
                {
                    throw new IllegalStateException("Observable method found but no RxJava on classpath.");
                }
            }
            class _cls1
                implements RxSupport.Invoker
            {

                final RestAdapter.RestHandler this$1;
                final Object val$args[];
                final RestMethodInfo val$methodInfo;

                public ResponseWrapper invoke(RequestInterceptor requestinterceptor)
                {
                    return (ResponseWrapper)invokeRequest(requestinterceptor, methodInfo, args);
                }

            _cls1()
            {
                this$1 = RestAdapter.RestHandler.this;
                methodInfo = restmethodinfo;
                args = aobj;
                super();
            }
            }

            return RestAdapter.access$000(RestAdapter.this).createRequestObservable(new _cls1());
        } else
        {
            method = new RequestInterceptorTape();
            requestInterceptor.intercept(method);
            final Callback final_callback = (Callback)args[args.length - 1];
            class _cls2 extends CallbackRunnable
            {

                final RestAdapter.RestHandler this$1;
                final Object val$args[];
                final RequestInterceptorTape val$interceptorTape;
                final RestMethodInfo val$methodInfo;

                public ResponseWrapper obtainResponse()
                {
                    return (ResponseWrapper)invokeRequest(interceptorTape, methodInfo, args);
                }

            _cls2(RequestInterceptorTape requestinterceptortape, RestMethodInfo restmethodinfo, Object aobj[])
            {
                this$1 = RestAdapter.RestHandler.this;
                interceptorTape = requestinterceptortape;
                methodInfo = restmethodinfo;
                args = aobj;
                super(final_callback, final_executor, final_errorhandler);
            }
            }

            httpExecutor.execute(new _cls2(method, ((RestMethodInfo) (methodInfo)), args));
            return null;
        }
    }


    ption(Map map)
    {
        this$0 = RestAdapter.this;
        super();
        methodDetailsCache = map;
    }
}
