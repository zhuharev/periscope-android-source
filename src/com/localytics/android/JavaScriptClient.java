// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;

// Referenced classes of package com.localytics.android:
//            InAppCallable, Localytics

final class JavaScriptClient
{

    private final SparseArray mCallbacks;

    JavaScriptClient(SparseArray sparsearray)
    {
        mCallbacks = sparsearray;
    }

    private Object invoke(int i, Object aobj[])
    {
        Object obj1 = null;
        Object obj = obj1;
        if (mCallbacks != null)
        {
            InAppCallable inappcallable = (InAppCallable)mCallbacks.get(i);
            obj = obj1;
            if (inappcallable != null)
            {
                obj = inappcallable.call(aobj);
            }
        }
        return obj;
    }

    final String getAttributes()
    {
        return (String)invoke(7, null);
    }

    final SparseArray getCallbacks()
    {
        return mCallbacks;
    }

    final String getCustomDimensions()
    {
        return (String)invoke(6, null);
    }

    final String getIdentifiers()
    {
        return (String)invoke(5, null);
    }

    final String getJsGlueCode()
    {
        return String.format("javascript:(function() {  var localyticsScript = document.createElement('script');  localyticsScript.type = 'text/javascript';  localyticsScript.text = '  localytics.identifers = %s;  localytics.customDimensions = %s;  localytics.attributes = %s;  localytics.libraryVersion = \"%s\";  localytics.tagEvent = function(event, attributes, customerValueIncrease) {     localytics.nativeTagEvent(event, JSON.stringify(attributes), JSON.stringify(customerValueIncrease));  };  localytics.setCustomDimension = function(number, value) {     if (number != null && value != null)        localytics.nativeSetCustomDimension(number, value);  };  window.open = function(url) {     if (url != null)        localytics.navigate(url);  };  localytics.close = function() {     localytics.nativeClose();  };';  document.getElementsByTagName('body')[0].appendChild(localyticsScript);})()", new Object[] {
            getIdentifiers(), getCustomDimensions(), getAttributes(), Localytics.getLibraryVersion()
        });
    }

    public final void nativeClose()
    {
        Localytics.Log.w("[JavaScriptClient]: nativeClose is being called");
        (new Handler(Looper.getMainLooper())).post(new _cls1());
    }

    public final void nativeSetCustomDimension(long l, String s)
    {
        Localytics.Log.w("[JavaScriptClient]: nativeSetCustomDimension is being called");
        invoke(8, new Object[] {
            Integer.valueOf((int)l), s
        });
    }

    public final void nativeTagEvent(String s, String s1, String s2)
    {
        Localytics.Log.w("[JavaScriptClient]: nativeTagEvent is being called");
        invoke(3, new Object[] {
            s, s1, s2
        });
    }

    public final void navigate(String s)
    {
        invoke(15, new String[] {
            s
        });
    }


    private class _cls1
        implements Runnable
    {

        final JavaScriptClient this$0;

        public void run()
        {
            invoke(4, null);
        }

        _cls1()
        {
            this$0 = JavaScriptClient.this;
            super();
        }
    }

}
