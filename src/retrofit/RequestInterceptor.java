// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package retrofit;


public interface RequestInterceptor
{
    public static interface RequestFacade
    {

        public abstract void addEncodedPathParam(String s, String s1);

        public abstract void addEncodedQueryParam(String s, String s1);

        public abstract void addHeader(String s, String s1);

        public abstract void addPathParam(String s, String s1);

        public abstract void addQueryParam(String s, String s1);
    }


    public static final RequestInterceptor NONE = new _cls1();

    public abstract void intercept(RequestFacade requestfacade);


    private class _cls1
        implements RequestInterceptor
    {

        public final void intercept(RequestFacade requestfacade)
        {
        }

        _cls1()
        {
        }
    }

}
