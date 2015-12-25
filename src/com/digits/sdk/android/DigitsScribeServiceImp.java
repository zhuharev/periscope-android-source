// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;

// Referenced classes of package com.digits.sdk.android:
//            DigitsScribeService

class DigitsScribeServiceImp
    implements DigitsScribeService
{

    static final String EMPTY_SCRIBE_COMPONENT = "";
    static final String EMPTY_SCRIBE_ELEMENT = "";
    static final String EMPTY_SCRIBE_SECTION = "";
    static final String IMPRESSION_ACTION = "impression";
    static final String SCRIBE_CLIENT = "android";
    static final String SCRIBE_PAGE = "digits";
    private final DefaultScribeClient scribeClient;

    public DigitsScribeServiceImp(DefaultScribeClient defaultscribeclient)
    {
        if (defaultscribeclient == null)
        {
            throw new NullPointerException("scribeClient must not be null");
        } else
        {
            scribeClient = defaultscribeclient;
            return;
        }
    }

    private void scribe(EventNamespace eventnamespace)
    {
        scribeClient.scribeSyndicatedSdkImpressionEvents(new EventNamespace[] {
            eventnamespace
        });
    }

    public void dailyPing()
    {
        scribe((new com.twitter.sdk.android.core.internal.scribe.EventNamespace.Builder()).setClient("android").setPage("digits").setSection("").setComponent("").setElement("").setAction("impression").builder());
    }
}
