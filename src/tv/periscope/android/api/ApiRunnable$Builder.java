// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;

import android.os.Bundle;
import o.ql;
import tv.periscope.android.signer.SignerService;

// Referenced classes of package tv.periscope.android.api:
//            ApiRunnable, PsRequest, ApiService

public static class mBackoffInterval
{

    private int mActionCode;
    private long mBackoffInterval;
    private Bundle mBundle;
    private ql mEventBus;
    private int mNumRetries;
    private PsRequest mRequest;
    private ApiService mService;
    private SignerService mSigner;

    public ApiRunnable build()
    {
        return new ApiRunnable(mEventBus, mService, mSigner, mActionCode, mRequest, mBundle, mNumRetries, mBackoffInterval);
    }

    public mBackoffInterval setActionCode(int i)
    {
        mActionCode = i;
        return this;
    }

    public mActionCode setBackoffInterval(long l)
    {
        mBackoffInterval = l;
        return this;
    }

    public mBackoffInterval setBundle(Bundle bundle)
    {
        mBundle = bundle;
        return this;
    }

    public mBundle setEventBus(ql ql)
    {
        mEventBus = ql;
        return this;
    }

    public mEventBus setNumRetries(int i)
    {
        mNumRetries = i;
        return this;
    }

    public mNumRetries setRequest(PsRequest psrequest)
    {
        mRequest = psrequest;
        return this;
    }

    public mRequest setService(ApiService apiservice)
    {
        mService = apiservice;
        return this;
    }

    public mService setSigner(SignerService signerservice)
    {
        mSigner = signerservice;
        return this;
    }

    public ()
    {
        mActionCode = -1;
        mNumRetries = 5;
        mBackoffInterval = 2000L;
    }
}
