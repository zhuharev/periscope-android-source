// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;

// Referenced classes of package com.twitter.sdk.android.core.internal.oauth:
//            OAuthResponse

final class A
    implements android.os.or
{

    public final OAuthResponse createFromParcel(Parcel parcel)
    {
        return new OAuthResponse(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final OAuthResponse[] newArray(int i)
    {
        return new OAuthResponse[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    A()
    {
    }
}
