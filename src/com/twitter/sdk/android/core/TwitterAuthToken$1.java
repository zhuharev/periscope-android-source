// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import android.os.Parcel;

// Referenced classes of package com.twitter.sdk.android.core:
//            TwitterAuthToken

final class 
    implements android.os.witterAuthToken._cls1
{

    public final TwitterAuthToken createFromParcel(Parcel parcel)
    {
        return new TwitterAuthToken(parcel, null);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final TwitterAuthToken[] newArray(int i)
    {
        return new TwitterAuthToken[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
