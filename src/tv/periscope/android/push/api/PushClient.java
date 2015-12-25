// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.push.api;

import o.aos;
import retrofit.RestAdapter;

public class PushClient
{
    static interface PushService
    {

        public abstract UnregisterTokenResponse logout(UnregisterTokenRequest unregistertokenrequest);

        public abstract RegisterTokenResponse registerToken(RegisterTokenRequest registertokenrequest);
    }

    public class RegisterTokenRequest
    {

        public String build;
        public String bundleId;
        public String cookie;
        public String deviceType;
        public String installId;
        public String model;
        public String os;
        final PushClient this$0;
        public String token;
        public String vendorId;

        public RegisterTokenRequest()
        {
            this$0 = PushClient.this;
            super();
        }
    }

    public class RegisterTokenResponse
    {

        final PushClient this$0;

        public RegisterTokenResponse()
        {
            this$0 = PushClient.this;
            super();
        }
    }

    public class UnregisterTokenRequest
    {

        public String cookie;
        public String installId;
        final PushClient this$0;

        public UnregisterTokenRequest()
        {
            this$0 = PushClient.this;
            super();
        }
    }

    public class UnregisterTokenResponse
    {

        final PushClient this$0;

        public UnregisterTokenResponse()
        {
            this$0 = PushClient.this;
            super();
        }
    }


    private PushService mPushService;
    private final RestAdapter mRestAdapter;

    public PushClient(RestAdapter restadapter)
    {
        mRestAdapter = restadapter;
    }

    private PushService getService()
    {
        if (mPushService == null)
        {
            mPushService = (PushService)mRestAdapter.create(tv/periscope/android/push/api/PushClient$PushService);
        }
        return mPushService;
    }

    public RegisterTokenResponse registerToken(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        RegisterTokenRequest registertokenrequest = new RegisterTokenRequest();
        registertokenrequest.cookie = s;
        registertokenrequest.bundleId = s1;
        registertokenrequest.vendorId = s2;
        registertokenrequest.token = s3;
        registertokenrequest.os = aos.dF();
        registertokenrequest.installId = s4;
        registertokenrequest.build = s5;
        registertokenrequest.deviceType = s6;
        registertokenrequest.model = s7;
        return getService().registerToken(registertokenrequest);
    }

    public UnregisterTokenResponse unregisterToken(String s, String s1)
    {
        UnregisterTokenRequest unregistertokenrequest = new UnregisterTokenRequest();
        unregistertokenrequest.cookie = s;
        unregistertokenrequest.installId = s1;
        return getService().logout(unregistertokenrequest);
    }
}
